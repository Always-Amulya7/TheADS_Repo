#!/bin/bash
read -p "Enter two numbers: " a b
while [ $b -ne 0 ]; do
	t=$b
	b=$(( a % b ))
	a=$t
done
echo "GCD = $a"

