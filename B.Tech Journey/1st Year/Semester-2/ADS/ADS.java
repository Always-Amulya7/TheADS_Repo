/*import java.util.Scanner;
class Bank
{
    String Name;
    long Account_No;
    int Balance = 0, Withdraw = 0, DBalance=0, WBalance=0;

    void Banking(String Name, long Account_No)
    {
        this.Name = Name;
        this.Account_No = Account_No;
        System.out.println("Account Holder Name: " + Name);
        System.out.println("Account Number: " + Account_No);
        System.err.println();
    }

    void Balance(int Balance)
    {
        this.Balance=Balance;
    }
    public void Deposit(int Deposit) 
    {
        DBalance = Balance + Deposit;
        System.out.println("Amount Deposited: " + Deposit);
        System.out.println("Updated Balance: " + DBalance);
        System.err.println();
    }

    public void Withdraw(int Withdraw)
     {
        if (Withdraw > DBalance) 
        {
            System.out.println("Insufficient Balance.");
        } 
        else 
        {
            WBalance = DBalance - Withdraw;
            System.out.println("Amount Withdrawn: " + Withdraw);
            System.out.println("Updated Balance: " + WBalance);
            System.err.println();
        }
    }

    public void checkBalance() 
    {
        System.out.println("Balance Is: " + WBalance);
        System.err.println();
    }

    public void checkCibil()
    {
        System.out.println("Cibil Score: " + (WBalance * 10));
        System.err.println();
    }
}
public class ADS
{
    public static void main(String args[]) 
    {
        try (Scanner sc = new Scanner(System.in)) 
        {
            System.out.print("Enter User Name: ");
            String Name = sc.next();
            System.out.print("Enter User Account Number: ");
            long Account_No = sc.nextLong();
            System.out.print("Enter The Present Balance: ");
            int Balance = sc.nextInt();
            System.out.print("Enter The Deposit: ");
            int Deposit = sc.nextInt();
            System.out.print("Enter The Withdraw: ");
            int Withdraw = sc.nextInt();
            System.out.println();
            Bank ob = new Bank();
            ob.Banking(Name, Account_No);
            ob.Balance(Balance);
            ob.Deposit(Deposit);
            ob.Withdraw(Withdraw);
            ob.checkBalance();
            ob.checkCibil();
        }
    }
}*/

/*class Student
{
    String Name;
    int Age;
    void Talk()
    {
        System.out.println("Hi I Am "+Name);
        System.out.println("My Age Is "+Age);
    }
}
class ADS
{
    public static void main(String[] args)
    {
        Student Amulya=new Student();
        Amulya.Name="Amulya";
        Amulya.Age=19;
        Amulya.Talk();
        Student AmulyaKing=new Student();
        AmulyaKing.Name="Duggu";
        AmulyaKing.Age=19;
        AmulyaKing.Talk();
    }
}*/

/*class Student
{
    String Name;
    int Age;
    void Set(String N,int A)
    {
        N=Name;
        A=Age;
        System.out.println(Name);
        System.out.println(Age);
    }
}
class ADS
{
    public static void main(String args[])
    {
        Student Raju;
        Raju=new Student();
        Raju.Name="Raju";
        Raju.Age=19;
        Raju.Set(Raju.Name,Raju.Age);
    }
}*/

/*class Student
{
    String Name;
    int Age;
    void Set(String N, int A)
    {
        Name=N;
        Age=A;
    }
    void Display()
    {
        System.out.println(Name);
        System.out.println(Age);
    }
}
class ADS
{
    public static void main(String args[])
    {
        Student S1=new Student();
        S1.Set("Raju",20);
        S1.Display();
        Student S2=new Student();
        S2.Set("Rani",19);
        S2.Display();
    }
}*/

/*class Book
{
    String Book_Name,Author_Name;
    int Page;
    void Display1(String Book_Name, String Author_Name, int Page)
    {
        this.Book_Name=Book_Name;
        this.Author_Name=Author_Name;
        this.Page=Page;
        System.out.println("Book="+this.Book_Name);
        System.out.println("Author="+this.Author_Name);
        System.out.print("Page="+this.Page);
    }
}
class ADS
{
    public static void main(String[] args)
    {
        Book ob=new Book();
        ob.Display1("Harry Potter", "J.K.Rowling", 756);
    }
}*/

/*class ADS
{
    public static void main(String args[])
    {
        final int A=10;
        System.out.print(A);
    }
}*/

/*class BOX
{
    double Length,Breadth;
    BOX(double Length,double Breadth)
    {
        this.Length=Length;
        this.Breadth=Breadth;
    }
    void Display()
    {
        System.out.println("Length Is:-"+this.Length);
        System.out.println("Length Is:-"+this.Breadth);
    }
}
class ADS
{
    public static void main(String args[])
    {
        BOX ob=new BOX(5.5,3.7);
        ob.Display();
    }
}*/

/*class Student
{
    int Age;
    String Name;
    Student(String Name,int Age)
    {
        this.Name=Name;
        this.Age=Age;
    }
    boolean Check(Student s)
    {
        if (s.Age==Age)
        return true;
        else
        return false;
    }
    void Display(boolean B1,boolean B2)
    {
        System.out.print(B1+" "+B2);
    }
}
class ADS
{
    public static void main(String args[])
    {
        Student S1=new Student("Raju",20);
        Student S2=new Student("Rani",20);
        Student S3=new Student("Rashmi",18);
        boolean B1=S1.Check(S2);
        boolean B2=S2.Check(S3);
        Display(B1,B2);
    }
}*/

/*class Area
{
    double l,b,h;
    Area(double l1,double b1,double h1)
    {
        this.l=l1;
        this.b=b1;
        this.h=h1;
    }
    double Area1()
    {
        return (l*b*h);
    }
}
class ADS
{
    public static void main(String args[])
    {
        Area Arr=new Area(5.5,6.5,7.5);
        double Area=Arr.Area1();
        System.out.print("The Area Is "+Area);
    }
}*/

/*class ADS
{
    public static void main(String args[])
    {
        final double CGPA=8;
        System.out.println(CGPA);
    }
}*/

/*class Student
{
    String Name;
    int Age;
    Student(String Name,int Age)
    {
        this.Name=Name;
        this.Age=Age;
    }
    void Display()
    {
        System.out.println(this.Name);
        System.out.println(this.Age);
    }
}
class ADS
{
    public static void main(String args[])
    {
        Student[] MyList=new Student[3];
        MyList[0]=new Student("Raju",20);
        MyList[1]=new Student("Rocky",20);
        MyList[2]=new Student("Rani",18);
        for (int i=0;i<MyList.length;i++)
        {
            MyList[i].Display();
        }
    }
}*/

/*class Student
{
    String Name;int Age;
    class UGStudent
    {
        String Name;
        int Age;
        String Major;
    }
    class Employee
    {
        int Eid;
        String Name,Department;
    }
    class Manager extends Employee
    {
        int Team_Size;
        int Experience;
    }
}*/

/*class Student
{
    String Name;
    int Age;
    void SetStudent(String Name, int Age)
    {
        this.Name = Name;
        this.Age = Age;
    }
    class UGStudent extends Student
    {
        String Major;
        UGStudent(String Name, int Age, String Major)
        {
            super.SetStudent(Name, Age); // Call SetStudent method of the outer class
            this.Major = Major;
            System.out.println(this.Major);
        }
    }
    void Display()
    {
        System.out.print(Name + " " + Age + " ");
    }
}
public class ADS
{
    public static void main(String args[])
    {
        Student student = new Student();
        Student.UGStudent ugStudent = student.new UGStudent("Amulya", 19, "CSE");
        ugStudent.Display();
    }
}*/


/*class Student
{
    private String Name;
    private int Age;

    Student(String Name, int Age) 
    {
        this.Name = Name;
        this.Age = Age;
    }

    class UGStudent extends Student
    {
        String Major;

        UGStudent(String Name, int Age, String Major) 
        {
            super(Name, Age);
            this.Major = Major;
            System.out.println(this.Major);
        }
    }

    void Display()
    {
        System.out.print(Name + " " + Age + " ");
    }
}

public class ADS 
{
    public static void main(String args[])
    {
        Student.UGStudent ugStudent = new Student("Amulya", 19).new UGStudent("Amulya", 19, "CSE");
        ugStudent.Display();
    }
}*/

/*interface Shape
{
    void Calculate_Area();
    void Calculate_Perimeter();
}
class Rectangle implements Shape
{
    public void Calculate_Area()
    {
        System.out.println("The Area Of Rectangle: "+(10*5));
    }
    public void Calculate_Perimeter()
    {
        System.out.println("The Peimeter Of Rectangle: "+(2*(10+5)));
    }
}
class Circle implements Shape
{
    public void Calculate_Area()
    {
        System.out.println("The Area Of Circle: "+(Math.PI*10*10));
    }
    public void Calculate_Perimeter()
    {
        System.out.println("The Peimeter Of Circle: "+(2*Math.PI*10));
    }
}
class ADS
{
    public static void main(String args[])
    {
        Shape S1=new Rectangle();
        S1.Calculate_Area();
        S1.Calculate_Perimeter();
        Shape S2=new Circle();
        S2.Calculate_Area();
        S2.Calculate_Perimeter();
    }
}*/

/*abstract class Marks 
{
    protected int markICP;
    protected int markDSA;
    protected double percentage;
    abstract void getPercentage();
}

class CSE extends Marks
{
    private int algoDesign;
    CSE(int markICP, int markDSA, int algoDesign)
     {
        this.markICP = markICP;
        this.markDSA = markDSA;
        this.algoDesign = algoDesign;
    }
    void getPercentage()
    {
        percentage = (markICP + markDSA + algoDesign) / 3.0;
        System.out.println("Percentage of CSE student: " + percentage);
    }
}

class NonCSE extends Marks
{
    private int enggMechanics;
    NonCSE(int markICP, int markDSA, int enggMechanics)
    {
        this.markICP = markICP;
        this.markDSA = markDSA;
        this.enggMechanics = enggMechanics;
    }
    void getPercentage()
    {
        percentage = (markICP + markDSA + enggMechanics) / 3.0;
        System.out.println("Percentage of NonCSE student: " + percentage);
    }
}
public class ADS
{
    public static void main(String[] args)
    {
        CSE cseStudent = new CSE(80, 85, 90);
        NonCSE nonCseStudent = new NonCSE(75, 78, 82);
        cseStudent.getPercentage();
        nonCseStudent.getPercentage();
    }
}*/


/*abstract class DetailInfo
{
    abstract void display(String name);
    abstract void count();
}
class Person extends DetailInfo
{
    static int maxcount=0;
    String name;
    void display(String name)
    {
        this.name=name;
        System.out.println("Name: "+name);
    }
    void count()
    {
        for (int i=0;i<name.length();i++)
        {
            maxcount++;
        }
        System.out.println("The Total Letters Are: "+maxcount);
    }
}
class ADS
{
    public static void main(String args[])
    {
        Person P1=new Person();
        P1.display("Amulya");
        P1.count();
    }
}*/

// Mid Sem Paper Solution


/*class ADS
{
    static int x=-55;
    public static void main(String args[])
    {
        ADS obj=new ADS();
        obj.x=obj.x*2-66;
        System.out.println(obj.x);
        ADS obj1=new ADS();
        obj1.x=obj1.x*2+66;
        System.out.print(obj.x+" "+obj1.x);
    }
    static
    {
        System.out.println(x);
    }
}*/

/*public class ADS
{
    public static final int x=4;
    public static void main(String args[])
    {
        int a=10,b=5;
        switch (a<b?a:b-1)
        {
            case 5:System.out.println("Wow");
            break;
            case 3:System.out.println("It's Working");
            break;
            case x:System.out.println("Ohhh...");
            break;
            default:System.out.println("Fine");
        }
    }
}*/

/*abstract class ADS
{
    private String bankName;
    ADS(String bankName)
    {
        this.bankName=bankName;
    }
    public String getBankName()
    {
        return "Your Bank Is:"+bankName;
    }
}
class P2 extends ADS
{
    P2()
    {
        super("SBI");
        super("Axis");
    }
}
public static void main(String args[])
{
    ADS bank=new P2();
    System.out.println(ADS.getBankName());
}*/

/*class Complex
{
    int real,imag;
    Complex()
    {
        real=0;
        imag=0;
    }
    void display()
    {
        System.out.print("Number Set: "+real+"+("+imag+")");
    }
    void add()
    {
        Complexadd();
    }
    public Complex add(Complex C1,Complex C2)
    {
        int RealSum=C1.real+C2.real;
        int CompSum=C1.imag+C2.imag;
        int 
    }
}
class ADS
{
    public static void main(String args[])
    {
        Complex C1=new Complex(5,6);
        C1.display();
        Complex C2=new Complex(7,8);
        C2.display();
        add();
    }
}*/


//All Assignment Compiled

/*import java.util.Scanner;
class ADS
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter An +ve Integer Greater Than 2: ");
            int Num=sc.nextInt();
            if (Num<2)
            System.out.println("Enter The Correct Output");
            System.out.println("The Number Entered Is: "+Num);
            int Count=0;
            while(Num>2)
            {
                Num/=2;
                Count++;
            }
            System.out.println("The Last Divisibility Is Till "+Count);
        }
    }
}*/

/*import java.util.Scanner;
class BMI
{
    private double Weight,Height;
    BMI()
    {
        Weight=0;
        Height=0;
    }
    BMI(double weight,double height)
    {
        this.Weight=weight;
        this.Height=height;
        System.out.println("The Weight In Kilograms Is: "+Weight);
        System.out.println("The Height In Meters Is: "+Height);
    }
    double Calc_BMI(double weight, double height)
    {
        double BMI= weight/(height*height);
        return BMI;
    }
}
class ADS
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter Weight in Kgs: ");
            double Weight=sc.nextDouble();
            System.out.print("Enter Height in Meter: ");
            double Height=sc.nextDouble();
            BMI Ob=new BMI(Weight,Height);
            double Value=Ob.Calc_BMI(Weight,Height);
            String Store="";
            if (Value<18.5)
            Store="Underweight";
            else if (Value>=18.5 && Value<=24.9)
            Store="Normal Weight";
            else if (Value>=25.0 && Value<=29.9)
            Store="Overweight";
            else
            Store="OBESE";
            System.out.println("The Body Mass Index= "+Value);
            System.out.println(Store);
        }
    }
}*/

/*class Spy
{
    int DigitSum=0,ProductSum=1;
    void Display(int Num)
    {
        System.out.println("The Number Input Was "+Num);
    }
    boolean Calculate(int Num)
    {
        int originalNum = Num;
        while(Num!=0)
        {
            int digit=Num%10;
            DigitSum+=digit;
            ProductSum*=digit;
            Num/=10;
        }
        return (DigitSum==ProductSum);
    }
}
class ADS
{
    public static void main(String args[])
    {
        int Number=132;
        Spy Ob=new Spy();
        Ob.Display(Number);
        boolean Res=Ob.Calculate(Number);
        System.out.println(Number+" Is Spy Number? "+Res);
    }
}*/

/*class ADS
{
    public static void main(String args[])
    {
        System.out.println("The Word Is: CARBON");
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
                                if (i != j && i != k && i != l && i != m && i != n &&
                                        j != k && j != l && j != m && j != n &&
                                        k != l && k != m && k != n &&
                                        l != m && l != n &&
                                        m != n)
                                System.out.println(""+Arr[i]+Arr[j]+Arr[k]+Arr[l]+Arr[m]+Arr[n]);
                            }
                        }
                    }
                }
            }
        }
    }
}*/

/*class ADS
{
    public static void main(String args[])
    {
        System.out.println("The Word Is: CAR");
        char Arr[]={'C','A','R'};
        for (int l=0;l<Arr.length;l++)
        {
            for (int m=0;m<Arr.length;m++)
            {
                for (int n=0;n<Arr.length;n++)
                {
                    if (l!=m && l!=n && m!=n)
                    System.out.println(""+Arr[l]+Arr[m]+Arr[n]);
                }
            }
        }
    }
}*/

/*import java.util.*;
class ADS
{
    public static int Sum(int Number)
    {
        int Sum = 0;
        while (Number > 0) { // Change the condition to Number > 0
            Sum += Number % 10;
            Number = Number / 10;
        }
        return Sum;
    }

    public static void main(String args[])
    {
        try (Scanner sc = new Scanner(System.in)) 
        {
            System.out.print("The Number Is: ");
            int Num = sc.nextInt();
            int Store = Sum(Num);
            while (Store >= 10) 
            { // Add a loop to handle the case when the sum is not a single digit
                Store = Sum(Store);
            }
            System.out.println("The Sum Of The number Until It Is Single Digit Is: " + Store);
        }
    }
}*/

/*class ADS
{
    public static boolean isOdd(int Num)
    {
        return ((Num & 1)==1);
    }
    public static void main(String args[])
    {
        int Num=Integer.parseInt(args[0]);
        System.out.println("The Number Is: "+Num);
        System.err.println("The Number "+Num+" Is Odd? "+isOdd(Num));
    }
}*/

/*import java.util.Scanner;
public class ADS
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
}*/

/*import java.util.Scanner;
class ADS
{
    public static void main(String args[])
    {
        int Arr[][]=new int[3][3];
        Scanner sc=new Scanner(System.in);
        for (int i=0;i<Arr.length;i++)
        {
            for (int j=0;j<Arr.length;j++)
            {
                System.out.print("Enter The Element At "+(i+1)+""+(j+1)+" : ");
                Arr[i][j]=sc.nextInt();
            }
        }
        System.out.println("The Matrix Of 3 x 3 Is:");
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
        System.out.println("The Sum Is: "+Sum);
    }
}*/

/*import java.util.Scanner;
class ADS
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter The Size Of The Matrix: ");
            int m=sc.nextInt();
            int n=sc.nextInt();
            double[][] Arr=new double[m][n];
            for (int i=0;i<Arr.length;i++)
            {
                for (int j=0;j<Arr.length;j++)
                {
                    System.out.print("Enter The Element At "+(i+1)+""+(j+1)+" : ");
                    Arr[i][j]=sc.nextDouble();
                }
            }
            System.out.println("The Sum Of 2-D Matrix Is: "+sumMajorDiagonal(Arr));
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

/*import java.util.Scanner;
class ADS
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter The Size Of Matrix: ");
            int m=sc.nextInt();
            int n=sc.nextInt();
            double Arr[][]=new double[m][n];
            for (int i=0;i<Arr.length;i++)
            {
                for (int j=0;j<Arr.length;j++)
                {
                    System.out.print("Enter The Element At "+(i+1)+""+(j+1)+" : ");
                    Arr[i][j]=sc.nextDouble();
                }
            }
            for (int i=0;i<Arr.length;i++)
            {
                for (int j=0;j<Arr.length;j++)
                {
                    System.out.print(Arr[i][j]+" ");
                }
                System.out.println();
            }
            System.out.print("Enter The Column Choice: ");
            int Col=sc.nextInt();
            System.out.println("The Sum Is: "+sumColumn(Arr,Col));
        }
    }
    public static double sumColumn(double[][] m, int columnIndex)
    {
        int Sum=0;
        int[] ColSum=new int[m.length];
        for (int i=0;i<m.length;i++)
        {
            for (int j=0;j<m.length;j++)
            {
                ColSum[i]+=m[j][i];
            }
        }
        return ColSum[columnIndex];
    }
}*/

/*import java.util.*;
class Column_Sum
{
    void Display()
    {
        System.out.print("Enter The Size Of The Matrix: ");
    }
    Column_Sum()
    {
        try(Scanner sc=new Scanner(System.in))
        {
            Display();
            int m=sc.nextInt();
            int n=sc.nextInt();
            double Arr[][]=new double[m][n];
            for (int i=0;i<Arr.length;i++)
            {
                for (int j=0;j<Arr.length;j++)
                {
                    System.out.print("Enter The Element At "+(i+1)+""+(j+1)+" : ");
                    Arr[i][j]=sc.nextDouble();
                }
            }
            for (int i=0;i<Arr.length;i++)
            {
            for (int j=0;j<Arr.length;j++)
            {
                System.out.print(Arr[i][j]+" ");
            }
            System.out.println();
            }
        }
    }
    public static double sumColumn(double[][] m, int columnIndex)
    {
        int Sum=0;
        int[] ColSum=new int[m.length];
        for (int i=0;i<m.length;i++)
        {
            for (int j=0;j<m.length;j++)
            {
                ColSum[i]+=m[j][i];
            }
        }
        return ColSum[columnIndex];
    }
}
class ADS
{
    public static void main(String args[])
    {
        Column_Sum Ob=new Column_Sum();
        System.out.println("The Sum Of The ColumnIndex: "+Ob.sumColumn(Column_Sum.Arr,3))
    }
}*/

/*import java.util.*;
class Arithmetic
{
    public static final int Number=10;
    void Display()
    {
        System.out.println("To Be Checked Whether The Sequence Is In Arithmetic Series Or Not");
    }
    public static void Check(int a,int b,int c) 
    {
        if (a+b==c || a==b-c || a*b==c)
        System.out.println("In Arithmetic Series");
        else
        System.out.println("Not In Arithmetic Series");
    }
}
class ADS
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            int a=Integer.parseInt(args[0]);
            int b=Integer.parseInt(args[1]);
            int c=Integer.parseInt(args[2]);
            Arithmetic Ob=new Arithmetic();
            Ob.Display();
            Ob.Check(a, b, c);
            Arithmetic Obb=new Arithmetic();
            Obb.Display();
            Obb.Check(5,6,7);
        }
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
class ADS
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
class ADS
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
        System.out.println("The scalar product of the vectors is: " + obj.Vector(Vector1, Vector2));}
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
class ADS
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

/*import java.util.*;
import java.lang.*;
class ADS
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        try
        {
            System.out.print("Enter Your Lucky Number: ");
            int Number=sc.nextInt();
            if (Number<0)
            throw new NumberFormatException("Enter +ve No Only");
            System.out.print("Your Lucky Number Is: "+Number);
        }
        catch (NumberFormatException e)
        {
            System.out.println("Enter Only +ve Number");
        }
    }
}*/

/*import java.util.*;
import java.lang.*;
class ADS
{
    public static void main(String args[])
    {
        try
        {
            Scanner sc=new Scanner(System.in);
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

/*import java.util.*;
import java.lang.*;
public class ADS
{
    public static void main(String args[])
    {
        try
        {
            Scanner sc=new Scanner(System.in);
            System.out.println("Student Is Amulya Shrivastava");
            System.out.print("Enter The Marks: ");
            int Marks=sc.nextInt();
            if (Marks>100)
            throw new MarksOutOfBoundException("Enter Marks Correctly");
            System.out.println("The Marks Of The Student Is: "+Marks);
        }
        catch (MarksOutOfBoundException e)
        {
            System.out.println("Enter Marks Between 0-100");
        }
    }
}*/

/*class Person
{
    String Name;
    int Age;
    void setData(String Name,int Age)
    {
        this.Name=Name;
        this.Age=Age;
    }
    void displayData()
    {
        System.out.println("Name Of The Student: "+Name);
        System.out.println("Age Of The Student: "+Age);
    }
}
class ADS
{
    public static void main(String args[])
    {
        Person P1=new Person();
        P1.Name="Rohan";
        P1.Age=20;
        P1.displayData();
        Person P2=new Person();
        P2.setData("Amulya", 19);
        P2.displayData();
        if (P1.Age>P2.Age)
        System.out.print(P2.Name+" Is Younger");
        else
        System.out.print(P1.Name+" Is Younger");
    }
}*/

/*import java.util.*;
class Complex
{
    double Real,Imag;
    void setData(double Real,double Imag)
    {
        this.Real=Real;
        this.Imag=Imag;
    }
    void display()
    {
        System.out.println(Real+((Imag>0)?"+":"-")+Math.abs(Imag)+"i");
    }
    Complex add(Complex C1,Complex C2)
    {
        Complex C3=new Complex();
        C3.Real=C1.Real+C2.Real;
        C3.Imag=C1.Imag+C2.Imag;
        return C3;
    }
}
public class ADS
{
    public static void main(String[] args)
    {
        try(Scanner sc=new Scanner(System.in))
        {
            double Real,Imag;
            Complex C1=new Complex();
            System.out.print("Enter Real And Imag Part For 1: ");
            Real=sc.nextDouble();
            Imag=sc.nextDouble();
            C1.setData(Real, Imag);
            Complex C2=new Complex();
            System.out.print("Enter Real And Imag Part For 2: ");
            Real=sc.nextDouble();
            Imag=sc.nextDouble();
            C2.setData(Real, Imag);
            System.out.println("C1 Is :");
            C1.display();
            System.out.println("C2 Is :");
            C2.display();
            System.out.println("The Sum Is: ");
            Complex C3=C1.add(C1, C2);
            C3.display();
        }
    }
}*/

/*import java.util.Scanner;
class Product
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
class ADS
{
    public static void main(String args[])
    {
        System.out.println("Welcome To ADS Mart");
        try(Scanner sc=new Scanner(System.in))
        {
            Product P[]=new Product[5];
            P[0]=new Product("A",10.0,2);
            P[1]=new Product("B",15.0,3);
            P[2]=new Product("C",20.0,1);
            P[3]=new Product("D",25.0,4);
            P[4]=new Product("E",30.0,2);
            /*System.out.print("Items Purchased: ");
            int Pur=sc.nextInt();
            Product P[]=new Product[Pur];
            String Store;
            double Pr;
            int q;
            System.out.println("Shopping Items--->\n");
            for (int i=0;i<P.length;i++)
            {
                System.out.print("ProductID: ");
                Store=sc.next();
                System.out.print("Price: $ ");
                Pr=sc.nextDouble();
                System.out.print("Quantity: ");
                q=sc.nextInt();
                System.out.println("*************");
                P[i]=new Product(Store,Pr,q);
            }
            System.out.println();
            System.out.println("The Bill--->\n");*/
            /*for (int i=0;i<P.length;i++)
            {
                P[i].display();
            }
            System.out.println("Total Price: $ "+Product.totalprice);
        }
    }
}*/

/*import java.util.*;
class Deposit
{
    long Principal;
    int Time;
    double Rate,TotalAmount;
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
        System.out.println(Principal+"\t\t"+Rate+"\t"+Time+"\t"+TotalAmount);
    }
    double calc_amt()
    {
        TotalAmount=Principal+(Principal*Rate*Time)/100;
        return TotalAmount;
    }
}
class ADS
{
    public static void main(String args[])
    {
        System.err.println("Principal\tRate\tTime\tTotal Amount");
        Deposit SBI=new Deposit(5_000,8.0,1);
        SBI.calc_amt();
        SBI.Display();
        Deposit BOI=new Deposit(6_000,3.0,2);
        BOI.calc_amt();
        BOI.Display();
        Deposit PNB=new Deposit(45_000,6.0,3);
        PNB.calc_amt();
        PNB.Display();
    }
}*/

/*import java.util.*;
class Person
{
    String Name;
    int Age;
    Person(String Name,int Age)
    {
        this.Name=Name;
        this.Age=Age;
    }
}
class Employee extends Person
{
    int EId;
    double Salary;
    Employee(String Name,int Age,int EId,double Salary)
    {
        super(Name,Age);
        this.EId=EId;
        this.Salary=Salary;
    }
    void empDisplay()
    {
        System.out.println(Name+"\t"+Age+"\t"+EId+"\t"+Salary);
    }
}
class ADS
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

/*import java.util.*;
abstract class Marks
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
class ADS
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

public class ADS 
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

/*import java.util.*;
class Commission
{
    double Sales;
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
class ADS
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

/*import java.util.*;
class Book
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

public class ADS 
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


/*class ADS
{
    public static void main(String args[])
    {
        int[] arr={1,2,3};
        int i=Integer.parseInt(args[0]);
        try
        {
            System.out.println(arr[i]);
            System.out.println(100/i);
        }
        catch(Exception e)
        {
            System.out.println("Enter Valid Index");
        }
        /*catch(ArrayIndexOutOfBoundsException e)
        {
            System.err.println("Enter Correctly");
        }
    }
}*/

/*class ADS
{
    public static void main(String args[])
    {
        java.util.Scanner sc=new java.util.Scanner();
        String Save=sc.next();
        System.out.println(Save);
    }
}*/

/*class Biryani
{
    void taste()
    {
        System.out.println("Hydrabadi Dum Biryani");
    }
}
class Mybiryani extends Biryani
{
    void taste()
    {
        System.out.println("Kolkata Biryani");
    }
}
class ADS
{
    public static void main(String args[])
    {
        Biryani Obj=new Biryani();
        {
            void taste()
            {
                System.out.println("KKR Biryani");
            }
            Obj.taste();
        }
        
    }
}*/

/*class Company
{
    String Name="Amulya";
    static class Employee
    {
        String Name,ID;
        void Display(String Name,String ID)
        {
            this.Name=Name;
            this.ID=ID;
            System.out.println(Name);
            System.out.println(ID);
        }
    }
}
class ADS
{
    public static void main(String args[])
    {
        Company.Employee Obj=new Company.Employee();
        Obj.Display("Amulya","12542");
        Company ob=new Company();
        System.out.println(ob.Name);
    }
}*/

/*class Person
{
    public static String Street,City,pincode;
    static class Address
    {
        void details(String St,String Ct,String pin)
        {
            System.out.println("Street="+St);
            System.out.println("City="+Ct);
            System.out.println("Pin Code="+pin);
        }
    }
    void details()
    {
        System.out.println("Street="+Street);
        System.out.println("City="+City);
        System.out.println("Pin Code="+pincode);
    }
}
class ADS
{
    public static void main(String args[])
    {
        Person Obj=new Person();
        Obj.Street="Lane-6";
        Obj.City="Ranchi";
        Obj.pincode="834009";
        Obj.details();
        Person.Address Ob=new Person.Address();
        Ob.details("Lane-6", "Ranchi", "834009");
    }
}*/

/*interface Animal
{
    static int Sum=5;
    void makesound();
}
class Dog implements Animal
{
    public void makesound()
    {
        System.out.println("Dog Sound");
    }
}
class Cat implements Animal
{
    public void makesound()
    {
        System.out.println("Cat Sound");
    }
}
class ADS
{
    public static void main(String args[])
    {
        Dog a=new Dog();
        a.makesound();
        Cat b=new Cat();
        b.makesound();
    }
}*/

/*class Person
{
    String Name="Amulya";
    void Display()
    {
        System.out.println("Enter Person Class");
    }
}
class Employee extends Person
{
    void Display()
    {
        System.out.println("In Employee Class "+Name);
    }
}
class ADS
{
    public static void main(String args[])
    {
        /*Person ob=new Person();
        ob.Display();
        Employee Obj=new Employee();
        Obj.Display();
        Person ob=new Employee();
        ob.Display();
        ob.Display();
    }
}*/

/*class vehicle
{
    int no=7;
    int getWeheels()
    {
        return no;
    }
}
class ADS
{
    public static void main(String args[])
    {
        vehicle v=new vehicle();
        System.out.println(v.getWeheels());
    }
}*/

/*class Student
{
    String Name;
    int Age;
    void SetStudent(String name,int age)
    {
        this.Name=name;
        this.Age=age;
    }
}
class UGStudent extends Student
{
    String Major;
    void SetStudent(String name,int age,String major)
    {
        this.Name=name;
        this.Age=age;
        this.Major=major;
    }
}
class ADS
{
    public static void main(String[] args)
    {
        Student s=new Student();
        s.SetStudent("Raju", 18);
        UGStudent s1=new UGStudent();
        s1.SetStudent("Rani",18,"CSE");
        System.out.println(s1.Name);
        System.out.println(s1.Age); 
    }
}*/

/*class Student
{
    int Age;
    String Name;
    Student(String Name,int Age)
    {
        this.Name=Name;
        this.Age=Age;
    }
    boolean check(Student s)
    {
        if (s.Age==Age)
        return true;
        else
        return false;
    }
}
class ADS
{
    public static void main(String[] args)
    {
        Student s1=new Student("Raju",20);
        Student s2=new Student("Rani",20);
        Student s3=new Student("Rashmi",22);
        boolean b1=s1.check(s2);
        boolean b2=s2.check(s3);
        System.out.println(b1+" "+b2);
    }
}*/


/*class ADS
{
    public static final double length=10,width=20,radius=7;
    public static void main(String[] args)
    {
        areacircle();
        areareactangle();
    }
    public static void areacircle()
    {
        System.out.println(radius);
        System.err.println(Math.PI*radius*radius);
    }
    public static void areareactangle()
    {
        System.out.println(length*width);
    }
}*/

/*abstract class details
{
    abstract void Display();
}
class Show extends details
{
    public void Display()
    {
        System.out.println("In Show");
    }
}
class ADS
{
    public static void main(String args[])
    {
        Show Ob=new Show();
        Ob.Display();
    }
}*/

/*class Complex
{
    double Real,Imag;
    Complex(double Real,double Imag)
    {
        this.Real=Real;
        this.Imag=Imag;
    }
    void display()
    {
        System.out.println(Real+((Imag>0)?" + ":" - ")+(Math.abs(Imag))+" i");
    }
    public Complex add(Complex C1,Complex C2)
    {
        Complex C3=new Complex(0,0);
        C3.Real=C1.Real+C2.Real;
        C3.Imag=C1.Imag+C2.Imag;
        return C3;
    }
}
class ADS
{
    public static void main(String args[])
    {
        Complex C1=new Complex(5.0,6.0);
        System.out.print("X Set Is: ");
        C1.display();
        Complex C2=new Complex(7.0,8.0);
        System.out.print("Y Set Is: ");
        C1.display();
        Complex C3=C1.add(C1, C2);
        System.out.print("(X+Y) Set Is: ");
        C1.display();
    }
}*/

/*class Person
{
    public static String Name;
    public static int Age;
    Person(String name,int age)
    {
        Name=name;
        Age=age;
    }
    void displayStudent()
    {
        System.out.println("Name Of Student= "+Name);
        System.out.println("Age  Of Student= "+Age);
    }
}
class Employee extends Person
{
    String Eid,Department;
    double Salary;
    Employee(String Name,int Age,String Eid,String Department,double Salary)
    {
        super(Name,Age);
        this.Eid=Eid;
        this.Department=Department;
        this.Salary=Salary;
    }
    void displayDetails()
    {
        System.out.println("Name Of Student= "+Name);
        System.out.println("Age  Of Student= "+Age);
        System.out.println("Employee ID= "+Eid);
        System.out.println("Department= "+Department);
        System.out.println("Salary= "+Salary);
    }
}
class ADS
{
    public static void main(String args[])
    {
        /*Person obj=new Person("Amulya",19);
        Employee Ob=new Employee("Amulya",19,"CSE1001","CSE",50000.0);
        Ob.displayDetails();
        Employee Ob[]=new Employee[50];
        for (int i=0;i<Ob.length;i++)
        {
            Ob[i]=new Employee("Amulya",19,"CSE1001","CSE",50000.0);
        }
        for (int i=0;i<Ob.length;i++)
        {
            Ob[i].displayDetails();
            System.out.println();
        }
    }
}*/

/*interface StaffInterface
{
    void displayStaff();
    void giveBonus(double amount);
}

abstract class Staff implements StaffInterface
{
    String Fname;
    String Lname;
    double Salary;

    public Staff(String Fname, String Lname, double Salary)
    {
        this.Fname = Fname;
        this.Lname = Lname;
        this.Salary = Salary;
    }

    @Override
    public void displayStaff()
    {
        System.out.println("First Name: " + Fname);
        System.out.println("Last Name: " + Lname);
        System.out.println("Salary: " + Salary);
    }

    @Override
    public void giveBonus(double amount)
    {
        System.out.println("Bonus= " + (amount * 5));
    }
}

class ADS
{
    public static void main(String args[])
    {
        Staff Ob = new Employee("Amulya", "Shrivastava", 50000.0);
        Ob.displayStaff();
        Ob.giveBonus(50000.0);
    }
}

class Employee extends Staff
{
    public Employee(String Fname, String Lname, double Salary)
    {
        super(Fname, Lname, Salary);
    }
}*/

/*interface Animal
{
    public void make_sound();
}
class Dog implements Animal
{
    void Dog()
    {
        System.out.println("Dog Barks");
    }
    public void make_sound()
    {
        System.out.println("Bhow Bhow");
    }
}
class Cat implements Animal
{
    void Cat()
    {
        System.out.println("Cat Meow");
    }
    public void make_sound()
    {
        System.out.println("Meow Meow");
    }
}
class ADS
{
    public static void main(String args[])
    {
        Dog ob=new Dog();
        ob.make_sound();
        Cat obj=new Cat();
        obj.make_sound();
    }
}*/

/*import java.util.*;
import java.lang.*;
class ADS
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        try
        {
            System.out.print("Enter The Marks In DSA: ");
            int Marks=sc.nextInt();
            if (Marks>100)
            throw new MarksException("Error");
            else
            System.out.println("The Marks In DSA Is: "+Marks);
        }
        catch (MarksException e)
        {
            System.out.println("Mark Can't Be Greater Than 0");
        }
    }
}*/

/*import java.util.*;
import java.lang.*;
public class ADS
{
    public static void main(String args[])
    {
        try
        {
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter The Value: ");
            int Value=sc.nextInt();
            if (Value>100)
            throw new MarksOutOfBoundException();
            System.out.println("Marks: "+Value);
        }
        catch (MarksOutOfBoundException e)
        {
            System.out.println("Naah");
        }
    }
}*/

/*import java.util.*;

class MarksException extends Exception
{
    public MarksException(String message)
    {
        super(message);
    }
}

class ADS
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        try
        {
            System.out.print("Enter The Marks In DSA: ");
            int Marks = sc.nextInt();
            if (Marks > 100)
            {
                throw new MarksException("Error: Marks cannot be greater than 100");
            }
            else if (Marks < 0)
            {
                throw new MarksException("Error: Marks cannot be negative");
            }
            else
            {
                System.out.println("The Marks In DSA Is: " + Marks);
            }
        }
        catch (MarksException e)
        {
            System.out.println(e.getMessage());
        }
    }
}*/

/*abstract class Bank
{
    abstract void withdraw();  // removed private keyword
    abstract void deposit();   // added public keyword for consistency
    abstract void balance();   // added abstract keyword and public for consistency
}

class Office extends Bank
{
    public void withdraw()  // implemented withdraw method
    {
        System.out.println(100);
    }
    
    public void deposit()
    {
        System.out.println(500);  // corrected typo
    }
    
    public void balance()
    {
        System.err.println(400);
    }
}

class ADS
{
    public static void main(String args[])
    {
        Office ob = new Office();
        ob.deposit();
        ob.withdraw();
        ob.balance();
    }
}*/

/*class ADS
{
    static int x=-55;
    public static void main(String args[])
    {
        ADS obj1=new ADS();
        obj1.x=obj1.x*2-66;
        System.err.println(obj1.x); 
        ADS obj2=new ADS();
        obj2.x=obj2.x+66;
        System.out.println(obj1.x+" "+obj2.x);
    }
}*/

/*class ADS
{
    public static final int x=4;
    public static void main(String[] args)
    {
        int a=10,b=5;
        switch(a<b?a:b-1)
        {
            case 5:System.out.println("Wow");
            break;
            case 3:System.out.println("Its Working");
            break;
            case x:System.out.println("Ohh...");
            break;
            default:System.out.println("Fine...");
        }
    }
}*/

/*abstract class Bank
{
    private String bankName;
    Bank(String bankName)
    {
        this.bankName=bankName;
    }
    public String getBankName()
    {
        return "Your Bank Is: "+bankName;
    }
}
class ADS extends Bank
{
    ADS()
    {
        super("SBI");
        super("AXIS");
    }
    public static void main(String args[])
    {
        ADS Ob=new ADS();
    }
    System.out.println(bank.getBankName);
}*/

/*abstract class Bank
{
    String bankName;
    abstract void Bank(String bankName);
    abstract String getBankName();
}

class P1 extends Bank 
{
    String bankName="";
    public void Bank(String bankName)
    {
        this.bankName = bankName;
        System.err.println(bankName);
    }
    public static String getvBankName(String bankName)
    {
        return "Your Bank Is: "+bankName;
    }
}
class ADS
{
    public static void main(String args[])
    {
        P1 ob = new P1();
        ob.Bank("SBI");
        ob.getBankName("SBI");
    }
}*/

/*abstract class Bank
{
    private String bankName;
    Bank(String bankName) 
    {
        this.bankName = bankName;
    }
    public String getBankName()
    {
        return "Your Bank Is: " + bankName;
    }
}
class P1 extends Bank
{
    String bankName = "";
    P1() 
    {
        super("SBI");
        bankName = "SBI";
    }
    public void setBankName(String bankName)
    {
        System.out.println(bankName);
    }
    public String getvBankName()
    {
        return "Your Bank Is: " + bankName;
    }
}
class ADS
{
    public static void main(String args[])
    {
        P1 ob = new P1();
        ob.setBankName("SBI");
        System.out.println(ob.getBankName());
    }
}*/

/*abstract class Bank
{
    String bankName;
    abstract void setBankName(String bankName);
    abstract String getBankName();
}

class P1 extends Bank
{
    String bankName = "";
    public void setBankName(String bankName)
    {
        this.bankName = bankName;
        System.out.println(bankName);
    }
    public String getBankName()
    {
        return "Your Bank Is: " + bankName;
    }
}
class ADS
{
    public static void main(String args[])
    {
        P1 ob = new P1();
        ob.setBankName("SBI");  // Set bank name using the method in P1
        System.out.println(ob.getBankName());  // Get bank name using the method in P1
    }
}*/

/*import java.util.ArrayList;
import java.util.List;

public class ADS
{
    public static void main(String[] args) {
        // Auto-boxing
        int primitiveInt = 50;
        Integer wrapperInt = primitiveInt;  // Auto-boxing
        
        // Unboxing
        Integer wrapperInt2 = new Integer(60);
        int primitiveInt2 = wrapperInt2;  // Unboxing
        
        // Auto-boxing in Collections
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);  // Auto-boxing
        
        // Unboxing from Collections
        int firstNumber = numbers.get(0);  // Unboxing
        
        System.out.println("Auto-boxing: " + wrapperInt);
        System.out.println("Unboxing: " + primitiveInt2);
        System.out.println("Auto-boxing in Collections: " + firstNumber);
    }
}*/

/*import java.util.*;
class ADS
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        try
        {
            System.out.print("The Number To Be Entered: ");
            int Number=sc.nextInt();
            if (Number<0)
            throw new NumberError("Error Input");
        }
        catch (NumberError e)
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

/*class Store
{
    public static String Name="ADS";
}
class ADS
{
    public static void main(String args[])
    {
        Store obj=new Store();
        obj.Name="ADS";
        System.out.print(Store.Name);
    }
}*/