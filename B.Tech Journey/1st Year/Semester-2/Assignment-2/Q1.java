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