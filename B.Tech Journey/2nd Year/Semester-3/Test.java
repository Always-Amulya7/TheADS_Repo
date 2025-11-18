// import java.util.*;
// class Test{
//     public static void main(String args[]){
//         try(Scanner Sc=new Scanner(System.in)){
//             System.out.print("Enter The ith Bit: ");
//             int i=Sc.nextInt();
//             System.out.print("Enter The jth Bit: ");
//             int j=Sc.nextInt();
//             System.out.print("Enter The Size Of The Array: ");
//             int n=Sc.nextInt();
//             int Arr[]=new int[n];
//             System.out.print("Enter The Array Elements: ");
//             for (int k=0;k<n;k++){
//                 Arr[k]=Sc.nextInt();
//             }
//             System.out.println("The Array Is: "+Arrays.toString(Arr));
//             int Temp=Arr[i];
//             Arr[i]=Arr[j];
//             Arr[j]=Temp;
//             System.out.print("The Changed Array: "+Arrays.toString(Arr));
//         }
//     }
// }

// import java.util.*;

// class Test {
//     public static void main(String args[]) {
//         try (Scanner Sc = new Scanner(System.in)) {
//             System.out.print("Enter The Size Of The Array: ");
//             int n = Sc.nextInt();
//             int Arr[] = new int[n];
//             String Store[] = new String[n];
//             System.out.print("Enter The Array Elements: ");
//             for (int k = 0; k < n; k++) {
//                 Arr[k] = Sc.nextInt();
//                 Store[k] = Integer.toBinaryString(Arr[k]);
//             }
//             System.out.println("The Array Is: " + Arrays.toString(Arr));
//             System.out.print("The Count Array: ");
//             for (int i = 0; i < n; i++) {
//                 int Count = 0;
//                 for (int j = 0; j < Store[i].length(); j++) {
//                     if (Store[i].charAt(j) == '1') {
//                         Count++;
//                     }
//                 }
//                 System.out.print(Count + " "); // Added space between counts for better readability
//             }
//         }
//     }
// }

// import java.util.*;
// class Test{
//     public static void main(String args[]){
//         try(Scanner Sc=new Scanner(System.in)){
//             System.out.print("Enter Total Number: ");
//             int Number=Sc.nextInt();
//             double Arr[]=new double[Number];
//             System.out.println("Enter The Number Order: ");
//             for (int i=0;i<Number;i++){
//                 Arr[i]=Sc.nextDouble();
//             }
//             double Max=Arr[0];
//             for (int i=0;i<Number;i++){
//                 if (Arr[i]>Max){
//                     Max=Arr[i];
//                 }
//             }
//         }
//     }
// }

// import java.util.*;
// class Test{
//     public static void main(String args[]){
//         try(Scanner Sc=new Scanner(System.in)){
//             System.out.print("Enter The Array Size: ");
//             int Number=Sc.nextInt();
//             String Arr[]=new String[Number];
//             System.err.print("The Array To Be Entered: ");
//             for (int i=0;i<Number;i++){
//                 Arr[i]=Sc.next();
//             }
//             System.out.println("The Number Array: "+Arrays.toString(Arr));
//             String Store="";
//             for(int i=0;i<Number;i++){
//                 Store=Store.concat(Arr[i]);
//             }
//             double New = Double.parseDouble(Store);
//             System.out.print("The Double Value Is: "+New);
//         }
//     }
// }

// import java.util.*;
// class Test{
//     public static void main(String args[]){
//         try(Scanner Sc=new Scanner(System.in)){
//             System.out.print("Enter The Number: ");
//             int Number=Sc.nextInt();
//             int Count=0;
//             int Temp=Number;
//             while(Number>0){
//                 Number=Number/10;
//                 Count++;
//             }
//             System.out.println("The Count Value Is: "+Count);
//             int Arr[]=new int[Count];
//             for (int i=Count-1;i>=0;i--){
//                 Arr[i]=Temp%10;
//                 Temp=Temp/10;
//             }
//             System.out.println("The Number Array Is: "+Arrays.toString(Arr));
//             int Sum=0;
//             for (int i=Count-1;i>=0;i=i-2){
//                 Sum=Sum+Arr[i];
//             }
//             System.out.print("The Sum Is: "+Sum);
//         }
//     }
// }

// import java.util.*;

// class Test {
//     public static void main(String args[]) {
//         try (Scanner Sc = new Scanner(System.in)) {
//             System.out.print("Enter The Size Of The Array: ");
//             int Num = Sc.nextInt();
//             int Arr[] = new int[Num];

//             System.out.print("Enter The Array Elements: ");
//             for (int i = 0; i < Num; i++) {
//                 Arr[i] = Sc.nextInt();
//             }

//             System.out.println("The Array Is: " + Arrays.toString(Arr));

//             // Finding the maximum element in the array
//             int Max = Arr[0];
//             for (int i = 0; i < Num; i++) {
//                 if (Arr[i] > Max) {
//                     Max = Arr[i];
//                 }
//             }
//             System.out.println("The Max Element Is: " + Max);

//             // Finding the missing terms
//             StringBuilder Store = new StringBuilder();
//             for (int i = 1; i <= Max; i++) { // Loop through 1 to Max
//                 boolean isPresent = false;
//                 for (int j = 0; j < Num; j++) { // Check if 'i' exists in the array
//                     if (Arr[j] == i) {
//                         isPresent = true;
//                         break;
//                     }
//                 }
//                 if (!isPresent) { // If 'i' is missing, add it to Store
//                     Store.append(i).append(" ");
//                 }
//             }

//             if (Store.length() > 0) {
//                 System.out.println("The Missing Terms Are: " + Store.toString().trim());
//             } else {
//                 System.out.println("No Missing Terms.");
//             }
//         }
//     }
// }

// import java.util.*;

// class Test {
//     public static void main(String args[]) {
//         try (Scanner Sc = new Scanner(System.in)) {
//             System.out.print("Enter The Size Of The Array: ");
//             int Num = Sc.nextInt();

//             int Arr[] = new int[Num];
//             System.out.print("Enter The Array Elements: ");
//             for (int i = 0; i < Num; i++) {
//                 Arr[i] = Sc.nextInt();
//             }

//             int Max = Integer.MIN_VALUE;
//             int Second_Max = Integer.MIN_VALUE;

//             // Find the maximum and second maximum
//             for (int i = 0; i < Num; i++) {
//                 if (Arr[i] > Max) {
//                     Second_Max = Max; // Update second maximum
//                     Max = Arr[i];     // Update maximum
//                 } else if (Arr[i] > Second_Max && Arr[i] != Max) {
//                     Second_Max = Arr[i]; // Update second maximum
//                 }
//             }
//             System.out.println("The Max Is: " + Max);
//         }
//     }
// }

// import java.util.Scanner;

// class TypeConversion {
//     public static void main(String[] args) {
//         try (Scanner sc = new Scanner(System.in)) {
//             // Read inputs for different types
//             System.out.print("Enter an integer: ");
//             int intValue = sc.nextInt();

//             System.out.print("Enter a float value: ");
//             float floatValue = sc.nextFloat();

//             System.out.print("Enter a double value: ");
//             double doubleValue = sc.nextDouble();

//             System.out.print("Enter a boolean value (true/false): ");
//             boolean booleanValue = sc.nextBoolean();

//             // Convert to strings using String.valueOf
//             String intString = String.valueOf(intValue);
//             String floatString = String.valueOf(floatValue);
//             String doubleString = String.valueOf(doubleValue);
//             String booleanString = String.valueOf(booleanValue);

//             System.out.println("\nConverted to String:");
//             System.out.println("Integer as String: " + intString);
//             System.out.println("Float as String: " + floatString);
//             System.out.println("Double as String: " + doubleString);
//             System.out.println("Boolean as String: " + booleanString);

//             // Convert back to their respective object types using valueOf
//             Integer intObject = Integer.valueOf(intString);
//             Float floatObject = Float.valueOf(floatString);
//             Double doubleObject = Double.valueOf(doubleString);
//             Boolean booleanObject = Boolean.valueOf(booleanString);

//             System.out.println("\nConverted back to Objects:");
//             System.out.println("Integer Object: " + intObject);
//             System.out.println("Float Object: " + floatObject);
//             System.out.println("Double Object: " + doubleObject);
//             System.out.println("Boolean Object: " + booleanObject);
//         }
//     }
// }

// import java.util.*;
// class Test{
//     public static void main(String args[]){
//         try(Scanner Sc=new Scanner(System.in)){
//             System.out.print("Enter The Order: ");
//             int x=Sc.nextInt();
//             int y=Sc.nextInt();
//             int z=Sc.nextInt();
//             int Arr[]={x,y,z};
//             int Max=Math.max(Math.max(x,y), z);
//             int Min=Math.min(Math.min(x,y), z);
//             if (Arr[0]==Min && Arr[2]==Max){
//                 System.out.print("The Order Is Ascending");
//             }
//             else if(Arr[0]==Max && Arr[2]==Min){
//                 System.out.print("The Order Is Descending");
//             }
//             else
//             System.out.print("The Order Does Not Follow Things");
//         }
//     }
// }

// import java.util.Scanner;

// class Test {
//     public static void main(String args[]) {
//         try (Scanner sc = new Scanner(System.in)) {
//             System.out.print("Enter a Number: ");
//             int num = sc.nextInt();

//             // Check if the number is greater than 0 and is a power of 2
//             if (num > 0 && (num & (num - 1)) == 0) {
//                 System.out.println(num + " is a power of 2.");
//             } else {
//                 System.out.println(num + " is NOT a power of 2.");
//             }
//         }
//     }
// }

import java.util.*;
class Test{
    public static void main(String args[]){
        try(Scanner Sc=new Scanner(System.in)){
            System.out.print("Enter The Numbers: ");
            int x=Sc.nextInt();
            int y=Sc.nextInt();
            int Product=0;
            for (int i=1;i<=y;i++){
                Product+=x;
            }
            System.out.print("The Product Is: "+Product);
        }
    }
}