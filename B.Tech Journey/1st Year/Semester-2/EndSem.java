//Assignment-1

/*import java.util.*;
class EndSem
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter A Number Greater Than 2: ");
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

/*import java.util.*;
class EndSem
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter The Weight In KGS: ");
            float Weight=Sc.nextFloat();
            System.out.print("Enter The Height In Meters: ");
            float Height=Sc.nextFloat();
            float BMI=Weight/(Height*Height);
            if (BMI<18.5)
            System.out.println("UnderWeight");
            else if (BMI>=18.5 && BMI<24.9)
            System.out.println("Normal Weight");
            else if (BMI>=25.0 && BMI<29.9)
            System.out.println("Overweight");
            else
            System.out.println("OBESE");
        }
    }
}*/

/*import java.util.*;
class EndSem
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter The Number To Be Checked: ");
            int Number=Sc.nextInt();
            int Sum=0,Product=1;
            int Temp=Number;
            while (Number>0)
            {
                Sum+=Number%10;
                Product*=Number%10;
                Number=Number/10;
            }
            System.out.println("The Number "+Temp+" Is Spy? "+(Sum==Product));
        }
    }
}*/

/*import java.util.*;
class EndSem
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter The String Of Three Number: ");
            String Str=Sc.next();
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
}*/

/*import java.util.*;
class EndSem
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter The Number: ");
            int Number=Sc.nextInt();
            int Store=Sum_Of_Digits(Number);
            while (Store>10)
            {
                Store=Sum_Of_Digits(Store);
            }
            System.out.println("The Number Of Count: "+Store);
        }
    }
    public static int Sum_Of_Digits(int Number)
    {
        int Sum=0;
        while(Number>0)
        {
            Sum+=Number%10;
            Number=Number/10;
        }
        return Sum;
    }
}*/

/*import java.util.*;
class EndSem
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter The Number To Be Checked: ");
            int Number=Sc.nextInt();
            System.out.println("The Number "+Number+" Is Odd? "+isOdd(Number));
        }
    }
    public static boolean isOdd(int Number)
    {
        return (Number&1)==1;
    }
}*/

/*import java.util.*;
class EndSem
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter The Length Of The Array: ");
            int Number=Sc.nextInt();
            int[] Arr=new int[Number];
            System.out.println("Enter The Elements Of The Array: ");
            for (int i=0;i<Arr.length;i++)
            {
                System.out.print("Enter For Element "+(i+1)+" : ");
                Arr[i]=Sc.nextInt();
            }
            System.out.print("The Array Is: ");
            for (int i=0;i<Arr.length;i++)
            {
                System.out.print(Arr[i]+" ");
            }
            System.out.println();
            int Max,Min,Max_Position=0,Min_Position=0,Max_Count=0,Min_Count=0;
            Max=Arr[0];
            Min=Arr[0];
            for (int i=0;i<Arr.length;i++)
            {
                if (Arr[i]>Max)
                {
                    Max=Arr[i];
                    Max_Count=1;
                    Max_Position=i+1;
                }
                else if (Arr[i]==Max)
                {
                    Max_Count++;
                }
                if (Arr[i]<Min)
                {
                    Min=Arr[i];
                    Min_Count=1;
                    Min_Position=i+1;
                }
                else if (Arr[i]==Min)
                {
                    Min_Count++;
                    Min_Position = i + 1;
                }
            }
            System.out.println("Maximum Element Of Array Is "+Max+" And Occurs "+Max_Count+" Times.");
            System.out.println("Minimum Element Of Array Is "+Min+" And Occurs "+Min_Count+" Times.");
            System.out.println("First Occurrence Of Maximum Element Is At Position "+Max_Position+".");
            System.out.println("Last Occurrence Of Minimum Element Is At Position "+Min_Position+".");
        }
    }
}*/

/*import java.util.*;
class EndSem
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter The Size Of The Rows And Columns: ");
            int Rows=Sc.nextInt();
            int Columns=Sc.nextInt();
            int[][] Arr=new int[Rows][Columns];
            System.out.println("Enter The 2-D Array: ");
            for (int i=0;i<Arr.length;i++)
            {
                for (int j=0;j<Arr.length;j++)
                {
                    System.out.print("Enter The Element At "+(i+1)+""+(j+1)+" : ");
                    Arr[i][j]=Sc.nextInt();
                }
            }
            System.out.println("The 2-D Array: ");
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
            System.out.println("The Sum Of The 2-D Array Is: "+Sum);
        }
    }
}*/

/*import java.util.*;
class EndSem
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter The Size Of The Rows And Columns: ");
            int Rows=Sc.nextInt();
            int Columns=Sc.nextInt();
            double[][] Arr=new double[Rows][Columns];
            for (int i=0;i<Arr.length;i++)
            {
                for (int j=0;j<Arr.length;j++)
                {
                    System.out.print("Enter The Elements At "+(i+1)+""+(j+1)+" : ");
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
            System.out.println("The Sum Of The Diagonal Elements Is: "+SumMajorDiagonal(Arr));
        }
    }
    public static double SumMajorDiagonal(double[][] Arr)
    {
        int Sum=0;
        for (int i=0;i<Arr.length;i++)
        {
            for (int j=0;j<Arr.length;j++)
            {
                if (i==j)
                Sum+=Arr[i][j];
            }
        }
        return Sum;
    }
}*/

/*import java.util.Scanner;
class EndSem
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter The Size Of The Rows And Columns: ");
            int Rows=Sc.nextInt();
            int Columns=Sc.nextInt();
            double[][] Arr=new double[Rows][Columns];
            System.out.println("Enter The Elements Of The Array: ");
            for (int i=0;i<Rows;i++)
            {
                for (int j=0;j<Columns;j++)
                {
                    System.out.print("Enter The Element At "+(i+1)+""+(j+1)+" : ");
                    Arr[i][j]=Sc.nextDouble();
                }
            }
            System.out.println("The 2-D Array Is: ");
            for (int i=0;i<Rows;i++)
            {
                for (int j=0;j<Columns;j++)
                {
                    System.out.print(Arr[i][j]+" ");
                }
                System.out.println();
            }
            System.out.print("Enter The Choice Of The Column To Get The Sum: ");
            int Choice=Sc.nextInt();
            System.out.println("The Sum Of The Column Specified Is: "+sumColumn(Arr, Choice));
        }
    }
    public static double sumColumn(double[][] m, int columnIndex)
    {
        int Sum=0;
        for (int i=0;i<m.length;i++)
        {
            Sum+=m[i][columnIndex];
        }
        return Sum;
    }
}*/

/*import java.util.*;
class EndSem
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter The 3-Values: ");
            int A=Sc.nextInt();
            int B=Sc.nextInt();
            int C=Sc.nextInt();
            if ((A+B==C)||(A==B-C)||((A*B)==C))
            System.out.println("They Are In Arithmetic Formula");
            else
            System.err.println("They Are Not In Arithmetic Series");
        }
    }
}*/

/*import java.util.*;
class EndSem
{
    public static void main(String[] args)
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter The Number Of Sentences: ");
            int Number=Sc.nextInt();
            String[] Store=new String[Number];
            System.out.println("Enter The Sentences: ");
            Sc.nextLine();
            for (int i=0;i<Store.length;i++)
            {
                System.out.print((i+1)+". ");
                Store[i]=Sc.nextLine();
            }
            System.out.println("The Reversed Order Is: ");
            for (int i=Store.length-1;i>=0;i--)
            {
                System.out.println((i+1)+". "+Store[i]);
            }
        }
    }
}*/

/*import java.util.*;
class EndSem
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.println("Enter The Data For The 2-Vectors: ");
            int[] A=new int[2];
            int[] B=new int[2];
            System.out.println("Data For Vector A: ");
            A[0]=Sc.nextInt();
            A[1]=Sc.nextInt();
            System.out.println("Data For Vector B: ");
            B[0]=Sc.nextInt();
            B[1]=Sc.nextInt();
            int Sum=0;
            for (int i=0;i<A.length;i++)
            {
                Sum+=A[i]*B[i];
            }
            System.out.println("The Dot Product Of A.B Will Be: "+Sum);
        }
    }
}*/

/*import java.util.*;
class EndSem
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter The Size Of Rows And Columns: ");
            int Rows=Sc.nextInt();
            int Columns=Sc.nextInt();
            double[][] Arr1=new double[Rows][Columns];
            double[][] Arr2=new double[Rows][Columns];
            System.out.println("Enter The Data Of The Matrix-I");
            for (int i=0;i<Arr1.length;i++)
            {
                for (int j=0;j<Arr1.length;j++)
                {
                    System.out.print("Enter The Element At Position "+(i+1)+""+(j+1)+" : ");
                    Arr1[i][j]=Sc.nextDouble();
                }
            }
            System.out.println("Enter The Data Of The Matrix-II");
            for (int i=0;i<Arr2.length;i++)
            {
                for (int j=0;j<Arr2.length;j++)
                {
                    System.out.print("Enter The Element At Position "+(i+1)+""+(j+1)+" : ");
                    Arr2[i][j]=Sc.nextDouble();
                }
            }
            System.out.println("The Matrix I: ");
            for (int i=0;i<Arr1.length;i++)
            {
                for (int j=0;j<Arr1.length;j++)
                {
                    System.out.print(Arr1[i][j]+"\t");
                }
                System.out.println();
            }
            System.out.println("The Matrix II: ");
            for (int i=0;i<Arr2.length;i++)
            {
                for (int j=0;j<Arr2.length;j++)
                {
                    System.out.print(Arr2[i][j]+"\t");
                }
                System.out.println();
            }
            double[][] Result=addMatrix(Arr1, Arr2);
            System.out.println("The Sum Matrix Is: ");
            displayMatrix(Result);
        }
    }
    public static double[][] addMatrix(double[][] a, double[][] b)
    {
        double[][] Sum_Matrix=new double[a.length][a.length];
        for (int i=0;i<Sum_Matrix.length;i++)
        {
            for (int j=0;j<Sum_Matrix.length;j++)
            {
                Sum_Matrix[i][j]=a[i][j]+b[i][j];
            }
        }
        return Sum_Matrix;
    }
    public static void displayMatrix(double[][] matrix)
    {
        for (double[] row : matrix)
        {
            for (double element : row)
            {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}*/

//Assignment-2

/*import java.util.*;
class Person
{
    public static String Name;
    public static int Age;
    void setData(String Name,int Age )
    {
        this.Name=Name;
        this.Age=Age;
    }
    void displayData()
    {
        System.out.println("The Name Of The Person Is: "+Name);
        System.out.println("The Age  Of The Person Is: "+Age);
    }
}
class EndSem
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            Person S1=new Person();
            S1.setData("Rohan", 20);
            System.out.print("Enter The Name2:");
            String Name=sc.next();
            System.out.print("Enter The Age:");
            int Age=sc.nextInt();
            Person S2=new Person();
            S2.setData(Name,Age);
            S1.displayData();
            S2.displayData();
            if (S1.Age>S2.Age)
            System.out.print(S2.Name+" Is Younger");
            else
            System.out.print(S1.Name+" Is Younger");
        }
    }
}*/

/*import java.util.*;
class Complex
{
    int Real,imag;
    void setData(int Real,int imag)
    {
        this.Real=Real;
        this.imag=imag;
    }
    void display()
    {
        System.out.println(Real+((imag>0)?"+":"-")+(int)Math.abs(imag)+"i");
    }
    public Complex add(Complex C1,Complex C2)
    {
        Complex C3=new Complex();
        C3.Real=C1.Real+C2.Real;
        C3.imag=C1.imag+C2.imag;
        return C3;
    }
}
class EndSem
{
    public static void main(String[] args)
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            Complex C1=new Complex();
            System.out.print("Enter The Complex Set-I: ");
            int R1=Sc.nextInt();
            int I1=Sc.nextInt();
            C1.setData(R1, I1);
            C1.display();
            Complex C2=new Complex();
            System.out.print("Enter The Complex Set-II: ");
            int R2=Sc.nextInt();
            int I2=Sc.nextInt();
            C2.setData(R2, I2);
            C2.display();
            Complex C3=C1.add(C1,C2);
            System.out.println("The Resulting Complex Values Is: ");
            C3.display();
        }
    }
}*/

/*import java.util.*;
class Product
{
    private String ProdID;
    private double Price;
    private int Quantity;
    private static double TotalPrice=0.0;
    public Product(String ProdID,double Price,int Quantity)
    {
        this.ProdID = ProdID;
        this.Price = Price;
        this.Quantity = Quantity;
        TotalPrice += Price * Quantity;
    }
    void display()
    {
        System.out.println("Product ID--> "+ProdID);
        System.out.println("Price     --> "+Price);
        System.out.println("Quantity  --> "+Quantity);
        System.out.println("------------------------------------");
    }
    public static double getTotalPrice()
    {
        return TotalPrice;
    }
}
class EndSem
{
    public static void main(String args[])
    {
        Product[] Store=new Product[5];
        Store[0]=new Product("AmulCo",50.0,20);
        Store[1]=new Product("SudhaCo",60.0,5);
        Store[2]=new Product("GaytriCo",70.0,10);
        Store[3]=new Product("NandiniCo",20.0,15);
        Store[4]=new Product("PrachiCo",10.0,25);
        for (int i=0;i<Store.length;i++)
        {
            Store[i].display();
        }
        System.out.println("The Total Bill Is: $"+Product.getTotalPrice());
    }
}*/

/*import java.util.*;
class Deposit
{
    static long Principal;
    static int Time;
    static double Rate;
    Deposit()
    {
        System.out.println("Banking System--->");
    }
    Deposit(long Principal,int Time,double Rate)
    {
        this.Principal=Principal;
        this.Time=Time;
        this.Rate=Rate;
    }
    Deposit(long Principal,int Time)
    {
        this.Principal=Principal;
        this.Time=Time;
    }
    Deposit(long Principal,double Rate)
    {
        this.Principal=Principal;
        this.Rate=Rate;
    }
    void display()
    {
        System.out.println("The Principal= "+Principal);
        System.out.println("The Rate= "+Rate);
        System.out.println("The Time= "+Time);
    }
    double calcAmt()
    {
        double SI=(Principal*Rate*Time)/100;
        return Principal+SI;
    }
}
class EndSem
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.println("Enter The PRT-->");
            long Principal=Sc.nextLong();
            double Rate=Sc.nextDouble();
            int Time=Sc.nextInt();
            Deposit Obj1=new Deposit(Principal,Time,Rate);
            Obj1.display();
            System.out.println("The Amount Is: "+Obj1.calcAmt());
            Deposit Obj2=new Deposit(Principal,Rate);
            Obj1.display();
            System.out.println("The Amount Is: "+Obj2.calcAmt());
        }
    }
}*/

/*import java.util.*;
class Person
{
    static String Name;
    static int Age;
    Person(String name,int age)
    {
        this.Name=name;
        this.Age=age;
    }
}
class Employee extends Person
{
    static int EId;
    static double Salary;
    Employee(String Name,int Age,int EId,double Salary)
    {
        super(Name, Age);
        this.EId=EId;
        this.Salary=Salary;
    }
    void empDisplay()
    {
        System.out.println("Name Of The Employee= "+Name);
        System.out.println("Age  Of The Employee= "+Age);
        System.out.println("Employee ID Of The Employee= "+EId);
        System.out.println("Salary Of The Employee= "+Salary);
    }
}
public class EndSem
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter The Name: ");
            String Name=Sc.next();
            System.out.print("Enter The Age: ");
            int Age=Sc.nextInt();
            System.out.print("Enter The Employee ID: ");
            int EId=Sc.nextInt();
            System.out.print("Enter The Salary: ");
            double Salary=Sc.nextDouble();
            Employee Obj=new Employee(Name, Age, EId, Salary);
            Obj.empDisplay();
        }
    }
}*/

/*import java.util.Scanner;
abstract class Marks
{
    double MarksICP,MarksDSA,Percentage;
    abstract double getPercentage();
}
class CSE extends Marks
{
    double AlgoDesign;
    CSE(double MarksICP,double MarksDSA,double AlgoDesign)
    {
        this.MarksICP=MarksICP;
        this.MarksDSA=MarksDSA;
        this.AlgoDesign=AlgoDesign;
    }
    double getPercentage()
    {
        return (MarksICP+MarksDSA+AlgoDesign)/3;
    }
}
class NonCSE extends Marks
{
    double EnggMechanics;
    NonCSE(double MarksICP,double MarksDSA,double EnggMechanics)
    {
        this.MarksICP=MarksICP;
        this.MarksDSA=MarksDSA;
        this.EnggMechanics=EnggMechanics;
    }
    double getPercentage()
    {
        return (MarksICP+MarksDSA+EnggMechanics)/3;
    }
}
class EndSem
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter The Subject-->");
            String Choice=Sc.next();
            double MarksICP,MarksDSA,AlgoDesign,EnggMechanics;
            switch(Choice)
            {
                case "CSE":
                System.out.print("Enter The Marks In The Subject: ");
                MarksICP=Sc.nextDouble();
                MarksDSA=Sc.nextDouble();
                AlgoDesign=Sc.nextDouble();
                CSE Obj1=new CSE(MarksICP, MarksDSA, AlgoDesign);
                System.out.println("The Average Percent: "+Obj1.getPercentage());
                break;
                case "NonCSE":
                System.out.print("Enter The Marks In The Subject: ");
                MarksICP=Sc.nextDouble();
                MarksDSA=Sc.nextDouble();
                EnggMechanics=Sc.nextDouble();
                CSE Obj2=new CSE(MarksICP, MarksDSA, EnggMechanics);
                System.out.println("The Average Percent: "+Obj2.getPercentage());
                break;
                default:System.err.println("Enter The Choice Correctly");
                break;
            }
        }
    }
}*/

/*interface DetailInfo
{
    void display();
    int count();
}
class Person implements DetailInfo
{
    private static int maxCount;
    private String name;
    Person(String name)
    {
        this.name = name;
    }
    public void display()
    {
        System.out.println("Name: " + name);
    }
    public int count()
    {
        return name.length();
    }
    public static int getMaxCount()
    {
        return maxCount;
    }
    public static void setMaxCount(int maxCount) 
    {
        Person.maxCount = maxCount;
    }
}

public class EndSem
{
    public static void main(String[] args) 
    {
        Person person1 = new Person("John Doe");
        Person person2 = new Person("Alice");

        // Set maxCount
        Person.setMaxCount(10);

        // Display the name and count of characters for each person
        person1.display();
        System.out.println("Number of characters: " + person1.count());

        person2.display();
        System.out.println("Number of characters: " + person2.count());

        // Display maxCount
        System.out.println("Max Count: " + Person.getMaxCount());
    }
}*/

/*import java.util.*;
class Commission
{
    private double Sales;
    Commission(double Sales)
    {
        this.Sales=Sales;
    }
    double getCommission()
    {
        if (Sales<100)
        return 0.2*Sales;
        else if (Sales>=500 && Sales<5000)
        return (0.2*Sales)+(0.5*(Sales-100));
        else 
        return (0.2*Sales)+(0.5*4500)+(0.8*(Sales-5000));
    }
}
class EndSem
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.err.print("Enter The Sales: ");
            int Sales=Sc.nextInt();
            Commission Com=new Commission(Sales);
            double Result=Com.getCommission();
            if (Result<0){
            System.out.println("Invalid Input");
            return;}
            System.out.println("The Sales Of The User= "+Result);
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

public class EndSem
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
public class EndSem
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

public class EndSem
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

public class EndSem
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

//Assignment-03

/*import java.util.*;
class EndSem
{
    public static void main(String args[])
    {
        Scanner Sc=new Scanner(System.in);
        try
        {
            System.out.print("Enter Your Lucky Number: ");
            int Number=Sc.nextInt();
            if (Number>0)
            System.out.println("Luck Factor--> "+Number);
            else
            throw new NumberFormatException("Error Hai Idhar");
        }
        catch(NumberFormatException e)
        {
            System.out.println("-ve Numbers Not Accepted");
        }
    }
}*/

/*import java.util.*;
class EndSem
{
    public static void main(String args[])
    {
        Scanner Sc=new Scanner(System.in);
        try
        {
            int Arr[]={1,2,3,4};
            System.out.println(Arr[3]/0);
        }
        catch(ArithmeticException e)
        {
            System.out.println("Error Hai Vaii");
        }
        try
        {
            int Arr1[]=null;
            System.out.println(Arr1[2]);
        }
        catch(NullPointerException e)
        {
            System.out.println("Null Hai Vaii");
        }
    }
}*/

/*import java.util.*;
class EndSem
{
    public static void main(String args[])
    {
        Scanner Sc=new Scanner(System.in);
        try
        {
            System.out.print("Enter The Marks: ");
            int Marks=Sc.nextInt();
            if (Marks>100)
            throw new MarksExceptionError("Marks Cannot Be Greater Than 100");
            else
            System.out.println("The Marks Is: "+Marks);
        }
        catch(MarksExceptionError e)
        {
            System.out.println(e.getMessage());
        }
    }
}
class MarksExceptionError extends Exception
{
    MarksExceptionError(String Message)
    {
        super(Message);
    }
}*/

/*import java.util.*;
class Box<T>
{
    T Store;
    Box(T Store)
    {
        this.Store=Store;
    }
    void setVar(T Store)
    {
        this.Store=Store;
    }
    T getVar()
    {
        return Store;
    }
}
public class EndSem
{
    public static void main(String args[])
    {
        Box<String> Var1=new Box<>(null);
		Box<String> Var2=new Box<>(null);
        Var1.setVar("Hello First Wala");
        Var2.setVar("Hello Second Wala");
        System.out.println(Var1.getVar());
        System.out.println(Var2.getVar());
        Box<Integer> Var3=new Box<Integer>(null);
        Box<Integer> Var4=new Box<Integer>(null);
        Var3.setVar(10);
        Var4.setVar(7);
        System.out.println(Var3.getVar());
        System.out.println(Var4.getVar());
        Box<Object> Var5=new Box<Object>(null);
        Box<Object> Var6=new Box<Object>(null);
        Var5.setVar("Hello");
        Var6.setVar((double)911);
        System.out.println(Var5.getVar());
        System.out.println(Var6.getVar());
    }
}*/

/*import java.util.*;
class EndSem
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter The Size Of The Array: ");
            int Size=Sc.nextInt();
            Integer Arr1[]=new Integer[Size];
            System.out.print("Enter The Data: ");
            for (int i=0;i<Size;i++)
            {
                Arr1[i]=Sc.nextInt();
            }
            System.out.println();
            EndSem.<Integer>printArray(Arr1);
            System.out.println();
            Double Arr2[]=new Double[Size];
            System.out.print("Enter The Data: ");
            for (int i=0;i<Size;i++)
            {
                Arr2[i]=Sc.nextDouble();
            }
            System.out.println();
            EndSem.<Double>printArray(Arr2);
        }
    }
    public static <E> void printArray( E[] inputArray)
    {
        System.out.print("The Array To Be Printed-->");
        for (E Element : inputArray)
        {
            System.out.print(Element+" ");
        }
    }
}*/

/*import java.util.*;
class EndSem
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter The Size Of The Array--> ");
            int Size=Sc.nextInt();
            Integer Arr1[]=new Integer[Size];
            Double Arr2[]=new Double[Size];
            System.out.print("Enter The Data Set-1-->");
            for (int i=0;i<Size;i++)
            {
                Arr1[i]=Sc.nextInt();
            }
            System.out.print("Enter The Element To Be Searched--> ");
            int Search1=Sc.nextInt();
            System.out.println("The Element Count Is "+EndSem.<Integer>count(Arr1,Search1));
            System.out.print("Enter The Data Set-2-->");
            for (int i=0;i<Size;i++)
            {
                Arr2[i]=Sc.nextDouble();
            }
            System.out.print("Enter The Element To Be Searched--> ");
            double Search2=Sc.nextDouble();
            System.out.println("The Element Count Is "+EndSem.<Double>count(Arr2,Search2));
        }
    }
    public static <T> int count(T[] array,T item)
    {
        int Count=0;
        for (int i = 0; i < array.length; i++)
        {
            if (item.equals(array[i]))
			{
				Count++;
			}
        }
        return Count;
    }
}*/

/*import java.util.*;
class EndSem
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter The Number--> ");
            int Number=Sc.nextInt();
            System.out.println("The Factorial Of "+Number+" Is "+Factorial(Number));
        }
    }
    public static int Factorial(int Number)
    {
        if(Number<=1)
			return 1;
		else
			return Number*Factorial(Number-1);
    }
}*/

/*import java.util.*;
class EndSem
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter The Base: ");
            int Base=Sc.nextInt();
            System.out.print("Enter The Power: ");
            int Power=Sc.nextInt();
            System.out.println("The Base To The Power Raised: "+Calculate(Base,Power));
        }
    }
    public static int Calculate(int Base,int Power)
    {
        if (Power==0)
        return 1;
        else
        return Base*Calculate(Base, Power-1);
    }
}*/

/*import java.util.*;
class EndSem
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter The Number To Get Reversed: ");
            int Number=Sc.nextInt();
            System.out.println("The Reversed Number Is: "+Reverse(Number,0));
        }
    }
    public static int Reverse(int Number,int reverse)
    {
        if (Number==0)
        return reverse;
        else
        {
            reverse=reverse*10+(Number%10);
            return Reverse(Number/10, reverse);
        }
    }
}*/

/*import java.util.*;
class EndSem
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter The Limit: ");
            int Limit=Sc.nextInt();
            System.out.println("The Factorial Series Is: "+Fibonacci(Limit));
        }
    }
    public static int Fibonacci(int Number)
    {
        if (Number<2)
        return Number;
        return Fibonacci(Number-1)+Fibonacci(Number-2);
    }
}*/

/*import java.util.*;
class EndSem
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter The Two Numbers For GCD: ");
            int Num1=Sc.nextInt();
            int Num2=Sc.nextInt();
            System.out.println("The GCD Is: "+GCD(Num1,Num2));
        }
    }
    public static int GCD(int Num1,int Num2)
    {
        if (Math.max(Num1,Num2)%Math.min(Num1, Num2)==0)
        return Math.min(Num1, Num2);
        else
        return GCD(Math.max(Num1, Num2), Math.max(Num1,Num2)%Math.min(Num1, Num2));
    }
}*/

/*import java.util.Scanner;
class EndSem
{
    public static void main(String args[])
    {
        Scanner Sc=new Scanner(System.in);
        System.out.print("Enter The Size Of The Array: ");
        int Size=Sc.nextInt();
        int[] Arr=new int[Size];
        System.out.print("Enter The Array: ");
        for (int i=0;i<Size;i++)
        {
            Arr[i]=Sc.nextInt();
        }
        System.out.print("Enter The Element To Be Searched: ");
        int Search=Sc.nextInt();
        System.out.println("The Element Is Found At: "+BinarySearch(Arr,Search,Size/2));
    }
    public static int BinarySearch(int[] Arr,int Search,int Mean)
    {
        if(Search==Arr[Mean])
			return (Mean+1);
		else
		{
			if(Search>Arr[Mean])
			{
				return BinarySearch(Arr, Search, Mean+Mean/2);
			}
			else
			{
				return BinarySearch(Arr, Search, Mean-Mean/2);
			}
		}
    }
}*/

/*import java.util.*;
class EndSem
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter The Decimal Number: ");
            int Decimal=Sc.nextInt();
            System.out.println("The Decimal TO Binary Value Is: "+DecToBinary(Decimal));
        }
    }
    public static long DecToBinary(int Decimal)
    {
        if(Decimal<=1)
			return Decimal;
		else
			return DecToBinary(Decimal/2)*10+(Decimal%2);
    }
}*/

/*import java.util.*;
class EndSem
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter The First Number: ");
            int Num1=Sc.nextInt();
            System.out.print("Enter The Second Number: ");
            int Num2=Sc.nextInt();
            System.out.println("The Multiplicity Is: "+Multiplicity(Num1,Num2));
        }
    }
    public static int Multiplicity(int Num1,int Num2)
    {
        if(Num2>0)
			return Num1+Multiplicity(Num1,Num2-1);
		else if(Num2<0)
			return Multiplicity(Num1,Num2+1)-Num1;
		else
			return 0;
    }
}*/

/*import java.util.*;
class EndSem
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter The String: ");
            String Store=Sc.next();
            System.out.println("The Reversed String Is: "+Reversed(Store));
        }
    }
    public static String Reversed(String Store)
    {
        if (Store.length()==1)
        return Store;
        else
        {
            return Store.charAt(Store.length()-1)+Reversed(Store.substring(0,Store.length()-1));
        } 
    }
}*/

/*import java.util.*;
class EndSem
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter The String: ");
            String Store=Sc.nextLine();
            System.out.println("Is Palindrome? "+(Store.equals(isPalindrome(Store))));
        }
    }
    public static String isPalindrome(String Store)
    {
        if (Store.length()==1)
        return Store;
        else
        return Store.charAt(Store.length()-1)+isPalindrome(Store.substring(0,Store.length()-1));
    }
}*/

/*import java.util.*;
class EndSem
{
    public static void main(String args[])
    {
        try(Scanner Sc=new Scanner(System.in))
        {
            System.out.print("Enter The Size Of The Array: ");
            int Size=Sc.nextInt();
            int Arr[]=new int[Size];
            System.out.print("Enter The Data Of The Array: ");
            for (int i=0;i<Size;i++)
            {
                Arr[i]=Sc.nextInt();
            }
            System.out.print("Enter The Key Element: ");
            int Key=Sc.nextInt();
            int p1=0,p2=Size-1;
            int[] s=quicksort(Arr, Key, p1, p2);
		    for(int i=0; i<Size; i++)
		    {
			    System.out.print(Arr[i]+" ");
		    }
        }
    }
    public static int[] quicksort(int arr[], int p, int p1, int p2 ) 
	{
		if(p1<p2)
		{ 
			if(arr[p1]<p) 
				p1++; 
			else
			{
				if(arr[p2]>p) 
					p2--; 
				else if(arr[p1]==arr[p2]) 
					p1++; 
				else 
				{ 
					int t=arr[p1]; 
					arr[p1]=arr[p2]; 
					arr[p2]=t; 
				}
			}
			return quicksort(arr,p,p1,p2); 
		}
		else
			return arr;
	}
}*/


/*import java.util.*;
public class EndSem
{
	public static void main(String args[])
	{
		queue arr[] = new queue[3];
		Scanner in = new Scanner(System.in);
		System.out.print("Enter The Number Of Rings: ");
		int n=in.nextInt();
		for(int i=0; i<3; i++)
		{
			arr[i]= new queue(n, "Queue "+i);
		}
		for(int i=n; i>=1; i--)
		{
			arr[0].push(i);
			System.out.println(arr[0]);
		}
		set(n, arr, 0, 1, 2);
	}
	public static void set(int i, queue[] arr, int q1, int q2, int q3)
	{
		if(i>0)
		{
			set(i-1, arr, q1, q3, q2);
			swapDisk(q1, q2, arr);
			for(queue t:arr)
			{
				System.out.println(t.getName()+" :"+t);
			}
			set(i-1, arr, q3, q2, q1);
		}
	}
	public static void swapDisk(int q1, int q2, queue[] arr)
	{
		int t=arr[q1].peek();
		if(t>0)
		{	
			arr[q2].push(t);
			arr[q1].pop();
		}
	}
}
class queue
{
	private int arr[];
	private String name;
	int top;
	queue(int n, String name)
	{
		this.name=name;
		top=-1;
		arr = new int[n];
	}
	String getName()
	{
		return name;
	}
	void pop()
	{
		if(top==-1)
		{
			try
			{
				throw new StackUnderflowException("Queue is already Empty");
			}
			catch(StackUnderflowException e)
			{
				e.printStackTrace();
			}
		}
		else
			top--;
	}
	int peek()
	{
		if(top!=-1)
		{
			return arr[top];
		}
		else
		{
			System.out.print("Queue is Empty, Nothing to show");
			return -1;
		}
	}
	void push(int i)
	{
		if(top==arr.length)
		{
			try
			{
				throw new StackOverflowException("Queue is already full");
			}
			catch(StackOverflowException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			top++;
			arr[top]=i;
		}
	}
	int[] show()
	{
		if(top==-1)
		{			
				return null;
		}
		else
		{
			int rt[] = new int[top+1];
			for(int i=0; i<=top; i++)
			{
				rt[i]=arr[i];
			}
			return rt;
		}
	}
	public String toString()
	{
		if(show()!=null)
		{
			int[] rt=show();
			String s="[";
			for(int i:rt)
			{
				s=s+i+", ";
			}
			s=s+"]";
			return s;
		}
		else
			return "[ ]";
	}
}
class StackUnderflowException extends Exception
{
	StackUnderflowException(String s)
	{
		super(s);
	}
}
class StackOverflowException extends Exception
{
	StackOverflowException(String s)
	{
		super(s);
	}
}*/

/*import java.util.*;
class LinkedList
{
    private Node Head = null;
    private Node Tail = null;
    private int Size = 0;

    public LinkedList() 
    {
        this.Size = Size;
    }

    private class Node 
    {
        private int Value;
        private Node Next;

        public Node(int Value) 
        {
            this.Value = Value;
        }

        public Node(int Value, Node Next) 
        {
            this.Value = Value;
            this.Next = Next;
        }
    }

    public void insertFirst(int Value)
    {
        Node node = new Node(Value);
        node.Next = Head;
        Head = node;
        if (Tail == null)
            Tail = Head;
        Size += 1;
    }

    public void insertLast(int Value)
    {
        if (Tail==null)
        {
            insertFirst(Value);
            return;
        }
        Node node=new Node(Value);
        Tail.Next=node;
        Tail=node;
        Size++;
    }

    public void insertAny(int Value,int Index)
    {
        if (Index==0)
        {
            insertFirst(Value);
            return;
        }
        if (Index==Size)
        {
            insertLast(Value);
            return;
        }
        Node Temp=Head;
        for (int i=1;i<Index;i++)
        {
            Temp=Temp.Next;
        }
        Node node=new Node(Value,Temp.Next);
        Temp.Next=node;
        Size++;
    }

    public int deleteFirst()
    {
        int Val=Head.Value;
        Head=Head.Next;
        if (Head==null)
        Tail=null;
        Size--;
        return Val;
    }

    public int deleteLast()
    {
        if (Size<=1)
        return deleteFirst();
        Node SecondLast=get(Size-2);
        int Val=Tail.Value;
        Tail=SecondLast;
        Tail.Next=null;
        return Val;
    }
    
    public int delete(int Index)
    {
        if (Index==0)
        return deleteFirst();
        if (Index==Size-1)
        return deleteLast();
        Node Previous=get(Index-1);
        int Val=Previous.Next.Value;
        Previous.Next=Previous.Next.Next;
        return Val;
    }

    public Node Find(int Value)
    {
        Node node=Head;
        while (node!=null)
        {
            if (node.Value==Value)
            return node;
        }
        node=node.Next;
        return node;
    }


    //Reference Pointer To The Node

    public Node get(int Index)
    {
        Node node=Head;
        for (int i=0;i<Index;i++)
        {
            node=node.Next;
        }
        return node;
    }

    public void Display() 
    {
        Node Temp = Head;
        while (Temp != null) 
        {
            System.out.print(Temp.Value + " --> ");
            Temp = Temp.Next;
        }
        System.out.println("END");
    }
}
class EndSem 
{
    public static void main(String args[]) 
    {
        LinkedList List = new LinkedList();
        
        List.insertFirst(3);
        List.insertFirst(2);
        List.insertFirst(8);
        List.insertFirst(17);
        List.Display();

        List.insertLast(95);
        List.Display();

        List.insertAny(100,3);
        List.Display();

        System.err.println(List.deleteFirst());
        List.Display();

        System.err.println(List.deleteLast());
        List.Display();

        System.err.println(List.delete(2));
        List.Display();

        System.err.println(List.Find(2));
    }
} */

/*import java.util.*;
class DoubleLinkedList
{
    private Node Head = null;
    
    private class Node
    {
        private int Value;
        private Node Next;
        private Node Previous;

        public Node(int Value) 
        {
            this.Value = Value;
        }

        public Node(int Value, Node Next,Node Previous) 
        {
            this.Value = Value;
            this.Next = Next;
            this.Previous=Previous;
        }
    }

    public void insertFirst(int Value)
    {
        Node node = new Node(Value);
        node.Next = Head;
        node.Previous=null;
        if (Head!=null)
        Head.Previous=node;
        Head=node;
    }

    public void insertLast(int Value)
    {
        Node node=new Node(Value);
        if (Head==null)
        {
            node.Previous=null;
            Head=node;
        }
        else
        {
            Node Temp=Head;
            while(Temp.Next!=null)
            {
                Temp=Temp.Next;
            }
            Temp.Next=node;
            node.Previous=Temp;
        }
    }

    public void insertAny(int after, int Value)
    {
        Node p = Find(after);
        if (p == null)
        {
            System.out.println("Does Not Exist");
            return;
        }
        Node node = new Node(Value);
        node.Next = p.Next;
        p.Next = node;
        node.Previous = p;
        if (node.Next != null) 
        {
            node.Next.Previous = node;
        }
    }

    public int deleteFirst()
    {
        int Val=Head.Value;
        Head=Head.Next;
        if (Head==null)
        Head=Head.Next;
        Head.Previous=null;
        return Val;
    }

    public int deleteLast()
    {
        if (Head == null)
        {
            throw new NoSuchElementException("List is empty");
        }
        Node Temp = Head;
        int Val;
        if (Head.Next == null)
        {
            Val = Head.Value;
            Head = null;
        }
        else
        {
            while (Temp.Next != null)
            {
                Temp = Temp.Next;
            }
            Val = Temp.Value;
            Temp.Previous.Next=null;
        }
        return Val;
    }
    
    public int delete(int Index)
    {
        if (Head == null)
            throw new NoSuchElementException("List is empty");
        if (Index < 0)
            throw new IndexOutOfBoundsException("Index out of bounds");
        Node Temp = Head;
        if (Index == 0)
        {
            int Val = Temp.Value;
            Head = Temp.Next;
            if (Head != null) 
            {
                Head.Previous = null;
            }
            return Val;
        }
    
        for (int i = 0; i < Index; i++)
        {
            if (Temp == null)
                throw new IndexOutOfBoundsException("Index out of bounds");
            Temp = Temp.Next;
        }
        if (Temp == null || Temp.Previous == null)
            throw new IndexOutOfBoundsException("Index out of bounds");
        int Val = Temp.Value;
        Node Prev = Temp.Previous;
        Node Next = Temp.Next;
        Prev.Next = Next;
        if (Next != null)
            Next.Previous = Prev;
        return Val;
    }

    public Node Find(int Value)
    {
        Node node=Head;
        while (node!=null)
        {
            if (node.Value==Value)
            return node;
            node=node.Next;
        }
        return node;
    }

    //Reference Pointer To The Node

    public Node get(int Index)
    {
        Node node=Head;
        for (int i=0;i<Index;i++)
        {
            node=node.Next;
        }
        return node;
    }

    public void Display() 
    {
        Node Temp = Head;
        Node Last = null;
        while (Temp != null) 
        {
            System.out.print(Temp.Value + " --> ");
            Temp = Temp.Next;
        }
        System.out.println("END");
    }

    public void DisplayRev() 
    {
        Node node = Head;
        Node Last = null;
        while (node != null) 
        {
            System.out.print(node.Value + " --> ");
            Last=node;
            node=node.Next;
        }
        System.out.println("END");
        while(Last!=null)
        {
            System.out.print(Last.Value+" --> ");
            Last=Last.Previous;
        }
        System.out.println("START");
    }
}
class EndSem 
{
    public static void main(String args[]) 
    {
        DoubleLinkedList List = new DoubleLinkedList();
        
        List.insertFirst(3);
        List.insertFirst(2);
        List.insertFirst(8);
        List.insertFirst(17);
        List.Display();
        //List.DisplayRev();

        List.insertLast(95);
        List.Display();

        List.insertAny(8,65);
        List.Display();
        //List.DisplayRev();

        System.err.println("Element Deleted: "+List.deleteFirst());
        List.Display();

        System.err.println("Element Deleted: "+List.deleteLast());
        List.Display();

        System.err.println("Element Deleted: "+List.delete(1));
        List.Display();

        //System.err.println(List.Find(2));
    }
}*/

/*import java.util.*;
class Node
{
    protected int Regd_no;
    protected float Marks;
    protected Node Next;
    public Node(int Regd_no,float Marks)
    {
        this.Regd_no=Regd_no;
        this.Marks=Marks;
        this.Next=null;
    }
    public int GetRegd_no()
    {
        return Regd_no;
    }
    public float GetMarks()
    {
        return Marks;
    }
}
class EndSem
{
    public static void main(String args[])
    {
        Scanner Sc=new Scanner(System.in);
        Node Head=null;
        Node Tail=null;
        System.out.println("----------MENU----------");
        System.out.println("0:  Exit\n1:  Creation\n2:  Display\n3:  Insert In Beginning\n4:  Insert In Ending\n5:  Insert At Any Position\n6:  Delete In Beginning\n7:  Delete In Ending\n8:  Delete at Any Position\n9:  Search The Linked List\n10: Sort The Linked List\n11: Count The Elements\n12: Reverse The List");
        while(true)
        {
            System.out.print("\nEnter The Choice--> ");
            int Choice=Sc.nextInt();
            switch (Choice)
            {
                case 0:System.out.println("Exiting The Program");Sc.close();System.exit(0);
                case 1:Head=Create(Head);break;
                case 2:Display(Head);break;
                case 3:Head=InsertBeg(Head);break;
                case 4:Head=InsertEnd(Head);break;
                case 5:Head=InsertAtAny(Head);break;
                case 6:Head=DeleteBeg(Head);break;
                case 7:Head=DeleteEnd(Head);break;
                case 8:Head=DeleteAtAny(Head);break;
                case 9:Search(Head);break;
                case 10:Head=Sort(Head);break;
                case 11:System.out.println("The Number Of Nodes In The Linked List Is: "+Count(Head));break;
                case 12:Head=Reverse(Head);break;
                default:System.out.println("Error In Selection");break;
            }
        }
    }
    public static Node Create(Node Head)
    {
        Scanner Sc=new Scanner(System.in);
        System.out.print("Enter The Registeration Number: ");
        int Redg=Sc.nextInt();
        System.out.print("Enter The Marks: ");
        float Mark=Sc.nextFloat();
        Head=new Node(Redg, Mark);
        return Head;
    }
    public static void Display(Node Head)
    {
        Scanner Sc=new Scanner(System.in);
        Node Temp=Head;
        if (Temp==null)
        System.out.println("Linked List Is Empty");
        else
        {
            int i=0;
            System.out.println("Index\tRedg_Number\tMarks");
            do
            {
                System.out.println(++i + "\t"+Temp.GetRegd_no()+"\t\t"+Temp.GetMarks());
                Temp=Temp.Next;
            }
            while(Temp!=null);
        }
    }
    public static Node InsertBeg(Node Head)
    {
        Scanner Sc=new Scanner(System.in);
        if (Head==null)
        {
            Head=Create(Head);
            return Head;
        }
        else
        {
            System.out.print("Enter The Registeration Number: ");
            int Regd=Sc.nextInt();
            System.out.print("Enter The Marks: ");
            float Mark=Sc.nextFloat();
            Node node=new Node(Regd,Mark);
            node.Next=Head;
            Head=node;
            return node;
        }
    }
    public static Node InsertEnd(Node Head)
    {
        Scanner Sc=new Scanner(System.in);
        if (Head==null)
        {
            Head=Create(Head);
            return Head;
        }
        else
        {
            System.out.print("Enter The Registeration Number: ");
            int Regd=Sc.nextInt();
            System.out.print("Enter The Marks: ");
            float Mark=Sc.nextFloat();
            Node Temp=Head;
            while(Temp.Next!=null)
            {
                Temp=Temp.Next;
            }
            int ValueR=Temp.GetRegd_no();
            float ValueM=Temp.GetMarks();
            Node node=new Node(Regd, Mark);
            Temp.Next=node;
            //Tail=node;
            node=Head;
            return node;
        }
    }
    public static Node InsertAtAny(Node Head)
    {
        Scanner Sc=new Scanner(System.in);
        System.out.print("Enter The Position To Insert Node: ");
        int Position=Sc.nextInt();
        if (Position==0)
        {
            return InsertBeg(Head);
        }
        else
        {
            Node Temp=Head;
            for (int i=0;i<Position-1;i++)
            {
                try
                {
                    Temp=Temp.Next;
                    if (Temp==null)
                    throw new NullPointerException("Not Valid");
                }
                catch(NullPointerException e)
                {
                    System.out.println("Failed Task: Position Is Greater Than Size");
                }
            }
            System.out.print("Enter The Registeration Number: ");
            int Regd=Sc.nextInt();
            System.out.print("Enter The Marks: ");
            float Mark=Sc.nextFloat();
            Node node=new Node(Regd, Mark);
            node.Next=Temp.Next;
            Temp.Next=node;
            return Head;
        }
    }
    public static Node DeleteBeg(Node Head)
    {
        Scanner Sc=new Scanner(System.in);
        try
        {
            Node Temp=Head;
            Temp=Temp.Next;
            System.out.println("Deletion Successful");
        }
        catch(NullPointerException e)
        {
            System.err.println("Please Create A Linked List");
            return null;
        }
        return Head;
    }
    public static Node DeleteEnd(Node Head)
    {
        Scanner Sc=new Scanner(System.in);
        Node Temp=Head;
        if (Temp==null)
        {
            System.out.println("Please Create A Linked List");
            return null;
        }
        else if (Temp.Next==null)
        {
            System.out.println("Deletetion Success");
            return null;
        }
        else
        {
            while(Temp.Next!=null)
            {
                Temp=Temp.Next;
            }
            Temp.Next=null;
            System.out.println("Deletetion Successful");
            return Head;
        }
    }
    public static Node DeleteAtAny(Node Head)
    {
        Scanner Sc=new Scanner(System.in);
        System.out.print("Enter The Position To Be Deleted: ");
        int Position=Sc.nextInt();
        if (Position==0)
        {
            return DeleteBeg(Head);
        }
        else
        {
            Node Temp=Head;
            for (int i=0;i<Position-1;i++)
            {
                try
                {
                    Temp=Temp.Next;
                    if (Temp==null)
                    throw new NullPointerException();
                }
                catch (NullPointerException e)
                {
                    System.out.println("Failed To Delete At The Position");
                    return Head;
                }
            }
            try
            {
                Node Temp1=Temp;
                Temp1=Temp1.Next;
                Temp.Next=Temp1.Next;
                System.out.println("Deletion Success");
            }
            catch (NullPointerException e)
            {
                System.out.println("This Does Not Exist`");
            }
            return Head;
        }
    }
    public static Node Search(Node Head)
    {
        Scanner Sc=new Scanner(System.in);
        System.out.print("Enter The Regd_No To Be Searched: ");
        int Search=Sc.nextInt();
        boolean Test=false;
        Node Temp=Head;
        do
        {
            if (Temp.GetRegd_no()==Search)
            {
                Test=true;
                break;
            }
            else
            Temp=Temp.Next;
        }
        while (Temp!=null);
        if (Test)
        {
            System.out.println(Temp.GetRegd_no()+" Has Got "+Temp.GetMarks()+" Marks.");
        }
        else
        {
            System.out.println("Element Not Found");
        }
        return Head;
    }
    public static int Count(Node Head)
    {
        Node Temp=Head;
        int Count=0;
        do
        {
            Count++;
            Temp=Temp.Next;
        }
        while(Temp!=null);
        return Count;
    }
    public static Node Sort(Node Head)
    {
        Scanner Sc=new Scanner(System.in);
        if (Head==null)
        {
            System.out.println("Linked List Is Empty");
            return Head;
        }
        else
        {
            int Length=Count(Head);
            int Arr_R[]=new int[Length];
            float Arr_M[]=new float[Length];
            Node Temp=Head;
            for (int i=0;i<Length;i++)
            {
                Arr_R[i]=Temp.GetRegd_no();
                Arr_M[i]=Temp.GetMarks();
                Temp=Temp.Next;
            }
            for (int i=0;i<Length-1;i++)
            {
                for (int j=0;j<Length;j++)
                {
                    if (Arr_M[i]<Arr_M[j])
                    {
                        float T1=Arr_M[i];
                        Arr_M[i]=Arr_M[j];
                        Arr_M[j]=T1;
                        int T2=Arr_R[i];
                        Arr_R[i]=Arr_R[j];
                        Arr_R[j]=T2;
                    }
                }
            }
            Temp=new Node(Arr_R[0],Arr_M[0]);
            Head=Temp;
            for (int i=1;i<Length;i++)
            {
                Temp.Next=new Node(Arr_R[i], Arr_M[i]);
                Temp=Temp.Next;
            }
            System.out.println("Linked List Sorted");
            return Head;
        }
    }
    public static Node Reverse(Node Head)
    {
        Scanner Sc=new Scanner(System.in);
        if (Head==null)
        {
            System.out.println("Linked List Is Empty");
            return null;
        }
        else
        {
            int Length=Count(Head);
            int Arr_R[]=new int[Length];
            float Arr_M[]=new float[Length];
            Node Temp=Head;
            for (int i=0;i<Length;i++)
            {
                Arr_R[i]=Temp.GetRegd_no();
                Arr_M[i]=Temp.GetMarks();
                Temp=Temp.Next;
            }
            for (int i=0;i<Length/2;i++)
            {
                float T1=Arr_M[Length-i-1];
                Arr_M[Length-i-1]=Arr_M[i];
                Arr_M[i]=T1;
                int T2=Arr_R[Length-i-1];
                Arr_R[Length-i-1]=Arr_R[i];
                Arr_R[i]=T2;
            }
            Temp=new Node(Arr_R[0],Arr_M[0]);
            Head=Temp;
            for (int i=1;i<Length;i++)
            {
                Temp.Next=new Node(Arr_R[i], Arr_M[i]);
                Temp=Temp.Next;
            }
            System.out.println("Linked List Reversed");
            return Head;
        }
    }
}*/

/*import java.util.*;
class Node
{
    protected int Regd_No;
    protected float Marks;
    protected Node Next;
    protected Node Previous;
    public Node(int Regd_No,float Marks,Node Previous)
    {
        this.Regd_No=Regd_No;
        this.Marks=Marks;
        this.Next=null;
        this.Previous=Previous;
    }
    public int GetRegd_no()
    {
        return Regd_No;
    }
    public float GetMarks()
    {
        return Marks;
    }
}
class EndSem
{
    public static void main(String args[])
    {
        Scanner Sc=new Scanner(System.in);
        Node Head=null;
        Node Tail=null;
        System.out.println("----------MENU----------");
        System.out.println("0:  Exit\n1:  Creation\n2:  Display\n3:  Insert In Beginning\n4:  Insert In Ending\n5:  Insert At Any Position\n6:  Delete In Beginning\n7:  Delete In Ending\n8:  Delete at Any Position\n9:  Search The Linked List\n10: Sort The Linked List\n11: Count The Elements\n12: Reverse The List");
        while(true)
        {
            System.out.print("\nEnter The Choice--> ");
            int Choice=Sc.nextInt();
            switch (Choice)
            {
                case 0:System.out.println("Exiting The Program");Sc.close();System.exit(0);
                case 1:Head=Create(Head,Tail);break;
                case 2:Display(Head,Tail);break;
                case 3:Head=InsertBeg(Head,Tail);if (Head==null){Head=Create(Head,Tail);Tail=Head;}break;
                case 4:Tail=InsertEnd(Head,Tail);if (Tail==null){Head=Create(Head,Tail);Tail=Head;}break;
                case 5:Head=InsertAtAny(Head,Tail);Tail=GetEnd(Head);break;
                case 6:Head=DeleteBeg(Head,Tail);break;
                case 7:Head=DeleteEnd(Head,Tail);break;
                case 8:Head=DeleteAtAny(Head,Tail);Tail=GetEnd(Head);break;
                case 9:Search(Head,Tail);break;
                //case 10:Head=Sort(Head,Tail);break;
                //case 11:System.out.println("The Number Of Nodes In The Linked List Is: "+Count(Head,Tail));break;
                //case 12:Head=Reverse(Head,Tail);break;
                default:System.out.println("Error In Selection");break;
            }
        }
    }
    public static Node Create(Node Head,Node Tail)
    {
        Scanner Sc=new Scanner(System.in);
        System.out.print("Enter The Registeration Number: ");
        int Redg=Sc.nextInt();
        System.out.print("Enter The Marks: ");
        float Mark=Sc.nextFloat();
        Node Temp=new Node(Redg, Mark,null);
        return Temp;
    }
    public static void Display(Node Head,Node Tail)
    {
        Node Temp=Head;
        if (Temp==null)
        System.out.println("Double Linked List Empty");
        else
        {
            int i=0;
            System.out.println("Index\tRedg_Number\tMarks");
            do
            {
                System.out.println(++i + "\t"+Temp.GetRegd_no()+"\t\t"+Temp.GetMarks());
                Temp=Temp.Next;
            }
            while(Temp!=null);
        }
    }
    public static Node GetEnd(Node Head)
    {
        if (Head==null)
        return null;
        else
        {
            Node Temp=Head;
            while(Temp!=null)
            {
                Temp=Temp.Next;
            }
            return Temp;
        }
    }
    public static Node InsertBeg(Node Head,Node Tail)
    {
        if (Head==null)
        return null;
        else
        {
            Scanner Sc=new Scanner(System.in);
            System.out.print("Enter The Registeration Number: ");
            int Redg=Sc.nextInt();
            System.out.print("Enter The Marks: ");
            float Marks=Sc.nextFloat();
            Node Temp=new Node(Redg, Marks, null);
            Temp.Next=Head;
            Head.Previous=Temp;
            return Temp;
        }
    }
    public static Node InsertEnd(Node Head, Node Tail)
    {
        Scanner Sc = new Scanner(System.in);
        System.out.print("Enter The Registration Number: ");
        int Regd = Sc.nextInt();
        System.out.print("Enter The Marks: ");
        float Marks = Sc.nextFloat();
        Node newNode = new Node(Regd, Marks, Tail);
        if (Tail != null)
        {
            Tail.Next = newNode;
        } 
        else
        {
            Head = newNode;
        }

        return newNode;
    }
    public static Node InsertAtAny(Node Head,Node Tail)
    {
        if (Head==null)
        return null;
        else
        {
            Node Temp=Head;
            int i=0;
            Scanner Sc=new Scanner(System.in);
            System.out.print("Enter The Position At Which To Be Inserted: ");
            int Position=Sc.nextInt();
            while (i<Position)
            {
                i++;
                if (Temp.Next==null)
                {
                    System.out.println("Entered Position Is Not Valid");
                    return Head;
                }
                Temp=Temp.Next;
            }
            System.out.print("Enter The Registeration Number: ");
            int Redg=Sc.nextInt();
            System.out.print("Enter The Marks: ");
            float Marks=Sc.nextFloat();
            Node Temp1=new Node(Redg, Marks, Tail);
            Temp1.Next=Temp.Next;
            Temp.Next.Previous=Temp1;
            Temp.Next=Temp1;
            return Head;
        }
    }
    public static Node DeleteBeg(Node Head,Node Tail)
    {
        if (Head==null)
        {
            System.out.print("Double Linked List Empty");
            return null;
        }
        else
        {
            Node Temp=Head;
            Temp=Temp.Next;
            Temp.Previous=null;
            return Temp;
        }
    }
    public static Node DeleteEnd(Node Head,Node Tail)
    {
        if (Tail==null)
        {
            System.out.println("Double Linked List Empty");
            return null;
        }
        else
        {
            Node Temp=Tail;
            Temp=Temp.Previous;
            Temp.Next=null;
            return Temp;
        }
    }

public static Node DeleteAtAny(Node Head,Node Tail)
    {
        if (Head==null)
        {
            return null;
        }
        else 
        {
            Scanner Sc=new Scanner(System.in);
            System.out.println("Enter The Position To Be Deleted: ");
            int Position=Sc.nextInt();
            if (Position==0)
            {
                return DeleteBeg(Head, Tail);
            }
            else
            {
                Node Temp=Head;
                int i=0;
                while(i<Position-1)
                {
                    Temp=Temp.Next;
                    if (Temp==null)
                    {
                        System.out.println("Entered Value Is More In Size");
                        return Head;
                    }
                    i++;
                }
                try
                {
                    Temp.Next=Temp.Next.Next;
                    Temp.Next.Previous=Temp;
                }
                catch (NullPointerException e)
                {
                    System.out.println("Null Value Is Found");
                }
            }
            System.out.println("Position Number Detected: "+Position);
            return Head;
        }
    }
    public static void Search(Node Head,Node Tail)
    {
        Scanner Sc=new Scanner(System.in);
        System.out.print("Enter The Redg_No To Be Searched: ");
        int Search=Sc.nextInt();
        boolean Key=false;
        Node Temp=Head;
        while (Temp!=null)
        {
            if (Temp.GetRegd_no()==Search)
            {
                Key=true;
                break;
            }
            else
            {
                Temp=Temp.Next;
            }
        }
        if (Key)
        System.out.println(Temp.GetRegd_no()+" Has Got "+Temp.GetMarks());
        else
        System.out.println("The Element Was Not Found.");
    }
}*/

/*import java.util.*;
class Node
{
    int Info;
    Node Next;
    Node (int Info)
    {
        this.Info=Info;
    }
}*/
/*class EndSem
{
    public static final int MAX_VALUE=10;
    public static void main(String args[])
    {
        Scanner Sc=new Scanner(System.in);
        int Stack[]=new int[MAX_VALUE];
        int Top=-1;
        System.out.println("--------MENU--------");
        System.out.println("0: Exit\n1: Push\n2: Pop\n3: Display");
        while(true)
        {
            System.out.print("\nEnter Your Choice--> ");
            int Choice=Sc.nextInt();
            switch (Choice)
            {
                case 0:System.out.println("Exiting Program");System.exit(0);break;
                case 1:Top=Push(Stack,Top);break;
                case 2:Top=Pop(Stack,Top);break;
                case 3:Display(Stack,Top);break;
                default:System.out.println("Invalid Input Here");break;
            }
        }
    }
    public static int Push(int Stack[],int Top)
    {
        if (IsFull(Top))
        {
            System.out.println("Error: Stack OverFlow");
            return Top;
        }
        else
        {
            Top++;
            Scanner Sc=new Scanner(System.in);
            System.out.print("Enter The Element To Push: ");
            Stack[Top]=Sc.nextInt();
            return Top;
        }
    }
    public static int Pop(int Stack[],int Top)
    {
        if (IsEmpty(Top))
        {
            System.out.println("Error: Stack Already Empty");
            return Top;
        }
        else
        {
            Top--;
            return Top;
        }
    }
    public static void Display(int Stack[],int Top)
    {
        if(IsEmpty(Top))
        {
            System.out.println("Error: Stack Already Empty");
        }
        else
        {
            System.out.println("Elements In The Stack");
            for (int i=0;i<=Top;i++)
            {
                System.out.print(Stack[i]+" --> ");
            }
            System.out.println("END");
        }
    }
    public static boolean IsFull(int Top)
    {
        return MAX_VALUE-1==Top;
    }
    public static boolean IsEmpty(int Top)
    {
        return Top==-1;
    }
}*/

/*class EndSem
{
    public static void main(String args[])
    {
        Scanner Sc=new Scanner(System.in);
        System.out.println("--------MENU--------");
        System.out.println("0: Exit\n1: Push\n2: Pop\n3: Display");
        Node Top=null;
        while(true)
        {
            System.out.print("\nEnter Your Choice--> ");
            int Choice=Sc.nextInt();
            switch (Choice)
            {
                case 0:System.out.println("Exiting Program");System.exit(0);break;
                case 1:Top=Push(Top);break;
                case 2:Top=Pop(Top);break;
                case 3:Display(Top);break;
                default:System.out.println("Invalid Input Here");break;
            }
        }
    }
    public static Node Push(Node Top)
    {
        Scanner Sc=new Scanner(System.in);
        System.out.print("Enter The Value To Be Pushed: ");
        Node node=new Node(Sc.nextInt());
        node.Next=Top;
        Top=node;
        return Top;
    }
    public static Node Pop(Node Top)
    {
        if (Top==null)
        {
            System.out.println("Error: Stack UnderFlow");
            return null;
        }
        else
        {
            Node Temp=Top;
            Temp=Temp.Next;
            return Temp;
        }
    }
    public static void Display(Node Top)
    {
        if (Top==null)
        {
            System.out.println("Stack Already Empty");
        }
        else
        {
            System.out.println("Elements Of The Stack");
            Node Temp=Top;
            while(Temp!=null)
            {
                System.out.print(Temp.Info+" --> ");
                Temp=Temp.Next;
            }
            System.out.println("END");
        }
    }
}*/

/*import java.util.*;
class Node
{
    int Info;
    Node Next;
    Node (int Info)
    {
        this.Info=Info;
        this.Next=null;
    }
}
class EndSem
{
    public static final int MAX_VALUE=5;
    public static int Front=-1;
    public static int Rear=-1;
    public static void main(String args[])
    {
        Scanner Sc=new Scanner(System.in);
        int Queue[]=new int[MAX_VALUE];
        System.out.println("--------MENU--------");
        System.out.println("0: Exit\n1: Push\n2: Pop\n3: Display");
        while(true)
        {
            System.out.print("\nEnter Your Choice--> ");
            int Choice=Sc.nextInt();
            switch (Choice)
            {
                case 0:System.out.println("Exiting Program");System.exit(0);break;
                case 1:Insert(Queue);break;
                case 2:Delete(Queue);break;
                case 3:Display(Queue);break;
                default:System.out.println("Invalid Input Here");break;
            }
        }
    }
    public static void Insert(int Queue[])
    {
        if (IsFull())
        {
            System.out.println("Error: Queue OverFlow");
        }
        else
        {
            Scanner Sc=new Scanner(System.in);
            System.out.print("Enter Value To Be Inserted: ");
            Queue[++Rear]=Sc.nextInt();
        }
    }
    public static void Delete(int Queue[])
    {
        if (IsEmpty())
        {
            System.out.println("Error: Queue Already Empty");
        }
        else
        {
            Front++;
        }
    }
    public static void Display(int Queue[])
    {
        if (IsEmpty())
        {
            System.out.println("Error: Queue Is Empty");
        }
        else
        {
            System.out.println("Queue Contains");
            for (int i=Front+1;i<=Rear;i++)
            {
                System.out.print(Queue[i]+" --> ");
            }
            System.out.println("END");
        }
    }
    public static boolean IsFull()
    {
        return Rear==MAX_VALUE-1;
    }
    public static boolean IsEmpty()
    {
        return Rear==Front;
    }
}*/

/*import java.util.Queue;
import java.util.*;
class EndSem
{
    public static void main(String args[])
    {
        Scanner Sc=new Scanner(System.in);
        Node Front=null,Rear=null;
        System.out.println("--------MENU--------");
        System.out.println("0: Exit\n1: Push\n2: Pop\n3: Display");
        while(true)
        {
            System.out.print("\nEnter Your Choice--> ");
            int Choice=Sc.nextInt();
            switch (Choice)
            {
                case 0:System.out.println("Exiting Program");System.exit(0);break;
                case 1:Front=Insert(Rear,Front);Rear=GetRear(Front);break;
                case 2:Delete(Rear,Front);break;
                case 3:Display(Rear,Front);break;
                default:System.out.println("Invalid Input Here");break;
            }
        }
    }
    public static Node Insert(Node Rear,Node Front)
    {
        Scanner Sc=new Scanner(System.in);
        System.out.print("Enter The Value In The Queue: ");
        Node Temp=new Node(Sc.nextInt());
        if (Rear==null||Front==null)
        {
            Front=Temp;
            Rear=Temp;
        }
        else
        {
            Rear.Next=Temp;
            Rear=Temp;
        }
        return Front;
    }
    public static Node Delete(Node Rear,Node Front)
    {
        if (Front==null)
        System.out.println("Error: Queue UnderFlow");
        else
        {
            Front=Front.Next;
        }
        return Front;
    }
    public static void Display(Node Rear,Node Front)
    {
        Node Temp=Front;
        if (Temp==null)
        {
            System.out.println("Queue Is Empty");
        }
        else
        {
            System.out.println("The Queue Is: ");
            while(Temp!=null)
            {
                System.out.print(Temp.Info+" --> ");
                Temp=Temp.Next;
            }
            System.out.println("END");
        }
    }
    public static Node GetRear(Node Front)
    {
        if (Front==null)
        {
            return null;
        }
        else
        {
            Node Temp=Front;
            while(Temp!=null)
            {
                Temp=Temp.Next;
            }
            return Temp;
        }
    }
}*/

/*class EndSem
{
    public static void main(String args[])
    {
        ABC(10);
    }
    public static void ABC(int N)
    {
        if (N==0)
        return;
        ABC(N-=2);
        System.out.print(N+" ");
    }
}*/

/*class EndSem
{
    public static void main(String args[])
    {
        int Decimal=25;
        System.out.println("The Binary Value Is: "+DecimalFormat(Decimal));
    }
    public static int DecimalFormat(int Decimal)
    {
        if(Decimal<=1)
			return Decimal;
		else
			return DecimalFormat(Decimal/2)*10+(Decimal%2);
    }
}*/

/*import java.util.*;
class EndSem
{
    public static void main(String args[])
    {
        Scanner Sc=new Scanner(System.in);
        int Arr[]={15,20,30,41,25,10,5};
        System.out.print("Enter The Element To Search: ");
        int Search=Sc.nextInt();
        int Index=LinearSearch(Arr, Search, 0);
        if (Index!=-1)
        System.out.println("The Element Is Found At "+Index);
        else
        System.out.println("The Element Is Not Found");
    }
    public static int LinearSearch(int[] Arr,int Search,int Index)
    {
        if (Index>=Arr.length)
        return -1;
        if (Search==Arr[Index])
        return Index;

        return LinearSearch(Arr, Search, Index+1);
    }
}

class EndSem
{
    public static void main(String args[])
    {
        int Arr[]={64, 34, 25, 12, 22, 11, 90};
        int Length=Arr.length;
        BubbleSort(Arr,Length);
        System.out.println("The Sorted Array Is: ");
        for(int i=0;i<Length;i++)
        {
            System.out.print(Arr[i]+" ");
        }
    }
    public static void BubbleSort(int[] Arr,int Length)
    {
        if (Length==1)
        return;
        for (int i=0;i<Length-1;i++)
        {
            if (Arr[i]>Arr[i+1])
            {
                int Temp=Arr[i];
                Arr[i]=Arr[i+1];
                Arr[i+1]=Temp;
            }
        }
        BubbleSort(Arr,Length-1);
    }
}*/

public class RecursiveSelectionSort
{
    public static void selectionSort(int[] arr, int n, int index)
    {
        if (index == n)
        {
            return;
        }
        int minIndex = index;
        for (int i = index + 1; i < n; i++) 
        {
            if (arr[i] < arr[minIndex])
            {
                minIndex = i;
            }
        }
        int temp = arr[minIndex];
        arr[minIndex] = arr[index];
        arr[index] = temp;
        selectionSort(arr, n, index + 1);
    }
    public static void main(String[] args)
    {
        int[] arr = {64, 25, 12, 22, 11};
        int n = arr.length;
        selectionSort(arr, n, 0);
        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
}
