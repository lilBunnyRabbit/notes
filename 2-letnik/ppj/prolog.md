---
layout: note
title: Principi Programskih Jezikov - Prolog
---


> **Example code**
> ```prolog
> is_digesting(X,Y) :- just_ate(X,Y).
> is_digesting(X,Y) :-
>   just_ate(X,Z),
>   is_digesting(Z,Y).
>    
>  just_ate(mosquito,blood(john)).
>  just_ate(frog,mosquito).
>  just_ate(stork,frog).
>  ```

> **Example code 2**
>> ```prolog
>> is_digesting(X,Y) :- just_ate(X,Y).
>> is_digesting(X,Y) :-
>>  just_ate(X,Z),
>>  is_digesting(Z,Y).
>>    
>> just_ate(mosquito,blood(john)).
>> just_ate(frog,mosquito).
>> just_ate(stork,frog).
>> ```