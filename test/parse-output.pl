#!/usr/bin/perl -w

use KBS2::ImportExport;
use PerlLib::SwissArmyKnife;

system "./run.sh";
my $c = read_file('output.txt');
$c =~ s/.*?\[PARSE-TREE\]\s*//sg;
print "<$c>\n";

my $ie = KBS2::ImportExport->new();
my $res1 = $ie->Convert
  (
   InputType => 'KIF String',
   OutputType => 'Prolog',
   Input => $c,
  );
print Dumper($res1);

