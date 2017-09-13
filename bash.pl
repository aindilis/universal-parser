:- consult('/var/lib/myfrdcsa/codebases/minor/universal-parser/bnf_parser.pl').
:- consult('/var/lib/myfrdcsa/codebases/minor/universal-parser/bash-2.0.bnf').

%% /var/lib/myfrdcsa/codebases/minor/universal-parser/bash-2.0.bnf
%% /var/lib/myfrdcsa/codebases/minor/universal-parser/languages/bnf/bash-2.0.bnf

process :-
	member(Command,
	       [
		%% 'ls',
		'ls -al'
		%% 'ls -al /var/lib/myfrdcsa'
	       ]),
	doParse(Command).

:- process.