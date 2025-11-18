#!/bin/bash
echo "Enter first number: "
read num1
echo "Enter second number: "
read num2
echo "Addition: $(bc -l <<< "scale=2; $num1 + $num2")"
echo "Subtraction: $(bc -l <<< "scale=2; $num1 - $num2")"
echo "Multiplication: $(bc -l <<< "scale=2; $num1 * $num2")"
if [ $(echo "$num2 == 0" | bc -l) -eq 0 ]; then
    echo "Division: $(bc -l <<< "scale=2; $num1 / $num2")"
else
    echo "Cannot divide by zero"
fi
