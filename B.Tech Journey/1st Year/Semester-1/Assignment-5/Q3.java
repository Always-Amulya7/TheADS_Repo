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