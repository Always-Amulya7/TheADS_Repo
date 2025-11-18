//Write a java program that takes three int values from the command line and prints them in ascending order. Use Math.min() and Math.max().

class Q5 
{
public static void main(String[] args) 
{
int num1 = Integer.parseInt(args[0]);
int num2 = Integer.parseInt(args[1]);
int num3 = Integer.parseInt(args[2]);
int min = Math.min(Math.min(num1, num2), num3);
int max = Math.max(Math.max(num1, num2), num3);
int middle = num1 + num2 + num3 - min - max;
System.out.println("The numbers in ascending order are: " + min + ", " + middle + ", " + max);
}
}
