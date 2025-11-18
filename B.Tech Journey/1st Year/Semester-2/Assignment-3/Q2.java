import java.util.*;
import java.lang.*;
class Q2
{
    public static void main(String args[])
    {
        try (Scanner Sc = new Scanner(System.in))
        {
            int[] Arr = { 1, 2, 3, 4, 0 };
            int[] Arr1 = null;
            try
            {
                System.out.println(Arr[2] / 0);
            }
            catch (Exception e) //ArithmeticException
            {
                System.out.println("Arithmetic Exception");
            }
            try
            {
                System.out.println(Arr1[5] + "");
            }
            catch (Exception e) //NullPointerException
            {
                System.out.println("Null Pointer Exception");
            }
            try
            {
                System.out.println(Arr[5]);
            }
            catch (Exception e) //ArrayIndexOutOfBoundsException
            {
                System.out.println("Out Of Bounds Exception");
            }
        }
    }
}