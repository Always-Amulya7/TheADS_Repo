import java.util.Scanner;

class Q9 {
    static class Node {
        int Data;
        Node Next;

        Node(int Data) {
            this.Data = Data;
            this.Next = null;
        }
    }

    Node Head;

    public void insert(int Data) {
        Node NewNode = new Node(Data);
        if (Head == null) {
            Head = NewNode;
            return;
        }
        Node Temp = Head;
        while (Temp.Next != null) {
            Temp = Temp.Next;
        }
        Temp.Next = NewNode;
    }

    public boolean compare(Q9 List) {
        Node Temp1 = Head;
        Node Temp2 = List.Head;

        while (Temp1 != null && Temp2 != null) {
            if (Temp1.Data != Temp2.Data) {
                return false;
            }
            Temp1 = Temp1.Next;
            Temp2 = Temp2.Next;
        }
        return Temp1 == null && Temp2 == null;
    }

    public void display() {
        Node Temp = Head;
        System.out.print("Linked List : ");
        while (Temp != null) {
            System.out.print(Temp.Data + " -> ");
            Temp = Temp.Next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Q9 List1 = new Q9();
        Q9 List2 = new Q9();

        System.out.print("Enter Number Of Elements :");
        int Count1 = scanner.nextInt();
        System.out.print("Enter The Elements For First Linked List : ");
        for (int i = 0; i < Count1; i++) {
            List1.insert(scanner.nextInt());
        }

        System.out.print("Enter Number Of Elements For Second Linked List : ");
        int Count2 = scanner.nextInt();
        System.out.print("Enter The Elements For Second Linked List : ");
        for (int i = 0; i < Count2; i++) {
            List2.insert(scanner.nextInt());
        }

        System.out.print("First Linked List : ");
        List1.display();
        System.out.print("Second Linked List : ");
        List2.display();

        if (List1.compare(List2)) {
            System.out.println("The Two Linked Lists Are Equal");
        } else {
            System.out.println("The Two Linked Lists Are Not Equal");
        }
    }
}