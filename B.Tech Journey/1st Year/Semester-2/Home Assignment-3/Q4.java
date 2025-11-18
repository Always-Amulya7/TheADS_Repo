import java.util.Scanner;
public class Q4
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter The First Number: ");
		int a=in.nextInt();
		System.out.print("Enter The Second Number: ");
		int b=in.nextInt();
		int ans=mul(a,b);
		System.out.println("The Result Is: "+ans);
	}
	public static int mul(int a, int b)
	{
		if(b>0)
			return a+mul(a,b-1);
		else if(b<0)
			return mul(a,b+1)-a;
		else
			return 0;
	}
}
