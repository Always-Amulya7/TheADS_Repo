#!/bin/bash
read -p "Enter number of terms: " n
a=0
b=1
count=0
while [ $count -lt $n ]; do
	echo -n "$a "
	fn=$(( a + b ))
	a=$b
	b=$fn
	count=$(( count + 1 ))
done
echo ""
