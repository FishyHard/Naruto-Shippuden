# Naruto Shippuden mod: everything in the game

NeoForge 26.3 port, version 3.0.0. Generated from the mod's code on 2026-10-01, so it matches this build. Names are the ones shown in game.

## Contents

- [How jutsu work](#how-jutsu-work)
- [DNA](#dna)
- [Nature releases](#nature-releases)
- [Kekkei genkai](#kekkei-genkai)
- [Clans](#clans)
- [Dojutsu (eyes)](#dojutsu-eyes)
- [Mangekyou Sharingan](#mangekyou-sharingan)
- [Other techniques](#other-techniques)
- [Custom jutsu](#custom-jutsu)
- [Weapons and their arts](#weapons-and-their-arts)
- [Items](#items)
- [Mobs and characters](#mobs-and-characters)
- [Blocks](#blocks)
- [Effects](#effects)
- [World](#world)
- [Stats, ranks and progression](#stats-ranks-and-progression)
- [Settings](#settings)
- [Controls](#controls)

## How jutsu work

- A **release scroll** (right-click) opens the jutsu scroll: each jutsu is bought in order with **JP**. The first purchase gives the **technique item**.
- Hold the technique item and press **X** for the jutsu wheel; right-click casts the selected jutsu. Each jutsu has its own chakra cost and cooldown.
- Every jutsu has a rank that sets its price, the Ninjutsu it needs, its chakra cost and its cooldown. Cooldowns get shorter at higher shinobi ranks (x1.25 Academy Student, x1 Genin, x0.85 Chunin, x0.7 Jonin, x0.55 Kage).
- Damage grows with Ninjutsu (+1% a point, up to 2.5x). A jutsu that finds no target costs nothing.

| Rank | JP | Ninjutsu | Chakra | Cooldown (Genin) |
|---|---|---|---|---|
| E | 3 | 0 | 25 | 2s |
| D | 6 | 5 | 50 | 4s |
| C | 12 | 12 | 100 | 8s |
| B | 20 | 22 | 180 | 14s |
| A | 32 | 35 | 300 | 24s |
| S | 50 | 50 | 500 | 45s |

## DNA

How you gain natures and kekkei genkai.

- **Undefined DNA** drops from shinobi: village shinobi 15% (Genin), 25% (Chunin), 40% (Jonin); Asuma and Shikamaru 50%; Kurama always drops 3. Other mobs never drop it.
- **Right-click Undefined DNA** to identify it. It always works: 80% a nature DNA, 20% a kekkei genkai DNA.
- **Right-click a DNA** to implant it in yourself, or **hit a player** with it to implant it in them. Implanting is a medical procedure: the implanter's **Medicine** sets the chance. A nature goes from 50% at Medicine 0 to 100% at 300, a kekkei genkai from 25% to 100%. A failure uses up the DNA. The DNA's tooltip shows your chance.
- A **kekkei genkai combines natures**: you need them before its DNA can be implanted. This can be turned off in the settings.
- Success unlocks the release and gives its scroll. Two DNA can be crafted back into one Undefined DNA.

| Kekkei genkai | Needs |
|---|---|
| Boil Release | Fire + Water |
| Bone Release | no natures |
| Dust Release | Earth + Wind + Fire |
| Ice Release | Water + Wind |
| Magnet Release | Wind + Earth |
| Smoke Release | Fire + Wind + Water |
| Steel Release | Earth + Fire |
| Storm Release | Lightning + Water |
| Swift Release | Wind + Lightning |
| Typhoon Release | Wind + Water |
| Wood Release | Earth + Water |

Boil, Dust, Ice, Magnet, Storm and Wood follow the Naruto wiki. The wiki gives none for Steel and Swift, says Typhoon includes Wind, Smoke is from the fan wiki, and Bone (the Kaguya clan's Shikotsumyaku) isn't made of natures.

## Nature releases

Each nature is unlocked with its DNA (or rolled). Scroll: `<nature>_release`, technique: `<nature>_release_technique`.

### Fire

| Jutsu | Rank | JP | Chakra | Needs | What it does |
|---|---|---|---|---|---|
| Phoenix Sage Fire Technique | D | 6 | 50 | 5 Ninjutsu | Five small fireballs in a fan. |
| Great Fireball Technique | C | 12 | 100 | 12 Ninjutsu | A great ball of fire that bursts into flames. |
| Great Flame Technique | B | 20 | 180 | 22 Ninjutsu | Breathes a stream of fire for two seconds. |
| Great Dragon Fire Technique | A | 32 | 300 | 35 Ninjutsu | A dragon of fire or water that passes through everything in its way. |
| Great Fire Annihilation | S | 50 | 500 | 50 Ninjutsu | Great Fire Annihilation: a sea of flame pours out in a wide front and burns everything across a great distance. |

### Water

| Jutsu | Rank | JP | Chakra | Needs | What it does |
|---|---|---|---|---|---|
| Water Gun Technique | D | 6 | 50 | 5 Ninjutsu | Three quick water bullets. |
| Water Formation Wall | C | 12 | 100 | 12 Ninjutsu | A spinning wall of water around the caster for five seconds: pushes enemies out and stops projectiles. |
| Water Prison Technique | C | 12 | 100 | 12 Ninjutsu | Water Prison: a sphere of water closes round the enemy looked at. As long as the caster keeps their hand in it (stays where they stand) the enemy is trapped and drowns; walking away bursts the prison. |
| Water Shark Bullet Technique | B | 20 | 180 | 22 Ninjutsu | A shark of water that hunts the nearest enemy. |
| Water Dragon Bullet Technique | A | 32 | 300 | 35 Ninjutsu | A dragon of fire or water that passes through everything in its way. |
| Great Waterfall Technique | S | 50 | 500 | 50 Ninjutsu | Great Waterfall Technique: a torrent of water rises in front of the caster and crashes forward, sweeping everything away. |

### Wind

| Jutsu | Rank | JP | Chakra | Needs | What it does |
|---|---|---|---|---|---|
| Gale Palm | D | 6 | 50 | 5 Ninjutsu | A blast of wind from the palm that throws everything in front back. |
| Vacuum Sphere | C | 12 | 100 | 12 Ninjutsu | Five rapid bullets of compressed air. |
| Great Breakthrough | B | 20 | 180 | 22 Ninjutsu | Great Breakthrough: a gale from the mouth that blasts everything in front far away and blows projectiles out of the air. |
| Vacuum Great Sphere | A | 32 | 300 | 35 Ninjutsu | Vacuum Great Sphere: three great balls of compressed air, each bursting where it lands. |
| Rasenshuriken | S | 50 | 500 | 50 Ninjutsu | Thrown Rasenshuriken: on impact a storm of wind blades pulls enemies in and cuts them for three seconds. |

### Earth

| Jutsu | Rank | JP | Chakra | Needs | What it does |
|---|---|---|---|---|---|
| Double Suicide Decapitation Technique | D | 6 | 50 | 5 Ninjutsu | Double Suicide Decapitation Technique: the caster sinks into the ground, burrows under the enemy looked at and drags them down into the earth up to their chest, stuck there for three seconds. |
| Rock Pillar Spears | C | 12 | 100 | 12 Ninjutsu | Stone spikes burst out of the ground in a line, launching whatever stands there. |
| Earth-Style Wall | C | 12 | 100 | 12 Ninjutsu | Raises a wall of earth in front of the caster that crumbles back after 12 seconds. |
| Golem Technique | B | 20 | 180 | 22 Ninjutsu | Summons an earth golem that fights for the caster for 30 seconds. |
| Earth Dragon Bullet | B | 20 | 180 | 22 Ninjutsu | Earth Dragon Bullet: a dragon of mud that rams through everything and spits balls of mud at enemies near its path. |
| Swamp of the Underworld | A | 32 | 300 | 35 Ninjutsu | Turns the ground where the caster looks into deep mud for eight seconds: enemies sink, slow down and choke. |

### Lightning

| Jutsu | Rank | JP | Chakra | Needs | What it does |
|---|---|---|---|---|---|
| Chidori Senbon | D | 6 | 50 | 5 Ninjutsu | Five needles of lightning in a fan; each numbs what it hits. |
| Lightning Beast Tracking Fang | C | 12 | 100 | 12 Ninjutsu | Lightning Beast Tracking Fang: a beast of lightning that hunts the enemy; its shock jumps to three more enemies nearby. |
| Lariat | B | 20 | 180 | 22 Ninjutsu | Lightning Lariat: the caster charges up in crackling lightning armor, then charges forward (steering with their look) and clotheslines the first enemy in the way, launching it with a shockwave. Running into a wall ends the charge in a shockwave too. |
| Chidori | A | 32 | 300 | 35 Ninjutsu | Chidori: lightning gathers in the hand with the chirping of a thousand birds, then the caster lunges and runs the enemy through. |
| Four Pillar Bind | A | 32 | 300 | 35 Ninjutsu | Four Pillar Bind: four stone pillars rise round the enemy looked at and lightning arcs between them, pinning and shocking everything inside for four seconds. |
| Kirin | S | 50 | 500 | 50 Ninjutsu | Kirin: thunderclouds gather over the target, then a huge dragon of lightning dives onto it, followed by a storm of bolts. |

## Kekkei genkai

Unlocked with their DNA. Same scroll and technique pattern as the natures.

### Boil Release

| Jutsu | Rank | JP | Chakra | Needs | What it does |
|---|---|---|---|---|---|
| Skilled Mist Technique | C | 12 | 100 | 12 Ninjutsu | A cloud of acidic mist where the caster looks: burns and weakens for six seconds. |
| Steam Dash | B | 20 | 180 | 22 Ninjutsu | Rushes the caster forward for a few ticks; enemies they pass through are hurt once and thrown. |
| Erupting Propulsion Fist | B | 20 | 180 | 22 Taijutsu | Erupting Propulsion Fist: steam bursts from the elbow and drives a punch that sends everything in front flying. |
| Steam Explosion | A | 32 | 300 | 35 Ninjutsu | Steam Explosion: the steam built up in the body bursts out all at once, scalding and blasting everything around. |
| Unrivalled Strength | A | 32 | 300 | 35 Ninjutsu | Twenty seconds of boiling strength: much stronger, tougher, and steaming. |

### Bone Release

| Jutsu | Rank | JP | Chakra | Needs | What it does |
|---|---|---|---|---|---|
| Ten-Finger Drilling Bullets | D | 6 | 50 | 5 Ninjutsu | Six bone bullets shot from the fingertips. |
| Dance of the Camellia | C | 12 | 100 | 12 Taijutsu | A lunge with a bone sword that pierces everything just in front. |
| Dance of the Willow | C | 12 | 100 | 12 Taijutsu | Dance of the Willow: bones burst out of the arms and shoulders and slash everything around the caster. |
| Dance of the Larch | B | 20 | 180 | 22 Ninjutsu | Dance of the Larch: spikes of bone jut out all over the body for eight seconds; whoever comes close is impaled. |
| Dance of the Clematis: Vine | B | 20 | 180 | 22 Ninjutsu | Dance of the Clematis: Vine: a whip of spine lashes out, wraps the first enemy in reach and drags them in. |
| Dance of the Clematis: Flower | A | 32 | 300 | 35 Ninjutsu | A great spiralling bone drill that bores through everything in its way. |
| Dance of the Seedling Fern | S | 50 | 500 | 50 Ninjutsu | A forest of bone spikes bursts from the ground all around the caster. |

### Dust Release

| Jutsu | Rank | JP | Chakra | Needs | What it does |
|---|---|---|---|---|---|
| Split Detachment of the Primitive World Technique | A | 32 | 300 | 35 Ninjutsu | Split Detachment of the Primitive World: five small cubes fanned out, each erasing what it touches. |
| Detachment of the Primitive World Technique | A | 32 | 300 | 35 Ninjutsu | A glowing cube that erases what it touches in a great white burst. |
| Detachment of the Primitive World Technique Area | S | 50 | 500 | 50 Ninjutsu | Detachment of the Primitive World Technique Area: a cube of dust swells over the whole area looked at and erases it. |

### Ice Release

| Jutsu | Rank | JP | Chakra | Needs | What it does |
|---|---|---|---|---|---|
| Certain-Kill Ice Spears | C | 12 | 100 | 12 Ninjutsu | Five spears of ice; each freezes what it hits. |
| Swallow Snow Storm | C | 12 | 100 | 12 Ninjutsu | Swallow Snow Storm: a flock of ice swallows darts out and hunts down enemies, freezing them. |
| Demonic Mirroring Ice Crystals | B | 20 | 180 | 22 Ninjutsu | Demonic Mirroring Ice Crystals: a dome of framed ice mirrors rises round the enemy looked at. Nobody inside gets out, and needles of ice fly from the mirrors into everyone trapped until the dome shatters. |
| Ice Rock Dome of Magnificent Nothingness | A | 32 | 300 | 35 Ninjutsu | Ice Rock Dome of Magnificent Nothingness: a dome of thick ice closes over the enemy looked at: nobody inside gets out, and they freeze slowly for six seconds. |
| Black Dragon Blizzard | A | 32 | 300 | 35 Ninjutsu | A black dragon of ice that freezes everything it passes. |

### Magnet Release

| Jutsu | Rank | JP | Chakra | Needs | What it does |
|---|---|---|---|---|---|
| Black Iron Fist | C | 12 | 100 | 12 Ninjutsu | A giant fist of iron sand punches forward. |
| Iron Sand Drizzle | B | 20 | 180 | 22 Ninjutsu | Iron sand rains down on the area the caster looks at for two seconds. |
| Iron Sand Wall | B | 20 | 180 | 22 Ninjutsu | Iron Sand Wall: iron sand sweeps up round the caster into a barrier for eight seconds that stops projectiles and blows. |
| Iron Sand Gathering Assault | B | 20 | 180 | 22 Ninjutsu | Iron Sand Gathering Assault: a great mass of iron sand shoots forward and bursts into spikes where it strikes. |
| Iron Sand: Black Iron Wings | A | 32 | 300 | 35 Ninjutsu | Iron Sand: Black Iron Wings: wings of iron sand for twenty seconds. They glide like an elytra (jump in mid-air to spread them) and beat to carry the caster along their look, like Butterfly Mode's. |
| Iron Sand World Method | S | 50 | 500 | 50 Ninjutsu | Iron Sand World Method: iron sand spreads out from the caster in a web of spikes in every direction ahead. |

### Smoke Release

| Jutsu | Rank | JP | Chakra | Needs | What it does |
|---|---|---|---|---|---|
| Dark Spike Bullet | C | 12 | 100 | 12 Ninjutsu | Smoke Release: Dark Spike Bullet: a spike of hardened smoke that bursts into a blinding cloud. |
| Vapor Blade | C | 12 | 100 | 12 Ninjutsu | Smoke Release: Vapor Blade: a wide blade of smoke sweeps the front, cutting and blinding. |
| Black Burst | B | 20 | 180 | 22 Ninjutsu | Smoke Release: Black Burst: a heavy fist of black smoke that sends enemies flying. |
| Erupting Smoke | B | 20 | 180 | 22 Ninjutsu | Smoke Release: Erupting Smoke: smoke erupts from the ground where the caster looks, throwing enemies up and choking them. |
| Demonic Illusion: Drowning in Smoke | A | 32 | 300 | 35 Ninjutsu | Demonic Illusion: Drowning in Smoke: the enemy looked at breathes in smoke and believes they are drowning in it. |
| Hiding with Smoke Technique | A | 32 | 300 | 35 Ninjutsu | Hiding with Smoke Technique: the caster's body turns to smoke for ten seconds: invisible, fast, and hard to hit. |

### Steel Release

| Jutsu | Rank | JP | Chakra | Needs | What it does |
|---|---|---|---|---|---|
| Steel Projectile | C | 12 | 100 | 12 Ninjutsu | A lance of steel that punches through two enemies. |
| Steel Blades Technique | B | 20 | 180 | 22 Taijutsu | Steel Blades Technique: the arms harden into blades of steel for twenty seconds; the first swing cuts everything in front. |
| Steel Shield Technique | B | 20 | 180 | 22 Ninjutsu | Steel Shield Technique: a wall of steel rises in front of the caster for eight seconds and stops everything thrown at it. |
| Impervious Armour | A | 32 | 300 | 35 Ninjutsu | Timed self buff shown by particles: resistance (and slowness for heavy armor). |

### Storm Release

| Jutsu | Rank | JP | Chakra | Needs | What it does |
|---|---|---|---|---|---|
| Laser Circus | B | 20 | 180 | 22 Ninjutsu | Six beams of storm light that bend towards enemies. |
| Black Hunting | B | 20 | 180 | 22 Ninjutsu | Storm Release: Black Hunting: dark storm light strikes down on every enemy round the spot looked at. |
| Thunder Cloud Inner Wave | A | 32 | 300 | 35 Ninjutsu | A thundercloud over the target that strikes enemies below it for five seconds. |

### Swift Release

| Jutsu | Rank | JP | Chakra | Needs | What it does |
|---|---|---|---|---|---|
| Shadowless Flight | A | 32 | 300 | 35 Ninjutsu | Moves faster than the eye can follow: a blur of dashes through enemies, then a burst of speed. |

### Typhoon Release

| Jutsu | Rank | JP | Chakra | Needs | What it does |
|---|---|---|---|---|---|
| Consecutive Bursting Strong Winds | B | 20 | 180 | 22 Ninjutsu | Three blasts of wind in quick succession, each a spiralling wave of air that hurls everything back. |
| Great Consecutive Bursting Extreme Winds | A | 32 | 300 | 35 Ninjutsu | A tornado where the caster looks, drifting the way they faced: a spinning funnel of wind and torn-up ground that sucks enemies in, lifts them and spins them for four seconds. |

### Wood Release

| Jutsu | Rank | JP | Chakra | Needs | What it does |
|---|---|---|---|---|---|
| Wood Spikes Ring | C | 12 | 100 | 12 Ninjutsu | Wood Release: Wood Spikes Ring: a ring of sharpened wooden stakes bursts out of the ground round the caster. |
| Tree Bind Flourishing Burial | B | 20 | 180 | 22 Ninjutsu | Tree Bind Flourishing Burial: roots spiral up out of the ground round each enemy near the spot looked at, close in and grow into a tree with them inside, holding and crushing them, then burst open. |
| Four-Pillar Prison Technique | A | 32 | 300 | 35 Ninjutsu | Wood Release: Four-Pillar Prison Technique: a cage of thick wooden bars grows up round the enemy looked at, trapping them. |
| Wood Dragon Technique | A | 32 | 300 | 35 Ninjutsu | A wooden dragon that rams through everything and crushes it. |
| Wood Human Technique | S | 50 | 500 | 50 Ninjutsu | The Wood Human: a giant wooden golem that fights for the caster for 40 seconds. |

## Clans

The Clan Paper rolls a clan; the clan scroll sells its jutsu. The Chinoike clan has no clan technique: its jutsu are on the Ketsuryugan scroll.

### Aburame Clan

| Jutsu | Rank | JP | Chakra | Needs | What it does |
|---|---|---|---|---|---|
| Parasitic Destruction Insect Technique | C | 12 | 100 | 12 Ninjutsu | A cloud of insects flies out (drawn to enemies) and swarms where it lands for five seconds. |
| Insect Clone Technique | C | 12 | 100 | 12 Ninjutsu | Insect Clone Technique: a double made of insects takes the caster's place while they vanish; when it breaks it swarms. |
| Insect Jar Technique | B | 20 | 180 | 22 Ninjutsu | Insects wall in the enemy being looked at (or the spot): trapped, slowed and drained for five seconds. |
| Secret Technique: Insect Bog | A | 32 | 300 | 35 Ninjutsu | A carpet of insects spreads forward over the ground, bogging down and eating everything on it. |
| Secret Technique: Insect Sphere | S | 50 | 500 | 50 Ninjutsu | Secret Technique: Insect Sphere: a great sphere of insects closes round the caster and everything near, eating at their chakra. |

### Akimichi Clan

| Jutsu | Rank | JP | Chakra | Needs | What it does |
|---|---|---|---|---|---|
| Partial Multi-Size Technique | D | 6 | 50 | 5 Ninjutsu | Partial Multi-Size Technique: one arm swells to giant size and swats everything in front away. |
| Multi-Size Technique | C | 12 | 100 | 12 Ninjutsu | Grows to a giant for twenty seconds: much stronger and tougher, a little slower. |
| Human Bullet Tank | B | 20 | 180 | 22 Ninjutsu | Swells into a rolling ball (spiked: bigger, faster, longer) that the caster steers, flattening whatever it runs over. |
| Super Open Hand Slap | B | 20 | 180 | 22 Taijutsu | Super Open Hand Slap: a giant open hand slaps down everything in front of the caster. |
| Spiked Human Bullet Tank | A | 32 | 300 | 35 Ninjutsu | Swells into a rolling ball (spiked: bigger, faster, longer) that the caster steers, flattening whatever it runs over. |
| Butterfly Mode | S | 50 | 500 | 50 Ninjutsu | Burns fat into chakra: glowing butterfly wings and thirty seconds of overwhelming strength. |
| Butterfly Bullet Bombing | S | 50 | 500 | 50 Taijutsu | Butterfly Bullet Bombing: in Butterfly Mode, the caster leaps and drives a fist of chakra into the ground below. |

### Fuma Clan

| Jutsu | Rank | JP | Chakra | Needs | What it does |
|---|---|---|---|---|---|
| Shuriken Barrage | D | 6 | 50 | 5 Ninjutsu | Five shuriken in a fan. |
| Fuma Shuriken | C | 12 | 100 | 12 Ninjutsu | A great windmill shuriken that cuts through everything on its way out, then comes back to the thrower. |
| Toroi's Magnetic Fuma Shuriken | B | 20 | 180 | 22 Ninjutsu | An iron shuriken steered by magnetism: it seeks its target and bursts into four smaller seeking blades. |

### Hozuki Clan

| Jutsu | Rank | JP | Chakra | Needs | What it does |
|---|---|---|---|---|---|
| Water Gun Technique | D | 6 | 50 | 5 Ninjutsu | A quick stream of water bullets flicked from the fingertip. |
| Water Gun: Two Guns | D | 6 | 50 | 5 Ninjutsu | Water Gun: Two Guns: water bullets fired from both hands in turn. |
| Hydrification Technique | C | 12 | 100 | 12 Ninjutsu | Until when each Hozuki's body is liquid (Hydrification). */ private static final Map LIQUID = new HashMap<>(); /** Hydrification Technique: for ten seconds the body turns to water: blows and weapons pass through it, jutsu do half. |
| Drowning Water Blob Technique | C | 12 | 100 | 12 Ninjutsu | A blob of water that swallows whoever it hits: trapped in a floating sphere, they slowly drown. |
| Great Water Arm Technique | B | 20 | 180 | 22 Ninjutsu | The arm swells with water into a giant fist that punches forward, still joined to the arm. |
| Tate Eboshi | A | 32 | 300 | 35 Ninjutsu | Water Release: Tate Eboshi: a towering wave rises where the caster looks and comes crashing down. |

### Hyuga Clan

| Jutsu | Rank | JP | Chakra | Needs | What it does |
|---|---|---|---|---|---|
| Gentle Fist | D | 6 | 50 | 5 Taijutsu | A palm strike that closes the chakra points: weakens, and drains an enemy ninja's chakra. |
| Gentle Step Twin Lion Fists | C | 12 | 100 | 12 Ninjutsu | Two roaring chakra lions leap from the palms at the enemy. |
| Eight Trigrams Twin Lions Crumbling Attack | B | 20 | 180 | 22 Ninjutsu | A rush through the enemies, ending in a crushing blast of the lions' chakra. |
| Gentle Fist Art One Blow Body | B | 20 | 180 | 22 Taijutsu | Gentle Fist Art One Blow Body: the caster hurls their whole body forward behind a palm full of chakra. |
| Eight Trigrams Palms Revolving Heaven | A | 32 | 300 | 35 Ninjutsu | Rotation: a spinning dome of chakra that throws back everything around and turns aside projectiles. |
| Eight Trigrams Sixty-Four Palms | S | 50 | 500 | 50 Taijutsu | Sixty-four palms at the chakra points of everyone in reach, holding them in place, then a final blow that throws them. |

### Inuzuka Clan

| Jutsu | Rank | JP | Chakra | Needs | What it does |
|---|---|---|---|---|---|
| Akamaru | D | 6 | 50 | 5 Summoning | The caster's Akamaru within range, if any. */ private static AkamaruEntity.@Nullable CustomEntity akamaruOf(ServerPlayer p, double range) { return level(p).getEntitiesOfClass(AkamaruEntity.CustomEntity.class, p.getBoundingBox().inflate(range), d -> d.isOwnedBy(p)).stream().findFirst() .orElse(null); } /** Akamaru to the caster's side: called over (and healed) if he is around, otherwise summoned. He stays, like a tamed wolf. |
| Four Legs Technique | D | 6 | 50 | 5 Taijutsu | Beast Mimicry: down on all fours, fast and savage, for thirty seconds (Akamaru, if near, too). |
| Dynamic Marking | D | 6 | 50 | 5 Ninjutsu | Akamaru marks an enemy with his scent: it glows for a minute, he goes for it, and the fangs find it. |
| Passing Fang | C | 12 | 100 | 12 Taijutsu | Spins into a grey drill and tears through everything in a line (at the marked enemy, if there is one). |
| Beast Human Clone | C | 12 | 100 | 12 Ninjutsu | Akamaru turns into his partner's double for thirty seconds and fights at full strength. |
| Fang Passing Fang | B | 20 | 180 | 22 Taijutsu | Partner and Akamaru both spin into fangs and hit the enemy again and again from both sides. |
| Fang Rotating Fang | A | 32 | 300 | 35 Taijutsu | Fang Rotating Fang: partner and Akamaru roll into buzz-saws and circle the enemy, tearing at it from every side. |

### Lee Clan

| Jutsu | Rank | JP | Chakra | Needs | What it does |
|---|---|---|---|---|---|
| Drunken Fist | D | 6 | 50 | 5 Taijutsu | Twenty seconds of the Drunken Fist: staggering out of the way and lashing out at anything that comes close. |
| Gate of Opening | D | 6 | 50 | 5 Taijutsu | Opens the Eight Gates up to the given one: more speed and strength with each gate, a heavier toll on the body from the third, and from the fifth a technique on opening. After the Gate of Death the body is left spent. |
| Gate of Healing | D | 6 | 50 | 5 Taijutsu | Opens the Eight Gates up to the given one: more speed and strength with each gate, a heavier toll on the body from the third, and from the fifth a technique on opening. After the Gate of Death the body is left spent. |
| Gate of Life | C | 12 | 100 | 12 Taijutsu | Opens the Eight Gates up to the given one: more speed and strength with each gate, a heavier toll on the body from the third, and from the fifth a technique on opening. After the Gate of Death the body is left spent. |
| Gate of Pain | C | 12 | 100 | 12 Taijutsu | Opens the Eight Gates up to the given one: more speed and strength with each gate, a heavier toll on the body from the third, and from the fifth a technique on opening. After the Gate of Death the body is left spent. |
| Gate of Limit: Hidden Lotus | B | 20 | 180 | 22 Taijutsu | Opens the Eight Gates up to the given one: more speed and strength with each gate, a heavier toll on the body from the third, and from the fifth a technique on opening. After the Gate of Death the body is left spent. |
| Gate of View: Morning Peacock | B | 20 | 180 | 22 Taijutsu | Opens the Eight Gates up to the given one: more speed and strength with each gate, a heavier toll on the body from the third, and from the fifth a technique on opening. After the Gate of Death the body is left spent. |
| Gate of Wonder: Daytime Tiger | A | 32 | 300 | 35 Taijutsu | Opens the Eight Gates up to the given one: more speed and strength with each gate, a heavier toll on the body from the third, and from the fifth a technique on opening. After the Gate of Death the body is left spent. |
| Gate of Death: Night Guy | S | 50 | 500 | 50 Taijutsu | Opens the Eight Gates up to the given one: more speed and strength with each gate, a heavier toll on the body from the third, and from the fifth a technique on opening. After the Gate of Death the body is left spent. |

### Nara Clan

| Jutsu | Rank | JP | Chakra | Needs | What it does |
|---|---|---|---|---|---|
| Shadow Imitation Shuriken Technique | D | 6 | 50 | 5 Ninjutsu | A shuriken thrown along the caster's shadow: whoever it hits is pinned where they stand for three seconds. |
| Shadow Imitation Technique | C | 12 | 100 | 12 Ninjutsu | The shadow creeps to the enemy being looked at and catches it: for ten seconds it copies every move the caster makes. |
| Shadow Gathering Technique | B | 20 | 180 | 22 Ninjutsu | The shadows of everything around are drawn into the caster's own: for thirty seconds it reaches twice as far and creeps faster. |
| Shadow–Neck Binding Technique | B | 20 | 180 | 22 Ninjutsu | Shadow Imitation, then hands of shadow climb the caught enemy's body and choke them for six seconds. |
| Shadow Sewing Technique | A | 32 | 300 | 35 Ninjutsu | Shadows creep out to up to five enemies nearby; where one reaches, spikes of shadow burst out of the ground all round it and run it through, pinning it for four seconds. |
| Shadow Imitation Field Technique | S | 50 | 500 | 50 Ninjutsu | Shadow Imitation Field: the caster's shadow spreads into a great pool on the ground around them (it stays where it spread), and everyone it reaches is caught fast for eight seconds, unable to move or do anything, while the caster walks free. |

### Sarutobi Clan

| Jutsu | Rank | JP | Chakra | Needs | What it does |
|---|---|---|---|---|---|
| Ash Pile Burning | C | 12 | 100 | 12 Ninjutsu | Breathes a cloud of hot ash that blinds, then ignites it with a click of the teeth. |
| Great Flame Technique | B | 20 | 180 | 22 Ninjutsu | Breathes a stream of fire for two seconds. |
| Fire Dragon Flame Bullet | A | 32 | 300 | 35 Ninjutsu | A fire dragon that spits fireballs at enemies near its path. |

### Uzumaki Clan

| Jutsu | Rank | JP | Chakra | Needs | What it does |
|---|---|---|---|---|---|
| Adamantine Sealing Chains | C | 12 | 100 | 12 Ninjutsu | Golden chakra chains shoot from the back, seek enemies and bind them in place for four seconds. |
| Heal Bite | B | 20 | 180 | 22 Ninjutsu | Heal Bite: the ally looked at (a player or the caster's own creature; the caster if no one) bites the caster and draws their chakra, healing even deadly wounds and restoring their stamina. It drains the caster hard: a third of their chakra on top of the jutsu's price, and what is missing comes out of their own health. |
| Four Symbols Seal | B | 20 | 180 | 22 Ninjutsu | Four Symbols Seal: a seal pressed on the enemy looked at locks their chakra away for twenty seconds. |
| Uzumaki Sealing Technique | A | 32 | 300 | 35 Ninjutsu | Uzumaki Sealing Technique: seal script wraps the enemy looked at; a weakened enemy is sealed away completely. |
| Dead Demon Consuming Seal | S | 50 | 500 | 50 Ninjutsu | Dead Demon Consuming Seal. The caster's soul is drawn half out and the Shinigami appears behind them; its arm reaches through them and grabs the soul of the enemy close in front, who is held fast, stripped of their jutsu and then sealed away. A soul too strong to pull out whole loses its arms instead (it can barely fight for a minute). Either way the Shinigami then consumes the caster's own soul: they have ten seconds left. |

### Tsuchigumo Clan

| Jutsu | Rank | JP | Chakra | Needs | What it does |
|---|---|---|---|---|---|
| Creation of Heaven and Earth | A | 32 | 300 | 35 Ninjutsu | Until when each Tsuchigumo's Fury is fed by natural energy (Creation of Heaven and Earth). */ private static final Map CREATION = new HashMap<>(); /** Creation of Heaven and Earth: the seal on Fury is released and natural energy gathers from the earth and air: for a minute the next Fury is far larger. |
| Fury | S | 50 | 500 | 50 Ninjutsu | The clan's forbidden technique: a ball of chakra swells where the caster looks and explodes like a small sun. |

### Uchiha Clan

| Jutsu | Rank | JP | Chakra | Needs | What it does |
|---|---|---|---|---|---|
| Manipulating Windmill Triple Blades | D | 6 | 50 | 5 Ninjutsu | Manipulating Windmill Triple Blades: three windmill shuriken on wires curve round the enemy and bind them. |
| Uchiha Return | C | 12 | 100 | 12 Ninjutsu | Uchiha Return: the war fan sweeps before the caster for a second and a half and sends every projectile back to its thrower. |
| Uchiha Flame Formation | A | 32 | 300 | 35 Ninjutsu | Uchiha Flame Formation: a ring of fire rises round the caster for ten seconds that burns up projectiles and drives enemies back. |
| Great Fire Destruction | S | 50 | 500 | 50 Ninjutsu | Great Fire Destruction: a vast sheet of fire spreads out in front of the caster, as wide as a battlefield. |

### Yamanaka Clan

| Jutsu | Rank | JP | Chakra | Needs | What it does |
|---|---|---|---|---|---|
| Mind Body Transmission Technique | D | 6 | 50 | 5 Ninjutsu | Mind Body Transmission Technique: the caster's mind reaches out to everything alive nearby; for fifteen seconds all of it glows. |
| Mind Body Switch Technique | C | 12 | 100 | 12 Ninjutsu | Mind Body Switch Technique: the caster's mind jumps into the creature looked at and controls it for fifteen seconds (see #takeOver); a player's body is taken and held helpless for five. |
| Mind Body Disturbance Technique | B | 20 | 180 | 22 Ninjutsu | Mind Body Disturbance Technique: the enemy's nerves are thrown into confusion for six seconds: they stagger and lash out blindly. |
| Mind Body Transmission Formation | A | 32 | 300 | 35 Ninjutsu | Mind Body Transmission Formation: the caster links the minds of every ally nearby for thirty seconds: they move and strike as one (faster and stronger), and every enemy around is laid bare. |
| Mind Clone Switch Technique | S | 50 | 500 | 50 Ninjutsu | Mind Clone Switch Technique: the caster's mind splits into up to five enemies in front and takes them all over for ten seconds. |

## Dojutsu (eyes)

Eyes awaken through the game (or the cheat menu). **V** opens an eye (tap), steps up to the Mangekyou, sneak + V closes everything; hold V for the eye wheel. Each eye's jutsu need that eye open.

### Sharingan

| Jutsu | Rank | JP | Chakra | Needs | What it does |
|---|---|---|---|---|---|
| Genjutsu: Sharingan | D | 6 | 50 | 5 Ninjutsu | The Susanoo stages in order, and the rank that prices each (the scrolls sell the first three or all four). */ private static final String[] SUSANOO_STAGES = { "Ribcage", "Skeleton", "Armoured", "Complete" }; private static final JutsuRank[] SUSANOO_RANKS = { JutsuRank.C, JutsuRank.B, JutsuRank.A, JutsuRank.S }; /** A scroll's Susanoo stages. They are counted in the eye's old stage variables (the bought count and the stage the Susanoo key grows to), which are kept as they were so saves carry over. / private record Susanoo(Jutsus.Track track, ObjDoubleConsumer setBought, ObjDoubleConsumer setLearned) { void buy(ServerPlayer player, PlayerVariables v) { int next = track.owned(v); if (next >= track.tiers().size() // v.jp { vars.jp -= track.tiers().get(next).cost(); setBought.accept(vars, next + 1); setLearned.accept(vars, next + 1); vars.syncPlayerVariables(player); }); } } private static Susanoo susanoo(ToDoubleFunction bought, ObjDoubleConsumer setBought, ToDoubleFunction learned, ObjDoubleConsumer setLearned, int stages) { Jutsus.Tier[] tiers = new Jutsus.Tier[stages]; for (int i = 0; i < stages; i++) tiers[i] = Jutsus.named(SUSANOO_RANKS[i].jp, i + 1, SUSANOO_STAGES[i]); return new Susanoo(Jutsus.track("Susanoo", bought, 1, null, learned, tiers), setBought, setLearned); } // ------------------------------------------------------------------ sharingan (added from the wiki) /** Genjutsu: Sharingan: one look and the enemy's senses are thrown off for five seconds: they reel and strike at anything. |
| Coercion Sharingan | C | 12 | 100 | 12 Ninjutsu | One look paralyses: the enemy stands frozen for three seconds, the tomoe spinning in front of their eyes. |
| Demonic Illusion: Mirage Crow | B | 20 | 180 | 22 Ninjutsu | A murder of crows bursts from the caster and swarms the enemy, blinding and pecking for four seconds. |
| Demonic Illusion: Shackling Stakes Technique | A | 32 | 300 | 35 Ninjutsu | Illusory stakes drive down into the enemy and pin them to the spot for five seconds. |
| Izanagi | S | 50 | 500 | 50 Ninjutsu | Until when each caster's reality is being rewritten (Izanagi). */ private static final Map IZANAGI = new HashMap<>(); /** Izanagi: for ten seconds the caster rewrites reality: every wound they take is undone as if it never happened. When it ends, the eye that cast it goes dark: the Sharingan closes. |
| Izanami | S | 50 | 500 | 50 Ninjutsu | Izanami: the enemy looked at is caught in a loop. For eight seconds they live the same moment again and again: every two seconds they are sent back to the place and facing they had when the caster's eye met theirs, forget what they were doing, and (a player) can do nothing in between. Like Izanagi, it costs the eye: the Sharingan closes when the loop ends. |

### Kokugan

| Jutsu | Rank | JP | Chakra | Needs | What it does |
|---|---|---|---|---|---|
| Sukunahikona | B | 20 | 180 | 22 Ninjutsu | Sukunahikona: the caster shrinks to a speck for three seconds; attacks miss them and enemies lose sight of them. |
| Sukunahikona: Rapid Succession | B | 20 | 180 | 22 Ninjutsu | Sukunahikona: Rapid Succession: shrunken rods flicked out that snap to full size in flight. |
| Lacquer Bloom | A | 32 | 300 | 35 Ninjutsu | Lacquer Bloom: shrunken rods under the enemy burst to full size, impaling and pinning them for three seconds. |
| Black Holy Hammer | A | 32 | 300 | 35 Ninjutsu | Black Holy Hammer: one enormous rod drops from above and nails the enemy to the ground. |
| Daihakoten | A | 32 | 300 | 35 Ninjutsu | Daikokuten: Daihakoten: a huge black cube, taken out of a dimension where time does not flow, drops onto the enemy. |
| Daikokuten: Falling Star | S | 50 | 500 | 50 Ninjutsu | Daikokuten: Falling Star: a rain of cubes over the area looked at. |

### Byakugan

| Jutsu | Rank | JP | Chakra | Needs | What it does |
|---|---|---|---|---|---|
| Palm Bottom | D | 6 | 50 | 5 Taijutsu | Palm Bottom: a sharp palm strike that knocks the enemy back. |
| Eight Trigrams Vacuum Palm | C | 12 | 100 | 12 Ninjutsu | Eight Trigrams Vacuum Palm: a blast of chakra from the palm strikes an enemy from afar. |
| Eight Trigrams Vacuum Wall Palm | B | 20 | 180 | 22 Ninjutsu | Eight Trigrams Vacuum Wall Palm: a wall of chakra pressure hurled from both palms that flattens everything in front. |
| Rabbit Hair Needle | A | 32 | 300 | 35 Ninjutsu | Rabbit Hair Needle: a volley of chakra-hardened needles that seek out enemies. |
| Eight Trigrams One Hundred Twenty-Eight Palms | S | 50 | 500 | 50 Taijutsu | Eight Trigrams One Hundred Twenty-Eight Palms: twice the sixty-four, faster, with a final blow that sends everyone flying. |

### Ketsuryugan

| Jutsu | Rank | JP | Chakra | Needs | What it does |
|---|---|---|---|---|---|
| Genjutsu: Ketsuryugan | C | 12 | 100 | 12 Ninjutsu | Genjutsu: Ketsuryugan: the blood-red eyes hypnotise the enemy looked at for six seconds: they stand still, their will gone. |
| Blood Transformation Technique | B | 20 | 180 | 22 Ninjutsu | Until when each caster's body is blood (Blood Transformation). */ private static final Map BLOOD_FORM = new HashMap<>(); /** Blood Transformation Technique: the body dissolves into blood for three seconds: nothing can hurt it and it moves like a flood. |
| Blood Dragon Ascension | A | 32 | 300 | 35 Ninjutsu | Blood Dragon Ascension: a dragon of blood surges out and tears through everything in its path. |
| Exploding Human Technique | S | 50 | 500 | 50 Ninjutsu | Exploding Human Technique: the caster's chakra seeps into the enemy's blood; for three seconds it boils, then the enemy bursts, hurting everyone around them too. |

### Rinnegan

| Jutsu | Rank | JP | Chakra | Needs | What it does |
|---|---|---|---|---|---|
| Bansho Ten'in | C | 12 | 100 | 12 Ninjutsu | Banshō Ten'in: the enemy looked at is pulled through the air straight to the caster. |
| Shinra Tensei | B | 20 | 180 | 22 Ninjutsu | Shinra Tensei: a repulsive force bursts out of the caster and flings everything around away, turning projectiles aside. |
| Asura Attack | B | 20 | 180 | 22 Ninjutsu | Asura Attack: the arm splits open and fires a volley of missiles that seek enemies and explode. |
| Blocking Technique Absorption Seal | B | 20 | 180 | 22 Ninjutsu | Blocking Technique Absorption Seal: for eight seconds every jutsu that reaches the caster is drunk in as chakra. |
| Human Path | A | 32 | 300 | 35 Ninjutsu | Human Path: the caster grips the enemy and pulls their soul out of their body. |
| Amenotejikara | A | 32 | 300 | 35 Ninjutsu | Amenotejikara: the caster and the one looked at instantly swap places. |
| Chibaku Tensei | S | 50 | 500 | 50 Ninjutsu | Chibaku Tensei: a black core rises above the spot looked at and drags every enemy around up into it, crushing them. |
| Tengai Shinsei | S | 50 | 500 | 50 Ninjutsu | Tengai Shinsei: a huge meteorite falls out of the sky onto the spot looked at. |

### Tenseigan

| Jutsu | Rank | JP | Chakra | Needs | What it does |
|---|---|---|---|---|---|
| Silver Wheel Reincarnation Explosion | B | 20 | 180 | 22 Ninjutsu | Silver Wheel Reincarnation Explosion: spheres of chakra fly out and blow apart where they hit. |
| Golden Wheel Reincarnation Explosion | A | 32 | 300 | 35 Ninjutsu | Golden Wheel Reincarnation Explosion: gravity draws everything round the spot looked at into one point, then it explodes. |
| Localised Reincarnation Explosion | A | 32 | 300 | 35 Ninjutsu | Localised Reincarnation Explosion: a burst of repelling force round the caster that blasts every enemy near away. |
| Tenseigan Chakra Mode | S | 50 | 500 | 50 Ninjutsu | Tenseigan Chakra Mode: thirty seconds cloaked in blazing chakra: flight, great strength and speed, and truth-seeking balls circling the caster. |

## Mangekyou Sharingan

Six Mangekyou, one kept at a time (a new one replaces the old). Their jutsu need the Mangekyou active. Each scroll also sells the **Susanoo** stages (hold **B** to grow it, tap to dismiss): Ribcage (C, 12 JP), Skeleton (B, 20 JP), Armoured (A, 32 JP), Complete (S, 50 JP). Itachi's and Obito's scrolls sell the first three; Kakashi has no Susanoo.

### Itachi's Mangekyou

| Jutsu | Rank | JP | Chakra | Needs | What it does |
|---|---|---|---|---|---|
| Amaterasu | A | 32 | 300 | 35 Ninjutsu | Amaterasu: the one looked at bursts into black flame (or the spot looked at, if no one). |
| Tsukuyomi | S | 50 | 500 | 50 Ninjutsu | Tsukuyomi: the enemy is pulled into Itachi's world of illusion and tortured there; outside, they stand broken for five seconds. |

### Kakashi's Mangekyou

| Jutsu | Rank | JP | Chakra | Needs | What it does |
|---|---|---|---|---|---|
| Kamui Long-Range | A | 32 | 300 | 35 Ninjutsu | Kamui: space twists round the one looked at and swallows them into the Kamui dimension. Players come back after fifteen seconds; bosses are too big to take and are torn at instead. |
| Kamui Lightning Cutter | A | 32 | 300 | 35 Ninjutsu | Kamui Lightning Cutter: a Lightning Cutter driven through the enemy with Kamui wrapped round it, tearing space where it strikes. |
| Kamui Shuriken | S | 50 | 500 | 50 Ninjutsu | Kamui Shuriken: the Susanoo's great shuriken, each warping away whatever it cuts. |

### Shisui's Mangekyou

| Jutsu | Rank | JP | Chakra | Needs | What it does |
|---|---|---|---|---|---|
| Kotoamatsukami | S | 50 | 500 | 50 Ninjutsu | Takes over a creature's will for a while: it fights the caster's enemies and never the caster. A player is held still with their blows against the caster turned aside. / private static final Map CONTROLLED = new HashMap<>(); private static void control(ServerPlayer p, LivingEntity target, int ticks, Element element) { ServerLevel level = level(p); CONTROLLED.put(target.getUUID(), p.getUUID()); channel(p, ticks, 1, t -> { if (!target.isAlive()) return; if (t % 8 == 0) level.sendParticles(element.trail, target.getX(), target.getEyeY() + 0.4, target.getZ(), 3, 0.3, 0.1, 0.3, 0); if (target instanceof Mob mob) { LivingEntity prey = mob.getTarget(); if (prey == null // !prey.isAlive() // prey == p // !Techniques.isEnemy(p, prey)) mob.setTarget(level.getEntitiesOfClass(LivingEntity.class, mob.getBoundingBox().inflate(20), x -> x != mob && x != p && x.isAlive() && Techniques.isEnemy(p, x) && !(x instanceof net.minecraft.world.entity.decoration.ArmorStand)) .stream().min((a, b) -> Double.compare(a.distanceToSqr(mob), b.distanceToSqr(mob))).orElse(null)); } else if (t CONTROLLED.remove(target.getUUID(), p.getUUID())); } @SubscribeEvent public static void controlledBlow(LivingIncomingDamageEvent event) { net.minecraft.world.entity.Entity attacker = event.getSource().getEntity(); if (attacker != null && event.getEntity().getUUID().equals(CONTROLLED.get(attacker.getUUID()))) event.setCanceled(true); } /** Kotoamatsukami: Shisui's genjutsu rewrites the enemy's will so perfectly they never know: for a minute they fight for the caster. |

### Madara's Mangekyou

| Jutsu | Rank | JP | Chakra | Needs | What it does |
|---|---|---|---|---|---|
| Genjutsu: Sharingan | A | 32 | 300 | 35 Ninjutsu | Genjutsu: Sharingan: Madara's eyes bend even a great beast to his will; for forty seconds it fights for him. |
| Susanoo: Fist | S | 50 | 500 | 50 Ninjutsu | Susanoo: Fist: a giant fist of the Susanoo's chakra smashes forward through everything in its way. |

### Obito's Mangekyou

| Jutsu | Rank | JP | Chakra | Needs | What it does |
|---|---|---|---|---|---|
| Kamui Self-Teleportation | B | 20 | 180 | 22 Ninjutsu | Kamui to the caster's own dimension, or back to where they left from. |
| Kamui Short-Range | A | 32 | 300 | 35 Ninjutsu | Kamui: space twists round the one looked at and swallows them into the Kamui dimension. Players come back after fifteen seconds; bosses are too big to take and are torn at instead. |
| Kamui Phantom Phasing | A | 32 | 300 | 35 Ninjutsu | Five seconds partly in the Kamui dimension: attacks and projectiles pass through, enemies lose track of the caster, and the caster walks through walls (see #phaseThroughWalls). |

### Sasuke's Mangekyou

| Jutsu | Rank | JP | Chakra | Needs | What it does |
|---|---|---|---|---|---|
| Amaterasu | A | 32 | 300 | 35 Ninjutsu | Amaterasu: the one looked at bursts into black flame (or the spot looked at, if no one). |
| Blaze Release: Kagutsuchi | A | 32 | 300 | 35 Ninjutsu | Blaze Release: Kagutsuchi: the black flames shaped into a blade that sweeps in front of the caster. |
| Blaze Release: Honoikazuchi | S | 50 | 500 | 50 Ninjutsu | Blaze Release: Honoikazuchi: three arrows of black flame that seek, pierce and spread fire where they land. |
| Amaterasu: Flame Wrapping Fire | S | 50 | 500 | 50 Ninjutsu | Amaterasu: Flame Wrapping Fire: black flames wrap the caster for twenty seconds, burning whoever comes close. |

## Other techniques

### Flying Raijin (on the Flying Raijin Kunai)

Needs Shurikenjutsu 25 (Level Two: 35). Always learned once you have the kunai.

- Throw Marked Kunai
- Write Formula
- Marking Strike
- Flying Raijin
- Flying Raijin: Level Two
- Release Formulas

### Shadow Clone Technique

An item of its own. Each cast makes a clone that fights with you for 60 s (25 chakra). The clone limit grows with Ninjutsu: 1 + Ninjutsu/15, at most 8. Sneak + right-click releases them. Clones use your skin.

## Custom jutsu

On the **Jutsu** page of the info card (key **I**): 4 slots. A design is a name, one of your releases (you need at least one jutsu learned from it), a form, a size, a speed and a power (1-5). Its rank comes from those and sets the price (rank JP x1.5 + 10), chakra, cooldown and Ninjutsu needed. It then appears on that release's wheel after its own jutsu. Forgetting one refunds half its JP.

| Form | What it does |
|---|---|
| Bullets | Three quick bullets |
| Sphere | A great ball that bursts |
| Shuriken | A spinning blade that cuts through |
| Beast | A beast that hunts the enemy |
| Dragon | A dragon that rams through everything |
| Wave | A wide wave rolling forward |
| Stream | A stream breathed out for two seconds |
| Burst | A blast all around the caster |
| Rain | A rain of bullets where you look |

## Weapons and their arts

Weapons with arts work like techniques: X opens the wheel, right-click uses the art. Art damage grows with **Kenjutsu**; with too little Kenjutsu, melee hits do half damage.

### White Light Chakra Sabre (Kenjutsu 10)

| Art | Rank | Kenjutsu | What it does |
|---|---|---|---|
| White Light Blade | C | 10 | Chakra flows through the blade for a while: stronger hits. |
| White Light Streak | B | 20 | A long white streak of light released by the swing, cutting through everything in a line. |

### Asuma Chakra Blade (Kenjutsu 20)

| Art | Rank | Kenjutsu | What it does |
|---|---|---|---|
| Flying Swallow | C | 20 | Flying Swallow: wind chakra lengthens the blades into invisible edges. Stronger with a blade in each hand. |
| Wind Blade Slash | B | 25 | A crescent of wind cut from the blades flies forward through every enemy in its way. |
| Burning Ash | A | 30 | Burning Ash: a cloud of chakra-laden ash is breathed out, then a click of the teeth sets it all ablaze (needs Fire). |

### Sword of Kusanagi (Kenjutsu 25)

| Art | Rank | Kenjutsu | What it does |
|---|---|---|---|
| Chidori Katana | C | 25 | Chakra flows through the blade for a while: stronger hits. |
| Chidori Sharp Spear | B | 30 | Chidori Sharp Spear: the lightning on the blade shoots out into a long spear, running through everything in a line. |
| Chidori Current | A | 35 | Chidori Current: the sword is driven into the ground and lightning runs out through it, shocking and numbing everything around. |

### Gunbai (Kenjutsu 25)

| Art | Rank | Kenjutsu | What it does |
|---|---|---|---|
| Gunbai Fanned Wind | C | 25 | Gunbai Fanned Wind: a swing of the fan blows a gale that throws everything in front far back and blows projectiles away. |
| Uchiha Return | B | 30 | An Uchiha Return guard: until the time runs out, what hits from the front is taken into the fan. */ private record Guard(long until, float[] stored) { } private static final Map GUARDS = new HashMap<>(); /** Uchiha Return: for four seconds the fan takes every attack from the front (projectiles are sent back), then releases all of it at once as a blast of wind. |

### Triple-Blade Scythe (Kenjutsu 30)

| Art | Rank | Kenjutsu | What it does |
|---|---|---|---|
| Scythe Throw | C | 30 | Who each wielder has drawn blood from, and until when that blood is fresh. */ private record Blood(UUID target, long until) { } private static final Map BLOOD = new HashMap<>(); private static void drawBlood(ServerPlayer p, LivingEntity target) { BLOOD.put(p.getUUID(), new Blood(target.getUUID(), now(p) + 600)); level(p).sendParticles(Element.BLOOD.trail, target.getX(), target.getY(0.6), target.getZ(), 10, 0.2, 0.3, 0.2, 0.05); } /** Scythe Throw: the scythe flies out on its cable, cutting everything in the way and drawing blood, then is reeled back. |
| Jashin Ritual | A | 40 | Jashin Ritual: with fresh blood of an enemy, the wielder draws Jashin's circle under their feet. For 20 seconds, while they stand in it, every wound they take is dealt to that enemy too. |

### Shichiseiken (Kenjutsu 35)

| Art | Rank | Kenjutsu | What it does |
|---|---|---|---|
| Word Soul Curse | B | 35 | Word Soul Curse: a cut of the Shichiseiken takes hold of the enemy's word soul for thirty seconds (they glow). |
| Benihisago Seal | S | 45 | Benihisago Seal: the cursed enemy's soul is drawn towards the sword: they are dragged in and held while it is torn from them. Costs enormous chakra, as the Sage's tools do. |

### Samehada (Kenjutsu 45)

| Art | Rank | Kenjutsu | What it does |
|---|---|---|---|
| Chakra Feast | C | 45 | Chakra Feast: Samehada gives back the chakra it has eaten as healing. |
| Shark Skin Spikes | B | 45 | Shark Skin Spikes: the scales jut out into spikes, shredding everything around and eating their chakra. |
| Water Prison Shark Dance | S | 55 | Water Prison Shark Dance: a great dome of water rises around the wielder for ten seconds. Inside, enemies are slowed and drown while sharks hunt them; the wielder breathes and moves freely. |

### Kubikiribocho (Kenjutsu 45)

| Art | Rank | Kenjutsu | What it does |
|---|---|---|---|
| Flying Revolving Sword | B | 45 | Flying Revolving Sword: the great cleaver is thrown spinning, cuts through everything in its path and comes back. |
| Decapitating Slash | A | 50 | Decapitating Slash: a leap at the enemy looked at and one great downward cleave. |
| Hidden Mist Technique | C | 45 | Hidden Mist Technique: a thick mist spreads around the wielder for fifteen seconds; enemies in it can't see, the wielder can't be seen. |

### Hiramekarei (Kenjutsu 45)

| Art | Rank | Kenjutsu | What it does |
|---|---|---|---|
| Unleashing: Long-sword | C | 45 | Hiramekarei changes form. |
| Unleashing: Hammer | B | 50 | Hiramekarei changes form. |
| Twinsword | C | 45 | Hiramekarei changes form. |
| Fishbone Crystals | B | 50 | Fishbone Crystals: a spray of light blue crystal bones that pierce and pin whoever they hit. |

### Kabutowari (Kenjutsu 45)

| Art | Rank | Kenjutsu | What it does |
|---|---|---|---|
| First Axe Strike | B | 45 | First Axe Strike: a rush at the enemy looked at and an axe blow that splits any guard (a raised shield is knocked aside). |
| Bluntsword: Spin Strike | B | 45 | Bluntsword: Spin Strike: axe and hammer whirl round on their cord for two seconds, battering everything close and pulling it in. |
| Iron Hammer of Kirigakure | A | 50 | Iron Hammer of Kirigakure: a leap and the hammer brought down with all its weight: a shockwave throws everything around up. |

### Kiba Sword (Kenjutsu 45)

| Art | Rank | Kenjutsu | What it does |
|---|---|---|---|
| Thunderswords: Lightning Flow | C | 45 | Lightning jumps from the struck enemy to the nearest other one. |
| Thunderswords Technique: Remote Control | B | 50 | Thunderswords Technique: Remote Control: lightning leaves the blades and snakes along the ground to the enemy, then jumps on. |
| Thunderswords Technique: Thunderbolt | A | 55 | Thunderswords Technique: Thunderbolt: the blades call lightning out of the sky onto where the wielder points, three times. |

### Nuibari (Kenjutsu 45)

| Art | Rank | Kenjutsu | What it does |
|---|---|---|---|
| Thread Pull | C | 45 | Thread Pull: Nuibari's wire catches the enemy looked at and drags them onto the blade. |
| Earth Spider Sewing | A | 50 | Longsword Ninja Art — Earth Spider Sewing: Nuibari is thrown through every enemy in a line; its thread stitches them together and pulls them into one knot, held for three seconds. |
| Nuibari: Fall | B | 50 | Nuibari: Fall: a leap over the enemy looked at and a plunge straight down through them, pinning them for two seconds. |

### Shibuki (Kenjutsu 45)

| Art | Rank | Kenjutsu | What it does |
|---|---|---|---|
| Blastsword: Consecutive Slashes | B | 45 | A paper tag on the struck enemy goes off (the wielder is braced against it). |
| Blastsword: Earth Rupture | A | 50 | Blastsword: Earth Rupture: the blade is slammed into the ground and a line of blasts tears forward through the earth. |
| Blasting Bridle Repeating Death | S | 55 | Blastsword Technique: Blasting Bridle Repeating Death: the scroll of tags unrolls all around and they go off one after another in widening rings. |

Passives: Samehada eats the chakra of what it hits; Kubikiribocho mends itself on hits and kills; the Triple-Bladed Scythe draws blood for the Jashin ritual.

## Items

### In the creative tabs

**Nature Releases** (10): Fire Release, Fire Release Technique, Water Release, Water Release Technique, Wind Release, Wind Release Technique, Earth Release, Earth Release Technique, Lightning Release, Lightning Release Technique

**Kekkei Genkai** (22): Boil Release, Boil Release Technique, Bone Release, Bone Release Technique, Dust Release, Dust Release Technique, Ice Release, Ice Release Technique, Magnet Release, Magnet Release Technique, Smoke Release, Smoke Release Technique, Steel Release, Steel Release Technique, Storm Release, Storm Release Technique, Swift Release, Swift Release Technique, Typhoon Release, Typhoon Release Technique, Wood Release, Wood Release Technique

**DNA** (18): Fire DNA, Water DNA, Wind DNA, Earth DNA, Lightning DNA, Boil DNA, Bone DNA, Dust DNA, Ice DNA, Magnet DNA, Smoke DNA, Steel DNA, Storm DNA, Swift DNA, Typhoon DNA, Wood DNA, Undefined DNA, Chakra Nature Reset

**Clans** (29): Clan Paper, Clan Reset, Uchiha Release, Uchiha Release Technique, Uzumaki Release, Uzumaki Release Technique, Hyuga Release, Hyuga Release Technique, Aburame Release, Aburame Release Technique, Akimichi Release, Akimichi Release Technique, Nara Release, Nara Release Technique, Yamanaka Release, Yamanaka Release Technique, Inuzuka Release, Inuzuka Release Technique, Lee Release, Lee Release Technique, Sarutobi Release, Sarutobi Release Technique, Hozuki Release, Hozuki Release Technique, Fuma Release, Fuma Release Technique, Tsuchigumo Release, Tsuchigumo Release Technique, Chinoike Release

**Dojutsu** (24): Sharingan Release, Sharingan Release Technique, Byakugan Release, Byakugan Release Technique, Ketsuryugan Release, Ketsuryugan Release Technique, Rinnegan Release, Rinnegan Release Technique, Tenseigan Release, Tenseigan Release Technique, Kokugan Release, Kokugan Release Technique, Itachi Mangekyou Sharingan Release, Itachi Mangekyou Sharingan Release Technique, Sasuke Mangekyou Sharingan Release, Sasuke Mangekyou Sharingan Release Technique, Obito Mangekyou Sharingan Release, Obito Mangekyou Sharingan Release Technique, Kakashi Mangekyou Sharingan Release, Kakashi Mangekyou Sharingan Release Technique, Shisui Mangekyou Sharingan Release, Shisui Mangekyou Sharingan Release Technique, Madara Mangekyou Sharingan Release, Madara Mangekyou Sharingan Release Technique

**Shinobi Weapons** (22): Kunai, Shuriken, Explosive Kunai, Poison Kunai, Fuma Shuriken, Toroi Unique Fuma Shuriken, Flying Raijin Kunai, Tanto, Katana, Asuma Chakra Blade, White Light Chakra Sabre, Sword of Kusanagi, Gunbai, Triple-Blade Scythe, Samehada, Kubikiribocho, Hiramekarei, Kabutowari, Kiba Sword, Nuibari, Shibuki, Shichiseiken

**Headbands** (15): Hidden Leaf Genin Headband (blue), Hidden Leaf Genin Headband (black), Hidden Leaf Genin Headband (red), Hidden Sand Genin Headband (blue), Hidden Sand Genin Headband (black), Hidden Sand Genin Headband (red), Hidden Mist Genin Headband (blue), Hidden Mist Genin Headband (black), Hidden Mist Genin Headband (red), Hidden Cloud Genin Headband (blue), Hidden Cloud Genin Headband (black), Hidden Cloud Genin Headband (red), Hidden Stone Genin Headband (blue), Hidden Stone Genin Headband (black), Hidden Stone Genin Headband (red)

**Shinobi Items** (18): Bronze Ryo, Silver Ryo, Gold Ryo, Chakra Paper, Shadow Clone Technique, Paper Bomb, Iron Stick, Sharp Iron, Kamui Stone, Ichiraku Ramen, Shogi, Shogi board, Story Mode, D-Rank Mission: Shogi Board, D-Rank Mission: Pillage The Post, D-Rank Mission: Save The Village, C-Rank Mission: Asuma's Chakra Blade, C-Rank Mission: Iron Defense

**Spawn eggs** (vanilla Spawn Eggs tab): Shinobi Merchant Spawn Egg, Hidden Leaf Shinobi Spawn Egg, Hidden Sand Shinobi Spawn Egg, Hidden Mist Shinobi Spawn Egg, Hidden Cloud Shinobi Spawn Egg, Hidden Stone Shinobi Spawn Egg, Asuma Spawn Egg, Shikamaru Spawn Egg, Kurama Spawn Egg

### Shinobi Merchant and village trades

Money is Ryo: 9 Bronze = 1 Silver, 9 Silver = 1 Gold. The Shinobi Merchant spawns in villages.

| Who | Pays | Gets |
|---|---|---|
| Farmer | 4 Bronze Ryo | Ichiraku Ramen |
| Shinobi Merchant | 12 Bone | 2 Bronze Ryo |
| Shinobi Merchant | Diamond | 2 Silver Ryo |
| Shinobi Merchant | 2 Emerald | Silver Ryo |
| Shinobi Merchant | 2 Ender Pearl | Silver Ryo |
| Shinobi Merchant | 3 Gold Ingot | Silver Ryo |
| Shinobi Merchant | 6 Gunpowder | 3 Bronze Ryo |
| Shinobi Merchant | 4 Iron Ingot | 4 Bronze Ryo |
| Shinobi Merchant | 16 Rotten Flesh | 2 Bronze Ryo |
| Shinobi Merchant | 12 String | 2 Bronze Ryo |
| Shinobi Merchant | 2 Bronze Ryo | 3 Bread |
| Shinobi Merchant | 3 Bronze Ryo | 2 Cooked Salmon |
| Shinobi Merchant | 4 Bronze Ryo | Ichiraku Ramen |
| Shinobi Merchant | 2 Silver Ryo | 2 Explosive Kunai |
| Shinobi Merchant | 2 Bronze Ryo | 4 Iron Stick |
| Shinobi Merchant | 4 Bronze Ryo | 4 Kunai |
| Shinobi Merchant | Silver Ryo | 4 Poison Kunai |
| Shinobi Merchant | 3 Bronze Ryo | 2 Sharp Iron |
| Shinobi Merchant | 4 Bronze Ryo | 8 Shuriken |
| Shinobi Merchant | 3 Silver Ryo | Katana |
| Shinobi Merchant | Silver Ryo + 4 Bronze Ryo | Tanto |
| Weaponsmith | Gold Ryo | Asuma Chakra Blade |

### Other items

**Headband outfits** (worn with the headband, chosen on the headband screen): 45 pieces, chestplate, leggings and boots for each village and colour.

**Weapon forms** (a weapon turns into these; not handed out on their own): Gunbai guard form, Hiramekarei Twinsword form, Hiramekarei Hammer form, and the Jonin katana village shinobi carry.

**Hidden, only with `/give`**: the Otsutsuki weapons (Otsutsuki Axe, Otsutsuki Bat, Otsutsuki Blade, Otsutsuki Chopping Sword, Otsutsuki Hammer, Otsutsuki Katana, Otsutsuki Spear, Otsutsuki Sword). Right-click switches between them.

**Given by the game** (missions, rewards, crafting): Letter From Brother

Thrown kunai and shuriken, and a few old jutsu projectiles, also exist as projectile items; you never hold them.

## Mobs and characters

### Characters and mobs

- **Asuma**: Mission character.
- **Earth Golem**: An earth golem summoned by Hidden Stone shinobi.
- **Hidden Cloud Shinobi**: Village shinobi (Genin, Chunin or Jonin): footwork, hand signs and their village's nature jutsu, kunai and shuriken, Body Flicker, Substitution.
- **Hidden Leaf Shinobi**: Village shinobi (Genin, Chunin or Jonin): footwork, hand signs and their village's nature jutsu, kunai and shuriken, Body Flicker, Substitution.
- **Hidden Mist Shinobi**: Village shinobi (Genin, Chunin or Jonin): footwork, hand signs and their village's nature jutsu, kunai and shuriken, Body Flicker, Substitution.
- **Hidden Sand Shinobi**: Village shinobi (Genin, Chunin or Jonin): footwork, hand signs and their village's nature jutsu, kunai and shuriken, Body Flicker, Substitution.
- **Hidden Stone Shinobi**: Village shinobi (Genin, Chunin or Jonin): footwork, hand signs and their village's nature jutsu, kunai and shuriken, Body Flicker, Substitution.
- **Iruka Sensei**: Academy teacher (story).
- **Shikamaru**: Mission character.
- **Training Dummy**: Takes hits for training.
- **Shinobi Merchant**: Trades for Ryo (see above).
- **Kurama** (Nine-Tails, spawn egg): claw swipes, tail sweeps, a roar, the Tailed Beast Ball (and a volley of small ones), a leap with a shockwave. Faster below half health.

### Summons and jutsu creatures

Akamaru, Crow, Earth Golem, Wood Golem; plus the shadow clones, the Nara shadows, the ice mirrors, Akamaru's forms and the other bodies jutsu create.

### Susanoo forms

14 forms: the ribcage, then a skeleton, humanoid and armoured form for each Mangekyou (Itachi, Sasuke, Madara, Obito, Shisui).

## Blocks

Mostly blocks jutsu place (they disappear again) and story blocks:

- Amaterasu (`amaterasu`)
- Amaterasu (`amaterasu_spread`)
- Dust Release (`dust_block`)
- Dust Release (`dust_block_view`)
- Dust Release (`dust_block_view_2`)
- Dust Release (`dust_block_view_3`)
- Earth Wall (`earth_wall`)
- Kamui Stone (`kamui_stone`)
- Kamui Void (`kamui_void`)
- Shadow (`nara_shadow`)
- Paper Bomb (`paper_bomb`)
- Waterwall (`waterwall`)

## Effects

Status effects jutsu put on you or others: Coercion Sharingan Genjutsu, Drowning, Gates, Hyuga, Ice Mirror, Inuzuka, Tree Bind Flourishing Burial.

## World

- Biomes: Kamui, Story Mode Biome
- Dimensions: Kamui Dimension, Story Mode Dimension
- Structures: Kamui Tower1, Kamui Tower2, Kamui Tower3, Kamui Tower4, Kamui Tower5, Kamui Tower6, Kamui Tower7, Kamui Tower8, Kamui Tower9

## Stats, ranks and progression

- Killing and casting give XP; levels give **SP** to spend on stats (info card, Stats page) and **JP** to buy jutsu.
- Shinobi ranks: Academy Student, Genin, Chunin, Jonin, Kage (not tied to level). Higher ranks shorten cooldowns.

| Stat | Cap | What it does |
|---|---|---|
| Ninjutsu | none | +10 max chakra a point; jutsu damage +1% a point (up to 150) |
| Taijutsu | 120 | +1 fist damage per 15 |
| Kenjutsu | 100 | weapon art damage; needed to wield big swords |
| Shurikenjutsu | 40 | thrown weapons; Flying Raijin |
| Summoning | 60 | summons |
| Kinjutsu | 100 | forbidden techniques |
| Medicine | 300 | +6 max health per 10 (200 at 300) and healing |
| Speed | 10 | +3.5% speed a point |
| Genjutsu | 70 | genjutsu |
| IQ | 220 | strategy |
| Senjutsu | none | +15 senjutsu chakra a point |

- **Chakra Control** (G): walk on water and walls, Focus (sneak and stand still) to regenerate chakra and sense, harder sprinting punches, a dash on Left Alt.
- **Info card** (I): stats, dojutsu, missions, the Jutsu page and a mini-game.
- Missions: D-Rank Mission: Shogi Board, D-Rank Mission: Pillage The Post, D-Rank Mission: Save The Village, C-Rank Mission: Asuma's Chakra Blade, C-Rank Mission: Iron Defense, Story Mode.

## Settings

In game: **Mods → Naruto Shippuden → Config**, or the file `config/naruto_shippuden-common.toml`.

| Setting | Default | What it does |
|---|---|---|
| `random_clan` | false | true: new players roll a random clan and nature (Clan Paper, Chakra Paper); false: they choose a clan on a screen |
| `kekkei_genkai_at_birth_percent` | 1 | Chance a new player is born with a random kekkei genkai |
| `sharingan_minutes / mangekyou_sharingan_minutes` | 30 / 90 | Minutes of play before an Uchiha awakens them |
| `byakugan_minutes` | 40 | Hyuga |
| `ketsuryugan_minutes` | 33.3 | Chinoike |
| `tenseigan_minutes / rinnegan_minutes / kokugan_minutes` | 120 / 180 / 150 | Otsutsuki paths |
| `combine_natures` | true | Kekkei genkai DNA needs the natures it combines |

## Controls

All in their own "Naruto Shippuden" category in Controls.

| Key | What it does |
|---|---|
| V | Dojutsu: tap to open / step up, sneak + tap to close, hold for the eye wheel |
| B | Susanoo: hold to grow, tap to dismiss |
| G | Chakra Control on/off |
| Left Alt | Dash (with Chakra Control) |
| X | Jutsu wheel |
| I | Info card |
