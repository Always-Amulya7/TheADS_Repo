import java.util.*;
import java.lang.*;
class Q3
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter The Marks: ");
            int Marks=Sc.nextInt();
            try
            {
                if (Marks<=100)
                System.out.print("The Marks Entered Was: "+Marks);
                else
                throw new MarksExceptionError("Thik Se Input Karo Bey");
            }
            catch(MarksExceptionError e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}
class MarksExceptionError extends Exception
{
    MarksExceptionError(String Message)
    {
        super(Message);
    }
}