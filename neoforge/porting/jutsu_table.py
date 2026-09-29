import re,glob,json,os
ROOT=__import__('os').path.join(__import__('os').path.dirname(__file__), '..', 'src/main/java/net/mcreator/narutoshippudenmod/') + '/'
HERE=os.path.dirname(os.path.abspath(__file__))
d=json.load(open(os.path.join(HERE,'jutsu.json')))
# item class -> registry id
cls2id={}
for f in glob.glob(ROOT+'item/*.java'):
    s=open(f).read()
    for m in re.finditer(r'public static class (\w+) extends NarutoShippudenModElements\.ModElement \{\s*public static Item block;\s*static \{\s*Registration\.holder\(Registries\.ITEM, "(\w+)"',s):
        cls2id[m.group(1)]=m.group(2)
proc_cls={}
for f in glob.glob(ROOT+'procedures/*.java'):
    for m in re.finditer(r'\n\tpublic static class (\w+)Procedure \{',open(f).read()): proc_cls[m.group(1)]=os.path.basename(f)[:-5]
STATNAME={'ninjutsu':'Ninjutsu','taijutsu':'Taijutsu','genjutsu':'Genjutsu','IQ':'IQ','jutsupowerstat':'Jutsu Power'}
FIX={'?':'Detachment of the Primitive World','Human Beast Mixture Transformation \\u2014 Three-Headed Wolf':'Human Beast Mixture Transformation: Three-Headed Wolf'}
lines=[]
techs={}
for t in d['tech']:
    prefix=t['proc'][:-len('TechniqueRightclicked')]
    item=t['item'][1] if t['item'] else cls2id.get(prefix+'TechniqueItem')
    if not item or not t['jutsu']: continue
    tv=t['tvar']
    js=[]
    ms='v -> v.MangekyouSharinganActivate' if t.get('ms') else 'null'
    for j in t['jutsu']:
        lv,tier=j['learn'] if j['learn'] and 'learn' in j['learn'][0] else (None,None)
        if lv is None:
            lv=next((x['learn'][0] for x in t['jutsu'] if x['learn'] and 'learn' in x['learn'][0]),None); tier=str(j['index']+1)
        st=j['stat'] or (None,'0')
        name=FIX.get(j['name'],j['name']).replace('"','\\"')
        stat='%s, v -> v.%s, %s'%('"%s"'%STATNAME[st[0]] if st[0] else 'null', st[0] if st[0] else 'ninjutsu', st[1])
        js.append('jutsu("%s", v -> v.%s, %s, %s, %d, %s)'%(name,lv,tier,stat,j['chakra'],', '.join(map(str,j['cd']))))
    techs[item]=lv if tv or True else lv
    sel='v -> v.%s, (v, i) -> v.%s = i'%(tv,tv) if tv else 'v -> 0, (v, i) -> {}'
    lines.append('\t\ttechnique("%s", %s, %s, %s.%sProcedure::executeProcedure,\n\t\t\t\t%s);'%(item,sel,ms,proc_cls[t['proc']],t['proc'],',\n\t\t\t\t'.join(js)))
# technique items whose procedures have no "Selected:" branches, written by hand
CD=lambda *t: ', '.join(map(str,t))
EXTRA=[('shadow_clone_technique','ClanProcedures','ShadowCloneTechniqueRightclicked','jutsu("Shadow Clone Technique", v -> 1, 1, "Ninjutsu", v -> v.ninjutsu, 5, 30, %s)'%CD(25,25,25,25,25)),
	('tsuchigumo_release_technique','ClanProcedures','TsuchigumoReleaseFuryRightclicked','jutsu("Fury", v -> v.tsuchigumolearn, 1, "Ninjutsu", v -> v.ninjutsu, 20, 300, %s)'%CD(200,160,120,80,40)),
for element in ('Fire','Earth','Water','Wind','Lightning'):
	# the chakra cost is chosen when the jutsu is created, so the procedure checks it
	EXTRA.append(('custom_%s_release_technique'%element.lower(),'CustomJutsuProcedures','Custom%sReleaseTechniqueRight%sedProcedure'%(element,'click' if element=='Fire' else 'Click'),
		'jutsu("Custom Jutsu", v -> 1, 1, "Ninjutsu", v -> v.ninjutsu, 5, 0, %s)'%CD(60,50,40,30,20)))
for item,cls,proc,j in EXTRA:
	proc=proc if proc.endswith('Procedure') else proc+'Procedure'
	lines.append('\t\ttechnique("%s", v -> 0, (v, i) -> {}, null, %s.%s::executeProcedure,\n\t\t\t\t%s);'%(item,cls,proc,j))
rel=[]
for b in d['buy']:
    if not b['item']: continue
    groups={}
    for r in b['tiers']: groups.setdefault(r['counter'],[]).append(r)
    tracks=[]
    for counter,tiers in groups.items():
        if [r['tier'] for r in tiers]!=list(range(len(tiers))): break
        learnvar=next((r['learn'][1] for r in tiers if r['learn']),None)
        tech=next((cls2id.get(r['give']) for r in tiers if r['give'] and cls2id.get(r['give']) in techs),None)
        if tech is None and learnvar: tech=next((i for i,lv in techs.items() if lv==learnvar),None)
        label='Susanoo' if 'susano' in counter else ''
        parts=', '.join('tier(%d, %s, %s)'%(r['cost'], r['learn'][0] if r['learn'] else '0', '"%s"'%cls2id[r['give']] if r['give'] and cls2id.get(r['give']) else 'null') for r in tiers)
        tracks.append('track("%s", v -> v.%s, %d, %s, %s,\n\t\t\t\t\t%s)'%(label,counter,tiers[0]['sneak'],'"%s"'%tech if tech else 'null','v -> v.%s'%learnvar if learnvar else 'null',parts))
    else:
        rel.append('\t\trelease("%s", %s.%sProcedure::executeProcedure,\n\t\t\t\t%s);'%(b['item'][1],proc_cls[b['proc']],b['proc'],',\n\t\t\t\t'.join(tracks)))
imports=sorted({proc_cls[t['proc']] for t in d['tech']}|{proc_cls[b['proc']] for b in d['buy']}|{e[1] for e in EXTRA})
out='''package net.mcreator.narutoshippudenmod.core.jutsu;

%s

import static net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.jutsu;
import static net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.release;
import static net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.technique;
import static net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.tier;
import static net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.track;

/**
 * Every technique item and release scroll, read out of the MCreator procedures (porting/jutsu_table.py). Each jutsu:
 * name, unlock (learn variable and tier), stat requirement, chakra cost, cooldown in ticks for Academy Student, Genin,
 * Chunin, Jonin and Kage. Each release: its bought counter, the procedure that buys the next tier, the technique item
 * and learn variable it unlocks, and per tier the JP price, learn value and item given.
 */
final class JutsuTable {
	private JutsuTable() {
	}

	static void register() {
%s

%s
	}
}
'''%('\n'.join('import net.mcreator.narutoshippudenmod.procedures.%s;'%c for c in imports),'\n'.join(lines),'\n'.join(rel))
open(os.path.join(HERE,'override/net/mcreator/narutoshippudenmod/core/jutsu/JutsuTable.java'),'w').write(out)
print(len(lines),'techniques',sum(l.count('jutsu(') for l in lines),'jutsu',len(rel),'releases')
