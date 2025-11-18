#!/bin/bash
read -p "Enter a number: " num
orig=$num
rev=0
while [ $num -gt 0 ]; do
	d=$(( num % 10 ))
