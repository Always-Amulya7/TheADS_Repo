import java.util.*;
class Q10{
    public static void main(String args[]){
        try(Scanner Sc=new Scanner(System.in)){
            System.out.print("Enter Two Numbers : ");
            float Val1=Sc.nextFloat();
            float Val2=Sc.nextFloat();
            float Difference=Val2-Val1;
            if (Difference<1)
            System.out.println("The Difference Has Value Less Than Of e");
            else
            System.err.println("No The Value Is Of Type Difference > e");
        }
    }
}