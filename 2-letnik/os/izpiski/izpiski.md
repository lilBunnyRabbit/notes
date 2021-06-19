# OS Zapiski
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
  - i-ti