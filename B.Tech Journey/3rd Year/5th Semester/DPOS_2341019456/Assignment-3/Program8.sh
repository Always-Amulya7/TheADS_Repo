#!/bash/bin
num1=1
num2=2
num3=3
if [ $num1 -ge $num2 ] && [ $num1 -ge $num3 ]; then
	echo "Largest Number: $num1"
elif [ $num2 -ge $num1 ] && [ $num2 -ge $num3 ]; then
	echo "Largest Number: $num2"
else
	echo "Largest Number: $num3"
fi
