# 1.16.5 -> NeoForge 26.3 porting tools

`port.py` regenerates `../src/main/java` from the 1.16.5 sources remapped to Mojang member names
(ForgeGradle `updateMappings`). Stages: class renames (`classmap.txt`, `manual_classes.txt`, `nested.txt`),
code rules (`rules.py`), per-system generators (`models.py`, `renderers.py`, `effects.py`, `armor.py`, `gui.py`)
and hand-written files in `override/`.
