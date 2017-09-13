#!/usr/bin/perl -w

use PerlLib::SwissArmyKnife;

my $c = read_file('bash-2.0.bnf').
  $c =~ s///;

my $iopairs = [[
	       '<digit> ::= 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
<sign> ::= + | -
<number> ::= [ <sign> ] <digit> { <digit> }',
	       '<digit>  ::= 0 ; 1 ; 2 ; 3 ; 4 ; 5 ; 6 ; 7 ; 8 ; 9 .
<sign>   ::= (+) ; (-)                             .
<number> ::= [ <sign> ], <digit>, { <digit> }      .',
	       ]];

# my $inductiveprogramming = Capability::InductiveProgramming::

# http://nautilus.cs.miyazaki-u.ac.jp/~skata/MagicHaskeller.html

# f "<digit> ::= 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
# <sign> ::= + | -
# <number> ::= [ <sign> ] <digit> { <digit> }" 2 == "<digit>  ::= 0 ; 1 ; 2 ; 3 ; 4 ; 5 ; 6 ; 7 ; 8 ; 9 .
# <sign>   ::= (+) ; (-)                             .
# <number> ::= [ <sign> ], <digit>, { <digit> }      ."

## or

# f "<digit> ::= 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9" == "<digit>  ::= 0 ; 1 ; 2 ; 3 ; 4 ; 5 ; 6 ; 7 ; 8 ; 9 ."
