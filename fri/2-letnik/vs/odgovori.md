---
layout: note
title: Odgovori
toc: true
quotes: true
---

## Misc

| Porazdelitev      | $E(X)$                           | $D(X)$                                             |
| :---------------- | :------------------------------- | :------------------------------------------------- |
| Binomska          | $np$                             | $npq$                                              |
| Geometrijska      | $\frac{1}{p}$                    | $\frac{q}{p^2}$                                    |
| Pascalova         | $\frac{n}{p}$                    | $m\frac{q}{p^2}$                                   |
| Poissonova        | $\lambda$                        | $\lambda$                                          |
| Hipergeometrijska | $n\frac{M}{N}$                   | $\frac{nM(N-n)(N-M)}{N^2(N-1)}$                    |
| Enakomerna        | $\sum_{i = 1}^{n}x_i\frac{k}{n}$ | $\frac{1}{n}\sum_{k = 1}^n (x_k - \overline{x})^2$ |
| Normalna          | $u$                              | $o^2$                                              |
| Exponentna        | $\frac{1}{\lambda}$              | $\frac{1}{\lambda^2}$                              |
| Gama              | $\frac{k}{\lambda}$              | $\frac{k}{\lambda^2}$                              |
| Hi-kvadrat        | $n$                              | $2n$                                               |

## Slucajne spremenljivke
- **Primeri:** diskretna in zvezna
- **Slucajna spremenljivka** je spremenljivka, ki zavzame neko doloceno vrednost odvisno od slucaja pri vsaki ponovitvi poskusa
- **Zaloga vrednosti** slucajne spremenljivke je mnozica vrednosti, ki jih lahko prevzame ob neki ponovitvi poskusa
- **Porazdelitveni zakon** nam pove verjetnost, da s.s. prevzame neko vrednost v ponovitvi poskusa
- Pravimo, da je porazdelitveni zakon poznan, ce lahko za vsak realen $x$ zracunamo njegovo verjetnost:
  - $F(x) = P(X \leq x)$
  - $F(x)$ tudi pravimo **porazdelitvena funkcija**
- **Diskretna** s.s. ima **zalogo vrednosti** neko stevno mnozico (npr. met kocke), **Zvezna** pa nek interval (npr. visina studenta)
- Poznamo pa se **Mesane** s.s., ki pa imajo nekaj lastnosti diskretnih in nekaj lastnosti zveznih
- **Lastnosti porazdelitvene funkcije:**
  - Zvezna iz desne
  - Zavzame neko realno stevilo na intervalu $[0,\ 1]$
  - $F(\infty) = 1$
  - $F(-\infty) = 0$
  - $P(x_1 < X \leq x_2) = F(x_2) - F(x_1)$
  - Je nepadajoca
  - $P(X > x) = 1 - F(x)$
  - $P(X == x) = F(x) - F(-x)$

## Diskretne slucajne spremenljivke
- *Primer: Met kocke, ki ima porazdelitveno tabelo $(1,2,3,4,5,6)$ zgoraj in $(\frac{1}{6},\frac{1}{6},\frac{1}{6},\frac{1}{6},\frac{1}{6},\frac{1}{6})$ spodaj*
- **Porazdelitvena tabela** je prikaz vrednosti, ki jih s.s. lahko zavzame in njihove verjetnosti
- Za **diskretne** s.s. je **porazdelitvena funkcija** definirana kot: $F(xk) = \sum_{i = 0}^{k} p_i$, **zaloga vrednosti** je pa neka stevna mnozica
- **Vrste porazdelitev:**
  - **Enakomerna** - vse vrednosti so enako verjetne (npr. met kocke)
  - **Binomska** - zanima nas verjetnost, da se v $n$ poskusih dogodek zgodi $k$-krat (npr. koliksna je verjentnost, da v 4 metih kocke vrzemo sestico natanko dvakrat)
  - **Poissonova** - zanima nas verjetnost, kjer je $X$ stevilo ponovitev dogodka na danem intervalu. V nekem intervalu se dogodek ponavadi zgodi $\lambda$-krat (npr. stetje prometa)
  - **Pascalova** - zanima nas verjetnost, da bomo potrebovali $k$ ponovitev poskusa, da pridemo do $n$-te pojavitve (npr. verjetnost, da vrzemo sestico 10x, ce ce dogodek ponovimo 12x, ali koliko metov bo potrebnih, da z 90% verjetnostjo vrzemo sestico 10x, ce recemo, da je n = 1, torej opazujemo, do prve ponovitve dogodka $\rightarrow$ dobimo geometrijsko porazdelitev)
  - **Hipergeometrijska** - npr. imamo $R$ rdecih in $B$ belih kroglic, izvlecemo jih $n$. $X$ oz $k$ je stevilo izvlecenih kroglic. Zanima nas verjetnost, da izvlecemo $k$ rdecih kroglic, ce izvlecemo $n$ kroglic.
- Pri **diskretnih** s.s. lahko izpeljemo formula za **pricakovano vrednost** $E(x)$ (t.j. vrednost, za katero pricakojemo, da se bo najveckrat pojavila). To je posplositev povprecne vrednosti.
  - **Utezeno povprecje** je $\frac{\sum_{i = 1}^{m}x_ik_i}{N}$
  - Ker se $\sum_{i = 1}^{m}k_i$ sestejejo v $N$ upostevamo, da je $\frac{k_i}{N} = f_i$ in dobimo
  - $E(X) = \sum_{i = 1}^{m} = x_ip_i$

## Poissonova porazdelitev
- *Primer: Stetje prometa, kjer nas zanima verjetnost, da v nekem casovnem intervalu pride mimo $k$ avtomobilov*
- **Zaloga vrednosti** so vsa naravna stevila vkljucno z 0
- $\lambda$ nam prikazuje pricakovano stevilo ponovitev dogodka $A$ v danem casovnem intervalu (ce spreminjamo interval se spreminja tudi $\lambda$). Iz tega je reazvidno, da bo **pricakovana vrednost** enaka $\lambda$-i (enako za disperzijo)
- Poissonovo porazdelitev lahko povezemo z **binomsko**: Naj $n$ stevilo manjsih casovnih enot in $p$ verjetnost, da pride mimo vsaj en avto
  - Problem: v eni casovni enoti lahko pride vec kot pricakovano avtomobilov, zato povecamo stevilo manjsih casovnih enot
  - opazujemo kaj se zgodi, ce gre $n$ proti $\infty$ in na koncu pidemo do **Poissonovega obrazca**, ki velja za velike $n$ in majhne $p$ s formulo $P_n(k) \approx \frac{(np)^{k}e^{-np}}{k!}$
  - To je tudi verjetnostna funkcija
  - $np = \lambda$
- Pri posissonovi porazdelitvi moramo upostevati **dve predpostavki:**
  - Da je vsaka casovna enota enaka kot naslednja
  - ni nujno, da se bo dogodek ponovil enako velikrat v naslednji casovni enoti, kot se je v prejsni

## Pascalova porazdelitev
- *Primer: Zanima nas koliko metov bo potrebnih, da sestico vrzemo 10x z 90% verjetnostjo*
- **Zaloga vrednosti** pascalove porazdelitve je $n,\ n+1,\ \ldots$, kjer je $n$ stevilo pojavitev poskusa (torej zanima nas, da se dokoged zgodi $n$-krat)
- Pascalova porazdelitev ima **pricakovano vrednost** $\frac{n}{p}$ in **disperzijo** $\frac{nq}{p^2}$
- Iz pascalove lahko hitro pridemo do geometrijske, ce za $n$ izberemo 1 (torej opazujemo verjetnost do prve pojavitve poskusa) in iz tega dobimo **pricakovano vrednost** za $G$ je $\frac{1}{p}$ in **disperzijo** $\frac{q}{p^2}$
- **Verjetnostna funkcija** je $p_k = \binom{k - 1}{m - 1}p^mq^{k - m} \ za \ k \geq m$

## Hipergeometrijska porazdelitev
- *Primer: Imamo R rdecih in B belih kroglic, od tega jih izvleces n, k oz X je stevilo rdecih kroglic, ki jih lahko izvleces med temi n ($H(R, B, n)$)*
- **Zaloga vrednosti** je neka podmnozica $N$ (t.j. mnozica vseh opazovanih elementov), za katero je sledeca verjetnostna funkcija vedno definirana:
  - $\frac{\binom{R}{k}\binom{B}{n-k}}{\binom{R+B}{n}}$
- Hipergeometrijsko porazdelitev uporabljamo za primere, kjer je $n$ obcuten glede na velikost celotne populacije, za vecje populacije z manjsimi $n$-ji lahko uporabljamo kar **binomsko porazdelitev**
- Prav tako veljajo dolocene omejitve parametrov:
  - $max(0, B - n) \leq k \leq min(R, n)$
  - $n \leq N = R + B$

## Zvezne slucajne spremenljivke
- Za neko s.s. pravimo, da je **zvezna**, ce obstaja za vsak $x$ element realnih stevil, taka **integrabilna funkcija**, kjer je $p$ gostota porazdelitve:
  - $F(x) \int_{-\infty}^x p(t) dt$
- **Skica:** 
  - **y** os - gostota
  - **x** os - zaloga vrednosti
  - npr. narisemo zvonasto krivuljo
- **Zaloga vrednosti** taksne s.s. je nek interval (npr. visina studenta, kjer je vrednost na intervalu npr. 140-210cm)
- **Lastnosti gostote:**
  - $\int_{-\infty}^{\infty} p(x) dx = 1$
  - $P(x_1 < X < x_2 = F(x_2) - F(x_1) = \int_{x_1}^{x_2} pt(dt)$
  - $p(x) = F'(x)$
- **Vrste porazdelitev:**
  - **Enakomerna** - npr. idealni generator stevil
  - **Normalna** - npr. Ocene
  - **Eksponentna** - npr. verjetnost, da bo vratar cakal na prihod studenta vec kot 3min, ce vemo, da se v povprecju pojavi 0.5 sudenta na minuto
  - **Gama** - kot exponentna le da upostevamo se, da se nek dogodek ponovi $k$ -krat
  - **Cauchyeva**
- Za racunanje na podintervalu pa uporabimo enako formulo kot 2. lastnost gostote

## Normalna porazdelitev
- Primer: porazdelitev ocen, zelimo, da bi bila najvecja frekvenca pri sredinski vrednosti - malo zelo slabih in malo zelo dobrih
- **Gostota:** $\frac{1}{\sigma \sqrt{2 \pi}}e^{-\frac{1}{2}(\frac{X - \mu}{\sigma})^2}$
  - $\sigma$ je koren disperzije
  - $\mu$ je enak pricakovani vrednosti
- **Zaloga vrednosti** je enaka vsem realnim stevilom
- **Porazdelitvnena funkcija:** $1/2 + \Phi(X - \frac{\mu}{\sigma})$, kjer je formula za **funkcijo napake** $\Phi(x) = \frac{1}{\sqrt{2 \pi}}\int_0^x e^{-\frac{t^2}{2}} dt$
  - $\Phi(x) = 0$
- Normalno porazdelitev lahko povezemo s **CLI:**
  - Ce imamo neke neodvisne slucajne spremenljivke, ki so enako porazdeljene lahko sklepamo, da bo njihova vsota porazdeljena priblizno normalno
  - dobljeno vsoto lahko nadaljno standardiziramo (kar pomeni, da bo pricakovana vrednost enaka nic, odklon pa 1) s pomocjo formule $Z = S - \frac{\mu}{\sigma}$ 
  - in ker vemo, da velja $E(S) = \mu$ dobimo $E(Z) = E(S) - \frac{\mu}{\sigma} \rightarrow E(Z) = \mu - \frac{\mu}{\sigma} = 0$
  - in iz tega $D(Z) = 1$
- Na grafu se $\mu$ nahaja natanko pod vrhom zvonaste krivulje, $\sigma$ pa levo in desno od nje
  - 68% na intervalu $\pm \sigma$
  - 95% na intevalu $\pm 2\sigma$
  - 99.7% na intervalu $\pm 3\sigma$
- Imamo tudi vecrazsezne normalne porazdelitve (npr. za dvorazsezno normalno porazdelitev $N(\mu x, \mu y,\sigma x, \sigma y, p)$, kjer je $p$ korelacijski koeficient $X$ in $Y$) 
  - Formula za **gosoto:** `(1/2pi*oxoy*koren od 1-pna2)*e na (1/2*(1-p na 2))*(standardiziran X)na2 – 2p*standX*standY + (stand Y) na2)`

## Bernullijev zakon velikih stevil
- Definicija verjetnosti:
  - **statisticna:** imamo nek dogodek A, ki ima neko verjetnost (0-1) z oznako $P(A)$, za dogodek A lahko recemo, da se bo pri vecjih ponovitvah poskusa frekvence pojavitve dogodka A ustalila pri $P(A)$
  - **klasicna:** imamo nek skupek dogodkov E1...Es, ki so enako verjetni, tedaj vemo, da za vsak Ei (1 - s) velja, da $P(E_i) = \frac{1}{s}$, ce pa imamo nek dogodek A, ki je skupek dogodkov E(npr. 1 - m), pa vemo, da bo verjetnost dogodka A enaka $\frac{m}{s}$
- **Zapisan izrek:** naj `n` stevilo ponovitev dogodka, `p` verjetnost, `q = 1 - p` ter `k` frekvenca dogodka A v n neodvisnih poskusih, tedaj velja da za vsak $\epsilon > 0$, da je $\lim_{n \to \infty} P(\lvert\frac{k}{n - p}\rvert \leq \epsilon) = 1$ in da $P(\lvert\frac{k}{n-p}\rvert \leq) \approx 2  \Phi(\epsilon \sqrt{\frac{n}{qp}})$
- **Funkcija napake** je enaka kot pri normalni porazdelitvi $\Phi(x) = \frac{1}{\sqrt{2 \pi}}\int_0^x e^{-\frac{t^2}{2}} dt$
- Primer: Kovanec vrzemo 300x, kaksna je verjernost, da se bo frekvenca pojavitve grba razlikovala od 0.5 za manj kot 0.01

## Eksponentna
- To je porazdelitev, kjer pri Posiisonovem procesu merimo cas med dvema dogodkoma
- Poissnov proces je proces, kjer opazujemo neodvisne in zvezne dogodke, ki se ponavljajo z neko konstantno hitrosjo
- Primer: Studenti v klub prihajajo priblizno poissonovo porazdeljeno, kjer na minuto pride 0.5 studenta 
