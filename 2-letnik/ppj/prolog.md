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
