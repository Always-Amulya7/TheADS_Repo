// Leetcode-01

import java.util.*;
class Q3{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter The Size Of The Array: ");
        int Size=sc.nextInt();
        System.out.print("Enter The Array Elements: ");
        int arr[]=new int[Size];
        for (int i=0;i<Size;i++)
        arr[i]=sc.nextInt();
        System.out.print("Enter The Target Value: ");
        int target=sc.nextInt();
        ArrayList<Integer> lst=new ArrayList<>();
        for (int i=0;i<Size;i++){
            for (int j=i+1;j<Size;j++){
                if (arr[i]+arr[j]==target){
                    lst.add(i);
                    lst.add(j);
                    break;
                }
            }
        }
        System.out.println("The Positions are: "+lst);
        sc.close();
    }
}