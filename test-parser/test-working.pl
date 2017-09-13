%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% parseDomain.pl
%%   Simple parser of PDDL domain file into prolog syntax.
%% Author: Robert Sasak, Charles University in Prague
%%
%% Example: 
%% ?-parseDomain('blocks_world.pddl', O).
%%   O = domain(blocks,
%%        [strips, typing, 'action-costs'],
%%        [block],
%%        _G4108,
%%        [ on(block(?x), block(?y)),
%%	         ontable(block(?x)),
%%	         clear(block(?x)),
%%	         handempty,
%%	         holding(block(?x)) ],
%%        [number(f('total-cost', []))],
%%        _G4108,
%%        [ action('pick-up', [block(?x)],       %parameters
%%		      [clear(?x), ontable(?x), handempty], %preconditions
%%		      [holding(?x)],                       %positiv effects
%%          [ontable(?x), clear(?x), handempty], %negativ effects
%%          [increase('total-cost', 2)]),        %numeric effects
%%         ...],
%%       ...)
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% Support for reading file as a list.

:- ensure_loaded('/var/lib/myfrdcsa/codebases/minor/flp-pddl/prolog-pddl-parser/prolog-pddl-3-0-parser-20140825/readFileI.pl').

% parseDomain(+File, -Output).
% Parse PDDL domain File and return it rewritten prolog syntax.   
parseDomain(F, O):-
	view([domainFile,F]),
	parseDomain(F, O, _).

% parseDomain(+File, -Output, -RestOfFile)
% The same as above and also return rest of file. Can be useful when domain and problem are in one file.
parseDomain(File, Output, R) :-
		read_file(File, List),
		view([list,List]),
		domain(Output, List, R),
		view([domain,Output]).

lower_case_list(A,B) :-
	findall(Y,(member(X,A),lower_case(X,Y)),B).

capitalize(WordLC, WordUC) :-
	atom_chars(WordLC, [FirstChLow|LWordLC]),
	atom_chars(FirstLow, [FirstChLow]),
	upcase_atom(FirstLow, FirstUpp),
	atom_chars(FirstUpp, [FirstChUpp]),
	atom_chars(WordUC, [FirstChUpp|LWordLC]).

% Defining operator ?. It is a syntax sugar for marking variables: ?x
:-op(300, fy, ?).

% List of DCG rules describing structure of domain file in language PDDL.
% BNF description was obtain from http://www.cs.yale.edu/homes/dvm/papers/pddl-bnf.pdf
% This parser do not fully NOT support PDDL 3.0
% However you will find comment out lines ready for futher development.
require_def(R)                                  --> ['(',':','requirements'], oneOrMore(require_key, R), [')'].
require_key(strips)				--> [':strips'].
require_key(typing)				--> [':typing'].
require_key('negative-preconditions')		--> [':negative-preconditions'].
require_key('disjunctive-preconditions')	--> [':disjunctive-preconditions'].
require_key(equality)				--> [':equality'].
require_key('existential-preconditions')	--> [':existential-preconditions'].
require_key('universal-preconditions')		--> [':universal-preconditions'].
require_key('quantified-preconditions')	        --> [':quantified-preconditions'].
require_key('conditional-effects')		--> [':conditional-effects'].
require_key(fluents)				--> [':fluents'].
require_key(adl)				--> [':adl'].
require_key('durative-actions')			--> [':durative-actions'].
require_key('derived-predicates')		--> [':derived-predicates'].
require_key('timed-initial-literals')		--> [':timed-initial-literals'].
require_key(preferences)			--> [':preferences'].
%require_key(constraints)			--> [':constraints'].
% Universal requirements
require_key(R)		--> [':', R].

domain(D)                       --> typed_list(A,B), {D = p(A,B)}.


%% typed_list(W, G)		--> oneOrMore(W, N), ['-'], type(T), {G = are(N,T)}.
%% typed_list(W, [G,Ns])		--> oneOrMore(W, N), ['-'], type(T), !, typed_list(W, Ns), {T }.
%% typed_list(W, N)		--> zeroOrMore(W, N).

%% typed_list(L)                      --> oneOrMore(typed_list_element(E),L).
%% typed_list_element(E)              --> oneOrMore(nonDashToken,Items),['-'],token(T), {E = are(Items,T)}.
%% nonDashToken(T)                    --> token(T), {T \= '-'}.

%% typed_list(W, [F|Ls])           --> oneOrMore(W, L), ['-'], !, type(T), typed_list(W, Ls), {F =.. [are,L,T]}.	%:typing
%% typed_list(W, L)                --> zeroOrMore(W, L).

typed_list(T,W)                   --> oneOrMore(token,T).

%% typed_list(W, [F|Ls])           --> oneOrMore(W, L), ['-'], !, type(T), typed_list(W, Ls), {F =.. [are,L,T]}.	%:typing
%% typed_list(W, L)                --> true.





types_def(L)			--> ['(',':',types],      typed_list(name, L), [')'].
constants_def(L)		--> ['(',':',constants],  typed_list(name, L), [')'].
predicates_def(P)		--> ['(',':',predicates], oneOrMore(atomic_formula_skeleton, P), [')'].

atomic_formula_skeleton(F)
                                --> ['('], predicate(P), typed_list(variable, L), [')'], {F =.. [P|L]}.
                                %% --> ['('], predicate(P), typed_list(variable, L), [')'], {compound_name_arguments(F,P,L)}.

atomic_function_skeleton(f(S, L))
				--> ['('], function_symbol(S), typed_list(variable, L), [')'].

functions_def(F)		--> ['(',':',functions], zeroOrMore(function_def,F), [')'].	%:fluents

function_def(F)                 --> ['('],name(N),zeroOrMore(typed_arguments,A),[')'],{F = f(N,A)}.
typed_arguments(A)              --> oneOrMore(variable,Variables),['-'],name(T),{A = are(Variables,T)}.

%% functions_def(F)		--> ['(',':',functions], function_typed_list(atomic_function_skeleton, F), [')'].	%:fluents
%constraints(C)		        --> ['(',':',constraints], con_GD(C), [')']. %:constraints
structure_def(A)		--> action_def(A).
structure_def(D)		--> durative_action_def(D).	%:durativeactions
structure_def(D)		--> derived_def(D).		%:derivedpredicates

function_typed_list(W, [F|Ls])  --> oneOrMore(W, L), ['-'], !, function_type(T), function_typed_list(W, Ls), {F =.. [are,L,T]}.	%:typing
function_typed_list(W, L)	--> zeroOrMore(W, L).

function_type(number)		--> [number].
emptyOr(_)			--> ['(',')'].
emptyOr(W)			--> W.

% Actions definitons
action_def(action(S, L, Precon, Pos, Neg, Assign))
				--> ['(',':',action], action_symbol(S),
						[':',parameters,'('], typed_list(variable, L), [')'],
						action_def_body(Precon, Pos, Neg, Assign),
					[')'].

durative_action_def(durativeAction(S, L, V, P1, P2))
                                --> ['(',':','durative-action'], action_symbol(S),
					[':',parameters,'('], typed_list(variable, L), [')'],
					[':',duration,'('], ['='], variable(_), value(V), [')'],
					durative_action_def_body(P1, P2), [')'].

value(V)                        --> atomic_function(_,V).
value(V)                        --> f_exp(V).

action_symbol(N)		--> name(N).
action_def_body(P, Pos, Neg, Assign)
				--> (([':',precondition], emptyOr(pre_GD(P)))	; []),
				    (([':',effect],       emptyOr(effect(Pos, Neg, Assign)))	; []).

durative_action_def_body(P1, P2)
				--> (([':',condition], temp_GD(P1)) ; []),
				    (([':',effect], temp_GD(P2)) ; []).

temp_GD(P)			--> ['(',and], oneOrMore(temp_GD,P), [')'].
temp_GD('at start'(P))          --> ['('],[at,start],pre_GD(P),[')'].
temp_GD('at end'(P))            --> ['('],[at,end],pre_GD(P),[')'].
temp_GD('over all'(P))          --> ['('],[over,all],pre_GD(P),[')'].
temp_GD(P)			--> pre_GD(P).

pref_name(N)			--> name(N).

atomic_function(_, F)		--> ['('], function_symbol(S), zeroOrMore(term, T), [')'], {F =.. [S|T]}.

f_exp(N)			--> number(N).
f_exp(op(O, E1, E2))		--> ['('], binary_op(O), f_exp(E1), f_exp(E2), [')'].
f_exp('-'(E))			--> ['(','-'], f_exp(E), [')'].
f_exp(H)			--> f_head(H).

binary_op(O)			--> multi_op(O).
binary_op('-')			--> ['−'].
binary_op('/')			--> ['/'].
multi_op('*')			--> ['*'].
multi_op('+')			--> ['+'].
multi_op('-')			--> ['-'].

cond_effect(E)   		--> ['(',and], zeroOrMore(p_effect, E), [')'].				%:conditional-effects
cond_effect(E)			--> p_effect(E).						%:conditional-effects

%% float(F, Head, Tail) :-
%% 	float(F), !,
%% 	with_output_to(codes(Head, Tail), write(F)).
%% float(F) -->
%% 	number(F),
%% 	{ float(F) }.

effect(P, N, A)			--> ['(',and], c_effect(P, N, A), [')'].
effect(P, N, A)			--> c_effect(P, N, A).
%% c_effect(forall(E))		--> ['(',forall,'('], typed_list(variabl∗), effect(E), ')'.	%:conditional-effects
c_effect(when(P, E))		--> ['(',when], gd(P), cond_effect(E), [')'].			%:conditional-effects
c_effect(P, N, A)		--> p_effect(P, N, A).
p_effect([], [], [])		--> [].
p_effect(Ps, Ns, [F|As])        --> ['('], assign_op(O), [')'], p_effect(Ps, Ns, As), {F =.. [O]}.
%% p_effect(Ps, Ns, [F|As])        --> ['('], assign_op(O), f_head(H), f_exp(E), [')'], p_effect(Ps, Ns, As), {F =.. [O, H, E]}.
p_effect(Ps, [F|Ns], As)	--> ['(',not], atomic_formula(term,F), [')'], p_effect(Ps, Ns, As).
p_effect([F|Ps], Ns, As)	--> atomic_formula(term, F), p_effect(Ps, Ns, As).
p_effect(op(O, H, E))		--> ['('], assign_op(O), f_head(H), f_exp(E), [')'].	%:fluents , What is difference between rule 3 lines above???

derived_def(derived(S,G))       --> ['(', ':', 'derived'], atomic_formula_skeleton(S), gd(G), [')'].

% BNF description include operator <term>+ to mark zero or more replacements.
% This DCG extension to overcome this. 
oneOrMore(W, [R|Rs], A, C) :- F =.. [W, R, A, B], F, (
					oneOrMore(W, Rs, B, C) ;
					(Rs = [] , C = B) 
				).
% BNF operator <term>*
zeroOrMore(W, R)		--> oneOrMore(W, R).
zeroOrMore(_, [])		--> [].


% Name is everything that is not number, bracket or question mark.
% Those rules are not necessary, but rapidly speed up parsing process.
name(N)				--> [N], {integer(N), !, fail}.
name(N)				--> [N], {float(N), !, fail}.
name(N)				--> [N], {N=')', !, fail}.
name(N)				--> [N], {N='(', !, fail}.
%% name(N)				--> [N], {N=']', !, fail}.
%% name(N)				--> [N], {N='[', !, fail}.
name(N)				--> [N], {N='?', !, fail}.
name(N)				--> [N].

type(either(PT))		--> ['(',either], !, oneOrMore(primitive_type, PT), [')'].
type(PT)			--> primitive_type(PT).

primitive_type(N)		--> name(N).


literal(T, F)			--> atomic_formula(T, F).
literal(T, not(F))		--> ['(',not], atomic_formula(T, F), [')'].

atomic_formula(_, F)		--> ['('], predicate(P), zeroOrMore(term, T), [')'], {F =.. [P|T]}.		% cheating, maybe wrong

predicate(P)			--> name(P).

term(N)				--> name(N).
term(V)				--> variable(V).

variable('$VAR'(V))             --> ['?'], name(N), {capitalize(N,V)}.

number(N)			--> [N], {integer(N)}.
number(N)			--> mfloat(N).

gd(F)				--> atomic_formula(term, F).	%: this option is covered by gd(L)
gd(L)				--> literal(term, L).								%:negative-preconditions
gd(P)				--> ['(',and],  zeroOrMore(gd, P), [')'].
gd(or(P))			--> ['(',or],   zeroOrMore(gd ,P), [')'].					%:disjuctive-preconditions
gd(not(P))			--> ['(',not],  gd(P), [')'].							%:disjuctive-preconditions
gd(imply(P1, P2))		--> ['(',imply], gd(P1), gd(P2), [')'].						%:disjuctive-preconditions
gd(exists(L, P))		--> ['(',exists,'('], typed_list(variable, L), [')'], gd(P), [')'].		%:existential-preconditions
gd(forall(L, P))		--> ['(',forall,'('], typed_list(variable, L), [')'], gd(P), [')'].		%:universal-preconditions
gd(F)				--> f_comp(F).	%:fluents

f_head(F)			--> ['('], function_symbol(S), zeroOrMore(term, T), [')'], { F =.. [S|T] }.
f_head(S)			--> function_symbol(S).

function_symbol(S)		--> name(S).

mfloat(F)                       --> [N1,'.',N2], {number(N1), number(N2), atomic_list_concat([N1,'.',N2],'',Tmp),atom_number(Tmp,F)}.

pre_GD(P)			--> pref_GD(P).
pre_GD(P)                       --> oneOrMore(assignment,P).
pre_GD(P)			--> ['(',and], pre_GD(P), [')'].
pre_GD(forall(L, P))		--> ['(',forall,'('], typed_list(variable, L), [')'], pre_GD(P), [')'].		%:universal-preconditions

pref_GD(preference(N, P))	--> ['(',preference], (pref_name(N); []), gd(P), [')'].				%:preferences
pref_GD(P)			--> gd(P).

f_comp(compare(C, E1, E2))	--> ['('], binary_comp(C), f_exp(E1), f_exp(E2), [')'].

binary_comp('>')		--> ['>'].
binary_comp('<')		--> ['<'].
binary_comp('=')		--> ['='].
binary_comp('>=')		--> ['>','='].
binary_comp('<=')		--> ['<','='].

assignment(A)                   --> ['('], assign_op(P), f_head(H), f_exp(E), [')'], {A =.. [P,H,E]}.

assign_op(assign)		--> [assign].
assign_op(scale_up)		--> [scale_up].
assign_op(scale_down)		--> [scale_down].
assign_op(increase)		--> [increase].
assign_op(decrease)		--> [decrease].

token(T)                        --> name(T).