import java.lang.reflect.Method;
import java.util.*;
import javax.swing.ComponentInputMap;
import org.w3c.dom.Node;

/*class Self
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter The Number: ");
            int Number=Sc.nextInt();
            int Count=0;
            while(Number>2)
            {
                Number=Number/2;
                Count++;
            }
            System.out.println("The Number Of Times Is: "+Count);
        }
    }
}*/

/*class Self
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter Weight In KGS: ");
            float Weight=Sc.nextFloat();
            System.out.print("Enter Height In Meter: ");
            float Height=Sc.nextFloat();
            double BMI=Weight/(Height*Height);
            if (BMI<18.5)
            System.out.println("Under Weight");
            else if(BMI>=18.5 && BMI<24.9)
            System.out.println("Normal Weight");
            else if(BMI>=25.0 && BMI<29.9)
            System.out.println("Over Weight");
            else
            System.out.println("OBSE");
        }
    }
}*/

/*class Self
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter A Number: ");
            int Number=Sc.nextInt();
            int Sum=0,Product=1;
            do
            {
                Sum=Sum+Number%10;
                Product=Product*Number%10;
                Number=Number/10;
            }
            while(Number>0);
            System.out.println("Spy Or Not? "+((Sum==Product)?true:false));
        }
    }
}*/

/*class Self
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter A Word: ");
            String Word=Sc.next();
            for (int i=0;i<Word.length();i++)
            {
                for (int j=0;j<Word.length();j++)
                {
                    for (int k=0;k<Word.length();k++)
                    {
                        for (int l=0;l<Word.length();l++)
                        {
                            for (int m=0;m<Word.length();m++)
                            {
                                for (int n=0;n<Word.length();n++)
                                {
                                    if (i!=j && i!=k && i!=l && i!=m && i!=n &&
                                        j!=k && j!=l && j!=m && j!=n &&
                                        k!=l && k!=m && k!=n &&
                                        l!=m && l!=n &&
                                        m!=n)
                                    System.out.println(""+Word.charAt(i)+Word.charAt(j)+Word.charAt(k)+Word.charAt(l)+
                                                          Word.charAt(m)+Word.charAt(n));
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}*/

/*class Self
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

/*class Self
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter A Number: ");
            int Number=Sc.nextInt();
            int Store=sum_Of_Digits(Number);
            while (Store>=10)
            {
                Store=sum_Of_Digits(Store);
            }
            System.out.println("The Number Of Times Is: "+Store);
        }
    }
    public static int sum_Of_Digits(int Number)
    {
        int Sum=0;
        do
        {
            Sum+=Number%10;
            Number=Number/10;
        }
        while(Number>0);
        return Sum;
    }
}*/

/*class Self
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter A Number: ");
            int Number=Sc.nextInt();
            System.out.println("The Number "+Number+" Is Odd? "+isOdd(Number));
        }
    }
    public static boolean isOdd(int n)
    {
        return ((n & 1)==1);
    }
}*/

/*class Self
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter The Number Of Elements Of The Array: ");
            int Size=Sc.nextInt();
            int[] Arr=new int[Size];
            for (int i=0;i<Size;i++)
            {
                System.out.print("Enter The Element At "+(i+1)+" : ");
                Arr[i]=Sc.nextInt();
            }
            System.out.print("The Array Is: ");
            for (int i=0;i<Size;i++)
            {
                System.out.print(Arr[i]+" ");
            }
            int Max=Arr[0],Min=Arr[0],maxcount=1,mincount=1;
            int maxposition=0,minposition=0;
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
    }
}*/

/*class Self
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter The Number Of Rows And Columns: ");
            int Rows=Sc.nextInt();
            int Columns=Sc.nextInt();
            int[][] Arr=new int[Rows][Columns];
            int Sum=0;
            for (int i=0;i<Arr.length;i++)
            {
                for (int j=0;j<Arr.length;j++)
                {
                    System.out.print("Enter The Element At "+(i+1)+""+(j+1)+" : ");
                    Arr[i][j]=Sc.nextInt();
                    Sum+=Arr[i][j];
                }
            }
            System.out.println("The 2-D Array Is: ");
            for (int i=0;i<Arr.length;i++)
            {
                for (int j=0;j<Arr.length;j++)
                {
                    System.out.print(Arr[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println("The Sum Of The 2-D Array Is: "+Sum);
        }
    }
}*/

/*class Self
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter The Number Of Rows And Columns: ");
            int Rows=Sc.nextInt();
            int Columns=Sc.nextInt();
            double[][] Arr=new double[Rows][Columns];
            for (int i=0;i<Arr.length;i++)
            {
                for (int j=0;j<Arr.length;j++)
                {
                    System.out.print("Enter The Element At "+(i+1)+""+(j+1)+" : ");
                    Arr[i][j]=Sc.nextDouble();
                }
            }
            System.out.println("The 2-D Array Is: ");
            for (int i=0;i<Arr.length;i++)
            {
                for (int j=0;j<Arr.length;j++)
                {
                    System.out.print(Arr[i][j]+"\t");
                }
                System.out.println();
            }
            System.out.println("The Sum Of Diagonal Elements Of The 2-D Array Is: "+sumMajorDiagonal(Arr));
        }
    }
    public static double sumMajorDiagonal(double[][] m)
    {
        double Sum=0.0;
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

/*class Self
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter The Number Of Rows And Columns: ");
            int m=sc.nextInt();
            int n=sc.nextInt();
            double[][] Arr=new double[m][n];
            for (int i=0;i<m;i++)
            {
                for (int j=0;j<n;j++)
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

/*class Self
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter Three Integers: ");
            int A=Sc.nextInt();
            int B=Sc.nextInt();
            int C=Sc.nextInt();
            if ((A+B==C)||(A==B-C)||(A*B==C))
            System.out.println("In Arithmetic Series");
            else
            System.out.println("Not In Arithmetic Series");
        }
    }
}*/

/*class Self
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter The Number Of Lines: ");
            int Number=Sc.nextInt();
            String Arr[]=new String[Number];
            System.out.println("Enter The Respective Sentences: ");
            Sc.nextLine();
            for (int i=0;i<Number;i++)
            {
                Arr[i]=Sc.nextLine();
            }
            System.out.println("The Reversed Order Is: ");
            for (int j=Number-1;j>=0;j--)
            {
                System.out.println(Arr[j]);
            }
        }
    }
}*/

/*class Self
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
        int store=0;
        for (int i=0;i<2;i++)
        {
            store+=Vector1[i]*Vector2[i];
        }
        System.out.println("The scalar product of the vectors is: " +store);}
    }
}*/

/*class Self
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter The Dimensions: ");
            int m=sc.nextInt();
            int n=sc.nextInt();
            double[][] Matrix1=new double[m][n];
            double[][] Matrix2=new double[m][n];
            System.out.println("Enter Matrix 1:");
            for (int i=0;i<m;i++)
            {
                for (int j=0;j<n;j++)
                {
                    System.out.print("Enter At "+(i+1)+""+(j+1)+" : ");
                    Matrix1[i][j]=sc.nextDouble();
                }
            }
            System.out.println("Enter Matrix 2:");
            for (int i=0;i<m;i++)
            {
                for (int j=0;j<n;j++)
                {
                    System.out.print("Enter At "+(i+1)+""+(j+1)+" : ");
                    Matrix2[i][j]=sc.nextDouble();
                }
            }
            System.out.println("Matrix 1: ");
            for (int i=0;i<m;i++)
            {
                for (int j=0;j<n;j++)
                {
                    System.out.print(Matrix1[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println("Matrix 2: ");
            for (int i=0;i<m;i++)
            {
                for (int j=0;j<n;j++)
                {
                    System.out.print(Matrix2[i][j]+" ");
                }
                System.out.println();
            }
            double[][] Sum_Matrix=new double[m][n];
            System.out.println("Matrix 1: ");
            for (int i=0;i<m;i++)
            {
                for (int j=0;j<n;j++)
                {
                    Sum_Matrix[i][j]+=Matrix1[i][j]+Matrix2[i][j];
                }
            }
            System.out.println("The Sum Matrix Is: ");
            for (int i=0;i<m;i++)
            {
                for (int j=0;j<n;j++)
                {
                    System.out.print(Sum_Matrix[i][j]+" ");
                }
                System.out.println();
            }
        }
    }
}*/

/*public class Self
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

/*class Person
{
    public String Name;
    public int Age;
    void Setdata(String name,int age)
    {
        this.Name=name;
        this.Age=age;
    }
    void Display()
    {
        System.out.println("Name="+Name);
        System.out.println("Age="+Age);
    }
}
class Self
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            Person Ob1=new Person();
            Ob1.Name="Amulya";
            Ob1.Age=19;
            Ob1.Display();
            System.out.print("Enter The Name=");
            String Name=Sc.nextLine();
            System.out.print("Enter The Age=");
            int Age=Sc.nextInt();
            Person Ob2=new Person();
            Ob2.Setdata(Name, Age);
            Ob2.Display();
            if (Ob1.Age>Ob2.Age)
            System.out.println(Ob1.Name+" Is Bigger In Age.");
            else
            System.out.println(Ob2.Name+" Is Bigger In Age.");
        }
    }
}*/

/*class Complex
{
    double Real,Imaginary;
    void Setdata(double Real,double Imaginary)
    {
        this.Real=Real;
        this.Imaginary=Imaginary;
    }
    void Display()
    {
        System.out.println(Real+((Imaginary>0)?"+":"-")+Math.abs(Imaginary)+"i");
    }
    public Complex add(Complex C1,Complex C2)
    {
        Complex C3=new Complex();
        C3.Real=C1.Real+C2.Real;
        C3.Imaginary=C1.Imaginary+C2.Imaginary;
        return C3;
    }
}
class Self
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter The First Set OF Data= ");
            Complex C1=new Complex();
            double Real1=Sc.nextDouble();
            double Imag1=Sc.nextDouble();
            C1.Setdata(Real1, Imag1);
            C1.Display();
            System.out.print("Enter The Second Set OF Data= ");
            Complex C2=new Complex();
            double Real2=Sc.nextDouble();
            double Imag2=Sc.nextDouble();
            C2.Setdata(Real2, Imag2);
            C2.Display();
            System.out.print("The Sum Of The Complex Numbers Is: ");
            Complex C3=C1.add(C1,C2);
            C3.Display();
        }
    }
}*/

/*class Product
{
    String prodID;
    double price;
    int quantity;
    static double totalprice=0;
    Product(String prodID,double price,int quantity)
    {
        this.price=price;
        this.prodID=prodID;
        this.quantity=quantity;
    }
    void display()
    {
        System.out.println("Product ID   ---> "+prodID);
        System.out.println("Price        ---> $"+price);
        System.out.println("Quantity     ---> "+quantity);
        System.out.println("-------------------------------");
        totalprice+=price*quantity;
    }
}
class Self
{
    public static void main(String args[])
    {
        System.out.println("Welcome To ADS Mart");
        try(Scanner sc=new Scanner(System.in))
        {
            Product Obj[]=new Product[5];
            Obj[0]=new Product("A", 15, 2);
            Obj[1]=new Product("B", 20, 2);
            Obj[2]=new Product("C", 30, 2);
            Obj[3]=new Product("D", 10, 2);
            Obj[4]=new Product("E", 25, 2);
            for (int i=0;i<Obj.length;i++)
            {
                Obj[i].display();
            }
            System.out.println("The Total Bill ---->"+Product.totalprice);
        }
    }
}*/

/*class Deposit
{
    public long Principal;
    public int Time;
    public double Rate,TotalAmount=0.0;
    Deposit(long P,double R,int T)
    {
        Principal=P;
        Rate=R;
        Time=T;
    }
    Deposit(long P,double R)
    {
        Principal=P;
        Rate=R;
    }
    Deposit(long P,int T)
    {
        Principal=P;
        Time=T;
    }
    void Display()
    {
        System.err.println("Principal="+Principal);
        System.out.println("Rate="+Rate);
        System.out.println("Time="+Time);
        System.out.println("Total Amount= "+CalcAmt());
    }
    double CalcAmt()
    {
        return TotalAmount=Principal+((Principal*Rate*Time)/100);
    }
}
class Self
{
    public static void main(String args[])
    {
        Deposit SBI=new Deposit(5000,5,6);
        SBI.Display();
        Deposit BOI=new Deposit(6_000,3.0,2);
        BOI.Display();
        Deposit PNB=new Deposit(45_000,6.0,3);
        PNB.Display();
    }
}*/

/*class Person
{
    String Name;
    int Age;
    Person(String Name,int Age)
    {
        this.Name=Name;
        this.Age=Age;;
    }
}
class Employee extends Person
{
    int EId;
    double Salary=0.0;
    Employee(String Name,int Age,int EId,double Salary)
    {
        super(Name, Age);
        this.EId=EId;
        this.Salary=Salary;
    }
    void empDisplay()
    {
        System.out.println(Name+"\t"+Age+"\t"+EId+"\t"+Salary);
    }
}
class Self
{
    public static void main(String args[])
    {
        Employee E[]=new Employee[4];
        E[0]=new Employee("MESSI", 10, 1001, 100000);
        E[1]=new Employee("NEYMAR", 11, 1002, 10000);
        E[2]=new Employee("HALLAND", 12, 1002, 1000);
        E[3]=new Employee("ZALTAN", 13, 1003, 100);
        System.out.println("Name\tAge\tEID\tSalary");
        for (int i=0;i<E.length;i++)
        {
            E[i].empDisplay();
        }
    }
}*/

/*abstract class Marks
{
    double markICP,markDSA,percentage;
    abstract void getPercentage();
}
class CSE extends Marks
{
    double algoDesign;
    public CSE(double markICP,double markDSA,double algoDesign)
    {
        this.markICP=markICP;
        this.markDSA=markDSA;
        this.algoDesign=algoDesign;
    }
    void getPercentage()
    {
        percentage=(markICP+markDSA+algoDesign)/3;
        System.out.println("Percentage Of CSE Student: "+percentage);
    }
}
class NonCSE extends Marks
{
    double enggMechanics;
    public NonCSE(double markICP,double markDSA,double enggMechanics)
    {
        this.markICP=markICP;
        this.markDSA=markDSA;
        this.enggMechanics=enggMechanics;
    }
    void getPercentage()
    {
        percentage=(markICP+markDSA+enggMechanics)/3;
        System.out.println("Percentage Of NonCSE Student: "+percentage);
    }
}
class Self
{
    public static void main(String args[])
    {
        CSE CSEStudent=new CSE(80,85,90);
        NonCSE NonCSEStudent=new NonCSE(70,75,80);
        CSEStudent.getPercentage();
        NonCSEStudent.getPercentage();
    }
}*/

/*interface DetailInfo 
{
    void Display();
    void count();
}

class Person implements DetailInfo 
{
    static int maxcount;
    String Name;

    Person(String Name) 
    {
        this.Name = Name;
    }

    public void Display() 
    {
        System.out.println("Name=" + Name);
    }

    public void count()
     {
        maxcount = 0;
        for (int i = 0; i < Name.length(); i++)
        { // "length()" instead of "Length()"
            if (Name.charAt(i) != ' ')
                maxcount++;
        }
        System.out.println("The Letters In The Sentence Is: " + maxcount);
    }
}

public class Self 
{
    public static void main(String args[]) 
    {
        Person P1 = new Person("Amulya");
        P1.Display();
        P1.count();
        Person P2 = new Person("Deep");
        P2.Display();
        P2.count();
    }
}*/

/*package P1;
import java.util.Scanner;

class Student 
{
    String Name;
    int Roll;

    void InputDetails()
    {
        try (Scanner sc = new Scanner(System.in)) 
        {
            System.out.print("Enter The Name: ");
            Name = sc.next(); // Removed declaration of local variable String Name
            System.out.print("Enter The Roll Number: ");
            Roll = sc.nextInt(); // Changed Number to Roll to assign value to class member Roll
        }
    }

    void showDetails() {
        System.out.println("The Name Of The Student Is: " + Name);
        System.out.println("Roll Number: " + Roll);
    }
}

public class Test extends Student 
{
    public int Mark1, Mark2;

    protected void InputDetails() 
    {
        try (Scanner sc = new Scanner(System.in)) 
        {
            System.out.print("Enter The Name: ");
            Name = sc.next(); // Changed String Name to Name to assign value to class member Name
            System.out.print("Enter The Roll Number: ");
            Roll = sc.nextInt(); // Changed Number to Roll to assign value to class member Roll
        }
    }

    protected void showDetails() 
    {
        super.showDetails();
        System.out.println("Marks 1: " + Mark1); // Removed duplicate printing of Name and Roll
        System.out.println("Marks 2: " + Mark2); // Removed duplicate printing of Name and Roll
    }
}

package P2;

public interface Sports
{
    int Score1 = 3;
    int Score2 = 0;
}

import P1.Student;
import P2.Sports;

public class ADS extends Test implements Sports 
{
    public static void main(String[] args) 
    {
        ADS Ob = new ADS();
        Ob.InputDetails();
        Ob.showDetails();
        System.out.println("Total Marks: " + (Ob.Mark1 + Ob.Mark2));
        System.out.println("Total Score: " + (Sports.Score1 + Sports.Score2));
    }
}*/

/*class Commission
{
    static double Sales;
    Commission(double Sales)
    {
        this.Sales=Sales;
    }
    double getCommission()
    {
        if (Sales<100)
        return (0.02*Sales);
        else if (Sales<5000)
        return ((0.02*Sales)+(0.05*(Sales-100)));
        else
        return ((0.02*Sales)+(0.05*(4500))+(0.08*(Sales-500)));
    }
}
class Self
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter The Sales Of A User: ");
            double Sales=sc.nextDouble();
            Commission Com=new Commission(Sales);
            double Commission=Com.getCommission();
            if (Commission>0)
            System.out.println("Your Commission Is: "+Commission);
            else
            System.out.println("Invalid Input");
        }
    }
}*/

/*class Book
{
    String BName, BEdition;
    double BPrice;
    Book(String BName, String BEdition, double BPrice)
    {
        this.BName = BName;
        this.BEdition = BEdition;
        this.BPrice = BPrice;
    }
}

public class Self
{
    public static void main(String[] args) 
    {
        try (Scanner sc = new Scanner(System.in)) 
        {
            Book[] books = new Book[5];
            books[0] = new Book("Harry Potter", "Deathly Hallows", 995);
            books[1] = new Book("Geronimo Stilton", "Elisabetta Dami", 495);
            books[2] = new Book("Oliver Twist", "Charles Dickens", 545);
            books[3] = new Book("Malgudi Day", "RK Narayan", 125);
            books[4] = new Book("Wings Of Fire", "APJ Abdul Kalam", 675);

            double maxPrice = books[0].BPrice;
            int maxIndex = 0;

            for (int i = 1; i < books.length; i++) 
            {
                if (books[i].BPrice > maxPrice) 
                {
                    maxPrice = books[i].BPrice;
                    maxIndex = i;
                }
            }

            System.out.println("Book with maximum price:");
            System.out.println("Book Name: " + books[maxIndex].BName);
            System.out.println("Book Edition: " + books[maxIndex].BEdition);
            System.out.println("Book Price: " + books[maxIndex].BPrice);
        }
    }
}*/

/*import java.util.*;
class Bank
{
    private String bankName;
    private double depositAmount;
    private static double totalAmount = 0;
    public void setBankName(String bankName)
    {
        this.bankName = bankName;
    }
    public void setAmount(double depositAmount)
    {
        if (depositAmount >= 1000)
        {
            this.depositAmount = depositAmount;
            totalAmount += depositAmount;
        } 
        else
        {
            System.out.println("Minimum deposit amount is 1000.");
        }
    }
    public void showData()
    {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Deposit Amount: " + depositAmount);
    }
    public static double getTotalAmount()
    {
        return totalAmount;
    }
    public static String getMinimumDepositBank(Bank[] banks)
    {
        double minDeposit = Double.MAX_VALUE;
        String bankName = "";
        for (Bank bank : banks)
        {
            if (bank.depositAmount < minDeposit)
            {
                minDeposit = bank.depositAmount;
                bankName = bank.bankName;
            }
        }
        return bankName;
    }
}
public class ADS
{
    public static void main(String[] args)
    {
        Bank[] banks = new Bank[5];
        banks[0] = new Bank();
        banks[0].setBankName("Bank A");
        banks[0].setAmount(1500);

        banks[1] = new Bank();
        banks[1].setBankName("Bank B");
        banks[1].setAmount(2000);

        banks[2] = new Bank();
        banks[2].setBankName("Bank C");
        banks[2].setAmount(1200);

        banks[3] = new Bank();
        banks[3].setBankName("Bank D");
        banks[3].setAmount(950);

        banks[4] = new Bank();
        banks[4].setBankName("Bank E");
        banks[4].setAmount(1800);

        // Display bank information
        System.out.println("Bank Information:");
        for (Bank bank : banks) 
        {
            bank.showData();
            System.out.println();
        }

        // Display total amount deposited
        System.out.println("Total Amount Deposited: " + Bank.getTotalAmount());

        // Display bank with minimum deposit amount
        System.out.println("Bank with Minimum Deposit: " + Bank.getMinimumDepositBank(banks));
    }
}*/

/*class Distance 
{
    private int meters;
    private int centimeters;

    // Parameterized constructor
    public Distance(int meters, int centimeters) 
    {
        this.meters = meters;
        this.centimeters = centimeters;
    }

    // Display method to display the distance
    public void display() 
    {
        System.out.println("Distance: " + meters + " meters " + centimeters + " centimeters");
    }

    // Method to add two distances
    public void sum(Distance d1, Distance d2)
    {
        int totalCentimeters = d1.centimeters + d2.centimeters;
        int carry = totalCentimeters / 100; // Find carry if centimeters exceed 100
        int remainingCentimeters = totalCentimeters % 100;
        int totalMeters = d1.meters + d2.meters + carry;
        System.out.println("Sum of distances:");
        System.out.println("Total Meters: " + totalMeters + " meters");
        System.out.println("Total Centimeters: " + remainingCentimeters + " centimeters");
    }
}

public class ADS
{
    public static void main(String[] args)
    {
        // Creating Distance objects
        Distance distance1 = new Distance(5, 70); // 5 meters 70 centimeters
        Distance distance2 = new Distance(3, 30); // 3 meters 30 centimeters

        // Displaying distances
        System.out.println("Distance 1:");
        distance1.display();
        System.out.println();

        System.out.println("Distance 2:");
        distance2.display();
        System.out.println();

        // Adding distances
        Distance totalDistance = new Distance(0, 0);
        totalDistance.sum(distance1, distance2);
    }
}*/

/*class PointType
{
    private double x;
    private double y;

    // Parameterized constructor
    public PointType(double x, double y) 
    {
        this.x = x;
        this.y = y;
    }

    // Setter methods
    public void setX(double x) 
    {
        this.x = x;
    }

    public void setY(double y) 
    {
        this.y = y;
    }

    // Getter methods
    public double getX() 
    {
        return x;
    }

    public double getY() 
    {
        return y;
    }

    // Display method to print coordinates
    public void display() 
    {
        System.out.println("Point Coordinates: (" + x + ", " + y + ")");
    }
}

class CircleType extends PointType 
{
    private double radius;

    // Parameterized constructor
    public CircleType(double x, double y, double radius)
    {
        super(x, y);
        this.radius = radius;
    }

    // Setter method for radius
    public void setRadius(double radius)
    {
        this.radius = radius;
    }

    // Getter method for radius
    public double getRadius()
    {
        return radius;
    }

    // Calculate and print area of the circle
    public void calculateAndPrintArea()
    {
        double area = Math.PI * radius * radius;
        System.out.println("Area of the circle: " + area);
    }

    // Calculate and print circumference of the circle
    public void calculateAndPrintCircumference()
    {
        double circumference = 2 * Math.PI * radius;
        System.out.println("Circumference of the circle: " + circumference);
    }
}

public class ADS
{
    public static void main(String[] args)
    {
        // Creating a PointType object representing the center of the circle
        PointType center = new PointType(3, 4);

        // Creating a CircleType object
        CircleType circle = new CircleType(center.getX(), center.getY(), 5);

        // Displaying center coordinates
        center.display();

        // Displaying radius of the circle
        System.out.println("Radius of the circle: " + circle.getRadius());

        // Calculating and printing area of the circle
        circle.calculateAndPrintArea();

        // Calculating and printing circumference of the circle
        circle.calculateAndPrintCircumference();
    }
}*/

/*class Self
{
    public static void main(String args[])
    {
        try
        {
            Scanner Sc=new Scanner(System.in);
            System.out.print("Enter Your Lucky Number: ");
            int Number=Sc.nextInt();
            if (Number>0)
            System.out.println("Your Lucky Number Is: "+Number);
            else
            throw new NumberFormatException();
        }
        catch (NumberFormatException e)
        {
            System.out.println("Error Ochi Vaii");
        }
    }
}*/

/*class Self
{
    public static void main(String args[])
    {
        Scanner Sc=new Scanner(System.in);
        System.out.print("Enter The Marks: ");
        int Marks=Sc.nextInt();
        try
        {
            if (Marks>100)
            throw new MarksException("Aukad Anusaar Marks");
            else if (Marks<100)
            System.out.println(Marks+" : Itna Aaya Hai");
            else if (Marks<0)
            throw new MarksException("Minus Mein Marks Sak Lo");
        }
        catch (MarksException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
class MarksException extends Exception
{
    MarksException(String Message)
    {
        super(Message);
    }
}*/


/*import java.util.ArrayList;
import java.util.Arrays;

public class Self {

    private int[] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0; // also working as index value

    public Self() {
        this.data = new int[DEFAULT_SIZE];
    }

    public void add(int num) {
        if (isFull()) {
            resize();
        }
        data[size++] = num;
    }

    private void resize() {
        int[] temp = new int[data.length * 2];

        // copy the current items in the new array
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    private boolean isFull() {
        return size == data.length;
    }

    public int remove() {
        int removed = data[--size];
        return removed;
    }

    public int get(int index) {
        return data[index];
    }

    public int size() {
        return size;
    }

    public void set(int index, int value) {
        data[index] = value;
    }

    @Override
    public String toString() {
        return "Self{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
//        ArrayList list = new ArrayList();
        Self list = new Self();
//        list.add(3);
//        list.add(5);
//        list.add(9);

        for (int i = 0; i < 14; i++) {
            list.add(2 * i);
        }

        System.out.println(list);

        ArrayList<Integer> list2 = new ArrayList<>();
//        list2.add("dfghj");
    }
}*/

/*class Self
{
    public static void main(String args[])
    {
    Object[] intar={1,2,3};
    Object[] doublear={1.6,2.3,4.6};
    printar(intar);
    printar(doublear);
    }
    public static void printar(Object[ ] ar)
    {
    for(int i=0;i<ar.length;i++)
    System.out.println(ar[i]);
    }
}*/

/*import java.util.ArrayList;
import java.util.function.Consumer;

public class Self
{
    public static void main(String[] args)
    {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 5; i++)
        {
            arr.add(i + 1);
        }
//      arr.forEach((item) -> System.out.println(item * 2));

        Consumer<Integer> fun = (item) -> System.out.println(item * 2);
        arr.forEach(fun);

        Operation sum = (a, b) -> a + b;
        Operation prod = (a, b) -> a * b;
        Operation sub = (a, b) -> a - b;

        Self myCalculator = new Self();
        System.out.println(myCalculator.operate(5, 3, sum));
        System.out.println(myCalculator.operate(5, 3, prod));
        System.out.println(myCalculator.operate(5, 3, sub));
    }

    private int operate(int a, int b, Operation op)
    {
        return op.operation(a, b);
    }
}
interface Operation
{
    int operation(int a, int b);
}*/

/*import java.util.ArrayList;
import java.util.Arrays;

public class Self
{
    private int[] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0; // also working as index value

    public Self()
    {
        this.data = new int[DEFAULT_SIZE];
    }

    public void add(int num)
    {
        if (isFull())
        {
            resize();
        }
        data[size++] = num;
    }

    private void resize()
    {
        int[] temp = new int[data.length * 2];
        // copy the current items in the new array
        for (int i = 0; i < data.length; i++)
        {
            temp[i] = data[i];
        }
        data = temp;
    }

    private boolean isFull()
    {
        return size == data.length;
    }

    public int remove()
    {
        int removed = data[--size];
        return removed;
    }

    public int get(int index)
    {
        return data[index];
    }

    public int size()
    {
        return size;
    }

    public void set(int index, int value)
    {
        data[index] = value;
    }

    @Override
    public String toString()
    {
        return "Self{" +"data=" + Arrays.toString(data) +", size=" + size +'}';
    }

    public static void main(String[] args) 
    {
//        ArrayList list = new ArrayList();
          Self list = new Self();
//        list.add(3);
//        list.add(5);
//        list.add(9);

        for (int i = 0; i < 14; i++)
        {
            list.add(2 * i);
        }

        System.out.println(list);

        ArrayList<Integer> list2 = new ArrayList<>();
//        list2.add("dfghj");
    }
}*/

/*class Self
{
    public static void main(String args[])
    {
        System.out.println("Generics Working --->");
        Box<Integer> intBox=new Box<>(20);
        Box<String> strBox=new Box<>("ADS");
        int a=intBox.getContent();
        System.out.println(a);
        String s=strBox.getContent();
        System.out.println(s);
    }
}
class Box <T>
{
    T content;
    Box(T content)
    {
        this.content=content;
    }
    public T getContent()
    {
        return content;
    }
}*/

/*import java.util.ArrayList;
import java.util.Arrays;

public class Self
{
    private int[] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0; // also working as index value

    public Self()
    {
        this.data = new int[DEFAULT_SIZE];
    }

    public void add(int num)
    {
        if (isFull())
        {
            resize();
        }
        data[size++] = num;
    }

    private void resize()
    {
        int[] temp = new int[data.length * 2];
        // copy the current items in the new array
        for (int i = 0; i < data.length; i++)
        {
            temp[i] = data[i];
        }
        data = temp;
    }

    private boolean isFull()
    {
        return size == data.length;
    }

    public int remove()
    {
        int removed = data[--size];
        return removed;
    }

    public int get(int index)
    {
        return data[index];
    }

    public int size()
    {
        return size;
    }

    public void set(int index, int value)
    {
        data[index] = value;
    }

    @Override
    public String toString()
    {
        return "Self{" +"data=" + Arrays.toString(data) +", size=" + size +'}';
    }

    public static void main(String[] args) 
    {
          ArrayList list = new ArrayList();
          //Self list = new Self();
          list.add(3);
          list.add(5);
          list.add(9);

        for (int i = 0; i < 14; i++)
        {
            list.add(2 * i);
        }

        System.out.println(list);

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("dfghj");

        for (int i = 0; i < 14; i++)
        {
            list2.add(i+"Hello");
        }

        System.out.println(list2);
    }
}*/

/*class Self
{
    public static void main(String args[])
    {
        int g=10,f=20,e=30,d=40,b=50,a=60;
        System.out.println((a+b+d)/(e-f)+g);
        System.out.println();
    }
}*/

/*class Box <T>
{
    T Content;
    Box(T Content)
    {
        this.Content=Content;
    }
    public T getContent()
    {
        return Content;
    }
}
class Self
{
    public static void main(String args[])
    {
        Box<Integer> Obj1=new Box<>(20);
        Box<String> Obj2=new Box<>("Sotantra");
        int a=Obj1.getContent();
        System.out.println(a);
        String b=Obj2.getContent();
        System.out.println(b);
    }
}*/

/*class Self
{
    public static void main(String args[])
    {
        //Integer Obj=new Integer(25);
        Integer Obj=2;
        Integer[] Abc={1,2,3};
        System.out.println(Abc[0]+Abc[1]+Abc[2]);
    }
}*/

/*class Self
{
    public static void main(String args[])
    {
        Object[] Obj1={1,2,3,5};
        Object[] Obj2={1.5,2,3,9.5};
        printArr(Obj1);
        printArr(Obj2);
    }
    public static void printArr(Object[] Arr)
    {
        for (Object Element: Arr)
        System.out.println(Element);
    }
}*/

/*class Self
{
    public static void main(String args[])
    {
        Integer[] Obj1={1,2,3,5};
        Double[] Obj2={1.5,2.5,3.2,9.5};
        printArr(Obj1);
        printArr(Obj2);
    }
    public static <Store> void printArr(Store[] Arr)
    {
        for (Object Element: Arr)
        System.out.println(Element);
    }
}*/

/*class Box <T extends Number>
{
    T[] Nums;
    Box(T[] Nums)
    {
        this.Nums=Nums;
    }
    public double findSum()
    {
        double sum=0;
        for (int i=0;i<Nums.length;i++)
        {
            sum+=Nums[i].doubleValue();
        }
        return sum;
    }
}
class Self
{
    public static void main(String args[])
    {
        Integer[] Obj={1,2,3,4,5};
        Box<Integer> Obj1=new Box<>(Obj);
        Double[] Objj={1.1,2.1,3.1,4.1,5.1};
        Box<Double> Obj2=new Box<>(Objj);
        double St=Obj1.findSum();
        System.out.println(St);
        double Stt=Obj1.findSum();
        System.out.println(Stt);
    }
}*/

/*class Self<T,U>
{
    T First;
    U Second;
    public Self(T First,U Second)
    {
        this.First=First;
        this.Second=Second;
    }
    public T getFirst()
    {
        return First;
    }
    public U getSecond()
    {
        return Second;
    }
    public static void main(String args[])
    {
        Self<String,Integer> Obj=new Self<>("ADS",10);
        System.out.print(Obj.getFirst());
        System.err.println(Obj.getSecond());
    }
}*/

/*class Box <T extends Number>
{
    T[] nums;
    Box(T[] Ob)
    {
        nums=Ob;
    }
    public double findSum()
    {
        double sum=0;
        for (int i=0;i<nums.length;i++)
        {
            sum+=nums[i].doubleValue();
        }
        return sum;
    }   
    boolean equalSum(Box<?> Obj)
    {
        if (findSum()==Obj.findSum())
        {
            return true;
        }
        return false;
    }
}
class Self
{
    public static void main(String args[])
    {
        Integer[] inums={2,3,4,5};
        Box<Integer> iob=new Box<>(inums);
        double s1=iob.findSum();
        System.err.println("S1: "+s1);
        Double[] dnums={2.5,3.5,4.5,5.5};
        Box<Double> dob=new Box<>(dnums);
        double s2=dob.findSum();
        System.err.println("S2: "+s2);
        if (iob.equalSum(dob))
        System.out.println("Sum Are Equal");
        else
        System.out.println("Sum Are Not Equal");
    }
}*/


/*public class Self
{

    private Node head;
    private Node tail;
    private int size;

    private class Node
    {
        private int value;
        private Node next;

        public Node(int value)
        {
            this.value = value;
        }

        public Node(int value, Node next)
        {
            this.value = value;
            this.next = next;
        }
    }

    public Self() 
    {
        this.size = 0;
    }

    public void insertFirst(int val) 
    {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null) 
        {
            tail = head;
        }
        size += 1;
    }

    public void insertLast(int val)
    {
        if (tail == null) 
        {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int val, int index) 
    {
        if (index == 0)
        {
            insertFirst(val);
            return;
        }
        if (index == size)
        {
            insertLast(val);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++)
        {
            temp = temp.next;
        }

        Node node = new Node(val, temp.next);
        temp.next = node;

        size++;
    }

    // insert using recursion
    public void insertRec(int val, int index)
    {
        head = insertRec(val, index, head);
    }

    private Node insertRec(int val, int index, Node node)
    {
        if (index == 0)
        {
            Node temp = new Node(val, node);
            size++;
            return temp;
        }

        node.next = insertRec(val, index-1, node.next);
        return node;
    }

    public int deleteFirst()
    {
        int val = head.value;
        head = head.next;
        if (head == null) 
        {
            tail = null;
        }
        size--;
        return val;
    }
    
    public int deleteLast()
    {
        if (size <= 1)
        {
            return deleteFirst();
        }

        Node secondLast = get(size - 2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        size--;
        return val;
    }

    public int delete(int index)
    {
        if (index == 0)
        {
            return deleteFirst();
        }
        if (index == size - 1)
        {
            return deleteLast();
        }

        Node prev = get(index - 1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        size--;
        return val;
    }

    public Node find(int value)
    {
        Node node = head;
        while (node != null)
        {
            if (node.value == value)
            {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public Node get(int index)
    {
        Node node = head;
        for (int i = 0; i < index; i++)
        {
            node = node.next;
        }
        return node;
    }

    public void display()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    // https://leetcode.com/problems/remove-duplicates-from-sorted-list
    /*public void duplicates() 
    {
        Node node = head;

        while (node.next != null)
        {
            if (node.value == node.next.value)
            {
                node.next = node.next.next;
                size--;
            } 
            else
            {
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
    }*/

    // https://leetcode.com/problems/merge-two-sorted-lists/submissions/
    /*public static Self merge(Self first, Self second)
    {
        Node f = first.head;
        Node s = second.head;

        Self ans = new Self();

        while (f != null && s != null)
        {
            if (f.value < s.value)
            {
                ans.insertLast(f.value);
                f = f.next;
            } 
            else 
            {
                ans.insertLast(s.value);
                s = s.next;
            }
        }

        while (f != null)
        {
            ans.insertLast(f.value);
            f = f.next;
        }

        while (s != null)
        {
            ans.insertLast(s.value);
            s = s.next;
        }

        return ans;
    }*/

    /*public void bubbleSort()
    {
        bubbleSort(size - 1, 0);
    }

    private void bubbleSort(int row, int col)
    {
        if (row == 0)
        {
            return;
        }

        if (col < row)
        {
            Node first = get(col);
            Node second = get(col + 1);

            if (first.value > second.value)
            {
                // swap
                if (first == head)
                {
                    head = second;
                    first.next = second.next;
                    second.next = first;
                } 
                else if (second == tail)
                {
                    Node prev = get(col - 1);
                    prev.next = second;
                    tail = first;
                    first.next = null;
                    second.next = tail;
                } 
                else 
                {
                    Node prev = get(col - 1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bubbleSort(row, col + 1);
        } 
        else
        {
            bubbleSort(row - 1, 0);
        }
    }*/

    // recursion reverse
    /*private void reverse(Node node)
    {
        if (node == tail)
        {
            head = tail;
            return;
        }
        reverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }*/

    // in place reversal of linked list
    // google, microsoft, apple, amazon: https://leetcode.com/problems/reverse-linked-list/
    /*public void reverse()
    {
        if (size < 2)
        {
            return;
        }

        Node prev = null;
        Node present = head;
        Node next = present.next;

        while (present != null)
        {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null)
            {
                next = next.next;
            }
        }
        head = prev;
    }*/

    /*public static void main(String[] args)
    {
        Self first = new Self();
        Self second = new Self();

        first.insertFirst(1);
        first.insertFirst(2);
        first.insertFirst(3);
        first.insertFirst(4);
        first.insertFirst(5);
        first.display();

        first.insertLast(1);
        first.insertLast(3);
        first.insertLast(5);
        first.display();

        first.insertRec(6, 5);
        first.display();

        /*first.find(3);
        first.get(2);*/

        /*second.insertLast(1);
        second.insertLast(2);
        second.insertLast(9);
        second.insertLast(14);*/

        /*Self ans = Self.merge(first, second);
        ans.display();*/

        /*Self list = new Self();
        for (int i = 7; i > 0; i--)
        {
            list.insertLast(i);
        }
        list.display();
        //list.bubbleSort();
        //list.display();

    }
}*/

class Self
{

    static class Node
    {
        int regd_no;
        float mark;
        Node next;

        Node(int regd_no, float mark)
        {
            this.regd_no = regd_no;
            this.mark = mark;
            this.next = null;
        }
    }

    private static Node head = null;
    private static Node tail = null;
    private static int size = 0;

    public static void main(String[] args)
    {
        System.out.println("The Choice Available Are--->");
        Scanner sc = new Scanner(System.in);
        while (true) 
        {
            System.out.println("0: EXIT");
            System.out.println("1: CREATION");
            System.out.println("2: DISPLAY");
            System.out.println("3: SEARCH");
            System.out.println("4: SORT (Higher to Lower)");
            System.out.println("5: COUNT");
            System.out.println("6: REVERSE");
            System.out.print("Enter The Choice: ");
            int choice = sc.nextInt();
            switch (choice)
            {
                case 0:
                    System.exit(0);
                case 1:
                    create();
                    break;
                case 2:
                    display(head);
                    break;
                case 3:
                    System.out.print("Enter the regd_no to search: ");
                    int regd = sc.nextInt();
                    search(head, regd);
                    break;
                case 4:
                    sort(head);
                    display(head);
                    break;
                case 5:
                    int count = count(head);
                    System.out.println("Total nodes in the list: " + count);
                    break;
                case 6:
                    head = reverse(head);
                    display(head);
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        }
    }

    public static void create()
    {
        System.out.println("Enter The Singly Creation List");
        Scanner sc = new Scanner(System.in);
        int regd_no;
        do 
        {
            System.out.println("Enter The Redg No And Marks (-1,-1) To Exit:");
            regd_no = sc.nextInt();
            if (regd_no != -1) 
            {
                float mark = sc.nextFloat();
                head = InsBeg(head, regd_no, mark); // Create by inserting at the beginning
            }
        } 
        while (regd_no != -1);
    }

    public static Node InsBeg(Node head, int regd_no, float mark) 
    {
        Node node = new Node(regd_no, mark);
        node.next = head;
        head = node;
        if (tail == null) 
        {
            tail = head;
        }
        size++;
        return head;
    }

    public static void display(Node start) 
    {
        Node current = start;
        while (current != null) 
        {
            System.out.println("Regd No: " + current.regd_no + ", Marks: " + current.mark);
            current = current.next;
        }
    }

    public static void search(Node start, int regd) 
    {
        Node current = start;
        boolean found = false;
        int position = 0;
        while (current != null) 
        {
            position++;
            if (current.regd_no == regd) 
            {
                found = true;
                break;
            }
            current = current.next;
        }
        if (found) 
        {
            System.out.println("Regd No " + regd + " found at position " + position);
        } 
        else 
        {
            System.out.println("Regd No " + regd + " not found in the list");
        }
    }

    public static void sort(Node start) 
    {
        if (start == null || start.next == null) 
        {
            return;
        }
        Node current = start;
        while (current != null) 
        {
            Node index = current.next;
            while (index != null) 
            {
                if (current.mark < index.mark) 
                {
                    float tempMark = current.mark;
                    current.mark = index.mark;
                    index.mark = tempMark;
                    int tempRegd = current.regd_no;
                    current.regd_no = index.regd_no;
                    index.regd_no = tempRegd;
                }
                index = index.next;
            }
            current = current.next;
        }
    }

    public static int count(Node start) 
    {
        int count = 0;
        Node current = start;
        while (current != null)
        {
            count++;
            current = current.next;
        }
        return count;
    }

    public static Node reverse(Node start)
    {
        Node prev = null;
        Node current = start;
        Node next = null;
        while (current != null) 
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        start = prev;
        return start;
    }
}