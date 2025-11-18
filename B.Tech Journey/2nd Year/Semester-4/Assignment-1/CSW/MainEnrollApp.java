import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;
    private String studentId;
    
    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
    }
    
    public String getName() {
        return name;
    }
    
    public String getStudentId() {
        return studentId;
    }
}
class Course {
    private String courseName;
    private String courseId;

    public Course(String courseName, String courseId) {
        this.courseName = courseName;
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseId() {
        return courseId;
    }
}
interface EnrollmentSystem {
    void enrollStudent(Student student, Course course);

    void dropStudent(Student student, Course course);

    void displayEnrollments();
}

class Enrollment implements EnrollmentSystem {
    private List<String> enrollments = new ArrayList<>();

    @Override
    public void enrollStudent(Student student, Course course) {
        enrollments.add(student.getName() + " enrolled in " + course.getCourseName());
    }

    @Override
    public void dropStudent(Student student, Course course) {
        enrollments.remove(student.getName() + " enrolled in " + course.getCourseName());
    }

    @Override
    public void displayEnrollments() {
        for (String enrollment : enrollments) {
            System.out.println(enrollment);
        }
    }
}

public class MainEnrollApp {
    public static void main(String[] args) {
        Student student1 = new Student("Alice", "S001");
        Student student2 = new Student("Bob", "S002");

        Course course1 = new Course("Mathematics", "C101");
        Course course2 = new Course("Physics", "C102");

        EnrollmentSystem enrollmentSystem = new Enrollment();

        enrollmentSystem.enrollStudent(student1, course1);
        enrollmentSystem.enrollStudent(student2, course2);
        enrollmentSystem.enrollStudent(student1, course2);

        System.out.println("Enrollment Details:");
        enrollmentSystem.displayEnrollments();

        enrollmentSystem.dropStudent(student1, course2);

        System.out.println("\nEnrollment Details after dropping:");
        enrollmentSystem.displayEnrollments();
    }
}