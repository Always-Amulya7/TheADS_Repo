#!/bin/bash
read -p "Enter three numbers (space separated): " a b c
if [ $a -ge $b ] && [ $a -ge $c ]; then
	echo "$a is greatest"
elif [ $b -ge $a ] && [ $b -ge $c ]; then
	echo "$b is greatest"
else
	echo "$c is greatest"
fi
