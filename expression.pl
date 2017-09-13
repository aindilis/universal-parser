:- consult('/var/lib/myfrdcsa/codebases/minor/universal-parser/bnf_parser.pl').

<digit>  ::= 0 ; 1 ; 2 ; 3 ; 4 ; 5 ; 6 ; 7 ; 8 ; 9 .
<sign>   ::= (+) ; (-)                             .
<number> ::= [ <sign> ], <digit>, { <digit> }      .

<expr>   ::= <factor>, { ((+) ; (-)), <factor> }   .
<factor> ::= <term>,   { ((*) ; (/)), <term> }     .
<term>   ::= '(', <expr>, ')' ; <number>           .

:- doParse('-5*(73+7)').