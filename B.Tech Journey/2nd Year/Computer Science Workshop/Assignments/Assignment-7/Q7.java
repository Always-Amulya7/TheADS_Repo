import java.util.Scanner;

public class Q7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter A Double: ");
        String input = scanner.nextLine();
        Double obj = Double.valueOf(input);
        System.out.println("Double Object: " + obj);
    }
}
