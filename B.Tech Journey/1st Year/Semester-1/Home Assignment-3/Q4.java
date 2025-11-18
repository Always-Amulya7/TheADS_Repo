import java.util.Scanner;
class Q4
{
	public static void main(String args[])
	{
		try (Scanner sc = new Scanner(System.in))
		{
			int num;
			System.out.print("Enter An Integer:");
			num=sc.nextInt();
			if (num%5==0 && num%6==0)
			{
				System.out.println("Is "+num+" divisible by 5 and 6? True");
			}
			else
			{
				System.out.println("Is "+num+" divisible by 5 and 6? False");
			}
			if (num%5==0 || num%6==0)
			{
				System.out.println("Is "+num+" divisible by 5 or 6? True");
			}
			else
			{
				System.out.println("Is "+num+" divisible by 5 or 6? False");
			}
			if ((num%5==0||num%6==0) && (num%5!=0||num%6!=0))
			{
				System.out.println("Is "+num+" divisible by 5 or 6, but not both? True");
			}
			else
			{
				System.out.println("Is "+num+" divisible by 5 or 6, but not both? False");
			}
		}
	}
}