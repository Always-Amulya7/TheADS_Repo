import java.util.Arrays;

public class Q4 {
    public static void main(String[] args) {
        int Arr[] = {-2, -1, -3, 4, -1, 2, 1, -5, 4};
        int Max = Integer.MIN_VALUE;
        int startIndex = 0, endIndex = 0; // Store the indices for the largest subarray

        for (int i = 0; i < Arr.length; i++) {
            int Sum = Arr[i];
            for (int j = i + 1; j < Arr.length; j++) {
                Sum += Arr[j];
                if (Max < Sum) {
                    Max = Sum;
                    startIndex = i;
                    endIndex = j;
                }
            }
        }

        // Print the largest subarray only once after finding the maximum sum
        if (startIndex != endIndex) { // Ensure it's not a single element subarray
            System.out.println("Largest Subarray: " + Arrays.toString(Arrays.copyOfRange(Arr, startIndex, endIndex + 1)));
        }
        System.out.println("Sum: "+Max);
    }
}