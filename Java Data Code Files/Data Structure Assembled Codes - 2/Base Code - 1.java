//Write a Java program that can take a positive integer greater than 2 as input and write out the number of times one must repeatedly divide this number by 2 before 
//getting a value less than 2.
//Sample Run:
//The positive integer greater than 2 from command line argument is 67.
//The number of times one must repeatedly divide this number by 2 before getting a value less than 2 is 5.

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

//The body mass index (BMI) is commonly used by health and nutrition professionals to estimate human body fat in populations. It is computed by taking the individual's 
//weight (mass) in kilograms and dividing it by the square of their height in meters. i.e.
//Metric: BMI = 𝑾𝒆𝒊𝒈𝒉𝒕 (𝒌𝒈)/(𝑯𝒆𝒊𝒈𝒉𝒕)𝟐 (𝒎𝟐)
//Write a java program by using conditional statement to show the category for a given BMI.
//Category           BMI
//Less than 18.5    Underweight
//18.5 to 24.9      Normal Weight
//25.0 to 29.9      Overweight
//30.0 or more      Obese

//ample Run-1:
//Enter person Weight in kg: 68
//Enter height of person in meter: 2
//The person is Underweight.
//Sample Run-2:
//Enter person Weight in kg: 96
//Enter height of person in meter: 1.4
//The person is Obese.

import java.util.Scanner;
class Q2
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter Person Weight In Kg: ");
            float Weight=sc.nextFloat();
            System.out.print("Enter Height Of Person In Meter: ");
            float Height=sc.nextFloat();
            float BMI=Weight/(Height*Height);
            {
                if (BMI<18.5)
                System.out.println("The Person Is Underweight");
                else if (BMI>=18.5 && BMI<=24.9)
                System.out.println("The Person Has Normal Weight");
                else if (BMI>=25.0 && BMI<=29.9)
                System.out.println("The Person Is Over Weight");
                else
                System.out.println("The Person Is OBSE");
            }
        }
    }
}

//Write a java program to check whether a number is a spy number or not.
//Example:
//N = 132
//Sum of digit of N = 1 + 3 + 2 = 6
//Product of digit of N = 1 × 3 × 2 = 6
//So, 132 is a spy number.
//Sample Run:
//Enter a number: 1124
//1124 is a spy number.

import java.util.Scanner;
class Q3
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter The Number: ");
            int Number=sc.nextInt();
            int Sum=0,PSum=1,Store=Number;
            while(Number>0)
            {
                Sum+=Number%10;
                PSum*=Number%10;
                Number=Number/10;
            }
            if (Sum==PSum)
            System.out.println("So, "+Store+" Is A Spy Number");
            else
            System.out.println("So, "+Store+" Is Not A Spy Number");
        }
    }
}

//Write a Java program that outputs all possible strings formed by using the characters 'c', 'a', 'r', 'b', 'o', and 'n' exactly once.
//Example:
//For 3 characters ‘C’, ‘A’, ‘R’, the possible strings are
//CAR
//CRA
//RCA
//RAC
//ACR
//ARC

import java.util.Scanner;
class Q4
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter The Word: ");
            String Str=sc.next();
            char[] Store=Str.toCharArray();
            for (int i=0;i<Store.length;i++)
            {
                for (int j=0;j<Store.length;j++)
                {
                    for (int k=0;k<Store.length;k++)
                    {
                        if (i!=j && i!=k && j!=k)
                        System.out.println(""+Store[i]+Store[j]+Store[k]);
                    }
                }
            }
        }
    }
}

//Write a java method to calculate the sum of digits of a given number until the number is a single digit. The method signature is as follows.
//public static int sum_Of_Digits(int n)
//Example:
//Let n = 9294
//Sum = 9 + 2 + 9 + 4 = 24
//Sum = 2 + 4 = 6
//Sample Run:
//Enter a number 9294
//Sum of digits of 9294 until the number is a single digit is 6

import java.util.Scanner;
class Q5
{
    public static int Sum_Of_Digits(int Num)
    {
        while (Num >= 10)
        {
            Num = calculateDigitSum(Num);
        }
        return Num;
    }
    private static int calculateDigitSum(int Num)
    {
        int Sum = 0;
        while (Num > 0)
        {
            Sum += Num % 10;
            Num /= 10;
        }
        return Sum;
    }    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter A Number: ");
            int Number=sc.nextInt();
            System.out.print("Sum Of Digits Of "+Number+" Until The Number Is A Single Digit Is "+Sum_Of_Digits(Number));
        }
    }
}

//Write a Java method, isOdd( ), that takes an int i and returns true if and only if i is odd. Your method can't use the multiplication, modulus, or division operators, 
//The method signature is as follows.
//public static boolean isOdd(int n)
//Sample Run:
//Enter a number 37
//37 is odd: true

class Q6
{
    public static void main(String args[])
    {
        int Number=Integer.parseInt(args[0]);
        System.out.println("The Number Is: "+Number);
        System.out.print(Number+" Is Odd: "+isOdd(Number));
    }
    public static boolean isOdd(int n)
    {
        return (n & 1) == 1;
    }
}

//Write a java program to find the maximum and minimum and how many times they both occur in an array of n elements. Find out the positions where the maximum first
//occurs and the minimum last occurs.
//Sample Run:
//Enter number of elements of Array: 5
//Enter elements of the array: 12 14 12 14 13
//Maximum element of Array is 14 and occurs 2 times.
//Minimum element of Array is 12 and occurs 2 times.
//First occurrence of maximum element is at position 2.
//Last occurrence of minimum element is at position 3.

import java.util.Scanner;
public class Q7
{
    public static void main(String[] args)
    {
        try(Scanner scanner = new Scanner(System.in)){
        System.out.print("Enter Number Of Elements Of Array: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Enter Elements of The Array:\n");
        int max = array[0];
        int min = array[0];
        int maxCount = 1;
        int minCount = 1;
        int maxPosition = 0;
        int minPosition = 0;
        for (int i = 0; i < n; i++)
        {
            System.out.print("Enter The Element At "+(i+1)+" Is: ");
            array[i] = scanner.nextInt();
            if (i == 0)
            {
            max = array[i];
            min = array[i];
            }
        }
        for (int i = 1; i < n; i++)
        {
            if (array[i] > max)
            {
                max = array[i];
                maxCount = 1;
                maxPosition = i + 1;
            } 
            else if (array[i] == max)
            {
                maxCount++;
            }
            if (array[i] < min)
            {
                min = array[i];
                minCount = 1;
                minPosition = i + 1;
            } 
            else if (array[i] == min)
            {
                minCount++;
            }
        }
        System.out.println("Maximum Element Of Array Is " + max + " And Occurs " + maxCount + " Times.");
        System.out.println("Minimum Element Of Array Is " + min + " And Occurs " + minCount + " Times.");
        System.out.println("First Occurrence Of Maximum Element Is At Position " + maxPosition + ".");
        System.out.println("Last Occurrence Of Minimum Element Is At Position " + minPosition + ".");}
    }
}

//Write a java program to print M-by-N array in the tabular format. Also, display the sum of elements of the array.
//Sample Run:
//Enter number of Row and Columns of 2D-Array: 3 3
//Enter elements of 2D-Array: 1 2 3 2 3 4 3 4 5
//The elements of 2D array are: 123234345
//The sum of elements of the 2D-Array is 27

import java.util.Scanner;
class Q8
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter The Number Of Rows Of The Array: ");
            int Rows=sc.nextInt();
            System.out.print("Enter The Number Of Columns Of The Array: ");
            int Column=sc.nextInt();
            int Array[][],RowSum[],ColSum[];
            Array=new int[Rows][Column];
            RowSum=new int[Rows];
            ColSum=new int[Column];
            for (int i=0;i<Rows;i++)
            {
                for (int j=0;j<Column;j++)
                {
                    System.out.print("Enter The Element At Position "+(i+1)+""+(j+1)+" : ");
                    Array[i][j]=sc.nextInt();
                }
            }
            for (int i=0;i<Rows;i++)
            {
                RowSum[i]=0;
            }
            for (int j=0;j<Column;j++)
            {
                ColSum[j]=0;
            }
            for (int i=0;i<Rows;i++)
            {
                for (int j=0;j<Column;j++)
                {
                    RowSum[i]+=Array[i][j];
                }
            }
            for (int i=0;i<Column;i++)
            {
                for (int j=0;j<Rows;j++)
                {
                    ColSum[i]+=Array[i][j];
                }
            }
            int Sum=0;
            for (int i=0;i<Rows;i++)
            {
                Sum+=RowSum[i];
            }
            System.out.print("The Sum Of Elements Of The 2D-Array Is "+(Sum));
        }
    }
}

//Write a method that sums all the numbers in the major diagonal in an n * n matrix of double values using the following header:
//public static double sumMajorDiagonal(double[][] m)
//Write a java program that reads a 4-by-4 matrix and displays the sum of all its elements on the major diagonal.
//Sample Run:
//Enter a 4-by-4 matrix row by row:
//1 2   3  4.0 
//5 6.5 7  8 
//9 10  11 12 
//13 14 15 16 
//Sum of the elements in the major diagonal is 34.5

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

//Write a method that returns the sum of all the elements in a specified column in a matrix using the following header:
//public static double sumColumn(double[][] m, int columnIndex)
//Write a java program that reads a 3-by-4 matrix and displays the sum of each column.
//Sample Run:
//Enter a 3-by-4 matrix row by row: 
//1.5 2 3 4 
//5.5 6 7 8 
//9.5 1 3 1 
//Sum of the elements at column 0 is 16.5 
//Sum of the elements at column 1 is 9.0 
//Sum of the elements at column 2 is 13.0 
//Sum of the elements at column 3 is 13.0

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

//Write a Java program that takes as input three integers, a, b, and c, from the Java console and determines if they can be used in a correct arithmetic formula 
//(in the given order), like “a + b = c,” “a = b − c,” or “a b = c.”∗

import java.util.Scanner;
class Q11
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

//Write a Java program that takes all the lines input to standard input and writes them to standard output in reverse order. 
//That is, each line is output in the correct order, but the ordering of the lines is reversed.

import java.util.Scanner;
class Q12
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

//Write a Java program that takes two arrays a and b of length n storing int values, and returns the dot product of a and b. That is, 
//it returns an array c of length n such that c[i] = a[i] · b[i], for i = 0, . . . , n − 1.

import java.util.Scanner;
class Q13
{
    public static void main(String args[])
    {
        try (Scanner sc = new Scanner(System.in)) 
        {
            System.out.print("Enter The Size Of The Array: ");
            int N = sc.nextInt();
            int A[], B[];
            A = new int[N];
            B = new int[N];
            System.out.println("\nEnter The Vector A:");
            for (int i = 0; i < N; i++) 
            {
                System.out.print("Enter For Position " + (i + 1) + " : ");
                A[i] = sc.nextInt();
            }
            System.out.println("\nEnter The Vector B:");
            for (int i = 0; i < N; i++) 
            {
                System.out.print("Enter For Position " + (i + 1) + " : ");
                B[i] = sc.nextInt();
            }
            System.out.print("\nVector A: ");
            int Ch = 105;
            for (int i = 0; i < N; i++) 
            {
                if (A[i] > 0) {
                    if (i < N - 1)
                        System.out.print(A[i] + "" + (char) Ch + "+");
                    if (i == N - 1)
                        System.out.print(A[i] + "" + (char) Ch);
                } else {
                    if (i < N - 1)
                        System.out.print(A[i] + "" + (char) Ch);
                    if (i == N - 1)
                        System.out.print(A[i] + "" + (char) Ch);
                }
                Ch++;
            }
            Ch = 105;
            System.out.print("\nVector B: ");
            for (int j = 0; j < N; j++) 
            {
                if (B[j] > 0) {
                    if (j < N - 1)
                        System.out.print(B[j] + "" + (char) Ch + "+");
                    if (j == N - 1)
                        System.out.print(B[j] + "" + (char) Ch);
                } else {
                    if (j < N - 1)
                        System.out.print(B[j] + "" + (char) Ch);
                    if (j == N - 1)
                        System.out.print(B[j] + "" + (char) Ch);
                }
                Ch++;
            }
            int Result = 0;
            for (int i = 0; i < N; i++) 
            {
                Result += A[i] * B[i];
            }
            System.out.print("\nThe Dot Product Is: " + Result);
        }
    }
}

//Write a method to add two matrices. The header of the method is as follows:
//public static double[][] addMatrix(double[][] a, double[][] b)
//In order to be added, the two matrices must have the same dimensions and the same or compatible types of elements.

import java.util.Scanner;
class Q14
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

//Write a java program that randomly fills in 0s and 1s into a 4-by-4 matrix, prints the matrix, and finds the first row and column with the most 1s.
//Sample run:
//0 0 1 1 
//0 0 1 1 
//1 1 0 1 
//1 0 1 0
//The largest row index: 2
//The largest column index: 2

import java.util.Scanner;
public class Q15
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