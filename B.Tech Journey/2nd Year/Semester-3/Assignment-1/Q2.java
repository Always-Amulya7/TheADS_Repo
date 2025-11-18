//Find The Maximum And Minimum Number From A Given Set of Numbers.

import java.util.*;
class Q2
{
    public static void main(String[] args)
    {
        try (Scanner Sc = new Scanner(System.in))
        {
            System.out.print("Enter The Number Range: ");
            int Number = Sc.nextInt();
            int[] Num = new int[Number];
            for (int i = 0; i < Number; i++)
            {
                System.out.print("Enter The Number At " + (i + 1) + ": ");
                Num[i] = Sc.nextInt();
            }
            int Max = Num[0];
            int Min = Num[0];
            for (int element : Num)
            {
                if (element > Max) 
                {
                    Max = element;
                }
                if (element < Min) 
                {
                    Min = element;
                }
            }
            System.out.println("The Maximum Number Is: " + Max);
            System.out.println("The Minimum Number Is: " + Min);
        }
    }
}
