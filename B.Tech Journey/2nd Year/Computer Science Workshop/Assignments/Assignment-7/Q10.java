import java.util.Scanner;
class Q10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter An Expression: ");
        String expression = scanner.nextLine();
        char operator = expression.replaceAll("\\d", "").charAt(0);
        String[] numbers = expression.split("[-+*/]");
        int num1 = Integer.parseInt(numbers[0]);
        int num2 = Integer.parseInt(numbers[1]);
        switch (operator) {
            case '+':
                System.out.println("Sum = " + (num1 + num2));
                break;
            case '-':
                System.out.println("Difference = " + (num1 - num2));
                break;
            case '*':
                System.out.println("Product = " + (num1 * num2));
                break;
            case '/':
                System.out.println("Quotient = " + (num1 / num2));
                break;
        }
    }
}
