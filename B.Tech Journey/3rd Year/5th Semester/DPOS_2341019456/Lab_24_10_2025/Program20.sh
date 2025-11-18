#!/bin/bash
read -p "Enter n: " n
sum=0
for ((i=1; i<=n; i++)); do
	echo -n "$i "
	sum=$(( sum + i ))
done
echo ""
echo "Sum = $sum"

