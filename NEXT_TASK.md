# Next task: finish replacing the MCreator code

Read `NEXT_SESSION.md` first (layout, rules, build, dev test, gotchas). The user tested the last batch and is happy with it.
This task has three parts. Do them in order, test each in the dev client, then send **one jar and a changelog**. Push every
commit to both remotes (`origin`, `copy`); don't open PRs. Give a progress update with a percentage about every 5 minutes.

## 1. Obito's and Sasuke's Mangekyou scrolls

- The scrolls `mangekyou_sharingan_obito_release` and `mangekyou_sharingan_sasuke_release` still buy with their old MCreator
  procedures (`DojutsuProcedures.MangekyouSharingan…ReleaseRightclickedProcedure` and friends). Itachi, Kakashi, Shisui and
  Madara already use `DojutsuJutsu.mangekyouScroll` (look at how it's done around `DojutsuJutsu.java:137` and `:736`).
- Move Obito and Sasuke onto `mangekyouScroll` the same way: the jutsu track priced by `JutsuRank`, the Susanoo track still
  handed to the old procedure (the Susanoo itself is still the old model swap; don't remake it in this task).
- Keep the existing save variables (`mangekyousharinganobitokamuilearn`, `mangekyousharingansasukeamaterasulearn`, their
  `…release` bought counts) so progress carries over.
- Check: the scroll screen lists every tier with the right names and prices; buying unlocks the right jutsu on the wheel;
  `Eyes.oneMangekyou` still holds.

## 2. Learned jutsu by name, not by count

- Today a release stores *how many* of its jutsu were learned (`firelearn`, `waterlearn`, … and the `…release` bought counts).
  A jutsu is learned when that count reaches its tier. So adding, removing or reordering a release's jutsu shifts what old saves
  have unlocked.
- Replace it with a set of learned jutsu ids per player: a new synced string variable (for example `learned_jutsu`, ids like
  `fire_release_technique/great_fireball_technique`), saved and loaded next to `custom_jutsu` in
  `NarutoShippudenModVariables` (override).
  - `Jutsus.Jutsu.isLearned` reads the set.
  - `Jutsus.learn` and the release buy code (`NatureJutsu.nature`, and the same pattern in the kekkei genkai, clan and dojutsu
    classes) add to it.
  - Tiers still cost JP in order: the next tier is the first one not in the set.
- **Migration:** on login, if the set is empty, fill it from the old counts with today's jutsu order (the count *n* means the
  first *n* jutsu of that release), then keep the old counts only as a fallback. Do this once (a flag in the variables).
- Everything that reads `…learn` for jutsu (the wheel, tooltips, `ScrollScreen`, `DevTest` setup, the table in `JutsuTable`)
  must go through the new check. Grep for `learn\b` and `learned.applyAsDouble`.
- Test: an old-style save with `firelearn = 3` must come out with exactly the first three fire jutsu. Learning more still works
  in order. Reordering a release's list in code must no longer change what is learned.

## 3. Remove the MCreator code that isn't used any more

- Run `python3 porting/dead_code.py porting/dead_classes.txt`, then apply the `dead_code` rule to whole files (not the
  body-only runner), rebuild, and repeat until nothing new is found. Parts 1 and 2 will free more procedures.
- Go further than that tool:
  - generated items, entities, renderers, GUIs, models and textures nothing registers or references any more;
  - the old custom jutsu items and procedures (`custom_*_release_technique`, `CustomJutsuProcedures`, the
    `CreateJutsuGUI2Gui` page);
  - the `Tailed Beast Bomb` item and anything else only Kurama's old AI used;
  - variables only dead code read. Keep their load lines if old saves might carry them, but drop the fields that are truly
    unused.
- Rules:
  - Every hand fix to a generated file needs a matching rule in `porting/rules.py`.
  - Hand-written code lives in `porting/override`: `cmp` each override against its `src` copy before `rsync`.
  - Keep the user's models and textures (the removed clans' logo textures stay).
  - Don't remove anything the user can still get: items in the creative tabs, spawn eggs, merchant stock, mission rewards,
    recipes and loot tables.
- After each removal round: `./gradlew build`, a dev client start (check the log for `Exception|Caused by|Missing`), and the
  `jutsu`, `tabs` and `customscreen` modes. Report how many classes and lines went.

## When done

- Update `NEXT_SESSION.md`: the open items, anything whose layout changed, and new gotchas.
- Send the jar and a clear changelog. Say plainly what was tested and what wasn't.
