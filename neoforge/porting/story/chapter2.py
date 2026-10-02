"""Chapter 2, the first team: the player's squad (Team Six: Ren, Yui and their sensei Tatsumi Kurogane, original characters)
learns what the Academy didn't teach (chakra control, walking up cliffs and on water, the dash, their chakra nature) before
their first missions. The squad's characters are in chapter1.py (they appear after the Scroll of Seals). Run
`python3 chapter2.py` to write the quests into both resource trees."""
from chapter1 import G, say, choice, talk, write

Q = 'chapter2/'
AFTER_CH1 = 'chapter1/05_team_assignment'
LAKE = (-134, 91)


def team(steps=1, at=((-129, -67), (-123, -67))):
    """Ren and Yui, there for this player's lesson (their usual figures step aside meanwhile)."""
    return [dict(character='ren', pos=[at[0][0], G, at[0][1]], yaw=180, steps=steps),
            dict(character='yui', pos=[at[1][0], G, at[1][1]], yaw=180, steps=steps)]

QUESTS = {
    Q + '01_chakra_control': dict(
        title='Training: Chakra Control', chapter=2, after=[AFTER_CH1], start='tatsumi',
        offer=[
            say('tatsumi', "Before I send you on missions, you need to control your chakra, not just have it."),
            say('tatsumi', "Gather it. Feel it. Then stand still and let it settle. (G for Chakra Control, then hold Sneak to focus.)"),
        ],
        steps=[
            dict(type='event', event='chakra_control', text='Turn on Chakra Control (G)', time='day'),
            dict(type='event', event='focus', text='Hold Sneak and stand still to focus your chakra'),
            talk('tatsumi', 'Show Tatsumi-sensei', [
                say('tatsumi', "Good. Now keep that chakra in the soles of your feet, and walk straight up the cliff north of here."),
                say('ren', "Up the CLIFF? Without hands?"),
                say('tatsumi', "Too little and you slip. Too much and you're blasted off. Steady. Last one to the top makes dinner."),
            ]),
            # Yui walks straight up the cliff; Ren goes too, and keeps slipping off
            dict(type='goto', pos=[-126, 100, -178], radius=28, min_y=100, text='Walk up the cliff north of the training ground',
                 spawn=team(),
                 effects=[dict(type='walk', character='yui', points=[[-123, -90], [-124, -186]], speed=0.13),
                          dict(type='walk', character='ren', points=[[-129, -90], [-128, -186]], speed=0.11, slip=0.9)]),
            talk('tatsumi', 'Come back down to Tatsumi-sensei', [
                say('tatsumi', "Not bad. Ren's still halfway up, and Yui made it first. Ren makes dinner."),
                say('yui', "It's all about balance. You did well too!"),
            ]),
        ],
        rewards={'xp': 20}),

    Q + '02_water_walking': dict(
        title='Training: Walking on Water', chapter=2, after=[Q + '01_chakra_control'], start='tatsumi',
        offer=[
            say('tatsumi', "A cliff stands still. Water doesn't. Your chakra has to move with it."),
            say('tatsumi', "Go to the lake south-west of the Academy and stand in the middle of it. On it, not in it."),
        ],
        steps=[
            # the two of them already out on the water, circling; Ren goes under now and then
            dict(type='goto', pos=[-134, G, 91], radius=4, min_y=64.9, text='Stand on the water in the middle of the lake', time='evening',
                 spawn=team(at=((LAKE[0] + 4, LAKE[1]), (LAKE[0] - 4, LAKE[1]))),
                 effects=[dict(type='walk', character='yui', speed=0.07, loop=True,
                               points=[[LAKE[0] - 4, LAKE[1] - 4], [LAKE[0] + 4, LAKE[1] - 4], [LAKE[0] + 4, LAKE[1] + 4], [LAKE[0] - 4, LAKE[1] + 4]]),
                          dict(type='walk', character='ren', speed=0.08, loop=True, slip=0.3,
                               points=[[LAKE[0] + 3, LAKE[1] + 3], [LAKE[0] - 3, LAKE[1] + 3], [LAKE[0] - 3, LAKE[1] - 3], [LAKE[0] + 3, LAKE[1] - 3]])]),
            talk('tatsumi', 'Report back to Tatsumi-sensei', [
                say('tatsumi', "Dry feet. Good. Ren fell in twice. Don't tell him I said so."),
            ]),
        ],
        rewards={'xp': 20}),

    Q + '03_body_flicker': dict(
        title='Training: The Dash', chapter=2, after=[Q + '02_water_walking'], start='tatsumi',
        offer=[
            say('tatsumi', "Speed decides most fights before the first blow. Push your chakra out in one burst and move."),
            say('tatsumi', "With Chakra Control on, dash. (Left Alt, with a direction.)"),
        ],
        steps=[
            dict(type='event', event='dash', text='Dash with Chakra Control on (Left Alt)', time='day'),
            talk('tatsumi', 'Show Tatsumi-sensei', [
                say('tatsumi', "There it is. Now try that against someone who dashes back."),
                say('ren', "Me! Pick me! I'll show you a real dash!"),
            ]),
            dict(type='spar', npc='ren', hits=8, damage=2, rank=1, throws=True, substitution=False, text='Spar with Ren'),
            talk('ren', 'Talk to Ren', [
                say('ren', "Whoa... You're fast! Okay, okay, you win this one. Next one's mine!"),
            ]),
        ],
        rewards={'xp': 25}),

    Q + '04_chakra_nature': dict(
        title='Training: Chakra Nature', chapter=2, after=[Q + '03_body_flicker'], start='tatsumi',
        offer=[
            say('tatsumi', "Every shinobi's chakra leans toward a nature: fire, wind, lightning, earth or water."),
            say('tatsumi', "This Chakra Paper reacts to it. Channel your chakra into it."),
        ],
        steps=[
            dict(type='event', event='chakra_paper', text='Channel chakra into the Chakra Paper (use it)',
                 on_start=['execute unless items entity @s container.* naruto_shippuden:chakra_paper run give @s naruto_shippuden:chakra_paper']),
            talk('tatsumi', 'Tell Tatsumi-sensei what happened', [
                say('tatsumi', "So that's your nature. Learn it well: one day your strongest jutsu will be born from it."),
                say('tatsumi', "Training's done for now. Tomorrow we go to the mission desk. Our first mission as Team Six."),
            ]),
        ],
        rewards={'xp': 25}),
}

if __name__ == '__main__':
    for qid, q in QUESTS.items():
        write('quests/' + qid, q)
    print(len(QUESTS), 'quests')
