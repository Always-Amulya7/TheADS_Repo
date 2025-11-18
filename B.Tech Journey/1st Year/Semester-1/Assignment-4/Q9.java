import java.util.Scanner;
class Q9
{
    public static void main(String[] args)
    {
        try(Scanner sc = new Scanner(System.in);)
        {
            String res;
            System.out.print("Enter an integer: ");
            int input = sc.nextInt();
            while (input > 0)
            {
            int digit = input % 10;
            if (digit != 0)
            {
                res=""+digit;
                input /= 10;
                System.out.print(res+"");
            }
            else
            {
                input=input/10;
            }
            }
        }
    }
}
