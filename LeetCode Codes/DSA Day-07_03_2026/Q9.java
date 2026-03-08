// Leetcode-27

import java.util.*;
class Q9 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The Size Of Array: ");
        int size = sc.nextInt();
        int arr[] = new int[size];
        System.out.print("Enter The Array Elements: ");
        for (int i = 0; i < arr.length; i++)
            arr[i] = sc.nextInt();
        System.out.print("Enter The Value To Be Removed: ");
        int val = sc.nextInt();
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != val) {
                arr[index] = arr[i];
                index++;
            }
        }
        System.out.print("The InPlace Removal Is: [");
        for (int i = 0; i < index; i++) {
            System.out.print(arr[i]);
            if (i < index - 1)
                System.out.print(", ");
        }
        System.out.print("]");
        sc.close();
    }
}