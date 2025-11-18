import java.util.Scanner;
class Q8 {
    public static void main(String[] args) {
        try (Scanner Sc = new Scanner(System.in)) {
            System.out.print("Enter The Number To Be Reversed : ");
            int Number = Sc.nextInt();
            boolean isNegative = Number < 0;
            Number = Math.abs(Number);
            System.out.print("The Reversed Number Is : ");
            if (isNegative) {
                System.out.print("-");
            }
            while (Number > 0) {
                System.out.print(Number % 10);
                Number = Number / 10;
            }
        }
    }
}
