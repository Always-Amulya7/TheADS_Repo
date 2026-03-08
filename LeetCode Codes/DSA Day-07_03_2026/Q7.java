// Leetcode-2460

import java.util.*;
class Q7{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter The Size Of The Array: ");
        int arr[]=new int[sc.nextInt()];
        System.out.print("Enter The Array Elements: ");
        for (int i=0;i<arr.length;i++)
        arr[i]=sc.nextInt();
        for (int i=0;i<arr.length-1;i++){
            if (arr[i]==arr[i+1]){
                arr[i]*=2;
                arr[i+1]=0;
            }
        }
        for (int i=0;i<arr.length-1;i++){
            if (arr[i]!=0)
            arr[i]=arr[i];
            else{
                int temp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }
        }
        System.out.println("The New Array Is: "+Arrays.toString(arr));
        sc.close();
    }
}