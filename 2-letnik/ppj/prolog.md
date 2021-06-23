---
layout: note
title: Principi Programskih Jezikov - Prolog
---

- [Cheat Sheet](#cheat-sheet)
- [Codeq](#codeq)
  - [Family Relations](#family-relations)
  - [The World Factbook](#the-world-factbook)
  - [Lists](#lists)
  - [Lists and arithmetic](#lists-and-arithmetic)
  - [Sorting](#sorting)
  - [Sets](#sets)
  - [Trees](#trees)
  - [License plates](#license-plates)
  - [CLP(R)](#clpr)
  - [CLP(FD)](#clpfd)

# Cheat Sheet
```pl
a_ali_b(X) :- X = a ; X = b.
```

> **Operatorji/predikati**
> `;` — disjunkcija
> ``,` — konjunkcija
> `=` — zdruzevanje
> `==` — enakost
> `\==` — neenakost (pazi !)
> `\+` — negacija  (pazi !!)
> `>`, `<`, `=<`, `>=`, `=\=`, `=:=` — primerjava dveh izrazov, ki se evelvirata v števili

> **List**
> `[]` is the empty list.
> `[1, 2, 3]` is the list whose head is `1` and whose tail is `[2, 3]`.
> `[H | T]` is the list whose head is `H` and whose tail is `T`.

# Codeq
## Family Relations
> `mother(M, C)`: `M` is the mother of `C`.
> ```pl
> mother(M, C) :-
>    parent(M, C),
>    female(M).
> ```

> `father(X, Y)`: `X` is the father of `Y`.
> ```pl
> father(X, Y) :-
>     parent(X, Y),
>     male(X).
> ```

> `grandparent(P, C)`: `P` is a grandparent of `C`.
> ```pl
> grandparent(X, Y) :-
>     parent(Z, Y),
>     parent(X, Z).
> ```

> `sister(X, Y)`: `X` is a (half)sister of `Y`.
> ```pl
> sister(X, Y) :-
>     female(X),
>     parent(Z, X),
>     parent(Z, Y),
>     X \== Y.
> ```

> `brother(X, Y)`: `X` is a (half)brother of `Y`.
> ```pl
> brother(X, Y) :-
>     male(X),
>     parent(Z, X),
>     parent(Z, Y),
>     X \== Y.
> ```

> `aunt(X, Y)`: `X` is an aunt of `Y`.
> ```pl
> aunt(X, Y) :-
>     female(X),
>     sister(Z, X),
>     parent(Z, Y).
>     
> aunt(X, Y) :-
>     female(X),
>     brother(Z, X),
>     parent(Z, Y).
> ```

> `cousin(X, Y)`: `X` is a cousin of `Y`.
> ```pl
> cousin(X, Y) :-
>     parent(Xp, X),
>     parent(Yp, Y),
>     sister(Xp, Yp).
> cousin(X, Y) :-
>     parent(Xp, X),
>     parent(Yp, Y),
>     brother(Xp, Yp).
> ```

> `ancestor(X, Y)`: `X` is an ancestor (parent, grandparent, great-grandparent, ...) of `Y`.
> ```pl
> ancestor(Ancestor, X) :- parent(Ancestor, X).
> ancestor(Ancestor, X) :- 
>     parent(PX, X),
>     ancestor(Ancestor, PX).
> ```

> `descendant(X, Y)`: `X` is a descendant (child, grandchild, great-grandchild, ...) of `Y`.
> ```pl
> descendant(Descendant, X) :- parent(X, Descendant).
> descendant(Descendant, X) :-
>     parent(PD, Descendant),
>     descendant(PD, X).
> ```

## The World Factbook
> capital(X, Y): Y is the capital city of country X.
> ```pl
> capital(Country, Capital) :- country(Country, ID, Capital, CapitalProvince, Size, Population).
> ```

> all_capitals(List): List is a list of all capitals in the world.
> ```pl
> all_capitals(List) :- findall(Capital, country(_, _, Capital, _, _, _), List).
> ```

> people_in_capitals(N): N is the total number of people living in capital cities of the world.
> ```pl
> get_population(Population) :- 
>     country(_, ID, Capital, _, _, _),
>     city(Capital, ID, _, Population, _, _, _),
>     number(Population).
> 
> sum_list([], 0).
> sum_list([H | T], N):-
>     sum_list(T, X),
>     N is X + H.
> 
> people_in_capitals(N) :-
>     findall(Population, get_population(Population), List),
>     sum_list(List, N).
> ```

> whoSpeaks(Lang, Country, NumOfSpeakers): predikat eno po eno vrne vse države Country v kateri govorijo jezik Lang in obenem vrne tudi koliko ljudi NumOfSpeakers v tej državi govori ta jezik.
> ```pl
> whoSpeaks(Language, Country, NumOfSpeakers) :-
>     language(CountryCode, Language, PercentageOfSpeakers),
>     country(Country, CountryCode, _, _, _, Population),
>     NumOfSpeakers is PercentageOfSpeakers * Population / 100.
> ```

> grant(Location): predikat eno po eno vrne vse lokacije Location, ki ustrezajo pogojem. Location predstavlja ime lokacije.
> ```pl
> grant(Location) :-
>     (city(Location, _, _, _, Latitude, _, _);
>     island(Location, _, _, _, _, Latitude, _)),
>     number(Latitude),
>     Latitude < -36,
>     Latitude > -38.
> ```

> holiday(Country, Neighbour): Neighbour je sosednja država od Country, ki ima morje.
> ```pl
> holiday(Country, Neighbour) :-
>     (
>         borders(CountryCode, NeighbourCode, _); 
>         borders(NeighbourCode, CountryCode, _)
>     ),
>     country(Country, CountryCode, _, _, _, _),
>     country(Neighbour, NeighbourCode, _, _, _, _),
>     geo_sea(_, NeighbourCode, _).
> ```

> flows(X, Y): the river X flows to sea Y. The predicate should follow the flow from X through different rivers until it reaches a sea
> ```pl
> flows(Name, FlowsToSea) :-
>     river(Name, _, _, FlowsToSea, _, _, _, _, _, _, _, _),
>     FlowsToSea \= null.
>       
> flows(Name, FlowsToSea) :-
>     river(Name, FlowsToRiver, _, _, _, _, _, _, _, _, _, _),
>     flows(FlowsToRiver, FlowsToSea), 
>     FlowsToRiver \= null.
> ```

> landlocked2(Country): predikat eno po eno vrne vse države, ki nimajo ne morja, ne sosede z morjem.
> ```pl
> landlocked2(Country) :-
>     % List of country codes with no sea
>     findall(
>         CountryCodeX, 
>         (country(_, CountryCodeX, _, _, _, _), \+ geo_sea(_, CountryCodeX, _)), 
>         LandLocked
>     ),
>     % Get country
>     country(Country, CountryCode, _, _, _, _),
>     \+ (
>         (
>             borders(CountryCode, NeighbourCode, _); 
>             borders(NeighbourCode, CountryCode, _)
>         ), 
>         \+ member(NeighbourCode, LandLocked)
>     ),
>     member(CountryCode, LandLocked).
> ```

> simpop(X, Y, Diff): X and Y are countries with the most similar numbers of residents. Diff represents the difference between them.
> ```pl
> simpop(X, Y, Diff) :-
>     % countries data
>     country(X, _, _, _, _, XP),
>     country(Y, _, _, _, _, YP),
>     % not equal
>     X \= Y,
>     % no country exists with a smaller difference
>     \+ (country(Z, _, _, _, _, ZP), Z \= X, abs(XP - ZP) < abs(XP - YP)),
>     Diff is abs(XP - YP).
> ```

## Lists
> insert(X, L1, L2): the list L2 is obtained from L1 by inserting the element X at arbitrary position.
> ```pl
> insert(X, L1, [X | L1]).
> insert(X, [Y | L1], [Y | L2]) :- insert(X, L1, L2).
> ```

> memb(M, L): M is an element of list L.
> ```pl
> memb(M, [M | _]).
> memb(M, [_ | T]) :- memb(M, T).
> ```

> del(X, L1, L2): the list L2 is obtained from L1 by deleting element X.
> ```pl
> % L2 is L1 after X
> del(X, [X | L2], L2).
> del(X, [Y | L1], [Y | L2]) :- del(X, L1, L2).
> ```

> dup(L1, L2): the list L2 is obtained from L1 by duplicating every element.
> ```pl
> dup(L1, L2): the list L2 is obtained from L1 by duplicating every element.
> ```

> conc(L1, L2, L): the list L is obtained by appending the elements of L2 to L1.
> ```pl
> conc(L1, [], L1).
> conc([], L2, L2).
> conc([H | L1], L2, [H | L]) :- conc(L1, L2, L).
> ```

> last_elem(L, E): E is the last element of list L.
> ```pl
> last_elem([E | []], E).
> last_elem([_ | T], E) :- last_elem(T, E).
> 
> % or
> % last_elem(L, E) :- conc(_, [E], L).
> ```

> divide(L, L1, L2): the list L1 contains elements at odd positions in L, and the list L2 contains the elements at even positions in L.
> ```pl
> divide(List, Odd, Even):- odd(List, Odd, Even).
> 
> odd([H | T], [H | Odd], Even):- even(T, Odd, Even).
> odd([], [], []).
> 
> even([H | T], Odd, [H | Even]) :- odd(T, Odd, Even).       
> even([], [], []). 
>     
> ```

> permute(L1, L2): the list L2 is a permutation of the elements of the list L1.
> ```pl
> takeout(X, [X | R], R).  
> takeout(X, [F | R], [F | S]) :- takeout(X, R, S).
> 
> permute([X | Y], Z) :- 
>     permute(Y, W), 
>     takeout(X, Z, W).  
> permute([], []).
> ```

## Lists and arithmetic

> shiftleft(L1, L2): the list L2 is obtained from L1 by shifting elements to the left by one (circular shift).
> ```pl
> shiftleft([H | T], L2) :- conc(T, [H], L2).
> ```

> shiftright(L1, L2): the list L2 is obtained from L1 by shifting elements to the right by one (circular shift).
> ```pl
> shiftright(L1, L2) :- shiftleft(L2, L1).
> ```

> rev(L1, L2): the list L2 is obtained from L1 by reversing the order of the elements.
> ```pl
> rev([], []).
> rev([H | T], L2) :-
>     rev(T, RT),
>     conc(RT, [H], L2).
> ```

> palindrome(L): the elements of list L are the same when read from the front or back of the list.
> ```pl
> palindrome(X) :- rev(X, X).
> ```

> evenlen(L): the list L has an even number of elements.
> oddlen(L): the list L has an odd number of elements.
> ```pl
> oddlen([H | L]) :- evenlen(L).
> 
> evenlen([]).
> evenlen([H | L]) :- oddlen(L).
> ```

> len(L, Len): Len is the length of list L.
> ```pl
> len([], 0).
> len([_ | T], Len) :- 
>     len(T, LT),
>     Len is LT + 1.
> ```

> sum(L, Sum): Sum is the sum of all elements in list L.
> ```pl
> sum([], 0).
> sum([H | T], Sum) :-
>     sum(T, ST),
>     Sum is ST + H.
> ```

> min(L, Min): Min is the smallest value in list L.
> ```pl
> min([Min], Min).
> 
> min([H | T], Min) :-
>     min(T, Min),
>     Min < H.
>     
> min([H | T], H) :-
>     min(T, Min),
>     Min >= H.
> ```

> max(L, Max): Max is the largest value in list L.
> ```pl
> max([Max], Max).
> max([H | T], Max) :-
>     max(T, Max),
>     Max > H.
> max([H |T], H) :-
>     max(T, Max),
>     Max =< H.
> ```

> sublist(L, SL): SL is a continuous sublist of list L. Your program should return every possible sublist; each answer may be returned more than once.
> ```pl
> sublist(L, SL) :-
>     conc(LL, _, L),
>     conc(_, SL, LL).
> ```

## Sorting

> is_sorted(L): the elements of list L are sorted in non-decreasing order.
> ```pl
> is_sorted([]).
> is_sorted([_]).
> is_sorted([X, Y | T]) :- 
>     is_sorted([Y | T]),
>     X =< Y.
> ```

> slowest_sort_ever(L, SL): the list SL contains the elements of L sorted in non-decreasing order. Average and worst case running time is O(n * n!).
> ```pl
> slowest_sort_ever(L, SL) :-
>     permute(L, SL),
>     is_sorted(SL).
> ```

> sins(X, SortedList, NewList): the list NewList is obtained by inserting X into SortedList at the correct position to preserve the non-decreasing order of elements.
> ```pl
> % :D
> % sins(X, SortedList, NewList) :-
> %     conc([X], SortedList, SC),
> %     slowest_sort_ever(SC, NewList).
> 
> sins(X, [], [X]).
> sins(X, [H | SortedList], [X, H | SortedList]) :- X < H.
> sins(X, [H | SortedList], [H | NewList]) :-
>     sins(X, SortedList, NewList),
>     X >= H.
> ```

> isort(L, SL): the list SL contains the elements of L sorted in non-decreasing order. Use the predicate sins/3 to implement insertion sort.
> ```pl
> isort([], []).
> isort([H | T], SL) :-
>     isort(T, SLN),
>     sins(H, SLN, SL).
> ```

> pivoting(P, L, S, G): the list S contains the elements of L smaller or equal to P, and the list G contains the elements of L greater than P. The order of elements in S and G should be the same as in L.
> ```pl
> pivoting(_, [], [], []).
> pivoting(P, [H | L], [H | S], G) :-
>     pivoting(P, L, S, G),
>     H =< P.
> pivoting(P, [H | L], S, [H | G]) :-
>     pivoting(P, L, S, G),
>     H > P.
> ```

> quick_sort(L, SL): the list SL contains the elements of L sorted in non-decreasing order. Use the predicate pivoting/4 to implement quicksort.
> ```pl
> quick_sort([], []).
> 
> quick_sort([H | L], SL) :-
>     pivoting(H, L, S, G),
>     quick_sort(S, SSorted),
>     quick_sort(G, GSorted),
>     conc(SSorted, [H | GSorted], SL).
> ```

## Sets

> count(X, L, N): N is the number of times the element X appears in the list L.
> ```pl
> count(_, [], 0).
> count(X, [X | T], N) :-
>     count(X, T, NN),
>     N is NN + 1.
> count(X, [H | T], N) :- 
>     count(X, T, N),
>     X \= H.
> ```
>  
> union(S1, S2, U): the list U contains all elements of S1 and S2, with no duplicates.
> ```pl
> union([], S2, S2).
> union([H | S1], S2, [H | U]) :-
>     union(S1, S2, U),
>     count(H, S2, 0).
> union([H | S1], S2, U) :-
>     union(S1, S2, U),
>     \+ count(H, S2, 0).
> ```

> intersect(S1, S2, I): the list I contains every element that appears in both S1 and S2, with no duplicates.
> ```pl
> intersect([], _, []).
> intersect([H | S1], S2, [H | I]) :-
>     intersect(S1, S2, I),
>     count(H, S2, 1).
> intersect([H | S1], S2, I) :-
>     intersect(S1, S2, I),
>     count(H, S2, 0).
> ```

> diff(S1, S2, D): the list D contains all elements of S1 that don't appear in S2, with no duplicates.
> ```pl
> diff([], _, []).
> diff([H | S1], S2, [H | D]) :-
>     diff(S1, S2, D),
>     count(H, S2, 0).
> diff([H | S1], S2, D) :-
>     diff(S1, S2, D),
>     count(H, S2, 1).
> ```

> is_superset(S1, S2): the set S1 is a superset (contains all elements) of S2.
> ```pl
> is_superset(_, []).
> is_superset(S1, [H | S2]) :-
>     is_superset(S1, S2),
>     count(H, S1, 1).
> ```

> is_subset(S1, S2): the set S1 is a subset of S2.
> ```pl
> is_subset(S1, S2) :- is_superset(S2, S1).
> ```

> subset(Set, Subset): the set Subset is a subset of Set. This predicate should generate all valid solutions, one by one.
> ```pl
> subset([], []).
> subset([H | Set], [H | Subset]) :-
>     subset(Set, Subset).
> subset([_ | Set], Subset) :-
>     subset(Set, Subset).
> ```

> powerset(Set, Powerset): the list Powerset contains all subsets of Set.
> ```pl
> powerset([], [[]]).
> powerset([H | Set], Powerset2) :-
>     powerset(Set, Powerset),
>     add_to_all(H, Powerset, Powerset1),
>     conc(Powerset1, Powerset, Powerset2).
>     
> add_to_all(_, [], []).
> add_to_all(X, [H | Y], [[X | H] | Z]) :-
>     add_to_all(X, Y, Z).
> ```

## Trees
 
> memberBT(X, T): X is an element of the binary tree T. A binary tree node is represented with the structure b(L, E, R), where L and R are left and right subtrees, respectively, and E is the node's value. An empty tree is denoted by nil.
> ```pl
> memberBT(X, b(_, X, _)).
> memberBT(X, b(L, _, R)) :-
>     memberBT(X, L);
>     memberBT(X, R).
> ```
 
> mirrorBT(T, NewT): the binary tree NewT is obtained from T by flipping it over the vertical axis through the root node.
> ```pl
> mirrorBT(nil, nil).
> mirrorBT(b(L, X, R), b(R1, X, L1)) :-
>     mirrorBT(L, L1),
>     mirrorBT(R, R1).
> ```
 
> numberBT(T, N): N is the number of nodes in the binary tree T.
> ```pl
> numberBT(nil, 0).
> numberBT(b(L, _, R), N) :-
>     numberBT(L, NL),
>     numberBT(R, NR),
>     N is NL + NR + 1.
> ```
 
> depthBT(T, D): D is the depth of the binary tree T.
> ```pl
> depthBT(nil, 0).
> 
> depthBT(b(L, _, R), N) :-
>     depthBT(L, NL),
>     depthBT(R, NR),
>     (NL > NR,
>     N is NL + 1;
>     NL =< NR,
>     N is NR + 1).
> ```
 
> tolistBT(T, L): the list L contains all the elements in the binary tree T, in infix order.
> ```pl
> tolistBT(nil, []). 
> tolistBT(b(L, X, R), C) :-
>     tolistBT(L, CL),
>     tolistBT(R, RL),
>     conc(CL, [X | RL], C).
> ```
 
> deleteBT(X, T, NewT): the binary tree NewT is obtained from T by deleting one occurence of the element X. If X is not a leaf node, the root of one of its subtrees is moved up. Your code should generate all valid solutions.
> ```pl
> deleteBT(X, b(b(LL, LX, LR), X, R), b(L, LX, R)) :- %get it from the left tree
>     deleteBT(LX, b(LL, LX, LR), L). 
> deleteBT(X, b(L, X, b(RL, RX, RR)), b(L, RX, R)) :- %get it from the right tree
>     deleteBT(RX, b(RL, RX, RR), R).     
> deleteBT(X, b(L, Y, R), b(L, Y, DR)) :-
>     deleteBT(X, R, DR).     
> deleteBT(X, b(L, Y, R), b(DL, Y, R)) :-
>     deleteBT(X, L, DL). 
> deleteBT(X, b(nil, X, nil), nil). 
> ```

> insertBT(X, T, NewT): the binary tree NewT is obtained from T by inserting the element X at a certain position. This is the opposite of the predicate deleteBT/3. Your code should generate all valid solutions.
> ```pl
> insertBT(X, T, NewT) :-
>     deleteBT(X, NewT, T).
> ```

> memberT(X, T): X is an element of the tree T. A tree node is represented with the structure t(E, T1, T2...), where E is the node's value, followed by any number of subtrees. An empty tree is denoted by nil.
> ```pl
> memberT(X, T) :-
>     T =.. [t, X | R].    
> memberT(X, T) :-
>     T =.. [t, _ | R],
>     member(Y, R),
>     memberT(X, Y).
> ```

> maxT(Tree, Max): Max is the greatest element in the tree Tree.
> ```pl
> maxT(Tree, Max) :-
>     memberT(Max, Tree),
>     \+ (memberT(X, Tree), X > Max).
> ```

## License plates

> getdigits(L, DL): the list DL contains the numeric elements of L, in the same order as in the original list.
> ```pl
> getdigits([], []).
> getdigits([H | T], [H | DL]) :-
    > getdigits(T, DL),
    > number(H).   
> getdigits([H | T], DL) :-
    > getdigits(T, DL),
    > \+ number(H).
> ```

joindigits(L, NL): the list NL is obtained from L by arbitrarily joining neighboring digits. Your code should > generate all valid solutions.
> ```pl
> joindigits([D], [D])
> joindigits([D1, D2 | L1], NL1) :-
    > J is D1 * 10 + D2,
    > joindigits([J | L1], NL1).   
> joindigits([D1 | L1], [D1 | NL1]) :-
    > joindigits(L1, NL1).
> ```

firstMinus(L1, L2): the list L2 is the same as L1, except for the first element that may be negated. Your > code should return both solutions.
> ```pl
> firstMinus([], []).
> firstMinus([H1 | L], [H2 | L]) :-
    > H1 = H2;
    > -H1 = H2;
    > H1 = -H2.
> ```

genexp(L, E): the expression E is obtained from the list L by inserting arithmetic operators between list > elements. Your code should generate all valid solutions.
> ```pl
> genexp([X], X).
> genexp(L1, E1) :-
    > conc(L, [H], L1),
    > (E1 = E+H;
    > E1 = E-H;
    > E1 = E*H;
    > E1 = E/H),
    > genexp(L, E).  
> genexp([H | L], E1) :-
    > (E1 = H+E;
    > E1 = H-E;
    > E1 = H*E;
    > E1 = H/E),
    > genexp(L, E).
> ```

> checkLicensePlate(LP, E1, E2): the digits in the list LP can be combined into a valid equation E1 = E2. E1 and E2 are arithmetic expressions, obtained from sublists of Plate by inserting arithmetic operators (+, -, * and /) between elements. An additional unary minus can be inserted before the leftmost number of E1 and E2.
> ```pl
> checkLicensePlate(LP, E1, E2) :-
    > getdigits(LP, DLP),
    > conc(L1, L2, DLP),
    > joindigits(L1, NL1),
    > joindigits(L2, NL2),
    > firstMinus(NL1, ML1),
    > firstMinus(NL2, ML2),
    > genexp(ML1, E1),
    > genexp(ML2, E2),
    > E1 =:= E2.
> ```

## CLP(R)
> A megabyte is the SI unit meaning 106 bytes, while a mebibyte is the IEC unit meaning 220 bytes. Write the predicate megabytes(SI, IEC) that converts between the two using constraints.
> ```pl
> megabytes(SI, IEC) :- {10 ^ 6 * SI = 2^20 * IEC}.
> ```
 
> A set of points in the plane is defined by the inequalities  
> - 0 ≤ X ≤ 5,
> - Y ≥ 0,
> - X + Y ≤ 7,
> - X + 2*Y ≥ 4 and
> - Y ≤ X + 5.  
> The predicate linear_opt(X, Y, MaxE) should return the point (X, Y) where the expression E = -0.4*X + 3.2*Y has the largest value.
> ```pl
> linear_opt(X, Y, MaxE) :-
>     {0 =< X, X =< 5,
>     Y >= 0,
>     X + Y =< 7,
>     X + 2 * Y >= 4,
>     Y =< X + 5,
>     E = -0.4*X + 3.2*Y},
>     maximize(E),
>     MaxE = E.
> ```
 
> max_adj_pair(List, Max): Max is the maximal sum of two adjacent elements in List.
> ```pl
> max_adj_pair([E1, E2 | List], Max) :-
>     {Max >= E1 + E2},
>     max_adj_pair([E2 | List], Max).
> max_adj_pair([_], Max) :-
>     minimize(Max).
> ```

> Formulate an LP model to help the rancher decide how to mix the two brands of turkey feed so that the minimum monthly intake requirement for each nutritional ingredient is met at minimum cost. Write the predicate turkey(Brand1, Brand2, Cost) that returns the amount (in kg) of brands 1 and 2 per turkey per month, and the total cost (in €).
> ```pl
> turkey(Brand1, Brand2, Cost) :-
>     {T = 1,
>     A >= 90 * T,
>     B >= 48 * T,
>     C >= 1.5 * T,
>     A = 5 * Brand1 + 10 * Brand2,
>     B = 4 * Brand1 + 3 * Brand2,
>     C = 0.5 * Brand1,
>     Cost = 0.2 * Brand1 + 0.3 * Brand2},
>     minimize(Cost).
> ```
 
> bounding_box(Points, X1/Y1, X2/Y2): X1/Y1 and X2/Y2 are the bottom-left and top-right points defining the smallest bounding box containing all points in the list Points.
> ```pl
> % Broken 1/3
> bounding_box([X/Y | Points], X1/Y1, X2/Y2) :-
>     {X1 =< X,
>     X2 >= X,
>     Y1 =< Y,
>     Y2 >= Y},
>     bounding_box(Points, X1/Y1, X2/Y2).
> bounding_box([_], X1/Y1, X2/Y2) :-
>     minimize(X2 - X1),
>     minimize(Y2 - Y1).
> ```

> center(Points, R, X/Y): X/Y is a point in the list Points that is at most R away from all other points.
> ```pl
> center1([], _, _).
> center1([Xi/Yi | Points], R, X/Y) :-
>     {Dx = X - Xi, Dy = Y - Yi,
>     Dx * Dx + Dy * Dy =< R * R},
>     center1(Points, R, X/Y).
> center(Points, R, X/Y) :-
>     member(X/Y, Points),
>     center1(Points, R, X/Y).
> ```

## CLP(FD)

> When asked how old she was, Beth replied "In two years I will be twice as old as I was five years ago". Write the predicate puzzle_beth(X) that finds her current age as X.
> ```pl
> puzzle_beth(X) :-
>     X + 2 #= 2 * (X - 5).
> ```

> Person A is two years older than B who is twice as old as C. The total of the ages of A, B and C is 27. Write the predicate puzzle_abc(A, B, C) that finds the ages of the three people.
> ```pl
> puzzle_abc(A, B, C) :-
>     A #= 2 + B,
>     B #= 2 * C,
>     A + B + C #= 27,
>     [A, B, C] ins 0..sup,
>     label([A, B, C]).
> ```

> The sum of ages of mother and her son is 66. The mother's age is the son's age reversed. How old are they? Write the predicate puzzle_momson(M, S) that finds the ages of mother M and son S.
> ```pl
> puzzle_momson(M, S) :-
>     M + S #= 66,
>     M #> S,
>     M #= D1 * 10 + D0,
>     S #= D0 * 10 + D1,
>     [D1, D0] ins 1..9,
>     label([M, S]).
> ```

> Present ages of A and B are in the ratio of 5:4. In three years the ratio of their ages will become 11:9.Write the predicate puzzle_ratio(A, B) that finds the ages of A and B.
> ```pl
> puzzle_ratio(A, B) :-
>     4 * A #= 5 * B,
>     9 * (A + 3) #= 11 * (B + 3),
>     [A, B] ins 0..10000000000,
>     label([A, B]).
> ```

> magic(S): the list S represents a 3×3 magic square (S is a permutation of numbers 1 to 9 - three numbers for each row). The sums of numbers in each row, column and diagonal of a magic squre are equal. Implement this predicate using constraints. Your code should return all possible solutions.
> ```pl
> magic(S) :-
>     permute([1, 2, 3, 4, 5, 6, 7, 8, 9], S),
>     S = [A, B, C,
>          D, E, F,
>          G, H, I],
>          
>     A + B + C #= X,
>     D + E + F #= X,
>     G + H + I #= X,
>     
>     A + D + G #= X,
>     B + E + H #= X,
>     C + F + I #= X,
>     
>     A + E + I #= X,
>     G + E + C #= X.
> ```

> gcd(X, Y, GCD): GCD is the greatest common divisor of X and Y. Implement this predicate using constraints.
> ```pl
> gcd(X, 0, X) :- !.
> gcd(0, X, X) :- !.
> gcd(X, Y, GCD) :-
>     X #>= Y,
>     Z #= X - Y,
>     gcd(Z, Y, GCD).
> gcd(X, Y, GCD) :-
>     X #< Y,
>     Z #= Y - X,
>     gcd(X, Z, GCD).
> ```

> tobase(Number, B, X): given a Number in the decimal system (base 10), X represents the same number in the system with base B. Implement this predicate using constraints. Limit the value of B to the interval [2..10].
> ```pl
> % Broken 4/7
> tobase(0, _, 0) :- !.
> tobase(Number, B, X) :-
>     B in 2..10,
>     MaxDigit #= B - 1,
>     Digit in 0..MaxDigit,
>     X #= 10 * X1 + Digit,
>     Number #= B * Number1 + Digit,
>     tobase(Number1, B, X1).
> ```