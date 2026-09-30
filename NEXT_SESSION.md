# Naruto Shippuden: NeoForge 26.3 port, handoff notes

Read this first in a new session. It covers what the project is, how the code is laid out, how the main systems work, how
to build and test, and how the user likes to work.

## The project

- **What it is:** the Naruto Shippuden Minecraft mod (originally made in MCreator for Forge 1.16.5), ported to **NeoForge 26.3**
  (26.3.0.26-beta, Java 25). Most jutsu, the economy, the dojutsu and the clans have since been rebuilt by hand.
- **Checkout:** `~/Desktop/Minecraft Mods/Naruto-Shippuden`, branch `claude/clever-tesla-qme96b`.
- **Remotes:** `origin` = FishyHard/Naruto-Shippuden, `copy` = FishyHard/Naruto_Shippuden_Claude. Push every commit to both.
  **Don't open PRs.**
- **Mod jar:** `neoforge/build/libs/naruto_shippuden-3.0.0.jar`. The user installs it themselves (macOS, Prism Launcher),
  plays, and sends screenshots with feedback. Send the jar with SendUserFile and give a clear changelog.

## How the user works

- Feedback comes in big batches with screenshots. Do all of it, test what can be tested in the dev client, then
  send **one jar plus a changelog** of what changed. They prefer that to long visual checks in development.
- They want vanilla-looking results: vanilla-style GUIs, text above the hotbar, keys in the Controls menu.
- Follow the Naruto wiki for jutsu (names, what they do). Existing models and textures stay unless they ask for new ones.
- Ranks must **never** be tied to levels.
- The Shinobi Merchant must not sell character weapons (Seven Swordsmen blades, chakra blades), headbands or chakra paper.
- The YouTuber extras (Voltic Mode, Furamingogan, Custom Dojutsu) were removed on request. Don't bring them back.
- Removed clans (keep their logo textures): Izuno, Kurama, Shimura (the Shimura Sharingan stays), Namikaze, Kazekage,
  Hatake, Otsutsuki, Senju, Tenro, Yuki, Hoshigaki, Kaguya.

## Build

```
cd neoforge && JAVA_HOME=~/.jdks/jdk-25.0.4.1+1/Contents/Home ./gradlew build
```

A build takes about 4 minutes. zsh doesn't split unquoted variables into words, so use arrays in shell loops.

## Layout

| Path | What it is |
|---|---|
| `src/` (repo root) | The original 1.16.5 MCreator mod. Only for reference. |
| `neoforge/src/main/java/net/mcreator/narutoshippudenmod/` | The port. Most files were **generated** from 1.16.5 by the porting pipeline; the rest are copies of the overrides. |
| `neoforge/porting/override/…` | **Hand-written Java.** Everything new lives here: the jutsu engine, GUIs and renderers. Each file is copied over its `src` twin. |
| `neoforge/porting/rules.py` | Ordered regex and function **rules** that fix or rewrite the generated code. Every hand fix to a generated file needs a matching rule. |
| `neoforge/porting/res_override/` | Hand-written resources, such as the lang file and trades. `src/main/resources` has the same files, so edit both. |
| `neoforge/porting/*.py` | The rest of the converter (`port.py` and the per-system converters), plus the tools below. |
| `neoforge/run/saves/devtest` | The dev test world. |

### How to change code

1. **Hand-written code:** edit it in `porting/override/…`, then run `rsync -a porting/override/ src/main/java/`.
   Before you rsync, `cmp` each override against its `src` copy: an override was stale once and nearly undid a feature.
   If you edit a `src` copy of an override directly, copy it back into `porting/override`.
2. **Generated code** (procedures, items, entities, renderers): write a **rule** in `porting/rules.py`, then apply it to
   `src`. Use `@func` for body-only rules; `split_header` keeps imports out. The small runner I used is below. It applies
   named rules to every generated file that isn't an override.

```python
import sys, os, glob
sys.path.insert(0, '.')                   # run from neoforge/porting
import rules
fns = [getattr(rules, n) for n in sys.argv[1:]]
over = {os.path.relpath(p, 'override') for p in glob.glob('override/**/*.java', recursive=True)}
for p in glob.glob('../src/main/java/**/*.java', recursive=True):
    rel = os.path.relpath(p, '../src/main/java/')
    if rel in over: continue
    s = t = open(p).read()
    for f in fns:
        head, body = rules.split_header(t); t = head + f(rel, body)
    if t != s: open(p, 'w').write(t)
```

   Useful helpers in `rules.py`:
   - `find_block(text, i)` finds the end of the `{…}` block that starts at `i`. It knows about strings and comments.
   - `remove_class(text, name)`
   - `remove_if_blocks(text, cond_regex)`
3. **Dead code:** `python3 porting/dead_code.py porting/dead_classes.txt` lists member classes nothing live reaches:
   procedures, entities, renderers, projectile items, effects and particles. The `dead_code` rule removes them along
   with their imports and renderer registrations. The list only ever grows.
4. `JutsuTable.java` is now **maintained by hand**, and `jutsu_table.py` is retired. Entries that the new jutsu classes
   register again point at the `NEW_ENGINE` no-op.

## Main systems (all in `porting/override/net/mcreator/narutoshippudenmod/`)

### Jutsu engine (`core/jutsu/`)

- `Jutsus` is the registry of **techniques** and **releases**.
  - A technique is an item with a wheel of jutsu; a release is a scroll where jutsu are bought with JP.
  - `Jutsus.cast` runs on right-click and cancels the item's own `use()`. It checks, in order: learned, requirement,
    stat, chakra, cooldown.
  - Sneaking is switched off during a cast (the old procedures used sneak to cycle jutsu). A technique can take
    sneak + right-click itself through `Technique.onSneak`; Shadow Clone uses it to release its clones.
- `engine/JutsuRank` has ranks E to S. Each rank sets the JP price, the Ninjutsu needed, the chakra cost and the cooldown.
  Cooldowns get shorter at higher shinobi ranks.
- `engine/Techniques` has the building blocks: `shoot`, `burst`, `cone`, `dash`, `strike`, `line`, `puff`, `channel`
  (repeat for N ticks) and `after` (delay).
  - `damage` scales with Ninjutsu: +1% per point, up to 2.5×.
  - `jutsuPower(entity)` feeds the old procedures their power tier (0–9) from Ninjutsu.
- `engine/JutsuProjectile` is the one projectile type for all jutsu. Its `Shape`s are ORB, DRAGON, SHARK,
  RASENSHURIKEN, NEEDLE, NONE, CUBE, SHURIKEN, LION, SHELL, ROD, DAIKOKUTEN, VORTEX and KUNAI. `client/jutsu/JutsuProjectileRenderer`
  draws each shape as glowing models built from cubes, tinted by the `Element`.
- `engine/Displays` makes animated block-display "sculptures", such as tree bind and the ice mirror dome.
- **Jutsu classes**, all registered with `nature(id, title, …, new Def(name, rank, cast[, stat]))`:
  - `NatureJutsu`: the five natures.
  - `KekkeiGenkaiJutsu`: the kekkei genkai.
  - `ClanJutsu`: the clans. Timed transformations use `mode()`; only one mode runs at a time, and it is cleaned up on
    death and logout.
  - `DojutsuJutsu`: Sharingan, Kokugan (ids still say `isshiki_dojutsu`), and the Mangekyou (Amaterasu, Kamui with its
    wormhole and phasing, and more).
  - They reuse the old save variables: `…technique`, `…learn` and `…release`.
- **Nara:** Shadow Imitation Shuriken, Shadow Imitation, Shadow Gathering (30 s: double reach), Shadow–Neck Binding, Shadow Sewing
  (spikes out of the ground), Shadow Imitation Field. A `Hold` per caster keeps who is caught (`Caught`: spot, yaw offset, the
  shadow link). With mimic the caught copy the caster's steps, turns, look and swings in their own facing. Links re-lay every tick.
  Sneak + right-click lets go.
- **Restraint** (`ClanJutsu.restrain`, synced `restrained`): a player caught in a shadow or whose mind is taken can do nothing; the
  server cancels interactions/attacks/jutsu and pins the hotbar slot, `client/Restrained` cancels swings, scroll and mod keys.
- **Mind Body Switch** on a creature (`ClanJutsu.takeOver`): synced `possessing` = entity id + 1; `client/Restrained` moves the camera
  into it; the server drives it from `getLastClientInput()` and the player's look; attacks come in as the "mind" action.
- Nara shadow links are a Bezier curve; pieces move by their display transform (interpolated), not by position.
- Jutsu built from blocks use `Techniques.place` (real blocks, restored), not stretched block displays.
- **Uchiha** and **Yamanaka** clans have technique items (`JutsuItems` registers them, with the new eye and Shisui/Madara Mangekyou
  items). Yamanaka took Iburi's place everywhere (rule `iburi_is_yamanaka`; old saves' Iburi flag loads as Yamanaka).
- **Eyes:** Byakugan, Ketsuryugan, Rinnegan and Tenseigan are releases now (their old eye items are the scrolls), each needs its eye
  open. Mangekyou scrolls for Itachi, Kakashi, Shisui and Madara buy their jutsu track in `DojutsuJutsu.mangekyouScroll`; the Susanoo
  track still goes to the old procedure.
- Jutsu names follow the wiki (checked with the wiki's SMW `action=ask` API; its pages are behind Cloudflare, the API isn't). Release
  prefixes ("Fire Release:") are left off since the item already says which release.
- **Inuzuka:** Akamaru, Four Legs, Dynamic Marking, Passing Fang, Man Beast Clone, Fang Over Fang, Tunneling Fang.
  Akamaru's form (normal, clone or drill) is a synced value set by the `akamaru` rule.
- `FlyingRaijin` is a technique with a wheel on the Flying Raijin Kunai (ids still say `flying_thunder_god_kunai`):
  Throw Marked Kunai, Write Formula, Marking Strike, Flying Raijin, Level Two, Release Formulas. Formulas are saved
  in the player's persistent data, and marked creatures are kept in memory.
- `ShadowClones`: the clone limit grows with Ninjutsu (1 + Ninjutsu/15, at most 8). Each clone costs 25 chakra and
  lasts 60 s. Sneak + right-click releases them. Clones render with their owner's skin.
- `ThrownWeapons`: thrown shuriken and kunai arrows are swapped for `JutsuProjectile`s, so they look like the Fuma clan's.
  Their old landing procedures still drop the item or explode. Flying Raijin kunai stay arrows.

### Player systems (`core/`)

- `Eyes`: one Dojutsu key (tap to open or step up to the Mangekyou, sneak-tap to close everything, hold for a wheel)
  and a Susanoo key (hold to grow it, tap to dismiss). Only one Mangekyou is kept: getting a new one replaces the old.
- `ChakraControl`: the G key toggles it. While it's on you can:
  - walk on water and climb walls (client-side movement);
  - use Focus (sneak and stand still) to regenerate chakra and sense nearby creatures;
  - hit harder with sprinting punches (chakra-enhanced);
  - dash with Left Alt, in the direction you're walking.
- `NarutoActions`: the one client→server action packet (the cheats, info-card pages, eye, Susanoo, chakra and dash keys).
- `ModelSwapRenderers`: model swaps (Susanoo, Passing Fang and others) are drawn with the player's full body rotation,
  including gliding and swimming.
  - Dojutsu eyes are drawn in the Post event, so they hide when a form replaces the player.
  - A closed eye's texture gives way to any open eye.
- `EntityScale` scales entities (it replaced Pehkui), and `Progression` handles XP and levels.
- **Removed:** the Jutsu Power stat and its key (power follows Ninjutsu now). Also the old WASD double-tap dash keys.

### Client (`client/`)

- `EyeKeys` (all the keys, in their own "Naruto Shippuden" Controls category), `JutsuClient` (the jutsu wheel and
  scroll) and `WheelLayout` (the shared wheel layout, which keeps buttons from overlapping).
- `MessageToast`: every action-bar message becomes a small dark panel above the hotbar.
  - Its icon is the held item; an XP bottle for XP and JP; a book for stat gains; the eye itself for dojutsu; the
    player's own Mangekyou for the Susanoo.
  - "Label: value" shows the label in grey, and anything in brackets is grey too.
- `client/jutsu/`:
  - `AkamaruRenderer`: his own copy of the model with a separate **Neck** part, and wolf-like animations.
  - `AkimichiRenderer`: the tank ball, and the butterfly wings drawn as a body **layer**.
  - `KamuiClient`: phasing no-clip, set in `MovementInputUpdateEvent`.
  - `ShadowCloneRenderer`, `WeaponRenderer` (Flying Raijin kunai arrows) and `GolemRenderer`.
- Messages are plain sentence case above the hotbar. The `vanilla_messages` rule turned the old chat spam into overlay
  messages; story, quest and letter text stays in chat.

### Keys (defaults)

| Key | What it does |
|---|---|
| V | Dojutsu |
| B | Susanoo |
| G | Chakra Control |
| Left Alt | Dash |
| X | Jutsu wheel |
| I | Info card |

## Testing in the dev client

```
cd neoforge && JAVA_HOME=~/.jdks/jdk-25.0.4.1+1/Contents/Home ./gradlew runClient -PdevTest -PdevScreens -PquickPlay=devtest -PdevOnly=<mode>
```

Screenshots are saved to `run/screenshots/screen_*.png`, and `DEVTEST …` lines appear in the log. The modes
(`client/DevTest.java`) are:

- `jutsu`: casts every jutsu and logs the chakra each one spent. `-PdevJutsu=fire,water` limits it to those.
- `models`: summons entities. `-PdevModels=<ids>`; passing every `entityKey` id checks that nothing crashes.
- `batch5`: runs on a glass platform at y 220. It covers the wings, Akamaru's forms and sitting pose, the eye wheel,
  phasing through a wall, thrown weapons, gliding, Tenseigan, clones and their release, a Flying Raijin jump, the
  Inuzuka and Flying Raijin wheels, and water and wall walking.
- `eyes`, `weapons`, `akimichi`, `economy`.
- No `-PdevOnly`: shows every GUI screen.

Test code can call server code with `onServer(mc, p -> …)`. Use `raijin(p, option)` to cast a Flying Raijin option.

## NeoForge 26.3 gotchas learned the hard way

- ModelPart coordinates are already in blocks/16. **Never scale the pose by 1/16 again**; models end up tiny.
- `Player.tick` resets `noPhysics` right after `PlayerTickEvent.Pre`. For no-clip, set it in `MovementInputUpdateEvent`
  on the client and `PlayerTickEvent.Post` on the server.
- Player velocity must be sent with `syncVelocity = true`.
- For attachments that must follow every pose, add a `RenderLayer` via `EntityRenderersEvent.AddLayers` and call
  `getParentModel().body.translateAndRotate(pose)`. Look the entity up with `level.getEntity(state.id)`.
- NeoForge doesn't deliver a cancelled `RenderLivingEvent.Pre` to later listeners, and `Post` never fires for it.
- `SoundEvents.WOLF_*` only exist as `WOLF_*_BABY` or variant sounds.
- The shaded MC sources are in `neoforge/build/moddev/artifacts/minecraft-patched-*-sources.jar` (unzip into the
  scratchpad to grep them).

## Open ideas and unchecked items

- Some old techniques still run their MCreator procedures: Shadow Clone's story-exam branch, the Custom Jutsu and
  the Mangekyou scrolls.
- The Susanoo itself is still the old model swap. It now follows the body when gliding.
- Checked in the dev client but still waiting on the user's feedback: Flying Raijin, the Inuzuka jutsu, Chakra Control
  and the message panel.
