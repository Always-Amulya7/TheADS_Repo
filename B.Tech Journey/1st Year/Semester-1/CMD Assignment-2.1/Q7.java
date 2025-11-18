//Write a java program that takes three positive integers from command-line arguments and prints true if any one of them is less than or equal to the product of the other two and false otherwise.

class Q7
{
public static void main(String[ ] args)
{    
int num1 = Integer.parseInt(args[0]);
int num2 = Integer.parseInt(args[1]);
int num3 = Integer.parseInt(args[2]);
if (num1 <= num2 * num3 || num2 <= num1 * num3 || num3 <= num1 * num2)
{
System.out.println("True");
} 
else 
{
System.out.println("False");
}
}
}