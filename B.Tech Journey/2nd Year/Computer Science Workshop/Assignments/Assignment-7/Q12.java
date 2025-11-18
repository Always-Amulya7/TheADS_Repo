import java.util.Scanner;

class Q12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter An Integer As A String: ");
        String input = scanner.nextLine();
        int value = Integer.parseInt(input);
        System.out.println("Integer Base Type: " + value);
    }
}
