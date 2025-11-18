import java.util.Scanner;
import java.util.Stack;

class Q8 {
    static class Queue {
        Stack<Integer> Stack1 = new Stack<>();
        Stack<Integer> Stack2 = new Stack<>();

        void enqueue(int Data) {
            while (!Stack1.isEmpty()) {
                Stack2.push(Stack1.pop());
            }
            Stack1.push(Data);
            while (!Stack2.isEmpty()) {
                Stack1.push(Stack2.pop());
            }
        }

        int dequeue() {
            if (Stack1.isEmpty()) return -1;
            return Stack1.pop();
        }

        boolean isEmpty() {
            return Stack1.isEmpty();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue Queue = new Queue();

        System.out.print("Enter Number Of Elements To Add To The Queue : ");
        int Count = scanner.nextInt();
        System.out.print("Enter The Elements : ");
        for (int i = 0; i < Count; i++) {
            Queue.enqueue(scanner.nextInt());
        }

        System.out.print("Do You Want To Remove An Element? ");
        String Choice = scanner.next();
        if (Choice.equalsIgnoreCase("yes")) {
            System.out.println("Removed Element : " + Queue.dequeue());
        }

        System.out.println("Is Queue Empty? " + Queue.isEmpty());
    }
}
