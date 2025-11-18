import java.util.*;
import java.lang.*;
class Q5
{
    public static <E> void printArray(E[] inputArray)
    {
        System.out.print("The Array To be Printed Is: ");
        for (E Elements: inputArray)
        {
            System.out.print(Elements+" ");
        }
    }
    public static void main(String args[])
    {
        Scanner Sc=new Scanner(System.in);
        System.out.print("Enter The Size Of The Array: ");
        int Number=Sc.nextInt();
        Integer Arr1[]=new Integer[Number];
        for(int i=0; i<Number; i++)
		{
			System.out.print("Enter For Postion Number "+i+" :");
			Arr1[i]=Sc.nextInt();
		}
		Q5.<Integer>printArray(Arr1);
        System.err.println();
        Double Arr2[]=new Double[Number];
        for(int i=0; i<Number; i++)
		{
			System.out.print("Enter For Postion Number "+i+" :");
			Arr2[i]=Sc.nextDouble();
		}
		Q5.<Double>printArray(Arr2);
    }
}