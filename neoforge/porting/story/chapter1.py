"""Chapter 1, the Academy: the characters (story/characters) and the quests (story/quests/chapter1/...), written as data.
(Chakra control, walking on walls and water, the dash and the Chakra Paper are Chapter 2's, taught by the player's sensei.)
Run `python3 chapter1.py` to write them into both resource trees. The quest format is in story/Story.java's javadoc.

The player is a classmate in Naruto's graduation year: Iruka's lessons in the Academy yard (chakra control, walking up
walls and on water, kunai, taijutsu, the Chakra Paper), the graduation exam, the night Mizuki steals the Scroll of
Seals, and the team assignments that lead into Chapter 2. World coordinates are Chikyū's (the Leaf's centre at 0, 0)."""
import json
import os

HERE = os.path.dirname(os.path.abspath(__file__))
NEO = os.path.normpath(os.path.join(HERE, '..', '..'))
TREES = [os.path.join(NEO, 'src/main/resources'), os.path.join(NEO, 'porting/res_override')]
G = 65          # the Leaf's ground: where feet stand


def skin(name):
    return 'naruto_shippuden:textures/entities/story/%s.png' % name


HEADBAND = {'head': 'naruto_shippuden:genin_konohagakure_helmet'}
# the class wear their headbands once they have passed (for the players who saw them pass); Naruto's comes from Iruka on the
# night of the Scroll of Seals. Ino (at her waist), Shikamaru (on his arm) and Hinata (round her neck) wear theirs where
# Minecraft has no slot for it, so theirs is painted on or left out.
GRADUATES = dict(graduate=HEADBAND, graduate_after='chapter1/03_graduation')


CHARACTERS = {
    'iruka': dict(name='Iruka Umino', skin=skin('iruka'), model='player', equipment=HEADBAND, home=[-84, G, -73], yaw=0,
                  idle=["Don't be late for class.", "A shinobi's tools are only as good as their training.",
                        "Naruto! ...Oh, it's you. Sorry. Have you seen him?"]),
    # gone from the Academy once the class has passed (that night he shows what he is)
    'mizuki': dict(name='Mizuki', skin=skin('mizuki'), model='player', equipment=HEADBAND, home=[-79, G, -74], yaw=0, until='chapter1/03_graduation',
                   idle=["Iruka is too soft on that Naruto.", "Study hard. The exam is closer than you think."]),
    # the Hokage's hat and the jonin vest are real armour (story/StoryGear), over his uniform
    'hiruzen': dict(name='Hiruzen Sarutobi', skin=skin('hiruzen'), model='player', home=[0, G, -56], yaw=0,
                    equipment={'head': 'naruto_shippuden:hokage_hat', 'chest': 'naruto_shippuden:jonin_vest'},
                    idle=["Every one of you is a leaf of this village.", "Ah, the Academy's newest. How are your lessons?"]),
    'naruto': dict(name='Naruto Uzumaki', skin=skin('naruto'), model='player', home=[-99, G, -60], yaw=-90,
                   graduate=HEADBAND, graduate_skin=skin('naruto_genin'), graduate_after='chapter1/04_scroll_of_seals',
                   idle=["I'm gonna be Hokage someday, believe it!", "Ramen after class? ...You're paying, right?",
                         "Sasuke thinks he's so cool. Hmph!"]),
    'sasuke': dict(name='Sasuke Uchiha', skin=skin('sasuke'), model='player', home=[-94, G, -68], yaw=-90, **GRADUATES,
                   idle=["...", "Don't get in my way.", "Hmph."]),
    'sakura': dict(name='Sakura Haruno', skin=skin('sakura'), model='slim', home=[-91, G, -69], yaw=90, **GRADUATES,
                   idle=["Sasuke is SO cool, isn't he?", "I'm top of the class in theory, you know!"]),
    'ino': dict(name='Ino Yamanaka', skin=skin('ino'), model='slim', home=[-90, G, -67], yaw=90,
                idle=["Back off, Forehead! ...Oh, you're not Sakura.", "My family runs the flower shop. Come by sometime!"]),
    'shikamaru': dict(name='Shikamaru Nara', skin=skin('shikamaru_kid'), model='player', home=[-72, G, -69], yaw=90,
                      idle=["What a drag...", "I'd rather be watching the clouds."]),
    'choji': dict(name='Choji Akimichi', skin=skin('choji'), model='player', home=[-71, G, -67], yaw=90, **GRADUATES,
                  idle=["*crunch* Want a chip? ...Just one.", "Shikamaru's smarter than he looks."]),
    # her resting Byakugan, drawn as players' eyes are (the mod's dojutsu textures)
    'hinata': dict(name='Hinata Hyuga', skin=skin('hinata'), model='slim', home=[-104, G, -57], yaw=-90,
                   eyes='naruto_shippuden:textures/dojutsu/byakugan/byakugan_2x2_pupils_1x2_not_active.png',
                   idle=["O-oh! I wasn't watching Naruto... I mean...", "G-good luck with your training."]),
    'kiba': dict(name='Kiba Inuzuka', skin=skin('kiba'), model='player', home=[-75, G, -59], yaw=90, **GRADUATES,
                 idle=["Akamaru says you smell like a rookie!", "Wanna go a round? I'll go easy. Maybe."]),
    'shino': dict(name='Shino Aburame', skin=skin('shino'), model='player', home=[-64, G, -65], yaw=90, **GRADUATES,
                  idle=["...", "The insects tell me rain is coming. Why? Because they always know."]),
    # the player's squad: original characters, at Training Ground 3 once Chapter 1's last night is over
    'tatsumi': dict(name='Tatsumi Kurogane', skin=skin('tatsumi'), model='player', equipment=HEADBAND, home=[-126, G, -76], yaw=0, after='chapter1/04_scroll_of_seals',
                    idle=["Teamwork first. Talent second.", "Don't look at my scar, look at my hands. That's where the jutsu starts."]),
    'ren': dict(name='Ren Sakuragi', skin=skin('ren'), model='player', equipment=HEADBAND, home=[-129, G, -67], yaw=180, after='chapter1/04_scroll_of_seals',
                idle=["Our first real mission's coming. I can feel it!", "Race you to the stumps!"]),
    'yui': dict(name='Yui Hoshino', skin=skin('yui'), model='slim', home=[-123, G, -67], yaw=180, after='chapter1/04_scroll_of_seals',
                idle=["If you get hurt, come to me. I've been studying medical ninjutsu.", "Ren's loud, but he means well."]),
}


def say(speaker, text, choices=None):
    line = {'speaker': speaker, 'text': text}
    if choices:
        line['choices'] = choices
    return line


def choice(text, flag=None, lines=None):
    c = {'text': text}
    if flag:
        c['flag'] = flag
    if lines:
        c['lines'] = lines
    return c


def talk(npc, text, dialogue, **more):
    return dict(type='talk', npc=npc, text=text, dialogue=dialogue, **more)


Q = 'chapter1/'
EXAM_ROOM = [-70, G, -100]
TRAINING_GROUND = [-120, G, -74]
HEADBANDS = [('Blue', 'naruto_shippuden:genin_konohagakure_helmet'), ('Black', 'naruto_shippuden:genin_konohagakure_black_helmet'),
             ('Red', 'naruto_shippuden:genin_konohagakure_red_helmet')]

QUESTS = {
    Q + '01_first_day': dict(
        title='First Day at the Academy', chapter=1, start='auto',
        steps=[
            talk('iruka', 'Talk to Iruka in the Academy yard', time='morning', dialogue=[
                say('iruka', "Ah, there you are! You must be our new student. Welcome to the Hidden Leaf Academy. I'm Iruka Umino, your instructor."),
                say('iruka', "The graduation exam is only weeks away, so we'll have to work hard. Any questions before we start?", [
                    choice("Nice to meet you, Iruka-sensei!", 'polite', [say('iruka', "Ha, polite too! You'll fit right in.")]),
                    choice("When do I learn the cool jutsu?", 'eager', [say('iruka', "Ha! You sound just like Naruto. First things first.")]),
                ]),
                say('iruka', "Go and meet your classmates in the yard first. You'll be training beside them every day."),
            ]),
            talk('naruto', 'Meet Naruto by the swing', [
                say('naruto', "Hey! You're the new kid, right? I'm Naruto Uzumaki, and I'm gonna be Hokage someday!"),
                say('naruto', "So everybody's gotta respect me! ...Starting with you. Believe it!", [
                    choice("Hokage? That's a big dream.", 'kind', [say('naruto', "Heh heh! Biggest dream in the whole village!")]),
                    choice("You? Hokage?", 'tease', [say('naruto', "Hey! Just you wait, I'll show everybody!")]),
                ]),
            ]),
            talk('sasuke', 'Meet Sasuke', [
                say('sasuke', "..."),
                say('player', "Hi, I'm new here."),
                say('sasuke', "I'm not here to make friends. Don't slow me down."),
            ]),
            talk('sakura', 'Meet Sakura and Ino', [
                say('sakura', "Oh, hi! I'm Sakura. Have you met Sasuke yet? Isn't he amazing?"),
                say('ino', "Back off, Forehead, nobody asked you! I'm Ino. Sasuke sits next to ME, by the way."),
                say('sakura', "In your dreams, Ino-pig!"),
            ]),
            talk('shikamaru', 'Meet Shikamaru and Choji', [
                say('shikamaru', "New kid, huh? I'm Shikamaru. This is Choji. Don't expect much from me... what a drag."),
                say('choji', "*crunch* Hi! You can have one chip. Just one. ...Okay, maybe not."),
            ]),
            talk('iruka', 'Report back to Iruka', [
                say('iruka', "Lively bunch, aren't they? Good. Lessons begin now, starting with the tools every shinobi carries."),
            ]),
        ],
        rewards={'xp': 10}),

    Q + '02_kunai_taijutsu': dict(
        title='Lesson: Kunai and Taijutsu', chapter=1, after=[Q + '01_first_day'], start='iruka',
        offer=[
            say('iruka', "A shinobi without tools is a shinobi in trouble. Here are some kunai."),
            say('iruka', "Throw them at the training dummy by the targets. Aim for the chest!"),
        ],
        steps=[
            dict(type='hit', entity='naruto_shippuden:training_dummy', count=5, text='Hit the training dummy with kunai', time='day',
                 on_start=['give @s naruto_shippuden:kunai 16',
                           'execute unless entity @e[type=naruto_shippuden:training_dummy,x=-68,y=65,z=-58,distance=..3] run '
                           'summon naruto_shippuden:training_dummy -68 65 -58']),
            talk('iruka', 'Show Iruka', [
                say('iruka', "Nice throws! Now, taijutsu. Kiba's been itching for a match all morning."),
                say('kiba', "Finally! Akamaru and I are gonna wipe the floor with you, rookie!"),
            ]),
            dict(type='spar', npc='kiba', hits=6, damage=2, rank=0, text='Spar with Kiba'),
            talk('kiba', 'Talk to Kiba', [
                say('kiba', "Tch... not bad. Akamaru says you got lucky. ...Rematch later!"),
            ]),
            talk('iruka', 'Report back to Iruka', [
                say('iruka', "A fine match. Remember: a real fight isn't won with strength alone, but with what you see coming."),
            ]),
        ],
        rewards={'xp': 20}),

    Q + '03_graduation': dict(
        title='The Graduation Exam', chapter=1, after=[Q + '02_kunai_taijutsu'], start='iruka',
        offer=[
            say('iruka', "This is it: the graduation exam. Come to the exam room on the Academy's ground floor. Mizuki and I will be your examiners."),
        ],
        steps=[
            dict(type='goto', pos=EXAM_ROOM, radius=4, text='Go to the exam room in the Academy', time='morning',
                 spawn=[dict(character='iruka', pos=[-70, G, -105], yaw=0, steps=4), dict(character='mizuki', pos=[-73, G, -105], yaw=0, steps=4)]),
            talk('iruka', 'Talk to Iruka', [
                say('iruka', "First part: the Clone Technique. Show us clones of yourself."),
                say('mizuki', "Relax. Just like we practised."),
            ]),
            dict(type='event', event='shadow_clone', text='Perform the Clone Technique (use the scroll)',
                 on_start=['execute unless items entity @s container.* naruto_shippuden:shadow_clone_technique run give @s naruto_shippuden:shadow_clone_technique']),
            talk('iruka', 'Talk to Iruka', [
                say('iruka', "Clean, solid clones. Second part: a spar. Sasuke is waiting for you in the yard."),
            ]),
            dict(type='spar', npc='sasuke', hits=8, damage=3, rank=1, throws=True, substitution=True, text='Spar with Sasuke in the yard'),
            talk('sasuke', 'Talk to Sasuke', [
                say('sasuke', "...You're stronger than you look. Next time, I won't hold back."),
            ]),
            talk('iruka', 'Return to Iruka', [
                say('iruka', "Congratulations. You pass! From today, you are a shinobi of the Hidden Leaf."),
                say('iruka', "Here: your forehead protector. Which cloth would you like?",
                    [choice(colour, 'headband_' + colour.lower(), [say('iruka', "Wear it with pride.")],
                            ) | {'commands': ['give @s %s' % item, 'naruto rank genin @s']} for colour, item in HEADBANDS]),
                say('iruka', "...Naruto failed again, though. Go and see him if you can. He's by the swing."),
            ]),
            talk('naruto', 'Find Naruto at the swing', time='evening', dialogue=[
                say('naruto', "...Hey. Congrats on passing. Everybody passed. Everybody but me."),
                say('naruto', "Mizuki-sensei said there's a secret way to pass... Never mind. See ya.", [
                    choice("Don't give up, Naruto.", 'cheered_naruto', [say('naruto', "...Yeah. I never give up. That's my ninja way!")]),
                    choice("A secret way? That sounds strange.", 'suspicious', [say('naruto', "Huh? It's fine! Mizuki-sensei's nice!")]),
                ]),
            ]),
        ],
        rewards={'xp': 50}),

    Q + '04_scroll_of_seals': dict(
        title='The Scroll of Seals', chapter=1, after=[Q + '03_graduation'], start='auto',
        steps=[
            talk('hiruzen', 'Answer the Hokage\'s summons at his residence', time='night', dialogue=[
                say('hiruzen', "You're one of the new genin, aren't you? I'm sorry to call on you on your first night as a shinobi."),
                say('hiruzen', "Naruto has taken the Scroll of Seals, a scroll of forbidden techniques. Everyone is searching for him."),
                say('hiruzen', "Check the training ground west of the Academy. And be careful."),
            ]),
            dict(type='goto', pos=TRAINING_GROUND, radius=9, text='Search Training Ground 3, west of the Academy',
                 spawn=[dict(character='iruka', pos=[-126, G, -75], yaw=-90, steps=6), dict(character='naruto', pos=[-128, G, -77], yaw=-90, steps=6),
                        dict(character='mizuki', pos=[-117, G, -75], yaw=90, steps=6)],
                 effects=[dict(type='pose', character='iruka', pose='crouch')]),
            talk('iruka', 'Talk to the wounded Iruka', [
                say('iruka', "You... get out of here! Mizuki's the one who tricked Naruto. He wants the scroll for himself!"),
            ]),
            talk('mizuki', 'Face Mizuki', [
                say('mizuki', "Oh? One of the little genin. Do you know why the whole village hates Naruto? Shall I tell you?"),
                say('mizuki', "No? Then you can fall here with Iruka.", [
                    choice("Leave them alone!", 'brave'),
                    choice("Naruto is my classmate. I won't let you.", 'loyal'),
                ]),
            ]),
            dict(type='spar', npc='mizuki', hits=10, damage=3, rank=2, throws=True, substitution=True, text='Fight Mizuki'),
            talk('naruto', 'Talk to Naruto', [
                say('naruto', "Lay one finger on Iruka-sensei and I'll take you down! Multi Shadow Clone Jutsu!"),
                say('mizuki', "Wh-what?! Hundreds of them...?!"),
                say('naruto', "Heh heh... I guess I got a little carried away. You okay?"),
                say('iruka', "Naruto, come here. Close your eyes... There. Congratulations. You graduate too."),
            ], effects=[dict(type='clones', character='naruto', around='mizuki', count=28, seconds=7),
                        dict(type='smoke', character='mizuki', delay=150), dict(type='pose', character='mizuki', pose='lie', delay=150),
                        dict(type='pose', character='iruka', pose='stand', delay=170)]),
            talk('hiruzen', 'Report to the Hokage', [
                say('hiruzen', "The scroll is safe, and Naruto is a genin. You did well tonight, standing beside your classmates."),
                say('hiruzen', "Rest now. Tomorrow you'll be placed in your squad."),
            ]),
        ],
        # the night is over: the team assignments are in the morning
        rewards={'xp': 60, 'time': 'morning'}),

    Q + '05_team_assignment': dict(
        title='Team Assignment', chapter=1, after=[Q + '04_scroll_of_seals'], start='iruka',
        offer=[
            say('iruka', "Good morning, genin! Today you'll be split into three-person squads, each led by a jonin."),
            say('naruto', "Team Seven! With Sakura-chan! ...And Sasuke. Ugh."),
            say('iruka', "And you: Team Six, with Ren Sakuragi and Yui Hoshino, under jonin Tatsumi Kurogane. He's waiting for you at Training Ground 3."),
        ],
        steps=[
            talk('tatsumi', 'Meet your sensei at Training Ground 3', [
                say('tatsumi', "So you're the third one. I'm Tatsumi Kurogane, your sensei. That loud one is Ren, and that's Yui."),
                say('ren', "Hey! Finally, a full team!"),
                say('yui', "Nice to meet you. Let's do our best."),
                say('tatsumi', "Graduating the Academy only means you can learn. From tomorrow, I teach you what a real shinobi does."),
            ]),
        ],
        rewards={'xp': 30}),
}


def write(rel, data):
    for t in TREES:
        p = os.path.join(t, 'data/naruto_shippuden/story', rel + '.json')
        os.makedirs(os.path.dirname(p), exist_ok=True)
        with open(p, 'w') as f:
            json.dump(data, f, indent=2, ensure_ascii=False)
            f.write('\n')


if __name__ == '__main__':
    for cid, c in CHARACTERS.items():
        write('characters/' + cid, c)
    for qid, q in QUESTS.items():
        write('quests/' + qid, q)
    # quests that are gone (the engine's test, the first draft's lessons now in Chapter 2)
    for t in TREES:
        d = os.path.join(t, 'data/naruto_shippuden/story/quests')
        for old in ('engine_test', 'chapter1/02_chakra_control', 'chapter1/03_water_walking', 'chapter1/04_shinobi_tools',
                    'chapter1/05_chakra_paper', 'chapter1/06_graduation', 'chapter1/07_scroll_of_seals', 'chapter1/08_team_assignment'):
            p = os.path.join(d, old + '.json')
            if os.path.exists(p):
                os.remove(p)
    print(len(CHARACTERS), 'characters,', len(QUESTS), 'quests')
