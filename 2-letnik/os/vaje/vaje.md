---
layout: note
title: Operacijski Sistemi - Izpiski vaj
---
<!-- #region -->
- [Ukazna lupina](#ukazna-lupina)
  - [Ukazna vrstica](#ukazna-vrstica)
  - [Se vec ukazov](#se-vec-ukazov)
  - [Premikanje po datotecnem sistemu](#premikanje-po-datotecnem-sistemu)
- [Skriptiranje - osnovni gradniki](#skriptiranje---osnovni-gradniki)
<!-- #endregion -->

## Ukazna lupina
### Ukazna vrstica
- preko ukazne vrstice vnasamo ukaze
- `student@stroj:~>` - pozivnik
- **osnovni ukazi:** `echo, printf, logout, cat, date, ls, cd, ...`
- **naprednejsi ukazi**
  - **stikala** → `-x`
  - **sestavljeni** → `<ukaz> && <ukaz> && ...`
  - skripte
- okno konzole je kot **neskoncen trak**
- `[Tab]` → avtomatsko dopolnjevanje (path, imena datotek)
- `Ctrl + C` → prekinitev izvajanja
- `Ctrl + Z` → zaustavitev izvajanja
- `Ctrl + D` → konec vnosa

### Se vec ukazov
- `cat, less, head, tail` → izpis vsebine
- `sort` → urejanje vrstic
- `shuf` → permutiranje vrstic
- `uniq` → odstranjevanje duplikatov
- `nl` → stevilcenje vrstic
- `rev` → obrat vrstic
- `tr` → spreminjanje znakov
- `cut` in `paste` → obdelava stolpcev
- `wc` → stetje besed
- `cmp` → primerjava vsebine
- `split` → sekanje
- `comm, diff in patch` → ugotavljanje razlik
- `grep` in `egrep <regex>` → iskanje v datotekah
- `sed -r 'naslovs/ri/niz` → urejevalnik toka podatkov
- `awk`

### Premikanje po datotecnem sistemu
- `cd <imenik>` → vstop v imenik
- **relativno** → `cd ../../abc`
- **absolutno** → `cd /usr/abc/def/`
- `pwd` → trenutna lokacija

## Skriptiranje - osnovni gradniki