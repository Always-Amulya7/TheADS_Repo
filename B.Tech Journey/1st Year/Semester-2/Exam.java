import java.util.*;
/*class Score
{
    void Display()
    {
        System.out.print("Enter A Number: ");
    }
    int Calc(int Number)
    {
        int Count=0;
        while(Number>2)
        {
            Number=Number/2;
            Count++;
        }
        return Count;
    }
}
class Exam 
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        Score Ob=new Score();
        Ob.Display();
        int Number=sc.nextInt();
        System.out.println("The Number Of Single Divisibility: "+Ob.Calc(Number));
    }
}*/

/*class Exam
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter The Weight In KGS: ");
            int Weight=sc.nextInt();
            System.out.print("Enter The Height In Meters: ");
            int Height=sc.nextInt();
            double BMI=(Weight)/(Height*Height);
            System.out.println("The BMI Is: "+BMI);
            if (BMI<18.5)
            System.out.println("Underweight");
            else if (BMI>18.5 && BMI<24.9)
            System.out.println("Normal Weight");
            else if (BMI>25 && BMI<29.9)
            System.out.println("Over Weight");
            else
            System.out.println("OBESE");
        }

    }
}*/

/*class Exam
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter The Number: ");
        int Number=sc.nextInt();
        int digitSum=0,productSum=1;
        int Store=Number;
        while(Number>0)
        {
            digitSum+=Number%10;
            productSum*=Number%10;
            Number=Number/10;;
        }
        boolean Res=(digitSum==productSum);
        System.out.println(Store+" Is Spy? "+Res);
    }
}*/

/*class Exam
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Reshuffe Of Words");
        char Arr[]={'C','A','R','B','O','N'};
        for (int i=0;i<Arr.length;i++)
        {
            for (int j=0;j<Arr.length;j++)
            {
                for (int k=0;k<Arr.length;k++)
                {
                    for (int l=0;l<Arr.length;l++)
                    {
                        for (int m=0;m<Arr.length;m++)
                        {
                            for (int n=0;n<Arr.length;n++)
                            {
                                if (i!=j && i!=k && i!=l && i!=m && i!=n 
                                    && j!=k && j!=l && j!=m && j!=n 
                                    && k!=l && k!=m && k!=n 
                                    && l!=m && l!=n
                                    && m!=n)
                                System.out.println(""+Arr[i]+Arr[j]+Arr[k]+Arr[l]+Arr[m]+Arr[n]);
                            }
                        }
                    }
                }
            }
        }
    }
}*/

/*class Exam
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter A Number: ");
            int Number=sc.nextInt();
            int Store=sum_Of_Digits(Number);
            while (Store>=10)
            {
                Store=sum_Of_Digits(Store);
            }
            System.out.println("The Number Of Times Is: "+Store);
        }
    }
    public static int sum_Of_Digits(int n)
    {
        int Sum=0;
        while(n>0)
        {
            Sum+=n%10;
            n=n/10;
        }
        return Sum;
    }
}*/

/*class Exam
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter A Number: ");
            int Number=sc.nextInt();
            System.out.println(Number+" Is Odd? "+isOdd(Number));
        }
    }
    public static boolean isOdd(int n)
    {
        return ((n & 1)==1);
    }
}*/

/*class Exam
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter The Size Of The Array: ");
        int n=sc.nextInt();
        int[] Arr=new int[n];
        int Max=Arr[0],Min=Arr[0],maxcount=1,mincount=1;
        int maxposition=0,minposition=0;
        for (int i=0;i<Arr.length;i++)
        {
            System.out.print("Enter The Element At "+(i+1)+" : ");
            Arr[i]=sc.nextInt();
            if (i == 0)
            {
            Max = Arr[i];
            Min = Arr[i];
            }
        }
        System.out.println("\nThe Array Is: ");
        for (int i=0;i<Arr.length;i++)
        {
            System.out.print(Arr[i]+" ");
        }
        for (int i=0;i<Arr.length;i++)
        {
            if (Arr[i]>Max)
            {
                Max=Arr[i];
                maxcount=1;
                maxposition=i+1;
            }
            else if (Arr[i]==Max)
            {
                maxcount++;
            }
            if (Arr[i]<Min)
            {
                Min=Arr[i];
                mincount=1;
                minposition=i+1;
            }
            else if (Arr[i]==Min)
            {
                mincount++;
            }
        }
        System.out.println("\nMaximum Element Of Array Is " + Max + " And Occurs " + maxcount + " Times.");
        System.out.println("Minimum Element Of Array Is " + Min + " And Occurs " + mincount + " Times.");
        System.out.println("First Occurrence Of Maximum Element Is At Position " + maxposition + ".");
        System.out.println("Last Occurrence Of Minimum Element Is At Position " + minposition + ".");
    }
}*/

/*class Exam
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter The Dimensions: ");
            int m=sc.nextInt();
            int n=sc.nextInt();
            int[][] Arr=new int[m][n];
            for (int i=0;i<Arr.length;i++)
            {
                for (int j=0;j<Arr.length;j++)
                {
                    System.out.print("Enter At "+(i+1)+""+(j+1)+" : ");
                    Arr[i][j]=sc.nextInt();
                }
            }
            System.out.println("\nThe 2D Array Is: ");
            for (int i=0;i<Arr.length;i++)
            {
                for (int j=0;j<Arr.length;j++)
                {
                    System.out.print(Arr[i][j]+" ");
                }
                System.out.println();
            }
            int Sum=0;
            for (int i=0;i<Arr.length;i++)
            {
                for (int j=0;j<Arr.length;j++)
                {
                    Sum+=Arr[i][j];
                }
            }
            System.out.println("The Sum Of The 2D Array Is: "+Sum);
        }
    }
}*/

/*class Exam
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter The Dimensions: ");
            int m=sc.nextInt();
            int n=sc.nextInt();
            double[][] Arr=new double[m][n];
            for (int i=0;i<Arr.length;i++)
            {
                for (int j=0;j<Arr.length;j++)
                {
                    System.out.print("Enter At "+(i+1)+""+(j+1)+" : ");
                    Arr[i][j]=sc.nextDouble();
                }
            }
            System.out.println("\nThe 2D Array Is: ");
            for (int i=0;i<Arr.length;i++)
            {
                for (int j=0;j<Arr.length;j++)
                {
                    System.out.print(Arr[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println("The Sum Of The Diagonal Of 2D Array Is: "+sumMajorDiagonal(Arr));
        }
    }
    public static double sumMajorDiagonal(double[][] m)
    {
        double Sum=0;
        for (int i=0;i<m.length;i++)
        {
            for (int j=0;j<m.length;j++)
            {
                if (i==j)
                Sum+=m[i][j];
            }
        }
        return Sum;
        }
}*/

/*class Exam
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter The Dimensions: ");
            int m=sc.nextInt();
            int n=sc.nextInt();
            double[][] Arr=new double[m][n];
            for (int i=0;i<Arr.length;i++)
            {
                for (int j=0;j<Arr.length;j++)
                {
                    System.out.print("Enter At "+(i+1)+""+(j+1)+" : ");
                    Arr[i][j]=sc.nextDouble();
                }
            }
            System.out.println("\nThe 2D Array Is: ");
            for (int i=0;i<Arr.length;i++)
            {
                for (int j=0;j<Arr.length;j++)
                {
                    System.out.print(Arr[i][j]+" ");
                }
                System.out.println();
            }
            System.out.print("Enter The Choice Column: ");
            int Ch=sc.nextInt();
            System.out.println("The Sum Of The Diagonal Of 2D Array Is: "+sumColumn(Arr,Ch));
        }
    }
    public static double sumColumn(double[][] m, int columnIndex)
    {
        double[] Sum=new double[m.length];
        for (int i=0;i<m.length;i++)
        {
            for (int j=0;j<m.length;j++)
            {
                Sum[i]+=m[j][i];
            }
        }
        return Sum[columnIndex];
    }
}*/

/*class Exam
{
    public exam()
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter Values: ");
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            if ((a+b==c)||(a==b-c)||(a*b==c))
            System.out.print("In Arithimetic Series");
            else
            System.out.print("Not In Arithimetic Series");
        }
    }
    public static void main(String args[])
    {
        Exam ob=new Exam();
    }
}*/

/*import java.util.*;
class Reverse
{
    Reverse()
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter The String Length:");
            int n=sc.nextInt();
            String[] Arr=new String[n];
            System.out.println("Enter The Respective Sentences: ");
            sc.nextLine();
            for (int i=0;i<n;i++)
            {
                Arr[i]=sc.nextLine();
            }
            System.out.println("\nThe Reversed Statements Are: ");
            for (int i=n-1;i>=0;i--)
            {
                System.out.println(Arr[i]);
            }
        }
    }
}
class Exam
{
    public static void main(String args[])
    {
        Reverse Ob;
        Ob=new Reverse();
    }
}*/

/*import java.util.*;
class Vectors
{
    double store=0;
    double Vectors(double[] V1,double[] V2)
    {
        // Scalar Product Vaii
        for (int i=0;i<2;i++)
        {
            store+=V1[i]*V2[i];
        }
        return store;
    }
}
class Exam
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in)){
        double[] Vector1=new double[2];
        double[] Vector2=new double[2];
        System.err.print("Enter Values For Vector1: ");
        for (int i=0;i<Vector1.length;i++)
        {
            Vector1[i]=sc.nextDouble();
        }
        System.err.print("Enter Values For Vector2: ");
        for (int i=0;i<Vector2.length;i++)
        {
            Vector2[i]=sc.nextDouble();
        }
        System.out.println("The Vectors Are:");
        System.out.println(Vector1[0]+"i+"+Vector1[1]+"j");
        System.out.println(Vector2[0]+"i+"+Vector2[1]+"j");
        Vectors obj = new Vectors(); // Create a Vectors object
        //double result = obj.Vector(Vector1, Vector2); // Call the method to calculate
        System.out.println("The scalar product of the vectors is: " + obj.Vectors(Vector1, Vector2));}
    }
}*/

/*import java.util.*;
class Matrix_Add
{
    void Display()
    {
        System.out.println("Enter The Data For The Matrix: ");
    }
    public static double[][] addMatrix(double[][] a, double[][] b)
    {
        double[][] Store=new double[a.length][b.length];
        for (int i=0;i<a.length;i++)
        {
            for (int j=0;j<b.length;j++)
            {
                Store[i][j]+=a[i][j]+b[i][j];
            }
        }
        for (int i=0;i<Store.length;i++)
        {
            for (int j=0;j<Store.length;j++)
            {
                System.out.print(Store[i][j]+" ");
            }
            System.out.println();
        }
        return Store;
    }
}
class Exam
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            Matrix_Add Ob=new Matrix_Add();
            double a[][],b[][];
            a=new double[3][3];
            b=new double[3][3];
            Ob.Display();
            for (int i=0;i<a.length;i++)
            {
                for (int j=0;j<a.length;j++)
                {
                    System.out.print("Enter Element At "+(i+1)+""+(j+1)+": ");
                    a[i][j]=sc.nextDouble();
                }
            }
            Ob.Display();
            for (int i=0;i<b.length;i++)
            {
                for (int j=0;j<b.length;j++)
                {
                    System.out.print("Enter Element At "+(i+1)+""+(j+1)+": ");
                    b[i][j]=sc.nextDouble();
                }
            }
            System.out.println("The Sum Matrix Is: ");
            Ob.addMatrix(a, b);
        }
    }
}*/

/*import java.util.*;
public class Exam
{
    public static void main(String[] args)
    {
        int[][] matrix = new int[4][4];
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) 
        {
            for (int j = 0; j < matrix[i].length; j++) 
            {
                matrix[i][j] = random.nextInt(2); // Generates random numbers 0 or 1
            }
        }
        System.out.println("Matrix:");
        for (int i = 0; i < matrix.length; i++) 
        {
            for (int j = 0; j < matrix[i].length; j++) 
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // Find the row and column with the most 1s
        int[] rowSums = new int[matrix.length];
        int[] colSums = new int[matrix[0].length];

        // Calculate row and column sums
        for (int i = 0; i < matrix.length; i++) 
        {
            for (int j = 0; j < matrix[i].length; j++) 
            {
                rowSums[i] += matrix[i][j];
                colSums[j] += matrix[i][j];
            }
        }

        // Find the index of the row with the maximum sum
        int maxRowIndex = maxIndex(rowSums);

        // Find the index of the column with the maximum sum
        int maxColIndex = maxIndex(colSums);

        // Print the results
        System.out.println("Row with the most 1s: " + maxRowIndex);
        System.out.println("Column with the most 1s: " + maxColIndex);
    }

    // Method to find the index of the maximum value in an array
    public static int maxIndex(int[] array) 
    {
        int maxIndex = 0;
        int maxValue = array[0];
        for (int i = 1; i < array.length; i++) 
        {
            if (array[i] > maxValue) 
            {
                maxValue = array[i];
                maxIndex = i+1;
            }
        }
        return maxIndex;
    }
}*/

/*class Exam
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        try
        {
            System.out.print("Enter A Number: ");
            int Number=sc.nextInt();
            if (Number<0)
            throw new NumberError("Error");
            System.out.println("The Lucky Number Is: "+Number);
        }
        catch(NumberError e)
        {
            System.out.println(e.getMessage());
        }
    }
}
class NumberError extends Exception
{
    public NumberError(String message)
    {
        super(message);
    }
}*/

/*import java.lang.*;
class Exam
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        try
        {
            String Arr[]={"Yellow","Red","Green","Blue"};
            System.err.println("The Array Is: ");
            for (int i=0;i<Arr.length;i++)
            {
                System.out.print(Arr[i]+" ");
            }
            System.out.println("\nThe Color At Position 5 Is: "+Arr[4]);
            System.out.println("\nThe Color At Position -1 Is: "+Arr[-1]);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("\nArray Length Not Satisfied");
        }
    }
}*/

/*import java.lang.*;
class Exam
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        try
        {
            System.out.print("Enter A Number: ");
            int Number=sc.nextInt();
            if (Number>0)
            throw new MarksException("Error");
            System.out.println("The Marks Is: "+Number);
        }
        catch(MarksException e)
        {
            System.out.println("Error");
        }
    }
}*/

//Mid Sem Question-2024

/*class A
{
    final int a=abc();
    protected int abc()
    {
        return 10;
        System.out.println("Hi");
    }
}
public class Exam
{
    public static void main(String args[])
    {
        A ob=new A();
        System.out.println(ob.a);
    }
}*/

/*public class Exam
{
    static int a=0;
    public static void main(String args[])
    {
        for (int i=3;i>1;i--)
        {
            abc(i);
        }
    }
    static void abc(int x)
    {
        int b=0,a=b;
        for(int i=1;i<=3;i++)
        {
            a+=x;
            b+=i;
            System.out.println(a+" "+b);
        }
    }
}*/

/*class Point
{
    double x,y;
    void setData(double x,double y)
    {
        this.x=x;
        this.y=y;
    }
    void display()
    {
        System.out.println("The Point Is: "+x+" "+y);
    }
}
class Exam
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter Point1: ");
            double x1=sc.nextDouble();
            double y1=sc.nextDouble();
            System.out.print("Enter Point2: ");
            double x2=sc.nextDouble();
            double y2=sc.nextDouble();
            Point Ob1=new Point();
            Point Ob2=new Point();
            Ob1.setData(x1, y1);
            Ob1.display();
            Ob1.setData(x2, y2);
            Ob1.display();
            System.out.println("The Distance Is: "+
            //Math.sqrt((((Ob2.x)*(Ob2.x))-((Ob1.x)*(Obj1.x)))+(((Ob2.y)*(Ob2.y))-((Ob1.y)*(Obj1.y)))));
        }
    }
}*/

/*class Exam
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String[] Arr=new String[5];
        try
        {
            System.out.print("Enter The Position Of The Array: ");
            int n=sc.nextInt();
            System.out.print("Enter The Choice: ");
            Arr[n]=sc.next();
            System.out.println(Arr[0]);
            System.out.println(Arr[6]);
        }
        catch (NullPointerException e)
        {
            System.out.println("Error1");
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.err.println("Error2");
        }
    }
}*/

interface Polygon
{
    abstract double findArea();
}
class Rectangle implements Polygon
{
    double findArea(double l,double b)
    {
        return (l*b);
    }
}
class Square implements Polygon
{
    double findArea(double a)
    {
        return (a*a);
    }
}
class Exam
{
    public static void main(String args[])
    {
        Reactangle Ob1=new Reactangle();
        System.out.println("The Area Is: "+Ob1.findArea(5.0,6.0));
        Square Ob2=new Square();
        System.out.println("The Area Is: "+Ob2.findArea(5.0));
    }
}