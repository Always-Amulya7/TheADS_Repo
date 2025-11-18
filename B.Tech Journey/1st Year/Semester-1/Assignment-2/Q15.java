import java.util.Scanner;
class Q15
{
	public static void main(String args[])
	{
		try (Scanner Sc = new Scanner(System.in)) 
		{
			System.out.print("Enter the radius of the hemisphere:");
			double r;
			r=Sc.nextDouble();
			double area=3*Math.PI*r*r;
			double volume=(2.0/3)*Math.PI*r*r*r;
			System.out.println("The surface area of the hemisphere is "+(float) area);
			System.out.println("The volume of the hemisphere is "+(float) volume);
		}
	}
}