import java.util.Scanner;
import java.util.Stack;

class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter A Parenthesis Expression : ");
        String Expression = scanner.next();

        Stack<Integer> Stack = new Stack<>();
        int Count = 1;
        System.out.print("Parenthesis Numbers : ");
        for (char c : Expression.toCharArray()) {
            if (c == '(') {
                Stack.push(Count);
                System.out.print(Count++ + " ");
            } else if (c == ')') {
                System.out.print(Stack.pop() + " ");
            }
        }
        System.out.println();
    }
}
