"""Writes the Shinobi Merchant's trades (and the Ryo villager trades) into res_override and src/main/resources.

Prices are in Bronze Ryo: 9 Bronze = 1 Silver, 9 Silver = 1 Gold. Each trade set is (amount shown per merchant, max uses, trades).
"""
import json
import os

HERE = os.path.dirname(os.path.abspath(__file__))
ROOTS = [os.path.join(HERE, 'res_override'), os.path.join(HERE, '..', 'src', 'main', 'resources')]
NS = 'naruto_shippuden'
S, G = 9, 81

VILLAGES = ['konohagakure', 'sunagakure', 'kirigakure', 'kumogakure', 'iwagakure']
HEADBAND_COLORS = ['', 'black_', 'red_']

# only everyday shinobi gear: character weapons (Seven Swordsmen blades, Asuma's chakra blades...), clan items, headbands and
# chakra paper come from the story, clans and villages, never from a shop
SETS = {
    'tools': (4, 16, [('kunai', 4, 4), ('shuriken', 8, 4), ('poison_kunai', 4, S), ('explosive_kunai', 2, 2 * S),
                      ('sharp_iron', 2, 3), ('iron_stick', 4, 2)]),
    'weapons': (2, 3, [('tanto', 1, S + 4), ('katana', 1, 3 * S)]),
    'food': (2, 16, [('ichiraku_ramen', 1, 4), ('minecraft:bread', 3, 2), ('minecraft:cooked_salmon', 2, 3)]),
}
# what the merchant buys: (vanilla item, count, paid in bronze)
BUYING = (2, 12, [('rotten_flesh', 16, 2), ('bone', 12, 2), ('string', 12, 2), ('gunpowder', 6, 3), ('ender_pearl', 2, S),
                  ('iron_ingot', 4, 4), ('gold_ingot', 3, S), ('diamond', 1, 2 * S), ('emerald', 2, S)])


def coins(bronze):
    """Up to two cost stacks for a price (the merchant screen takes two)."""
    stacks = [('gold_ryo', bronze // G), ('silver_ryo', bronze % G // S), ('bronze_ryo', bronze % S)]
    stacks = [(item, n) for item, n in stacks if n]
    if len(stacks) > 2:  # fold bronze into silver-and-bronze of the remainder
        stacks = [stacks[0], ('bronze_ryo', bronze % G)]
    return [{'id': '%s:%s' % (NS, item), 'count': n} for item, n in stacks]


def write(rel, data):
    for root in ROOTS:
        path = os.path.join(root, rel)
        os.makedirs(os.path.dirname(path), exist_ok=True)
        with open(path, 'w') as f:
            json.dump(data, f, indent=2)
            f.write('\n')


def trade(wants, gives, max_uses):
    data = {'wants': wants[0], 'gives': gives, 'max_uses': max_uses, 'xp': 0, 'reputation_discount': 0.0}
    if len(wants) > 1:
        data['additional_wants'] = wants[1]
    return data


def trade_set(name, amount, trades):
    ids = []
    for trade_id, data in trades:
        write('data/%s/villager_trade/shinobi_merchant/%s/%s.json' % (NS, name, trade_id), data)
        ids.append('%s:shinobi_merchant/%s/%s' % (NS, name, trade_id))
    write('data/%s/tags/villager_trade/shinobi_merchant/%s.json' % (NS, name), {'values': ids})
    write('data/%s/trade_set/shinobi_merchant/%s.json' % (NS, name),
          {'amount': amount, 'random_sequence': '%s:trade_set/shinobi_merchant/%s' % (NS, name), 'trades': '#%s:shinobi_merchant/%s' % (NS, name)})


for name, (amount, uses, items) in SETS.items():
    trade_set(name, amount, [(item.split(':')[-1], trade(coins(price), {'id': item if ':' in item else '%s:%s' % (NS, item), 'count': count}, uses))
                             for item, count, price in items])
amount, uses, items = BUYING
trade_set('buying', amount, [(item, trade([{'id': 'minecraft:' + item, 'count': count}], coins(price)[0], uses)) for item, count, price in items])

# villagers take Ryo too
write('data/%s/villager_trade/farmer/1/ichiraku_ramen.json' % NS, trade(coins(4), {'id': NS + ':ichiraku_ramen'}, 10))
write('data/%s/villager_trade/weaponsmith/1/chakra_blade.json' % NS, trade(coins(G), {'id': NS + ':chakra_blade'}, 1))
print('trade sets:', ', '.join(list(SETS) + ['buying']))
