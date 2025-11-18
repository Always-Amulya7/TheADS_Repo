//Write A Java Program To Input An Array And Then Find The Pair With Maximum And Minumum Difference Between Them.

import java.util.Scanner;
import java.util.Arrays;

public class Q7 {

    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        System.out.print("Enter The Size Of The Array : ");
        int Size = Sc.nextInt();
        int[] Arr = new int[Size];
        int Temp = 0;
        int Max = 0;
        int Min = 0;
        for (int i = 0; i < Arr.length; i++) {
            System.out.print("Element At Position At " + (i + 1) + " : ");
            Arr[i] = Sc.nextInt();
        }
        for (int i = 0; i < Arr.length - 1; i++) {
            for (int j = 0; j < Arr.length - i - 1; j++) {
                if (Arr[j] > Arr[j + 1]) {
                    Temp = Arr[j + 1];
                    Arr[j + 1] = Arr[j];
                    Arr[j] = Temp;
                }
            }
        }
        System.out.println("The Array Is : " + Arrays.toString(Arr));
        Max = Arr[Arr.length - 1] - Arr[0];
        System.out.println("The Max Difference Is :" + Max);
        System.out.println("The Max Element Pair Is : " + Arr[Arr.length - 1] + " And " + Arr[0] + "");
        int Difference[] = new int[Arr.length - 1];
        for (int i = 0, j = 1; i < Difference.length && j < Arr.length; i++, j++) {
            Difference[i] = Arr[j] - Arr[i];
        }
        int Temp1 = 0;
        for (int i = 0; i < Difference.length - 1; i++) {
            for (int j = 0; j < Difference.length - i - 1; j++) {
                if (Difference[j] > Difference[j + 1]) {
                    Temp1 = Difference[j];
                    Difference[j] = Difference[j + 1];
                    Difference[j + 1] = Temp1;
                }
            }
        }
        Min = Difference[0];
        System.out.println("The Min Difference Is :" + Min);
        for (int i = 0; i < Arr.length - 1; i++) {
            if (Arr[i + 1] - Arr[i] == Difference[0]) {
                System.out.println("The Min Elements Pair Are : " + Arr[i + 1] + " And  " + Arr[i]);
            }
        }
    }

}