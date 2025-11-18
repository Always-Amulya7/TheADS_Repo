#!/bin/bash
read -p "Enter Principal: " p
read -p "Enter Rate of Interest (in %): " r
read -p "Enter Time (in years): " t
ci=$(echo "scale=4; $p * ( (1 + $r/100)^$t - 1 )" | bc -l)
echo "Compound Interest = $ci"
