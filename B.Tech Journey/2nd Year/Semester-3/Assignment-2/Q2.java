//write A Jave Program To Merge Two Array In Sorted Order.

import java.util.Scanner;
import java.util.Arrays;
public class Q2 {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        System.out.print("Enter The Size Of The Array-1 : ");
        int Size1=Sc.nextInt();
        int Arr1[] = new int[Size1];
        int temp;
        int temp1;
        int start = 0;
        for (int i = 0; i < Arr1.length; i++) {
            System.out.print("Element At Position At "+(i+1)+" : ");
            Arr1[i] = Sc.nextInt();
        }
        System.out.println("Array-1 : "+Arrays.toString(Arr1));
        
        System.out.print("Enter The Size Of The Array-2 : ");
        int Size2=Sc.nextInt();
        int Arr2[] = new int[Size2];
        for (int i = 0; i < Arr2.length; i++) {
            System.out.print("Element At Position At "+(i+1)+" : ");
            Arr2[i] = Sc.nextInt();
        }
        System.out.println("Array-2 : "+Arrays.toString(Arr2));
        for (int i = 0; i < Arr1.length - 1; i++) {
            for (int j = 0; j < Arr1.length - i - 1; j++) {
                if (Arr1[j] > Arr1[j + 1]) {
                    temp = Arr1[j];
                    Arr1[j] = Arr1[j + 1];
                    Arr1[j + 1] = temp;
                }
            }
        }
        System.out.println("Sorted Array For Array-1 Is : " + Arrays.toString(Arr1));
        for (int i = 0; i < Arr2.length - 1; i++) {
            for (int j = 0; j < Arr2.length - i - 1; j++) {
                if (Arr2[j] > Arr2[j + 1]) {
                    temp1 = Arr2[j];
                    Arr2[j] = Arr2[j + 1];
                    Arr2[j + 1] = temp1;
                }
            }
        }
        System.out.println("Sorted Array For Array-2 Is : " + Arrays.toString(Arr2));
        int Arr3[] = new int[Arr1.length + Arr2.length];
        int i = 0, j = 0, k = 0;
        while (i < Arr1.length && j < Arr2.length) {
            if (Arr1[i] <= Arr2[j]) {
                Arr3[k++] = Arr1[i++];
            } else
                Arr3[k++] = Arr2[j++];
        }
        while (i < Arr1.length)
            Arr3[k++] = Arr1[i++];
        while (j < Arr2.length)
            Arr3[k++] = Arr2[j++];
        System.out.println("Merged Array Is : " + Arrays.toString(Arr3));
    }

}