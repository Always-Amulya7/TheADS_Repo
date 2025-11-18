#!/bin/bash
read -p "Enter a number: " num
rev=0
temp=$num
while [ $temp -gt 0 ]; do
	d=$(( temp % 10 ))
	rev=$(( rev * 10 + d ))
	temp=$(( temp / 10 ))
done
echo "Reversed number = $rev"
