//Write a java program that takes a double value t from the command line and prints the value of cos (5t) + sin (7t). Use Math.cos() and math.sin()

class Q4
{
public static void main(String args[])
{
double t;
t=Double.parseDouble(args[0]);
double a=Math.cos(5*t);
double b=Math.sin(7*t);
double sum=a+b;
System.out.println("The Sum Results in "+sum);
}
}
