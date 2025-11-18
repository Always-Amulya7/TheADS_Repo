import java.util.Scanner;
import java.util.Stack;

class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> Stack = new Stack<>();

        System.out.print("Enter Number Of Elements In The Stack : ");
        int Count = scanner.nextInt();
        System.out.print("Enter The Elements : ");
        for (int i = 0; i < Count; i++) {
            Stack.push(scanner.nextInt());
        }

        System.out.println("Stack : " + Stack);
        int[] NextSmallest = new int[Stack.size()];
        Stack<Integer> TempStack = new Stack<>();
        int Index = Stack.size() - 1;

        while (!Stack.isEmpty()) {
            int Current = Stack.pop();
            while (!TempStack.isEmpty() && TempStack.peek() >= Current) {
                TempStack.pop();
            }
            NextSmallest[Index--] = TempStack.isEmpty() ? -1 : TempStack.peek();
            TempStack.push(Current);
        }

        System.out.print("Next Smallest Elements : ");
        for (int Element : NextSmallest) {
            System.out.print(Element + " ");
        }
        System.out.println();
    }
}
