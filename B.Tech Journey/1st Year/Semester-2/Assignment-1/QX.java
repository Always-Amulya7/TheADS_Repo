import java.util.Scanner;
class QX
{
    public static void main(String args[])
    {
        try (Scanner sc = new Scanner(System.in))
        {
            System.out.print("Enter The Dimension Of The Matrix: ");
            int Rows = sc.nextInt();
            int Columns = sc.nextInt();
            double[][] Array = new double[Rows][Columns];
            for (int i = 0; i < Rows; i++)
            {
                for (int j = 0; j < Columns; j++)
                {
                    System.out.print("Enter The Element At Position " + (i + 1) + "" + (j + 1) + " : ");
                    Array[i][j] = sc.nextDouble();
                }
            }
            double[] ColSum = new double[Columns];
            System.out.println("2D Array:");
            for (int i = 0; i < Rows; i++)
            {
                for (int j = 0; j < Columns; j++)
                {
                    System.out.print((int) Array[i][j] + " ");
                }
                System.out.println();
            }
            for (int i = 0; i < Rows; i++)
            {
                for (int j = 0; j < Columns; j++)
                {
                    ColSum[j]+=Array[i][j];
                }
            }
            for (int i = 0; i < Columns; i++)
            {
                System.out.println("The Sum Of The Column " + (i + 1) + " : " + ColSum[i]);
            }
            System.out.print("Enter Your Choice Column: ");
            int Choice=sc.nextInt();
            System.out.println("The Sum Of The Column " + Choice + " : " + ColSum[Choice-1]);
        }
    }
}