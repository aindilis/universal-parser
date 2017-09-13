% <digit> ::= 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
% <sign> ::= + | -
% <number> ::= [ <sign> ] <digit> { <digit> }

:- consult('/var/lib/myfrdcsa/codebases/minor/free-life-planner/lib/util/util.pl').

:- [library(dcg/basics)].


:- op(1120, xfx, ::=).
:- op(11, fx, <), op(13, xf, >).


<digit>  ::= 0 ; 1 ; 2 ; 3 ; 4 ; 5 ; 6 ; 7 ; 8 ; 9 .
<sign>   ::= (+) ; (-)                             .
<number> ::= [ <sign> ], <digit>, { <digit> }      .

<expr>   ::= <factor>, { ((+) ; (-)), <factor> }   .
<factor> ::= <term>,   { ((*) ; (/)), <term> }     .
<term>   ::= '(', <expr>, ')' ; <number>           .


parse(Rule)    --> { Rule ::= Body }, parse(Body).
parse(Atom)    --> { atomic(Atom), atom_codes(Atom, Codes) }, Codes.

parse((X , Y)) --> parse(X), parse(Y).

parse((X ; _)) --> parse(X).
parse((_ ; Y ; Z)) --> parse(Y ; Z).
parse((_ ; Z)) --> { Z \= (_ ; _) }, parse(Z).

parse([X])     --> parse(X).
parse([_])     --> {}.

parse({X})     --> parse(X), parse({X}).
parse({_})     --> [].

%% :- string_codes("-5*(73+7)",Codes), findall(Res,phrase(parse(<expr>), Codes,Res),Z),member(Answer,Z),string_codes(Atom,Answer),see(Atom),fail.

:- listing.

% :- atom_codes('42 times', Codes), phrase(integer(X), Codes, Rest), see(X).

% %% :- string_codes("-5*(73+7)",Codes), phrase(parse(<expr>),Codes,Res2), see([Res1,Res2]).

% :- atom_codes('-5*(73+7)',Codes),phrase(parse(<factor>),Codes,Res0), atom_codes(Atom,Res0), see(Atom).

% %% X = 42
% %% Rest = [32, 116, 105, 109, 101, 115]