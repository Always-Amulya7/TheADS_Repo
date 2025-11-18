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