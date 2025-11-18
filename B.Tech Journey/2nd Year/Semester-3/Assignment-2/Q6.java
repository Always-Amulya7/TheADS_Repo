//Write A Java Program To Find The Missing Element In The Array Provided.

import java.util.*;

public class Q6 {

    public static void main(String[] args) {
        try (Scanner Sc = new Scanner(System.in)) {
            System.out.print("Enter The Size Of The Array : ");
            int Size = Sc.nextInt();
            int[] Arr = new int[Size];
            for (int i = 0; i < Arr.length; i++) {
                System.out.print("Element At Position At " + (i + 1) + " : ");
                Arr[i] = Sc.nextInt();
            }
            int Missing = 0;
            for (int i = 0; i < Arr.length; i++) {
                if (Arr[i + 1] - Arr[i] != 1) {
                    Missing = (Arr[i + 1] + Arr[i]) / 2;
                    break;
                } else
                    continue;
            }
            System.out.println("The Missing Element Is : " + Missing);
        }
    }
}