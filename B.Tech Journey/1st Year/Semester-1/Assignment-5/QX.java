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