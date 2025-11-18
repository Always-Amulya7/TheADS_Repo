//A University conducts a 100-mark exam for its student and grades them as follows. Assigns a grade based on the value of the marks. 
//Write a java program to print the grade according to the mark secured by the student. [Use switch-case].
//Mark Range    Letter Grade
//>=90                O
//>=80 AND <90        A
//>=70 AND <80        B
//>=60 AND <70        C
//>=50 AND <60        D
//>=50 AND <40        E 
//<40                 F

import java.util.Scanner;
class QX 
{
    public static void main(String[] args) 
    {
        try (Scanner sc = new Scanner(System.in))
        {
            System.out.print("Enter the student's mark: ");
            int mark = sc.nextInt();
            String grade;
            switch (mark / 10) 
            {
                case 10:case 9:grade = "O";
                               break;
                case 8:grade = "A";
                               break;
                case 7:grade = "B";
                               break;
                case 6:grade = "C";
                               break;
                case 5:grade = "D";
                               break;
                default:grade = "F";
            }

            System.out.println("The student's grade is: " + grade);
        }
    }
}
