---
layout: note
title: Zapiski
toc: true
---


# Vaje
## Dokazovanje pravilnosti programov

Kako vemo, ali program deluje pravilno? Kako vemo, kakšen program želimo sestaviti?

Ločimo med **specifikacijo** in **implementacijo** programa:

* **Specifikacija** je opis, kaj naj želeni program počne.
* **Implementacija** je konkreten program, ki počne to, kar zahteva specifikacija.

Specifikacija je lahko podana bolj ali manj natančno, v človeškem jeziku ali
zapisana v formalnem matematičnem jeziku. Zakaj potrebujemo specifikacije?
Nekateri odgovori:

* da pridobimo opis programa, ki naj bi ga sestavili
* da lahko preverimo, ali je implementacija pravilna
* zagotovimo kompatibilnost med različnimi deli programske opreme

Danes bomo spoznali le majhen košček specifikacij, t.i. Hoarovo logiko, s katero izražamo
dejstva o programih v ukaznem programskem jeziku in dokazujemo njihovo pravilnost.

## Hoarova logika

V Hoarovi logiki pišemo *Hoarove trojice*
```
    { P } c { Q }
```
kjer sta `P`in `Q` logični formuli in `c` ukaz. Formuli `P` pravimo *predpogoj* (angl.
*precondition*), formuli `Q` pravimo *končni pogoj* (ang. *postcondition*). V resnici
poznamo  dve različici trojic:

> **Delna pravilnost**: `{ P } c { Q }`
> pomeni: **Če velja `P` in če bo ukaz `c` končal, potem bo veljal `Q`**


> **Popolna pravilnost** `[ P ] c [ Q ]`
> pomeni: **Če velja `P`, potem se bo `c` končal in veljal bo `Q`.**


Zapomnimo si: delna pravilnost ne zagotavlja, da se bo `c` končal, popolna pravilnost to
zagotavlja.

#### Primer 1

Program `c` zamenja vrednosti spremenljivk `x` in `y`:
```
    { x = m ∧ y = n } c { x = n ∧ y = m }
```
Tu moramo predpostaviti, da sta `m` in `n` *duhova* (angl. ghost variable), se pravi
spremenljivki, ki se ne pojavljata v `c`.

#### Primer 2

Program `c` poskrbi, da je `x` manjši ali enak `y`:
```
    { true } c { x ≤ y }
```
Ali znamo zapisati tak program? Da, na primer
```
    x := 0 ; y := 1
```
Specifikacija to dovoli. Verjetno smo hoteli v resnici tole:
```
    { x = m ∧ y = n } c { x = min(m, n) ∧ y = max(m, n) }
```
Ko delamo s Hoarovo logiko, običajno pišemo pogoje in kodo navpično, da lahko med vrstice
vrivamo pogoje.
```
    { x = m ∧ y = n }
    c
    { x = min(m, n) ∧ y = max(m, n) }
```
Seveda potrebujemo nekakšna pravila sklepanja.

## Pravila sklepanja

Za Hoarovo logiko veljajo naslednja pravila sklepanja.

### Splošna pravila

Vedno smemo uporabiti veljavno logično in matematično sklepanje, na primer:
```
    P' ⇒ P    { P } c { Q }      Q ⇒ Q'
    ——————————————————————————————————–
              { P' } c { Q' }


    { P₁ } c { Q₁ }     { P₂ } c { Q₂ }
    ——————————————————————————————————–
         { P₁ ∧ P₂ } c { Q₁ ∧ Q₂ }
```
Naj bodo `FV(P)` vse spremenljivke, ki se pojavljajo v formuli `P` (free variables)
in `FA(c)` vse spremnljivke, ki jih `c` nastavlja (assigned variables). Na primer:
```
    FV(x ≤ y ∨ x > 0) = {x, y}

    FA(if x < y then x := y + 3 else skip end) = { x }
```
Velja pravilo:
```
    FV(P) ∩ FA(c) = ∅
    —————————————————
      { P } c { P }
```
#### Pravilo za `skip`
```
    ———————————————–
    { P } skip { P }
```
#### Pravilo za pogojni stavek
```
    { P ∧ b } c₁ { Q }       { P ∧ ¬b } c₂ { Q }
    ———————————————————————————————————————————–
        { P } if b then c₁ else c₂ end { Q }
```
#### Pravilo za `c₁ ; c₂`
```
    { P } c₁ { Q }      { Q } c₂ { R }
    —————————————————————————————————–
           { P } c₁ ; c₂ { R }
```
#### Pravilo za zanko `while`
```
            { P ∧ b } c { P }
    —————————————————-————————————————–
    { P } while b do c done { ¬ b ∧ P }
```
Formuli `P` pravimo *invarianta* zanke `while`.

#### Pravilo za prirejanje
```
    ————————————————————————–
    { P[x ↦ e] } x := e { P }
```
Zapis `P[x ↦ e]` pomeni "v izjavi `P` zamenjaj `x` z `e`"

### Popolna pravilnost

Vsa zgornja pravila, razen dveh, lahko predelamo v popolno pravilnost, na primer:
```
    [ P ∧ b ] c₁ [ Q ]       [ P ∧ ¬b ] c₂ [ Q ]
    ———————————————————————————————————————————–
        [ P ] if b then c₁ else c₂ end [ Q ]
```
Prva izjema je pravilo
```
    FV(P) ∩ FA(c) = ∅
    —————————————————
      { P } c { P }
```
ki ga predelamo takole
```
    FV(P) ∩ FA(c) = ∅    [ R ] c [ Q ]
    ——————————————————————————————————
          [ R ∧ P ] c [ Q ∧ P ]
```
(Opomba: pravilo
```
    FV(P) ∩ FA(c) = ∅
    —————————————————
      [ P ] c [ P ]
```
*ni* veljavno. Če bi bilo, bi lahko dokazali
```
    [ x > 0 ] while true do skip done [x > 0]
```
kar pa ne velja.)

Pri zanki `while` zagotovimo, da se bo končala, tako da poiščemo količino, ki se
zmanjšuje, a se ne more zmanjševati v nedogled. Na primer, to je lahko celoštevilska
pozitivna vrednost.

*Pozor:* realna pozitivna vrednost se lahko zmanjšuje v nedogled:
```
    0.1 > 0.01 > 0.001 > 0.0001 > ...
```
Tudi celoštevilska vrednost se lahko zmanjšuje v nedogled:
```
    2 > 1 > 0 > -1 > -3 > -5 > -7 > ....
```
Pravilo za popolno pravilnost `while` se glasi:

Naj bo `e` količina, ki se ne more v nedogled zmanjševati (na primer naravno število):
```
        [ P ∧ b ∧ e = z ] c [P ∧ e < z ]
     —————————————————————————————————————
      [ P ] while b do c done [ ¬ b ∧ P ]
```
V tem pravilu je `z` duh.
Kako pa ta pravila v praksi uporabljamo? Poglejmo nekaj primerov.

## Primeri

### Primer 1

Zapiši s Hoarovo logiko:

1. Program `c` se ne ustavi.

2. Program `c` se ustavi.

### Primer 2

Dokaži pravilnost programa:
```
    { x ≤ 7 }
    x := x + 3
    { x ≤ 10 }
```
### Primer 3

Dokaži pravilnost programa:
```
    { x ≤ y }
    s := (x + y) / 2
    { x ≤ s ≤ y }
```
### Primer 4

Dogovor: namesto `P ∧ Q` pišemo tudi `P, Q`

Dokaži pravilnost programa:
```
    [ b ≥ 0 ]
    i := 0 ;
    p := 1 ;
    while i < b do
       p := p * a ;
       i := i + 1
    done
    [ p = a ^ b ]
```
Rešitev:
```
    { b ≥ 0 }
    i := 0 ;
    { b ≥ 0, i = 0 }
    p := 1 ;
    { b ≥ 0, i = 0, p = 1 } # logično sklepamo, je zelo easy
    { p = a ^ i, i ≤ b }
    while i < b do
       { i < b, p = a ^ i, i ≤ b }
       # iz p = a^i sledi p·a = a^(i+1)
       # iz i < b sledi i+1 < b+1 sledi i+1 ≤ b (ker i, b celi števili)
       { p · a = a ^ (i + 1), (i + 1) ≤ b }
       p := p * a ;
       { p = a ^ (i + 1), (i + 1) ≤ b }
       i := i + 1
       { p = a ^ i, i ≤ b }
    done
    { i ≥ b, p = a ^ i, i ≤ b } # očitno
    { i = b, p = a ^ i } # očitno
    { p = a ^ b }
```
Popolna pravilnost: zmanjšuje se celoštevilska količina `e = b - i ≥ 0`.
Imamo invarianto `Q ≡ (p = a ^ i ∧ i ≤ b)`
```
    while i < b do
       [ Q, i < b, b - i = z ]
       [ i < b, b - i = z ]
       p := p * a ;
       [ i < b, b - i = z ]
       ⇒
       [ b - i = z ]
       ⇔
       [ b = z + i ]
       ⇒
       [ b < z + i + 1 ]
       ⇔ 
       [ b - i - 1 < z ]
       ⇔
       [ b - (i+1) < z ]
       i := i + 1
       [ b - i < z ]
    done
```
### Primer 5

Dokaži pravilnost programa:
```
    [x = m ∧ y = n]
    if y < x then
       x := x + y ;
       y := x - y ;
       x := x - y
    else
       skip
    end
    [ x = min(m, n) ∧ y = max(m, n) ]
```
Rešitev:
```
    [x = m ∧ y = n]
    if y < x then
       [ y < x, x = m ∧ y = n]
       [ n < m, x = m ∧ y = n]
       [ y = n = min(m, n) ∧ x = m = max(m, n) ]
       [ (x+y)-((x+y)-y) = min(m, n) ∧ ((x+y)-y) = max(m, n) ]
       x := x + y ;
       [ x-(x-y) = min(m, n) ∧ (x-y) = max(m, n) ]
       y := x - y ;
       [ x-y = min(m, n) ∧ y = max(m, n) ]
       x := x - y
       [ x = min(m, n) ∧ y = max(m, n) ]
    else
       [x ≤ y, x = m ∧ y = n]
       [m ≤ n, x = m ∧ y = n]
       skip
       [ m ≤ n, x = m ∧ y = n ] # očitno sledi
       [ x = min(m, n) ∧ y = max(m, n) ]
    end
    [ x = min(m, n) ∧ y = max(m, n) ]
```
## Dokazovanje pravilnosti (Naloge)

Pri dokazovanju pravilnosti si lahko pomagamo z naslednjimi splošnimi nasveti.

* Po stavku `x := N` vedno velja `{ x = N }`. Formalno to dokažemo tako: `{ N = N } x := N { x = N }`.
* Pravilo za prireditveni stavek je `{ P[x ↦ e] } x := e { P }`. Pri izpeljevanju najprej vse `x`-e v predpogoju izrazimo z `e`, nato pa `e`-je zamenjamo z `x`.
* V zančni invarianti se zančni pogoj in lokalne spremenljivke ne pojavljajo, saj mora invarianta veljati tudi po izstopu iz zanke. Ko invarianto »peljemo« čez telo zanke, se nam v njej lahko pojavijo lokalne spremenljivke. Teh se želimo znebiti, ko dosežemo konec zanke.
* Na koncu zanke se lahko izkaže, da je invarianta prešibka in iz nje ne moremo izpeljati končnega pogoja. V tem primeru lahko v invarianto dodamo še kak pogoj in ga ločeno peljemo čez zanko. To ne bo nikoli pokvarilo obstoječe izpeljave: če velja `A ⇒ C`, potem velja tudi `A ∧ B ⇒ C`.

### Naloga 1

Dokažite parcialno in popolno pravilnost programa glede na dano specifikacijo.
```
    { x = m ∧ y = n } ⇒
    { - (- y) = n ∧ x = m } ⇒
    { x + y - (x + y - y) = n ∧ x + y - y = m }
    x := x + y;
    { x - (x - y) = n ∧ x - y = m }
    y := x - y;
    { x - y = n ∧ y = m }
    x := x - y;
    { x = n ∧ y = m }
```
#### Rešitev 1

### Naloga 2

Dokažite parcialno in popolno pravilnost programa glede na dano specifikacijo.
```
    { true }
    if y < x then
      { true ∧ y < x } ⇒
      { y ≤ x }
      z := x;
      { y ≤ z }
      x := y;
      { x ≤ z }
      y := z
      { x ≤ y }
    else
      { true ∧ y ≥ x } ⇒
      { x ≤ y }
      skip
      { x ≤ y }
    end
    { x ≤ y }
```
#### Rešitev 2

### Naloga 3

Sestavite program `c`, ki zadošča specifikaciji
```
    [ n ≥ 0 ]
    c
    [ s = 1 + 2 + ... + n ]
```
in dokažite njegovo pravilnost.

#### Rešitev 3
```
  { n ≥ 0 } ⇒
  { n ≥ 0 ∧ 0 = 0 }
  x := 0 ;
  { n ≥ 0 ∧ x = 0 }
  s := 0 ;
  { n ≥ 0 ∧ x = 0 ∧ s = 0 } ⇒
  { s = 1 + 2 + ... + (x - 1) ∧ x ≤ n + 1 }
  while x <= n do
    { s = 1 + 2 + ... + (x - 1) ∧ x ≤ n + 1 ∧ x ≤ n } ⇒
    { s = 1 + 2 + ... + (x - 1) ∧ x ≤ n } <=>
    { s + x = 1 + 2 + ... + (x -1 + 1) ∧ x + 1 ≤ n + 1 }
    s := s + x;
    { s = 1 + 2 + ... + (x - 1 + 1) ∧ x + 1 ≤ n + 1 }
    x := x + 1
    { s = 1 + 2 + ... + (x - 1) ∧ x ≤ n + 1 }
  done
  { ¬ (x ≤ n) ∧ P } <=>
  { x > n ∧ s = 1 + 2 + ... + (x - 1) ∧ x ≤ n + 1 } <=>
  { x = n + 1 ∧ s = 1 + 2 + ... + (x - 1) } ⇒
  { s = 1 + 2 + ... + n }


  [ n ≥ 0 ] ⇒
  [ n ≥ 0 ∧ 0 = 0 ]
  x := 0 ;
  [ n ≥ 0 ∧ x = 0 ]
  s := 0 ;
  [ n ≥ 0 ∧ x = 0 ∧ s = 0 ] ⇒
  [ s = 1 + 2 + ... + (x - 1) ∧ x ≤ n + 1 ] // n - x ≥ -1
  while x <= n do
    [ s = 1 + 2 + ... + (x - 1) ∧ x ≤ n + 1 ∧ x ≤ n ∧ n - x = z ] ⇒
    [ s = 1 + 2 + ... + (x - 1) ∧ x ≤ n ∧ n - x = z ] <=>
    [ s + x = 1 + 2 + ... + (x -1 + 1) ∧ x + 1 ≤ n + 1 ∧ n - x = z ]
    s := s + x;
    [ s = 1 + 2 + ... + (x - 1 + 1) ∧ x + 1 ≤ n + 1 ∧ n - x = z ]
    [ s = 1 + 2 + ... + (x - 1 + 1) ∧ x + 1 ≤ n + 1 ∧ n - (x + 1 - 1) = z ]
    x := x + 1
    [ s = 1 + 2 + ... + (x - 1) ∧ x ≤ n + 1 ∧ n - (x - 1) = z ] ⇒
    [ s = 1 + 2 + ... + (x - 1) ∧ x ≤ n + 1 ∧ n - x = z - 1 < z ] ⇒
    [ s = 1 + 2 + ... + (x - 1) ∧ x ≤ n + 1 ∧ n - x < z ]
  done
  [ ¬ (x ≤ n) ∧ P ] <=>
  [ x > n ∧ s = 1 + 2 + ... + (x - 1) ∧ x ≤ n + 1 ] <=>
  [ x = n + 1 ∧ s = 1 + 2 + ... + (x - 1) ] ⇒
  [ s = 1 + 2 + ... + n ]
```
### Naloga 4

Dokažite parcialno in popolno pravilnost programa glede na dano specifikacijo.
```
    { x ≥ 0 }
    y := 0;
    z := x;
    while 1 < z - y do
      s := (y + z)/2;
      if s * s < x then
        y := s
      else
        z := s
      end
    done
    { y² ≤ x ≤ (y+1)² }
```
#### Rešitev 5

