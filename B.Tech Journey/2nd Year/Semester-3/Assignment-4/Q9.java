import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Q9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> Queue = new LinkedList<>();

        System.out.print("Enter Number Of Elements In The Queue : ");
        int Count = scanner.nextInt();
        System.out.print("Enter The Elements : ");
        for (int i = 0; i < Count; i++) {
            Queue.add(scanner.nextInt());
        }

        System.out.println("Original Queue : " + Queue);

        Queue = reverse(Queue);
        System.out.println("Reversed Queue : " + Queue);
    }

    public static Queue<Integer> reverse(Queue<Integer> Queue) {
        Stack<Integer> Stack = new Stack<>();
        while (!Queue.isEmpty()) {
            Stack.push(Queue.remove());
        }
        while (!Stack.isEmpty()) {
            Queue.add(Stack.pop());
        }
        return Queue;
    }
}