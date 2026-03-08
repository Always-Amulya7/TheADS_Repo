import java.util.*;
class Q2{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter The Number To Be Checked: ");
        int Num=sc.nextInt();
        int temp=Num,rev=0;
        while(temp>0){
            rev=rev*10+temp%10;
            temp/=10;
        }
        System.out.println("The Number Is Palindrome? "+(Num==rev));
        sc.close();
    }
}