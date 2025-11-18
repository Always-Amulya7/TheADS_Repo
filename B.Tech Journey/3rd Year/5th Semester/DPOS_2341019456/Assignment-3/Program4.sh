#!/bin/bash
even=0
odd=0
echo "Enter 10 numbers: "
for i in {1..10}; do
    read num
    if [ $((num % 2)) -eq 0 ]; then
        ((even++))
    else
        ((odd++))
    fi
done
echo "Even: $even"
echo "Odd: $odd"
