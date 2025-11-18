#!/bin/bash
read -p "Enter a number: " num
if [ $num -eq 0 ]; then
	echo "Number of digits = 1"
	exit 0
fi
count=0
while [ $num -gt 0 ];do
	num=$(( num / 10))
	count=$(( count + 1 ))
done
echo "Number of digits = $count"
