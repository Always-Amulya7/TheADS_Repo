//Write a java program that takes two int values from the command line as dividend and divisor and print the quotient and remainder.

class Q1
{
public static void main(String args[])
{
int a,b,q,r;
a=Integer.parseInt(args[0]);
b=Integer.parseInt(args[1]);
q=a/b;
r=a%b;
System.out.println("The Quotient is:"+q);
System.out.println("The Remainder is:"+r);
}
}
