//Write a java program to input a four-digit number from command line argument and find sum of the first and last digit of the number.

class Q3
{
public static void main(String[] args)
{
int fourDigitNumber = Integer.parseInt(args[0]);
if (fourDigitNumber < 1000 || fourDigitNumber > 9999)
{
System.out.println("Invalid input: The number must be a four-digit integer.");
}
int firstDigit = fourDigitNumber / 1000; // Extract the first digit
int lastDigit = fourDigitNumber % 10; // Extract the last digit
int sum = firstDigit + lastDigit;
System.out.println("The sum of the first and last digit of " + fourDigitNumber + " is: " + sum);
}
}