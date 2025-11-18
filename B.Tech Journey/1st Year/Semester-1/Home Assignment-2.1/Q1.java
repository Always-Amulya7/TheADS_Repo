//Write a java program to take three inputs from command line argument as principle, rate and time. Find Simple interest.

class Q1
{
public static void main(String[] args)
{
double principal = Double.parseDouble(args[0]);
double rate = Double.parseDouble(args[1]);
double time = Double.parseDouble(args[2]);
if (principal < 0 || rate < 0 || time < 0) 
System.err.println("Invalid input: Principal, rate, and time must be positive.");
double simpleInterest = (principal * rate * time) / 100;
System.out.println("The simple interest for principal " + principal + ", rate " + rate + ", and time " + time + " is: " + simpleInterest);
}
}
