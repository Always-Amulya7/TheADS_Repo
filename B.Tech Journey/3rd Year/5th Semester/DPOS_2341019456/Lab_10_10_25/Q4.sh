#/bin/bash
read -p "Enter a number: " num
temp=$num
sum=0
digits=${#num}
while [ $temp -gt 0 ]; do
	rem=$(( temp % 10 ))
	sum=$(( sum + rem ** digits ))
	temp=$(( temp / 10 ))
done
if [ $sum -eq $num ]; then
	echo "$num is an Armstrong Number"
else
	echo "$num is not an Armstrong Number"
fi
