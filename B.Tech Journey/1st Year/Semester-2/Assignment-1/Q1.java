import java.util.*;
class Q1
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter A Number:");
            int Number=sc.nextInt();
            if (Number>2)
            System.out.print("The Input Is Accepted\n");
            else
            System.out.println("Enter The Correct Input");
            System.out.println("The Positive Integer Greater Than 2 From Command Line Argument Is "+Number);
            {
                int Count=0;
                do
                {
                    Number=Number/2;
                    Count++;
                }
                while(Number>2);
                System.out.println("The Number Of Times One Must Repeatedly Divide This Number By 2 Before Getting A Value Less Than 2 Is "+Count+".");
            }
        }
    }
}