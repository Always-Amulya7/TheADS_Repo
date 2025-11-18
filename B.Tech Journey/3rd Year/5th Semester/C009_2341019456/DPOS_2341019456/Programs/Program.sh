#!/bin/bash

# Function to check if a number is prime
is_prime() {
    local num=$1

    # 0 and 1 are not prime numbers
    if [ $num -lt 2 ]; then
        return 1
    fi

    # Loop to check divisibility by numbers up to the square root of the number
    for (( i = 2; i * i <= num; i++ )); do
        if [ $((num % i)) -eq 0 ]; then
            return 1
        fi
    done

    return 0
}

# Check if the script is executed with an argument
if [ $# -eq 0 ]; then
    echo "Usage: ./prime_check.sh <number>"
    exit 1
fi

# Check if the input is a non-negative integer
if ! [[ $1 =~ ^[0-9]+$ ]]; then
    echo "Error: Please enter a non-negative integer."
    exit 1
fi

# Call the function to check if the number is prime
is_prime $1
if [ $? -eq 0 ]; then
    echo "$1 is a prime number."
else
    echo "$1 is not a prime number."
fi   
