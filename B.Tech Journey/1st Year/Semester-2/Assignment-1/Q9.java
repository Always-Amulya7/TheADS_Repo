import java.util.Scanner;
class Q9
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("The Number Of Rows Of The 2D Array: ");
            int Row=sc.nextInt();
            System.out.print("The Number Of Columns Of The 2D Array: ");
            int Columns=sc.nextInt();
            double Array[][];
            Array=new double[Row][Columns];
            for (int i=0;i<Row;i++)
            {
                for (int j=0;j<Columns;j++)
                {
                    System.out.print("Enter The Element At Position "+(i+1)+""+(j+1)+" : ");
                    Array[i][j]=sc.nextDouble();
                }
            }
            print2DArray(Array);
            System.out.print("The Sum Of The Diagonal Is: "+sumMajorDiagonal(Array));
        }
    }
    public static double sumMajorDiagonal(double[][] m)
    {
        double Sum=0;
        for (int i=0;i<m.length;i++)
        {
            Sum+=m[i][i];
        }
        return Sum;
    }
    public static void print2DArray(double[][] array)
    {
        System.out.println("2D Array:");
        for (int i = 0; i < array.length; i++) 
        {
            for (int j = 0; j < array.length; j++)
            {
                System.out.print((int)array[i][j] + " ");
            }
            System.out.println();
        }
    }
}