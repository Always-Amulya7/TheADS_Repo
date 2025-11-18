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