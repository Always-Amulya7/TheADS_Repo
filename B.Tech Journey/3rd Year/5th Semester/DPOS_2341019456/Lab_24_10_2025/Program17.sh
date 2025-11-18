#!/bin/bash
read -p "Enter two numbers: " a b
if [ $a -eq 0 ] || [ $b -eq 0 ]; then
    echo "LCM = 0"
    exit 0
fi
gcd_func() {
    x=$1
    y=$2
    while [ $y -ne 0 ]; do
        t=$y
        y=$(( x % y ))
        x=$t
    done
    echo $x
}
g=$(gcd_func $a $b)
lcm=$(( (a / g) * b ))
echo "LCM = $lcm"
