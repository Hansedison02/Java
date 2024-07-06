public class Student extends Person {
    private int numCourses = 0;
    private String[] courses = new String[100]; // Assuming a maximum of 100 courses
    private int[] grades = new int[100]; // Assuming a maximum of 100 grades

    public Student(String name, String address) {
        super(name, address);
    }

    @Override
    public String toString() {
        return "Student: " + super.toString();
    }

    public void addCourseGrade(String course, int grade) {
        courses[numCourses] = course;
        grades[numCourses] = grade;
        numCourses++;
    }

    public void printGrades() {
        System.out.println("Grades:");
        for (int i = 0; i < numCourses; i++) {
            System.out.println(courses[i] + ": " + grades[i]);
        }
    }

    public double getAvgGrade() {
        int sum = 0;
        for (int i = 0; i < numCourses; i++) {
            sum += grades[i];
        }
        return (double) sum / numCourses;
    }
}