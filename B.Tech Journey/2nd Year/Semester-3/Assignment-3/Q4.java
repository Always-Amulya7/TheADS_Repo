import java.util.Scanner;

class Q4 {
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

    // Search for an element in the linked list
    public boolean search(int Key) {
        Node Temp = Head;
        while (Temp != null) {
            if (Temp.Data == Key) {
                return true;
            }
            Temp = Temp.Next;
        }
        return false;
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
        Q4 List = new Q4();

        System.out.print("Enter Number Of Elements In The Linked List: ");
        int Count = scanner.nextInt();
        System.out.print("Enter The Elements: ");
        for (int i = 0; i < Count; i++) {
            List.insert(scanner.nextInt());
        }

        System.out.print("Original Linked List: ");
        List.display();

        System.out.print("Enter Element to Search: ");
        int Key = scanner.nextInt();
        boolean Found = List.search(Key);

        if (Found) {
            System.out.println("Element Found In The Linked List");
        } else {
            System.out.println("Element Not Found In The Linked List");
        }

        scanner.close();
    }
}
