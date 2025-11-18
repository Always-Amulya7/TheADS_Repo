#!/bin/bash
read -p "Enter Prnicipal: " p
read -p "Enter Rate Of Interest (in %): " r
read -p "Enter Time (in years): " t
si=$(echo "scale=2; $p * $r * $t / 100" | bc)
echo "Simple Interest = $si" 
