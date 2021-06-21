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
  - [Skriptiranje](#skriptiranje)
  - [Argumenti skripte](#argumenti-skripte)
  - [Spremenljivke](#spremenljivke)
  - [Pogojni izrazi](#pogojni-izrazi)
  - [Programski stavki](#programski-stavki)
- [Podlupina, preusmeritve, pogojno izvajanje in funkcije](#podlupina-preusmeritve-pogojno-izvajanje-in-funkcije)
  - [Izvajanje v podlupini](#izvajanje-v-podlupini)
  - [Preusmerjanje](#preusmerjanje)
  - [Pogojni izrazi](#pogojni-izrazi-1)
  - [Skriptiranje](#skriptiranje-1)
  - [Aritmetika](#aritmetika)
  - [Funkcije](#funkcije)
  - [Obnasanje funkcij in iteratorjev](#obnasanje-funkcij-in-iteratorjev)
  - [Ostalo](#ostalo)
- [Sistemski klici](#sistemski-klici)
  - [Jedro](#jedro)
  - [Standardna C knjiznica](#standardna-c-knjiznica)
  - [Obdelava napak](#obdelava-napak)
  - [Sledenje programom](#sledenje-programom)
- [Uporabniki](#uporabniki)
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
### Skriptiranje
- `#!` → **shebang**  
  ```bash
  #!/bin/bash

  # komentar

  exit 42
  ```
- **Zagon skripte**
  - **neposreden** → `chmod u+x skripta.sh` → `./skripta.sh`
  - **prek arumenta tolmacu** → `bash skripta.sh`
  - **v trenutni lupini** → `source skripta.sh`
- za **zaporedno izvajanje** uporabimo `EOL` ali `;`  
  ```bash
  echo -n "Vnesi svoje ime: "; read ime
  echo "Zdravo $ime"
  ```

### Argumenti skripte
- **Vgrajene spremenljivke**
  - `$#` - stevilo argumentov
  - `$0` - ime skripte
  - `$1, $2, ...` - argumenti skripte
  - `$*, $@` - vsi argumenti skripte
- `shift` ukaz

### Spremenljivke
- dekleracija ni potrebna
- **tipi**
  - `ime=vrednost`
  - `local ime=vrednost`
  - `readonly ime=vrednost`
  - `export ime=vrednost`
- **uporaba** → `${ime}` ali `$ime`
- **privzeta vrednost** → `${ime:-privzeto}` ali `${ime:=privzeto}` (nastavi vrednost)
- **podnizi**
  - `${#ime}` - dolzina niza
  - `${ime:poz}` - podniz od **poz** do konca
  - `${ime:poz:dol}` - podniz od **poz** dolzine **dol**
- `${!ime}` - kadar spr vsebuje ime spremenljivke
- **odstranjevanje podnizov**
  - `${ime#vzorec}` - najkrajsa predpona
  - `${ime##vzored}` - najdaljsa predpona
  - `${ime%vzored}` - najkrajsa pripona
  - `${ime%%vzorec}` - najdaljsa pripona
- **zamenjava podniza**
  - `${ime/vzorec/vrednost}` - prva pojavitev
  - `${ime//vzorec/vrednost}` - vse pojavitve
- **zanimive spremenljivke** → `$SHELL, $BASH, $LINES, $COLUMNS, $PWD, $RANDOM`
- `read` - prebere input (`-p` dodamo string, `-n` dodamo stevilo znakov)

### Pogojni izrazi
- `[ pogoj ]` je ukaz `test`
- `[[ pogoj ]]` ni ukaz ampak kljucna baseda
- **primerjava nizov**
  - `test -z niz` - dolzina niza enaka nic
  - `test -n niz` - dolzina niza vecja od nic
  - `test niz1 == niz2`
  - `test niz1 != niz2`
  - `test niz1 > niz2`
  - `test niz1 < niz2`
- **preverjanje datotek**
  - `test -e datoteka` - ali obstaja
  - `test -f datoteka` - ali je navadna
  - `test -d datoteka` - ali je imenik
  - `test -L datoteka` - ali je simbolicna povezava
  - `test -b datoteka` - ali je blocno oorientirana
  - `test -c datoteka` - ali je znakovno orientirana
  - ...

### Programski stavki
- **zanke**
  - `while pogoj; do ukazi; done`
  - `until pogoj; do ukazi; done`
  - `for var in spisek; do ukazi; done`
  - `for ((init; pogoj; inkrement)); do ukazi; done`
  - `break` in `continue`
- **if**  
  ```bash
  if pogoj; 
  then 
    ukazi; 
  elif pogoj; 
  then 
    ukazi; 
  else 
    ukazi; 
  fi
  ```
- **case**  
  ```bash
  case niz in
    (vzorec1) ukazi1 ;;
    (vzorec2) ukazi2 ;;
    ...
    (*) ukazi ;;
  esac
  ```

## Podlupina, preusmeritve, pogojno izvajanje in funkcije
### Izvajanje v podlupini
- **podlupina** je podproces trenutne lupine
- **navadno** `( ukaz )`
- **s substitucijo** `$( ukaz )` → `dirname $(which less)`

### Preusmerjanje
- `stdin` → deskriptor `0`
- `stdout` → deskriptor `1`
- `stderr` → deskriptor `2`
- **preusmerjanje standardnega vhoda** → `ukaz < datoteka`
- **preusmerjanje standardnega izhoda** → `ukaz > datoteka` ali `ukaz >> datoteka`
- **splosno preusmerjanje**
  - `ukaz deskriptor < datoteka`
  - `ukaz deskriptor > datoteka`
  - `ukaz deskriptor >> datoteka`
  - `ukaz deskriptor1 >& deskriptor2`
- **tukaj dokument** → `ukaz << locilo` → `cat << 'EOF' > skripta.sh`
- **tukaj niz** → `ukaz <<< niz` → `tr "13579" "123" <<< $(seg 0 9)`
- **cevovod**
  - `ukaz 1 | ukaz 2 | ... | ukaz N`
  - primer `cat /etc/passwd | cut -d -f7 | sort`

### Pogojni izrazi
- odvisni od **izhodnega statusa**
- `ukaz1 && ukaz2` **in**
- `ukaz1 || ukaz2` **ali**

### Skriptiranje
- `{ ukazi; }` - statement block

### Aritmetika
- `(( aritmetika ))` ali `$(( aritmetika ))` 
- primer `(( a = 1 + 2 * 3 ))`

### Funkcije
- `function ime { ukazi }`
- Argumenti: `$1, $2, $3, ...`
- `return vrednost` → se shrani v `$?`  
  ```bash
  function fakt {
    if (( $1 <= 1 )); then
      echo 1
    else 
      tmp=$(fakt $(( $1 - 1 )))
      echo $(( $1 * $tmp ))
    fi
  }
  ```

### Obnasanje funkcij in iteratorjev
- funkcija se obnasa kot skripta
- **preusmeritve**
  - iz datoteke  
    ```bash
    while read a; do
      echo "$a"
    done < mojadatoteka.txt
    ```
  - iz spremenljivke  
    ```bash
    studenti=(Joze Mirko Miha Janez)
    for stud in "${studenti[@]}"; do
      echo "$student"
    done

    # ali

    a=$'ena\ndva\ntri\nstiri'
    while read line; do
      echo "$line"
    done <<< "$a"
    ```

### Ostalo
- bash podpira tabele `( array )`
- `man man`

## Sistemski klici
### Jedro
- `uname` - osnovni podatki o jedru
- `/proc/` - datotecni sistem
- `dmesg` - jedrna obvestila
- `sysctl` - nastavljanje jedra

### Standardna C knjiznica
- library `glibc`
- vsebuje tudi ovojne funkcije sistemskih klicev

### Obdelava napak
- **rezultat funkcije (izhodni status)**
  - `0` - uspeh
  - `-1` - neuspeh
- `errno` - koda zadnje napake
- `perror()` - izpis obvestila o napaki  
  ```c
  #include <stdlib.h>
  #include <errno.h>
  int main(int argc, char* argv[]) {
    if (chdir(argv[1]) < 0) {
      int koda = errno;
      perror(argv[0]);
      exit(koda);
    }
    write(1, "Vse je OK.\n", 11);
    exit(0);
  }
  ```

### Sledenje programom
- `time` - merjenje casa
- `strace` - sledenje sistemskih klicev
- `ltrace` - sledenje klicem v libc

## Uporabniki