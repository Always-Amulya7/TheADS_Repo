// Leetcode-1752

import java.util.*;
class Q6{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter The Size Of The Array: ");
        int arr[]=new int[sc.nextInt()];
        System.out.print("Enter The Array Elements: ");
        for (int i=0;i<arr.length;i++)
        arr[i]=sc.nextInt();
        int count=0;
        // Rotated Array Formula
        for (int i=0;i<arr.length;i++){
            if (arr[i]>arr[(i+1)%arr.length]) {
                count++;
            }
        }
        System.out.println("The Total Number Of Counts: "+(count<=1));
        sc.close();
    }
}