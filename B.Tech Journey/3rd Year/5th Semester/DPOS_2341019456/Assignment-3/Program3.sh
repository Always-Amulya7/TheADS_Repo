#!/bin/bash
echo "Enter basic salary: "
read salary
da=$(echo "scale=2; $salary * 0.4" | bc -l)
hra=$(echo "scale=2; $salary * 0.3" | bc -l)
gross=$(echo "scale=2; $salary + $da + $hra" | bc -l)
echo "Gross Salary: $gross"
