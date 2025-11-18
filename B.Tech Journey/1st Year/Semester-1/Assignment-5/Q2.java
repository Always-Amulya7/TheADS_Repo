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