import java.util.Scanner;

class Q5 {
    static class Node {
        int Data;
        Node Next;

        Node(int Data) {
            this.Data = Data;
            this.Next = null;
        }
    }

    Node Head;

    // Insert a new node at the end of the linked list
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

    // Sort the linked list in ascending order
    public void sort() {
        if (Head == null || Head.Next == null) return;

        Node Temp = Head;
        while (Temp != null) {
            Node Index = Temp.Next;
            while (Index != null) {
                if (Temp.Data > Index.Data) {
                    int Swap = Temp.Data;
                    Temp.Data = Index.Data;
                    Index.Data = Swap;
                }
                Index = Index.Next;
            }
            Temp = Temp.Next;
        }
    }

    // Display the linked list
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
        Q5 List = new Q5();

        System.out.print("Enter Number Of Elements : ");
        int Count = scanner.nextInt();
        System.out.print("Enter The Elements : ");
        for (int i = 0; i < Count; i++) {
            List.insert(scanner.nextInt());
        }

        System.out.print("Linked List Before Sorting : ");
        List.display();

        List.sort();
        System.out.print("Linked List After Sorting : ");
        List.display();

        scanner.close();
    }
}