#!/bin/bash
echo "Enter the marks: "
read mark
echo "Enter % in attendance: "
read attend
if [ $mark -ge 20 ] && [ $(echo " $attend >= 75" | bc -l) -ne 0 ]; then
	echo "Allowed for semester"
else
	echo "Not allowed"
fi
