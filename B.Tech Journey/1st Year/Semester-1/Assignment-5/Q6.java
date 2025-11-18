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