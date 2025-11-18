import java.util.Scanner;
public class Q16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        String choice;
        do {
            System.out.print("Enter A Number: ");
            int num = scanner.nextInt();
            if (num > largest) largest = num;
            if (num < smallest) smallest = num;
            System.out.print("Do You Want To Continue?: ");
            choice = scanner.next();
        } while (choice.equalsIgnoreCase("yes"));
        System.out.println("Largest Number: " + largest);
        System.out.println("Smallest Number: " + smallest);
    }
}
