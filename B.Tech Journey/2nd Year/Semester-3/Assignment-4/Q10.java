import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Q10 {

    public static void reverseQueue(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }
        int element = queue.poll();
        reverseQueue(queue);
        queue.add(element);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();

        System.out.print("Enter The Number Of Elements In The Queue : ");
        int count = scanner.nextInt();

        System.out.print("Enter The Elements Of The Queue: ");
        for (int i = 0; i < count; i++) {
            queue.add(scanner.nextInt());
        }

        System.out.println("Original Queue: " + queue);
        
        reverseQueue(queue);
        
        System.out.println("Reversed Queue: " + queue);

        scanner.close();
    }
}
