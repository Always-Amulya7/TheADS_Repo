//Write a java program that takes two positive integers from command-line arguments and prints the result of first number raise to the power of second number.

class Q2
{
public static void main(String args[])
{
int a,b;
a=Integer.parseInt(args[0]);
b=Integer.parseInt(args[1]);
int res=(int)Math.pow(a,b);
System.out.println("The Result is "+res);
}
}
