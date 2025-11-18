import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Q7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> Queue = new LinkedList<>();

        System.out.print("Enter Number Of Elements To Add To The Queue : ");
        int Count = scanner.nextInt();
        System.out.print("Enter the Elements : ");
        for (int i = 0; i < Count; i++) {
            Queue.add(scanner.nextInt());
        }

        System.out.println("Initial Queue : " + Queue);
        String Exit="";
        while (!Exit.equalsIgnoreCase("Exit")) {
            System.out.print("Do You Want to Remove An Element? ");
            String RemoveChoice = scanner.next();
            if (RemoveChoice.equalsIgnoreCase("yes")) {
                if (!Queue.isEmpty()) {
                    System.out.println("Removed Element : " + Queue.remove());
                } else {
                    System.out.println("Queue Is Empty");
                }
            }
            System.out.print("Wish To Exit: ");
            Exit = scanner.next();
        }

        System.out.println("Final Queue : " + Queue);
    }
}