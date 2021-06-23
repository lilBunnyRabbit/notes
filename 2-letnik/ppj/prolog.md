---
layout: note
title: Principi Programskih Jezikov - Prolog
---

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