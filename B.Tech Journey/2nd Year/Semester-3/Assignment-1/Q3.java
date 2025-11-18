//Reverse The Array From A Pivot Point For The Array Made.

import java.util.*;
class Q3
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter The Number Range : ");
            int Number=Sc.nextInt();
            int[] Num=new int[Number];
            for (int i=0;i<Number;i++)
            {
                System.out.print("Enter The Number At " + (i + 1) + ": ");
                Num[i] = Sc.nextInt();
            }
            System.out.println("The Original Array : "+Arrays.toString(Num));
            int Temp[]=Num;
            int Numm;
            System.out.print("Enter The Times Of Reversal : ");
            int Pivot=Sc.nextInt();
            for (int j=0;j<Pivot;j++)
            {
                for (int i=0;i<Temp.length-1;i++)
                {
                    Numm=Temp[i];
                    Temp[i]=Temp[i+1];
                    Temp[i+1]=Numm;                
                }
            }
            int NewArr[]=Temp;
            System.out.println("The Rotated  Array : "+Arrays.toString(NewArr));
        }
    }
}