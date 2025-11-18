import java.util.Scanner;
import java.util.HashSet;

class Q7 {
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

    // Remove duplicate nodes from the linked list
    public void removeDuplicates() {
        if (Head == null) return;

        HashSet<Integer> seen = new HashSet<>();
        Node current = Head;
        Node prev = null;

        while (current != null) {
            if (seen.contains(current.Data)) {
                prev.Next = current.Next;  // Remove duplicate
            } else {
                seen.add(current.Data);
                prev = current;
            }
            current = current.Next;
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
        Q7 List = new Q7();

        System.out.print("Enter Number Of Elements: ");
        int Count = scanner.nextInt();
        System.out.print("Enter The Elements: ");
        for (int i = 0; i < Count; i++) {
            List.insert(scanner.nextInt());
        }

        System.out.print("Original Linked List: ");
        List.display();

        List.removeDuplicates();
        System.out.print("Linked List After Removing Duplicates: ");
        List.display();

        scanner.close();
    }
}
