import java.util.Scanner;
import java.util.Stack;

class Q5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> Stack = new Stack<>();

        System.out.print("Enter Number Of Elements In The Stack : ");
        int Count = scanner.nextInt();
        System.out.print("Enter The Elements : ");
        for (int i = 0; i < Count; i++) {
            Stack.push(scanner.nextInt());
        }

        System.out.println("Original Stack : " + Stack);

        sortStack(Stack);
        System.out.println("Sorted Stack : " + Stack);

        scanner.close();
    }

    public static void sortStack(Stack<Integer> Stack) {
        if (!Stack.isEmpty()) {
            int Temp = Stack.pop();
            sortStack(Stack);
            insertInSortedOrder(Stack, Temp);
        }
    }

    private static void insertInSortedOrder(Stack<Integer> Stack, int Element) {
        if (Stack.isEmpty() || Element > Stack.peek()) {
            Stack.push(Element);
        } else {
            int Temp = Stack.pop();
            insertInSortedOrder(Stack, Element);
            Stack.push(Temp);
        }
    }
}