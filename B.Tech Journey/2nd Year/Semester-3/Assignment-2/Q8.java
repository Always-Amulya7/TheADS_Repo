//Write A Java Program To Find The Element Of The Array That Appears Maximum Number Of Times.

import java.util.Scanner;

public class Q8 {

    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        System.out.print("Enter The Size Of The Array : ");
        int Size = Sc.nextInt();
        int[] Arr=new int[Size];
        for (int i = 0; i < Arr.length; i++) {
            System.out.print("Element At Position At " + (i + 1) + " : ");
            Arr[i] = Sc.nextInt();
        }
        int Max = Arr[0];
        for (int i = 0; i < Arr.length; i++) {
            int count = 0;
            for (int j = 1; j < Arr.length; j++) {
                if (Arr[i] == Arr[j]) {
                    count++;
                }
            }
            if (count > Max) {
                Max = Arr[i];
            }
        }
        System.out.println("Element That Appears Maximum Number Of Times Is: " + Max);

    }

}