---
layout: note
title: Vprasanja
toc: true
---

# ORS izpitna vprasanja
## 1. Sklop
1. **Kaj je polje DRAM? Kako je organizirano?**
2. **Zakaj imamo v polju DRMA ccelic dolge vrstice?**
3. **Zakaj v polju DRAM celic vrstice niso dolge toliko kot je dolga ena pomnilniška beseda?**
4. **Zakaj potrebujemo signala CAS# in RAS# ? Zakaja preprosto ne izstavimo naslova pomnilniške besede?**
5. **Kaj je banka v DRAM pomnilnikih?**
6. **Koliko polj DRAM vsebuje ena banka?**
7. **Do katerih DRAM celic v DRAM banki dostopamo istočasno?**
8. **Kako osvežujemo vsebino vsrtice v DRAM banki?**
9. **Opišite dostop (bralni ali pisalni) do DRAM banke (časovno zaporedje naslovnih in kontrolnih signalov, časi, ..)**
10. **Kaj sdo časi tRAS, tRDC, tRP, tRCin tCL?**
11. **Kako je definiran čas dosatopa do vrstice tRC?**
12. **Kako izboljšamo odzivnost DRAM pomnilnikov? Kaj je Fast Page Mode DRAM? Kaj pa EDO DRAM?**
13. **Kakšne izboljšave prinaša SDRAM?**
14. **Kaj je CAS latenca pri SDRAM-ih? Kako je pri SDRAM-ih definirana (določena)?**
15. **Kakšne so tipične vrednosti časov tRCD, tCL (CAS latency), tRP pri modernih SDRAM-ih? Ali jih lahko tehnološko skrajšamo in kako?**
16. **Kaj je DDR? Kaj je 2n-prefetch?** 
17. **Kaj so ukazi pri SDRAM-ih?**
18. **Opišite dostop (pisalni ali bralni) do banke v SDRAM pomnilniku?** 
19. **Kaj je eksplozijski prenos?**  
20. **Kakšna je razlika med eksplozijskim prenosom in 2n-prefetchom? Ali lahko uporabomo oboje?**
21. **Ali pri DDR(2,3,4) lahko opravimo eksplozijski dostop dolžine 1?** 
22. **Opišite kako pohitrimo dostope pri DDR(2,3,4) v primerjavi s SDRAM-i?**
23. **Kako se pri SDRAM-ih mapirajo naslovi iz CPE v naslove vrstice, stolpca, banke?**
24. **Kaj je DIMM modul?**
25. **Kaj je rank?**
26. **Do koliko podatkov naenkrat dostopamo pri DDR(2,3,4) DIMM modulu?**
27. **Kajh pomeniji čai podani kot npr. 9-9-9 pri DIMM modulih?**
28. **Kaj pomeni PC4-19200 pri DDR4 DIMM modulih?**
29. **Kako je določena frkevnca ure na vodilu za DDR(2,3,4)?**
30. **Kaj so kanali? Koliko kanalov podpirajo sodobni procesorji in njihovi pomnilniški krmilniki?**
31. **Kako so kanali označeni na matičnih ploščah?**
32. **Predpostavite, da imate dva enaka DIMM modula? Kako jih boste vstavili v sockete na matični plošči? Zakaj?**

## 2. Sklop
33. **Kaj so izjeme (prekinitve in pasti)?**
34. **Kako se prožijo prekinitve?**
35. **Kaj je prekinitvena tabela?**
36. **Kako je organizirana prekinitvena tabela pri ARM Cortex M procesorjih?**
37. **Kaj je prekinitveno servisni podprogram (interrupt handler)?**
38. **Kako CPE pridobi naslov PSP?**
39. **Kaj je prekinitveni krmilnik in zakaj ga potrebujemo?**
40. **Opišite delovanje prekinitvenega krmilnika Intel 8259A.**
41. **Kako bi s prekinitvenim krmilnikom 8259A servisirali več kot 8 prekinitvenih zahtev (kanalov)?**
42. **Opišite kaskadno vezavo prekinitvenih krmilnikov 8259A.**
43. **Kaj je osnova ideja pri APIC?**
44. **Opišite vlogo LAPIC in IO APIC?**
45. **Kaj je APIC vodilo? Čemu je namenjeno?**
46. **Opišite delovanje IO APIC krmilnika.**
47. **Kaj ej to preusmeritvena tabela v IO APIC (redirection table)?**
48. **Kaj so to PCI prekinitve? Kako si PCI naprave delijo prekinitvene signale?**
49. **Kam se vežejo PCI prekinitveni signali PIRQA - PIRQD na IO APIC?**
50. **Kako je pametno povezati INTA-INTD signale med posameznimi PCI napravami?**
51. **Predpostavite, da v sistem želite vstaviti neko PCI kaertico. Kako boste izbrali na katerem vhodu (PIRQA-PIRQD) bo prožila prekinitve?**
52. **Kaj so to MSI prekinitve?**

## 3. Sklop
53. **Zakaj potrebujemo DMA krmilnike? Kako bi bilo brez njih?**
54. **Kakšna je razlika med fly-by in fly through DMA krmilnik? Navedite dva realna primera.**
55. **Opišite delovanje 8237A DMA krmilnika.**
56. **Opišite delovanje DMA krmilnika v sistemih STM32F4.**
57. **Kaj je DMA kanal?**
58. **Na koga se nanaša naslov, ki ga izstavi fly-by DMA krmilnik?**
59. **Predpostavite, da želite iz V/I naprave prenašati v pomnilnik. Opištite DMA prenos ter vse sodelujoče signale za 8237A.**
60. **Kakšna razlika je med tokom (stream) in kanalom pri DMA krmilniku v STM32F'.**
61. **Opišite inicializacijo DMA krmilnika. Kaj je vse treba nastaviti pred začetkom prenosa?**
62. **Kako DMA krmilnik obvesti CPE, da je prenos zaključen?**
63. **Kaj je to bus mastering?**

## 4. Sklop
63. **Kaj je to navidezni pomnilnik? Zakaj ga imamo?**
64. **Kaj je stran in kaj je okvir?**
65. **Kako velika naj bo stran?**
66. **Kaj je napaka strani?**
67. **Kaj je deskriptor strani?**
68. **Kaj vsebuje tabela strani?**
69. **Opišite večnivojsko ostranjevanje?**
70. **Najmanj koliko tabel strani moramo hraniti v pomnilniku pri 2(3,4, ..)-nivojskem ostranjevanju?**
71. **Kako pohitrimo preslikovanje navideznih naslovov?**
72. **Kaj je TLB? Kako je organiziran? Kako je velik?**
73. **Zakaj zadošča tako mali TLB? Na kaj se zanašamo?**
74. **Kako preslikujemo naslove v prisotnosti predpomnilnika?**
75. **Zakaj ni dobro, da v predpomnilnik gremo z navideznim naslovom? Zakaj pa bi bilo to dobro?**
76. **Kako sme biti velika stran ob prisotnosti predpomnilnika? Zakaj?**