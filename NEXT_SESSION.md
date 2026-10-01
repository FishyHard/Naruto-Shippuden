# Naruto Shippuden: NeoForge 26.3 port, handoff notes

Read this first in a new session. It covers what the project is, how the user works, how the code is laid out, how the main
systems work, how to build and test, and the engine gotchas that cost time before.

## The project

- **What it is:** the Naruto Shippuden Minecraft mod (originally made in MCreator for Forge 1.16.5), ported to **NeoForge 26.3**
  (26.3.0.26-beta, Java 25). The jutsu, economy, dojutsu and clans have been rebuilt by hand on a shared jutsu engine.
- **Checkout:** `~/Desktop/Minecraft Mods/Naruto-Shippuden`, branch `claude/clever-tesla-qme96b`.
- **Remotes:** `origin` = FishyHard/Naruto-Shippuden, `copy` = FishyHard/Naruto_Shippuden_Claude. Push every commit to both.
  **Don't open PRs.**
- **Mod jar:** `neoforge/build/libs/naruto_shippuden-3.0.0.jar`. The user installs it themselves (macOS, Prism Launcher), plays,
  and sends screenshots with feedback. Send the jar with SendUserFile (it's about 13 MB; if the upload to their phone times out,
  send it again) and give a clear changelog.

## How the user works

- Feedback comes in **big batches** with screenshots, sometimes with more messages added while you work. Do all of it, test
  what can be tested in the dev client, then send **one jar plus a changelog**.
- On long batches they asked for a **progress update with a percentage about every 5 minutes**.
- They want **vanilla-looking** results: vanilla-style GUIs, text above the hotbar, keys in the Controls menu, pixel textures
  (not blurry ones), and real blocks rather than stretched block displays.
- **Follow the Naruto wiki** for jutsu names and what they do (see "Wiki research" below). Names are the wiki's, without the
  release prefix ("Great Fireball Technique", not "Fire Release: Great Fireball Technique"): the item already says which
  release it is.
- **Their own models come first.** Existing models and textures stay unless they ask. When a model of theirs looks right
  (for example the iron sand coat and wings), render it rather than inventing a new one.
- Ranks must **never** be tied to levels.
- The Shinobi Merchant must not sell character weapons (Seven Swordsmen blades, chakra blades), headbands or chakra paper.
- The YouTuber extras (Voltic Mode, Furamingogan, Custom Dojutsu) were removed on request. Don't bring them back.
- **Removed clans** (keep their logo textures): Izuno, Kurama, Shimura (the Shimura Sharingan stays), Namikaze, Kazekage,
  Hatake, Otsutsuki, Senju, Tenro, Yuki, Hoshigaki, Kaguya, and **Iburi** (its slot is now the Yamanaka clan).
- They sometimes play in the dev client window while a test runs. A test that looks wrong (a hotbar slot changed, the
  window resized) may be their input, not a bug.

## Build

```
cd neoforge && JAVA_HOME=~/.jdks/jdk-25.0.4.1+1/Contents/Home ./gradlew build
```

A build takes about 4 minutes; `./gradlew compileJava -q` checks the code in about 30 s. zsh doesn't split unquoted variables
into words, so use arrays in shell loops. The shell's working directory can change between commands: use absolute paths or
`cd neoforge &&` at the start.

## Layout

| Path | What it is |
|---|---|
| `src/` (repo root) | The original 1.16.5 MCreator mod. Only for reference. |
| `neoforge/src/main/java/net/mcreator/narutoshippudenmod/` | The port. Most files were **generated** from 1.16.5 by the porting pipeline; the rest are copies of the overrides. |
| `neoforge/porting/override/…` | **Hand-written Java.** Everything new lives here: the jutsu engine, GUIs and renderers. Each file is copied over its `src` twin. |
| `neoforge/porting/rules.py` | Ordered regex and function **rules** that fix or rewrite the generated code. Every hand fix to a generated file needs a matching rule. |
| `neoforge/porting/res_override/` | Hand-written resources: the lang file, item models, textures made for new work. `src/main/resources` has the same files, so write both. |
| `neoforge/porting/*.py` | The rest of the converter (`port.py` and the per-system converters), plus the tools below. |
| `neoforge/run/saves/devtest` | The dev test world. |

### How to change code

1. **Hand-written code:** edit it in `porting/override/…`, then run `rsync -a porting/override/ src/main/java/`. Before you
   rsync, `cmp` each override against its `src` copy: an override was stale once and nearly undid a feature. If you edit a
   `src` copy of an override directly, copy it back into `porting/override`.
2. **Generated code** (procedures, items, entities, renderers): write a **rule** in `porting/rules.py`, then apply it to `src`.
   `@func` rules get the file body only (`split_header` keeps imports out). Rules that must edit imports (like `dead_code` and
   `iburi_is_yamanaka`) take the whole file and are added with `RULES.append`. This runner applies named `@func` rules to every
   generated file that isn't an override (run it from `neoforge/porting`):

```python
import sys, os, glob
sys.path.insert(0, '.')
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

   Useful helpers in `rules.py`: `find_block(text, i)` (the end of the `{…}` block starting at `i`, aware of strings and
   comments), `remove_class(text, name)` and `remove_if_blocks(text, cond_regex)`.
3. **Dead code:** `python3 porting/dead_code.py porting/dead_classes.txt` adds member classes nothing live reaches
   (procedures, entities, renderers, items, GUIs, effects, particles) to the list; the `dead_code` rule then removes them with
   their imports, renderer/screen/particle/effect registrations, and the blank gaps. The list only ever grows. Run it after
   removing callers, then apply `dead_code` to whole files (not through the body-only runner), or the imports stay. Repeat
   until a round finds nothing.
   - An **item** is a root when players can get it: its id is in a creative tab (`ModItemGroups`, expanded like the tabs are),
     a data file (recipes, loot, trades, advancements) or a string in code outside the item itself. `KEEP` in `dead_code.py`
     holds items kept on purpose though nothing gives them (the Otsutsuki weapons: the user wants them in the game, hidden).
   - A nested class name several units repeat (`ItemRanged`, `GuiContainerMod`…) stands for none of them; a `Model…` defined
     in two renderers stands for both.
   - The generated GUIs' `handleButtonAction` branches the hand-written screens never send are cut by the `unused_gui_buttons`
     rule (table `GUI_BUTTONS` in `rules.py`: update it when a screen gains a button).
   - A generated file the rule empties completely is deleted by hand (`CustomJutsuProcedures.java` was); the pipeline would
     make it again as an empty class.
4. **New items** (technique items the old mod never had) are registered in `core/jutsu/JutsuItems` with
   `Registration.add`, called from the mod constructor. Give them an `items/*.json`, a `models/item/*.json` and a lang entry in
   both resource trees.
5. `JutsuTable.java` now only holds `shadow_clone_technique` (still cast by its MCreator procedure). Every other technique and
   scroll is registered by the jutsu classes.

### Porting rules added recently

| Rule | What it does |
|---|---|
| `engine_item_hooks` | Technique and release items never run their own `use()`; the old right-click procedures point at `ClanJutsu.unused`. |
| `engine_item_hit_hooks` | Technique and release items lose their `hurtEnemy` (the old on-hit effects, like Boil and Smoke). |
| `iburi_is_yamanaka` | Iburi's clan roll, select entry and info icon become Yamanaka's. |
| `old_magnet_models` | Turns off the old iron sand model swaps in `PlayerProcedures` (`client/jutsu/IronSandRenderer` draws them). |
| `remove_clans` | The removed clans' scrolls, techniques, paper rolls and info/select entries. |

## Main systems (all in `porting/override/net/mcreator/narutoshippudenmod/`)

### Jutsu engine (`core/jutsu/`)

- `Jutsus` is the registry of **techniques** (an item with a wheel of jutsu) and **releases** (a scroll where jutsu are bought
  with JP).
  - `Jutsus.cast` runs on right-click and cancels the item's own `use()`. It stops, in order, for: restrained or possessing,
    chakra sealed, not learned, the technique's requirement (an eye open, a clan), stat, chakra, cooldown.
  - The selected jutsu is always read through `Jutsus.index`: an index out of range means the first jutsu. Checks and cast use
    the same reading (they once differed, and unlearned jutsu fired).
  - `Jutsus.miss(player, message)`: a jutsu that finds nothing in reach (no target looked at, Akamaru not near) calls it, and
    the cast costs no chakra and starts no cooldown.
  - Sneaking is switched off during a cast. A technique can take sneak + right-click itself through `Technique.onSneak`
    (Shadow Clone releases its clones; Nara lets go of its shadow).
- `engine/JutsuRank` (E to S) sets each jutsu's JP price, Ninjutsu needed, chakra and cooldown, so every clan and release is
  priced on one scale. Cooldowns get shorter at higher shinobi ranks.
- `engine/Techniques` has the building blocks: `shoot`, `burst`, `cone`, `dash`, `strike`, `line`, `spray`, `puff`, `channel`
  (repeat for N ticks), `after` (delay) and `place` (a real block that is restored after N ticks).
  - `damage` scales with Ninjutsu (+1% per point, up to 2.5×) and adds each `Element`'s side effect (fire burns, ice slows,
    SHADOW slows, MIND nausea, BLOOD wither…).
- `engine/JutsuProjectile` is the one projectile type for all jutsu. Its `Shape`s are ORB, DRAGON, SHARK, RASENSHURIKEN, NEEDLE,
  NONE, CUBE, SHURIKEN, LION, SHELL, ROD, DAIKOKUTEN, VORTEX and KUNAI; `client/jutsu/JutsuProjectileRenderer` draws them tinted
  by the `Element`.
- `engine/Displays` makes block-display pieces: `grow`, `animate` (interpolated transform) and `remove`. Use them for flat or
  thin things (the Nara shadows, Shadow Sewing's spikes, ice mirrors). For anything that should look like blocks, use
  `Techniques.place` instead: stretched block textures look wrong to the user.
- **Jutsu classes**, all registered with `nature(id, title, has, selected, select, learned, setLearned, bought, setBought,
  new Def(name, rank, cast[, stat]))`, which makes the technique `<id>_release_technique` and the scroll `<id>_release`:
  - `NatureJutsu`: fire, water, wind, earth, lightning (5–6 jutsu each).
  - `KekkeiGenkaiJutsu`: boil, bone, dust, ice, magnet, smoke (fanon names), steel, storm, swift, typhoon, wood.
  - `ClanJutsu`: Aburame, Akimichi, Fuma, Hozuki, Hyuga, Inuzuka, Lee, Nara, Sarutobi, Uzumaki, Tsuchigumo, Uchiha, Yamanaka.
    Timed transformations use `mode()`: one at a time, cleaned up on death and logout. `ClanJutsu.stop` ends every mode,
    shadow and possession (the dev test calls it between casts).
  - `DojutsuJutsu`: Sharingan, Byakugan, Ketsuryugan, Rinnegan, Tenseigan, Kokugan (ids say `isshiki_dojutsu`) and the six
    Mangekyou. Each needs its eye open (`requires(...)`).
  - They reuse the old save variables `…technique`, `…learn` and `…release`; new ones were added in
    `NarutoShippudenModVariables` (save and load lines next to `nararelease`).

### Clans and eyes, in short

- **Nara** (`ClanJutsu`, "nara" section): Shadow Imitation Shuriken, Shadow Imitation, Shadow Gathering (30 s of double reach),
  Shadow–Neck Binding, Shadow Sewing, Shadow Imitation Field.
  - A `Hold` per caster keeps who is caught. Each `Caught` has its spot, its yaw offset from the caster, its shadow `link`, its
    `pool` (plus Sewing's spikes) and its own curve `bow`.
  - The shadow creeps along the ground (`creep`), then `bind` holds the caught. With mimic they copy the caster's steps, turns,
    look and swings in their own facing (the step is rotated by the yaw offset). Players are teleported with the rotation.
  - The link is a Bezier curve that sways; its pieces move by an interpolated display transform (`slide`), not by position.
    When someone caught dies, their pieces are removed at once.
  - Shadow Imitation Field holds its catch still while the caster walks. Sneak + right-click lets go.
- **Restraint** (`ClanJutsu.restrain`, synced variable `restrained`): a player caught in a shadow, possessed, or in Izanami's
  loop can do nothing. The server cancels item use, block and entity clicks, attacks and jutsu, and pins the hotbar slot;
  `client/Restrained` cancels swings, scrolling, hotbar keys, drop, off-hand swap and all of the mod's keys.
- **Yamanaka** (took Iburi's slot everywhere; old saves' Iburi flag loads as Yamanaka): Mind Body Transmission, Mind Body
  Switch, Mind Body Disturbance, Mind Body Transmission Formation, Mind Clone Switch.
  - Mind Body Switch on a creature is real control (`ClanJutsu.takeOver`). The synced `possessing` holds the entity id + 1.
    `client/Restrained` moves the camera into the creature and sends the player's look (Minecraft stops sending it while the
    camera is another entity). The server moves the creature with `move()` from `getLastClientInput()`. Attacks come in as
    the "mind" action. The caster's body is limp; sneak, damage to the body, or the time ends it.
  - Mind Clone Switch puppets only go for the caster's other enemies, never each other.
- **Uchiha:** Manipulating Windmill Triple Blades, Uchiha Return, Uchiha Flame Formation, Great Fire Destruction.
- **Uzumaki:** Four Symbols Seal locks a player's jutsu for 20 s (`ClanJutsu.sealed`).
- **Hozuki:** Hydrification makes the body liquid for 10 s (non-jutsu damage is cancelled, jutsu do half).
- **Inuzuka:** Akamaru, Four Legs, Dynamic Marking, Passing Fang, Beast Human Clone, Fang Passing Fang, Fang Rotating Fang.
  Akamaru's form (normal, clone, drill) is a synced value set by the `akamaru` rule.
- **Tsuchigumo:** Creation of Heaven and Earth powers up the next Fury.
- **Chinoike** has no clan technique: the wiki lists nothing beyond the Ketsuryugan, whose jutsu are on the eye's scroll.
- **Eyes:** the old eye items (`byakugan_release` …) are the scrolls, given when the eye awakens. The Sharingan has Genjutsu:
  Sharingan, Izanagi (10 s of undone damage, then the eye closes) and Izanami (a loop back to one moment, then the eye
  closes).
- **Mangekyou:** Itachi (Amaterasu, Tsukuyomi), Kakashi (Kamui, Kamui Lightning Cutter, Kamui Shuriken), Obito (the three
  Kamui), Sasuke (Amaterasu and Blaze Release), Shisui (Kotoamatsukami), Madara (Genjutsu: Sharingan, Susanoo: Fist). For
  every eye, `DojutsuJutsu.mangekyouScroll` sells the jutsu track and the Susanoo stages (Ribcage, Skeleton, Armoured, Complete,
  priced C, B, A, S; Itachi and Obito sell three), all on the engine. The stages still count in the old `…susanorelease` and
  `…susanolearn` variables, which the Susanoo key reads. Only one Mangekyou is kept per player (`Eyes.oneMangekyou`).
- `FlyingRaijin` is a technique with a wheel on the Flying Raijin Kunai (ids say `flying_thunder_god_kunai`): Throw Marked
  Kunai, Write Formula, Marking Strike, Flying Raijin, Level Two, Release Formulas.
- `ShadowClones`: the clone limit grows with Ninjutsu (1 + Ninjutsu/15, at most 8); 25 chakra and 60 s each; clones render with
  their owner's skin. The Aburame Insect Clone reuses the clone entity.
- `ThrownWeapons`: thrown shuriken and kunai arrows become `JutsuProjectile`s. Flying Raijin kunai stay arrows.

### Custom jutsu (`core/jutsu/CustomJutsu`, `gui/JutsuCreationScreens`)

- The Jutsu tab of the info card: 4 slots and an editor. A design is a name, a release the player has (natures and kekkei
  genkai), a `Form` (Bullets, Sphere, Shuriken, Beast, Dragon, Wave, Stream, Burst, Rain), a size, a speed and a power 1–5.
  Its `JutsuRank` comes from those choices and sets the JP price (rank.jp × 1.5 + 10), chakra, cooldown and Ninjutsu.
- Designs are stored one per line in the synced variable `custom_jutsu` (`name|release|FORM|size|speed|power`). They are not
  items: `Jutsus.EXTRA` adds them to that release's technique wheel after its own jutsu (`Technique.jutsu(variables)` is the
  per-player list; `technique.jutsu` alone is only the fixed ones).
- Creating needs the release and at least one jutsu learned from its scroll. Forget refunds half. The old one-slot designs
  migrate on login and the old `custom_*_release_technique` items are removed.
- Actions: `custom_jutsu` (key = the design), `forget_jutsu` (amount = slot).

### Learned jutsu (`Jutsus`)

- Release jutsu are learned **by id**: the synced string `learned_jutsu` (comma separated, e.g.
  `fire_release_technique/great_fireball_technique`; `Jutsu.key()` makes it from the technique id and the jutsu's name).
  `Jutsus.TRACKED` is every jutsu some scroll sells; those use the set, the rest (weapon arts, custom jutsu, Flying Raijin,
  Shadow Clone) keep their own rule.
- `Track.owned` is the number of leading tiers whose jutsu are all learned (the Susanoo stages still use their bought count).
  The buy code (`NatureJutsu.nature`, `DojutsuJutsu.mangekyouScroll`) calls `track.learnTier` and still writes the old counts.
- **Renaming a jutsu changes its key**: a save then loses it. Rename with a migration, or keep the old name's key.
- Migration: on login, if `learned_jutsu_migrated` is false, the old counts fill the set (count *n* = the first *n* jutsu, in
  today's order). `Jutsus.migrate(v, true)` does it again, adding: the dev test uses it after setting counts directly.

### Jutsu that cast themselves

`Jutsus.Jutsu` has an `own` cast (`Consumer<ServerPlayer>`). When set, `Jutsus.cast` runs it instead of the technique's procedure
and takes the chakra and cooldown itself (unless the jutsu called `Jutsus.miss`). Weapon arts and custom jutsu use it.

### Weapons (`core/jutsu/Weapons`)

- Each weapon with abilities is a technique registered by `weapon(item, kenjutsu, forms...)`; its arts are `art(...)` with a
  `JutsuRank` and a Kenjutsu minimum. The selected art is in the synced string `weapon_arts` (`item=index,...`). Art damage
  scales with Kenjutsu (`Weapons.hurt`), not Ninjutsu.
- Building blocks: `flow` (chakra through the blade for a while: bonus damage, reach modifier, on-hit effect, particles along
  the blade), `fly` (the real item thrown as an item display moved by its interpolated transform; `Flight.FLAT_YZ` for
  Kubikiribocho, `FLAT_XY` for the scythe, `POINT` for Nuibari, which never spins), guards (Uchiha Return), rituals (Jashin),
  marks (blood, curse), Hiramekarei's stored chakra (`StoredChakra` tag) and forms (item swap with `FormUntil`).
- Passives: Samehada eats chakra (`Absorbed` tag), Kubikiribocho mends on hit and kill, the scythe draws blood.
- Too little Kenjutsu halves melee hits (it used to drop the weapon). `KENJUTSU` and `PASSIVES` feed the tooltips.
- Rules `weapon_old_procedures` and `weapon_old_sharpness` switched the old MCreator weapon code off.

### Village shinobi (`core/jutsu/ShinobiAI`, `client/ShinobiRenderer`)

- Genin/Chunin/Jonin (`ShinobiRank` 0–2, `JutsuPower` for `Techniques.power`), stats, a name, a kunai or tanto. Summon a rank with
  `/summon naruto_shippuden:hidden_cloud_shinobi ~ ~ ~ {NeoForgeData:{ShinobiRank:2}}`.
- `Combat` goal: footwork at the village's range with strafing, hand signs (entity event 71, the client poses the arms) before
  the village's nature jutsu (the same `NatureJutsu` methods players use, which now take any `LivingEntity`), kunai and shuriken,
  melee, Body Flicker, retreat when low. Substitution (a real log for 2 s) in a damage event.
- Targets: whoever hurt them (comrades are alerted), whatever hurts or is hit by a player of their village, monsters.
  `Techniques.ALLIES` keeps their jutsu off their own side.
- Rules `shinobi_ai` and `shinobi_renderer`. The renderer wraps their own model (pose on top of its walk) and draws the held item.

### Kurama (`core/jutsu/Kurama`)

- Claw swipe, tail sweep, roar (with the roar animation, entity event 100), Tailed Beast Ball (charges in the mouth for 2 s,
  element `BIJU`), a volley of small ones, a leap with a landing shockwave. Faster below half health. Heals slowly (the old
  procedure gave Instant Health every tick). Nothing breaks blocks. Rule `kurama_ai`. Model, hitboxes and animation untouched.

### DNA (`core/jutsu/Dna`)

- Village shinobi drop Undefined DNA (5/10/15% by rank, Genin to Jonin); nothing else does.
- Right-click Undefined DNA: always identifies (80% a nature, 20% a kekkei genkai). Right-click a DNA: implant in yourself; hit a
  player: implant in them. The implanter's Medicine sets the chance (nature 50→100%, kekkei genkai 25→100% over Medicine 0→300);
  a failure uses the DNA up.
- A kekkei genkai needs its natures (`Kind.needs`), unless `combine_natures` is off in the config. Canon: Boil, Dust, Ice, Magnet,
  Storm, Wood. Our choices: Steel (Earth+Fire), Swift (Wind+Lightning), Typhoon (Wind+Water), Smoke (Fire+Wind+Water), Bone (none).
- Rules `dna_items` (the items lose use/hurtEnemy) and `old_dna_drop` (no 1% drop from any mob).

### Config (`core/NarutoConfig`)

- A NeoForge config, `config/naruto_shippuden-common.toml`, editable in game (Mods → Naruto Shippuden → Config; screen in
  `client/ConfigScreen`, names in the lang file under `naruto_shippuden.configuration.*`). Sections clans, awakening (minutes),
  dna. Read from memory.
- The old `config/narutoshippuden/narutoshippudenconfig.json` is imported once on load and renamed `.old`. Rule `config_reads`
  turned the procedures' file reads (the player tick read it every tick) into `NarutoConfig` calls; `CONFIG_KEYS` in `rules.py`
  maps the old keys. A new old-key read makes the rule fail loudly.
- `playerskins` in the old folder is a separate feature and stays.

### Performance

- Rule `sync_on_change`: the procedures' set-and-sync only syncs when the value changes. Before, the player tick copied health
  into the variables every tick and every player got all their variables 20 times a second; now about once a second.
- `core/TickProfiler` (dev only): `DEVTEST tick` lines with the mod's player-tick time, syncs a second and who asked for them.
  Mode `perf`.

### Stats (`core/Stats`)

- Applied as saved attribute modifiers: Medicine +6 max health per 10 (200 at 300) and healing, Speed +3.5% a point, Taijutsu
  +1 fist damage per 15. (The old `/attribute` commands named `generic.*` attributes that no longer exist; rule
  `old_stat_attributes` removed them.)
- `Stats.upgrade` (action `stat`) spends up to SP-per-click, never past the cap, and refuses a maxed stat. Caps: Taijutsu 120,
  Kenjutsu 100, Shurikenjutsu 40, Summoning 60, Kinjutsu 100, Medicine 300, Speed 10, Genjutsu 70, IQ 220; Ninjutsu and Senjutsu
  have none (they add 10 max chakra / 15 senjutsu chakra a point; Ninjutsu stops adding damage at 150).

### Creative tabs (`itemgroup/ModItemGroups`, hand-written)

Nature Releases, Kekkei Genkai, DNA, Clans, Dojutsu, Shinobi Weapons, Headbands, Shinobi Items; spawn eggs in the vanilla tab.

### Magnet Release iron sand (`client/jutsu/IronSandRenderer`)

- A layer on the player, chosen by the synced `magnet_coat`: 1 = Iron Sand Wall, 2 = Black Iron Fist (the form lasts 5 s),
  3 = Black Iron Wings.
- It draws the **user's original Blockbench models** (`JutsuRenderers.MagnetCoatRenderer` and `MagnetWingsRenderer`,
  `createBodyLayer()`): their `Body` part rides the player's body, and the wings beat by nudging `leftwing` and `rightwing`
  after `resetPose()`. The models' own arms are not drawn: they sat outside the player's.
- Under the coat there's a fitted iron sand layer over the body, arms and legs, so only the head shows.
- The fist adds two giant floating hands, built for each side (thumbs inward, fingers curling forward). The right one punches.
- Black Iron Wings glide on the elytra system (the `GLIDING_FLIGHT` attribute), like the Akimichi butterfly wings.
- Textures: `textures/entities/jutsu/iron_sand_cloak.png` (128 px, for the original models) and `iron_sand.png` (64 px), both
  pixel-art mottled black with iron glints.

### Player systems (`core/`)

- `Eyes`: one Dojutsu key (tap to open or step up to the Mangekyou, sneak-tap to close everything, hold for a wheel) and a
  Susanoo key (hold to grow it, tap to dismiss). `Eyes.closeAll` closes every eye.
- `ChakraControl`: the G key toggles it: water and wall walking, Focus (sneak and stand still) to regenerate chakra and sense,
  harder sprinting punches, and a dash on Left Alt.
- `NarutoActions`: the one client→server action packet (cheats, info-card pages, eyes, Susanoo, chakra, dash, and "mind" for
  possession attacks and looks).
- `ModelSwapRenderers`: model swaps (Susanoo, Passing Fang and others) drawn with the player's full body rotation.
- `EntityScale` scales entities (it replaced Pehkui); `Progression` handles XP and levels.

### Client (`client/`)

- `EyeKeys` (all the keys, in their own "Naruto Shippuden" Controls category), `JutsuClient` (the jutsu wheel and scroll),
  `WheelLayout` and `Restrained` (restraint and possession, above).
- `MessageToast`: every action-bar message becomes a small dark panel above the hotbar.
- `client/jutsu/`: `AkamaruRenderer`, `AkimichiRenderer` (the tank ball and the butterfly wings layer; its `PartModel` and
  `draw` are reused by other layers), `IronSandRenderer`, `KamuiClient`, `ShadowCloneRenderer`, `WeaponRenderer`,
  `GolemRenderer`.

### Keys (defaults)

| Key | What it does |
|---|---|
| V | Dojutsu |
| B | Susanoo |
| G | Chakra Control |
| Left Alt | Dash |
| X | Jutsu wheel |
| I | Info card |

## Wiki research

WebFetch gets HTTP 402 from fandom, and fandom's normal pages sit behind a Cloudflare check (don't try to get round it). The
**MediaWiki API works** with `curl -A "Mozilla/5.0"`:

- A page's wikitext or rendered text: `https://naruto.fandom.com/api.php?action=parse&page=<Page>&prop=text&format=json&redirects=1`.
  Clan and eye pages list their jutsu in the infobox of the rendered text.
- Every jutsu of a nature or clan, from the wiki's semantic data:
  `api.php?action=ask&format=json&query=[[Chakra Nature::Fire Release]]|?Debut manga|?Appears in|limit=500` (or
  `[[Clan::Nara Clan]]`). Prefer jutsu that appear in the manga.
- The Smoke and Bone Releases the user linked are on `narutofanon.fandom.com` (same API). Canon Bone Release is the
  Shikotsumyaku page.

Scripts that did this (`fetch.py`, `ask.py`) were in the session scratchpad; they're a few lines each to rewrite.

## Testing in the dev client

```
cd neoforge && JAVA_HOME=~/.jdks/jdk-25.0.4.1+1/Contents/Home ./gradlew runClient -PdevTest -PdevScreens -PquickPlay=devtest -PdevOnly=<mode>
```

Screenshots are saved to `run/screenshots/screen_*.png`, and `DEVTEST …` lines appear in the log. The modes
(`client/DevTest.java`):

- `jutsu`: casts every jutsu at five no-AI husks 16 blocks away and screenshots each from the side (`_a`, frozen) and from
  behind (`_b`). `-PdevJutsu=fire,nara,mangekyou_sharingan_itachi_release_technique` limits it. The log line
  `DEVTEST cast <nature> <i>: chakra <n>` shows what each cast spent: **5000 means it didn't go off**. That's either a real
  problem or a correct miss (jutsu with a shorter reach than 16 blocks, such as Water Prison, Double Suicide and Mind Body
  Switch, miss the husks and refund).
  - Before each cast it opens the eye that cast needs and turns on only that Mangekyou; every release is learned to 9.
  - `nara` 1 also checks mimic (`DEVTEST nara mimic <n>: caster x … husk x …`, the two must match). `magnet` 0 and 4 also
    take a front screenshot (`_front`).
  - The husks have no AI: vanilla doesn't move a no-AI mob by velocity (possession moves it with `move()` for that reason).
- `models`: summons entities. `-PdevModels=<ids>`.
- `batch5`: wings, Akamaru's forms, the eye wheel, phasing, thrown weapons, gliding, Tenseigan, clones, a Flying Raijin jump,
  the Inuzuka and Flying Raijin wheels, water and wall walking.
  - The jutsu list also takes the weapon ids (`-PdevJutsu=kubikiribocho,nuibari`; the player stands closer for weapons) and gives
    nine test custom jutsu (one per form) on the five nature wheels.
- `shinobi` (a Jonin of each village against a husk, 14 shots each), `kurama` (Kurama against a husk), `customscreen` (the Jutsu
  page, editor and wheel), `stats` (capped upgrading and the info card), `tabs` (each creative tab).
- `learned`: an old-style save (`firelearn = 3`) migrated, buying on, order independence, the Obito and Sasuke scrolls (names,
  prices, screenshots, the Susanoo track) and one Mangekyou at a time. Log lines `DEVTEST learned …` (`11100` = which jutsu are learned).
- `dna` (implanting, natures needed, the config switch, Medicine, identifying, drops, tooltips), `headband` (front/back/side
  shots of a headband), `perf` (see Performance).
- `eyes`, `weapons`, `akimichi`, `economy`. No `-PdevOnly`: shows every GUI screen.

Test code can call server code with `onServer(mc, p -> …)`. A full `jutsu` run takes about 15 minutes. Run it in the
background and watch the log for `Exception|Caused by`.

## Porting rules added recently (continued)

| Rule | What it does |
|---|---|
| `weapon_old_procedures`, `weapon_old_sharpness` | The weapons' old procedures and NBT sharpness bonuses are off. |
| `shinobi_ai`, `shinobi_renderer` | Village shinobi use ShinobiAI and ShinobiRenderer. |
| `kurama_ai` | Kurama uses core/jutsu/Kurama; no per-tick Instant Health. |
| `old_stat_attributes` | The broken `/attribute generic.*` commands are gone. |

Apply new `@func` rules with the body-only runner under "How to change code".

## Multiplayer testing

- `./gradlew runServer -PdevTest` starts a dedicated server in `neoforge/run-server` (offline mode, flat world, Caster/Watcher/Dev
  are operators; `/narutodev` is on with -PdevTest).
- Clients join it from outside Gradle: capture a dev client's command line (`ps -o args=` while `./gradlew runClient` runs), then
  start java with it, `--quickPlayMultiplayer localhost:25565 --username <name> --gameDir <dir>`. Two things bit: the program
  args file splits on spaces (the game dir must not contain "Minecraft Mods"), and the game dir needs `config/fml.toml` with
  `earlyWindowControl = false`, or the early window times out when started from a script.
- In multiplayer the dev test sends its commands over the network and its server steps as `/narutodev` (`core/DevServer`, the same
  code singleplayer calls directly). Mode `watch`: a second player who screenshots when the caster's test says so
  (`/narutodev shot`), from beside the arena (`/narutodev watch`).
- Other players' clients get only the variables in `NarutoShippudenModVariables.VISIBLE` (sent to trackers on change and on
  StartTracking). A renderer reading a variable of *another* player that isn't listed sees its default: add it there.
- The procedures' player tick runs on a client only for its own player (rule `tick_only_own_player`): on other players' copies
  it acted on numbers the client doesn't have (the Susanoo turned itself off on everyone else's screen).
- Watch for: client code reading server statics (shared in singleplayer, empty on a remote client), and common code loading
  client classes (a dedicated server crashes on start).

## NeoForge 26.3 gotchas learned the hard way

- ModelPart coordinates are already in blocks/16. **Never scale the pose by 1/16 again**.
- **Don't mirror a model with a negative scale:** it turns the faces inside out (culled). Build the mirrored geometry instead
  (`IronSandRenderer.mirror`).
- In a layer after `body.translateAndRotate`, +Y is down and −Z is the front. Parts drawn "upright" (wings) are turned with
  `rotate(Axis.ZP, PI)`, which flips X as well.
- For attachments that follow every pose, add a `RenderLayer` via `EntityRenderersEvent.AddLayers` and use the parent model's
  parts; look the entity up with `level.getEntity(state.id)`.
- Block displays are never culled (`noCulling`), so they can be moved far by their transform, which is interpolated (smooth).
  Moving them by position snaps.
- `LocalPlayer` only sends its position and look while it's the camera entity (`isControlledCamera`); its movement keys still
  arrive (`ServerPlayer.getLastClientInput()`).
- `ServerPlayer.setCamera` also teleports the player's body to the camera each tick (spectator behaviour): use a client-side
  camera instead when the body must stay.
- A mob with `NoAI` doesn't travel: no gravity, and velocity alone won't move it.
- `Player.tick` resets `noPhysics` right after `PlayerTickEvent.Pre`; for no-clip set it in `MovementInputUpdateEvent`
  (client) and `PlayerTickEvent.Post` (server).
- Velocity must be sent with `syncVelocity = true` (there's no `hurtMarked`).
- NeoForge doesn't deliver a cancelled `RenderLivingEvent.Pre` to later listeners, and `Post` never fires for it.
- Colour blocks are collections: `Blocks.CONCRETE.pick(DyeColor.BLACK)`. `ParticleTypes.FLASH` needs a colour option.
  `SoundEvents.WOLF_*` only exist as `WOLF_*_BABY` or variant sounds.
- The shaded MC sources are in `neoforge/build/moddev/artifacts/minecraft-patched-*-sources.jar` and NeoForge's in
  `~/.gradle/caches/modules-2/files-2.1/net.neoforged/neoforge/26.3.0.26-beta/*/neoforge-*-sources.jar`: unzip into the
  scratchpad to grep them.
- `LivingEntity.swing` takes `(hand, SwingAnimation.DEFAULT, true)`; `PoseStack.rotateDegrees(Axis, deg)`, not `mulPose`.
- Item displays: `display.getSlot(0).set(stack)` sets the item; their position setter for interpolation is private, so move them
  by their transform. Mob persistent data is saved as `NeoForgeData`.
- Attribute ids have no `generic.` prefix any more (`minecraft:max_health`).
- `PartDefinition.addOrReplaceChild` keeps the replaced part's children: a model built on `HumanoidModel.createMesh` that
  replaces "head" still has the hat cube (bigger than the head) unless it adds an empty "hat" under the new head (rule
  `headband_hat`; it drew stray bits of texture beside the headbands).
- `ItemDescriptions.add` adds up: several calls for one item give all their lines.
- Image work needs Pillow: make a venv in the scratchpad (`python3 -m venv venv && ./venv/bin/pip install pillow`).

## Open items

- Mind Body Switch control (camera, keys, look) can't be checked by the automated test: it was fixed from the user's report and
  is waiting on their feedback.
- Shadow Clone still runs its MCreator procedure (including the story-exam branch); it's the last entry in `JutsuTable`.
- The Susanoo itself is still the old model swap (`KeybindProcedures` reads the stage counts).
- Otsutsuki weapons: registered, in no tab (only `/give`), switching forms with the old `OtsutsukiToolsSwitchProcedure`.
- The Susanoo is still the old model swap.
- Checked in the dev client but still waiting on the user's feedback: Flying Raijin, Chakra Control, the message panel, and
  most of the new wiki jutsu.
