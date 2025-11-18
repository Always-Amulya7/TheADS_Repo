import java.util.*;
class Q17{
    public static void main(String args[]){
        try(Scanner Sc=new Scanner(System.in)){
            System.out.print("Enter The Number To be Checked : ");
            int Number=Sc.nextInt();
            boolean Check=(Number%2==0)?true:false;
            System.out.println("The Number "+Number+" Is Even ? "+Check);
        }
    }
}