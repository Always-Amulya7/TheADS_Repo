#!/bin/bash
echo "Enter first number: "
read num1
echo "Enter second number: "
read num2
echo "Addition: $((num1 + num2))"
echo "Substraction $((num1 - num2))"
echo "Multiplication $((num1 * num2))"
if [ $num2 -ne 0 ]; then
	echo "Division: $((num1 / num2))"
else
	echo "Cannot divide by zero"
fi
