import java.util.Scanner;
class Q3
{
    public static void main(String args[])
    {
        try (Scanner sc = new Scanner(System.in)) 
        {
            System.out.print("Enter The Size Of The Array: ");
            int N = sc.nextInt();
            int A[], B[];
            A = new int[N];
            B = new int[N];
            System.out.println("\nEnter The Vector A:");
            for (int i = 0; i < N; i++) 
            {
                System.out.print("Enter For Position " + (i + 1) + " : ");
                A[i] = sc.nextInt();
            }
            System.out.println("\nEnter The Vector B:");
            for (int i = 0; i < N; i++) 
            {
                System.out.print("Enter For Position " + (i + 1) + " : ");
                B[i] = sc.nextInt();
            }
            System.out.print("\nVector A: ");
            int Ch = 105;
            for (int i = 0; i < N; i++) 
            {
                if (A[i] > 0) {
                    if (i < N - 1)
                        System.out.print(A[i] + "" + (char) Ch + "+");
                    if (i == N - 1)
                        System.out.print(A[i] + "" + (char) Ch);
                } else {
                    if (i < N - 1)
                        System.out.print(A[i] + "" + (char) Ch);
                    if (i == N - 1)
                        System.out.print(A[i] + "" + (char) Ch);
                }
                Ch++;
            }
            Ch = 105;
            System.out.print("\nVector B: ");
            for (int j = 0; j < N; j++) 
            {
                if (B[j] > 0) {
                    if (j < N - 1)
                        System.out.print(B[j] + "" + (char) Ch + "+");
                    if (j == N - 1)
                        System.out.print(B[j] + "" + (char) Ch);
                } else {
                    if (j < N - 1)
                        System.out.print(B[j] + "" + (char) Ch);
                    if (j == N - 1)
                        System.out.print(B[j] + "" + (char) Ch);
                }
                Ch++;
            }
            int Result = 0;
            for (int i = 0; i < N; i++) 
            {
                Result += A[i] * B[i];
            }
            System.out.print("\nThe Dot Product Is: " + Result);
        }
    }
}
