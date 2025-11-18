import java.util.*;
public class Q7 
{
	public static void main(String args[])
	{
		Scanner Sc = new Scanner(System.in);
		System.out.print("Enter The Number To Determine The Factorial Of: ");
		int  Number=Sc.nextInt();
		long Fact=Factorial(Number);
		System.out.println("Factorial= "+Fact);
	}
	public static long Factorial(long Number)
	{
		if(Number<=1)
			return 1;
		else
			return Number*Factorial(Number-1);
	}
}