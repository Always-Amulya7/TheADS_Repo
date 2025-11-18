// import java.uitl.*;
// import java.util.Random;
// import java.util.Scanner;
// class Q3{
//     public static void main(String args[]){
//         try(Scanner Sc=new Scanner(System.in)){
//             System.out.print("Enter The Any Single Prime Number : ");
//             int Number=Sc.nextInt();
//             int[] Arr=new int[Number];
//             if (((Number+1)%2==0) && ((Number-1)%2!=0))
//             {
//                 System.out.println("Input Accepted !!");
//                 for (int i=0;i<Number;i++){
//                     if ()
//                 }
//             }
//             else
//             System.out.println("False Input");
//         }
//     }
//     public static int Evens() {
//         int[] Odd = {2, 4, 6, 8};
//         Random random = new Random();
//         return Odd[random.nextInt(Odd.length)];
//     }
//     public static int Odds() {
//         int[] Odd = {1, 3, 5, 7, 9};
//         Random random = new Random();
//         return Odd[random.nextInt(Odd.length)];
//     }
// }

import java.util.*;

public class GenerateNDigitNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of digits (N): ");
        int N = scanner.nextInt();

        // Validate that N+1 is even
        if ((N + 1) % 2 != 0) {
            System.out.println("Invalid input! N+1 must be even.");
            return;
        }

        // Validate that the last digit is a single-digit prime
        if (!isSingleDigitPrime(N)) {
            System.out.println("Invalid input! N must be a single-digit prime.");
            return;
        }

        // Generate the N-digit number
        StringBuilder number = new StringBuilder();
        Random random = new Random();

        // Generate the first (N-1) digits as odd
        for (int i = 0; i < N - 1; i++) {
            int oddDigit = randomOddDigit();
            number.append(oddDigit);
        }

        // Append N (a single-digit prime) as the last digit
        number.append(N);

        System.out.println("Generated " + N + "-digit number: " + number.toString());
    }

    // Function to check if a number is a single-digit prime
    public static boolean isSingleDigitPrime(int num) {
        int[] singleDigitPrimes = {2, 3, 5, 7};
        for (int prime : singleDigitPrimes) {
            if (num == prime) {
                return true;
            }
        }
        return false;
    }

    // Function to generate a random odd digit
    public static int randomOddDigit() {
        int[] oddDigits = {1, 3, 5, 7, 9};
        Random random = new Random();
        return oddDigits[random.nextInt(oddDigits.length)];
    }
}
