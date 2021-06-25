---
layout: note
title: Principi Programskih Jezikov - Ocaml
---

# Cheat Sheet
```ml
(* Source: https://learnxinyminutes.com/docs/ocaml/
   Author: Daniil Baturin
   License: CC-BY-SA *)

(*** Comments ***)

(* Comments are enclosed in (* and *). It's fine to nest comments. *)

(* There are no single-line comments. *)


(*** Variables and functions ***)

(* Expressions can be separated by a double semicolon symbol, ";;".
   In many cases it's redundant, but in this tutorial we use it after
   every expression for easy pasting into the interpreter shell.
   Unnecessary use of expression separators in source code files
   is often considered to be a bad style. *)

(* Variable and function declarations use "let" keyword. *)
let x = 10 ;;
let x = 13 ;;

(* OCaml allows single quote characters in identifiers.
   Single quote doesn't have a special meaning in this case, it's often used
   in cases when in other languages one would use names like "foo_tmp". *)
let foo = 1 ;;
let foo' = foo * 2 ;;

(* Since OCaml compiler infers types automatically, you normally don't need to
   specify argument types explicitly. However, you can do it if
   you want or need to. *)
let inc_int x = x + 1 ;;
let inc_int : int -> int = fun x -> x + 1 ;;


(* One of the cases when explicit type annotations may be needed is
   resolving ambiguity between two record types that have fields with
   the same name. The alternative is to encapsulate those types in
   modules, but both topics are a bit out of scope of this
   tutorial. *)

(* You need to mark recursive function definitions as such with "rec" keyword. *)
let rec factorial = fun n -> 
   if n = 0
   then 1
   else n * factorial (n-1)
;;

let rec factorial =
   fun n ->
      if n = 0
      then 1
      else n * factorial (n-1)
;;

(* Function application usually doesn't need parentheses around arguments *)
let fact_5 = factorial  5 + 4 ;;

(* ...unless the argument is an expression. *)
let fact_4 = 100 - factorial (5-1) ;;
(* let sqr2 = sqr (-2) ;; *)

(* Every function must have at least one argument.
   Since some functions naturally don't take any arguments, there's
   "unit" type for it that has the only one value written as "()" *)
let print_hello () = print_endline "hello world" ;;

(* Note that you must specify "()" as argument when calling it. *)
print_hello () ;;

(* Calling a function with insufficient number of arguments
   does not cause an error, it produces a new function. *)
let make_inc x y = x + y ;; (* make_inc is int -> int -> int *)

let make_inc = fun x -> fun x -> x + x ;;
let inc_2 = make_inc 2 ;;   (* inc_2 is int -> int *)
inc_2 3 ;; (* Evaluates to 5 *)

let make_inc = fun (x, y) -> x + y ;;

(* You can use multiple expressions in function body.
   The last expression becomes the return value. All other
   expressions must be of the "unit" type.
   This is useful when writing in imperative style, the simplest
   form of it is inserting a debug print. *)
let print_and_return x =
   print_endline (string_of_int x) ; print_endline (string_of_int x) ; x;;

(* Since OCaml is a functional language, it lacks "procedures".
   Every function must return something. So functions that
   do not really return anything and are called solely for their
   side effects, like print_endline, return value of "unit" type. *)


(* Definitions can be chained with "let ... in" construct.
   This is roughly the same to assigning values to multiple
   variables before using them in expressions in imperative
   languages. *)
let a = 10 in
   let b = 20 in
      a + b ;;

(* Anonymous functions use the following syntax: *)
let my_lambda = fun x -> x * x ;;

(*** Operators ***)

(* There is little distinction between operators and functions.
   Every operator can be called as a function. *)

(+) 3 4 ;; (* Same as 3 + 4 *)

(* There's a number of built-in operators. One unusual feature is
   that OCaml doesn't just refrain from any implicit conversions
   between integers and floats, it also uses different operators
   for floats. *)
12 + 3 ;; (* Integer addition. *)
12.0 +. 3.0 ;; (* Floating point addition. *)

12 / 3 ;; (* Integer division. *)
12.0 /. 3.0 ;; (* Floating point division. *)
5 mod 2 ;; (* Remainder. *)

(* Unary minus is a notable exception, it's polymorphic.
   However, it also has "pure" integer and float forms. *)
- 3 ;; (* Polymorphic, integer *)
- 4.5 ;; (* Polymorphic, float *)
~- 3 (* Integer only *)
~- 3.4 (* Type error *)
~-. 3.4 (* Float only *)

(* You can define your own operators or redefine existing ones.
   Unlike SML or Haskell, only selected symbols can be used
   for operator names and first symbol defines associativity
   and precedence rules. *)
let (+) a b = a - b ;; (* Surprise maintenance programmers. *)

(* More useful: a reciprocal operator for floats.
   Unary operators must start with "~". *)
let (~/) x = 1.0 /. x ;;
~/4.0 (* = 0.25 *)


(*** Built-in data structures ***)

(* Lists are enclosed in square brackets, items are separated by
   semicolons. *)
let my_list = [1; 2; 3] ;;

(* Tuples are (optionally) enclosed in parentheses, items are separated
   by commas. *)
let first_tuple = 3, 4, 4, 5 ;; (* Has type "int * int". *)
let second_tuple = (4, 5) ;;

(* Corollary: if you try to separate list items by commas, you get a list
   with a tuple inside, probably not what you want. *)
let bad_list = [1, 2] ;; (* Becomes [(1, 2)] *)

(* You can access individual list items with the List.nth function. *)
List.nth my_list 1 ;;

(* There are higher-order functions for lists such as map and filter. *)
List.map (fun x -> x * 2) [1; 2; 3] ;;
List.filter (fun x -> x mod 2 = 0) [1; 2; 3; 4] ;;

(* You can add an item to the beginning of a list with the "::" constructor
   often referred to as "cons". *)
1 :: [2; 3] ;; (* Gives [1; 2; 3] *)
[];;
"sfda" :: 1 :: [];;


(*** Strings and characters ***)

(* Use double quotes for string literals. *)
let my_str = "Hello world" ;;

(* Use single quotes for character literals. *)
let my_char = 'a' ;;

(* Single and double quotes are not interchangeable. *)
let bad_str = 'syntax error' ;; (* Syntax error. *)

(* This will give you a single character string, not a character. *)
let single_char_str = "w" ;;

(* Strings can be concatenated with the "^" operator. *)
let some_str = "hello" ^ "world" ;;

(* Strings are not arrays of characters.
   You can't mix characters and strings in expressions.
   You can convert a character to a string with "String.make 1 my_char".
   There are more convenient functions for this purpose in additional
   libraries such as Core.Std that may not be installed and/or loaded
   by default. *)
let ocaml = (String.make 1 'O') ^ "Caml" ;;

(* There is a printf function. *)
Printf.printf "%d %s" 99 "bottles of beer" ;;

(* Unformatted read and write functions are there too. *)
print_string "hello world\n" ;;
print_endline "hello world" ;;
let line = read_line () ;;


(*** User-defined data types ***)

(* You can define types with the "type some_type =" construct. Like in this
   useless type alias: *)
type par = int * int ;;

(* More interesting types include so called type constructors.
   Constructors must start with a capital letter. *)
type ml = OCaml | StandardML ;;
let lang = OCaml ;; (* Has type "ml". *)

(* Type constructors don't need to be empty. *)
type my_number = PlusInfinity | MinusInfinity | Real of float ;;
let r0 = Real (-3.4) ;; (* Has type "my_number". *)

(* Can be used to implement polymorphic arithmetics. *)
type number = Int of int | Float of float ;;

(* Point on a plane, essentially a type-constrained tuple *)
type point2d = Point of float * float ;;
let my_point = Point (2.0, 3.0) ;;

type point2 = float * float ;;

(*** Pattern matching ***)

(* Pattern matching is somewhat similar to switch statement in imperative
   languages, but offers a lot more expressive power.

   Even though it may look complicated, it really boils down to matching
   an argument against an exact value, a predicate, or a type constructor.
   The type system is what makes it so powerful. *)

(** Matching exact values.  **)

let is_zero x =
    match x with
    | 0 -> true
    | _ -> false  (* The "_" pattern means "anything else". *)
;;

(* Alternatively, you can use the "function" keyword. *)

(* function ~ fun x -> match x with *)
let is_one = function
| 1 -> true
| _ -> false
;;

(* Matching predicates, aka "guarded pattern matching". *)
let abs x =
    match x with
    | x when x < 0 -> -x
    | _ -> x
;;

abs 5 ;; (* 5 *)
abs (-5) (* 5 again *)

(** Matching type constructors **)

type animal = Dog of string | Cat of string ;;

let name x =
    match x with
    | Dog b -> b
    | Cat b -> b
;;

say (Cat "Fluffy") ;; (* "Fluffy says meow". *)

(** Traversing data structures with pattern matching **)

(* Recursive types can be traversed with pattern matching easily.
   Let's see how we can traverse a data structure of the built-in list type.
   Even though the built-in cons ("::") looks like an infix operator,
   it's actually a type constructor and can be matched like any other. *)
let rec sum_list l =
    match l with
    | [] -> 0
    | head :: tail -> head + (sum_list tail)
;;

sum_list [1; 2; 3] ;; (* Evaluates to 6 *)

(* Built-in syntax for cons obscures the structure a bit, so we'll make
   our own list for demonstration. *)

type int_list = Nil | Cons of int * int_list ;;
let rec sum_int_list l =
  match l with
      | Nil -> 0
      | Cons (head, tail) -> head + (sum_int_list tail)
;;

let t = Cons (1, Cons (2, Cons (3, Nil))) ;;
sum_int_list t ;;
```

# Tree
```ml
(* Navodila so na ucilnici *)
(* Notebook je na discordu *)
type avltree = Empty | Node of int * int * avltree * avltree

let showTreeHorizontally t = 
    let rec strign_of_avltree_level lvl = function 
        | Empty -> if lvl = 0 then "nil" else "   " 
        | Node (n, h, l, r) ->
              let make_space = String.map (fun _ -> ' ') in
              let sn = string_of_int n in
              let sl = strign_of_avltree_level lvl l in
              let sr = strign_of_avltree_level lvl r in
                  if h = lvl
                  then make_space sl ^ sn ^ make_space sr
                  else sl ^ make_space sn ^ sr
    in
    let rec print_levels lvl =
        if lvl >= 0
        then (print_string (string_of_int lvl ^ ": " ^ strign_of_avltree_level lvl t ^ "\n");
            print_levels (lvl-1))
        else ()
    in
    let height = function
        | Node (_, y, _, _) -> y
        | Empty -> 0
    in
    print_levels (height t) ; flush stdout


let t = Node (5, 3,
Node (3, 2,
    Node (1, 1, Empty, Empty),
    Node (4, 1, Empty, Empty)),
Node (8, 1, Empty, Empty))

let height t = match t with
| Empty -> 0
| Node (_, h, _, _) -> h

let leaf e = Node (e, 1, Empty, Empty)
let node (e, l, r) = Node (e, 1 + max (height l) (height r),l, r)

let t = node (5,
    node (3,
        leaf 1,
        leaf 4),
    leaf 8)

(* rešitev *)
let rec toList t = match t with
| Empty -> []
| Node (e, _, l, r) -> toList l @ e :: toList r
(* | Node (e, h, l, r) -> toList l @ [e] @ toList r *)

(* ena izmed neučinkovitih implementacij stikanja seznamov *)
let rec join_list xs ys = match xs with
    | [] -> ys
    | glava :: rep -> glava :: join_list rep ys

type order = Less | Equal | Greater

let cmp x y =
    match compare x y with
    | 0 -> Equal
    | r when r < 0 -> Less
    | _ -> Greater

let rec search x = function
| Empty -> false
| Node (y, _, l, r) ->
    (match cmp x y with
    | Less -> search x l
    | Equal -> true
    | Greater -> search x r)


(* počasna rešitev *)
let rec search_slow2 x = function
| Empty -> false
| Node (y, _, l, r) -> x = y || search_slow2 x l || search_slow2 x r

let search_slow e t = List.mem e (toList t)

let imbalance = function
| Empty -> 0
| Node (_, _, l, r) -> height l - height r

let rotateLeft = function
| Node (x, _, a, Node (y, _, b, c)) ->  node (y, node (x, a, b), c)
| t -> t


let rotateRight = function
| Node (y, _, Node (x, _, a, b), c) ->  node (x, a, node (y, b, c))
| t -> t

let balance t = match t with
| Empty -> Empty
| Node (x, _, l, r) ->
    (
    match imbalance t with
    | (-1 | 0 | 1) -> t
    | 2 ->
        begin match imbalance l with
        | (0 | 1) -> rotateRight t
        | -1 -> rotateRight (node (x, rotateLeft l, r))
        | _ -> failwith "Podrevesa niso AVL drevesa!"
        end
    | -2 ->
        begin match imbalance r with
        | (0 | -1) -> rotateLeft t
        | 1 -> rotateLeft (node (x, l, rotateRight r))
        | _ -> failwith "Podrevesa niso AVL drevesa!"
        end
    | _ -> failwith "Tega ne moremo poravaiti!"
    )
```