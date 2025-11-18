//Write A Java Program To Find The Number Of Duplicate Elements Occuring And Also Print The Duplicate Element.

import java.util.Scanner;

public class Q5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The Size Of The Array: ");
        int size = sc.nextInt();
        int[] Arr = new int[size];
        for (int i = 0; i < Arr.length; i++) {
            System.out.print("Element At Position " + (i + 1) + ": ");
            Arr[i] = sc.nextInt();
        }
        int Count_Duplicate = 0;
        boolean[] isCounted = new boolean[size];
        for (int i = 0; i < Arr.length; i++) {
            if (isCounted[i])
                continue;
            int Count = 0;
            for (int j = i + 1; j < Arr.length; j++) {
                if (Arr[i] == Arr[j]) {
                    Count++;
                    isCounted[j] = true;
                }
            }
            if (Count > 0) {
                System.out.println("Element " + Arr[i] + " Appears " + (Count + 1) + " Times.");
                Count_Duplicate++;
            }
        }
        System.out.println("There Are " + Count_Duplicate + " Duplicate Present");
    }
}
