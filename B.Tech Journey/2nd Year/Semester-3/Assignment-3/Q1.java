import java.util.List;
import java.util.Scanner;

class Q1 {
    static class Node {
        int Data;
        Node Next;

        Node(int Data) {
            this.Data = Data;
            this.Next = null;
        }
    }

    Node Head;

    public void insertFirst(int Data) {
        Node NewNode = new Node(Data);
        NewNode.Next = Head;
        Head = NewNode;
    }

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
        Q1 List = new Q1();
        String Choice;
        do {
            System.out.print("Enter The Choice : ");
            Choice = scanner.nextLine();
            switch (Choice) {
                case "Insert":
                    System.out.println("Enter Elements For The Linked List : ");
                    System.out.print("Insert At Beginning: ");
                    int FirstElement = scanner.nextInt();
                    List.insertFirst(FirstElement);
                    scanner.nextLine();
                    break;
                case "Display":
                    System.out.print("Final Linked List : ");
                    List.displayList();
                    break;
                case "Exit":
                    System.out.print("Exiting...");
                    break;
                default:
                    System.out.print("Invalid Choice");
                    break;
            }
        } while (!Choice.equalsIgnoreCase("Exit"));
    }
}
