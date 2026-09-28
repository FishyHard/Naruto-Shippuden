# Handoff: Naruto Shippuden mod → NeoForge 26.3 port

Paste the "Prompt" section below into a new Claude Code session on this repository.

## Prompt

You are continuing the port of the Naruto Shippuden Minecraft mod (repo `FishyHard/Naruto-Shippuden`, private copy
`FishyHard/Naruto_Shippuden_Claude`) from Forge 1.16.5 (MCreator) to **NeoForge 26.3 (26.3.0.26-beta)**.
Work on branch `claude/clever-tesla-qme96b`, and push to both repos (the copy remote may need adding:
`git remote add copy https://github.com/FishyHard/Naruto_Shippuden_Claude.git`). Don't open PRs unless asked.

The user tests jars themselves (macOS M1, Prism Launcher, instance "26.3", Java 25). They send crash logs and you
fix them, rebuild, and send the jar (`neoforge/build/libs/naruto_shippuden-3.0.0.jar`).

### Immediate task (unfinished in the last session)
The game crashed when looking at a **paper bomb** block:
`IllegalArgumentException: The min values need to be smaller or equals to the max values` at
`ModBlocks$PaperBombBlock$CustomBlock.getShape`. MCreator wrote rotated shapes with min/max swapped.

The fix was written but may not be committed yet (git was unavailable at the end of the last session):
- `neoforge/porting/rules.py`: new `box_order` rule (normalises `box(a,b,c,d,e,f)` literals).
- `neoforge/src/main/java/net/mcreator/narutoshippudenmod/block/ModBlocks.java`, around line 886: the SOUTH,
  EAST and WEST cases must be `box(4, 0, 6, 12, 1, 10)`, `box(6, 0, 4, 10, 1, 12)`, `box(6, 0, 4, 10, 1, 12)`.

Check `git log`/`git diff`. If these are missing, re-apply them. Then build, commit, push to both remotes and
send the jar.

### Status
Compile, dedicated-server start, client start and in-world rendering are verified. The user reported that everything
works; dojutsu rendering was fixed with `RenderTypes.entityCutoutZOffset`. The only known open bug is the paper bomb
crash above.

### Layout
- `src/` (repo root): the original 1.16.5 mod (Forge 36, Java 8). Build with Java 8. It's still the source of truth
  for the port.
- `neoforge/`: the 26.3 port (ModDevGradle, Java 25). Build with
  `cd neoforge && JAVA_HOME=<java25> ./gradlew build`.
- `neoforge/porting/`: the conversion pipeline that generated `neoforge/src/main` from the 1.16.5 sources:
  - `port.py`: main entry point. It reads 1.16.5 sources remapped to Mojang names. That remap was a git worktree at
    `/home/user/remap`, made by building the 1.16.5 project with `mappings channel: 'official'`. It also reads 26.3 MC
    sources extracted to `/home/user/mcsrc` for API lookups.
  - `rules.py` holds the ordered regex/function rules; the per-system converters are `models.py`, `renderers.py`,
    `gui.py`, `blocks.py`, `armor.py`, `effects.py`, `particles.py`, `keybinds.py`, `itemgroups.py`,
    `structures.py`, `overlay.py` and `resources.py`.
  - `override/`: hand-written Java files (compat layer `compat/*`, `core/EntityScale`, `core/ModelSwapRenderers`,
    network, variables).
  - `res_override/`: hand-written data (villager trades).
  - The copy in the repo has `/home/user/...` paths inside. In a fresh container, **edit files in
    `neoforge/src/main` directly** for small fixes. Regenerating needs the remap worktree and mcsrc recreated, so
    only do that for large changes. When you fix something by hand, also add the matching rule to
    `porting/rules.py` so a regeneration keeps it.

### Key decisions and replacements
- Pehkui → `core/EntityScale` (vanilla `SCALE` attribute plus hitbox and eye multipliers through `EntityEvent.Size`).
- Kleiders custom renderer → `core/ModelSwapRenderers`:
  - Model swaps are drawn in `RenderLivingEvent.Pre`.
  - The entity is attached to the render state with a `ContextKey`.
  - Dojutsu eyes are drawn with `entityCutoutZOffset` (decal), because they lie exactly on the skin.
- FHCore has been removed.
- Villager trades are data now: `data/naruto_shippuden/villager_trade` plus the level_1 tags.
- The Kamui dimension is floating islands of kamui_void; Story Mode uses overworld noise with a fixed biome.
- NPC spawns are NeoForge `add_spawns` biome modifiers.
- Texture folders `items/` and `blocks/` are added to the item and block atlases via
  `assets/minecraft/atlases/*.json`. Block models may only use the block atlas.

### Testing headless (Linux container)
- Server: `./gradlew runServer`. To send console commands, enable RCON in `run/server.properties`.
- Client: set `SDL_VIDEODRIVER=offscreen`, `LIBGL_ALWAYS_SOFTWARE=1` and `GALLIUM_DRIVER=llvmpipe`, unset
  `DISPLAY`, and set `earlyWindowControl = false` in `run/config/fml.toml`.
- Use `./gradlew runClient -PquickPlay=<world in run/saves> -PdevTest`. `client/DevTest.java` then clicks through
  the experimental-settings and stat-select screens, turns on the Byakugan, switches to the front camera and saves
  `run/screenshots/devtest_*.png`.
- When killing processes, use `pkill -f "fml[.]modFolders"` (the brackets stop pkill from matching your own shell).

### For the user on Mac
If the game hangs on the NeoForge loading window, set `earlyWindowControl = false` in the instance's
`minecraft/config/fml.toml`.
