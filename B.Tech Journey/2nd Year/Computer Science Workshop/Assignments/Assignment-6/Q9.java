import java.util.Scanner;
class Q9 {
    public static void main(String[] args) {
        try (Scanner Sc = new Scanner(System.in)) {
            System.out.print("Enter The Number To Be Reversed : ");
            int Num = Sc.nextInt();
            boolean isNegative = Num < 0;
            int Number = Math.abs(Num);
            int Reverse = 0;
            int Temp = Number;
            while (Temp > 0) {
                Reverse = Reverse * 10 + Temp % 10;
                Temp = Temp / 10;
            }
            System.out.print("The Reversed Number Is : ");
            if (isNegative) {
                System.out.print("-");
            }
            System.out.println(Reverse);
            if (Number == Reverse) {
                System.out.println("Yes, It Is A Palindrome");
            } else {
                System.out.println("No, It Is Not A Palindrome");
            }
        }
    }
}
