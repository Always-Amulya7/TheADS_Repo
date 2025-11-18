#!/bin/bash
read -p "Enter a number: " n
if [ $n -gt 0 ]; then
	echo "Positive number"
elif [ $n -lt 0 ]; then
	echo "Negative number"
else
	echo "Zero"
fi

