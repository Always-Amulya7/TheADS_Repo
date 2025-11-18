import java.util.Scanner;
class Q12
{
	public static void main(String args[])
	{
		try (Scanner input = new Scanner(System.in)) 
		{
			int kilometre;
			System.out.print("Enter the distance in km=");
			kilometre=input.nextInt();
			System.out.println(kilometre+" km is "+kilometre*1000+" meters");
			System.out.println(kilometre+" km is "+kilometre*3280.8399+" feet");
			System.out.println(kilometre+" km is "+kilometre*39370.0787+" inch");
			System.out.println(kilometre+" km is "+kilometre*100000+" centimetres");
		}
	}
}