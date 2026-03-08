import java.util.*;
class Q1{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter The Size Of The Array: ");
        int Size=sc.nextInt();
        System.out.print("Enter The Array Elements: ");
        int arr[]=new int[Size];
        for (int i=0;i<Size;i++)
        arr[i]=(sc.nextInt()%2==0)?1:0;
        boolean Flag=true;
        for (int i=0;i<Size-1;i++){
            if (arr[i]==arr[i+1]){
                Flag=false;
                break;
            }
        }
        System.out.println("The Array Is Special? "+((Size<=1)?true:Flag));
        sc.close();
    }
}