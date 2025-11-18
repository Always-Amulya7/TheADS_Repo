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