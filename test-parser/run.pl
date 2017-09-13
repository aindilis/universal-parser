view(Item) :-
	write_term(Item,[quoted(true)]),nl,!.
:- consult('/var/lib/myfrdcsa/codebases/minor/universal-parser/test-parser/test.pl').
:- parseDomain('/var/lib/myfrdcsa/codebases/minor/universal-parser/test-parser/item.pddl', T),
	view([t,T]).

