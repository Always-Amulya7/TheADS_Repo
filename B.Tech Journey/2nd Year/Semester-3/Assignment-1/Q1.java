//Find The Sum Of N Numbers Asked.

import java.util.*;
class Q1
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter The Number: ");
            int Num=Sc.nextInt();
            int Sum=0;
            for (int i=0;i<Num;i++)
            {
                System.out.print("Enter The Value At "+(i+1)+" : ");
                int Number=Sc.nextInt();
                Sum+=Number;
            }
            System.out.println("The Sum Of The Numbers Alloted Is : "+Sum);
        }
    }
}