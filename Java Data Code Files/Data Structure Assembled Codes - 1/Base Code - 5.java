//Amicable numbers are pair of numbers each of whose divisors are added to give the other number.
//Example: The smallest pair of amicable numbers is (220, 284).
//They are amicable because the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110, of which the sum is 284; and the proper 
//divisors of 284 are 1, 2, 4, 71 and 142, of which the sum is 220.
//Note: 1 is included as a divisor but the numbers are not included as their own divisors.
//Write a java program that tests whether a given pair of numbers is amicable numbers or not.
//Sample run 1:
//Enter first number: 220
//Enter second number: 284
//220 and 284 are amicable numbers.
//Sample run 2:
//Enter first number: 220
//Enter second number: 230
//220 and 230 are not amicable numbers.

import java.util.Scanner;
public class Q1
{
	public static void main(String[] args)
	{
		Scanner sc= new Scanner (System.in);
		System.out.println("Enter first number ");
		int x = sc.nextInt();
		System.out.println("Enter second number");
		int y = sc.nextInt();
		int sumx = 0,sumy= 0;
		for (int i = 1;i<=x/2;i++)
		{
			if (x%i==0)
			sumx+=i;
		}
		for (int j = 1;j<= y/2;j++)
		{ 
			if (y%j==0) 
			sumy+=j;
		}
			if(sumx==y&&sumy==x)
			{
				System.out.println("The numbers "+x+" & "+y+" are amicable");
			}
			else
			{
				System.out.println("The numbers "+x+" & "+y+" are not amicable");
			}
	}	
}

//WAP to check whether a number is twisted prime or not. Twisted prime is a number if the number and its reverse both are prime then it is called
//twisted prime.
//Sample run 1:
//Enter a number: 97
//97 is twisted prime.
//Sample run 2: 43
//43 is not a twisted prime

import java.util.Scanner;
public class Q2
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter a number ");
		int n = sc.nextInt();
		int n1 = n;
		int c1 = 0,c2 = 0;
		for (int i=2;i<=n/2;i++)
		{
			if(n%i==0)
			{
				c1=1;
				break;
			}
		}
		int rev = 0;
		while (n!=0)
		{
			int rem = n%10;
			rev = rev*10+rem;
			n=n/10;
		}
		for ( int j=2;j<=rev/2;j++)
		{
			if(rev%j==0) 
			{
				c2=1;
				break;
			}
			
		}
		if(c1==0&&c1==0)
		{
			System.out.println(n1+" is a Twisted prime");
		}
		else 
		{
			System.out.println(n1+" is not a Twisted prime");
		}
	}
}

//WAP to enter the first number and second number. Display the prime numbers between the first and second number.
//Sample run:
//Enter the first number: 4
//Enter the second number: 15
//Prime numbers between 4 and 15 are: 5 7 11 13

import java.util.*;
public class Q3
{
	public static void main(String[] args)
	{
		Scanner sc= new Scanner (System.in);
		System.out.println("Enter first number ");
		int x = sc.nextInt();
		System.out.println("Enter second number ");
		int y= sc.nextInt();
		for (int i=x;i<=y/2;i++) 
		{
			int c=0;
			for (int j=2;j<=i/2;j++) 
			{
				if(i%j==0)
				{
					c=1;
					break;
				}
			}
			if (c==0)
			{
				System.out.println(i);
			}
		}
	}
}

//WAP to calculate and display the factorial of all numbers between m and n (where m < n, m > 0, n > 0)
//Sample run:
//Enter the value of m: 2
//Enter the value of n: 5
//Factorial of 2 is: 2
//Factorial of 3 is: 6
//Factorial of 4 is: 24
//Factorial of 5 is: 120

import java.util.Scanner;
class Q4
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter The Value Of m:");
		int m=sc.nextInt();
		System.out.print("Enter The Value of n:");
		int n=sc.nextInt();
		long fact=1;
		for (int i=m;i<=n;i++)
		{
			fact=1;
			for (int j=1;j<=i;j++)
			{
				fact*=j;
			}
			System.out.println("Factorial Of "+i+" is: "+fact);		}
	}
}

//WAP to display the multiplication table from 2 to 15.
//Sample run:
//Multiplication table of 2
//2 × 1 = 2
//2 × 2 = 4
//:
//:
//2 × 10 = 20
//Multiplication table of 3
//3 × 1 = 3
//3 × 2 = 6
//:
//:
//3 × 10 = 30
//:
//:
//:
//Multiplication table of 15
//15 × 1 = 15
//15 × 2 = 30
//:
//:
//15 × 10 = 150

class Q5
{
	public static void main(String[] args)
	{
		for (int i=2;i<=15;i++)
		{
			System.out.println("Multiplication table of "+i);
			for (int j=1;j<=10;j++)
			{
				System.out.println(i+"x"+j+"="+i*j);
			}
			System.out.println();
		}
	}
}

//Write a program to print the following outputs using for loops:
//(a) 
//*
//* *
//* * *
//* * * *
//* * * * *
//(b) 
//1
//2 2
//3 3 3
//4 4 4 4
//5 5 5 5 5
//(c) 
//1
//2 3
//4 5 6
//7 8 9 10
//11 12 13 14 15
//(d) 
//1
//1 2
//1 2 3
//1 2 3 4
//1 2 3 4 5

public class Q6
{
	public static void main(String[] args)
	{
//		Q6(a)
		for ( int i= 1;i<=5;i++)
		{
			
			for(int j=1;j<=i;j++)
			{
				
				System.out.print("* ");
			}
			System.out.println();
		}	
//		Q6(b)
		for ( int i= 1;i<=5;i++)
		{
			
			for(int j=1;j<=i;j++)
			{
				
				System.out.print(i+" ");
			}
			System.out.println();
		}	
//		Q6(c)
		int k=1;
		for ( int i= 1;i<=5;i++)
		{
			
			for(int j=1;j<=i;j++)
			{
				
				System.out.print(k+" ");
				k++;
			}
			System.out.println();
		}
//		Q6(d)
		for ( int i= 1;i<=5;i++)
		{
			
			for(int j=1;j<=i;j++)
			{
				
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
}

//Write a program to print the following outputs using for loops:
//(a) 
//A
//A B
//A B C
//A B C D
//A B C D E
//(b) 
//$ $ $ $ $
//$ $ $ $
//$ $ $
//$ $
//$
//(c) 
//1
//2 2
//3 3 3
//4 4 4 4
//5 5 5 5 5

public class Q7
{
	public static void main(String[] args)
	{
//		Q7(a)
		for ( int i= 1;i<=5;i++)
		{char ch = 'A';
			
			for(int j=1;j<=i;j++)
			{
				
				System.out.print(ch+" " );
				ch++;
			}
			System.out.println();
		}
//		Q7(b)
		System.out.println();
		for ( int i= 5;i>=1;i--)
		{
			
			for(int j=i;j>=1;j--)
			{
				
				System.out.print("$ ");
			}
			System.out.println();
		}
		for (int i = 1; i<=5;i++)
		{
			for(int j =1;j<=5-i;j++)
			{
				System.out.print("  ");
			}
			for(int k=1;k<=i;k++)
			{
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}

//WAP to enter the value of n and display find the following sum of the series:
//1 + (1 + 2) + (1+ 2 +3) ..... + (1 + 2 + 3 + .... + n)

import java.util.Scanner;
public class Q8
{
	public static void main(String[] args)
	{
		Scanner sc= new Scanner (System.in);
		System.out.print("Enter The Range:");
		int n = sc.nextInt();
		int sum = 0,count=2;
		int i,j;
		for( i = 1; i <=n;i++)
		{
			if(i!=1)
			System.out.print("(");
			for( j = 1; j<=i;j++)
			{
				System.out.print(j);	
				if (j+1<=i)
				System.out.print("+");
				sum +=j;
				count++;
			}
			if (i<n && i!=1)
			System.out.print(")+");
			else if(i!=1)
			System.out.print(")");
			else
				System.out.print("+");
		}
		System.out.println();
		System.out.println("Sum = "+sum);
	}
}

//Write a program that will read the value of n from the user and calculate sum of the following series:
//1/1^2 + 1/2^2 + 1/3^2 + 1/4^^2+ ... + 1/𝑛^2.

import java.util.Scanner;
public class Q9
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc= new Scanner (System.in);
		System.out.print("Enter The Value Of n:");
		int n = sc.nextInt();
		int sum=0;
		for (int i = 1 ; i <= n ; i++)
		{
			int pow = 1/(int)Math.pow(i, i);
			sum+=pow;
		}
		System.out.print("Sum Of The Series Is:"+sum);
	}
}

//Given a=0, b=1 and c=1 are the first three numbers of some sequence. All other numbers in
//the sequence are generated from the sum of their three most recent predecessors. Write a java
//program to generate this sequence up to n terms where n > 3.

import java.util.Scanner;
class QX
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int a=0,b=1,c=1,n,term;
		System.out.print("Enter The Value Of n:");
		n=sc.nextInt();
		System.out.print("Desired Sequence Upto "+n);
		System.out.println();
		if (n==1)
		{
			System.out.print(0);
		}
		else if (n==2)
		{
			System.out.print("0 1");
		}
		else if (n==3)
		{
			System.out.print("0 1 1");
		}
		else
		{
			System.out.print("0 1 1 ");
			for (int i=4;i<=n;i++)
			{
				term=a+b+c;
				a=b;
				b=c;
				c=term;
				System.out.print(term+" ");
			}
		}
	}
}