import re,glob,json,os
ROOT=__import__('os').path.join(__import__('os').path.dirname(__file__), '..', 'src/main/java/net/mcreator/narutoshippudenmod/') + '/'
procs={}
for f in glob.glob(ROOT+'procedures/*.java'):
    s=open(f).read()
    for m in re.finditer(r'\n\tpublic static class (\w+)Procedure \{',s):
        end=s.find('\n\tpublic static class ',m.end()); procs[m.group(1)]=(os.path.basename(f)[:-5], s[m.start():end if end>0 else len(s)])
# item id -> procedure called in use()
items={}
for f in glob.glob(ROOT+'item/*.java'):
    s=open(f).read()
    for m in re.finditer(r'public static class (\w+) extends NarutoShippudenModElements\.ModElement \{',s):
        end=s.find('@NarutoShippudenModElements.ModElement.Tag',m.end()); body=s[m.start():end if end>0 else len(s)]
        rid=re.search(r'Registries\.ITEM, "(\w+)"',body)
        use=body[body.find('InteractionResult use('):] if 'InteractionResult use(' in body else ''
        call=re.search(r'(\w+)Procedure\s*\.executeProcedure',use)
        if rid and call: items[call.group(1)]=(m.group(1),rid.group(1))
CDRX0=r'equals\("Academy Student"\)\).{0,250}?addCooldown\(new ItemStack\(\w+\.block\), \(int\) (\d+)\).{0,250}?addCooldown\(new ItemStack\(\w+\.block\), \(int\) (\d+)\).{0,250}?addCooldown\(new ItemStack\(\w+\.block\), \(int\) (\d+)\).{0,250}?addCooldown\(new ItemStack\(\w+\.block\), \(int\) (\d+)\).{0,250}?addCooldown\(new ItemStack\(\w+\.block\), \(int\) (\d+)\)'
STATS='ninjutsu|taijutsu|kenjutsu|shurikenjutsu|summoning|kinjutsu|senjutsu|medicine|speed|genjutsu|IQ|jutsupowerstat'
out=[]
for name,(cls,body) in sorted(procs.items()):
    if not (items.get(name) and items[name][1].endswith('_technique')): continue
    shiftpos=body.find('} else if (entity.isShiftKeyDown())')
    if shiftpos<0 or 'Selected: ' not in body: continue
    main=body[:shiftpos]; shift=body[shiftpos:]
    tv=re.search(r'get\(entity\)\.(\w+) == 0\)',main)
    tvar=tv.group(1) if tv and 'technique' in tv.group(1).lower() else None
    if tvar is None:
        # a single jutsu, no selection variable
        learn=re.search(r'get\(entity\)\.(\w*learn\w*) >= (\d+)\)',main); stat=re.search(r'get\(entity\)\.(%s) >= (\d+)\)'%STATS,main)
        ch=re.search(r'ChakraAmount >= (\d+)\)',main); nm=re.search(r'"Selected: ([^"]+)"',shift)
        cds=re.findall(CDRX0,main,re.S)
        out.append(dict(proc=name,cls=cls,item=items.get(name),tvar=None,ms='Activate Mangekyou Sharingan' in body,itemcd=None,jutsu=[dict(index=0,name=nm.group(1).strip() if nm else name,
            learn=learn.groups() if learn else None,stat=stat.groups() if stat else None,chakra=int(ch.group(1)) if ch else 0,cd=[int(x) for x in cds[-1]] if cds else [0,0,0,0,0])]))
        continue
    names={}
    for m in re.finditer(r'get\(entity\)\.%s == (\d+)\).*?_setval = (\d+);.*?"Selected: ([^"]+)"'%tvar,shift,re.S):
        names[int(m.group(2))]=m.group(3)
    pos=[(m.start(),int(m.group(1))) for m in re.finditer(r'get\(entity\)\.%s == (\d+)\)'%tvar,main)]
    item_cd=re.findall(r'equals\("Academy Student"\)\) \{\s*if \(entity instanceof Player\)\s*\(\(Player\) entity\)\.getCooldowns\(\)\.addCooldown\(new ItemStack\((\w+)\.block\), \(int\) (\d+)\)',main)
    def block_end(t,i):
        i=t.index('{',i); d=0
        while True:
            c=t[i]
            if c=='"': i=t.index('"',i+1)
            elif c=='{': d+=1
            elif c=='}':
                d-=1
                if d==0: return i+1
            i+=1
    CDRX=r'equals\("Academy Student"\)\).{0,250}?addCooldown\(new ItemStack\(\w+\.block\), \(int\) (\d+)\).{0,250}?addCooldown\(new ItemStack\(\w+\.block\), \(int\) (\d+)\).{0,250}?addCooldown\(new ItemStack\(\w+\.block\), \(int\) (\d+)\).{0,250}?addCooldown\(new ItemStack\(\w+\.block\), \(int\) (\d+)\).{0,250}?addCooldown\(new ItemStack\(\w+\.block\), \(int\) (\d+)\)'
    spans=[]
    js=[]
    for i,(p,k) in enumerate(pos):
        e=block_end(main,p); spans.append((p,e))
        br=main[p:e]
        learn=re.search(r'get\(entity\)\.(\w+) >= (\d+)\)',br)
        stat=re.search(r'get\(entity\)\.(%s) >= (\d+)\)'%STATS,br)
        ch=re.search(r'ChakraAmount >= (\d+)\)',br)
        cds=re.findall(CDRX,br,re.S)
        js.append(dict(index=k,name=names.get(k,'?').strip(),learn=learn.groups() if learn else None,stat=stat.groups() if stat else None,chakra=int(ch.group(1)) if ch else 0,cd=[int(x) for x in cds[-1]] if cds else None))
    rest=main
    for p,e in reversed(spans): rest=rest[:p]+rest[e:]
    tail=re.findall(CDRX,rest,re.S)
    for j in js:
        if j['cd'] is None: j['cd']=[int(x) for x in tail[-1]] if tail else [0,0,0,0,0]
    out.append(dict(proc=name,cls=cls,item=items.get(name),tvar=tvar,ms='Activate Mangekyou Sharingan' in body,itemcd=item_cd[-1] if item_cd else None,jutsu=js))
# buy procedures
buys=[]
for name,(cls,body) in sorted(procs.items()):
    if not (name.lower().endswith('rightclicked') or name.lower().endswith('rightclick')) or 'techniquerightclick' in name.lower(): continue
    tiers=re.findall(r'get\(entity\)\.(\w+) == (\d+)\) \{\s*if \(NarutoShippudenModVariables\.get\(entity\)\.jp >= (\d+)\)(.*?)(?=\} else if \(NarutoShippudenModVariables\.get\(entity\)\.jp <=)',body,re.S)
    if not tiers: continue
    rows=[]
    sneakpos=body.find('} else if (entity.isShiftKeyDown())')
    for tm in re.finditer(r'get\(entity\)\.(\w+) == (\d+)\) \{\s*if \(NarutoShippudenModVariables\.get\(entity\)\.jp >= (\d+)\)(.*?)(?=\} else if \(NarutoShippudenModVariables\.get\(entity\)\.jp <=)',body,re.S):
        var,t,cost,blk=tm.groups(); sel=re.findall(r'get\(entity\)\.MangekyouSharinganRelease == (\d)',body[:tm.start()]); sneak=int(sel[-1]) if sel else -1
        lv=re.search(r'_setval = (\d+);\s*NarutoShippudenModVariables\.ifPresent\(entity, capability -> \{\s*capability\.(\w+) = _setval',blk)
        give=re.search(r'new ItemStack\((\w+)\.block\)',blk)
        rows.append(dict(counter=var,sneak=sneak,tier=int(t),cost=int(cost),learn=lv.groups() if lv else None,give=give.group(1) if give else None))
    buys.append(dict(proc=name,item=items.get(name),tiers=rows))
json.dump(dict(tech=out,buy=buys),open('/private/tmp/claude-501/-Users-fishyhard-Desktop-Minecraft-Mods/6560ed1d-3cd8-4983-b972-2816362ee963/scratchpad/jutsu.json','w'),indent=1)
for t in out:
    print(t['proc'],t['item'][1] if t['item'] else None,t['tvar'],t['ms'],[(j['name'][:22],j['learn'],j['chakra']) for j in t['jutsu']])
print('BUY')
for b in buys:
    if 'Mangekyou' in b['proc']: print(b['proc'],[(r['counter'][-18:],r['sneak'],r['cost']) for r in b['tiers']])
