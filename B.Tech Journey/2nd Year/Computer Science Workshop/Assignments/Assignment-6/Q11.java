import java.util.*;
class Q11{
    public static void main(String args[]){
        try(Scanner Sc=new Scanner(System.in)){
            System.out.print("Enter The Number For Even Check : ");
            int Number=Sc.nextInt();
            int Count=0;
            while(Number>0){
                int Digit=Number%10;
                if (Digit%2==0){
                    Count++;
                }
                Number=Number/10;
            }
            System.out.println("The Total Even Digits Are : "+Count);
        }
    }
}