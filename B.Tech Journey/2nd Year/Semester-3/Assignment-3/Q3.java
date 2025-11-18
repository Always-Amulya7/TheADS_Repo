import java.util.Scanner;

class Q3 {
    static class Node {
        int Data;
        Node Next;

        Node(int Data) {
            this.Data = Data;
            this.Next = null;
        }
    }

    Node Head;

    // Insert at the end of the linked list
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

    // Delete the first node
    public void deleteFirst() {
        if (Head != null) {
            Head = Head.Next;
        }
    }

    // Delete the last node
    public void deleteLast() {
        if (Head == null || Head.Next == null) {
            Head = null;
            return;
        }
        Node Temp = Head;
        while (Temp.Next.Next != null) {
            Temp = Temp.Next;
        }
        Temp.Next = null;
    }

    // Delete a node at a specific position (0-based index)
    public void deleteAtPosition(int Position) {
        if (Position == 0) {
            deleteFirst();
            return;
        }
        Node Temp = Head;
        for (int i = 1; i < Position && Temp.Next != null; i++) {
            Temp = Temp.Next;
        }
        if (Temp.Next != null) {
            Temp.Next = Temp.Next.Next;
        }
    }

    // Display the linked list
    public void display() {
        Node Temp = Head;
        System.out.print("\nLinked List: ");
        while (Temp != null) {
            System.out.print(Temp.Data + " -> ");
            Temp = Temp.Next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Q3 List = new Q3();

        System.out.print("Enter Number Of Elements : ");
        int Count = scanner.nextInt();
        System.out.print("Enter the Elements : ");
        for (int i = 0; i < Count; i++) {
            List.insert(scanner.nextInt());
        }

        System.out.println("Original List : ");
        List.display();

        System.out.println("Choose Deletion Operation : ");
        System.out.print("Enter Your Choice : ");
        int Choice = scanner.nextInt();

        switch (Choice) {
            case 1:
                List.deleteFirst();
                System.out.print("After Deleting First : ");
                List.display();
                break;
            case 2:
                List.deleteLast();
                System.out.print("After Deleting Last : ");
                List.display();
                break;
            case 3:
                System.out.print("Enter Position to Delete : ");
                int Position = scanner.nextInt();
                List.deleteAtPosition(Position);
                System.out.print("After Deleting At Position " + Position + ":");
                List.display();
                break;
            default:
                System.out.print("Invalid Choice");
        }

        scanner.close();
    }
}
