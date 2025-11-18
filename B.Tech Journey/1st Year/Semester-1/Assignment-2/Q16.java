import java.util.Scanner;
class Q16
{
	public static void main(String args[])
	{
		try (Scanner sc = new Scanner(System.in)) 
		{
			System.out.print("Enter the number of seconds:");
			double t,g;
			g=32.174;
			t=sc.nextDouble();
			double d=(1.0/2)*g*Math.pow(t,2);
			System.out.println("Distance travelled:"+d);
		}
	}
}