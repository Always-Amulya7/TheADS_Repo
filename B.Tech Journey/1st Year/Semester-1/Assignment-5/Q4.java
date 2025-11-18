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