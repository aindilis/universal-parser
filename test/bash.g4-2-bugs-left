/*
BSD License

Copyright (c) 2013, Tom Everett
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions
are met:

1. Redistributions of source code must retain the above copyright
   notice, this list of conditions and the following disclaimer.
2. Redistributions in binary form must reproduce the above copyright
   notice, this list of conditions and the following disclaimer in the
   documentation and/or other materials provided with the distribution.
3. Neither the name of Tom Everett nor the names of its contributors
   may be used to endorse or promote products derived from this software
   without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

A: Aa | b;
// becomes
A: bR;
R: (aA)?;

A: b | Aa
// becomes
A: bR;
R: (Aa)?;

A: AB | B
A: BR;
R: (BA)?;

*/

grammar bash;

WS
   : [ \t\r\n] -> skip
   ;

LETTER
    : [a-zA-Z];

DIGIT
    : [0-9];

number 
    : DIGIT | number DIGIT
    ;

word
    : LETTER | word LETTER | word '_'
    ;

word_list
    : word | word_list word
    ;

assignment_word
    : word '=' word
    ;

redirection
    : '>' word | '<' word |  number '>' word |  number '<' word |  '>>' word |  number '>>' word |  '<<' word |  number '<<' word |  '<&' number |  number '<&' number |  '>&' number |  number '>&' number |  '<&' word |  number '<&' word |  '>&' word |  number '>&' word |  '<<-' word |  number '<<-' word |  '>&' '-' |  number '>&' '-' |  '<&' '-' |  number '<&' '-' |  '&>' word |  number '<>' word |  '<>' word |  '>|' word |  number '>|' word
    ;

simple_command_element
    : (word | assignment_word | redirection)
    ;
    
redirection_list :
    redirection redirection_list_r
    ;

redirection_list_r :
    ( redirection redirection_list)?
    ;

simple_command
    : simple_command_element simple_command_r
    ;
    
simple_command_r
    : (simple_command_element simple_command)?
    ;

command
    : simple_command |  shell_command |  (shell_command redirection_list)
    ;
    
shell_command
    : for_command | case_command | ('while' compound_list 'do' compound_list 'done') | ('until' compound_list 'do' compound_list 'done') | select_command | if_command | subshell | group_command | function_def
    ;
    
for_command
    : (('for' word newline_list 'do' compound_list 'done') |  ('for' word newline_list '{' compound_list '}') |  ('for' word '|' newline_list 'do' compound_list 'done') |  ('for' word '|' newline_list '{' compound_list '}') |  ('for' word newline_list 'in' word_list list_terminator newline_list 'do' compound_list 'done') |  ('for' word newline_list 'in' word_list list_terminator newline_list '{' compound_list '}'))
    ;
    
select_command
    : ('select' word newline_list 'do' list 'done') |  ('select' word newline_list '{' list '}') |  ('select' word '|' newline_list 'do' list 'done') |  ('select' word '|' newline_list '{' list '}') |  ('select' word newline_list 'in' word_list list_terminator newline_list 'do' list 'done') |  ('select' word newline_list 'in' word_list list_terminator newline_list '{' list '}')
    ;
    
case_command
    : ('case' word newline_list 'in' newline_list 'esac') |  ('case' word newline_list 'in' case_clause_sequence newline_list 'esac') |  ('case' word newline_list 'in' case_clause 'esac')
    ;
    
function_def
    : (word '(' ')' newline_list group_command) |  ('function' word '(' ')' newline_list group_command) |  ('function' word newline_list group_command)
    ;
    
subshell
    : '(' compound_list ')'
    ;
    
if_command
    : ('if' compound_list 'then' compound_list 'fi') | ('if' compound_list 'then' compound_list 'else' compound_list 'fi') | ('if' compound_list 'then' compound_list elif_clause 'fi')
    ;
    
group_command
    : '{' list '}'
    ;
    
elif_clause
    : ('elif' compound_list 'then' compound_list) | ('elif' compound_list 'then' compound_list 'else' compound_list) | ('elif' compound_list 'then' compound_list elif_clause)
    ;
    
case_clause
    : pattern_list | (case_clause_sequence pattern_list)
    ;
    
pattern_list
    : (newline_list pattern ')' compound_list) |  (newline_list pattern ')' newline_list) |  (newline_list '(' pattern ')' compound_list) |  (newline_list '(' pattern ')' newline_list)
    ;
    
case_clause_sequence
    : pattern_list '||' | case_clause_sequence pattern_list '||'
    ;
    
/*
pattern
    : word |  (pattern '|' word)
    ;
*/

pattern
    : word pattern_r
    ;

pattern_r
    : ('|' word pattern)?
    ;

list
    : (newline_list list0)
    ;
    
compound_list
    : list | (newline_list list1)
    ;
    
list0
    : (list1 '\n' newline_list) |  (list1 '&' newline_list) |  (list1 '|' newline_list)
    ;

/*
A: Aa | b;
// becomes
A: bR;
R: (aA)?;

A: Aza | b;
*/    

list1
    : (list1 '&&' newline_list list1) | (list1 '||' newline_list list1) |  (list1 '&' newline_list list1) |  (list1 '|' newline_list list1) |  (list1 '\n' newline_list list1) |  (pipeline_command)
    ;
    
list_terminator
    : '\n' |  '|'
    ;
    
newline_list
    : '\n' | newline_list '\n'
    ;
    
/*
A: Aa | b;
// becomes
A: bR;
R: (aA)?;
*/

simple_list
    : simple_list1 | (simple_list1 '&') |  (simple_list1 '|')
    ;
    
simple_list1
    : (simple_list1 '&&' newline_list simple_list1) |  (simple_list1 '||' newline_list simple_list1) |  (simple_list1 '&' simple_list1) |  (simple_list1 '|' simple_list1) |  (pipeline_command)
    ;
    
pipeline_command
    : pipeline |  ('!' pipeline) |  (timespec pipeline) |  (timespec '!' pipeline) |  ('!' timespec pipeline)
    ;
    
pipeline
    : pipeline '|' (newline_list pipeline) | command
    ;
    
time_opt
    : '-p'
    ;
    
timespec
    : 'time' | 'time' time_opt
    ;
