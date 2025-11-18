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
