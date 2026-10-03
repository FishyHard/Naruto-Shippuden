"""Chapter 3, Team Six's first missions: the mission desk on the Hokage residence's ground floor, where the Hokage and Iruka
hand out D-ranks (firewood for Ichiraku, the lost cat Tora) and then the team's first C-rank, missing-nin on the trade road
outside the great gate. Run `python3 chapter3.py` to write the quests into both resource trees.

The mission desk (porting/structures_gen/leaf_landmarks.py, the residence's interior): its seats behind the desk at x -6, -3,
0, 3, 6, z -100, facing south over it; in front of it, the hall."""
from chapter1 import G, say, choice, talk, write

Q = 'chapter3/'
AFTER_CH2 = 'chapter2/04_chakra_nature'
DESK = [0, G, -96]                     # before the mission desk
ICHIRAKU = [-8, G, 57]
ROAD = [0, G, 208]                     # the trade road just outside the great gate
STICKS = 'minecraft:stick'


def at_desk(steps=2):
    """The Hokage and Iruka seated at the mission desk, the team waiting before it: Ren and Yui, their sensei behind them."""
    return [dict(character='hiruzen', pos=[-3, G, -100], yaw=0, steps=steps, pose='sit'),
            dict(character='iruka', pos=[3, G, -100], yaw=0, steps=steps, pose='sit'),
            dict(character='ren', pos=[-2, G, -95], yaw=180, steps=steps),
            dict(character='yui', pos=[2, G, -95], yaw=180, steps=steps),
            dict(character='tatsumi', pos=[0, G, -93], yaw=180, steps=steps)]


QUESTS = {
    Q + '01_firewood': dict(
        title='D-Rank: Firewood for Ichiraku', chapter=3, after=[AFTER_CH2], start='tatsumi', when='day', level=9,
        offer=[
            say('tatsumi', "Team Six, today's the day. The mission desk is on the ground floor of the Hokage residence."),
            say('tatsumi', "Let's see what the Hokage has for us. And Ren: no, it won't be bandits."),
        ],
        steps=[
            dict(type='goto', pos=DESK, radius=4, text='Go to the mission desk in the Hokage residence', spawn=at_desk()),
            talk('hiruzen', 'Receive your mission', [
                say('hiruzen', "Team Six. Your first mission as shinobi of the Leaf: a D-rank."),
                say('iruka', "Ichiraku Ramen is short of firewood. Sixteen sticks of it, cut outside the village walls."),
                say('ren', "Firewood?! I wanted to fight missing-nin!"),
                say('hiruzen', "Every shinobi starts here, Ren. Even the Fourth Hokage carried firewood."),
            ]),
            dict(type='collect', item=STICKS, count=16, text='Gather firewood: 16 sticks (cut wood outside the walls)'),
            dict(type='goto', pos=ICHIRAKU, radius=4, text='Bring the firewood to Ichiraku Ramen'),
            dict(type='collect', item=STICKS, count=16, take=True, text='Hand the firewood to Teuchi'),
            talk('teuchi', 'Talk to Teuchi', [
                say('teuchi', "Firewood! And split nice and even. Tell the old Hokage thanks."),
                say('teuchi', "Here, a bowl on the house. A shinobi's first pay should come with ramen."),
            ]),
        ],
        rewards={'xp': 25, 'ryo': 18, 'mission': 'D', 'items': [{'id': 'naruto_shippuden:ichiraku_ramen', 'count': 1}]}),

    Q + '02_tora': dict(
        title='D-Rank: The Lost Cat Tora', chapter=3, after=[Q + '01_firewood'], start='tatsumi', when='day', level=10,
        offer=[
            say('tatsumi', "Back to the desk. Another D-rank. Try to look excited, Ren."),
        ],
        steps=[
            dict(type='goto', pos=DESK, radius=4, text='Go to the mission desk', spawn=at_desk()),
            talk('iruka', 'Receive your mission', [
                say('iruka', "Tora, the Daimyo's wife's cat, has run away. Again. A ribbon on her left ear."),
                say('iruka', "She always hides in the same places: the trees by the training ground, behind Ichiraku, and the plaza."),
                say('yui', "The same cat... how many times has this happened?"),
                say('hiruzen', "This month? Four."),
            ]),
            dict(type='spots', points=[[-117, G, -80], [-19, G, 55], [3, G, -48]], seconds=2, radius=2.5,
                 colours=['#5E8C32', '#8A6A3E', '#A0C060'], bar='Searching',
                 text="Search Tora's hiding places: the training ground trees, behind Ichiraku, the plaza"),
            dict(type='near', tag='story_tora', radius=1.8, text="Tora's in the plaza! Catch her",
                 on_start=["summon minecraft:cat 3 65 -48 {CustomName:'Tora',PersistenceRequired:1b,variant:'minecraft:red',Tags:['story_tora']}"]),
            dict(type='goto', pos=DESK, radius=4, text='Bring Tora back to the mission desk', spawn=at_desk(), remove='story_tora'),
            talk('hiruzen', 'Report to the Hokage', [
                say('hiruzen', "Ah, Tora. And from your scratches, she didn't come quietly."),
                say('ren', "She bit me. Twice. Who names a cat 'Tiger' anyway?!"),
                say('iruka', "The Daimyo's wife will be grateful. Mission complete, Team Six."),
            ]),
        ],
        rewards={'xp': 25, 'ryo': 18, 'mission': 'D'}),

    Q + '03_missing_nin': dict(
        title='C-Rank: Missing-nin on the Road', chapter=3, after=[Q + '02_tora'], start='tatsumi', when='day', level=11,
        offer=[
            say('tatsumi', "A merchant was attacked on the trade road outside the great gate. Missing-nin, from the Mist."),
            say('tatsumi', "This one's a C-rank. It's real, so stay close and watch each other's backs."),
            say('ren', "FINALLY!"),
        ],
        steps=[
            dict(type='goto', pos=ROAD, radius=10, text='Go out through the great gate to the trade road',
                 spawn=[dict(character='tatsumi', pos=[3, G, 206], yaw=0, steps=3), dict(character='ren', pos=[-3, G, 206], yaw=0, steps=3),
                        dict(character='yui', pos=[0, G, 204], yaw=0, steps=3)]),
            # the story keeps the three there (dying and coming back finds them still on the road), tougher than an
            # Academy spar but not a match for a jonin; the team fights them alongside the player
            dict(type='kill', entity='naruto_shippuden:hidden_mist_shinobi', count=3, text='Defeat the missing-nin',
                 enemies=dict(around=[0, G, 214], radius=9, tags=['missing_nin'], health=26, damage=3),
                 allies=['tatsumi', 'ren', 'yui']),
            talk('tatsumi', 'Talk to Tatsumi-sensei', [
                say('tatsumi', "Good. You kept your heads, and nobody ran. That's a C-rank done, Team Six."),
                say('yui', "Is everyone hurt? Let me look."),
                say('ren', "Did you see that? Did you SEE that?!", [
                    choice("We did it together.", 'team_c_rank', [say('tatsumi', "Remember that feeling. That's a team.")]),
                    choice("You almost tripped, Ren.", 'tease_ren', [say('ren', "I did NOT! ...Okay, a little.")]),
                ]),
            ]),
        ],
        rewards={'xp': 60, 'ryo': 81, 'mission': 'C'}),
}

if __name__ == '__main__':
    for qid, q in QUESTS.items():
        write('quests/' + qid, q)
    print(len(QUESTS), 'quests')
