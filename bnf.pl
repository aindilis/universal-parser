%% :- ensure_loaded('/var/lib/myfrdcsa/codebases/minor/free-life-planner/projects/pddl/prolog-pddl-parser/prolog-pddl-3-0-parser-20140825/readFile.pl').
:- ensure_loaded('/var/lib/myfrdcsa/codebases/minor/agent-attempts/7/tmp/parseBNF.pl').

view(Item) :-
	write_term(Item,[quoted(true)]),nl,!.

%% :- read_file('/var/lib/myfrdcsas/versions/myfrdcsa-1.0/codebases/minor/agent-attempts/7/tmp/methodForAction.bnf',List),view(List).

%% :- read_file('/var/lib/myfrdcsas/versions/myfrdcsa-1.0/codebases/minor/agent-attempts/7/tmp/temp.bnf',List),view(List).

:- parseBNF('/var/lib/myfrdcsas/versions/myfrdcsa-1.0/codebases/minor/agent-attempts/7/tmp/temp.bnf', Output),view(Output).
