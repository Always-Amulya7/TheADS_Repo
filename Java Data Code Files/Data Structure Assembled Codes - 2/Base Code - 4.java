//Write a menu driven Java Program using class, methods and reference variables, to construct a singly linked list consisting of the following information in each node: 
//student regd_no (int), mark secured in a subject (float).

//The class definition should be as follows.
/*class Node
{
protected int regd_no;
protected float mark;
protected Node next;
}*/

//The prototype of the create method should be as follows.
//public static void create(Node start)
//Define the methods for each of the following operations to be supported by the above linked list are:
//a) The insertion operation
/*i. At the beginning of the list
Method Prototype: public static Node InsBeg(Node start)
ii. At the end of the list
Method Prototype: public static Node InsEnd(Node start)
iii. At any position in the list
Method Prototype: public static Node InsAny(Node start)*/
//b) The deletion operation
/*i. From the beginning of the list
Method Prototype: public static Node DelBeg(Node start)
ii. From the end of the list
Method Prototype: public static Node DelEnd(Node start)
iii. From any position in the list
Method Prototype: public static Node DelAny(Node start)
iv. Deleting a node based on student regd_no. If the specified node is not present
in the list an error message should be displayed. Both the option should be
demonstrated.*/
//c) Search a node based on student regd_no and update the mark of the student. If the specified node is not present in the list an error message should be displayed.
//Method Prototype: public static void search(Node start)
//d) Sort the nodes of the linked list according to the mark secured by the student from higher to lower. Method Prototype: public static void sort(Node start)
//e) Count the number of nodes present in the linked list Method Prototype: public static int count(Node start)
//f) Reverse the linked list Method Prototype: public static Node reverse(Node start)
//g) Displaying all the nodes in the list The prototype of the display function should be as follows. public static void display(Node start)

/*The template for menu driven java program to use the above list and invoke the required methods to perform different operations is given below.
public class LinkedList
{
public static void create(Node start)
{
-------
-----
}
public static void display(Node start)
{
-----
------
}*/

//Code for the remaining user defined methods
/*public static void main(String[] args) {
-----
-----
while(true)
{
System.out.println("****MENU*****");
System.out.println("0:Exit");
System.out.println("1:Creation");
System.out.println("2:Display");
-----
-----
System.out.println("Enter the choice");
choice=sc.nextInt();
switch(choice)
{
case 0:
System.exit(0);
case 1:
create(start);
break;
case 2:
display(start);
break;
-----
default:
System.out.println("Wrong choice");
}
}
}
}*/


import java.util.Scanner;
class Node
{
    protected int regd_no;
    protected float mark;
    protected Node next;

    public Node(int regd_no, float mark)
    {
        this.regd_no = regd_no;
        this.mark = mark;
        this.next = null;
    }
}

public class LinkedList
{
    public static Node start = null;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true)
        {
            System.out.println("****MENU*****");
            System.out.println("0: Exit");
            System.out.println("1: Creation");
            System.out.println("2: Display");
            // ... other menu options ...
            System.out.println("Enter the choice:");
            choice = sc.nextInt();

            switch (choice) {
                case 0:
                    System.exit(0);
                case 1:
                    create();
                    break;
                case 5:
                    display();
                    break;
                // ... other cases for menu options ...
                default:
                    System.out.println("Wrong choice");
            }
        }
    }

    public static void create()
    {
        Scanner sc = new Scanner(System.in);
        int regd_no;
        do
        {
            System.out.println("Enter student details (regd_no mark) or -1 -1 to exit creation:");
            regd_no = sc.nextInt();
            if (regd_no != -1)
            {
                float mark = sc.nextFloat();
                start = InsBeg(start, regd_no, mark); // Create by inserting at the beginning
            }
        } while (regd_no != -1);
    }

    public static Node InsBeg(Node start, int regd_no, float mark)
    {
        Node newNode = new Node(regd_no, mark);
        newNode.next = start;
        return newNode;
    }

    public static Node InsEnd(Node start, int regd_no, float mark)
    {
        Node newNode = new Node(regd_no, mark);
        if (start == null)
        {
            return newNode;
        }
        Node temp = start;
        while (temp.next != null)
        {
            temp = temp.next;
        }
        temp.next = newNode;
        return start;
    }

    public static Node InsAny(Node start, int regd_no, float mark)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter position to insert (starting from 1):");
        int pos = sc.nextInt();
        if (pos < 1)
        {
            System.out.println("Invalid position");
            return start;
        }

        Node newNode = new Node(regd_no, mark);
        if (pos == 1)
        {
            newNode.next = start;
            return newNode;
        }

        Node temp = start;
        for (int i = 1; i < pos - 1 && temp != null; i++)
        {
            temp = temp.next;
        }

        if (temp == null)
        {
            System.out.println("Invalid position (out of bounds)");
            return start;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        return start;
    }

    public static Node DelBeg(Node start)
    {
        if (start == null)
        {
            System.out.println("List is empty");
            return null;
        }
        return start.next;
    }

    public static Node DelEnd(Node start)
    {
        if (start == null)
        {
            System.out.println("List is empty");
            return null;
        }
        if (start.next == null)
        {
            return null;
        }
        Node temp = start;
        while (temp.next.next != null)
        {
            temp = temp.next;
        }
        temp.next = null;
        return start;
    }

    public static Node DelAny(Node start)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter regd_no to delete:");
        int del_regd_no = sc.nextInt();

        if (start == null)
        {
            System.out.println("List is empty");
            return null;
        }

        if (start.regd_no == del_regd_no)
        {
            return DelBeg(start);
        }

        Node temp = start;
        Node prev = null;
        while (temp != null && temp.regd_no != del_regd_no)
        {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null)
        {
            System.out.println("Student not found");
            return start;
        }

        prev.next = temp.next;
        return start;
    }

    public static void search(Node start)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter regd_no to search:");
        int search_regd_no = sc.nextInt();

        Node temp = start;
        boolean found = false;
        while (temp != null)
        {
            if (temp.regd_no == search_regd_no)
            {
                System.out.println("Student Found!");
                System.out.println("Regd No: " + temp.regd_no);
                System.out.println("Mark: " + temp.mark);
                found = true;
                break;
            }
            temp = temp.next;
        }

        if (!found)
        {
            System.out.println("Student not found");
        }
    }

    public static void display()
    {
        if (start == null)
        {
            System.out.println("List is empty");
            return;
        }

        Node temp = start;
        System.out.println("List of students:");
        while (temp != null)
        {
            System.out.println("Regd No: " + temp.regd_no + ", Mark: " + temp.mark);
            temp = temp.next;
        }
    }
}