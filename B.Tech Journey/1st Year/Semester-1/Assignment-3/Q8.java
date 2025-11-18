//Write a java program that takes the x – y coordinates of a
// point in the Cartesian plane and prints a message telling 
//either an axis on which the point lies or the quadrant in which it 
//is found.

//Here is the sample output:
//(-1.0, -2.5) is in quadrant III
//(0.0, 4.8) is on the y-axis

import java.util.Scanner;
class Q8
{
	public static void main(String args[])
	{
		try (Scanner sc = new Scanner(System.in))
		{
			System.out.println("Enter The Coordinates For X And Y:");
			double x,y;
			x=sc.nextDouble();
			y=sc.nextDouble();
			if (x>0 && y>0)
			System.out.println("("+x+","+y+") is in quadrant I");
			else if (x<0 && y>0)
			System.out.println("("+x+","+y+") is in quadrant II");
			else if (x<0 && y<0)
			System.out.println("("+x+","+y+") is in quadrant III");
			else if (x>0 && y<0)
			System.out.println("("+x+","+y+") is in quadrant IV");
			else if (x==0 && y==0)
			System.out.println("("+x+","+y+")"+" is at the origin");
			else if (x==0)
			System.out.println("("+x+","+y+") is at the Y-Axis");
			else
			System.out.println("("+x+","+y+") is at the X-Axis");
		}
	}
}