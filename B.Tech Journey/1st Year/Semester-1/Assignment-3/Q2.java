//Alice visited SUM hospital to get treatment for her fever and illness. Doctor advised her to drink at least 5000 ml of water each day.
// Alice drank x ml of water today. Write a program that print the following message depending on the value of x.
//“Yes, Alice is following doctor’s advice”
//                 OR
//“No, Alice is not following doctor’s advice”

import java.util.Scanner;
class Q2
{
	public static void main(String args[])
	{
		try (Scanner sc = new Scanner(System.in))
		{
			int WaterLevel;
			System.out.print("Enter Level Of Water Consumed:");
			WaterLevel=sc.nextInt();
			if (WaterLevel>=5000)
				System.out.println("\"Yes, Alice is following doctor’s advice\"");
			else
				System.out.println("\"No, Alice is following doctor’s advice\"");
		}
	}
}