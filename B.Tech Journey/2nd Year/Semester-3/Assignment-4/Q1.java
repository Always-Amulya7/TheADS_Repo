import java.util.Scanner;
import java.util.Stack;

class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        System.out.print("Enter Number Of Elements To Push : ");
        int count = scanner.nextInt();
        System.out.print("Enter The Elements: ");
        for (int i = 0; i < count; i++) {
            stack.push(scanner.nextInt());
        }

        System.out.println("Stack: " + stack);
        String choice;
        String Exit = "";
        while (!Exit.equalsIgnoreCase("Exit")) {
            System.out.print("Do You Want To Pop An Element : ");
            choice = scanner.next();
            if (choice.equalsIgnoreCase("yes")) {
                if (!stack.isEmpty()) {
                    int popped = stack.pop();
                    System.out.println("Popped Element : " + popped);
                } else {
                    System.out.println("Stack Is Empty");
                    break;
                }
            }
            System.out.print("Wish To Exit: ");
            Exit = scanner.next();
        }

        System.out.println("Is Stack Empty? " + stack.isEmpty());
        System.out.println("Final Stack: " + stack);
    }
}
