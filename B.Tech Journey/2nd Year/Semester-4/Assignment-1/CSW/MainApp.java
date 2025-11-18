import java.util.Scanner;

class College {
    private String collegeName, collegeLoc;

    void set(String collegeName, String collegeLoc) {
        this.collegeName = collegeName;
        this.collegeLoc = collegeLoc;
    }

    String getCollege() {
        return collegeName + ", " + collegeLoc;
    }
}

class Student {
    private String studentId, studentName;
    private College college;

    void set(String studentId, String studentName, College college) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.college = college;
    }

    String get() {
        return studentId + ", " + studentName + " College: " + college.getCollege();
    }
}

public class MainApp {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            College college = new College();
            Student student = new Student();
            boolean quit = false;
            while (!quit) {
                System.out.print("Wish For Enrollment? ");
                String choice = sc.nextLine();
                if (choice.equalsIgnoreCase("Yes")) {
                    System.out.println("Enter College Name and Location: ");
                    String clgName = sc.nextLine();
                    String clgLoc = sc.nextLine();
                    college.set(clgName, clgLoc);
                    System.out.println("Enter Student ID And Name: ");
                    String studId = sc.nextLine();
                    String studName = sc.nextLine();
                    student.set(studId, studName, college);
                    System.out.println("The Details Are: " + student.get());
                } else {
                    quit = true;
                }
            }
        }
    }
}
