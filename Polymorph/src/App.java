public class App {
    public static void main(String[] args) {
        Person person = new Person("Darryl Efraim", "323 Vivaldi St.");
        System.out.println(person);

        Teacher t_01 = new Teacher("Henry Stickmin", "712 Oak St.");
        System.out.println(t_01);
        t_01.addCourse("Digital Illustration");
        t_01.addCourse("Photography");
        t_01.addCourse("English");
        t_01.addCourse("Photography"); // This will print "Course already exists!"
        t_01.removeCourse("History"); // This will print "Course does not exist!"

        Student s_01 = new Student("Jenny Sydney", "2 Grasslsnd St.");
        System.out.println(s_01);
        s_01.addCourseGrade("Digital Illustration", 99);
        s_01.addCourseGrade("Photography", 85);
        s_01.addCourseGrade("English", 92);
        s_01.printGrades();
        System.out.println("Average Grade: " + s_01.getAvgGrade());
    }
}