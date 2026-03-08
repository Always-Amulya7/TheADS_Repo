// Leetcode-03

import java.util.*;
import java.lang.Math;
class Q10{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter The String: ");
        String str=sc.nextLine();
        int Max=Integer.MIN_VALUE;
        for (int i=0;i<str.length();i++){
            for (int j=i+1;j<=str.length();j++){
                String substr=str.substring(i,j);
                if (Check(substr))
                Max=Math.max(substr.length(),Max);
            }
        }
        System.out.println("The Max Length Substring is: "+Max);
        sc.close();
    }
    public static boolean Check(String substr){
        for (int i=0;i<substr.length();i++){
            for (int j=i+1;j<substr.length();j++){
                if (substr.charAt(i)==substr.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }
}