import java.util.*;
class Q5
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter The Number To Get The Factorial : ");
            int Number=Sc.nextInt();
            int Factorial=1;
            for (int i=Number;i>=0;i--)
            {
                if (i==0)
                break;
                else
                Factorial*=i;
            }
            System.out.println("The Factorial Of The Number Is : "+Factorial);
        }
    }
}