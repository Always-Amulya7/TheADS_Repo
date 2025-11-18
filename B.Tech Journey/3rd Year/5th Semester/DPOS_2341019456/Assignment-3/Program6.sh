#!/bash/bin
echo "Enter a year: "
read year
if (( ($year % 4 == 0  && $year % 100 != 100 ) || ($year % 400 == 0) )); then 
	echo "It's a leap year"
else
	echo "It's no a leap year"
fi 
