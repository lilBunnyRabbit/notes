---
layout: note
title: Izpiski predavanj
toc: true
quotes: true
---

# 1. Preliminaries
- a model of computation is a formal definition of the basic notations of algorithmic computation. It rigorusly defines what is meant by the notion of the algorithm, what is the environment required to execute the algorithm, how the algorithm executes in this environment

# 2. Finite automata and regular expressions
- A deterministic finite automation (DFA) is a 5-tuple ($Q, \Sigma, \delta, q_0, F$) where:
  - $Q$ is a finite set of states
  - $\Sigma$ is a finite input alphabet
  - $q_0 \in Q$ is the initial states
  - $F \subseteq Q$ is the set of final states and
  - $\delta$ is the transition function ($\delta : Q \times \Sigma \rightarrow Q$) 
- That is, $\delta (q, a)$ is a state (for each state $q$ and input symbol $a$). *Note: $\delta$ is the program of DFA. Every DFA has its own, specific $\delta$*
- A string $x$ is said to be accepted by a DFA $M = (Q, \Sigma, \delta, q_0, F)$ if $\delta(q_0, x) = p$ for some $p \in F$.
- The language accepted by a DFA $M$ is defined as the set $L(M) = x \in \Sigma^* \| \delta(q_0, x) \in F$
- The language $L'$ is said to be a regular set if $L'$ is accepted by some DFA.

## 2.1 Nondeterminism
- NFA decides wheter or not there exists a sequence of transitions leading from the initial to some final state for the given input $a_1a_2\ldots a_n$
- NFA is not a realistic model of computation: it is assumed that NFA can always guess right. That is, it is assumed that NFA has the magic capability of choosing, from any given set of options, the right option, i.e. the option that leads to a success (if such an option exists; otherwise NFA halts)
- NFA (and other nondeterministic models) can be used to find lower bounds on the time required to solve computational problems. The reasoning is as follows: If a problem $P$ requires time $T$ to be solved by a nondeterministioc model $M$, then solving this problem of any deterministic version $D$ of the model $M$ must require at least $T$ time (because $D$ lacks the ability of prediction).
- often its much easier to design a NFA for a given problem $P$. When we try to construct an equivalent deterministic version

### 2.1.1 Nondeterministic finite automation
- a nondeterministic finite automation (NFA) is a 5-touple ($Q, \Sigma, \delta, q_0, F$) where:
  - $Q$ is a finite set of states
  - $\Sigma$ is a finite input alphabet
  - $q_0 \in Q$ is the initial state
  - $F \subseteq Q$ is the set of final states
  - $\delta$ is the transition function ($\delta : Q \times \Sigma \rightarrow 2^Q$). That is $\delta(q,a)$ is te set of all states $p$, such that there is a transition labeled $a$ from $q$ to $p$
- A string $x$ is set to be accepted by a NFA $M = (Q, \Sigma, \delta, q_0, F)$ if $\delta(q_0, x)$ contains some $p \in F$
- The language accepted by a NFA $M = (Q, \Sigma, \delta, q_0, F)$ is the set $L(M) =\${$ x \in \Sigma^* \| \delta(q_0, x)\ contains\ a\ state\ in\ F $}
- Every DFA is also NFA
- Let $L$ be a set accepted by a NFA M. Then there exists a DFA $M'$ that accepts $L$.

### 2.1.2 Nondeterministic finite automation with $\varepsilon$ moves
- A NFA with $\varepsilon$-moves (NFA$_\varepsilon$) is a 5-touple ($Q, \Sigma, \delta, q_0, F$) where:
  - $Q$ is a finite set of states
  - $\Sigma$ is a finite input alphabet
  - $q_0 \in Q$ is the initial state
  - $F \subseteq Q$ is the set of final states
  - $\delta$ is the transition function ($\delta : Q \times \( \Sigma \cup \\{ \varepsilon \\}\) \rightarrow 2^Q$). That is, $\delta(q, a)$ is the set of all states $p$, such that there is a transition labeled $a$ from $q$ to $p$ where $a$ is either a symbol in $\Sigma$ or $\varepsilon$
- A string $x$ is said to be accepted by a NFA$_\varepsilon$ $M = (Q, \Sigma, \delta, q_0, F)$ if the set $L(M) = \\{ x \in \Sigma^* \| \hat{\delta}(q_0, x)\ contains\ a\ state\ in\ F \\}$
- Let $L$ be a set accepted by a NFA$_\varepsilon$ $M$. Then there exists a DFA $M'$ that accepts $L$.
- The set of all states reachable from the state $q$ with $\varepsilon$-transitions only: $\varepsilon$-Closure($q$).
- Let $\Sigma$ be an alphabet. Let $L_1$ and $L_2$ be sets of words from $\Sigma^*$. The concationation of $L_1$ and $L_2$, denoted $L_1L_2$ is the set $L_1L_2 = \\{ xy \| x \in L_1\ \land y \in L_2 \\}$. Words in $L_1L_2$ are formed by taking an $x$ in $L1$ and following it by a $y$ in $L_2$ for all possible $x,\ y$.

> <t-def>Kleene closure</t-def>  
> Let $L \subseteq \Sigma^*$.   
> Define $L^0 = \\{\varepsilon\\}$ and $L^i = LL^{i - 1}$ for $i \geq 1$.    
> The Kleene closure of $L$, denoted $L^*$, is the set $L^* = \bigcup^{\infty}_{i = 0} L^i$