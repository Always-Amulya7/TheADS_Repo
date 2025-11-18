import java.util.*;
class Q9
{
    public static void main(String args[])
    {
        Scanner Sc=new Scanner(System.in);
        System.out.print("Enter The Number: ");
        int Number=Sc.nextInt();
        System.out.println("The Reverse Number: "+Reversed(Number));
    }
    public static int Reversed(int Number)
	{
		if(Number<10)
        {
            return Number;
        }
		else
		{
			int Matrix=(int)(Math.log(Number)/Math.log(10));
			int Radix=Number%10;
			Radix=Radix*(int)Math.pow(10, Matrix);
			Number=Number/10;
			return Radix+Reversed(Number);
		}
    }
}