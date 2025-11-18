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