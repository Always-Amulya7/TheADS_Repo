import java.util.Scanner;

class Q10 {
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

    public void deleteAllOccurrences(int Value) {
        while (Head != null && Head.Data == Value) {
            Head = Head.Next;
        }

        Node Temp = Head;
        while (Temp != null && Temp.Next != null) {
            if (Temp.Next.Data == Value) {
                Temp.Next = Temp.Next.Next;
            } else {
                Temp = Temp.Next;
            }
        }
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
        Q10 List = new Q10();

        System.out.print("Enter Number Of Elements : ");
        int Count = scanner.nextInt();
        System.out.print("Enter The Elements : ");
        for (int i = 0; i < Count; i++) {
            List.insert(scanner.nextInt());
        }

        System.out.println("Original Linked List : ");
        List.display();

        System.out.print("Enter The Value To Delete All Occurrences : ");
        int Value = scanner.nextInt();
        List.deleteAllOccurrences(Value);

        System.out.println("Linked List After Deleting All Occurrences Of " + Value + ":");
        List.display();
    }
}