import java.util.*;
class Q1{
    public static void main(String args[]){
        try(Scanner Sc=new Scanner(System.in)){
            System.out.print("Enter The Number : ");
            int Number=Sc.nextInt();
            String Binary=ToBinary(Number);
            System.out.println("The Binary Represenation Is : "+Binary);
            int Count=0;
            for (int i=0;i<Binary.length();i++){
                if (Binary.charAt(i)=='1')
                Count++;
            }
            System.out.println("The Count Of 1 Is : "+Count);
        }
    }
    public static String ToBinary(int Number){
        return Integer.toBinaryString(Number);
    }
}