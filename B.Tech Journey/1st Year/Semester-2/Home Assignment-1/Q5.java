import java.util.Scanner;
public class Q5
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter The Number Of Rows And Columns : ");
        int Rows = scanner.nextInt();
        int Columns = scanner.nextInt();
        int[][] matrix = new int[Rows][Columns];
        fillMatrixRandomly(matrix);
        System.out.println("Original Matrix:");
        printMatrix(matrix);
        int[] result = findRowAndColumnWithMostOnes(matrix);
        int rowWithMostOnes = result[0];
        int columnWithMostOnes = result[1];
        System.out.println("The First Row With The Most 1s: " + rowWithMostOnes);
        System.out.println("The First Column With The Most 1s: " + columnWithMostOnes);
        scanner.close();
    }
    public static void fillMatrixRandomly(int[][] matrix)
     {
        for (int i = 0; i < matrix.length; i++) 
        {
            for (int j = 0; j < matrix.length; j++) 
            {
                matrix[i][j] = Math.random() < 0.5 ? 0 : 1;
            }
        }
    }
    public static void printMatrix(int[][] matrix) 
    {
        for (int[] row : matrix) 
        {
            for (int element : row) 
            {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static int[] findRowAndColumnWithMostOnes(int[][] matrix) 
    {
        int rowWithMostOnes = 0;
        int maxOnesInRow = 0;
        int columnWithMostOnes = 0;
        int maxOnesInColumn = 0;
        for (int i = 0; i < matrix.length; i++)
        {
            int onesInRow = 0;
            int onesInColumn = 0;
            for (int j = 0; j < matrix[0].length; j++)
            {
                onesInRow += matrix[i][j];
                onesInColumn += matrix[j][i];
            }
            if (onesInRow > maxOnesInRow)
            {
                maxOnesInRow = onesInRow;
                rowWithMostOnes = i;
            }
            if (onesInColumn > maxOnesInColumn)
            {
                maxOnesInColumn = onesInColumn;
                columnWithMostOnes = i;
            }
        }
        int[] result = { rowWithMostOnes, columnWithMostOnes };
        return result;
    }
}