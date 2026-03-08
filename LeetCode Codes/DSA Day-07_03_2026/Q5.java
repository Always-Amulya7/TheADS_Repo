// Leetcode-26

import java.util.*;
class Q5{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter The Size Of The Array: ");
        int arr[]=new int[sc.nextInt()];
        System.out.print("Enter The Array Elements: ");
        for (int i=0;i<arr.length;i++)
        arr[i]=sc.nextInt();
        Set<Integer> set=new LinkedHashSet<>();
        for (int num:arr)
        set.add(num);
        Integer[] result=set.toArray(new Integer[0]);
        System.out.print("The Removed Duplicate Array Is: \n"+Arrays.toString(result));
        System.out.println("The Length Is: "+set.size());
        sc.close();
    }
}