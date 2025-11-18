import java.util.*;
class QX
{
    public static void main(String args[])
    {
        Scanner Sc=new Scanner(System.in);
        System.out.print("Enter The Numbered Fibonacci Place: ");
        int Number=Sc.nextInt();
        System.out.println("The Fibonacci Number Is: "+Fibonacci(Number));
    }
    static int Fibonacci(int Number)
    {
        if (Number<2)
        return Number;
        return Fibonacci(Number-1)+Fibonacci(Number-2);
    }
}