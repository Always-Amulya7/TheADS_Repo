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