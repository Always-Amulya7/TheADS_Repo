#! /bin/bash
read -p "Enter a base: " base
read -p "Enter exp: " exp 
res=1
for (( i=0; i<exp; i++ )); do
	res=$((res*base))
done
echo "$Base raised to $exp = $res"
