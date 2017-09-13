% Support for reading file as a list.

:- ensure_loaded('/var/lib/myfrdcsa/codebases/minor/free-life-planner/lib/util/util.pl').
:- ensure_loaded('/var/lib/myfrdcsa/codebases/minor/flp-pddl/prolog-pddl-parser/prolog-pddl-3-0-parser-20140825/readFileI.pl').

view(Item) :-
	write_term(Item,[quoted(true)]),nl,!.

% parseSubL(+File, -Output).
% Parse PDDL subL File and return it rewritten prolog syntax.   
parseSubL(F, O):-
	view([subLFile,F]),
	parseSubL(F, O, _).

% parseSubL(+File, -Output, -RestOfFile)
% The same as above and also return rest of file. Can be useful when subL and problem are in one file.

parseSubL(File, Output, R) :-
		read_file(File, List),
		view([list,List]),
		daySpecs(Output, List, R).

% Defining operator ?. It is a syntax sugar for marking variables: ?x
:-op(300, fy, ?).

%% Sunday	Closed
%% Monday	6:30AM–7:30PM
%% Tuesday	6:30AM–7:30PM
%% Wednesday	6:30AM–7:30PM
%% Thursday	6:30AM–7:30PM
%% Friday	6:30AM–5:30PM
%% Saturday	6:30AM–12PM


daySpecs(DaySpecs)             --> zeroOrMore(daySpec, DaySpecs),
subL(Commands)               --> zeroOrMore(subLCommand, Commands).

subLCommand(Command)         --> ['('],subLFunctionSymbol(F),zeroOrMore(subLArgument,Args),[')'],{Command =.. [F|Args]}.

subLAssertionStatement([A,C]) --> ['#','<','AS',':'],formula(A),[':'],cycMt(C),['>'].

formula(F)                   --> ['('],cycPredicate(P),zeroOrMore(argument,Args),[')'],{F =.. [P|Args]}.
formula(F)                   --> ['('],zeroOrMore(argument,Args),[')'],{F =.. ['_emptyPredicate'|Args]}.
%% formula(V)                 --> ['('],variable(V),[')'].

cycPredicate(P)              --> cycConstant(P).

subLArgument(A)              --> subLConstant(A).
subLArgument(A)              --> argument(A).

subLFunctionSymbol(A)        --> name(A).
subLConstant(A)              --> name(A).

argument(A)                  --> cycConstant(A).
argument(A)                  --> variable(A).
argument(A)                  --> formula(A).
argument(A)                  --> number(A).
argument(A)                  --> string(A).

string(A)                    --> ['"'],
	                         oneOrMore(anything,A), ['"'].
anything(A)                  --> [A]. %% , {not(A = '(' ; A = ')')}.

cycConstant(A)               --> cyc_constant_with_sigil(A).
cycConstant(A)               --> cyc_constant_without_sigil(A).

cyc_constant_with_sigil(A)       --> name(Name), {atom_concat('#$',A,Name)}.
cyc_constant_without_sigil(A)    --> name(A).

variable('$VAR'(V))          --> ['?','?'], name(N), {capitalize(N,V)}.
variable('$VAR'(V))          --> ['?'], name(N), {capitalize(N,V)}.

cycMt(Mt)                     --> cycConstant(Mt).

% BNF description include operator <term>+ to mark zero or more replacements.
% This DCG extension to overcome this. 
oneOrMore(W, [R|Rs], A, C) :- F =.. [W, R, A, B], F, (
					oneOrMore(W, Rs, B, C) ;
					(Rs = [] , C = B) 
				).
% BNF operator <term>*
zeroOrMore(W, R)		--> oneOrMore(W, R).
zeroOrMore(_, [])		--> [].

%% way incorrect:
%% zeroOrOne(W, [R|Rs], A, C) :- F =.. [W, R, A, B], F.
%% zeroOrOne(_, [])		--> [].

% Name is everything that is not number, bracket or question mark.
% Those rules are not necessary, but rapidly speed up parsing process.
name(N)				--> [N], {integer(N), !, fail}.
name(N)				--> [N], {N=')', !, fail}.
name(N)				--> [N], {N='(', !, fail}.
%% name(N)				--> [N], {N=']', !, fail}.
%% name(N)				--> [N], {N='[', !, fail}.
name(N)				--> [N], {N='?', !, fail}.
name(N)				--> [N].


number(N)			--> [N], {integer(N)}.
%% number(N)			--> mfloat(N).
%% mfloat(F)                       --> [N1,'.',N2], {number(N1), number(N2), atomic_list_concat([N1,'.',N2],'',Tmp),atom_number(Tmp,F)}.
