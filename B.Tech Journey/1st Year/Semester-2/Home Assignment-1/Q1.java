import java.util.Scanner;
class Q1
{
    public static void main(String args[])
    {
        System.out.print("Enter 3 Numbers: ");
        try(Scanner sc=new Scanner(System.in))
        {
            int A,B,C;
            {
                A=sc.nextInt();
                B=sc.nextInt();
                C=sc.nextInt();
            }
            {
                if ( (A+B==C) || (A==B-C) || (A*B==C) )
                System.out.print("They Are In Arithmetic Formula");
                else
                System.out.print("They Are Not In Arithmetic Formula");
            }
        }
    }
}