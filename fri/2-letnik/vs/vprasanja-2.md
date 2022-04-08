---
layout: note
title: Teorija vprasanja - 2. del
toc: true
quotes: true
---

| Porazdelitev      |                        | $E(X)$                           | $D(X)$                                             |
| :---------------- | :--------------------- | :------------------------------- | :------------------------------------------------- |
| Binomska          | $B(n,\ p)$             | $np$                             | $npq$                                              |
| Geometrijska      | $G(p)$                 | $\frac{1}{p}$                    | $\frac{q}{p^2}$                                    |
| Pascalova         | $P(m,\ p)$             | $\frac{m}{p}$                    | $m\frac{q}{p^2}$                                   |
| Poissonova        | $\text{Pois}(\lambda)$ | $\lambda$                        | $\lambda$                                          |
| Hipergeometrijska | $H(n;\ M,\ N)$         | $n\frac{M}{N}$                   | $\frac{M(N-M)n(N-n)}{N^2(N-1)}$                    |
| Enakomerna        | $E(a,\ b)$             | $\sum_{i = 1}^{n}x_i\frac{k}{n}$ | $\frac{1}{n}\sum_{k = 1}^n (x_k - \overline{x})^2$ |
| Normalna          | $N(\mu,\ \sigma)$      | $\mu$                            | $\sigma^2$                                         |
| Exponentna        |                        | $\frac{1}{\lambda}$              | $\frac{1}{\lambda^2}$                              |
| Gama              | $\Gamma(b,\ c)$        | $\frac{b}{c}$                    | $\frac{b}{c^2}$                                    |
| Hi-kvadrat        | $\chi^2(n)$            | $n$                              | $2n$                                               |

## Pricakovana vrednost slucajne spremenljivke
- Primer: Vrzemo dva kovanca in standardno kocko, za vsako piko dobimo 1 evro in za vsako padlo cifro pa 2 evra. Slucajna spremenljivka $S$ predstavlja skupni dobljeni znesek v evrih -> zanima nas $E(S)$ (pricakovan dobicek)
- Motivacija za definicijo:
  - $E(X)$ je posplositev povprecne vrednosti diskretne spremenljivke
  - $X \approx \binom{x1\ x2\ \ldots \ x3}{p1\ p2\ \ldots \ p3}$
  - od koder izhaja $E(X) = \sum_{i = 1}^{m} x_ip_i$
- Definicja **diskrene slucajne spremenljivke:**
  - $E(X) = \sum_{i = 1}^{\infty} x_i p_i$, ce je $\sum_{i = 1}^{\infty} \|x_i\|p_i < \infty$
- Definicija **zvezne slucajne spremenljivke:**
  - $E(X) = \int_{-\infty}^{\infty} xp(x) dx$, ce je $\int_{-\infty}^{\infty} \|x\|p(x) dx < \infty$
- Primer slucajne spremenljivke, za katero ne obstaja $E(X)$
  - Met kovanca, kjer imas cifro in grb kot verjetnosti, ki jih lahko zavzame $X$, saj bi to zgledalo kot $E(X) = 0.5 * \text{cifra} + 0.5 * \text{grb} = ???$
- 