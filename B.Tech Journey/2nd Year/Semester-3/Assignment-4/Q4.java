import java.util.Scanner;
import java.util.Stack;

class Q4 {
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

        Stack<Integer> ReversedStack = reverse(Stack);
        System.out.println("Reversed Stack : " + ReversedStack);
    }

    public static Stack<Integer> reverse(Stack<Integer> Stack) {
        Stack<Integer> TempStack = new Stack<>();
        while (!Stack.isEmpty()) {
            TempStack.push(Stack.pop());
        }
        return TempStack;
    }
}
