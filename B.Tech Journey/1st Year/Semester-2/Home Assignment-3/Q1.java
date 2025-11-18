import java.util.*;
public class Q1
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter The First Value :");
		int m=in.nextInt();
		System.out.print("Enter The Second Value :");
		int n=in.nextInt();
		int ans=gcd(m,n);
		System.out.println("The GCD Is:"+ans);
	}
	public static int gcd(int m, int n)
	{
		if(Math.max(m, n)%Math.min(m, n)==0)
			return Math.min(m, n);
		else
			return gcd(Math.min(m,n),Math.max(m, n)%Math.min(m, n));
	}
}
