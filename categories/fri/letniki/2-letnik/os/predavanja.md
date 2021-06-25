---
layout: note
title: Izpiski predavanj
toc: true
---

## Racunalniski sistem
- **Strojna oprema (hardware)**
  - fizicna racunalniska oprema
  - procesor, pomnilnik, I/O, prekinitve, ...
- **Programska oprema (software)**
  - brez fizicne oblike
  - podatki in programi
  - **Sistemska programska oprema**: OS, goniilniki, lupina in sistemski upazi, upravljanje diska in datotek, ...

### Lupina
- Uporabniski program, ki nudi osnovni uporabniski vmesnik za upravljanje racunalniskega sistema
- **Storitve**:
  - upravljanje z datotekami, procesi, napravami in s programi
  - nadzor in konfiguracija OS
  - ...
- **Vrste**:
  - **Graficna**: graficni uporabniski vmesnik, namizno okolje
  - **Tekstovna**: tekstovni uporabniski vmesnik, ukazna lupina
  - Zvocni vmesniki: zvocni ukazi
  - Mesani nacini uporabe
- **Nacini dela**:
  - **Interaktivna uporaba**: vnos ukazov in zahteva po izvedbi -> lupina izvede ukaz in sporoci status izvedbe
  - **Neinteraktivna uporaba**: izvajanje zaporedja ukazov (skripte). Uporabnik zahteva izvedbo skripte in lupina jo izvede

### Graficna lupina
- preprosta za uporabo
- graficni uporabniski vmesnik (GUI)
- napredne vnosne naprave (tipkovnica, miska, ...)
- **Arhitektura**:
  - **Graficni vmesnik (graphical interface)**:
    - desktop environment
    - graficni elementi (okna, ikone, meniji, ...)
    - interaktivni elementi (kurzor, izbira, ...)
  - **Prikazni streznik (display server)**:
    - kominikacija z aplikacijami po protokolu
    - posreduje dogodke I/O naprav
    - upravlja izris oken (window manager)
    - izris graficnih primitivov (crta, pravokotnik, ...)
  - **Upravitelj oken (window manager)**
    - program, ki nadzoruje postavitev in prikaz oken
    - pogosto zdruzen s prikaznim streznikom
    - nacini upravljanja oken (skladovni, ploscicni, kompozitni in dinamicni)
  - **Operacijski sistem (video / GPU podsistem)**
    - Framebuffer naprava (`/dev/fb0`): dostop do video pomnilnika, upravljanje video naprave, ...
    - Direct rendering manager (`/dev/dri/card0`): podsistem za upravljanje z GPU napravami

### Upravljanje oken
- **Skladovni ali lebdeci**:
  - prekrivanje oken po principu sklada
  - izris oken v vrstnem redu glede na oddaljenost
- **Ploscicni**:
  - vec ne-prekrivajocih podrocji
  - vertikalno in horizontalno rezanje
- **Dinamicni**:
  - hibrid med ploscicnim in skladovnim
- **Kompozitni**:
  - vsako okno se izrise samo zase v vmesni pomnilnik

### Ukazna lupina
- imenujemo jo tudi tekstovna
- tekstovni uporabniski vmesnik
- napredna uporaba (programiranje, preusmerjanje vhoda in izhoda)
- tezja za uporabo kot graficna
- **REPL (read-evaluate-print loop)**
- **Tekstovni terminal (konzola)**: ukazna lupina tece v terminalu
- **Psevdo terminal**: program, ki emulira tekstovni terminal. Lahko tece v graficnem okolju.
  
### Lupina bash
- avtomatko dopoljevanje ukazov in zgodovina
- preusmerjanje, cevovodi
- izvajanje v ozadju
- **Vgrajeni ukazi**: jih neposredno podpira lupina
- **Zunanji ukazi**: nekje v `/bin` ali `/usr/bin`
- `type ukaz`: tip ukaza
- `$PATH`: pot, kjer so zunanji ukazi
- `which ukaz`: pot do ukaza
- `man ukaz` prirocnik za zunanje ukaze

### Sistemska orodja
- Upravljanje datotecnega sistema: konsistentnos strukture, ciscenje, kompresija, etc.
- Delo z datotekami: file manager, arhiverji, varnost, sinhronizacija, etc.
- Urejevalniki teksta: uproraba pri upravljanju sistema, hex urejevalniki, ukazni (premik po tekstu, etc.) in urejevalni (vstavljanje in brisanje) nacin
- Sistemska orodja: analiza delovanja sistema, konfiguracija, optimizacija, varnost, mrezna, etc.
- Razvojna orodja: 
  - programska oprema za razvoj programske opreme
  - vrste: programerski, prevajalniki, povezovalniki, etc.

## Operacijski sistem
- **Lastnosti:**
  - nabor programske opreme
  - nadzoruje izvajanje programov
  - povezuje uporabnika s strojno opremo
  - deluje kot vmesnik med programi in strojno opremo
- **Vloge:**
  - sistemski vpogled
  - upravljanje racunalniskih virov
  - nadzor nad delovanjem
  - ponudnik sistemskih storitev
- Sestavljen iz jedra, gonilnikov, lupine in sistemskih orodji
- **Storitve:** upravljanje z uporabniki, procesi, pomnilnikom, datotecnimi sistemi in datotekami, I/O napravami, medprocesna komunikacija, ...
- **Cilji**: ease of use, security, reliability, performance and flexibility

### Koncepti operacijskih sistemov
- **Abstrakcija:** 
  - posplositev in skrivanje podrobnosti
  - poenotenje in zdruzevanje podobnih entitet v eno krovno (primer `datoteka`)
- **Virtualizacija:**
  - mehanizem, ki nekaj ustvari navidezno (navidezna naprava, pomnilnik, procesor)
  - preslikava navideznega v realno
- **Abstrakcija in virtualizacija**: komplementarna koncepta. Primer: navidezni datotecni sistem `VFS` nudi enovit dostop do datotek, zdruzuje razlicne naprave in vkljucuje razlicne datotecne sisteme
- **Varnost:**
  - zaupanje v dobro delovanje sistema in jo dosezemo prek mehanizmov zascite sistema
- **Socasnost:**
  - obstoj vec procesov hkrati
  - obcutek hkratnega izvajanja vec procesov
- **Persistenca:**
  - dolgorocni obstoj podatkov in informacij
  - ucinkovitost hrambe
  - omogoca medprocesno komunikacijo (npr datoteka)
  
### Jedro
- programska koda, ki vsebuje bistveni del OS (npr upravljanje s procesi in pomnilnikom)
- izvaja se v priviligiranem nacinu delovanja procesorja (obvladuje celoten sistem)
- **Procesorki nivoji zascite:**
  - **Uporabniski prostor (zasciten nacin)**: omejena uporaba procesorja, napacna uporaba povzroci izjemo
  - **Jedrni prostor (priviligiran nacin)**: neomejen dostop do pomnilnika in naprav, nekateri ukazi se lahko izvajajo samo v tem nacinu
- **Komunikacija med jedrom in strojno opremo:**
  - **naprava**: dejanska naprava (npr tipkovnica)
  - **kontrolnik naprav**: elektronska vezja, ki razumejo ukaze podane na vmesniku in jih posredujejo napravi (npr USB kontrolnik)
  - **vmesnik strojne opreme**: mehanizem programskega podajanja ukazov napravam (npr pomnilnisko preslikan I/O)
  - **gonilniki naprav**: programska koda, ki zna upravljati z napravo preko vmesnikov strojne opreme (niso del jedra)

### Arhitektura jedra
- struktura in nacin povezovanja med posameznimi deli jedra
- **Vrste:**
  - **Monolitno jedro:**
    - velik kos strojne kode (vsebuje cel OS)
    - deli OS lahko hitro komunicirajo preko klicev funkcij
    - napaka v enem delu OS sesuje cel OS
    - tezja obvladljivost programske kode
    - sprememba izvorne kode -> ponovno prevajanje jedra
    - **DOS, FreeDOS, Windows 9x**
  - **Monolitno modularno jedro:**
    - modularna zasnova jedra (modul vsebuje gonilnik naprave)
    - module je moc vloziti in izlociti iz jedra tekom izvajanja
  - **Mikro jedro:**
    - vsebuje samo osnovne funkcionalnosti, ostale funkcionalnosti so izvedene preko procesov
    - medprocesna komunikacija (odjemalec-streznik)
    - medsebojni klici so casovno zahtevnejsi
    - prilagodljivost, varnost, porazdeljenost in enostavnejsa implementacija
  - **Hibridno jedro:**
    - zasnova je mikro jedro, izvedba pa monolitna (npr Windows NT)
  - **Nano jedro:** manjse mikro jedro
  - **Exokernel:** manjse mikro jedro, omogoca le zascito in souporabo virov
  - **Unikernel:** specificno namensko jedro za izbrano aplikacijo

## Sistemski klici
- mehanizem preko katerega uporabniski program zahteva jedrno storitev
- vsak klic ima svojo stevilko, prejme lahko tudi argumente
- stevilke in argumenti se prenasajo preko registrov in sklada
- **Tabela rokovalnikov sistemskih klicev**:
  - i-ti element tabele je naslov rokovnika
  - npr. 1 → exit, 2 → fork, 3 → read, ...
- **Preklop nivoja zascite procesorja:**
  - direkten klic podprograma v jedru sprozi izjemo zato s pomocjo strojne opreme izvedemo preklop v priviligiran nacin in klicemo podprogram
- **Sistemski vmesnik - preklop v jedro:**
  - **Namenski strojni ukaz:** procesor naredi prekop in poklice namesceni rokovalnik sistemskih klicev v jedru
  - **Programska prekinitev:** procesor naredi preklop in poklice namesceni rokovalnik prekinitve v jedru
  - Call gate: zahteva oddaljen klic v drug segment in initializacijo segmentov
  - Pomnilniska vrsta: sistemske klice postavimo v vrsto
- **Izvedba sistemskega klica:**
  1. priprava: podajanje st. sistemskega klica in arg
  2. vstop v jedro: preko sistemskega vmesnika, preklopimo v priviligiran nacin in sprozimo rokovoalnik
  3. izvedba rokovalnika sistemskega vmesnika: preverimo st klica in klic specificnega rokovalnika
  4. izvedba rokovalnika sistemskega klica: navaden klic rutine znotraj jedra
  5. iztop iz jedra: preklop nazaj v uporabniski nacin
- **sistemski klic vs klic funkcije:** 
  - sistemski klic je pocasnejsi (preklop nivoja zascite)
  - izvedba rokovalnika klica je zahtevnejsa
  - podpora procesorja: funckijski (strojni ukaz), sistemski (poseben mehanizem)
  - za funkcijske je OS kot programska knjiznica
  - funkcijski klici so manj varni
  - lunkja v sistemskem klicu lahko sesuje celoten os
  - luknja v funkcijskem klicu sesuje lahko le program
  - sistemski klic je tudi mehanizem zascite

### Ovojne funkcije sistemskih klicev
- neposredna izvedba je zahtevna (assembly) saj je potrebno rokovanje z registri in vstop v jedro
- Ovojna funkcija je namenjena izvedbi sistemskega klica
- je v standardni kljiznici
- npr fork (`unistd.h`)
- **Izvedba sistemskega klica:**
  - **neposredno:** nastavitev registrov in vstop v jedro v zbirniku
  - **specificne ovojne funkcije:** predpripravljena ovojna funkcija iz knjiznice
  - **splosne ovojne funkcije:** `syscall()`
  - **posredno preko ostalih funkcij:** npr `printf()`

### Standardi
- **API:** application programming interface. Vmesnik za uporabo programskih knjiznic. Temelji na simbolicni predstavitivi
- **ABI:** application binary interface. Temelji na stevilski predstavitvi.
- POSIX - standard `IEEE 1003`:
  - prenosljiv vmesnik operacijskega sistema
  - programski vmesnik med aplikacijami in OS
  - predpisuje funkcije, ukazno lupino, ...
  - standard omogoca prenosljivost programov
- Skladnos s SUS standardom:
  - **certificirani Unix**
  - **ne-certificirani Unix**
  - **ostali ne-certificirani**

## Upravljanje z uporabniki
### Varnost in zascita
- **Zascita:**
  - mehanizem za nadzor dostopa do virov (sciti pred nodovoljeno uporabo virov)
  - pravila uporabe, politika (policy)
  - naloga OS: os je odgovoren za vzpostavljanje zascite virov, ki jih upravlja
- **Varnost:**
  - mera zaupanja v ohranjanje integritete sistema
  - vkljucuje tudi okolje
  - zascita virov pred *omreznim dostopom (firewall)*, *fizicnim dostopom* in *uporabniska ozavescenost*
- **Nacela nacrtovanja varnosti:**
  - mehanizem zascite mora biti **javen**
  - privzeto dovoljenje = **ni dostopa**
  - **sprotno preverjanje dovoljnenj**
  - procesi naj imajo **najmanjse mozne privilegije**
  - mehanizem naj bo **preprost, celovit in vgrajen**
  - shema varnosti naj bo **uporabnisko prijazna**

### Uporabniski racun
- **Uporabnik:** oseba, ki uporablja racunalniski sistem (zabava, programiranje, vzdrzevanje, etc.)
- uporabniki si lahko podatke delijo ali ne
- **Vrste:** *navaden*, *admin/root*, *superuser* in *gost*
- **Stevilo uporabnikov OS:** *brezuporabniski (enouporabniski)* in *vecuporabniski*
- **Uporabniski racun:**
  - mehanizem za **razlikovanje med uporabniki**, **prijavo v sistem** in **locevanje virov med uporabniki**
  - **Podatki o uporabniku:**
    - **Osebni:** stevilka, ime, priimek, ...
    - **za prijavo:** ime in geslo, imenik, ...
    - **za mehanizem zascite:** skupine

### Prijava v sistem
- **Identifikacija:** kdo je dani uporabnik
- **Avtentikacija:** potrjevanje identitete
- Nacini avtentikacije:
  - **pomnenje podatkov:** gesla, pin, podpis, ...
  - **fizicne lastnosti:** prstni odtis, ...
  - **fizicne naprave:** RFID, ...
- Nacini dostopa: **lokalna prijava** in **oddaljena prijava** (npr ssh)

### Uporabniki v Linuxu
- **Administrator:** `root`, imenik `/root`, ima vsa dovoljenja in odgovornosti
- **Ostali uporabniki:** `<username>`, imenik `/home/<username>`
- **Uporabniski racuni:**
  - `/etc/passwd`: vse razen podatki o geslu (`ime:x:uid:gid:polno ime: domaci imenik:prijavna lupina`)
  - `/etc/shadow`: hrani zgoscene vrednosti (hash) gesel za uporabnike in skupine (`ime:$metoda$sol$koda:ostalo (rok trajanja gesel itd.)`)
  - **Sol:** nakljucni niz dodan geslu pred zgoscanjem. Namenjen temu da imata 2 enaki gesli z razlicno soljo razlicna hasha. onemogoci napad z mavricno tabelo (rainbow table)
  - `etc/group`: hrani seznam uporabnikov, ki se pripadajo skupini poleg skupine zapisane v `etc/passwd` (`ime skupine:x:gid:seznam uporabnikov`)

## Upravljanje z datotekami
### Datotecni sistem
- pomnilni medij oz pomnilna naprava, ki omogoca dolgotrajno hranjenje podatkov
- OS premosca vrzel med medijem in uporabnikom
- **Logicna organizacija podatkov:**
  - Visoko nivojski pogled: uporabnikov pogled na podatke
  - OS nudi enotno abstrakcijo podatkov
  - osnovni koncep med OS je datoteka
- **Fizicna organizacija podatkov:**
  - nizko nivojski pogled: za uporabnika je skrit
  - nacin in oblika zapisa podatkov in metapodatkov
  - nacin se prilagodi pomnilnem mediju
  - **gonilnik datotecnega sistema** je program, ki skrbi za specificen datotecni sistem
- **Datoteka:**
  - osnovna zakljucena zbirka podatkov
  - hrani neko vsebino
  - **meta podatki:** npr ime datoteke, velikost, lastnik, etc.
- **Imenik:**
  - omogoca zdruzevanje datotek
  - vsebuje datoteke in druge imenike
  - hierarhicna struktura
- **Hierarhicna struktura imenikov:**
  - gnezdenje imenikov in datotek
  - odnosi: **podimenik** in **nadimenik**
  - **korenski imenik (root directory)**: imenik, ki nima nadimenika
- **Naslavljanje datotek:** *absolutna pot* je pot od korenskega imenika, *relativna pot* je pot ki se pricne v delovnem imeniku

### Datoteke
- **Abstrakcija datoteke:**   

  |oznaka|opis|primer|
  |:-|:-|:-|
  |`-`|regular file|`/etc/passwd`|
  |`d`|directory|`/bin`|
  |`s`|symbolic link|`/usr/src/linux`|
  |`b`|block special device|`/dev/sda`|
  |`c`|character special device|`/dev/tty`|
  |`p`|named pipe||
  |`s`|socket||

- **Navadna datoteka:**
  - vsebina je poljubna (binarna ali tekstovna)
  - OS omogoca notranje operacije
  - vrsto datoteke doloca koncnica `<name>.*`
- **Imenik:**
  - posebna datoteka, ki vsebuje seznam imeniskih vnosov (**imeniski vnos (directory entry)** vsebuje ime in kazalce na ostale podatke)
- **Simbolicna (mehka) povezava:**
  - posebna datoteka, ki vsebuje simbolicne povezave (pot do ciljne datoteke)
  - ukazi na datoteko operirajo na ciljni datoteki
  - ukaz `ln -s`
- **Simbolicna (trda) povezava:**
  - dodaten imeniski vnos za isto datoteko
  - razlicni imeniski vnosi lahko predstavljajo isto datoteko
  - ukaz `ln original trda`
  - veckratne trde povezave
- **Blocna in znakovna naprava:**
  - dva posebna tipa
  - branje in pisanje se neposredno nanasa na napravo
  - **blocne naprave:** dostop po blokih
  - **znakovne naprave:** dostop po znakih
- **Cev (pipe) in vticnica (socket):**
  - mehanizem za medprocesno komunikacijo
  - naslavljajo preko imen datotek
  - **imenovana cev (named pipe):** FIFO, ustvarimo z `mkfifo`
  - **lokalna vticnica (local socket):** Unix domain socket, poseben vmesnik

### Kodiranje datotek
- **Kodiranje znakov:**
  - preslikava **zaporedja bytov v znake** (moresejeva koda, braillova pisava)
  - pomembno za tekstovne datoteke
- **Kodiranje ASCII**
  - 7b kodiranje
- **Izzivi internacionalizacije**
  - manjkajo znaki ne-angleskih jezikov
  - razsiritev ASCII na 8b
- **Unicode**
  - nabor UCS (universal character set)
  - 21b kodni prostor
  - *kodirani znaki 143.859 znakov in 154 pisav*
- **Razlicna kodiranja**
  - UTF: unicode transformation format
  - UTF-32: 4B zacetni biti so 0, **prostorsko neucinkovit**
  - UTF-16: 1B ali 2B besedi
  - **UTF-8**
    - razsirjen ASCII, se ujema na prvih 128 znakov
    - 1 do 4B/znak
    - samo-sinhronizacija
- **Skok v novo vrstico**
  - **LF:** naslednja vrstica
  - **CR:** skok na zacetek vrstice
  - WP:Newline

### Pripenjanje naprav
- pripenjanje vec pomnilnih naprav omogoci dostop vseh naprav
- vsaka naprava ima svojo imenisko strukturo
- v **windows** sistemih je vec locenih imeniskih struktur (C:, D:, ...) v **unix** sistemih pa je ena enotna (root)
- **Vec imeniskih struktur:** vsaka naprava ima svoj znak (C:, D:, ...)
- **Enotna imeniska struktura:** naprave so dostopne prek nekaterih imenikov (podstruktura na podan imenik)
- **Korenski datotecni sistem:**
  - vsebuje datoteke, pomembne za zagon OS
  - se priklopi in pripne ob zagonu OS na korenski imenik enotne imeniske strukture
- **Pripenjanje (mount)**
  - pripenjanje dodatnega datotecnega sistema v obstojeco imenisko strukturo
  - **tocka pripenjanja (mount point)** je ciljni imenik v obstojeci imeniski strukturi kamor zelimo pripeti dodatni datotecni sistem (`/mnt/...`)
  - tocka pripenjanja se prekrije s korenskim imenikom
  - ukaza `mount` in `unmount`

### Nadzor dostopa
- doloca **kdo** lahko **kaj** pocne **s cim**
- *kdo?* **subjekt** je uporabnik, skupina, proces ali obmocje zascite
- *kaj?* **dovoljenje** za operacije nad datoteko (npr branje)
- *s cim?* **objekt** zascite je navadna datoteka lahko pa tudi naprava, pomnilnik, ...
- **Matrika dostopa**
  - **stolpci:** objekti nadzora dostopa
  - **vrstice:** subjekti, ki dostopajo
  - **elementi:** nabor dovoljenj  

    |  | Datoteka 1 | Datoteka 2 | Datoteka 3 | Datoteka 4 |
    |-|-|-|-|-|
    | Uporabnik A | lastnik, R, W | R, X | lastnik, R ||
    | Uporabnik B |  | lastnik, R, W, X | R ||
    | Uporabnik C | W |  |  | lastnik, R |

- **Nadzorni seznam dostopa (access control list)**
  - dekompozicija matrike dostopa po stolpcih
  - stolpci matrike predstavljajo seznam dostopa  
    ```
    Datoteka 1: (A, lastnik, R, W), (C, W)
    Datoteka 2: (A, R, X), (B, lastnik, R, W, X)
    Datoteka 3: (A, lastnik, R), (B, R)
    Datoteka 4: (C, lastnik, R)
    ```
- **Seznam zmoznosti (capabillities list)**
  - dekompozicija matrike dostopa po vrsticah
  - vrstice matrike predstavljajo zmoznosti  
    ```
    Uporabnik A: (1, lastnik, R, W), (2, R, X), (3, lastnik, R)
    Uporabnik B: (2, lastnik, R, W, X), (3, R)
    Uporabnik C: (1, W), (4, lastnik, R)
    ```
- **Zascita datotek v Unix/Linux sistemih**
  - vrste dovoljenj: **r** - **r**ead, **w** - **w**rite, **x** - e**x**ecute, **-** - prazno
  - sklopi uporabnikov: **u** - **u**ser (lastnik), **g** - **g**roup (skupina), **o** - **o**ther, **a** - **a**ll (vsi)
  - `[user][group][other]` → `rwxrwxrwx` → `rw-r-xr--`  

    |znak| datoteka |imenik|
    |-|-|-|
    |`r`| branje datoteke | izpis vsebine datoteke|
    |`w`| pisanje oz. spreminjanje datoteke | spreminajanje imenika (ustvarjanje in brisanje datotek v imeniku) |
    |`x`| izvajanje oz. datoteke je izvršljiva| vstop v imenik (sistemski klic chdir oz. ukaz cd) |

## Procesi
- **Program** je **pasivna** entiteta, ki je shranjen v izvrsljivi datoteki
- **Proces** je **aktivna** entiteta, ki je program v izvajanju
- Stanje programa dolocajo podatki, sklad, kopica, datoteke in IO naprave
- Proces tekmuje z drugimi procesi za vire
- **Glavni nalogi**
  - **lastnistvo** oz zascita virov
  - **izvajanje kode** sledi neki poti preko vec programov
  - nalogi sta neodvisni storitvi:
    - **procesi** so povezani z lastnistvom virov
    - **niti** so povezane z izvajanjem kode
- **Storitve OS** so *ustvarjanje procesa*, *koncanje procesa*, *odlozitev izvajanja processa*, *komunikacija med procesi*, *resevanje sporov pri virih*, ...
- **Sestava procesa**
  - **programska koda** je strojna koda, ki se lahko izvaja na procesu
  - **sklad** so podatki, pomembni za izvajanje
  - **kopica** so dinamicno alocirani podatki
  - **podatki** so ostali podatki, ki jih proces obdeluje
  - **deskriptor procesa** so dodatni nadzorni podatki, ki jih os potrebuje za upravljanje procesa
- **Naslovni prostor procesa** je pomnilnik, ki ga proces lahko naslavlja

### Zivljenje procesa
- **Stvaritev procesa**
  - **Razlogi**
    - **prevzem novega posla v paketnih OS**
    - **zagon programa preko lupine**
    - **prijava uporabnika v sistem**
    - **zagon servisa OS**
    - **programsko izkoriscanje socasnosti**
    - **vzporedno procesiranje**
  - **Hierarhija procesov**
    - **stars:** proces, ki je podal zahtevo po stvaritvi novega procesa - otroka
    - **otrok:** proces, ki je bil ustvarjen na zahtevo drugega procesa - starsa
    - OS vodi evidenco procesov
    - **PID (process identification)** je stevilka procesa
    - **PPID (parent PID)** je stevilka starsa (stars ne ve PID otroka)
  - **Storitev OS**
    - **priprava procesnega deskriptorja:** init PID, PPID in stanje, podajanje argumentov in vstavitev v vrsto za razvrscanje
    - **priprava pomnilniskega prostora:** navidezni pomnilnik in preslikovalna tabela naslovov
    - **razno:** preverjanje pravic in zascite in priprava odprtih datotek
  - **nalaganje iz izvrsne datoteke:** program se nalozi in zacne izvajati(**eager** - nalaganje celotnega programa pred izvajanjem, **lazy** - nalaganje po potrebi)
  - **stvaritev iz obstojecega procesa:** stars in otrok si delita vire (niti) lahko pa tudi **kloniram** kar pomeni da je otrok kopija starsa (`fork()`)
- **Koncanje procesa**
  - **Razlogi**
    - **normalen zakljucek:** preko sistemskega klica (npr `exit()`)
    - **napaka pri izvajanju:** npr aritmetika, napaka zascite, priviligiran ukaz
    - **na zunanjo zahtevo:** s strani drugega procesa, prekoracitev virov
  - **Storitev OS**
    - **sprostitev zasedenih virov**
    - **sprostitev deskriptorja procesa:** pogosto zakasnjena

### Stanje procesa
- glede na to ali se proces izvaja, caka na rezultat IO, ...  
![](img_predavanja/stanje_procesa.png)  
- **nov:** ko se ustvari, inicializacija deskriptorja procesa, alokacija potrebnih virov
- **koncan:** ko se ukinja, sprostitev zasedenih virov
- **pripravljen:** pripravljen in caka na dodelitev procesorja
- **izvajan:** dejansko izvajanje na procesorju
- **cakajoc:** caka na nek dogodek, da nadaljuje
- **aktiven:** *izvajan* ali *pripravljen*
- **ni aktiven:** cka na nek dogodek

### Podatkovne strukture
- **Podatkovne strukture za opravljanje procesov**
  - **seznami:** vrsta pripravljenih/cakajocih procesov
  - **informacije o procesu:** deskriptior procesa
- **Deskriptior procesa**
  - jedrna podatkovna struktura
  - hrani nadzorne podatke procesa (id, stanje, ...)
  - omogoca preklapljanje procesov  
  ![](img_predavanja/deskriptior_procesa.png)

## Vecopravilnost
### Virtualizacija procesorja
- izziv je socasno izvajati poljubno stevilo procesov
- **Stevilo procesorjev**
  - **vecprogramiranje / multiprgoramiranje:** socasno izvajanje vec programov oz procesov na enem procesorju
  - **vecprocesiranje / multiprocesiranje:** vzporedno izvajanje vec programov na vec procesorjih (procesor je **vecjedrni** ali **vecnitni**)
- **Deljenje vira med vec entitetami**
  - **casovno dodeljevanje (time sharing)**
    - vsaka entiteta uporablja vir nekaj casa (**casovna rezina** je cas uporabe vira)
    - delijo si procesor in omrezno povezavo
  - **prostorsko dodeljevanje (space sharing)**
    - vsaka entiteta uporablja del vira
    - delijo si pomnilnik in diskovni prostor
- **Vecopravilnost (multitasking)**
  - vrsta programiranja
  - izvajanje vec procesov hkrati
  - preko **casovnega dodeljevanja**
  - vrsti: **sodelovalna / brez odvzemanja** in **prekinjevalna / z odvzemanjem**
- **Sodelovalna vecopravilnost**
  - temelji na sodelovanju procesov
  - odvzem procesorja je mozen znotraj sistemskih klicov
  - eksplicitno prepuscanje procesorja (`yield`)
  - predpostavi se razumno obnasanje procesov
  - racunsko intenzivni procesi lahko "ugrabijo" procesor
- **Prekinjevalna vecopravilnost**
  -  temelji na odvzemanju procesorja oz prekinjanju procesa (npr timer). Nadzor ima OS
  -  **casovna rezina:** 
     -  cas, ki ga ima proces na voljo
     -  po izteku se dodeli procesor drugemu procesu
     -  prekinjen proces se postavi v vrsto

### Neposredno izvajanje
- **Neomejeno neposredno izvajanje**
  - samo pozene program
  - **hitro:** program se direktno izvede
  - **izvajanje v celoti**
  - **neizkoriscenost virov:** proces caka npr IO
  - **tezak nadzor:** nemogoce nadzorovati
  - **TEZAVA:** OS ne tece vedno → izgubi nadzor nad sistemom
  - **RESITEV:** strojna podpora (uporabniski in jedrni nacin, preklopi, prekinitve, syscall)
- OS dobi nadzor ob
  - strojni prekinitvi
  - izjemi
  - sistemskem klicu
  - **prozenju ustreznega rokovalnika**
    - **PSP:** prekinitveno servisni program
    - **vstop v jedrni rokovalnik:** statusni register in PC na sklad, prekinitve se onemogocijo, izvedba rokovalnika in nivo zascite se preklopi na jedrni
    - **vrnitev iz rokovalnika:** statusni register in PC iz sklada, nivo zascite se proklopi na uporabniski
    - za ostale registre poskrbi rokovalnik
- **Omejeno neposredno izvajanje**
  - init rokovalnike prekinitev in pasti, rokovalnik syscall in casovnik
  - pozene program in pocakaj da OS dobi nadzor

### Preklop procesa
- vec procesov socasno v sistemu → casovno dodeljevanje → potrebno je **razvrscanje procesov** → mehanizem zamanjave procesa
- **Preklop procesa** se izvede na koncu rokovalnika, tik pred menjavo nacina
- preklop ni vedno potreben lahko se vrnemo v isti proces
- **Izvedba**
  - izbira drugega procesa (**razvrscevalnik**)
  - sprememba stanj procesov
  - preklop konteksta (PS, sklad, statusni in ostali registni) → v deskriptor procesa shranimo kontekst in obnovimo kotekst izbranega procesa
- **Ucinkovitost** je odvisna od
  - **strojne opreme:** hitrost pomnilnika, procesorja in stanje procesorja, ...
  - **operacijskega sistema:** zapletenost komponent, razvrscevalni algoritem, ...
  - v modernih sistemih traja preklop procesa pod `1 qs`

## Razvrscanje
- odlocanje o tem, kateri proces se razvrsti na viru → kljucno za zagotavljanje vecopravilnosti
- pogledi: **dolgorocno (job scheduling)**, **srednjerocno (swapping)** in **kratkorocno (CPU scheduling)**
- **Razvrscanje poslov (dolgorocno)**
  - paketna obdelava → enota obdelave je **posel**
  - posli cakajo in ko so izbrani se nalozijo in zacnejo izvajati
  - **job scheduler** je del OS, ki skrbi za razvrscanje poslov
  - navadno ni podprto na modernih OS
- **Menjava procesov (srednjerocno)**
  - disk se uporabi za umikanje procesov, npr ce primankuje pomnilnika proces umaknemo na disk sprostimo vire in ga potem lahko nalozimo nazaj
  - menjalnik (**swapper**) izbira procese za umik in vracanje (enakomerna obremenitev virov)
- **Razvrscanje na procesorju (kratkorocno)**
  - odloca o tem, kateri proces dobi moznost izvajanja na procesorju
  - kljucno za zagotavljanje vecopravilnosti
  - **Razvrscevalnik (scheduler)** je del upravitelja procesov in izbira enega izmed pripravljenih procesov
  - **Dodeljevalnik (dispatcher)** preklip procesa iz trenutnega na izbranege
- Razvrscevalnik se aktivira ko
  - proces konca
  - proces onemogoci
  - konec casovne rezine
  - konec cakanja
  - nov proces
- **Casovna rezina**
  - **racunsko intenzivna opravila:** rajsi daljse casovne rezine, omejijo stroske preklopa, vecja izkoriscenost procesorja
  - **interaktivna opravila:** krajse casovne rezine, procesi prej pridejo na vrsto, boljsa uporabniska izkusnja

### Mere zmogljivosti
- **Paketni sistemi**  
  [](img_predavanja/paketni_sistemi.png)  
  - **cakalni cas:** $$T_{cakalni} = T_{zacetni} - T_{prihodni}$$
  - **odzivni cas:** $$T_{odzivni} = T_{v/i} - T_{prihodni}$$
  - **cas obdelave:** $$T_{obdelave} = T_{koncni} - T_{prihodni}$$
- **Interaktivni sistemi**  
  [](img_predavanja/interaktivni_sistemi.png)
  - **cakalni cas:** celoten cas v stanju pripravljen
  - **odzivni cas:** $$T_{odzivni} = T_{zacetni} - T_{prihodni}$$ (predpostavimo $$T_{zacetni} = T_{v/i}$$)
  - **cas obdelave:** $$T_{obdelave} = T_{koncni} - T_{prihodni}$$
- **Ostale mere**
  - **izkoriscenost procesorja (processor utilization):** delez zaposlenosti procesorja
  - **prepustnost sistema (system troughput):** stevilo obdelanih procesov v danem casovnem obdobju
  - **postenost (fairness):** enakomernost delitve procesorja procesom

### Razvrscevalni algoritmi
- **Osnovni**
  - **FCFS:** prvi pride prvi melje
  - **SJF:** najkrajsi posel naprej
  - **PSFJ:** prekinjevalni najkrajsi posel naprej
  - **RR:** krozno razvrscanje
- **Prednostni**
  - **HPF:** najvisja prioriteta naprej
  - razvrscanje s prepustnicami
  - koracno razvrscanje
- **Prakticni**
  - **MLFQ:** vecnivojska odzivna vrsta
  - razvrscevalnik Linux
  - **CFS:** ppoplnoma posteno razvrscanje

### Osnovni algoritmi
- **FCFS** - first come, first served oz **FIFO** - first in, first out
  - **proces, ki je prej pripravljen, prej dobi procesor**
  - procesi na konec vrste, vzame se iz zacetka vrste
  - lastnosti:
    - razvrscanje **brez odvzemanja**
    - slab odzivni cas
    - dober cas obdelave
- **SJF** - shortest job first
  - **najkrajsi pripravljen posel dobi procesor**
  - potrebno je vnaprejsnje poznavanje dolzine poslov
  - lastnosti:
    - razvrscanje **brez odvzemanja**
    - algoritem je optimalen
    - slab odzivni cas
    - odlicen cas obdelave
- **PSJF** - preemptive shortest job first
  - **pripravljen posel z najkrajsim preostankom casa prej dobi procesor**
  - vnaprejsne poznavanje dolzin poslov
  - lastnosti:
    - razvrscanje **z odvzemanjem**
    - slab odzivni cas
    - odlicen obracalni cas
- **RR** - round robin
  - **pripravljene posle krozno razvrscamo zaporedoma, vsakega za nekaj casa**
  - procesi na konec vrste, vzame se iz zacetka vrste
  - izvajanje za dolocen cas (**casovna rezina**)
  - **casovna rezina** mora biti dovoj kratka za odzivnost in dovolj dolga za opravicitev casa preklopa
  - lastnosti:
    - razvrscanje **z odvzemanjem**
    - odlicen odzivni cas
    - slab cas obdelave
- **Ocena casa izvajanja**
  - **t** ... trajanje zadnjega teka procesa
  - **t'** ... ocena trajanja teka
  - **α** ... faktor pozabljanja (`α = 1` preteklost se ne uposteva, `α = 0` trajanje zadnjega teka nima vpliva)
  - $$t' := \alpha \cdot t + (1 - \alpha) \cdot t'$$
- **Vkljucevanje I/O operacij:** tekom i/o operacij je proces blokiran zato je bolje da prekrivamo izvajanja

### Prednostni algoritmi
- **prednostno razvrscanje:** algoritmi dajejo prednost glede na neko lastnost
- uposteva se prioriteta procesov (**notranja** - odvisna od lastnosti (npr trajanje) in **zunanja** - dolocena s strani uporabnika)
- **HPF** - highest priority first
  - **pripravljen posel z najvisjo prioriteto dobi procesor**
  - **z odvzemanjem:** ce ima prispeli proces visjo prioriteto zamenjamo
  - **brez odvzemanja:** pocakamo da trenutni proces prepusti procesor
- **Upostevanje prioritete procesov**
  - tezava se pojavi pri **stradanju:** procesi z visjo prioriteto nenehno prehitevajo
  - resitev je **staranje:** procesom, ki ne dobijo procesa vsake toliko povecamo prioriteto
- **SIRO** - service in random order
  - **razvrscanje po neki shemi nakljucnosti**
  - z ali brez odvzemanja
- **Lottery scheduling**
  - **dolocanje procesa z loterijo**
  - proces $$i$$ ima $$p_i$$ prepustnic
  - proces z visjo prioriteto dobi vec prepustnic
  - razvrscevalnik nakjucno izbere eno prepustnico in lastniku prepustnice dodeli procesor
  - lahko prepuscajo prepustnice drugim
  - verjetnost izbire k-tega procesa $$\frac{p_k}{\sum^{n}_{i=1}{p_i}}$$
- **Stride scheduling**
  - **proces, ki je najmanj prehodil, naprej**
  - ob stvaritvi dolocimo dolzino koraka
  - visja prioriteta → krajsi korak
  - procesu, ki je prehodil najmanj se dodeli procesor

### Prakticni algoritmi
- **MLQ** - multilevel queue
  - interaktivna in paketna opravila
  - vecnivojska vrsta: padajoce po prioriteti in narascajoce po casovni rezini
  - znotraj vrste se uporablja RR
- **MLFQ** - multi-level feedback queue
  - prehajanje med vrstami
    - ob prihodu najvisja prioriteta
    - ce posel porabi celo casovno rezino dekriemntiramo prioriteto
    - po dolocenem casu imajo vsi posli najvisjo prioriteto
  - ce posel vracas procesor tik pred iztekom rezine se mu prioriteta zmanjsa
- **Razvrscevalnik Linux O(1)**
  - izvira in dodajanje opravil v konstantnem casu
  - z odvzemanjem in proiriteto
  - aktivna in pretecena tabela
- **CFS** - popolnoma posteno razvrscanje
  - postenost: v danem casovnem intervalu naj posli dobijo delez, ki je enakovreden prioriteti
  - LINUX CFS razvrscevalnik
    - izbira posle z najmanjsim porabljenim caosm izvajanja
    - izvaja toliko casa, da ujamemo naslednji posel z najmanjsim porabljenim casom
    - po izvedbi se posel vstavi v drevo z novim skupno porabljenim casom izvajanja
    - nizja prioriteta cas tece hitreje

## Upravljanje s pomnilnikom
### Naslovni prostor
- **Pomnilnik** se deli se na **fizicni** in **naslovni** (kot ga vidi procesor, abstrakcija fizicnega)
- Vcasih je bil **logicni naslov = fizicni naslov**, pomnilnik se je delil na `[OS | ostalo]` in OS je bil kot knjiznica
- **Vecprogramiranje**
  - vec procesov v pomnilniku → deljenje pomnilnika → preklaplanje procesov → zascita procesov
  - Izgled `[OS | Proces A | Proces B | Proces C]`
- **Naslovni prostor**
  - pomnilnik kot ga vidi procesor → vidi samo svoj kos
  - sestaljen je iz **kode**, **kopice**, **sklada**, ...
  - navidezni naslov se preslika v fizicni naslov
  - Izgled `[koda | kopica | prosto | sklad]`
- **Dolocanje naslovov**
  - **cas prevajanja (compile time):** zbirnik ali prevajalnik doloci naslove simbolov oz spremenljivk
  - **cas povezovanja (link time):** zlaganje vec predvidenih modulov skupaj
  - **cas nalaganja (load time):** prenosljiva koda, poljubna lokacija
  - **cas izvajanja (run time):** premikanje in izmenjava procesov
- **Zascita procesa:**
  - naslovni prostor procesa je izoliran (za to skrbi OS)
  - preverja se naslove (preslikava na prosto ni dovoljena) in dovoljenja

### Pomnilniski API - libc
- **Aloacija pomnilnika**
  - **sklad** se implicitno alocira in dealokacija preko prevajalnika. Hrani lokalne spremenljivkem argumente funkcij in izvajalne podatke
  - **kopica** se eksplicitno alocira in delocira
- **Standardna knjiznica v C**
  - **alokacija pomnilnika**  
    ```c
    void* malloc(size_t size)
    // ali calloc(...), realloc(...)
    ```  
  - **dealokacija pomnilnika**  
    ```c
    free(void* ptr)
    ```  

## Pomnilniske storitve OS
- **Klasicne napake**
  - alokacija premalo pomnilnika → `malloc(strlen(s) + 1)`
  - pomnilnik ni inicializiran
  - prezgodnja sprostitev pomnilnika
  - veckratna sprostitev pomnilnika
  - napacna sprostitev pomnilnika
  - memory leak (pozabimo sprostiti)
- **Kaj naredi** `exit()`
  - sprosti naslovni prostor procesa
  - pomnilnik pusca le znotraj procesa
- **Velikost podatkovnega segmenta (kopice)**
  - sistemski klic `brk(...)`
  - **nastavljanje velikosti:** `void* brk(void* addr)`
  - **spreminjanje velikosti:** `void* sbrk(int incr)`
  - **trenutna velikost:** `brk(0)`
-  **Alokacija in preslikava pomnilnika**
   -  **alokacija in preslikava**  
    ```c
    void* mmap(void* addr, size_t len, int prot, int flags, int fd, off_t offset)
    ```   
  - **sproscanje pridobljenega pomnilnika**  
    ```c
     void* munmap(void* addr, size_t length)
    ```    
- **Randomizacija naslovnega prostora**
  - **ASLR** - address space layout randomization
  - **KASLR** - kernel ASLR
  - to se pojavi zaradi moznega **napada** (skok v okvarjeno kodo na nek znan fiksen naslov)
  - **resitev** je nakljucna razporeditev kljucnih delov naslovnega prostora (tezje se najde naslov)

## Virtualizacija pomnilnika
- **Cilji**
  - proces vidi **sklenjen kos pomnilnika**
  - **izolirani procesi** (mehanizem zascite)
  - **transparentnos** (proces se ne zaveda)
  - **ucinkovitost** (hitra preslikava)
- **Preslikava naslovov**
  - **navidezni naslov** → **fizicni naslov** ($$PA = f(VA)$$)
  - **OS skrbi za konfiguracijo**
  - **MMO** izvaja preslikavo
  - **TLB** skrbi za ucinkovitost preslikovanja
- **Izvedba preslikovanja**
  - izvedba za **vse navidezne naslove je nemogoca**
  - naslovni prostor premestimo na **poljubno mesto v fizicnem pomnilniku** (**realocation**)
  - **segmentacija** razdeli pomnilnik na bloke razlicnih velikosti. Segmenti so razdeljeni na strani
  - **ostrjevanje (paging)** razddeli pomnilnik na bloke enake velikosti
- **Staticno premescanje**
  - program se prevede na naslov 0
  - program se nalozi na izbrani **ciljni fizicni naslov**
  - **tezava** se pojavi pri dinamicnih naslovih (**ponovno premescanje programov**)
  - uporabimo le ce ni podpore za virtualizacijo
- **Dinamicno premescanje**
  - program se nalozi na izbrani **ciljni fizicni naslov**
  - **bazni register** hrani nalagalni naslov
  - **mejni register** hrani velikost naslovnega prostora
  - **enostavno** preslikovanje, zascita in premescanje
  - **MMU** je bazni in mejni register za izvedbo preslikovanja in preverjanja zascite
  - **pasti**
    - **prekoracitev baznega registra** → OS ukine proces
    - **izvedba priviligeranih ukazov** → OS ukine proces
    - posebne strojne ukaze za manipuliranje baznega in mejnega registra uporablja le OS 
- **Segmentacija in ostrjevanje**
  - pomnilnik razdeljen na bloke velikosti $$2^P$$  
    ![](img_predavanja/preslikovanje.png)  
  - iz **M**b navideznega v **N**b fizicni    

    |Segmentacija|Ostrjevanje|
    |-|-|
    |blok: segment| blok: stran in okvir|
    |segmenti razlicnih velikosti| enake velikosti strani|
    |segmenti imajo pomen (npr koda)|strani nimajo pomena|
    |tezavno upravljanje pomnilnika|lahko upravljanje pomnilnika|
    |zunanja fregmentacija|notranja fregmentacija|

  - v sodobnih OS se uporablja le ostrjevanje

### Ostrjevanje
- **stran** je blok v navideznem naslovnem prostoru
- **okvir strani** je blok v fizicnem naslovnem prostoru (hrani poljubno stran, enake velikosti kot stran)
- **Preslikovanje:** **navidezni naslov** (`naslov strani + odmik`) → **fizicni naslov** (`naslov okvirja + odmik`)  
  ![](img_predavanja/ostrjevanje.png)
- **Preslikovanje s tabelo strani**  
  ![](img_predavanja/preslikovanje_s_tabelo_strani.png)
- **velikost tabele strani** je $$2^{M - P}$$ deskriptorjev v tabeli
- **resitvi:** vecnivojska tabela strani in invertirana tabela strani
- **Ucinkovitost preslikovanja**
  - **ena preslikava:** `st. dostopov do pomnilnika = st. dostopov do tabel in podtabel strani + 1`
  - **resitev:**
    - **TLB** - translation lookaside buffer
    - preslikovalnik predpomnilnik
    - prostorska lokalnost
    - casovna lokalnost
- **Naloge OS**
  - evidenca prostih okvirjev strani
  - upravljanje preslikovalnih tabel (stvarite in koncanje procesa in preslikava pomnilnika)
  - poznavanje TLB ob preklopu procesa

### Uporaba zunanjega pomnilnika
- **pomnilniska hierarhija:** **notranji (fizicni)** je `RAM` in **zunanji** je `HDD/SSD`
- **izziv** je zagotoviti vec navideznega naslovnega prostora kot je velikost fizicnega
- **Pomnilniski prekrivki (memory overlays)**
  - star pristop
  - program je razdeljen na vec kosov ki so shranjeni v datotekah
  - programer sam poskrbi za sproscanje pomnilnika in nalaganje nove kode, ki prekrije staro
- **Vecprogramiranje**
  - vec procesov hkrati nalozenih v premajhnem pomnilniku → resitev je **odlagalni prostor**
- **Odlagalni prostor (swap space)** je del zunanjega pomnilnikga
  - **swap out** - shranjevanje strani iz pomnilnika na disk
  - **swap in** - nalaganje strani iz diska v pomnilnik  
    ![](img_predavanja/swap_space.png)  
  ![](img_predavanja/zunanji_pomnilnik.png)  
- **Postopek naslavljanja podatka**
  1. **zadetek v TLB:** ce **VPN** obstaja potem naslovi ustrezen del fizicnega pomnilnika
  2. **zgresitev v TBL, iskanje v tabeli strani:** ce **VPN** obstaja v preslikovalni tabeli strani in ce je veljaven in stran obstaja ga naslovi na ustrezen del fizicnega pomnilnika
  3. **zgresitev strani:** nalozi stran iz zunanjega pomnilnika, osvezi vnos v preslikovalni tabeli strani in ponovi strojni ukaz
- **Kaj ce je pomnilnik v celoti zaseden?**
  - pride do zamenjave strani (**swap in** in **swap out**)
  - **page replacement policy** minimizira stevilo zgresitev strani
  - **page (out) deamon**
- **Algoritmi izbire strani za izlocitev**
  - **FIF** - furthest in the future
    - optimalen algoritem
    - izloci stran, ki bo dostopana najdlje v prihodnosti
    - zgresitev strani prestavimo kar se da v prihodnost
    - moram poznati prihodnost
  - **FIFO** - first in, first out
    - izloci stran, ki je najdlje v pomnilniku
    - stare strani se lahko pogosto uporabljajo
  - **Nakljucna zamenjava**
  - **LFU** - least-fequently used
    - izloci najmanj uporabno stran
    - potrebno evidentirati frekvenco uporabe
  - **LRU** - least-recently used
    - izloci najdlje neuporabljeno stran
    - z **casovnim zaznamkom:** zaznamek se osvezi ob vsakem dostopu strani
    - z **vrsto strani:** ob vsakem dostopu do strani, stran pomaknemo na zacetek vrste
- **Strojna pomoc**
  - **dodatni bit v vnosu tabele strani**
  - **dirty bit:** ce je bila stran spremenjena od zadnega nalaganja
  - **fiksen bit:** preslikava je fiksna
  - **access/reference:** ali je bila stran dostopana

## Medprocesna komunikacija
- **Medprocesna komunikacija** je
  - komunikacija med procesi (naceloma socasni)
  - nadzorovan mehanizem OS, ki omogoca komunikacijo brez krsenja zascite procesov
- **namenjena je** izmenjavi podatkov, sinhronizaciji akcij, pohitritvi in modularnosti
- **Osnovna nacina**
  - **prenasanje sporocil** preko vticnice, cevi, ... (zgled `A → jedro → B`)
  - **deljen pomnilnik**
- **Ostali nacini**
  - **args**
  - **env**
  - izhodni status
  - stdin, stdout, stderr
  - datoteke
  - klic oddaljene procedure
  - sinhronizacija
- **Sporocilo** za OS nima pomena, za proces pa ima
- **Kanal** je medij za komunikacijo, ki ga ustvari in vzdrzuje OS (npr medpomnilnik) na katerega se preko **vrat** povezejo procesi

### Prenasanje sporocil
- **Prenos sporocila**
  - OS vzpostavi in sprosti kanal
  - OS opravlja kanal
  - OS poskrbi za uspesen prenos
  - kanal je v jedru
- **Osnovne operacije oz programski vmesniki**
  - **posiljanje** - `send` in `write`
  - **prejem** - `receive` in `read`
  - **odgovor** - `reply`
- **Sinhronost komunikacije**
  - **sinhrona operacija:** operacije blokirajo, **zmenek** kadar sta obe sinhroni
  - **asinhrona operacija:** operacije ne blokirajo, potrebujemo medpomnenje sporocil
- **Medpomnenje**
  - podatkovna struktuaa za hranjenje poslanih in se ne prejetih sporocil
  - **neomejena kapaciteta** → posiljatelj nikoli ne blokira
  - **omejena kapaciteta** → poiljatelj pri polni vrsti blokira
  - **nicelna kapaciteta** → posiljatelj blokira dokler prejemnik ne prejme
- **Naslavljanje procesov**
  - **neposredna komunikacija:** procesi se **eksplicitno poznajo**, naslavlja se preko **PID**  
    ```c
    send(pid, msg)
    receive(pid, msg)
    ```
  - **posredna komunikacija:** procesi komunicirajo preko **vmesnega objekta** → komunicira lahko vec procesov → v naprej vzpostavljen kanal  
    ```c
    send(addr, msg)
    receive(addr, msg)
    ```
- **Posredna komunikacija**
  - **nabiralnik** je vmesni objekt
  - nabiralnik v **naslovnem prostoru** zivi dokler zivi proces
  - nabiralnik v **sistemskem prostoru** prezivi proces, OS skrbi za ciscenje
  - **vec pisalcev** - vec procesov v isti nabiralnik
  - **vec bralcev** - vec procesov bere isti nabiralnik
- **Ucinkovitost**
  - zahteva sistemske klice
  - **request-reply** → 4x prehod med nacinom in 4x kopiranje podatkov
  - **Leno kopiranje**
    - kopiramo le naslov sporocila
    - kopiranje sporocila izvedemo kasneje
    - **request-reply** → 4x prehod in 2x kopiranje
- **Enostavnost uporabe**
  - OS skrbi za stvaritev in upravljanje kanala
  - OS skrbi za medpomnenje in sinh
- **Problem producer-consumer**
  - `>= 2` socasnih procesov
  - ni znano kdo ima procesor, kdaj se proizvede podatek in kdaj se lahko uporabi
- **Prakticne izvedbe prenasanja sporocil**
  - **signali**
  - **anonimne in imenovane cevi**
  - **sporocilne vrste**
  - **vticnice**

### Deljen pomnilnik
- je pomnilnik, ki je skupen dvema ali vec procesom
- je del fizicnega pomnilnika, preslikan v naslovni prostor procesov
- **Uporaba**
  - OS **vzpostavi**, doda v naslovni prostor in skonfigurira
  - **komunikacija** je neposredno branje in pisanje v deljen pomnilnik
  - po koncu uporabe deljen pomnilnik **sprostimo**
  - **hiter**
  - **podatki so takoj na voljo**
  - **potrebna eksplicitna sinhronizacija** - programer odgovoren
- Kako sinhronizirati dostop?
  - z mehanizmi iz knjiznice **pthreads**
  - z mehanizmi iz OS
  - sinhrono prenasanje sporocil
- **Ostrjevanje** → del navideznega prostora vec procesov je preslikan v iste okvirje strani
- **Nacini prenasanja podatkov**
  - **prenasanje sporocil**
    - **kopiranje** podatkov
    - hitra vzpostavite
    - pocasna komunikacija
  - **deljen pomnilnik**
    - **preslikava** vsebine pomnilnika med naslovnimi prostori
    - pocasna vzpostavitev
    - hitra komunikacija
    - enkratna vzpostavitev, veckratna uporaba

## Niti    
- glavni nalogi procesov sta **lastnistvo** in **izvajanje kode**
- **procesi** skrbijo za lastnistvo, **niti** pa skrbijo za izvajanje kode
- **Vrste**
  - en proces in ena nit na proces
  - vec procesov in ena nit na proces
  - en proces in vec niti na procesu
  - vec procesov in vec niti na procesih
- **Nit**
  - skrbi za izvajanje kode
  - ima svoj kontekst (staranje, registre in sklad)
  - pripada procesu
  - vse niti si delijo isti naslovni prostor

### Zakaj niti?
- **Prednosti vecnitnosti**
  - ustvarjanje in koncanje niti je hitro (ni potrebno init naslovnega prostora)
  - ucinkovit preklop niti, bolj ucinkovito kot med procesi, pni portrebno preklopiti naslovnega prostora in prazniti TLB
  - ucinkovita medprocesna komunikacija, saj si delijo pomnilnik
  - boljsi izkoristek procesorjev
  - bolj izkorisceni viri (manj prostora)
  - specializacija in modularnost (asinhrono)
- **Primeri uporabe:** brskalnik, text editor, streznik, vecnitnost v jedru OS

### Izvedba niti
- niti ki se izvedejo na **jedernem nivoju**
  - za njih skrbi OS
  - podpora preko syscall
  - tako kot procese **razvrscevalnik** razvrsca niti
  - OS poskrbi za synch
- niti ki se izvedejo na **uporabniskem nivoju**
  - upravljanje je izvedeno v uporabniskem programu (knjiznice)
  - OS se teh niti ne zaveda
  - **preslikava uporabniskih v jedrne:** *vec-v-eno*, *vec-v-vec*, *ena-v-eno* in *ena-v-vec*
- Zgled `[koda | kopica | prosto | sklad]` → `[koda | kopica | prosto | sklad 2 | prosto | sklad 1]`
- **Mehanizem za izvedbo niti**
  - **deskriptor niti (kontrolni blok niti)** - podatkovna struktura (v jedru), ki hrani podatke o niti (registri, stanje, sklad, PC)
  - **deljen pomnilnik** → navidezni pomnilnik: enaka preslikava iz navideznega prostora v fizicni pomnilnik
  - vzajemno izkljucevanje
  - cakanje druge niti
- **Preklop niti**
  - podobno kot preklop procesa
  - ni zamenjave naslovnega prostora
  - ni praznjenja preslikovalnega pomniklnika (**TLB**)

### Nitni izzivi
- `fork()` klonira vse niti procesa ali samo klicoce niti
- `exec()` nadomesti celoten proces → vse niti
- **Pokoncanje niti**
  - preden se zakljuci opravilo
  - **asinhrono** → se konca takoj (ex `Thread.stop()`)
  - **odlozeno koncanje** → se konca ko zakljuci trenutno opravilo, vsebuje preverjanje ali se mora koncati
  - sprostitev zasedenih virov
- signal **rokuje** nit, ki je vzrok za posiljanje signala
- **Stevilo niti in bazeni niti (thread pool)**
  - veliko zahtev → veliko niti
  - to preobremeni sistem
  - resitev je **bazen niti** (koncno stevilo, po koncanju se ponovno uporabi, vnaprej pripravljene, ni ustvarjanja in sproscanja)

## Socasnost
- **socasnost** je prekrivanje obstoja vec procesov (obcutek hkratnega izvajanja)
- **vzporednost** je dejansko hkratno izvajanje
- **porazdeljenost** je izvajanje vec procesov v vec vozliscih omrezja
- **Socasnost in vzporednost**
  - **socasnost brez vzporednosti** - vecopravilnost, izvajanje ukazov se prepleta
  - **socasnost z vzporednostjo** - vec procesorski sistem, ukazi se prekrivajo
  - **vzporednost brez socasnosti** - vzporednost na nivoju ukazov
  - **Enake tezave in resitve:** deljenje globalnih virov, deadlock, tezavno odkrivanje napak
- Pojavlja se pri **izvajanju vec razlicnih aplikacij** in **izvajanju ene aplikacije** (mnozica vzporednih procesov)
- Odnosi med procesi
  - **tekmujejo za vire** in se ne zavedajo drug drugega
  - z **medprocesno kounikacijo** se **neposredno** zavedajo drug drugega in **sodelujejo**
  - **posredno** zavedanje z **souporabo virov**

### Socasno izvajanje ukazov
- izvedba posameznih ukazov razlicnih procesov se **poljubno prepleta** (`vec procesov, en procesor`)
- izvedba posameznih ukazov razlicnih procesov se **poljubno prekriva** (`vec procesov, vec procesorjev`)  
  ![](img_predavanja/prepletanje_izvajanja.png)


### Souporaba vira
- **shared data** - vir, ki ga lahko uporabljata dva ali vec procesov
- **souporaba skupnega vira** - socasna uporaba vira s strani vec procesov
- **TEZAVA**  
  ![](img_predavanja/souporaba_vira.png)

### Tvegano stanja
- **tvegano stanje (race condition)** je rezultat souporabe skupnega vira, odvisen od prepletanja/prekrivanja ukazov
- tveganemu stanju se zelimo izogniti saj je nepravilno

### Kriticni odsek
- s **kriticnim odsekom (critical section)** scitimo socasno uporabo skupnega vira, ki vodi v tvegano stanje
- **ideja**
  - en proces naj bo socasno v KO, ostalim ne dovolimo vstopa, dokler prvi ne iztopi
  - princip **vzajemnega izkljucevanja**
- **Uporaba**
  - **vstop** v kriticni odsek je mozen le, ce noben drug proces ni v KO
  - po vstopu drugi procesi ne morejo v KO
  - **iztop** iz kriticnega odseka je vedno moze
  - po iztopu je KO prost
- **Vzajemno izkjucevanje** je mehanizem za preprecevanje tveganega stanja
  - zagotavlja, da se v KO nahaja le en proces
  - pojavita se novi tezavi: 
    - **stradanje** - proces, ki zeli vstopiti v KO in ne pride na vrsto
    - **smrtni objem** - dva ali vec procesov ne more nadaljevati, ker cakajo drgu drugega
- **izzivi**
  - enakopravnost
  - omejeno cakanje
  - ucinkovitost
  - poljubna hitrost izvajanja procesov
  - splosne resitve

## Vzajemno izkjucevanje
### Kjucavnica
- je osnovni mehanizem zagotavljanja **vzajemnega izkjucevanja**
- **vzajemno izkjucevanje** je da se v kriticnem odseku socasno nahaja le en proces
- **kljucavnica** sciti odsek  
  ```
  fun lock_init(lock) is
    lock = 0

  fun lock_enter(lock) is
    spin:
      if lock == 1 then goto spin 
      else lock = 1

  fun lock_exit(lock) is
    lock = 0
  ```
- **Tezave**
  - socasnost preverjanja stanja kljucavnice
  - locenost nastavljanja stana od preverjanja
    ```
    fun lock_enter(lock) is
      while lock == 1 do nothing
      lock = 1
    ```
  - **resitev** → atomarnost celotne operacije
- **Atomarna operacija**
  - zaporedje enega ali vec ukazov (se izvede kot celota)
  - izolacija od drugih socasnih procesov
  - vzajemno izkjucevanje
  - obvoz predpomnilnika (vec procesorjev)
    ```
    atomic fun lock_enter(lock) is
      while lock == 1 do nothing
      lock = 1
    ```
  - strojni ukazi navadno niso atomicni

### Strojna izvedba
- **Onemogocanje prekinitev**
  - **vstop v KO** → onemogocimo prekinitve
  - **iztop iz KO** → omogocimo prekinitve
  - **slabosti:** uporaba privilegiranih ukazov, onemogoci vecopravilnost in ne deluje na vecprocesorski arhitekturi
- **Namenski strojni ukazi**
  - atomicni
  - nacelo kjucavnice
  - **vstop** → cakaj dokler je zaklenjeno `enter()`
  - **iztop** → enostavno prirejanje `leave()`
- **Ukaz** `TEST & SET`
  - ce je zaklenjeno vrni `true`
  - sicer zakleni in vrni `false`   
    ```
    atomic instruction test_and_set(ref val) is
      if val then return true
      val = true
      return false

    fun enter() is
      while test_and_set(&flag) do nothing
    ```
- **Ukaz** `COMPARE & SWAP`
  - posplositev `TEST & SET`
  - ce je trenutna vrednost enaka testni vrednosti → zamenjaj z novo vrednostjo
  - vedno vrne staro vrednost  
    ```
    atomic instruction compare_and_swap(ref val, testval, newval) is
      oldval = val
      if val == testval then val = newval
      return oldval

    fun enter() is
      while compare_and_swap(&flag, false, true) do nothing
    ```
- **Ukaz** `EXCHANGE`
  - zamenjava dveh vrednosti  
    ```
    atomic instruction exchange(ref a, ref b) is
      t = a
      a = b
      b = a
      
    fun enter() is
      key = true
      do exchange(&flag, key) while key
    ```
- **Ukaz** `FETCH & ADD`
  - poveca vrednost in vrne staro vrednost  
    ```
    atomic instruction fetch_and_add(ref val) is
      oldval = val
      val += 1
      return oldval

    fun init() is
      ticket = turn = 0

    fun enter() is
      myturn = fetch_and_add(&lock.ticket)
      while lock.turn != myturn do nothing

    fun exit() is
      fetch_and_add(lock.turn)
    ```
- **Prednosti namenskih strojnih ukazov**
  - deluje na vecprocesorskih sistemih
  - enostavna izvedba
  - podpora vec kriticnim odsekom
- **Slabosti namenskih strojnih ukazov**
  - vrtece cakanje zapravlja procesorski cas
  - mozno stradanje
  - mozen smrtni objem

### Programska izvedba
- **Dekkerjev algoritem**
  - prvi alg za resevanje KO
  - dva procesa si predajata prednost
  - vrtece cakanje  
    ```
    me = 0
    you = 1 – me
    shared entering = [false, false]
    shared turn = you

    fun enter() is
      entering[me] = true
      while entering[you] do
        if turn == you then
          entering[me] = false
          while turn == you do nothing
          entering[me] = true
        endif
      endwhile

    fun leave() is
      turn = you
      entering[me] = false
    ```
- **Petersonov algoritem**  
  ```
  me = 0 oz. 1                        ... P0: me = 0, P1: me = 1
  you = 1 – me                        ... P0: you = 1, P1: you = 0
  shared entering = [false, false]    ... deljena spr., začetek: nobeden ne želi vstopiti
  shared turn = you                   ... deljena spr., na potezi je drugi proces

  fun enter() is
    entering[me] = true               ... želim vstopiti
    turn = you                        ... dam ti prednost
    while entering[you] and           ... dokler želiš ti vstopti in
      turn == you do nothing          ... je tvoja poteza, jaz čakam

  fun leave() is
    entering[me] = false              ... ne želim več vstopiti
  ```
  - vzajemno izkjucevanje z vidika procesa `P-me`
    - ce je `P-me` v KO, potem je `entering[me] = true`
    - za `P-you` velja ena od moznosti:
      - ne zeli vstopiti
      - zeli vstopiti in je predal prednost zato caka
      - zeli vstopiti in se ni predal prednosti zato je prisel do while zanke
- **Lamportov pekarski algoritem**
  - za **N** procesov, princip ostevilcenih listkov
  
### Ucinkovitost kljucavnic
- **Mere zmogljivosti**
  - **zakasnitveni cas (latency)** je cas za pridobitev proste kljucavnice (optimalno takoj izvedemo atomicno operacijo)
  - **cakalni cas (delay)** je cas za pridobitev ravnokar sporoscene kljucavnice (optimalno takoj)
  - **tekmovanje (contention)** je promet na vodilu zaradi atomicne operacije in zagotavljanja koherentnosti predpomnilnika
- **Izvedbe**  
  ```
  flag          ... testiranje v predpomnilniku, vrtenje
  test_and_set  ... atomicna operacija, dostop do GP
  ```
  - **osnovna**  
    ```
    fun lock_enter(lock) is
      while test_and_set(&flag) do nothing
    ```
  - **test + test and set**  
    ```
    fun enter() is
      while flag or test_and_set(&flag) do nothing
    ```
  - **+ zakasnitev**  
    ```
    fun enter() is
      while flag or test_and_set(&flag) do
        while flag do nothing
        delay()
      end
    ```
- **vrteca kljucavnica (spinlock)** je porabljeni procesorski cas za cakanje  
  ```
  fun enter() is
    while test_and_set(&flag) do nothing
  ```
- uporabimo `yield()`  
  ```
  fun enter() is
    while test_and_set(&flag) do yield()
  ```
- **Namesto vrtecega cakanja naj nit raje blokira**  
  ```
  fun enter() is
    while test_and_set(&flag) do
      wait_for_flag_to_be_changed()

  fun exit(ref lock) is
    lock = 0
    wake_up_some_waiting_thread()
  ```

## Sinhronizacija procesov
### Kljucavnica
- **Kljucavnica (lock, mutex)** je mehanizem zaklepanja
  - **odklenjeno** ali **zaklenjeno**
  - nit, ki zaklene kljucavnico, si jo **lasti** (le ena)
  - nit, ki jo zaklene jo tudi odklene
  - **uporaba** pri **vzajemnem izkljucevanju** na **kriticnih odsekih**
- **Uporaba**
  - **zakleni (lock, acquire):** ce je odklenjena jo zaklene, sicer caka da je odklenjena
  - **odkleni (unlock, release):** odklene sakljenjeno kljucavnico   
  ```c
  pthread_mutex_t m = PTHREAD_MUTEX_INITIALIZER;
  pthread_mutex_lock(&m);
  // kritični odsek
  pthread_mutex_unlock(&m);
  ```

### Problem proizvajalci-uporabniki
- dva ali vec socasnih procesov
- dve vrsti procesov: **proizvajalec** `P` in **porabnik** `Q`
- komunikacija poteka preko souporabe vrste
  - pojav **ttveganega stanja** pri socasnem dostopu do vrste
  - omejena ali neomejena kapaciteta vrste
- **Resitev z zaklepanjem**   
  ```c
  pthread_mutex_t m = PTHREAD_MUTEX_INITIALIZER;
  queue_t q = ...;
  ```
  - proizvajalec  
  ```c
  data = produce_data()
  pthread_mutex_lock(&m)
  q.enqueue(data)
  pthread_mutex_unlock(&m)
  ```
  - porabnik  
  ```c
  while true do
    if not queue.empty then
      pthread_mutex_lock(&m)
      q.dequeue(data)
      pthread_mutex_unlock(&m)
      consume_data(data)
    else nothing
  done
  ```
  - moti nas neprestano preverjanje ce je vrsta neprazna

### Pogojna spremenljivka
- **conditional variable** je mehanizem **obvescanja**
  - opazovalni pogoj → eksplicitno preverjamo
  - mnozica cakajocih niti
  - nit, ki obvesti cakajoce niti o izpolnjenosti pogoja
  - se uporablja skupaj s kljucavnico
  - **uporaba:** optimizacija uporabe procesorja
- **Uporaba**
  - **cakaj (wait)**
    - sprosti pripadajoco kjucavnico
    - nit se postavi v cakalno mnozico
    - blokira trenutno nit
    - ko se nit zbudi ponovno dobi kljucavnico
  - **obvesti (signal, notify)**
    - zbudi eno od niti iz cakalne mnozice
    - namen je obvestilo o izpolnjenem pogoju
  - **obvestiVse (broadcast, notifyAll)**
    - zbudi vse niti iz cakalne mnozice
    - kadar je izpolnjenih vec pogojev  
  ```c
  pthread_mutex_t m = PTHREAD_MUTEX_INITIALIZER;
  pthread_cond_t c = PTHREAD_COND_INITIALIZER;
  // ...
  // POGOJ ... globalna spremenljivka za opis pogoja
  ```  
  ```c
  void* make(void *arg) {
    // izpolni pogoj
    // ...
    pthread_mutex_lock(&m);
    // set POGOJ to true
    if (POGOJ) pthread_cond_signal(&c);
    pthread_mutex_unlock(&m);
  }
  ```   
  ```c
  void* watch(void *arg) {
    pthread_mutex_lock(&m);
    while (not POGOJ) pthread_cond_wait(&c, &m)
    pthread_mutex_unlock(&m);
    // obdelava po izpolnitvi pogoja
    // ...
  }
  ```

### Problem proizvajalci-porabniki
- **Resitev** z **zaklepanjem in pogojno spremenljivko**  
  ```c
  pthread_mutex_t m = PTHREAD_MUTEX_INITIALIZER;
  pthread_cond_t c = PTHREAD_COND_INITIALIZER;
  queue_t q = ...;
  ```
  ```c
  data = produce_data()
  pthread_mutex_lock(&m)
  q.enqueue(data)
  signal(c)
  pthread_mutex_unlock(&m)
  ```
  ```c
  while true do
    pthread_mutex_lock(&m)
    while q.empty() do
      wait(m, c);
    q.dequeue(data)
    pthread_mutex_unlock(&m)
    consume_data(data)
  done
  ```
- omejena kapaciteta vrste

### Problem bralci-pisalci
- **Bralci-pisalci**
  - vec procesov socasno dostopa do podatkov
  - bralci le berejo, pisalci berejo in spreminjajo
- **resitev** z osnovnim zaklepanjem
  - branje in pisanje obdamo s kljucavnico
- **slabost** onemogocimo socasno branje vec bralcev
- // koda

### Bralno-pisalna kljucavnica
- **izkljucujoce zaklepanje** (exclusive, write lock)
  - le ena nit lahko socasno zaklene
  - onemogoci souporabo vira drugim nitim
  - **pisanje, ne da bi komu pokvarili branje**
- **deljeno zklepanje** (shared, read lock)
  -  vec niti lahko socasno "deljeno" zaklene
  -  onemogoca souporabo izkljucujoce kljucavnice
  -  **enovito/celovito branje**
- **vrste zaklepanja**
  - **svetovalna kljucavnica** → neodvisnost operacije od kljucavnice
  - **obvezna kljucavnica** → odvisnost operacije od kljucavnice

### Semafor
- zdruzuje **stevec**, **kljucavnico** in **pogojno spremenljivko**
- **pozitiven stevec (vkljucno z 0)** → odprt semafor, prost prehod procesa v KO
- **negativen stevec** → zaprt semafor, prehod v KO ni mozen, proces caka na odprtje semaforja
- **Uporaba**
  - **wait (tudi test, down, proberen, P)** → dekrementira stevec, ce je semafor zaprt, potem gre proces v cakalno vrsto semaforja
  - **signal (tudi increment, up, verhogen, V)** → inkrementira stevec, ce je semafor odprt, potem zbudi morebitni cakajoci proces iz semaforjeve vrste
  - **atonomicnost operacij** zagotovimo s kratkim vrtecim cakanjem in onemogocanjem prekinitev
- **Izvedba**    
  ```
  // priprava
  sem: Semaphore
  init(sem, 1)
  …
  // zaklepanje
  wait(sem)
  // kritični odsek
  signal(sem)
  …
  ```   
  ```
  struct Semaphore is
    count: Int
    queue: Queue

  fun init(sem, value) is
    sem.value = value
    sem.queue = []

  atomic fun wait(sem) is
    sem.count -= 1
    if sem.count < 0 then
      queue.enqueue(this process)
      make_waiting(this process)

  atomic fun signal(sem) is
    sem.count += 1
    if sem.count <= 0 then
      process = queue.dequeue()
      make_ready(this process)
  ```
- **POSIX API**   
  ```c
  // tip semafor
  sem_t sem;
  // inicializacija semaforja
  sem_init(sem_t *sem, int pshared, int count)
  // operacija wait
  sem_wait(sem_t *sem);
  // opearcija signal
  sem_post(sem_t *sem);
  ```

### Monitor
- visjenivojski konstrukt
- vstop in iztop v kriticni odsek generira prevajalnik
- **vsebnik**
  - eksplicitno specificira souporabljen vir
  - vsebuje lokalne spr in fun
  - naenkart se lahko izvaja le ena funkcija
  - medsebojno izkljucevanje izvajanja funkcij  
- **primer**
  ```
  monitor BancniRacun is
    stanje: Int

  sync fun poloziDenar(polog) is
    stanje += polog

  sync fun dvigniDenar(dvig) is 
    stanje -= dvig

  sync fun obresti(p) is
    stanje *= (1 + p / 100)
  ```

### Ostali mehanizmi
- **pregrada** → obratno od semaforjev (za vstop zahteva N procesov)
- **serializers** → definicija prioritet
- **path expressions** → regularni izrazi za definicijo usklajenega obnasanja
- **wait-free sync** → read-copy-update kljucavnica

## Navidezni datotecni sistemi
### Datotecni sistem
- **Fizicna organizacija**
  - nizko nivojski pogled → za uporabnika skrit
  - nacin in oblika zapisa podatkov in metapodatkov → dejanski fizicen zapis
  - razlicni nacini fizicne organizacije → prilagoditev mediju
  - gonilniki datotecnega sistema
- **Gonilniki**
  - gonilniki za pomnlino napravo → naprava kot zaporedje blokov
  - gonilniki za datotecni sistem → organizira bloke med seboj
- **Vrste**
  - diskovni → ext4, ntfs, ...
  - mrezni → nfs, Coda, ...
  - posebni → `/proc/`, `/dev/`, ...

### Navidezni datotecni sistem
- **VFS**
  - razlicni datotecni sistemi → podobni koncepti
  - enostaven vmesnik za uporabnika
  - abstrakcija datotek
  - standardna hierarhija imenikov
- **Struktura VFS**   
  ![](img_predavanja/struktura_vfs.png)
- **Objektna orientiranost** → npr `struct` v C
- **VFS objekti** →  organizacija datotek v superblock, inode, dentry →  datotecni deskriptor je file
- **Supeblock** je predstavitev prikljupljenega datotecnega sistema
  - lastnosti so naprava, tip, velikost bloka, zastavice, ...
- **inode (index node)** je datoteka poljubnega tipa in predstavlja vse razen imena datoteke
  - lastnosti so st inode, st trdih povezav, velikost datoteke, lastnik, datum/cas dostopa, kazalci na bloke
  - operacije `create(), link(), ..., mkdir(), ... read(), write(), ...`
- **dentry (directory entry)** je imeniski vnos v imeniku
  - preslikava med imeni in inodei
  - lastnosti so ime datoteke, kazalci inode, kazalec na starsevski imenik in stevci uporabe

### Datotecni deskriptorji
- **Dupliciranje deskriptorja**
  - `dup(fd)`
    - **uporaba** → `new = dup(orig)`
    - ustvari nov deskriptor, ki predstavlja isto odprto datoteko kot original
    - uporabi se prva prosta stevilka deskriptorja
    - stevilka desriptorja == stevilka file
    - duplikati si delijo pozicijo v datoteki   
    ```c
    int fd = open(...);
    close(0);
    dup(fd);
    ```
  - `dup2(orig, new)`
    - preusmeritev orig v new
    - ce je new ze v uporabi se prej zapre   
    
    ```c
    // odpremo datoteko
    fd = open("vhod.txt", O_RDONLY);

    // izvedemo preusmeritev
    dup2(fd, 0);

    // zazenemo program
    execv("/bin/cat", NULL);
    ```

## Virtualizacija
- mehanizem, ki nekaj ustvari navidezno → **navidezna naprava** (procesor ali pomnilnik) ali **navidezni stroj** (celoten sistem, strojna oprema)
- **preslikava navideznega v realni sistem** → vmesnik in viri navidezne naprave se preslikajo na vmesnik in vire realne naprave, ki implementira navidezno
- **Primer** *navidezni disk* → uporabniku enako dostopen, v ozadju se prelika na dejanski sistem
- **Abstrakcija in virtualizacija**
  - podobna koncepta → oba nek vmesnik navideznega
  - abstrakcija skrije podrobnosti
  - virtualizacija podrobnosti pusti odprte
- **Virtualizacijska programska oprema** → Virtual machine
- **Vrste**
  - procesni navidezni stroj
  - sistemski navidezni stroj
  - vsebniki

### Lastnosti virtualizacije
- **replikacija virov** → videz da je vec virov, kot jih je
- **varnost in neodvisnost** → stroji med seboj neodvisni in izolirani, dva nivoja zascite in zascita nadzornika pred gostitelji
- **prilagodljivost in enostavno upravljanje** → vecja razpolozljivost in zanesljivost, zmanjsanje stroskov, lazje upravljanje navideznih strojev
- **Slabosti**
  - manjsa ucinkovitost
  - upravljanje dejanskega stroja je bolj zahtevno
  - ni popolna
  
### Sistemska virtualizacija
- virtualizira cel sistem
- stara ideja → preslabi racunalniki in dragi
- **Virtualizacija tipa 1**
  - nadzornik navideznih naprav (**VM monitor**) → **hipervizor** → tece neposredno na strojni opremi
  - servisni navidezni stroj → omogoca config in upravljanje sistema → priviligirane operacije → poganja gonilnike  
  ![](img_predavanja/virtualizacija_tipa_1.png)
- **Virtualizacija tipa 2**
  - temelji na gostiteljskem OS   
  ![](img_predavanja/virtualizacija_tipa_2.png)
- **Polna virtualizacija**
  - preslikava vseh pomembnih funkcij dejanskega stroja v funkcije navideznih strojev
  - OS se ne zaveda virtualizacije
- **Paravirtualizacija**
  - ucinkovitost za ceno spremembe gostujocega OS
  - gostujoc OS ve da je virtualen
  - OS ne izjava privilegiranih ukazov → eksplicitno klice nadzornika

### Izvedba virtualizacije
- **osnovna pristopa** sta **souporaba/deljenje casa** in **souporaba/deljenje prostora**

### Izvedba: virtualizacija procesorja
- strojni ukazi se izvedejo neposredno na procesorju
- priviligirane ukaze emulira nadzornik
- **Prevajanje**
  - v kodi nadomesti problematicne ukaze
- **Polna virtualizacija**
  - `navidezni naslov → navidezni fizicni naslov → dejanski fizicni naslov`
  - **1. moznost** → dvojno preslikovanje
  - **2. moznost** → sencna preslikovalna tabela
- **Paravirtualizacija**
  - s preslikovalnimi tabelami upravlja nadzornik
  - gostujoc OS se zaveda virtualizacije

### Izvedba: virtualizacija naprav
- **Izzivi**
  - veliko razlicnih naprav
  - manj standarizacije obnasanja naprav
- **Pristopi**
  - **passthrough model** → ekskluzivni in neposredni dostop do naprave
  - **Hypervisor-direct model** → nadzornik prestreze vse dostope in emulira odziv naprave
  - **Split-device driver model** → dostop do naprave je razdeljen med front-end in back-end gonilniki



## Procesi - API
### Windows
- `CreateProcess()`
- `ExitProcess()`
- `TerminateProcess(proces, status)`
- `GetExitCodeProcess(proces, status)`
- `WaitForSingleObject()`

### Unix - podobni sistemi
- **info o procesu**
  - **PID** - `int getpid()`
  - **PPID** - `int getppid()`
  - **UID** - `int getuid()`
  - **GID** - `int getgid()`
- **ostalo**
  - `int sleep(uint seconds)` - spanje procesa
  - **casi procesa** - `clock_t times(struct tms * buf)`  
    ```c
    struct tms {
      clock_t tms_utime; /* user time */
      clock_t tms_stime; /* system time */
      clock_t tms_cutime; /* user time of children */ 
      clock_t tms_cstime; /* system time of children */
    };
    ```
- **Stvaritev procesa - fork**
  - kopira trenutni proces
  - **otrok je kopija starsa**
    - ima nov deskriptor
    - vecina podatkov je istih
    - razlicne kljucavnice
    - enak naslovni prostor
  - `int fork()` - sistemski klic
    - `-1` ob neuspehu
    - sicer pa se vrneta dva procesa  
    ```c
    int pid = fork();
    if (pid > 0) {
      // STARŠ
    } else if (pid == 0) {
      // OTROK
    } else { // pid < 0
      // NEUSPEH
    }
    ```
- **Koncanje procesa - exit**
  - `exit(int status)` - sistemski klic
    - proces se zakljuci s podanim izhodnim statusom
    - jedro sprosti vire procesa
    - otroke posvoji proces **init** → **sirote**
    - iz te funkcije se nikoli ne vrnemo
  - **izhodni status**
    - 8b vrednost
    - `0` - uspesen zakljucek
    - `1..127` koda napake za neuspesen zakljucek
    - `128..255` zakljucek zaradi signala
    - status se shrani v deskriptorju procesa dokler ga ne prevzame **otrokov stars**
    - otrok je **zombi** dokler status ni prevzet
    - prevzem koncnega statusa otroka se rocno sprogramira
    - `SIGCHLD` → signal, ki pove starsu, da se je otrok koncal
- **Prevzem izhodnega statusa otroka - wait**
  - `int waitpid(pid, &status, opcije)` → cakanje dolocenega otroka
  - `int wait(&status)` → cakanje poljubnega otroka → enako kot `int waitpid(-1, &status, 0)`
  - izhodni status je skrit v spremenljivki status
- **Casovni diagram procesov**  
  ![](img_predavanja/casovni_diagram_procesov.png)  
  - **fork** → ustvari otroka → otrok dobi vse podatke od starsa
  - **exit** → oddaja statusa starsu
  - **wait** → prejem statusa
- **Zagon programa - exec**
  - program v izvrsljivi datoteki
  - nadomestitev trenutnega procesa
    - nov naslovni prostor
    - poenostavi se trenutni deskriptor procesa
  - lahko podamo tudi **argumente** in **okoljske spremenljivke**
  - **argumenti programa** → seznam nizov, vkljucno z imenom programa `int main(int argc, char** argv)`
  - **okoljske spremenljivke** → seznam imen spremenljivk in njihovih vrednosti `int main(int argc, char** argv, char** envp)`
  - prenos informacij je enosmeren
  - druzina funkcij: `exec[lv][pPe]?(...)`
    - **l** - argumenti so podani, kot argumenti funkcije
    - **v** - argumenti so podani posebej v tabeli
    - **p** - uporaba `$PATH` pri iskanju izvrsljive datoteke
    - **P** - podamno iskalno pot
    - **e** - okoljske spremenljivke so podane v tabeli  
    ```c
    execl(exe, arg0, …)
    execlp(exe, arg0, …)
    execle(exe, arg0, …, 0, envp)
    execv(exe, args)
    execvp(exe, args)
    execvP(exe, path, args) 
    execve(exe, args, envp)
    ```
  - **primeri**  
  ```c
  execl("/bin/ls", "ls", "-alp", "/home/jure", NULL);

  char* args[] = { "ls", "-alp", "/home/jure", NULL };
  execvp("ls", args);

  char* envp[] = { "FRI=cool","OS=even cooler", NULL}
  execve("ls", args, envp)

  execvp(argv[1], &argv[1]);

  execlp("ls", "proggy");
  ```
- **Prednosti** Unix pristopa - **fork & exec**
  - preprosto ustvarjanje procesa
  - locitev ustvarjanja in nalaganja procesa
  - moznost izvajanje kode po `fork()` in pred `exec()`
- **Slabosti** Unix pristopa - **fork & exec**
  - kopiranje procesov je neucinkovito
  - `vfork()` - optimizacija
    - razlicica `fork()`, kjer se pricakuje, da se bo takoj zatem izvedel se `exec()`
  - `COW (copy-on-write)` - optimizacija 
    - leno kopiranje
    - pomnilniski prostor kopiramo sele ko pride do prvega pisanja

## Medprocesna komunikacija API
### Aninimne cevi
- **cev (pipe)** omogoca enosmerno komunikacijo po principu **FIFO**
  - posredni sinhron nacin
  - podatki se medpomnijo (poskrbi OS)
- **Ustvarjanje cevi** → `int pipe(int fd[2])`
  - ustvari in odpre cev
  - `fd[0]` → datoteka, ki bere
  - `fd[1]` → datoteka, ki pise
  - `fd[1] → cev → fd[0]`
- **Uporaba cevi**
  - **branje** → `read(fd[0], ...)`
  - **pisanje** → `write(fd[1], ...)`
  - oba klica lahko blokirata
- **Dedovanje cevi**
  - otroci dedujejo odprte datoteke → tudi cevi
  - kombinacija klicov `pipe() & fork()`  
    ![](img_predavanja/dedovanje_cevi.png)
  - komunikacija je omejena samo na procese s **skupnim prednikom**
  - **starsi in potomci**
  - tipicno **starsi in otroci** in **otroci med seboj**
  - **Primer (stars pise, otrok bere)**  
    ```c
    // ustvarjanje cevi
    int fd[2];
    pipe(fd);

    // razvejevitev starsa
    fork();

    // priprava
    close(fd[0]); // stars
    close(fd[1]); // otrok

    // branje in pisanje
    write(fd[1]); // stars
    write(fd[0]); // otrok

    // sprostitev cevi
    close(fd[1]); // stars
    close(fd[0]); // otrok
    ```
- **Cevovod (pipeline)** je zaporedje otrok istega starsa
  - vhode in izhode otrok povezemo s cevmi
  - `P0 → cev 0 → P1 → cev 1 → P2`
- **Cevovod v lupini** je zaporedje ukazov loceni z `|`
  - lupina cevovode pripravi sama
    - `pipe()` - ustvari cevi
    - `fork()` - ustvari otroke
    - `dup2()` - naredi preusmeritve
    - `exec()` - zazene ukaze
    - `waitpid()` - pocaka da se vsi otroci koncajo
    - **Primer:** `cat /etc/passwd | cut –d: -f7 | sort -u`  
      ![](img_predavanja/primer_cevovoda.png)

### Imenovane cevi
- **imenovane cevi (named pipe, fifo)** so podobne anonimnim cevem
  - poseben tip datoteke (pipe)
  - neomejena komunikacija (vsak proces jo lahko uporabi)
- **Ustvarjanje** → `mkfifo()` in `mknod()` in ukaza `mkfifo cev` in `mknod cev p`
- **Uporaba** → `open()`, `close()`, `read()` in `write()`

### POSIX in System V
- **POSIX** medprocesna komunikacija uporablja datoteke za identifikacijo kanala
- **System V** medprocesna komunikacija uporablja kljuce za identifikacijo kanala
  - `ftok(pathname, ...)` ustvari kljuc
  - preko kljuca ustvarimo kanal

### Sporocilne vrste
- **Sporocilna vrsta (message queue)** je hramba sporocil v vrsti
  - posredna in asinhrona   
  ![](img_predavanja/sporocilna_vrsta.png)

### Sporocilne vrste - System V
- `int msgget(key, ...)` odpre/ustvari sporocilno vrsto z oznako **key** in vrne deskriptor vrste **qid**
- `int msgctl(qid, IPC_RMID, ...)` zapre vrsto
- `int msgsnd(qid, msg, size, ...)` poslje sporocila v vrsto
- `int msgrcv(qid, msg, size, ...)` prejme sporocilo

### Deljen pomnilnik
- **segmenti** → deljeni kosi pomnilnika
- je sistemsko pogojen → OS omejuje stevilo in velikost
- potek komunikacije: ustvarjanje in sprostitev segmenta → priklop in odklop segmenta

### Deljen pomnilnik - System V
- `int shmget(key, ...)` - odpre/ustvari deljen pomnilnik
- `int shmctl(shmid, IPC_RMID, ...)` - sprosti deljen pomnilnik
- `int shmat(shmid, ...)` - priklop segmenta z deskriptorjem `shmid`
- `int shmdt(addr, ...)` - odklop segmenta

### Deljen pomnilnik - POSIX
- `int shm_open(fname, ...)` - povezava do segmenta, vrne datotecni deskriptor
- `close() ali shm_close()` - sprosti povezave do segmenta
- `int shm_unlink(fname)` - sprostitev deljenega pomnilnika
- `void* mmap(...)` - priklop segmenta
- `int munmap(addr, ...)` - odklop segmenta

### Sporocila - QNX
- neposredna sinhrona oblika komunikacije
  - **neposredna** → naslavljanje preko **PID**
  - **sinhrona** → operacije blokirajo
- vsako sporocilo zahteva odgovor (`poslji-prejmi-odgovori`)
- sporocila se hranijo v procesovem pomnilniskem prostoru
- **Ukazi**
  - `Send(pid, msg, reply, ...)` - poslje sporocilo procesu **pid** in blokira dokler ne dobi **reply**
  - `Receive(0, msg, ...)` - prejme sporocilo **msg**, caka ce sporocilo ni na voljo in vrne **pid**
  - `Reply(pid, reply, ...)` - odgovori procesu **pid** z odgovorom **reply**
  
### Vticnice
- omogocajo **medprocesno** in **mrezno** komunikacijo
- dvosmerna komunikacija
- **odjemalec / streznik**
- **Potek**  
  ![](img_predavanja/vticnice.png)
- **Vrste**
  - **AF_LOCAL** - lokalna vticnica (preko datotek)
  - **AF_INET** - IPV4
  - **AF_INET6** - IPV6
  - ...

## Niti - API
### Java
- **Izvedba**
  - vmesnik `Runnable`
  - metoda `run()`
- **Ustvarjanje**
  - razred `Thread`
  - `getName() / setName()` - za ime niti
  - `getPriority() / setPriority()` - za prioriteto niti
- itd. read java docs

### Pthreads
- knjiznica `pthread.h`
- `pthread_exit()` - konca nit
- `pthread_t pthread_self()` - identiteta niti
- implementiramo z `void* nit(void* arg)`

### Windows
- knjiznica `windows.h`
- `pthread_exit()` - konca nit
- `pthread_t pthread_self()` - identiteta niti