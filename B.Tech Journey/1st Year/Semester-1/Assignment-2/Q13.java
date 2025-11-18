import java.util.Scanner;
class Q13
{
	public static void main(String args[])
	{
		System.out.print("Enter basic salary: ");
		float salary;
		try (Scanner sc = new Scanner(System.in))
		{
			salary=sc.nextFloat();
			System.out.print("Enter His dearness allowance:");
			float da;
			da=sc.nextFloat();
			System.out.print("Enter His house rent allowance:");
			float hra;
			hra=sc.nextFloat();
			float gsal= ((float)salary) + ((float) 0.4*salary) + ((float) 0.2*salary);
			System.out.println("DA is "+da);
			System.out.println("HRA is "+hra);
			System.out.println("Gross Salary is "+(int)gsal);
		}
	}
}