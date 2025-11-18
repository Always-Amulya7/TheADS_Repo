#!/bash/bin
echo "Enter a character: "
read char
if [[ $char =~ [a-z] ]]; then
	echo "Lower Character"
elif [[ $char =~ [A-Z] ]]; then
	echo "Upper Character"
elif [[ $char =~ [0-9] ]]; then
	echo "It's a Digit"
else
	echo "It's a whitespace or others"
fi
