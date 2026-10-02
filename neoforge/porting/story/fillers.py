"""Fillers: side stories between the chapters' quests, as the anime has them. Nothing in the main story waits on them; a
character offers one once the quest it follows is done, and only while no chapter quest is in progress (till then they say
its "later" line). Their ids sort after the chapters', so a character with a chapter quest to give offers that first.
Run `python3 fillers.py` to write them into both resource trees.

Ichiraku's stools, in Chikyū (the shop on the main street, its counter facing east onto the street): x -10, z 54, 56, 58,
60, the cushions on top; who sits there faces west, to the counter."""
from chapter1 import G, say, choice, talk, write

Q = 'fillers/'
RAMEN = 'naruto_shippuden:ichiraku_ramen'
ICHIRAKU = [-8, G, 57]                 # in front of the counter, on the street side


def stool(character, z, steps=2):
    """Someone sitting at Ichiraku's counter: on the stool at z, facing the counter."""
    return dict(character=character, pos=[-10, G + 0.6, z], yaw=90, steps=steps, pose='sit')


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
}

if __name__ == '__main__':
    for qid, q in QUESTS.items():
        write('quests/' + qid, q)
    print(len(QUESTS), 'fillers')
