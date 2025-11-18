import java.util.Scanner;
class Q11
{
	public static void main(String args[])
	{
		int Fah_value;;
		double Cel_value;
		try (Scanner inp = new Scanner(System.in)) 
		{
			System.out.print("Enter a degree in Fahrenheit: ");
			Fah_value=inp.nextInt();
		}
		Cel_value=(Fah_value-32)*(5.0/9);
		System.out.println(Fah_value+" Fahrenheit is "+Cel_value+" Celsius");
	}
}