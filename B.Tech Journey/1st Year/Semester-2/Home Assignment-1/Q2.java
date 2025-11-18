import java.util.Scanner;
class Q2
{
    public static void main(String args[])
    {
        try (Scanner sc = new Scanner(System.in)) 
        {
            System.out.print("Enter The Number Of Lines: ");
            int Number = sc.nextInt();

            // Consume the newline character
            sc.nextLine();

            String[] Store = new String[Number];
            for (int i = 0; i < Store.length; i++)
            {
                System.out.print("Enter The Line " + (i + 1) + " : ");
                Store[i] = sc.nextLine();
            }
            System.out.println();
            for (int i = Number - 1; i >= 0; i--)
            {
                System.out.println((Number) + ". " + Store[i]);
                Number--;
            }
        }
    }
}
