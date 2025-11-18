//Write a java program to input a character from command line and display the ASCII value of the entered character.

class Q6
{
public static void main(String[] args) 
{
System.out.println("Please provide a character as a command line argument.");
char character = args[0].charAt(0); // Get the first character from the command line argument
int asciiValue = (int) character; // Convert the character to its ASCII value
System.out.println("The ASCII value of '" + character + "' is " + asciiValue);
}
}