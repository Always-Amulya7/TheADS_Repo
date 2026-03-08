// Leetcode-07

import java.util.*;
import java.lang.Math;
class Q4{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter A Number: ");
        int Num=sc.nextInt();
        if (!(Num>Math.pow(-2, 31)&&Num<Math.pow(2,31)-1))
        System.out.println("Enter A Valid Number");
        int temp=(Num<0)?Num*-1:Num,rev=0;
        while(temp>0){
            rev=rev*10+temp%10;
            temp/=10;
        }
        int reversed=(Num<0)?rev*-1:rev;
        System.out.println("The 32-Bit Signed Reversed is: "+reversed);
        sc.close();
    }
}