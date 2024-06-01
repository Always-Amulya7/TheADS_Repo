//Define a class Person with two instance variables:
// name and age and two member methods:
// setData(): set the details of the person.
// displayData(): display the details of the person.
//Now, create two objects of class person and initialize one object value directly (by
//using the dot(.) operator name: “Rohan” and age: 20 ). Accept your name and age
//through the keyboard and set them to another object using the setData() method.
//Now display both the member variables using the displayData() method. Also, check
//who is younger.

import java.util.Scanner;
class Person
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
        System.out.println(this.Name);
        System.out.println(this.Age);
    }
}
class Q1
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in)){
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
        System.out.print(S1.Name+" Is Younger");}
    }
}

//Define a class called Complex with instance variables real, imag and instance methods
// void setData(),
// void display(),
// public Complex add(Complex, Complex)
//Write the main method in a separate class to implement the addition of two complex
//number with the given method signature as above.

class Complex
{
    double real;
    double imag;
    public void setData(double real, double imag)
    {
        this.real = real;
        this.imag = imag;
    }
    public void display()
    {
        System.out.println(real + " + " + imag + "i");
    }
    public Complex add(Complex num1, Complex num2)
    {
        Complex result = new Complex();
        result.real = num1.real + num2.real;
        result.imag = num1.imag + num2.imag;
        return result;
    }
}
public class Q2
{
    public static void main(String[] args)
    {
        Complex num1 = new Complex();
        Complex num2 = new Complex();

        num1.setData(3.5, 2.0);
        num2.setData(1.5, 4.5);

        Complex sum = num1.add(num1, num2);

        System.out.println("First complex number:");
        num1.display();
        System.out.println("Second complex number:");
        num2.display();
        System.out.println("Sum of the complex numbers:");
        sum.display();
    }
}

//In a super market each product is having minimum details like prodId, price, quantity
//that is used during the biling process. Keeping this in mind prepare a class named as
//Product having the member variables
// prodId, price, quantity
// a static variable totalPrice
//Initialize the value of product through parameterized constructor. It consists of a
//display() method to display the value of instance variables. A person went to market
//and purchase 5 different products. Using the above mentioned class, display the details
//of products that the person has purchased. Also, determine how much total amount
//the person will pay for the purchase of 5 products.

class Product
{
    private int prodId;
    private double price;
    private int quantity;
    private static double totalPrice = 0;
    public Product(int prodId, double price, int quantity)
    {
        this.prodId = prodId;
        this.price = price;
        this.quantity = quantity;
        totalPrice += price * quantity;
    }
    public void display()
    {
        System.out.println("Product ID: " + prodId);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("-------------------------");
    }
    public static double getTotalPrice() 
    {
        return totalPrice;
    }
}
public class Q3 
{
    public static void main(String[] args)
    {
        /*Product product1 = new Product(1, 10.5, 2);
        Product product2 = new Product(2, 20.75, 3);
        Product product3 = new Product(3, 15.0, 1);
        Product product4 = new Product(4, 8.25, 4);
        Product product5 = new Product(5, 12.0, 2);
        System.out.println("Details of Purchased Products:");
        product1.display();
        product2.display();
        product3.display();
        product4.display();
        product5.display();*/
        Product[] Arr=new Product[5];
        Arr[0]=new Product(1, 10.5, 2);
        Arr[1]=new Product(2, 20.75, 3);
        Arr[2]=new Product(3, 15.0, 1);
        Arr[3]=new Product(4, 8.25, 4);
        Arr[4]=new Product(5, 12.0, 2);
        for (int i=0;i<Arr.length;i++)
        {
            Arr[i].display();
        }
        System.out.println("Total Amount to be paid: $" + Product.getTotalPrice());
    }
}

//Define a class Deposit. The instance variable of the class Deposit are mentioned below.
//Instance Variable    Data Type
//Principal            Long
//Time                 Integer
//Rate                 Double
//TotalAmt             Double
//Initialize the instance variables Principal, Time, rate through constructors. Constructors
//are overloaded with the following prototypes.
//Constructor1: Deposit ( )
//Constructor2: Deposit (long, int, double)
//Constructor3: Deposit (long, int)
//Constructor4: Deposit (long, double)
//Apart from constructor, the other instance methods are
//(i) display ( ): to display the value of instance variables,
//(ii) calcAmt( ): to calculate the total amount.
//totalAamt = Principal + (PrincipalÖrateÖTime)/100;

class Deposit
{
    private Long Principal;
    private int Time;
    private double Rate,TotalAmt;
    Deposit()
    {
        System.out.println("Enter To Initialize: ");
    }
    Deposit (long P, int T, double R)
    {
        this.Principal=P;
        this.Time=T;
        this.Rate=R;
    }
    Deposit (long P, int T)
    {
        this.Principal=P;
        this.Time=T;
    }
    Deposit (long P, double R)
    {
        this.Principal=P;
        this.Rate=R;
    }
    void Display()
    {
        System.out.println("Principal="+Principal);
        System.out.println("Rate="+Rate);
        System.out.println("Time="+Time);
    }
    public double calcAmt()
    {
        TotalAmt=(Principal+(Principal*Rate*Time)/100);
        return TotalAmt;
    }
}
public class Q4
{
    public static void main(String args[])
    {
        Deposit Ob1 = new Deposit(5000L, 2, 5.0);
        Deposit Ob2 = new Deposit(5000, 2);
        Deposit Ob3 = new Deposit(5000, 5);
        Ob1.Display();
        System.out.println("Total Amount 1: " + Ob1.calcAmt());
        Ob2.Display();
        System.out.println("Total Amount 2: " + Ob2.calcAmt());
        Ob3.Display();
        System.out.println("Total Amount 3: " + Ob3.calcAmt());
    }
}

//Define a base class Person with instance variable name, age. The instance variables are initialized through constructors. The prototype of constructor is as below.
//Person (string, int)
//Define a derived class Employee with instance variables Eid, salary. The instance
//variables are initialized through constructors. The prototype of constructor is as below.
//Employee (string, int, int, double).
//Another instance method of Employee class is empDisplay() to display the information
//of employee details.

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
    int Eid;
    double Salary;
    Employee(String Name,int Age,int Eid,double Salary)
    {
        super(Name, Age);
        this.Eid = Eid;
        this.Salary = Salary;
    }
    void empDisplay()
    {
        System.out.println("Employee ID: " + Eid);
        System.out.println("Name: " + Name);
        System.out.println("Age: " + Age);
        System.out.println("Salary: " + Salary);
    }
}
public class Q5
{
    public static void main(String[] args)
    {
        Employee Ob = new Employee("Amulya", 19, 123456, 560000);
        Ob.empDisplay();
    }
}

//Create an abstract class Marks with three instance variables (markICP, markDSA, and percentage) and an abstract method getPercentage(). Create two classes: CSE
//with instance variable algoDesign, and NonCSE with instance variable enggMechanics. Both classes inherit the abstract class Marks and override the abstract method
//getPercentage(). The constructor of class CSE takes the marks in three subjects (markICP, markDSA, and algoDesign) as its parameters, and the constructor of class
//NonCSE takes the marks in three subjects (markICP, markDSA, and enggMechanics) as its parameters. Create an object for each of the two classes and print the percentage
//of marks for both students.

abstract class Marks 
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

public class Q6
{
    public static void main(String[] args)
    {
        CSE cseStudent = new CSE(80, 85, 90);
        NonCSE nonCseStudent = new NonCSE(75, 78, 82);
        cseStudent.getPercentage();
        nonCseStudent.getPercentage();
    }
}

//Define an interface DetailInfo to declare methods display( ) & count( ). Another class Person contains a static data member maxcount, instance member name & method
//display( ) to display name of a person, count the no. of characters present in the name of the person.

interface DetailInfo
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

public class Q7
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
}

//A sales person is paid commission based on the sales he makes as shown by the following table:
//SALES                         COMMISSION
//Under Rs. 100                 2% of SALES
//Rs 500 and under Rs 5000      5% of Sales
//Rs 5000 and above             8% of sales
//Write a class, Commission, which has:
//An instance variable, sales; an appropriate constructor; and a method,
//getCommission() that returns the commission.
//Now write a Demo class in Java to test the Commission class by reading
//a sale from the user, using it to create a Commission object after
//validating that the value is not negative. Finally, call the getcommission()
//method to get and print the commission.

import java.util.*;
class Commission
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
class Q11
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
}

//Define a class called Book with instance variables BName, BEdition, BPrice. Use constructor to initialize the instance variables of the class.
//Another instance method display ( ) to display the book information. A person purchase 5 different books. Display the book details which has the maximum price.

import java.util.*;
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

public class Q12
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
}

//Create a class Bank with two instance variables: bankNname, depositAamount and a class variable totalAamount. Defined three member
//methods: setBankName() to set the bank name, setAmount() to set the deposit amount, and showData() for displaying the bank name and deposit
//amount. A person visited 5 different banks and deposite money. Create 5 array object of class Bank set the bank name and deposit
//amount (the minimum deposit amount is 1000) using member methods setBankName() and setAmount(). Call the showData() method to display
//the information with totalAmount deposited by the person. Also, design a method that displays the bank name where the person deposits the minimum amount.

import java.util.*;
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
public class Q13
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
}

//Write a Java code that would represent Distance object (meters, centimetres) using classes. The class definition include a parameterized 3 constructor, 
//void display ( ) to display the instance variables, void sum (Distance, Distance) to add two distances. Now write a main function that creates a couple of Distance 
//objects and demonstrates the addition of two distances.

class Distance 
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

public class Q14
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
}

//A point in the x-y plane is represented by its x-coordinate and ycoordinate. Design a class, PointType in Java, that can store and processa point in the x-y plane. 
//You should then perform operations on the point, such as showing the point, setting the coordinates of the point, printing the coordinates of the point, returning the
//x-coordinate, and returning the y- coordinate. Every circle has a centre and a radius. Given the radius, we can determine the circle’s area and circumference.
//Given the centre, we can determine its position in the x-y plane. The centre of a circle is a point in the x-y plane. Design a class, CircleType that can store the 
//radius and centre of the circle. Because the center is a point in the x-y plane and you designed the class to capture the properties of a point from PointType class. 
//You must derive the class CircleType from the class PointType. You should be able to perform the usual operations on a circle, such as setting the radius, printing the
//radius, calculating and printing the area and circumference, and carrying out the usual operations on the center.

class PointType
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

public class Q15
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
}