#!/bash/bin
echo "Enter a day: "
read day
case $day in
	Wednesday|Friday|Thursday)
		echo "DOS Class time: Morning class for $day"
		;;
	Monday|Tuesday)
		echo "No class on $day"
		;;
	Sunday)
		echo "Holiday"
		;;
	Saturday)
		echo "class on $day"
		;;
	*)
	echo "Invalid day entered"
	;;
esac
