//Write A Java Program To Find The First Repeated Element In The Array.

import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        System.out.print("Enter The Size Of The Array: ");
        int size = Sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Element At Position " + (i + 1) + ": ");
            arr[i] = Sc.nextInt();
        }
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println("The First Repeated Element Is: " + arr[i]);
                    found = true;
                    break;
                }
            }
            if (found)
            break;
        }
        if (!found) {
            System.out.println("No Repeated Elements Found");
        }
    }
}
