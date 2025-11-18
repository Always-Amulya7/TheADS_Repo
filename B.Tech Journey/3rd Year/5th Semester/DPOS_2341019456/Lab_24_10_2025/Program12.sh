#!/bin/bash
read -p "Enter a number: " n
for ((i=1;i<=10;i++)); do
	echo "$n X $i = $(( n * i ))"
done
