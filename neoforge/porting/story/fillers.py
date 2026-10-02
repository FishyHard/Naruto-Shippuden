"""Fillers: side stories between the chapters' quests, as the anime has them. Nothing in the main story waits on them; a
character offers one once the quest it follows is done, and only while no chapter quest is in progress (till then they say
its "later" line). Their ids sort after the chapters', so a character with a chapter quest to give offers that first.
Run `python3 fillers.py` to write them into both resource trees.

Ichiraku's stools, in Chikyū (the shop on the main street, its counter facing east onto the street): x -10, z 54, 56, 58,
60, the cushions on top; who sits there faces west, to the counter. Yakiniku Q's first booth (the barbecue place on
avenue B): its floor cushions at z 60 (facing south, to the grill) and z 62 (facing north), x 11..13, the low table
between."""
from chapter1 import G, say, choice, talk, write

Q = 'fillers/'
RAMEN = 'naruto_shippuden:ichiraku_ramen'
ICHIRAKU = [-8, G, 57]                 # in front of the counter, on the street side


YAKINIKU = [17, G, 66]                 # inside Yakiniku Q's door
FLOWER_SHOP = [-3, G, 91]              # before the Yamanaka flower shop's open front
HOSPITAL = [83, G, -87]                # the hospital's waiting room (its benches face north)
CLOUDS = [-116, G, -78]                # open grass at the edge of Training Ground 3 (clear of the trees)
ROCK_FOOT = [0, G, -131]               # flat ground before the Hokage Rock, below its talus
# the splashes of Naruto's paint on the four faces, on the air just in front of each face (porting/structures_gen/world.py)
PAINT = [[-53, 128, -159], [-27, 110, -162], [-21, 120, -158], [-1, 123, -161], [4, 115, -163], [21, 100, -157]]
TRAINING_DUMMY = ('execute unless entity @e[type=naruto_shippuden:training_dummy,x=-68,y=65,z=-58,distance=..3] run '
                  'summon naruto_shippuden:training_dummy -68 65 -58')


def booth(character, x, north, steps=2):
    """Someone sitting on a floor cushion at Yakiniku Q's first grill table, north of it (facing south) or south."""
    return dict(character=character, pos=[x, G - 0.2, 60 if north else 62], yaw=0 if north else 180, steps=steps, pose='sit')


def ground(character, x, z, yaw, pose='sit', steps=2):
    """Someone sitting (or lying) on the grass."""
    return dict(character=character, pos=[x, G - 0.35 if pose == 'sit' else G, z], yaw=yaw, steps=steps, pose=pose)


def stool(character, z, steps=2):
    """Someone sitting at Ichiraku's counter: on the stool at z, facing the counter."""
    return dict(character=character, pos=[-10, G + 0.8, z], yaw=90, steps=steps, pose='sit')


QUESTS = {
    Q + 'ramen_with_iruka': dict(
        title='Filler: Ramen with Iruka-sensei', chapter=1, after=['chapter1/01_first_day'], start='naruto',
        later="Ramen tonight? Maybe, once you've finished what Iruka-sensei gave you. Then we eat, believe it!",
        offer=[
            say('naruto', "Hey, new kid! Iruka-sensei's taking me to Ichiraku tonight. Best ramen in the whole village!"),
            say('naruto', "You should come too! It's on the main street, south of the plaza. Iruka-sensei's paying! ...Probably."),
        ],
        steps=[
            dict(type='goto', pos=ICHIRAKU, radius=4, text='Meet Iruka-sensei and Naruto at Ichiraku Ramen', time='evening',
                 spawn=[stool('iruka', 54, 3), stool('naruto', 56, 3)]),
            talk('naruto', 'Sit down with Naruto', [
                say('naruto', "Hey, you came! Sit, sit! Old man, one more miso pork ramen!"),
                say('teuchi', "Coming right up! Any friend of Naruto's eats well at Ichiraku."),
                say('naruto', "This is the best place in the whole village. I've eaten here like a thousand times. Believe it!", [
                    choice("A thousand? Is that all you eat?", 'ramen_tease', [say('naruto', "Ramen is a complete meal! ...Mostly.")]),
                    choice("Then I'll have what you're having.", 'ramen_same', [say('naruto', "Heh heh! You've got good taste!")]),
                ]),
                say('naruto', "Iruka-sensei, can I have seconds? And thirds?"),
            ]),
            talk('iruka', 'Talk to Iruka-sensei', [
                say('iruka', "One bowl, Naruto. I'm a teacher, not a bank."),
                say('iruka', "...He's alone most nights, you know. It's good he has someone his age to eat with. Thank you for coming."),
                say('iruka', "Here, take a bowl home with you. Rest well: lessons start early."),
            ]),
        ],
        rewards={'xp': 10, 'items': [{'id': RAMEN, 'count': 2}]}),

    Q + 'kiba_rematch': dict(
        title='Filler: Rematch with Kiba', chapter=1, after=['chapter1/02_kunai_taijutsu'], start='kiba',
        later="Rematch later, rookie. You've got something going on. Akamaru can smell it.",
        offer=[
            say('kiba', "Hey, rookie! Akamaru's been growling at me all day. He says last time didn't count."),
            say('kiba', "Rematch. Right now. No holding back this time!"),
        ],
        steps=[
            dict(type='spar', npc='kiba', hits=8, damage=2, rank=1, throws=False, substitution=True, text='Spar with Kiba again'),
            talk('kiba', 'Talk to Kiba', [
                say('kiba', "Gah! Again?! ...Fine. You're good. Akamaru likes you, anyway. Don't let it go to your head."),
            ]),
        ],
        rewards={'xp': 15}),

    Q + 'victory_ramen': dict(
        title='Filler: A Bowl to Celebrate', chapter=1, after=['chapter1/04_scroll_of_seals'], start='naruto',
        later="Ramen! ...After you're done with your thing. Then we're celebrating, believe it!",
        offer=[
            say('naruto', "Look, look! A real headband! Iruka-sensei's taking me to Ichiraku to celebrate!"),
            say('naruto', "You helped that night, so you're coming too. Come on!"),
        ],
        steps=[
            dict(type='goto', pos=ICHIRAKU, radius=4, text='Celebrate at Ichiraku Ramen with Naruto and Iruka-sensei', time='evening',
                 spawn=[stool('iruka', 54, 3), stool('naruto', 56, 3)]),
            talk('iruka', 'Sit down with Iruka-sensei', [
                say('iruka', "Ow... careful with the back, Naruto. Mizuki's shuriken still remember me."),
                say('naruto', "Sorry, sensei! ...Hey. Thanks. For everything."),
                say('iruka', "Eat, before it gets cold. Both of you. You earned it."),
            ]),
            talk('naruto', 'Talk to Naruto', [
                say('naruto', "Someday, I'll be Hokage, and everybody in the village will know my name. Even the ones who glared at me."),
                say('naruto', "You'll see it too, right?", [
                    choice("I'll be right there, Lord Seventh.", 'believe_naruto', [say('naruto', "Lord Seventh... Heh. It sounds awesome!")]),
                    choice("Only if you beat me first.", 'rival_naruto', [say('naruto', "Ha! You're on! A rival, believe it!")]),
                ]),
            ]),
        ],
        rewards={'xp': 15, 'items': [{'id': RAMEN, 'count': 2}]}),

    Q + 'team_six_dinner': dict(
        title='Filler: Ren Makes Dinner', chapter=2, after=['chapter2/01_chakra_control'], start='ren',
        later="Dinner's on me... later. Finish what you're doing first, and don't let sensei catch you slacking!",
        offer=[
            say('ren', "So, uh... Last one up the cliff makes dinner. That's me. The thing is, I can't cook."),
            say('ren', "Sensei says Ichiraku counts, as long as I'm paying. Come on, before I change my mind!"),
        ],
        steps=[
            dict(type='goto', pos=ICHIRAKU, radius=4, text='Have dinner with Team Six at Ichiraku Ramen', time='evening',
                 spawn=[stool('tatsumi', 54, 3), stool('yui', 56, 3), stool('ren', 58, 3)]),
            talk('ren', 'Sit down with Ren', [
                say('ren', "Order whatever you want! ...Within reason. Within, like, a small bowl of reason."),
                say('teuchi', "Four bowls? Ha! The big spender of Team Six!"),
                say('yui', "Ren, you've counted your coins three times."),
                say('ren', "Four! I'm being careful!"),
            ]),
            talk('tatsumi', 'Talk to Tatsumi-sensei', [
                say('tatsumi', "A team that eats together trusts each other with their backs. That's the real lesson tonight."),
                say('tatsumi', "...And I'll pay. Ren, put your wallet away before you cry into the broth.", [
                    choice("Thank you, sensei!", 'thanked_tatsumi', [say('tatsumi', "Thank me by not falling off the cliff tomorrow.")]),
                    choice("Ren, you're off the hook.", 'saved_ren', [say('ren', "I owe you one! ...A small one!")]),
                ]),
            ]),
        ],
        rewards={'xp': 15, 'items': [{'id': RAMEN, 'count': 2}]}),

    # ---------------------------------------------------------------- Chapter 1: the Academy
    Q + 'cloud_watching': dict(
        title='Filler: Cloud Watching', chapter=1, after=['chapter1/01_first_day'], start='shikamaru', when='day',
        later="Clouds'll still be there later. Go do your thing first... what a drag.",
        offer=[
            say('shikamaru', "Iruka-sensei's lecture is about to start. Which means it's the perfect time to be somewhere else."),
            say('shikamaru', "Choji and I watch the clouds at the edge of Training Ground 3. Come if you want. Or don't. Too troublesome to argue."),
        ],
        steps=[
            dict(type='goto', pos=CLOUDS, radius=5, text='Find Shikamaru and Choji at the edge of Training Ground 3', time='day',
                 spawn=[ground('shikamaru', -117, -78, 90, pose='lie', steps=3), ground('choji', -114, -76, 90, steps=3)]),
            dict(type='wait', seconds=20, text='Lie back and watch the clouds'),
            talk('shikamaru', 'Talk to Shikamaru', [
                say('shikamaru', "See that one? Looks like a deer. And that one... like Iruka-sensei when he's yelling."),
                say('choji', "*crunch* That one looks like a rice ball. ...I'm hungry."),
                say('shikamaru', "Clouds don't have to be anywhere. Sometimes I envy them.", [
                    choice("Must be nice.", 'clouds_nice', [say('shikamaru', "Heh. You get it. Not many do.")]),
                    choice("We'll get in trouble for skipping.", 'clouds_worried', [say('shikamaru', "Yeah. Worth it, though.")]),
                ]),
            ]),
        ],
        rewards={'xp': 10}),

    Q + 'yamanaka_flowers': dict(
        title='Filler: Flowers for the Yamanaka Shop', chapter=1, after=['chapter1/01_first_day'], start='ino',
        later="I'd ask you a favour, but you look busy. Come find me when you're free!",
        offer=[
            say('ino', "Hey, new kid! My family's flower shop is short on stock and Dad's out. Help me out?"),
            say('ino', "Pick me some poppies and dandelions from around the village and bring them to the shop. It's on the main street, east of here."),
        ],
        steps=[
            dict(type='collect', item='minecraft:poppy', count=3, text='Pick 3 poppies'),
            dict(type='collect', item='minecraft:dandelion', count=3, text='Pick 3 dandelions'),
            dict(type='goto', pos=FLOWER_SHOP, radius=4, text='Bring the flowers to the Yamanaka flower shop',
                 spawn=[dict(character='ino', pos=[-4, G, 90], yaw=-90, steps=2)]),
            talk('ino', 'Talk to Ino', [
                say('ino', "Perfect! Poppies mean remembrance, dandelions mean happiness. Every flower says something, you know."),
                say('ino', "Don't tell Sakura I needed help. Here, for your trouble."),
            ]),
        ],
        # the flowers handed over, a pot and a cornflower back
        rewards={'xp': 15, 'commands': ['clear @s minecraft:poppy 3', 'clear @s minecraft:dandelion 3'],
                 'items': [{'id': 'minecraft:flower_pot', 'count': 1}, {'id': 'minecraft:cornflower', 'count': 1}]}),

    Q + 'hinata_ointment': dict(
        title="Filler: Hinata's Ointment", chapter=1, after=['chapter1/02_kunai_taijutsu'], start='hinata',
        later="I-it's nothing... You're busy. M-maybe later...",
        offer=[
            say('hinata', "U-um... Naruto got hurt in training again. I made this ointment, but... I can't just give it to him..."),
            say('hinata', "Could you... give it to him? Please don't say it's from me!"),
        ],
        steps=[
            talk('naruto', "Give Hinata's ointment to Naruto", [
                say('naruto', "Ointment? For me? Whoa, thanks! ...Wait, who made it? This smells way too nice to be yours.", [
                    choice("A secret admirer.", 'ointment_secret', [say('naruto', "A secret what? Heh, whatever, it works great!")]),
                    choice("It's from Hinata.", 'ointment_told', [say('naruto', "Hinata? Huh. She's kinda weird... but nice! Tell her thanks!")]),
                ]),
            ]),
            talk('hinata', 'Tell Hinata how it went', [
                say('hinata', "H-he used it? He's okay? ...Thank you. Really."),
            ]),
        ],
        rewards={'xp': 10}),

    Q + 'sasuke_challenge': dict(
        title="Filler: Sasuke's Challenge", chapter=1, after=['chapter1/02_kunai_taijutsu'], start='sasuke',
        later="...Later. You've got other things to do.",
        offer=[
            say('sasuke', "You. Your kunai throws were sloppy, but you hit the target. Let's see if it was luck."),
            say('sasuke', "Ten hits on the dummy. I did it in under a minute."),
        ],
        steps=[
            dict(type='hit', entity='naruto_shippuden:training_dummy', count=10, text='Land 10 kunai hits on the training dummy',
                 on_start=['give @s naruto_shippuden:kunai 16', TRAINING_DUMMY]),
            talk('sasuke', 'Talk to Sasuke', [
                say('sasuke', "...Not bad. Still slower than me."),
                say('sasuke', "Keep training. I'll need someone worth beating."),
            ]),
        ],
        rewards={'xp': 15}),

    Q + 'yakiniku_q': dict(
        title='Filler: Barbecue at Yakiniku Q', chapter=1, after=['chapter1/03_graduation'], start='choji',
        later="Barbecue after you're done! I'll save you a spot. ...Maybe not the meat, though.",
        offer=[
            say('choji', "We passed! You know what that means? BARBECUE! Yakiniku Q, on avenue B. Shikamaru and Ino are coming!"),
        ],
        steps=[
            dict(type='goto', pos=YAKINIKU, radius=4, text='Join Choji, Shikamaru and Ino at Yakiniku Q', time='evening',
                 spawn=[booth('choji', 12, True, 3), booth('shikamaru', 13, True, 3), booth('ino', 12, False, 3)]),
            talk('choji', 'Sit down with Choji', [
                say('choji', "Sit, sit! The meat's almost ready. That piece is mine. And that one. And-"),
                say('ino', "Choji! Let other people eat!"),
                say('shikamaru', "Let him be. Arguing with Choji over meat is too troublesome."),
                say('choji', "Here, you can have this one. Because we're friends now.", [
                    choice("Thanks, Choji!", 'choji_friend', [say('choji', "Heh heh! Friends share. ...Just not the last piece.")]),
                    choice("You keep it.", 'choji_generous', [say('choji', "Really?! You're the best!")]),
                ]),
            ]),
        ],
        rewards={'xp': 15}),

    # ---------------------------------------------------------------- Chapter 2: Team Six
    Q + 'paint_prank': dict(
        title='Filler: Paint on the Hokage Rock', chapter=2, after=['chapter2/01_chakra_control'], start='naruto',
        later="Shh! I can't talk now, you're busy anyway! ...Don't tell Iruka-sensei where I am!",
        offer=[
            say('naruto', "Heh heh... So, uh, I might've painted the Hokage faces again. And Iruka-sensei says I gotta wash it all off."),
            say('naruto', "You can walk up walls now, right? Help me scrub! Six big splashes, all over the faces. Stand on each one and scrub!"),
        ],
        steps=[
            dict(type='spots', points=PAINT, seconds=3, radius=2.5,
                 text='Scrub the paint off the Hokage faces: walk up the Rock and stand at each splash'),
            dict(type='goto', pos=ROCK_FOOT, radius=6, text='Come back down to the foot of the Rock',
                 spawn=[dict(character='naruto', pos=[-2, G, -130], yaw=180, steps=2), dict(character='iruka', pos=[2, G, -130], yaw=180, steps=2)]),
            talk('iruka', 'Talk to Iruka-sensei', [
                say('iruka', "Spotless. Naruto, you could learn something from your friend here."),
                say('naruto', "Yeah, yeah... Hey, it looked way better with the moustaches."),
                say('iruka', "Ramen's on me. Both of you. Just... no more paint."),
            ]),
        ],
        rewards={'xp': 20, 'items': [{'id': RAMEN, 'count': 1}]}),

    Q + 'yui_first_patient': dict(
        title="Filler: Yui's First Patient", chapter=2, after=['chapter2/02_water_walking'], start='yui',
        later="Ren's ankle can wait a little... finish what you're doing, then come and help me.",
        offer=[
            say('yui', "Ren fell in the lake one too many times and twisted his ankle. He says it's fine. It's not fine."),
            say('yui', "I've got him as far as the hospital, but he won't go in. Can you meet us at the doors? He listens to you."),
        ],
        steps=[
            dict(type='goto', pos=HOSPITAL, radius=5, text="Meet Yui and Ren in the hospital's waiting room", time='day',
                 spawn=[dict(character='yui', pos=[81, G, -87], yaw=0, steps=3),
                        dict(character='ren', pos=[81, G, -86], yaw=180, steps=3, pose='sit')]),
            talk('ren', 'Talk to Ren', [
                say('ren', "It's just a scratch! A ninja doesn't go to the hospital for a scratch!"),
                say('yui', "It's swollen, Ren. Sit still."),
                say('ren', "...Fine. But if they give me a shot, I'm leaving.", [
                    choice("Even Tatsumi-sensei gets patched up.", 'ren_patched', [say('ren', "...Really? Okay. Okay, fine.")]),
                    choice("I'll race you once it's healed.", 'ren_race', [say('ren', "You're ON. Yui, fix it fast!")]),
                ]),
            ]),
            talk('yui', 'Talk to Yui', [
                say('yui', "Thank you. Medical ninjutsu can only do so much... the patient has to let you help."),
                say('yui', "Here. I made extra. If you're ever hurt, eat this."),
            ]),
        ],
        rewards={'xp': 20, 'items': [{'id': 'minecraft:golden_apple', 'count': 1}]}),
}

if __name__ == '__main__':
    for qid, q in QUESTS.items():
        write('quests/' + qid, q)
    print(len(QUESTS), 'fillers')
