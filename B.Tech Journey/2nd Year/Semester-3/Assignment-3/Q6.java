import java.util.Scanner;

class Q6 {
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

    public void removeDuplicates() {
        Node Temp = Head;
        while (Temp != null && Temp.Next != null) {
            if (Temp.Data == Temp.Next.Data) {
                Temp.Next = Temp.Next.Next;
            } else {
                Temp = Temp.Next;
            }
        }
    }

    public Node reverseRecursively(Node Current) {
        if (Current == null || Current.Next == null) {
            return Current;
        }
        Node NewHead = reverseRecursively(Current.Next);
        Current.Next.Next = Current;
        Current.Next = null;
        return NewHead;
    }

    public void reverse() {
        Head = reverseRecursively(Head);
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
        Q6 List = new Q6();

        System.out.print("Enter Number Of Elements : ");
        int Count = scanner.nextInt();
        System.out.print("Enter The Elements : ");
        for (int i = 0; i < Count; i++) {
            List.insert(scanner.nextInt());
        }

        System.out.print("Original Linked List : ");
        List.display();

        List.removeDuplicates();
        System.out.print("Linked List After Removing Duplicates : ");
        List.display();

        List.reverse();
        System.out.print("Linked List After Reversing : ");
        List.display();

        scanner.close();
    }
}
