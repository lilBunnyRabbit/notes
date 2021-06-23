---
layout: note
title: Principi Programskih Jezikov - Zapiski
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


# Vaje 6: Induktivni podatkovni tipi — AVL drevesa

Implementirali bomo [AVL drevesa](https://en.wikipedia.org/wiki/AVL_tree) v jeziku OCaml. AVL drevo je dvojiško iskalno drevo, v katerem se za vsako vozlišče višini levega in desnega poddrevesa razlikujeta za največ 1.

## Podatkovni tip AVL drevo

V splošnem bi želeli v iskalnih drevesih hraniti poljubne podatke, ki jih lahko primerjamo po velikosti. Tu bomo nalogo poenostavili tako, da bomo v drevesih hranili le cela števila (`int`).

AVL drevo je:

* bodisi prazno (`Empty`)
* bodisi vozlišče (`Node`), sestavljeno iz:
    * vsebine (števila),
    * višine drevesa in
    * levega ter desnega AVL poddrevesa.

**Naloga:** definirajte podatkovni tip `avltree`, ki opisuje AVL drevesa.


```OCaml
(* rešitev *)
type avltree = Empty | Node of int * int * avltree * avltree
```




    type avltree = Empty | Node of int * int * avltree * avltree




Spodnja funkcja `showTreeHorizontally : avltree -> unit` grafično prikaže vhodno drevo `t` po nivojih.


```OCaml
let showTreeHorizontally t = 
    let rec strign_of_avltree_level lvl = function 
        | Empty -> if lvl = 0 then "nil" else "   " 
        | Node (n, h, l, r) ->
              let make_space = String.map (fun _ -> ' ') in
              let sn = string_of_int n in
              let sl = strign_of_avltree_level lvl l in
              let sr = strign_of_avltree_level lvl r in
                  if h = lvl
                  then make_space sl ^ sn ^ make_space sr
                  else sl ^ make_space sn ^ sr
    in
    let rec print_levels lvl =
        if lvl >= 0
        then (print_string (string_of_int lvl ^ ": " ^ strign_of_avltree_level lvl t ^ "\n");
            print_levels (lvl-1))
        else ()
    in
    let height = function
        | Node (_, y, _, _) -> y
        | Empty -> 0
    in
    print_levels (height t) ; flush stdout
```




    val showTreeHorizontally : avltree -> unit = <fun>




**Naloga:** definirajte AVL drevo `t`:

        5
       / \
      3   8
     / \
    1   4


```OCaml
(* rešitev *)
let t = Node (5, 3,
    Node (3, 2,
        Node (1, 1, Empty, Empty),
        Node (4, 1, Empty, Empty)),
    Node (8, 1, Empty, Empty))
;;
showTreeHorizontally t
```




    val t : avltree =
      Node (5, 3,
       Node (3, 2, Node (1, 1, Empty, Empty), Node (4, 1, Empty, Empty)),
       Node (8, 1, Empty, Empty))




    3:                5       
    2:        3               
    1:    1       4       8   
    0: nil nil nil nil nil nil





    - : unit = ()




## Pametni konstruktor

**Naloga:** definirajte funkcijo `height : avltree -> int`, ki vrne višino drevesa.
Primera:
    
    # height Empty ;;
    - : int = 0
    # height t ;;
    - : int = 3



```OCaml
(* rešitev *)
let height t = match t with
| Empty -> 0
| Node (_, h, _, _) -> h
;; height Empty
```




    val height : avltree -> int = <fun>







    - : int = 0




**Naloga:** definirajte "pametna" konstruktorja `leaf: int -> avltree` in `node: int * avltree * avltree -> avltree`, ki sama poskrbita za višino. Prav vam bo prišla funkcija `max: int -> int -> int`, ki vrne večjega od dveh števil. Primer uporabe:

    # let six = leaf 6 ;;
    val six : avltree = Node (6, 1, Empty, Empty)
    # let seven = leaf 7 ;;
    val seven : avltree = Node (7, 1, Empty, Empty)
    # let answer = node (42, six, seven) ;;
    val answer : avltree =
       Node (42, 2, Node (6, 1, Empty, Empty), Node (7, 1, Empty, Empty))


```OCaml
(* rešitev *)
let leaf e = Node (e, 1, Empty, Empty)

let node (x, l, r) = Node (x, 1 + max (height l) (height r), l, r)
```




    val leaf : int -> avltree = <fun>







    val node : int * avltree * avltree -> avltree = <fun>





```OCaml
let six = leaf 6 ;;
let seven = leaf 7 ;;
let answer = node (42, six, seven) ;;
```




    val six : avltree = Node (6, 1, Empty, Empty)







    val seven : avltree = Node (7, 1, Empty, Empty)







    val answer : avltree =
      Node (42, 2, Node (6, 1, Empty, Empty), Node (7, 1, Empty, Empty))




**Naloga:** s pametnimi konstruktorji definirajte AVL drevo, enako drevesu `t` iz prejšnje naloge.


```OCaml
(* rešitev *)
let t = node (5,
    node (3,
        leaf 1,
        leaf 4),
    leaf 8)
;;
showTreeHorizontally t
```




    val t : avltree =
      Node (5, 3,
       Node (3, 2, Node (1, 1, Empty, Empty), Node (4, 1, Empty, Empty)),
       Node (8, 1, Empty, Empty))




    3:                5       
    2:        3               
    1:    1       4       8   
    0: nil nil nil nil nil nil





    - : unit = ()




## Drevo ⇒ seznam

**Naloga:** definirajte funkcijo `toList: avltree -> int list`, ki elemente drevesa vrne kot urejen seznam števil. Za združevanje seznamov ima OCaml operator `@`.


```OCaml
(* rešitev *)
(* function ~ fun x -> match x with ... *)

let rec toList = function
| Empty -> []
| Node (x, _, l, r) -> toList l @ x :: toList r

(* ena izmed neučinkovitih implementacij stikanja seznamov *)
let rec join_list xs ys = match xs with
    | [] -> ys
    | glava :: rep -> glava :: join_list rep ys
```




    val toList : avltree -> int list = <fun>







    val join_list : 'a list -> 'a list -> 'a list = <fun>





```OCaml
showTreeHorizontally t;;
toList t;;
toList answer;;
```

    3:                5       
    2:        3               
    1:    1       4       8   
    0: nil nil nil nil nil nil





    - : unit = ()







    - : int list = [1; 3; 4; 5; 8]







    - : int list = [6; 42; 7]




## Iskanje

Algoritem, ki ugotovi, ali je dani `x` v drevesu `t`:

* če je `t` prazno drevo, se `x` ne pojavi;
* če je `t` vozlišče z vsebino `y` in poddrevesoma `l` ter `r`:
    * če je `x = y`, se `x` pojavi;
    * če je `x < y`, iščemo v poddrevesu `l`;
    * če je `x > y`, iščemo v poddrevesu `r`.

Iskanje bomo implementirali s funkcijo `search`, ki naj deluje tako:

    # search 5 t ;;
    - : bool = true

**Naloga** zapišite *tip* funkcije `search`, ki ugotovi, ali drevo `t` vsebuje vrednost `x`.


```OCaml
(* rešitev *)
(* search : int -> avltree -> bool *)
```

**Naloga** definirajte funkcijo `search`. Za primerjanje dveh števil uporabite funkcijo `cmp` s predavanj, ki vrne vrednost tipa `order`:   


```OCaml
type order = Less | Equal | Greater

let cmp x y =
    match compare x y with
    | 0 -> Equal
    | r when r < 0 -> Less
    | _ -> Greater
```




    type order = Less | Equal | Greater







    val cmp : 'a -> 'a -> order = <fun>





```OCaml
(* rešitev *)
let rec search x t = match t with
| Empty -> false
| Node (y, _, l, r) ->
    begin match cmp x y with
    | Less -> search x l
    | Equal -> true
    | Greater -> search x r
    end

(* počasni rešitevi *)
let rec search_slow2 x = function
| Empty -> false
| Node (y, _, l, r) -> x = y || search_slow2 x l || search_slow2 x r

let search_slow e t = List.mem e (toList t)
```




    val search : int -> avltree -> bool = <fun>







    val search_slow2 : int -> avltree -> bool = <fun>







    val search_slow : int -> avltree -> bool = <fun>




**Naloga:** preizkusite, ali `search` deluje.


```OCaml
(* rešitev *)
t ;;
search 3 t;;
search 2 t
```




    - : avltree =
    Node (5, 3,
     Node (3, 2, Node (1, 1, Empty, Empty), Node (4, 1, Empty, Empty)),
     Node (8, 1, Empty, Empty))







    - : bool = true







    - : bool = false




## Vrtenje in uravnoteženje

Pri vstavljanju ali brisanju elementov se lahko AVL drevo "pokvari": višina levega in desnega poddrevesa nekega poddrevesa se razlikujeta za več kot 1. To popravimo z vrtenjem (rotacijo) drevesa okrog korena.

**Naloga:** definirajte funkcijo `imbalance: avltree -> int`, ki vrne stopnjo neuravnoteženosti drevesa, tj. razliko med višinama levega in desnega poddrevesa.

    # imbalance t ;;
    - : int = 1
    # imbalance Empty ;;
    - : int = 0       


```OCaml
(* rešitev *)
let imbalance = function
| Empty -> 0
| Node (_, _, l, r) -> height l - height r ;;

imbalance t;;
imbalance answer;;
```




    val imbalance : avltree -> int = <fun>







    - : int = 1







    - : int = 0




V AVL drevesu je lahko neuravnoteženost kateregakoli vozlišča največ 1. Bolj neuravnotežena poddrevesa lahko popravimo z vrtenjem v levo oziroma desno. Vrtenje v levo oziroma desno ponazorimo z diagramom

         x                      y
       /   \       levo       /   \
      +     y       ==>      x     +
     /a\   / \              / \   /c\
     ---  +   +     <==    +   +  ---
         /b\ /c\   desno  /a\ /b\
         --- ---          --- ---
         
**Naloga:** definirajte funkciji `rotateLeft` in `rotateRight`, ki dano drevo zavrtita na prikazan način. Če to ni mogoče (ker je drevo npr. prazno ali list), naj funkciji vrneta nespremenjeno drevo.


```OCaml
(* rešitev *)
let rotateLeft = function
| Node (x, _, a, Node (y, _, b, c)) -> node (y, node (x, a, b), c)
| t -> t

let rotateRight = function
| Node (y, _, Node (x, _, a, b), c) -> node (x, a, node (y, b, c))
| t -> t

```




    val rotateLeft : avltree -> avltree = <fun>







    val rotateRight : avltree -> avltree = <fun>





```OCaml
showTreeHorizontally answer;;
showTreeHorizontally (rotateLeft answer);;
showTreeHorizontally (rotateRight answer);;
showTreeHorizontally (rotateRight (rotateRight answer));;
```

    2:        42       
    1:    6        7   
    0: nil nil  nil nil





    - : unit = ()




    3:             7   
    2:        42       
    1:    6            
    0: nil nil  nil nil





    - : unit = ()




    3:    6            
    2:        42       
    1:             7   
    0: nil nil  nil nil





    - : unit = ()




    3:    6            
    2:        42       
    1:             7   
    0: nil nil  nil nil





    - : unit = ()




Funkciji `rotateLeft` in `rotateRight` uporabimo za uravnoteženje drevesa. Ker bomo drevo uravnotežili po vsakem vstavljanju in brisanju elementa, lahko predpostavimo, da bo neuravnoteženost drevesa kvečjemu 2. Če je neuravnoteženost enaka 0, 1 ali -1, ni treba storiti ničesar. Sicer je neuravnoteženost 2 oziroma -2. V prvem primeru imamo drevo oblike

            x
          /   \
         /     \
        y       +
       / \     / \
      /   \   / h \
     / h+2 \  -----
    /       \
    ---------

Glede na višini poddreves vozlišča `y` lahko to drevo uravnotežimo z enim ali dvema vrtenjema. V prvem primeru imamo drevo oblike

             x                       y
           /   \                   /   \
          /     \                 /     \
         y       +               +        x
       /   \    /h\     ==>     / \     /   \
      +     +   ---            /h+1\   +     +
     / \   / \   c             -----  / \   /h\
    /h+1\ /h+1\*                 a   /h+1\  ---
    ----- -----                      -----   c
      a     b (lahko ima višino h)     b

ki ga popravimo z enim vrtenjem v desno, kot je prikazano zgoraj.

V drugem primeru imamo drevo oblike

            x                       x                       z
          /   \                   /   \                   /   \
         /     \                 /     \                 /     \
        y       +               z       +               y       x
      /   \    /h\    ==>     /   \     /h\    ==>     / \     / \
     +     z   ---           y     +    ---           +   +   +   +
    /h\   / \   c           / \   /h\    c           /h\ /h\ /h\ /h\
    ---  +   +             +   +  ---                --- --- --- ---
     a  /h\ /h\           /h\ /h\  b''                a   b'  b'' c
        --- ---           --- ---
         b'  b''           a   b'
     
    (b' ali b'' lahko ima višino h-1)

ki ga popravimo tako, da najprej levo poddrevo (s korenom `y`) zavrtimo v levo, nato pa celotno drevo zavrtimo v desno.

Če je neuravnoteženost drevesa enaka -2, postopamo simetrično.

**Naloga:** definirajte funkcijo `balance: avltree -> avltree`, ki uravnoteži AVL drevo na podlagi opisanih primerov.


```OCaml
(* rešitev *)
let balance t = match t with
| Empty -> Empty
| Node (x, _, l, r) ->
    begin match imbalance t, imbalance l, imbalance r with
    | (1 | 0 | -1), _, _ -> t
    | 2,  (0 | 1)  , _ -> rotateRight t
    | 2,  -1       , _ -> rotateRight (node (x, rotateLeft l, r))
    | -2, (0 | -1) , _ -> rotateLeft t
    | -2, 1        , _ -> rotateLeft (node (x, l, rotateRight r))
    | _ -> failwith "Tega ne moremo poraviti!"
    end

```




    val balance : avltree -> avltree = <fun>





```OCaml
showTreeHorizontally (balance answer);;
showTreeHorizontally (balance(rotateLeft answer));;
showTreeHorizontally (balance(rotateRight answer));;
```

    2:        42       
    1:    6        7   
    0: nil nil  nil nil





    - : unit = ()




    2:        42       
    1:    6        7   
    0: nil nil  nil nil





    - : unit = ()




    2:        42       
    1:    6        7   
    0: nil nil  nil nil





    - : unit = ()




## Vstavljanje

Nov element `x` vstavimo v AVL drevo `t` po naslednjem postopku:

* če je drevo prazno, vrni list z vsebino `x`;
* če je `t` vozlišče z vsebino `y` in poddrevesoma `l` ter `r`:
    * če je `x = y`, vrni `t`;
    * če je `x < y`, vstavi `x` v `l` in rezultat uravnoteži;
    * če je `x > y`, vstavi `x` v `r` in rezultat uravnoteži.

**Naloga:** definirajte funkcijo `add: int -> avltree -> avltree`.


```OCaml
(* rešitev *)
let rec add x = function
| Empty -> leaf x
| Node (y, _, l, r) ->
    begin match cmp x y with
    | Less -> balance (node (y, add x l, r))
    | Equal -> t
    | Greater -> balance (node (y, l, add x r))
    end ;;

showTreeHorizontally (3 + 5 |> leaf |> add 4 |> add 6 |> add 7 |> add 6) ;;
showTreeHorizontally (add 6 (add 7(add 6 (add 4 (leaf (3 + 5))))))
```




    val add : int -> avltree -> avltree = <fun>




    3:                5       
    2:        3               
    1:    1       4       8   
    0: nil nil nil nil nil nil





    - : unit = ()




    3:                5       
    2:        3               
    1:    1       4       8   
    0: nil nil nil nil nil nil





    - : unit = ()




## Brisanje

Element `x` iz AVL drevesa izbrišemo tako, da ga zamenjamo z njegovim naslednikom iz poddrevesa v vozlišču `x`. Pri tem bomo uporabili pomožno funkcijo `removeSuccessor`, ki vrne novo drevo in naslednika, deluje pa tako:

* če je `t`prazno drevo, sproži izjemo;
* če je `t` vozlišče z vsebino `x` in poddrevesoma `l` ter `r`:
    * če je `l` prazno drevo, vrni `(r, x)`;
    * sicer izbriši naslednika iz `l`, da dobiš `(l', y)`, nato pa sestavi in uravnoteži novo drevo s korenom `x` ter poddrevesoma `l'` in `r`.

**Naloga:** definirajte funkcijo `removeSuccessor: avltree -> avltree * int`.


```OCaml
(* rešitev *)

```

Element `x` lahko potem izbrišemo iz AVL drevesa `t` po naslednjem postopku:

* če je `t` prazno drevo, vrni `t`;
* če je `t` vozlišče z vsebino `y` in poddrevesoma `l` in `r`:
    * če je `x < y`, izbriši `x` iz levega poddrevesa `l` in rezultat uravnoteži;
    * če je `x > y`, izbriši `x` iz desnega poddrevesa `r` in rezultat uravnoteži;
    * če je `x = y`:
        * če je desno poddrevo prazno, vrni `l`;
        * če je levo poddrevo prazno, vrni `r`;
        * sicer iz `r` izbriši naslednika, da dobiš `(r', y')`, nato pa sestavi in uravnoteži novo drevo s korenom `y'` ter poddrevesoma `l` in `r'`.
        
**Naloga:** definirajte funkcijo `remove: int -> avltree -> avltree`.


```OCaml
(* rešitev *)

```


```OCaml
(* testi *)
let tr = Empty;;
let _ = showTreeHorizontally tr;;

let tr = add 1 tr;;
let test1 = tr = Node (1, 1, Empty, Empty) ;;
let _ = showTreeHorizontally tr;;


let tr = add 2 tr;;
let test2 = tr = Node (1, 2, Empty, Node (2, 1, Empty, Empty))
let _ = showTreeHorizontally tr;;

let tr = add 3 tr;;
let test3 = tr = Node (2, 2, Node (1, 1, Empty, Empty), Node (3, 1, Empty, Empty))
let _ = showTreeHorizontally tr;;

let tr = add 4 tr;;
let test4 = tr = Node (2, 3, Node (1, 1, Empty, Empty),
   Node (3, 2, Empty, Node (4, 1, Empty, Empty)))
let _ = showTreeHorizontally tr;;

let tr = add 5 tr;;
let test5 = tr = Node (2, 3, Node (1, 1, Empty, Empty),
   Node (4, 2, Node (3, 1, Empty, Empty), Node (5, 1, Empty, Empty)))
let _ = showTreeHorizontally tr;;

let tr = add 6 tr;;
let test6 = tr =  Node (4, 3,
   Node (2, 2, Node (1, 1, Empty, Empty), Node (3, 1, Empty, Empty)),
   Node (5, 2, Empty, Node (6, 1, Empty, Empty)))
let _ = showTreeHorizontally tr;;

let tr = add 7 tr;;
let test7 = tr = Node (4, 3,
   Node (2, 2, Node (1, 1, Empty, Empty), Node (3, 1, Empty, Empty)),
   Node (6, 2, Node (5, 1, Empty, Empty), Node (7, 1, Empty, Empty)))
let _ = showTreeHorizontally tr;;


let tr = remove 1 tr;;
let test_remove1 = tr = Node (4, 3, Node (2, 2, Empty, Node (3, 1, Empty, Empty)),
   Node (6, 2, Node (5, 1, Empty, Empty), Node (7, 1, Empty, Empty)))
let _ = showTreeHorizontally tr;;

let tr = remove 2 tr;;
let test_remove1 = tr = Node (4, 3, Node (3, 1, Empty, Empty),
   Node (6, 2, Node (5, 1, Empty, Empty), Node (7, 1, Empty, Empty)))
let _ = showTreeHorizontally tr;;

let tr = remove 3 tr;;
let test_remove1 = tr = Node (6, 3, Node (4, 2, Empty, Node (5, 1, Empty, Empty)),
   Node (7, 1, Empty, Empty))
let _ = showTreeHorizontally tr;;

let tr = remove 4 tr;;
let test_remove1 = tr = Node (6, 2, Node (5, 1, Empty, Empty), Node (7, 1, Empty, Empty))
let _ = showTreeHorizontally tr;;

let tr = remove 5 tr;;
let test_remove1 = tr = Node (6, 2, Empty, Node (7, 1, Empty, Empty))
let _ = showTreeHorizontally tr;;

let tr = remove 6 tr;;
let test_remove1 = tr = Node (7, 1, Empty, Empty)
let _ = showTreeHorizontally tr;;

let tr = remove 7 tr;;
let test_remove1 = tr = Empty
let _ = showTreeHorizontally tr;;
```




    val tr : avltree = Empty




    0: nil





    - : unit = ()







    val tr : avltree = Node (1, 1, Empty, Empty)







    val test1 : bool = true




    1:    1   
    0: nil nil





    - : unit = ()







    val tr : avltree = Node (1, 2, Empty, Node (2, 1, Empty, Empty))







    val test2 : bool = true




    2:    1       
    1:        2   
    0: nil nil nil





    - : unit = ()







    val tr : avltree =
      Node (2, 2, Node (1, 1, Empty, Empty), Node (3, 1, Empty, Empty))







    val test3 : bool = true




    2:        2       
    1:    1       3   
    0: nil nil nil nil





    - : unit = ()







    val tr : avltree =
      Node (2, 3, Node (1, 1, Empty, Empty),
       Node (3, 2, Empty, Node (4, 1, Empty, Empty)))







    val test4 : bool = true




    3:        2           
    2:            3       
    1:    1           4   
    0: nil nil nil nil nil





    - : unit = ()







    val tr : avltree =
      Node (2, 3, Node (1, 1, Empty, Empty),
       Node (4, 2, Node (3, 1, Empty, Empty), Node (5, 1, Empty, Empty)))







    val test5 : bool = true




    3:        2               
    2:                4       
    1:    1       3       5   
    0: nil nil nil nil nil nil





    - : unit = ()







    val tr : avltree =
      Node (4, 3,
       Node (2, 2, Node (1, 1, Empty, Empty), Node (3, 1, Empty, Empty)),
       Node (5, 2, Empty, Node (6, 1, Empty, Empty)))







    val test6 : bool = true




    3:                4           
    2:        2           5       
    1:    1       3           6   
    0: nil nil nil nil nil nil nil





    - : unit = ()







    val tr : avltree =
      Node (4, 3,
       Node (2, 2, Node (1, 1, Empty, Empty), Node (3, 1, Empty, Empty)),
       Node (6, 2, Node (5, 1, Empty, Empty), Node (7, 1, Empty, Empty)))







    val test7 : bool = true




    3:                4               
    2:        2               6       
    1:    1       3       5       7   
    0: nil nil nil nil nil nil nil nil





    - : unit = ()





    File "[22]", line 41, characters 9-15:
    41 | let tr = remove 1 tr;;
                  ^^^^^^
    Error: Unbound value remove



[Vir](https://www.cs.cornell.edu/courses/cs312/2007fa/lectures/lec14.html).

# Vaje 7: Rekurzija

Na današnjih vajah bomo spoznali povezavo med zankami in rekurzijo. Naučili se
bomo tudi nekaj tehnik programiranja z rekurzivnimi funkcijami.

## Iz zanke v rekurzijo

### Reference in zanke v Ocamlu

Ko v OCamlu definiramo vrednost `x` z `let x = e₁ in e₂` je `x` *nespremenljiva*
vrednost. Če želimo spremenljivo vrednost, moramo narediti *referenco*:

* z `ref v` naredimo novo referenco z vrednostjo `v`
* z `!r` dobimo trenutno vrednost reference `r`
* z `r := v` nastavimo vrednost reference `r`.

Primer:


```OCaml
let r = ref 5 ;;
!r ;;
!r + 10 ;;
```




    val r : int ref = {contents = 5}







    - : int = 5







    - : int = 15




Ločiti je treba med referenco `r` in njeno vrednostjo `!r`:

    # r + 10 ;;
    Characters 0-1:
      r + 10 ;;
      ^
    Error: This expression has type int ref
           but an expression was expected of type int

Poskusimo, kako se nastavi vrednost reference:


```OCaml
r := 8 ;;
!r ;;
!r + 10 ;;
(!) ;;
```




    - : unit = ()







    - : int = 8







    - : int = 18







    - : 'a ref -> 'a = <fun>




OCaml ima tudi zanki `while` in `for`. Prvo zapišemo

    while ⟨pogoj⟩ do
      ⋯
    done

in drugo

    for i = ⟨spodnja-meja⟩ to ⟨zgornja-meja⟩ do
      ⋯
    done

Mi bomo večinoma uprabljali `while`, nič pa ni narobe, če v svojih rešitvah
uporabite `for`. Tu je program, ki sešteje prvih `42` lihih števil:

    


```OCaml
let vsota_lihih_42 =
    let v = ref 0 in
    let i = ref 0 in
    while !i < 42 do
        v := !v + (2 * !i + 1) ;
        i := !i + 1
    done ;
    !v
```




    val vsota_lihih_42 : int = 1764





```OCaml

```




    - : int -> bool = <fun>




Števec `i` in vsota `v` sta referenci, ker se njuni vrednosti spreminjata. To je
običajno, kadar uporabljamo zanke.

### Naloga 1

Sestavite funkcijo `vsota1 : int -> int`, ki sprejme `n` in vrne vsoto `1 + 2 + ⋯ + n`. Uporabite reference in zanko `while`.

#### Rešitev


```OCaml
(* let vsota1 : int -> int = fun n -> ... *)
let vsota1 (n : int) : int =
    let i, s = ref 0, ref 0 in
    while !i <= n do
        s := !s + !i ; i := !i + 1
    done ;
    !s ;;
vsota1 4
```




    val vsota1 : int -> int = <fun>







    - : int = 10





```OCaml
let f (a, b) = a + b;;
let f x = match x with (a, b) -> a + b;;
```




    val f : int * int -> int = <fun>







    val f : int * int -> int = <fun>




### Naloga 2

Sestavite funkcijo `fibonacci1 : int -> int`, ki sprejme `n` in vrne `n`-to
Fibonaccijevo število `F(n)`. Nauk: Fibonaccijevo zaporedje je definirano s
predpisom:

    F(0) = 0
    F(1) = 1
    F(n) = F(n-1) + F(n-2)

Uporabite reference in zanko `while`.

#### Rešitev


```OCaml
let fibonacci1 n =
    let i = ref 0 in
    let curr = ref 0 in
    let next = ref 1 in
    while !i < n do
        let t = !curr in
            curr := !next;
            next := t + !next;
            i := !i + 1
    done ; !curr
    
;;
fibonacci1 10
```




    val fibonacci1 : int -> int = <fun>







    - : int = 55




## Rekurzivne funkcije

Zanko `while` lahko sistematično pretvorimo v rekurzivno funkcijo. Še prej pa
malce ponovimo rekurzivne funkcije.

### Naloga 3

Sestavite funkcijo `vsota2 : int -> int`, ki sprejme `n` in vrne vsoto `1 + 2 + ⋯ + n`. Funkcija naj bo rekurzivna in naj ne uporablja zank in referenc.

#### Rešitev


```OCaml
(*
0 -> 0
n -> n + vsota (n - 1) 
*)

let rec vsota2 n = if n < 1 then 0 else n + vsota2 (n - 1)
;;
vsota2 100
```




    val vsota2 : int -> int = <fun>







    - : int = 5050




### Naloga 4

Sestavite funkcijo `fibonacci2 : int -> int`, ki sprejme `n` in vrne `n`-to
Fibonaccijevo število `F(n)`. Funkcija naj bo rekurzivna in naj ne uporablja
zank in referenc.

#### Rešitev


```OCaml
(* F(0) = 0
F(1) = 1
F(n) = F(n-1) + F(n-2) *)

let rec fibonacci2 = function
| 0 -> 0
| 1 -> 1
| n -> fibonacci2 (n - 1) + fibonacci2 (n - 2)
;;
fibonacci2 40

```




    val fibonacci2 : int -> int = <fun>







    - : int = 102334155




## Akumulatorji in repna rekurzija

Pravimo, da je rekurzivni klic funkcije **repni klic** ali **klic na repu**
(angl. _tail recursive_), če je rezultat rekurzivnega klica hkrati tudi rezultat
funkcije. Povedano z drugimi besedami, funkcija se pokliče rekurzivno in nato takoj
vrne rezultat rekurzivnega klica.

Na primer, v rekurzivni funkciji




```OCaml
let rec f = function
| 0 -> 1
| n ->
    if n mod 2 = 0
    then f (n / 2)
    else 3 * f (n - 1)
```




    val f : int -> int = <fun>




je prvi rekurzivni klic repni, ker se izvede `f (n / 2)` in nato nič drugega,
drugi rekurzivni klic pa ni repni, ker je treba rezultat rekurzivnega klica `f
(n - 1)` še množiti s `3`.

Mnogi prevajalniki (vendar ne Java in Python) repne klice optimizirajo tako, da
jih kar pretvorijo v zanko, kar je dosti bolj učinkovito. Pogosto lahko
rekurzivno funkcijo, ki nima repnih klicev, predelamo v tako, ki ima repne
klice. Pri tem uporabimo t.i. tehniko *akumulatorjev*, ki imajo v rekurzivni
funkciji podobno vlogo kot pomožne spremenljivke v zanki.

Poglejmo, kako bi pretvorili funkcijo `vsota_lihih1 n`, ki z uporabo zanke
izračuna vsoto

    1 + 3 + 5 + ⋯ + (2 n - 1)

v repno rekurzivno funkcijo:


```OCaml
let vsota_lihih1 n =
    let v = ref 0 in
    let i = ref 0 in
    while !i < n do
        v := !v + (2 * !i + 1) ;
        i := !i + 1
    done ;
    !v
```




    val vsota_lihih1 : int -> int = <fun>




Recept je naslednji: ker zanka uporablja dve spremenljivki, namreč `v` in `i`,
bo imela rekurzivna funkcija dva argumenta `v` in `i`. Namesto, da bi
spreminjali vrednosti `v` in `i` (česar ne moremo, saj `v` in `i` ne bosta več
referenci), bomo naredili repni rekuzivni klic s popravljenima vrednostma `v` in
`i`:


```OCaml
let vsota_lihih2 n =
    let rec vsota v i =
        if i < n
        then vsota (v + (2 * i + 1)) (i + 1)
        else v
        in
    vsota 0 0
```




    val vsota_lihih2 : int -> int = <fun>




Kot vidimo, funkcija `vsota_lihih2` ni rekurzvina, ampak vsebuje *pomožno*
rekurzivno funkcijo `vsota`, ki igra vlogo zanke. Klic `vsota 0 0` nato izvede
`vsota` z ustreznima začetnima vrednostma `v` in `i`.

### Naloga 3

Po zgornjem receptu predelajte funkcijo `vsota1` v funkcijo `vsota3`, ki
uporablja akumulatorje in repno rekurzijo. Nato primerajte delovanje funkcij
`vsota1`, `vsota2` in `vsota3`. Ali lahko vse tri izračunajo npr. vsoto prvih
`1000000` števil?

#### Rešitev


```OCaml
let vsota3 n = 
    let rec vsota i s =
        if i <= n
        then vsota (i + 1) (s + i)
        else s
    in vsota 0 0;;
vsota3 100

let time f =
    let t = Unix.gettimeofday () in
    let res = f () in
    Printf.printf "Execution time: %f seconds\n"
    (Unix.gettimeofday () -. t) ; flush stdout ;
    res
;;
(* 
(* 1000000 -> 100000 *)
let vsota1_runtime = time (fun () -> vsota1 100000) ;;
let vsota2_runtime = time (fun () -> vsota2 100000) ;;
let vsota3_runtime = time (fun () -> vsota3 100000) ;; *)
```




    val vsota3 : int -> int = <fun>







    - : int = 5050







    val time : (unit -> 'a) -> 'a = <fun>





```OCaml
let d = 3 in d * d;;
```




    - : int = 9




### Naloga 4

Po zgornjem receptu predelajte funkcijo `fibonacci1` v funkcijo `fibonacci3`, ki
uporablja akumulatorje in repno rekurzijo.

#### Rešitev


```OCaml
let fibonacci3 n = 
    let rec fib i curr next =
        if i < n
        then fib (i + 1) next (curr + next)
        else curr
    in fib 0 0 1;;
fibonacci3 10
```




    val fibonacci3 : int -> int = <fun>







    - : int = 55




## Splošna pretvorba zanke `while` v rekurzivno funkcijo

Premislimo še, ali lahko zanko `while` v splošnem prevedemo v rekurzivno
funkcijo z akumulatorjem in repnim klicom. Obravnavajmo zanko `while` oblike
(zapisali smo jo v namišljenem ukaznem programskem jeziku):

    s := s₀
    while p(s) do
      s := f(s)
    done ;
    return r(s)

Tu smo z `s` označili skupno stanje vseh spremenljivk, ki nastopajo v zanki,
`s₀` je začetno stanje, `p(s)` je pogoj (ki je odvisen od stanja `s`), zanka
vsakič trenutno stanje `s` nastavi na novo stanje `f(s)`, na koncu pa vrne
rezultat `r(s)` (ki je spet odvisen od `s`). Na primer, zanko, ki izračuna
`n`-to Fibonaccijevo število bi zapisali takole:

    (a,b,i) := (0,1,0)
    while i < n do
       (a,b,i) = (b,a+b,i+1)
    done ;
    return a

Zgornjo zanko lahko predelamo v rekurzivno funkcijo `zanka`, ki spreme `s₀`,
`p`, `f` in `r` ter izračuna to, kar bi sicer izračunala zanka `while`:


```OCaml
let zanka s0 p f r =
    let rec loop s =
        if p s then loop (f s) else r s
    in loop s0
```




    val zanka : 'a -> ('a -> bool) -> ('a -> 'a) -> ('a -> 'b) -> 'b = <fun>




Tip funkcije `zanka` je

    α → (α → bool) → (α → α) → (α → β) → β

kar pomeni, da ima začetno stanje `s₀` (poljuben) tip `α`, pogoj `p` je
funkcija, ki slika stanje v `bool`, `f` je funkcija, ki stanje predela v novo
stanje, in `r` je funkcija, ki stanje predela v rezultat (poljubnega) tipa `β`.

### Naloga 5

Sestavite funkcijo `vsota4`, ki izračuna vsoto števil `1 + 2 + ⋯ + n`, tako da
uporabite funkcijo `zanka`. Torej, vaša rešitev mora biti oblike

    let vsota4 n = zanka ⋯ ⋯ ⋯ ⋯

kjer `⋯` nadomestite z ustreznimi vrednostmi `s₀`, `p`, `f` in `r`.

#### Rešitev


```OCaml
(* let vsota4 n = zanka
    (0, 0)
    (fun (i, _) -> i <= n)
    (fun (i, s) -> i + 1, s + i)
    (fun (_, s) -> s)
;; *)

let vsota4 n = zanka
    (0, 0)
    (fun (i, s) -> i <= n)
    (fun (i, s) -> i + 1, s + i)
    (fun (prvi, drugi) -> drugi)
;;
vsota4 100
```




    val vsota4 : int -> int = <fun>







    - : int = 5050




### Naloga 6

Sestavite funkcijo `fibonacci4`, ki izračuna `n`-to Fibonaccijevo, tako da
uporabite funkcijo `zanka`. Torej, vaša rešitev mora biti oblike

    let fibonacci4 n = zanka ⋯ ⋯ ⋯ ⋯

kjer `⋯` nadomestite z ustreznimi vrednostmi `s₀`, `p`, `f` in `r`.

#### Rešitev


```OCaml
let fibonacci4 n = zanka
(* (i, curr, next), s₀ = (0, 0, 1) *)
    (0, 0 , 1)
    (fun (i, curr, next) -> i < n)
    (fun (i, curr, next) -> (i + 1, next, curr + next))
    (fun (i, curr, next) -> curr)
(*     (fun (i, _, _) -> i < n)
    (fun (i, curr, next) -> (i + 1, next, curr + next))
    (fun (_, curr, _) -> curr) *)
;;
fibonacci4 10
```




    val fibonacci4 : int -> int = <fun>







    - : int = 55




### Naloga 7

Sestavite rekurzivno funkcijo `forzanka`, ki izračuna to, kar izračuna spodnja koda v namišljenem ukaznem programskem jeziku:

    s := s₀
    for i = a to b do
      s := f(i, s)
    done ;
    return r(s)

Enako kot prej tukaj `s` označuje skupno stanje vseh spremenljivk, ki nastopajo v zanki,
`s₀` pa začetno stanje. Zanka za vsak `i` med vključno `a` in `b` pokliče funkcijo `f`, ki glede `i` in trenutno stanje `s` izračuna novo stanje, na koncu pa vrne rezultat `r(s)`. Na primer, zanko `for`, ki izračuna vsoto prvih `n` naravnih števil, bi zapisali takole:

    v := 0
    for i = 1 to n do
        v := v+i
    done ;
    return v

Funkcija `forzanka` naj prejme začetno stanje `s₀`, spodnjo in zgornjo mejo `a` oziroma `b` ter funkciji `f` in `r`. Njen tip bo torej

    α → int → int → (int → α → α) → (α → β) → β

#### Rešitev


```OCaml

```

### Naloga 8

Sestavite funkcijo `fibonacci5`, ki izračuna `n`-to Fibonaccijevo, tako da
uporabite funkcijo `forzanka`. Torej, vaša rešitev mora biti oblike

    let fibonacci5 n = forzanka ⋯ ⋯ ⋯ ⋯ ⋯

kjer `⋯` nadomestite z ustreznimi vrednostmi `s₀`, `a`, `b`, `f` in `r`.

#### Rešitev


```OCaml

```


```OCaml

```

# Vaje 8: Programiranje s tokovi

Ker je OCaml neučakan jezik, v njem ne moremo neposredno definirati koinduktivnih podatkovnih tipov, kot so neskončni tokovi. Lahko pa jih simuliramo z uporabo funkcij. Definicija tipa `α stream` izgleda tako:

    


```OCaml
type 'a stream = Cons of 'a * (unit -> 'a stream)
;;
```




    type 'a stream = Cons of 'a * (unit -> 'a stream)




Prvi element toka smo zapisali neposredno, preostanek toka pa smo predstavili s funkcijo, ki sprejme »prazen« argument (`unit`) in vrne preostanek toka. To nam omogoča, da računanje preostanka toka preložimo do takrat, ko ga dejansko potrebujemo. Funkciji, ki odloži računanje, pravimo [*thunk*](https://en.wikipedia.org/wiki/Thunk).

Pri tem se definiranje tokov malenkost zakomplicira: v konstruktorju `Cons` bo drugi element zmeraj oblike `fun () -> …`. Obratno moramo pri uporabi vrednosti oblike `Cons (a, b)` preostanek toka zmeraj najprej izračunati z `b ()`.

## Tok iz seznama

Sestavimo funkcijo `from_list` tipa `α list → α → α stream`. Izraz

    from_list [e₁, e₂, ..., eᵢ] r

naj vrne neskončni tok, ki ima prvih `i` elementov iz danega seznama, nato pa ponavlja element `r`:

    e₁, e₂, ..., eᵢ, r, r, r, r, r, r, ...

Primer:

    # let four = from_list [1;2;3] 4 ;;
    val four : int stream = Cons (1, <fun>)

Namig: pri obravnavi seznama `l` si lahko pomagamo z izrazom `match`:


```OCaml
(* rešitev *)
let rec ones = Cons (1, fun () -> ones)

let rec from_list l r =
    match l with
(*     | []      -> let rec rs = Cons (r, fun () -> rs) in rs *)
    | [] -> Cons (r, fun () -> from_list [] r)
    | x :: xs -> Cons (x, fun () -> from_list xs r)

let four = from_list [1;2;3] 4 
```




    val ones : int stream = Cons (1, <fun>)







    val from_list : 'a list -> 'a -> 'a stream = <fun>







    val four : int stream = Cons (1, <fun>)




## Seznam iz toka

Sestavimo še obratno funkcijo `to_list n s`, ki vrne seznam prvih `n` elementov danega toka `s`. Primer:

    # to_list 10 four ;;
    - : int list = [1; 2; 3; 4; 4; 4; 4; 4; 4; 4]

Namig: operator `x :: xs` doda element `x` na začetek seznama `xs`.


```OCaml
(* rešitev *)
let rec to_list n s =
if n = 0 then []
else match s with
Cons (e, nadaljevanje) -> e :: to_list (n - 1) (nadaljevanje ());;
to_list 10 four ;;
to_list 3 ones;;
```




    val to_list : int -> 'a stream -> 'a list = <fun>







    - : int list = [1; 2; 3; 4; 4; 4; 4; 4; 4; 4]







    - : int list = [1; 1; 1]




## `n`-ti element toka

Sestavite funkcijo `element_at n s`, ki vrne `n`-ti element danega toka `s`. Primer:

    # element_at 100 four ;;
    - : int = 4


```OCaml
let mul (a, b, c) = a * b * c
let mul x = match x with a, b, c -> a * b * c

(* rešitev *)
let rec element_at n (Cons (e, s)) =
if n = 0 then e
else element_at (n - 1) (s ())

;;
element_at 100 four
```




    val mul : int * int * int -> int = <fun>







    val mul : int * int * int -> int = <fun>







    val element_at : int -> 'a stream -> 'a = <fun>







    - : int = 4




## Glava in rep

Sestavite funkciji `head : α stream → α` in `tail : α stream → α stream`, ki vrneta glavo
in rep toka. Primer:

    # head four ;;
    - : int = 1
    # tail four ;;
    - : int stream = Cons (2, <fun>)
    # head (tail four) ;;
    - : int = 2

(Opomba: takih funkcij običajno ne uporabljamo, ker so bolj praktični vzorci, s katerimi lahko izluščimo glavo in rep.)


```OCaml
(* rešitev *)

let head (Cons (e, s)) = e
let tail (Cons (e, s)) = s ()

;;
head four ;;
tail four ;;
head (tail four) ;;
```




    val head : 'a stream -> 'a = <fun>







    val tail : 'a stream -> 'a stream = <fun>







    - : int = 1







    - : int stream = Cons (2, <fun>)







    - : int = 2




## Preslikava

Sestavite funkcijo `map`, ki sprejme funkcijo `f` in tok

    e₁, e₂, e₃, ...

ter vrne tok

    f e₁, f e₂, f e₃, ...

Primer:

    # to_list 5 (map (fun x -> x*x) four) ;;
    - : int list = [1; 4; 9; 16; 16]

Kakšnega tipa je `map`?


```OCaml
(* rešitev *)
let rec map f (Cons (e, s)) = 
    Cons (f e, fun () -> map f (s ()))

;;
to_list 5 (map (fun x -> x*x) four)
```




    val map : ('a -> 'b) -> 'a stream -> 'b stream = <fun>







    - : int list = [1; 4; 9; 16; 16]




## Naravna števila

Sestavite tok `nat` naravnih števil `0, 1, 2, 3, ...`. Primer:

    # to_list 10 nat ;;
    - : int list = [0; 1; 2; 3; 4; 5; 6; 7; 8; 9]

*Namig*: pomagajte si s pomožno rekurzivno funkcijo `from k`, ki vrne tok števil od `k` naprej.


```OCaml
(* rešitev *)
let rec from k = Cons (k, fun () -> from (k + 1))

let nat = from 0

;;
to_list 10 nat
```




    val from : int -> int stream = <fun>







    val nat : int stream = Cons (0, <fun>)







    - : int list = [0; 1; 2; 3; 4; 5; 6; 7; 8; 9]




## Fibonaccijeva števila

Sestavite tok `fib` Fibonaccijevih števil `0, 1, 1, 2, 3, 5, 8, ...`. Primer:

    # to_list 10 fib ;;
    - : int list = [0; 1; 1; 2; 3; 5; 8; 13; 21; 34]


```OCaml
(* rešitev *)
let fib = 
    let rec fib current next = Cons (current, fun () -> fib next (next + current))
    in fib 0 1
    
;;
to_list 10 fib ;;
```




    val fib : int stream = Cons (0, <fun>)







    - : int list = [0; 1; 1; 2; 3; 5; 8; 13; 21; 34]




## Preslikava parov

Sestavite funkcijo

    zip : (α → β → γ) → α stream → β stream → γ stream

ki sprejme funkcijo `f` in toka

    d₁, d₂, d₃, ...
    e₁, e₂, e₃, ...

ter vrne tok

    f d₁ e₁, f d₂ e₂, f d₃ e₃, ...

Primer:

    # to_list 10 (zip (fun x -> fun y -> x + y) nat (tail nat)) ;;
    - : int list = [1; 3; 5; 7; 9; 11; 13; 15; 17; 19]


```OCaml
(* rešitev *)
let rec zip f (Cons (d, sd)) (Cons (e, se)) = Cons (f d e, fun () -> zip f (sd ()) (se ()))

;;
to_list 10 (zip (fun x -> fun y -> x + y) nat (tail nat)) ;;
to_list 10 (zip (fun x y -> x, y) nat (tail nat))
```




    val zip : ('a -> 'b -> 'c) -> 'a stream -> 'b stream -> 'c stream = <fun>







    - : int list = [1; 3; 5; 7; 9; 11; 13; 15; 17; 19]







    - : (int * int) list =
    [(0, 1); (1, 2); (2, 3); (3, 4); (4, 5); (5, 6); (6, 7); (7, 8); (8, 9);
     (9, 10)]




## Večkratniki

1. Sestavite funkcijo `veckratniki_stevila : int -> int stream`, ki sprejme `k` in vrne
   tok večkratnikov `k`. Na primer, `veckratniki_stevila 3` vrne tok `0, 3, 6, 9, 12, ...`.

2. Sestavite tok tokov `veckratniki : int stream stream`, katerega elementi so tokovi
   večkratnikov:

        (0, 0, 0, 0, ⋯), (0, 1, 2, 3, ⋯), (0, 2, 4, 6, ⋯), (0, 3, 6, 9, ⋯), ⋯

Primer:

    # to_list 10 (map (to_list 15) veckratniki) ;;
    - : int list list =
    [[0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0];
    [0; 1; 2; 3; 4; 5; 6; 7; 8; 9; 10; 11; 12; 13; 14];
    [0; 2; 4; 6; 8; 10; 12; 14; 16; 18; 20; 22; 24; 26; 28];
    [0; 3; 6; 9; 12; 15; 18; 21; 24; 27; 30; 33; 36; 39; 42];
    [0; 4; 8; 12; 16; 20; 24; 28; 32; 36; 40; 44; 48; 52; 56];
    [0; 5; 10; 15; 20; 25; 30; 35; 40; 45; 50; 55; 60; 65; 70];
    [0; 6; 12; 18; 24; 30; 36; 42; 48; 54; 60; 66; 72; 78; 84];
    [0; 7; 14; 21; 28; 35; 42; 49; 56; 63; 70; 77; 84; 91; 98];
    [0; 8; 16; 24; 32; 40; 48; 56; 64; 72; 80; 88; 96; 104; 112];
    [0; 9; 18; 27; 36; 45; 54; 63; 72; 81; 90; 99; 108; 117; 126]]

_Namig_: Uporabite `map`.


```OCaml
(* rešitev *)
let veckratniki_stevila k = map (fun x -> k * x) nat
let veckratniki_stevila k = map (( * ) k) nat

let veckratniki = map veckratniki_stevila nat

;;
to_list 10 (map (to_list 15) veckratniki) ;;
```




    val veckratniki_stevila : int -> int stream = <fun>







    val veckratniki_stevila : int -> int stream = <fun>







    val veckratniki : int stream stream = Cons (Cons (0, <fun>), <fun>)







    - : int list list =
    [[0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0];
     [0; 1; 2; 3; 4; 5; 6; 7; 8; 9; 10; 11; 12; 13; 14];
     [0; 2; 4; 6; 8; 10; 12; 14; 16; 18; 20; 22; 24; 26; 28];
     [0; 3; 6; 9; 12; 15; 18; 21; 24; 27; 30; 33; 36; 39; 42];
     [0; 4; 8; 12; 16; 20; 24; 28; 32; 36; 40; 44; 48; 52; 56];
     [0; 5; 10; 15; 20; 25; 30; 35; 40; 45; 50; 55; 60; 65; 70];
     [0; 6; 12; 18; 24; 30; 36; 42; 48; 54; 60; 66; 72; 78; 84];
     [0; 7; 14; 21; 28; 35; 42; 49; 56; 63; 70; 77; 84; 91; 98];
     [0; 8; 16; 24; 32; 40; 48; 56; 64; 72; 80; 88; 96; 104; 112];
     [0; 9; 18; 27; 36; 45; 54; 63; 72; 81; 90; 99; 108; 117; 126]]




## ★ Sploščen tok

Ta naloga ni tako dolgočasna kot ostale. Sestavite funkcijo

    flatten : (α stream) stream → α stream

ki sprejme tok tokov in vrne tok, v katerem se vsak element iz tokov pojavi natanko enkrat.


```OCaml
-2 :: [1; 2; 4] @ [2]
```




    - : int list = [-2; 1; 2; 4; 2]





```OCaml
let flatten tok_tokov =
    let rec flat (nespremenjeni_tokovi : 'a stream stream) (obdelani : 'a stream list) (na_vrsti : 'a stream list) =
        match na_vrsti with
        | [] -> flat (tail nespremenjeni_tokovi) [] (obdelani @ [head nespremenjeni_tokovi])
        | tok :: ostali_na_vrsti -> Cons (head tok,
            fun () -> flat nespremenjeni_tokovi (obdelani @ [tail tok]) ostali_na_vrsti)
    
    in flat tok_tokov [] []
```




    val flatten : 'a stream stream -> 'a stream = <fun>




## ★ Tok parov

Sestavite funkcijo

    product : α stream → β stream → (α * β) stream

ki sprejme tokova

    d₁, d₂, d₃, ...
    e₁, e₂, e₃, ...

in vrne tok parov `(dᵢ, eⱼ)`, v katerem se vsak par pojavi natanko enkrat. Vrstni red, v
katerem se pojavijo pari, ni pomemben. Primer:

    # to_list 100 (product nat nat) ;;
    - : (int * int) list =
    [(0, 0); (0, 1); (1, 0); (0, 2); (1, 1); (2, 0); (0, 3); (1, 2); (2, 1);
     (3, 0); (0, 4); (1, 3); (2, 2); (3, 1); (4, 0); (0, 5); (1, 4); (2, 3);
     (3, 2); (4, 1); (5, 0); (0, 6); (1, 5); (2, 4); (3, 3); (4, 2); (5, 1);
     (6, 0); (0, 7); (1, 6); (2, 5); (3, 4); (4, 3); (5, 2); (6, 1); (7, 0);
     (0, 8); (1, 7); (2, 6); (3, 5); (4, 4); (5, 3); (6, 2); (7, 1); (8, 0);
     (0, 9); (1, 8); (2, 7); (3, 6); (4, 5); (5, 4); (6, 3); (7, 2); (8, 1);
     (9, 0); (0, 10); (1, 9); (2, 8); (3, 7); (4, 6); (5, 5); (6, 4); (7, 3);
     (8, 2); (9, 1); (10, 0); (0, 11); (1, 10); (2, 9); (3, 8); (4, 7); (5, 6);
     (6, 5); (7, 4); (8, 3); (9, 2); (10, 1); (11, 0); (0, 12); (1, 11); 
     (2, 10); (3, 9); (4, 8); (5, 7); (6, 6); (7, 5); (8, 4); (9, 3); (10, 2);
     (11, 1); (12, 0); (0, 13); (1, 12); (2, 11); (3, 10); (4, 9); (5, 8);
     (6, 7); (7, 6); (8, ...); ...]

*Namig*: uporabite `map`, `map` in `flatten`.


```OCaml
(* rešitev *)
let tok_tokov_parov ds es = map (fun d -> map (fun e -> d, e) es) ds ;;
to_list 6 (map (to_list 5) (tok_tokov_parov nat nat)) ;;

let product ds es = flatten (tok_tokov_parov ds es)

;;
to_list 20 (product nat nat)
```




    val tok_tokov_parov : 'a stream -> 'b stream -> ('a * 'b) stream stream =
      <fun>







    - : (int * int) list list =
    [[(0, 0); (0, 1); (0, 2); (0, 3); (0, 4)];
     [(1, 0); (1, 1); (1, 2); (1, 3); (1, 4)];
     [(2, 0); (2, 1); (2, 2); (2, 3); (2, 4)];
     [(3, 0); (3, 1); (3, 2); (3, 3); (3, 4)];
     [(4, 0); (4, 1); (4, 2); (4, 3); (4, 4)];
     [(5, 0); (5, 1); (5, 2); (5, 3); (5, 4)]]







    val product : 'a stream -> 'b stream -> ('a * 'b) stream = <fun>







    - : (int * int) list =
    [(0, 0); (0, 1); (1, 0); (0, 2); (1, 1); (2, 0); (0, 3); (1, 2); (2, 1);
     (3, 0); (0, 4); (1, 3); (2, 2); (3, 1); (4, 0); (0, 5); (1, 4); (2, 3);
     (3, 2); (4, 1)]





```OCaml

```

# Množice

Ogledali si bomo dve implementaciji podatkovnega tipa [množica](https://en.wikipedia.org/wiki/Set_(abstract_data_type)). V jeziku OCaml množico opišemo z naslednjo signaturo:
<a id='module_set_cell'></a>


```OCaml
type order = Less | Equal | Greater

module type SET =
sig
    type element
    val cmp : element -> element -> order
    type set
    val empty : set
    val member : element -> set -> bool
    val add : element -> set -> set
    val remove : element -> set -> set
    val to_list : set -> element list
    val fold : ('a -> element -> 'a) -> 'a -> set -> 'a
end
```




    type order = Less | Equal | Greater







    module type SET =
      sig
        type element
        val cmp : element -> element -> order
        type set
        val empty : set
        val member : element -> set -> bool
        val add : element -> set -> set
        val remove : element -> set -> set
        val to_list : set -> element list
        val fold : ('a -> element -> 'a) -> 'a -> set -> 'a
      end




V množici se vsak element lahko pojavi samo enkrat. Tip elementov, ki jih vsebuje množica, mora biti primerljiv – elemente primerjamo s funkcijo `cmp`, ki vrne `Less`, `Equal` ali `Greater`. Množica podpira naslednje operacije:

* `member e s` vrne `true`, če množica `s` vsebuje element `e`,
* `add e s` doda element `e` v množico `s`,
* `remove e s` izbriše element `e` iz množice `s`
* `to_list s` vrne seznam elementov v množici `s` (v poljubnem vrstnem redu).


## Implementacija s seznamom

Definirajte strukturo `IntListSet`, ki elemente množice hrani v seznamu. Tip elementov naj bo celo število (`int`), za primerjavo pa lahko uporabite kar funkcijo `ocaml_cmp`:


```OCaml
let ocaml_cmp x y =
    let c = Stdlib.compare x y in
    if c < 0 then Less
    else if c > 0 then Greater
    else Equal
```




    val ocaml_cmp : 'a -> 'a -> order = <fun>




Primer uporabe:

    # let s = IntListSet.add 2 (IntListSet.add 4 IntListSet.empty) ;;
    val s : IntListSet.set = <abstr>
    # IntListSet.member 4 s ;;
    - : bool = true

Zgledujte se po implementaciji prioritetne vrste `MyFirstQueue` s predavanj.
<a id='IntListSet'></a>


```OCaml
module IntListSet : SET with type element = int =
struct
(*     type element *)
    type element = int
    
(*     val cmp : element -> element -> order *)
    let cmp = ocaml_cmp
    
(*     type set *)
    type set = element list
    
(*     val empty : set *)
    let empty = []
    
(*     val member : element -> set -> bool *)
(*     let member = List.mem  *)
    let eq x y = cmp x y = Equal
    let rec member e s = match s with
    | [] -> false
(*     | x :: xs -> if eq x e then true then member e xs *)
    | x :: xs -> eq x e || member e xs
    
(*     val add : element -> set -> set *)
    let add e s = if member e s then s else e :: s
    
(*     val remove : element -> set -> set *)
    let rec remove e = function
    | [] -> []
    | x :: xs -> if eq x e then xs else x :: remove e xs
    
(*     val to_list : set -> element list *)
    let to_list s = s
    
(*     fold f z [x1, x2, x3] = f (f (f z x1) x2) x3 *)
    let rec fold f z s = match s with
    | [] -> z
    | x :: xs -> fold f (f z x) xs
end

let s = IntListSet.add 2 (IntListSet.add 4 IntListSet.empty) ;;
IntListSet.member 4 s ;;

let open IntListSet in
let s = add 2 (add 4 empty) in
member 4 s
```




    module IntListSet :
      sig
        type element = int
        val cmp : element -> element -> order
        type set
        val empty : set
        val member : element -> set -> bool
        val add : element -> set -> set
        val remove : element -> set -> set
        val to_list : set -> element list
        val fold : ('a -> element -> 'a) -> 'a -> set -> 'a
      end







    val s : IntListSet.set = <abstr>







    - : bool = true







    - : bool = true




## Generični `ListSet`

Definicijo `IntListSet` spremenite v funktor `ListSet`, ki sprejme strukturo, ki zadošča signaturi


```OCaml
module type ORDERED =
    sig
        type t
        val cmp : t -> t -> order
    end
```




    module type ORDERED = sig type t val cmp : t -> t -> order end




ter vrne implementacijo množic s seznami. Nastavek je naslednji:

    module ListSet(M : ORDERED) : SET with type element = M.t =
      struct
         ⋮
      end

Primer uporabe:

    # module S = ListSet(struct type t = string  let cmp = ocaml_cmp end) ;;
    module S :
      sig
        type element = string
        val cmp : element -> element -> order
        type set
        val empty : set
        val member : element -> set -> bool
        val add : element -> set -> set
        val remove : element -> set -> set
        val to_list : set -> element list
        val fold : ('a -> element -> 'a) -> 'a -> set -> 'a
      end
    # let s = S.add "foo" (S.add "bar" S.empty) ;;
    val s : S.set = <abstr>
    # S.member "foo" s ;;
    - : bool = true

Zgledujte se po implementaciji prioritetne vrste `ListQueue` s predavanj.
<a id='ListSet'></a>


```OCaml
module ListSet(M : ORDERED) : SET with type element = M.t =
struct
(*     type element *)
    type element = M.t
    
(*     val cmp : element -> element -> order *)
    let cmp = M.cmp
    
(*     type set *)
    type set = element list
    
(*     val empty : set *)
    let empty = []
    
(*     val member : element -> set -> bool *)
(*     let member = List.mem  *)
    let eq x y = cmp x y = Equal
    let rec member e s = match s with
    | [] -> false
(*     | x :: xs -> if eq x e then true then member e xs *)
    | x :: xs -> eq x e || member e xs
    
(*     val add : element -> set -> set *)
    let add e s = if member e s then s else e :: s
    
(*     val remove : element -> set -> set *)
    let rec remove e = function
    | [] -> []
    | x :: xs -> if eq x e then xs else x :: remove e xs
    
(*     val to_list : set -> element list *)
    let to_list s = s
    
    let rec fold f z s = match s with
    | [] -> z
    | x :: xs -> fold f (f z x) xs
end
  
module S = ListSet(struct type t = string  let cmp = ocaml_cmp end) ;;
let s = S.add "foo" (S.add "bar" S.empty) ;;
S.member "foo" s ;;
```




    module ListSet :
      functor (M : ORDERED) ->
        sig
          type element = M.t
          val cmp : element -> element -> order
          type set
          val empty : set
          val member : element -> set -> bool
          val add : element -> set -> set
          val remove : element -> set -> set
          val to_list : set -> element list
          val fold : ('a -> element -> 'a) -> 'a -> set -> 'a
        end







    module S :
      sig
        type element = string
        val cmp : element -> element -> order
        type set
        val empty : set
        val member : element -> set -> bool
        val add : element -> set -> set
        val remove : element -> set -> set
        val to_list : set -> element list
        val fold : ('a -> element -> 'a) -> 'a -> set -> 'a
      end







    val s : S.set = <abstr>







    - : bool = true




## Primerjava učinkovitosti `ListSet` in `AVLSet`

Modul `AVLSet` implementira funktor, ki tako kot `ListSet` sprejme strukturo s signaturo `ORDERED` in vrne
implementacijo množic z AVL drevesi, glej datoteko `avlset.ml`.
<a id='AVLSet'></a>


```OCaml
(* datoteka avlset.ml *)
module AVLSet(M : ORDERED) : SET with type element = M.t =
  struct
    type element = M.t
    let cmp = M.cmp

    type set = Empty | Node of element * int * set * set

    let empty = Empty

    let height = function
      | Empty -> 0
      | Node (_, h, _, _) -> h

    let leaf v = Node (v, 1, Empty, Empty)

    let node (v, l, r) = Node (v, 1 + max (height l) (height r), l, r)

    let rec member x = function
      | Empty -> false
      | Node (y, _, l, r) ->
         begin
           match cmp x y with
           | Equal -> true
           | Less -> member x l
           | Greater -> member x r
         end

    let rec to_list = function
      | Empty -> []
      | Node (x, _, l, r) -> to_list l @ [x] @ to_list r

    let rotateLeft = function
      | Node (x, _, a, Node (y, _, b, c)) -> node (y, node (x, a, b), c)
      | t -> t

    (* alternativni zapis s case *)
    let rotateRight = function
      | Node (y, _, Node (x, _, a, b), c) -> node (x, a, node (y, b, c))
      | t -> t

    let imbalance = function
      | Empty -> 0
      | Node (_, _, l, r) -> height l - height r

    let balance = function
      | Empty -> Empty
      | Node (x, _, l, r) as t ->
         begin
           match imbalance t with
           | 2 ->
              (match imbalance l with
               | -1 -> rotateRight (node (x, rotateLeft l, r))
               | _ -> rotateRight t)
           | -2 ->
              (match imbalance r with
               | 1 -> rotateLeft (node (x, l, rotateRight r))
               | _ -> rotateLeft t)
           | _ -> t
         end

    let rec add x = function
      | Empty -> leaf x
      | Node (y, _, l, r) as t ->
         begin
           match cmp x y with
           | Equal -> t
           | Less -> balance (node (y, add x l, r))
           | Greater -> balance (node (y, l, add x r))
         end

    let rec remove x = function
      | Empty -> Empty
      | Node (y, _, l, r) ->
         let rec removeSuccessor = function
           | Empty -> assert false
           | Node (x, _, Empty, r) -> (r, x)
           | Node (x, _, l, r) ->
              let (l', y) = removeSuccessor l in
              (balance (node (x, l', r)), y)
         in
         match cmp x y with
         | Less -> balance (node (y, remove x l, r))
         | Greater -> balance (node (y, l, remove x r))
         | Equal ->
            begin match (l, r) with
            | (_, Empty) -> l
            | (Empty, _) -> r
            | _ ->
               let (r', y') = removeSuccessor r in
               balance (node (y', l, r'))
            end

    let rec fold f x = function
      | Empty -> x
      | Node (y, _, l, r) -> fold f (f (fold f x l) y) r

  end
```




    module AVLSet :
      functor (M : ORDERED) ->
        sig
          type element = M.t
          val cmp : element -> element -> order
          type set
          val empty : set
          val member : element -> set -> bool
          val add : element -> set -> set
          val remove : element -> set -> set
          val to_list : set -> element list
          val fold : ('a -> element -> 'a) -> 'a -> set -> 'a
        end




Preverimo, da je `AVLSet` res učinkovitejši od `ListSet`. Najprej definiramo dve
implementaciji množic celih števil, eno s seznami in eno z AVL drevesi:


```OCaml
module SL = ListSet (struct type t = int let cmp = ocaml_cmp end)
module SA = AVLSet (struct type t = int let cmp = ocaml_cmp end)
```




    module SL :
      sig
        type element = int
        val cmp : element -> element -> order
        type set
        val empty : set
        val member : element -> set -> bool
        val add : element -> set -> set
        val remove : element -> set -> set
        val to_list : set -> element list
        val fold : ('a -> element -> 'a) -> 'a -> set -> 'a
      end







    module SA :
      sig
        type element = int
        val cmp : element -> element -> order
        type set
        val empty : set
        val member : element -> set -> bool
        val add : element -> set -> set
        val remove : element -> set -> set
        val to_list : set -> element list
        val fold : ('a -> element -> 'a) -> 'a -> set -> 'a
      end




### Množica `{1, 2, ..., n}`

Definirajte funkcijo `add_list n`, ki vrne množico (implementirano s seznami) števil od `1` do `n`. Primer uporabe:

    # SL.to_list (add_list 10) ;;
    - : SL.element list = [10; 9; 8; 7; 6; 5; 4; 3; 2; 1]


```OCaml
let rec add_list = function
| 0 -> SL.empty
| n -> SL.add n (add_list (n - 1)) ;;
SL.to_list (add_list 10)
```




    val add_list : SL.element -> SL.set = <fun>







    - : SL.element list = [10; 9; 8; 7; 6; 5; 4; 3; 2; 1]




Na enak način definirajte še funkcijo `add_avl`, ki množico implementira z AVL drevesi:

    # SA.to_list (add_avl 10) ;;
    - : SA.element list = [1; 2; 3; 4; 5; 6; 7; 8; 9; 10]


```OCaml
let rec add_avl = function
| 0 -> SA.empty
| n -> SA.add n (add_avl (n - 1)) ;;
SA.to_list (add_avl 10)
```




    val add_avl : SA.element -> SA.set = <fun>







    - : SA.element list = [1; 2; 3; 4; 5; 6; 7; 8; 9; 10]




### Čas izvajanja

Podana je funkcija `time`, ki izmeri čas izvajanja dane funkcije `f`:

   


```OCaml
let time f =
    let start = Sys.time () in
    f () ;
    let stop = Sys.time () in
    stop -. start
```




    val time : (unit -> 'a) -> float = <fun>




Funkcija `f` je »thunk«, torej sprejme le argument tipa `unit`. Čas, ki ga OCaml potrebuje, da sešteje vsa števila od 1 do 10000000:

    # time (fun () -> let s = ref 0 in for i = 1 to 10000000 do s := !s + i done; !s) ;;
    - : float = 0.17635

Izmerite, koliko časa traja vstavljanje velikega števila elementov v množico.
Primerjajte implementaciji `SL` in `SA`.


```OCaml
time (fun () -> add_list 20000) ;;
time (fun () -> add_avl 20000) ;;

```




    - : float = 5.623744







    - : float = 0.0413669999999992655




## Fold

Funkcija `fold` sprejme

* funkcijo `f` dveh argumentov,
* začetno vrednost `z` in
* množico `m = {x₁, x₂, …, xᵢ}`

ter izračuna rezultat tako, da s pomočjo `f` elemente enega za drugim kombinira s trenutno vrednostjo:

    f (… (f (f z x₁) x₂) …) xᵢₙ

Primer, kjer je funkcija `f` kar sešetvane, začetna vrednost `z` je `0` in množica `m` je `{1,2,3,4}`:

    # SL.fold ( + ) 0 (add_list 4) ;;
    - : int = 10

Signaturi [`SET`](#module_set_cell) dodajte funkcijo `fold`:

    val fold : ('a -> element -> 'a) -> 'a -> set -> 'a

in jo implementirajte v funktorjih [`ListSet`](#ListSet) in [`AVLSet`](#AVLSet).

## Unija, filter in presek

Definirajte funktor `SetOps`, ki sprejme strukturo s signaturo `SET` in
implementira funkcije `union`, `filter` ter `intersection`. Nastavek za rešitev:

    module SetOps(S : SET) =
    struct
       let union a b = …
       let filter p a = …
       let intersection a b = …
    end

Unijo in presek poznamo, funkcija `filter` pa sprejme predikat (funkcijo, ki
vrača vrednosti tipa `bool`) in množico, ter novo množico tistih elementov, ki
zadoščajo predikatu. Pri definiciji funkcij si pomagajte s funkcijo `fold`.

Primer:

    # module SA_ops = SetOps(SA) ;;
    module SA_ops :
      sig
        val union : SA.set -> SA.set -> SA.set
        val filter : (SA.element -> bool) -> SA.set -> SA.set
        val intersection : SA.set -> SA.set -> SA.set
      end
    # SA.to_list (SA_ops.filter (fun x -> x > 10) (add_avl 20)) ;;
    - : SA.element list = [11; 12; 13; 14; 15; 16; 17; 18; 19; 20]


```OCaml
module SetOps(S : SET) =
  struct
    let union a b = S.fold (fun z x -> S.add x z) a b
    let filter p a = S.fold (fun z x -> if p x then S.add x z else z) S.empty a
    let intersection a b = filter (fun x -> S.member x b) a
  end

module SA_ops = SetOps(SA)
;;
SA.to_list (SA_ops.filter (fun x -> x > 10) (add_avl 20))
```




    module SetOps :
      functor (S : SET) ->
        sig
          val union : S.set -> S.set -> S.set
          val filter : (S.element -> bool) -> S.set -> S.set
          val intersection : S.set -> S.set -> S.set
        end







    module SA_ops :
      sig
        val union : SA.set -> SA.set -> SA.set
        val filter : (SA.element -> bool) -> SA.set -> SA.set
        val intersection : SA.set -> SA.set -> SA.set
      end







    - : SA.element list = [11; 12; 13; 14; 15; 16; 17; 18; 19; 20]





```OCaml

```
