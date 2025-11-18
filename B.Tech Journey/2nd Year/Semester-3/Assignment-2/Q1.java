//Write A Java Code To Find The Minimum - The Element With The Lowest Value And Then Reduce Each Element With The Minimum
//Value For Array Reduction.

import java.util.Scanner;
import java.util.Arrays;
public class Q1 {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        int Temp;
        int Count = 0;
        System.out.print("Enter The Size Of The Array : ");
        int Size=Sc.nextInt();
        int[] Arr = new int[Size];
        for (int i = 0; i < Arr.length; i++) {
            System.out.print("Element At Position At "+(i+1)+" : ");
            Arr[i] = Sc.nextInt();
        }
        System.out.println("The Array Is : "+Arrays.toString(Arr));
        for (int i = 0; i < Arr.length - 1; i++) {
            for (int j = 0; j < Arr.length - i - 1; j++) {
                if (Arr[j] > Arr[j + 1]) {
                    Temp = Arr[j];
                    Arr[j] = Arr[j + 1];
                    Arr[j + 1] = Temp;
                }
            }
        }
        System.out.println("Sorted Array Is : " + Arrays.toString(Arr));
        int Min = Arr[0];
        for (int i = 0; i < Arr.length; i++) {
            if (Arr[i] - Arr[0] != 0) {
                Count++;
            }
        }
        for (int i = 0; i < Arr.length; i++) {
            Arr[i] -= Min;
        }
        System.out.println("New Array Is : " + Arrays.toString(Arr));
        System.out.println("The Size Of The Array : "+Count);
    }

}