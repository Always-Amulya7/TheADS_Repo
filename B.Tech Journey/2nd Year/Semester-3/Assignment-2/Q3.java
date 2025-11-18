//Write A Java Program Which Selects A Sub Array From The Inputed Array And Reverse It. By Doing This The Main Array Should 
//Get Sorted.

import java.util.Scanner;
import java.util.Arrays;

public class Q3 {

    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        System.out.print("Enter The Size Of The Array : ");
        int Size=Sc.nextInt();
        int[] Arr = new int[Size];
        for (int i = 0; i < Arr.length; i++) {
            System.out.print("Element At Position At "+(i+1)+" : ");
            Arr[i] = Sc.nextInt();
        }
        int[] Sub_Array = { Arr[2], Arr[3], Arr[4] };
        int Left_SubArray = 0;
        int Right_SubArray = Sub_Array.length - 1;
        int Temp;
        while (Left_SubArray < Right_SubArray) {
            Temp = Sub_Array[Left_SubArray];
            Sub_Array[Left_SubArray] = Sub_Array[Right_SubArray];
            Sub_Array[Right_SubArray] = Temp;
            Left_SubArray++;
            Right_SubArray--;
        }
        System.out.println("Reversed Subarray Is :" + Arrays.toString(Sub_Array));
        for (int i = 2, j = 0; j < Sub_Array.length; i++, j++) {
            Arr[i] = Sub_Array[j];
        }
        System.out.println("By Reversing The Sorted Array Is :" + Arrays.toString(Arr));
    }

}