import java.util.Scanner;
class Q4
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter The Dimensions Of The Square Matrix : ");
            int Dim1=sc.nextInt();
            int Dim2=sc.nextInt();
            int Arr1[][],Arr2[][];
            Arr1=new int[Dim1][Dim2];
            Arr2=new int[Dim1][Dim2];
            int[][] Sum=new int[Dim1][Dim2];
            for (int i=0;i<Dim1;i++)
            {
                for (int j=0;j<Dim2;j++)
                {
                    Sum[i][j]=0;
                }
            }
            System.out.println("Enter Input For Array I:");
            for (int i=0;i<Dim1;i++)
            {
                for (int j=0;j<Dim2;j++)
                {
                    System.out.print("Enter Element At Position "+(i+1)+""+(j+1)+" : ");
                    Arr1[i][j]=sc.nextInt();
                }
            }
            System.out.println("Enter Input For Array II:");
            for (int i=0;i<Dim1;i++)
            {
                for (int j=0;j<Dim2;j++)
                {
                    System.out.print("Enter Element At Position "+(i+1)+""+(j+1)+" : ");
                    Arr2[i][j]=sc.nextInt();
                }
            }
            System.out.println("2D Array I:");
            for (int i=0;i<Dim1;i++)
            {
                for (int j=0;j<Dim2;j++)
                {
                    System.out.print(Arr1[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println("2D Array II:");
            for (int i=0;i<Dim1;i++)
            {
                for (int j=0;j<Dim2;j++)
                {
                    System.out.print(Arr2[i][j]+" ");
                }
                System.out.println();
            }
            int[][] ResultMatrix = addMatrix(Arr1, Arr2);
            System.out.println("Resultant Matrix (A + B):");
            displayMatrix(ResultMatrix);
        }
    }
        public static int[][] addMatrix(int[][] a, int[][] b)
        {
            // Check if the matrices have the same dimensions
            if (a.length != b.length || a[0].length != b[0].length)
            {
                System.err.println("Enter Correct Dimensions");
            }
            int rows = a.length;
            int columns = a[0].length;
            int[][] Result = new int[rows][columns];
            // Perform matrix addition
            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < columns; j++)
                {
                    Result[i][j] = a[i][j] + b[i][j];
                }
            }
            return Result;
        }
        public static void displayMatrix(int[][] matrix)
        {
            for (int[] row : matrix)
            {
                for (int element : row)
                {
                    System.out.print(element + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
}