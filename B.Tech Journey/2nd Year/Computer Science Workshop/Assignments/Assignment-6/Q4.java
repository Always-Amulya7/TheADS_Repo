import java.util.*;
class Q4{
    public static void main(String args[]){
        try(Scanner Sc=new Scanner(System.in)){
            System.out.print("Enter The 64 Bit Number : ");
            long Number=Sc.nextLong();
            String Value=Long.toString(Number);
            System.out.println("The Binary Entered : "+Value);
            char[] Array=new char[Value.length()];
            for (int i=0;i<Array.length;i++){
                Array[i]=Value.charAt(i);
                if (Array[i]=='1'){
                    Array[i]='0';
                }
                else{
                    Array[i]='1';
                }
            }
            System.out.print("The New 64-Bit Number Is : ");
            for (char Element : Array){
                System.out.print(Element);
            }
        }
    }
}