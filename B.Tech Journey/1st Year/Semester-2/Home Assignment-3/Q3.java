import java.util.*;
public class Q3
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter The Decimal Number: ");
		int n=in.nextInt();
		int ans=dec2bin(n);
		System.out.println("The Converted Value Is: "+ans);
	}
	public static int dec2bin(int n)
	{
		if(n<=1)
			return n;
		else
			return dec2bin(n/2)*10+(n%2);
	}
}
