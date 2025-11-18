import java.util.*;
import java.lang.*;
class Q1
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter Your Lucky Number: ");
            int Number=Sc.nextInt();
            try
            {
                if (Number>0)
                System.out.println("Thala For A Reason: "+Number);
                else
                throw new NumberFormatException();
            }
            catch (NumberFormatException e)
            {
                System.out.println("Thik Se Input Kar");
            }
        }
    }
}