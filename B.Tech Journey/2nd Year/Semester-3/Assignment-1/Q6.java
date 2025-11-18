import java.util.*;
class Q6
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter The Range : ");
            int Range=Sc.nextInt();
            int Sum=0;
            int First = 0;
            int Second = 1;
            System.out.println("Fibonacci series:");
            for (int i = 0; i < Range; i++)
            {
                System.out.print(First + " ");
                int Next = First + Second;
                First = Second;
                Second = Next;
            }
        }
    }
}