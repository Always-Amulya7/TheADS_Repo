import java.util.Scanner;

class Q2 {
    static class Node {
        int Data;
        Node Next;

        Node(int Data) {
            this.Data = Data;
            this.Next = null;
        }
    }

    Node Head;

    // Insert at the beginning of the linked list
    public void insertFirst(int Data) {
        Node NewNode = new Node(Data);
        NewNode.Next = Head;
        Head = NewNode;
    }

    // Insert at the end of the linked list
    public void insertLast(int Data) {
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

    // Insert at a specific position in the linked list
    public void insertAtPosition(int Data, int Position) {
        Node NewNode = new Node(Data);
        if (Position == 0) {
            insertFirst(Data);
            return;
        }
        Node Temp = Head;
        for (int i = 1; i < Position && Temp != null; i++) {
            Temp = Temp.Next;
        }
        if (Temp != null) {
            NewNode.Next = Temp.Next;
            Temp.Next = NewNode;
        }
    }

    // Display the linked list
    public void displayList() {
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
        Q2 List = new Q2();
        String Choice;
        do {
            System.out.print("\nEnter The Choice : ");
            Choice = scanner.nextLine();
            switch (Choice) {
                case "Insert":
                    System.out.print("Insert At Beginning: ");
                    int FirstElement = scanner.nextInt();
                    List.insertFirst(FirstElement);
                    scanner.nextLine(); // Consume newline
                    break;
                case "AtEnd":
                    System.out.print("Insert At End: ");
                    int LastElement = scanner.nextInt();
                    List.insertLast(LastElement);
                    scanner.nextLine(); // Consume newline
                    break;
                case "Between":
                    System.out.print("Insert At Position: ");
                    int Position = scanner.nextInt();
                    System.out.print("Value To Insert: ");
                    int PositionElement = scanner.nextInt();
                    List.insertAtPosition(PositionElement, Position);
                    scanner.nextLine(); // Consume newline
                    break;
                case "Display":
                    List.displayList();
                    break;
                case "Exit":
                    System.out.print("Exiting...\n");
                    break;
                default:
                    System.out.print("Invalid Choice\n");
                    break;
            }
        } while (!Choice.equalsIgnoreCase("Exit"));
        scanner.close();
    }
}