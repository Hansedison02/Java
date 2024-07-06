import java.util.*;

public class App {
    public static void main(String[] args) {
        Person person = new Person("John Doe", "123 Main St.");
        System.out.println(person);

        Student student = new Student("Jane Smith", "456 Elm St.");
        System.out.println(student);
        student.addCourseGrade("Math", 90);
        student.addCourseGrade("Science", 85);
        student.addCourseGrade("English", 92);
        student.printGrades();
        System.out.println("Average Grade: " + student.getAvgGrade());

        Teacher teacher = new Teacher("Bob Johnson", "789 Oak St.");
        System.out.println(teacher);
        teacher.addCourse("Math");
        teacher.addCourse("Science");
        teacher.addCourse("English");
        teacher.addCourse("Math"); // This will print "Course already exists!"
        teacher.removeCourse("History"); // This will print "Course does not exist!"
    }
}
