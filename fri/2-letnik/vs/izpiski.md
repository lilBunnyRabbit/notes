---
layout: note
title: Izpiski vaje
toc: true
quotes: true
---
## Kombinatorika

> <t-def>Pravilo produkta</t-def>  
> Denimo, da izbiranje poteka v $k$ zaporednih korakih. Na prvem koraku izbiramo med $n_1$ moznostmi **IN** na drugem med $n_2$ moznostmi, ..., **IN** nato na $k$-tem med $n_k$ moznostmi. Na vsakem koraku izbiranja naj bo stevilo moznosti neodvisno od izbiranja moznosti na prejsnjih korakih. Stevilo vseh moznih izborov je tedaj enako  
> 
$$
  n_1 \cdot n_2 \cdot \ldots \cdot n_k
$$

> <t-def>Pravilo vsote</t-def>  
> Kadar se pri izbiranju odlocamo za eno od $n_1$ moznosti iz prve mnozice, **ALI** za eno od $n_2$ moznosti iz druge mnozice, ..., **ALI** za eno od $n_k$ moznosti iz $k$-te mnozice, in so te mnozice paroma disjunktne, je stevilo vseh moznih izborov enako
> 
$$
  n_1 + n_2 + \ldots + n_k
$$

> <t-def>Pravilo komplementa</t-def>  
> Ce je vseh moznosti $n$ in je $s$ takih, ki ne ustrezajo pogojem (slabe moznosti), potem je dobrih moznosti 
> 
$$
  d = n - s
$$

> <t-def>Permutacije brez ponavljanja</t-def>  
> So razporeditve $n$ razlicnih elementov na $n$ prostih mest. **Vrstni red elementov JE pomemben**. Stevilo vseh takih razporeditev je 
> 
$$
  n! = n \cdot (n-1) \cdot (n-2) \cdot \ldots \cdot 2 \cdot 1
$$

> <t-def>Variacije brez ponavljanja</t-def>  
> So razporeditve $n$ razlicnih elementov na $k\ (k \leq n)$ prostih mest. **Vrstni red elemton JE pomemben**. Stevilo vseh takih razporeditev je 
> 
$$
\frac{n!}{(n-k)!} = n \cdot (n-1) \cdot (n-2) \cdot \ldots \cdot (n-k+1)
$$

> <t-def>Premutacije s ponavljanjem</t-def>  
> So razporeditve $n$ **ne nujno razlicnih elementov** na $n$ prostih mest. **Vrstni red JE pomemben**. Ce lahko elemente razelimo v $m$ skupin med sabo enakih elementov, in ce je v prvi taki skupini $k_1$ enakih elementov, v drugi $k_2$ enakih elementov, ..., v $m$-ti pa $k_m$ enakih elementov, potem je stevilo vseh takih razporeditev
> 
$$
\binom{n}{k_1, k_2, \ldots, k_m} = \frac{n!}{k_1! \cdot k_2! \cdot \ldots \cdot k_m!}
$$

> <t-def>Variacije s ponavljanjem</t-def>  
> So razporeditve $n$ razlicnih elementov na $k$ prostih mest. **Vrstni red JE pomemben**. Pri tem se lahko element dolocene vrste v razporeditvi pojavi poljubno mnogokrat. Stevilo vseh takih razporeditev je
> 
$$
n^k = n \cdot n \cdot \ldots \cdot n
$$

> <t-def>Kombinacije brez ponavljanja</t-def>  
> So izbire $k$ elementov izmed $n$ razlicnih elementov, kjer lahko vsak element izberemo le enkrat. **Vrstni red izbir NI pomemben**. Stevilo kombinacij brez ponavljanja je
> 
$$
\binom{n}{k} = \frac{n!}{k!(n - k)!} = \frac{n(n-1)(n-2)\cdot \ldots \cdot (n - k + 1)}{k(k-1)(k-2) \cdot \ldots \cdot 1}
$$

> <t-def>Pravilo kvocienta</t-def>  
> Ce imamo $n$ objektov, ki jih grupiramo v skupine velikosti $k$, za katere velja, da objektov znotraj iste skupine ne locimo, objekte iz dveh razlicnih skupin pa razlikujemo, potem je razlicnih razredov objektov
> 
$$
\frac{n}{k}
$$

> <t-def>Kombinacije s ponavljanjem</t-def>  
> So izbire $k$ elementov izmed $n$ razlicnih elementov. **Vrstni red NI pomemben**. Vsak element lahko izberemo poljubnokrat. Stevilo kombinacij s ponavljanjem je
> 
$$
\Big(\binom{n}{k}\Big) = \binom{n + k - 1}{k}
$$

## Verjetnost