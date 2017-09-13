#!/usr/bin/perl -w
# translate BNF grammar to sequence of RegEx'es
=pod 

=head1 BNF grammar to RegEx

=head2 Synopsis

Simple program to read in a BNF grammar and create
a regular expression for the root element.
This can be used to create a validator.

=head2 Usage

From the command line, type C<bnf2re input.bnf output.re>
where C<input.bnf> is a simple text file containing the BNF
grammar, while the second argument, C<output.re> will contain the
Perl regex. This latter argument is optional. If absent, output will
be written to a file with the same name as the input file but with an 
C<.re> extension.
  
=head2 Author

Frank Antonsen

=head

=cut

use strict;
use re 'eval';  # needed to handle recursive regexes

my ($bnffile, $output) = @ARGV;  # get arguments

die "Usage: bnf2re input.bnf [output.re]" if (@ARGV < 1);

$bnffile =~ /(.*)\.bnf/;
$output ||= $1.".re";  #default name for output file

open (BNF, "<$bnffile") or die "cannot open BNF file";
open (OUT, ">$output") or die "cannot open output file";

# sub to extract tags and do our own quotemeta
sub transform
{
        my $line = shift;

        $line =~ s/ //g;                 # remove spaces
        $line =~ s/<(.*?)>/\$$1/g;       # replace <txt> with $txt
        # hand-rolled quotemeta:
        $line =~ s{
	               (
	                 \+      # a plus sign
	                |
	                 \*      # a multiplication operator
	                |
	                 \?      # a question mark
	                | 
	                 \'      # a single quote
	                |
	                 \"      # a double quote
	                |
	                 /       # a slash (needed to avoid confusing qr/)
	                |
	                 \(      # opening bracket (to avoid confusing extended re's)
	                | 
	                 \)      # closing bracket (ditto)
	               )
	              }
	              {\\$1}gx;  # escape character globally

        # handle options - separated by |
        my @terms = split /(\|)/, $line;
        map {$_ = '(?:' . $_ . ')' unless $_ eq '|';} @terms; # wrap in (? .. )
        $line = join ' ',@terms;
}

my $re;    # regular expression being build
my $name;  # name of term being defined

# read BNF file
while(my $line =<BNF>)
{
        chomp $line;
        next if $line =~ /^#/;   # comment line so ignore

        # definition of new term?
        if($line =~ /<(.*?)>\s*::=\s*(.*)/)
        {
                if ($re)   # print previous
                {
                    $re =~ s/\$$name(?!=qr)/(??{\$$name})/g;   # handle recursion
 	                print OUT $re,"/;\n";
 	            }
                $re = '$' . $1 . "=qr/";   # redefine $re
                $name = $1;                # store name of term
                $re .= transform $2;
        }
        else
        {
                $re .= transform $line;
        }
}

print OUT "$re/;\n";   # last line
print "done\n";
close BNF or die "could not close BNF file";
close OUT or die "could not close output file";