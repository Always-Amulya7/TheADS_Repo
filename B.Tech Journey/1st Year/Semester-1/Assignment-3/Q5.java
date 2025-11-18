//Write a Java program that takes a year from user and print true if that year is a leap year otherwise print false.

//Here is a sample run:

//Input the year: 2016
//2016 is a leap year: true

//Input the year: 2008
//2008 is a leap0 year: false

//Input the year: 1900
//1900 is a leap year: false

import java.util.Scanner;
class Q5
{
	public static void main(String args[])
	{
		try (Scanner sc = new Scanner(System.in))
		{
			int year;
			System.out.print("Enter The Year:");
			year=sc.nextInt();
			if ((year%4==0 || year%100==0)||(year%400==0))
			{
				System.out.println(year+" is a leap year:"+true);
			}
			else
			{
				System.out.println(year+" is a leap year:"+false);
			}
		}
	}
}