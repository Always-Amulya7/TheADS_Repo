import java.util.Scanner;
class Q14
{
	public static void main(String args[]) 
	{
		int a,b,c,e,d;
		try (Scanner sc = new Scanner(System.in))
		{
			System.out.print("Enter a number between 0 and 1000:");
			int no=sc.nextInt();
			a=no%10;
			b=no/10;
		}
		c=b%10;
		d=b/10;
		e=a+c+d;
		System.out.println("The Sum Of Digits Is "+e);
	}
}

//sum=number%10;
//number/=10;
//sum+=number%10;
//number/=10
//sum+=number%10;