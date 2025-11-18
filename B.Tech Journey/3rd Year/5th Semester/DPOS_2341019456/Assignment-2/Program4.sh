echo "Enter filename:"
read fname
if [ -e $fname ]
then
echo "File Exists"
else
echo "File does not exist"
fi
