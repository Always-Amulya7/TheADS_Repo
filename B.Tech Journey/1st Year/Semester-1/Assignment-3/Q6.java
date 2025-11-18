//Write a java program to calculate the monthly electricity bill. The tariff is given as follows:
//Price per unit          Unit range
//Rs. 3/-               First 50 units
//Rs. 4.80/-            50-200 units
//Rs. 5.80/-            200-400 units
//Rs. 6.20/-            Above 400 units

import java.util.Scanner;
class Q6
{
	public static void main(String args[])
	{
		try(Scanner sc = new Scanner (System.in))
		{
			System.out.print("Enter the unit of electricity used:");
		double unit = sc.nextDouble();
		if (unit <= 50) 
		{
			System.out.print("Amount:"+(unit*3.0));
		} 
		else if (unit <=200)
		{
			System.out.print("Amount:"+((50*3.0)+(unit-50)*4.8));
		} 
		else if (unit <=400)
		{
			System.out.print("Amount:"+((200*4.8)+(unit-200)*5.8)); 
		}
		else if (unit>=401)
		{
			System.out.print("Amount:"+((400*5.8)+(unit-400)*6.2));
		}
		}
		
	}
}