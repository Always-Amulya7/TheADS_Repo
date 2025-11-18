import java.lang.reflect.Array;
import java.util.*;
class Q3{
    public static void main(String args[]){
        try(Scanner Sc=new Scanner(System.in)){
            System.out.print("Enter The Number : ");
            int Num=Sc.nextInt();
            int Count=0,Temp=Num;
            while(Num>0){
                Num=Num/10;
                Count++;
            }
            System.out.println("The Count Is : "+Count);
            int[] Arr=new int[Count];
            for (int i=0;i<Count;i++){
                Arr[i]=Temp%10;
                Temp=Temp/10;
            }
            int[] NumArr=new int[Count];
            for (int i=0;i<Count;i++){
                NumArr[i]=Arr[Count-1-i];
            }
            System.err.println("The Number Array Is : "+Arrays.toString(NumArr));
            System.out.print("Enter The Bit For Operation : ");
            int Bit1=Sc.nextInt();
            System.out.print("Enter The Bit To Swap With : ");
            int Bit2=Sc.nextInt();
            int Store=0;
            Store=NumArr[Bit1];
            NumArr[Bit1]=NumArr[Bit2];
            NumArr[Bit2]=Store;
            System.out.println("The New Array After Swapping : "+Arrays.toString(NumArr));
        }
    }
}