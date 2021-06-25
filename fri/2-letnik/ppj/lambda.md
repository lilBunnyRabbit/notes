---
layout: note
title: Lambda
toc: true
---

```
-- pomoc: ./plzoo/lambda.native -l vaje4.lambda --wrapper rlwrap
-- implementacija `true`, `false` in `if` s predavanj
true  := ^ x y . x ;
false := ^ x y . y ;
false' := ^ x . ^ y . y ;
if := ^ p x y . p x y ; 

-- te konstante niso "konstantne funkcije" (oz. nevemo)
:constant T
:constant F

-- 1 ∧ q ~ q 
and := ^ p q . if p q false ;
not := ^ p . if p false true ;
or := ^ p q . if p true (if q true false);
imply := ^ p q . if p (if q true false) true;
iff := ^ p q . and (imply p q) (imply q p) ;
bool := ^ p . if p T F ;

0' := ^ f x . x ;
1' := ^ f x . f x ;
2' := ^ f x . f (f x) ;
3' := ^ f x . f (f (f x)) ;
4' := ^ f x . f (f (f (f x))) ;
5' := ^ f x . f (f (f (f (f x)))) ;
6' := ^ f x . f (5' f x) ;

nasl := ^ n . ^ f x . f (n f x) ;

-- (f o g) x = f (g x)

-- n' : (f |-> f^n)
-- n' : (x |-> (f |-> f(f ... f(x))))


0 := ^ f x . x ;
1 := ^ f x . f 0 x ;
2 := ^ f x . f 1 (f 0 x) ;
3 := ^ f x . f 2 (f 1 (f 0 x)) ;
4 := ^ f x . f 3 (f 2 (f 1 (f 0 x))) ;
5 := ^ f x . f 4 (f 3 (f 2 (f 1 (f 0 x)))) ;
6 := ^ f x . f 5 (5 f x) ;

succ := ^ n . ^ f x . f n (n f x) ;

-- g 0 = x
-- g (n+1) = f n (g n)

-- fact 0 = 1
-- fact (n+1) = (n+1) * (fact n)
-- fact (n+1) = (^ m r . (m+1) * r) n (fact n)

-- fact := ^ n . n (^ m r . (m+1) * r) 1

-- fact 0 = (^ n . n (^ m r . (m+1) * r) 1) 0
--        = 0 (^ m r . (m+1) * r) 1 = 1


-- fact 2 = (^ n . n (^ m r . (m+1) * r) 1) 2
--        = 2 (^ m r . (m+1) * r) 1
--        = (^ f x . f 1 (f 0 x)) (^ m r . (m+1) * r) 1
--        = (^ m r . (m+1) * r) 1 ((^ m r . (m+1) * r) 0 1)
--        = (^ m r . (m+1) * r) 1 ((0+1) * 1)
--        = (1+1) * ((0+1) * 1) = 2

-- g 0 = x
-- g (n+1) = f n (g n)
-- g := ^ n . n f x

-- pred 0 = 0
-- pred (n+1) = (^ m r . m) n (pred n)

pred := ^ n . n (^ m r . m) 0 ;

-- (5 := ^ f x . f 4 (f 3 (f 2 (f 1 (f 0 x)))))
-- pred 5 = 5 (^ m r . m) 0
--        = (^ f x . f 4 (f 3 (f 2 (f 1 (f 0 x))))) (^ m r . m) 0 =
--        = (^ m r . m) 4 ((^ m r . m) 3 ((^ m r . m) 2 ((^ m r . m) 1 ((^ m r . m) 0 0))))
--        = 4

:deep
:eager

:constant S
:constant Z

-- show 0 = Z
-- show (n+1) = S (show n)
-- show (n+1) = f n (show n)
-- show (n+1) = (^ m r . S r) n (show n)
show := ^ n . n (^ m r . S r) Z ;

-- 0 + k = k
-- succ n + k = succ (n + k)
-- plus 0 k = k
-- plus (n+1) k = succ (plus n k)

-- plusk 0 = k
-- plusk (n+1) = succ (plusk n)
-- plusk (n+1) = f n (plusk n)
-- plusk (n+1) = (^ m r . succ r) n (plusk n)
k := 3 ;
plusk := ^ n . n (^ m r . succ r) k ;
+ := ^ k . ^ n . n (^ m r . succ r) k ;
-- + := ^ k n . n (^ m r . succ r) k ;
plus2 := + 2 ;

-- 0 · k = 0
-- (succ n) · k = k + n · k
-- mno 0 k = 0
-- mno (n+1) k = k + mno n k

-- mnok 0 = 0
-- mnok (n+1) = k + mnok n
-- mnok (n+1) = f n (mnok n)
-- mnok (n+1) = (^ m r . + r k) n (mnok n)

mnok := ^ n . n (^ m r . + r k) 0 ;
* := ^ k . ^ n . n (^ m r . + r k) 0 ;

-- n - 0 = n
-- n - (k+1) = pred (n - k)
-- za drugi pogoj poskri ze predhodnik
-- ods n 0 = n
-- ods n (k+1) = pred (ods n k)
-- ods n (k+1) = f k (ods n k)
-- ods n (k+1) = (^ m r . pred r ) k (ods n k) = pred (ods n k)
- := ^ n . ^ k . k (^ m r . pred r ) n;

0' := ^ f x . x ;
1' := ^ f x . f x ;
2' := ^ f x . f (f x) ;
3' := ^ f x . f (f (f x)) ;
4' := ^ f x . f (f (f (f x))) ;
5' := ^ f x . f (f (f (f (f x)))) ;
6' := ^ f x . f (5' f x) ;

power := ^ x y . y x ;
composition := ^ f g x . f (g x) ;

-- Kaj je kompozitum?: (f ∘ g) x = f (g x)
-- krajši zapis: f ∘ f ∘ f = f³

-- 2' : g ↦ g ∘ g
-- 3' : f ↦ f ∘ f ∘ f
-- power 2' 3' =
--         3' 2' : (f ↦ f ∘ f ∘ f) (g ↦ g ∘ g) =
--         (g ↦ g ∘ g) ∘ (g ↦ g ∘ g) ∘ (g ↦ g ∘ g) =
--         h ↦ ((g ↦ g²) ∘ (g ↦ g²) ∘ (g ↦ g²)) h =
--         h ↦ (((h)²)²)² = h^(2³) = h⁸
--         h ↦ h ∘ h ∘ h ∘ h ∘ h ∘ h ∘ h ∘ h

-- vsota prvih n naravnih stevil
-- primitivna rekurzija
-- sum 0 = 0
-- sum (n+1) = n+1 + (sum n)

sum := ^ n . n (^ m r . + (+ m 1) r) 0 ;

-- sum 2  (2 := ^ f x . f 1 (f 0 x)):
-- 2 (^ m r . + (+ m 1) r) 0 ;
-- = (^ m r . + (+ m 1) r) 1 ((^ m r . + (+ m 1) r) 0 0) =
-- = (^ m r . + (+ m 1) r) 1 1
-- = 3
```


