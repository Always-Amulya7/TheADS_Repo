import java.util.Scanner;

class Q8 {
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

    public Q8 copyInReverseOrder() {
        Q8 NewList = new Q8();
        Node Temp = Head;
        while (Temp != null) {
            Node NewNode = new Node(Temp.Data);
            NewNode.Next = NewList.Head;
            NewList.Head = NewNode;
            Temp = Temp.Next;
        }
        return NewList;
    }

    public void display() {
        Node Temp = Head;
        System.out.print("\nLinked List : ");
        while (Temp != null) {
            System.out.print(Temp.Data + " -> ");
            Temp = Temp.Next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Q8 List = new Q8();

        System.out.print("Enter Number Of Elements : ");
        int Count = scanner.nextInt();
        System.out.print("Enter The Elements : ");
        for (int i = 0; i < Count; i++) {
            List.insert(scanner.nextInt());
        }

        System.out.print("Original Linked List : ");
        List.display();

        Q8 ReversedList = List.copyInReverseOrder();
        System.out.print("Copied Reversed Linked List : ");
        ReversedList.display();
    }
}