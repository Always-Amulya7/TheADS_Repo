import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter An Integer: ");
        String input = scanner.nextLine();
        Integer obj = Integer.valueOf(input);
        System.out.println("Integer Object: " + obj);
    }
}
