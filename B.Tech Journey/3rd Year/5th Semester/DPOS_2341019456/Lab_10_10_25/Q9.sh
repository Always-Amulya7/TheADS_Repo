#!/bin/bash
read -p "Enter year: " y
if (( (y % 400 == 0) || (y % 4 == 0 && y % 100 !=0) )); then
	echo "$y is a Leap Year"
else
	echo "$y is not a Leap Year"
fi
