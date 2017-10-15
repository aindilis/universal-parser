#!/bin/bash

./antlr4-tester.sh prolog.g4 'has(jack,apples).
has(ann,plums).
has(dan,money).
fruit(apples).
fruit(plums).
' program > output.txt
