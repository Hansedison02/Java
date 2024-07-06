public class Teacher extends Person {
    private int numCourses = 0;
    private String[] courses = new String[100]; // Assuming a maximum of 100 courses

    public Teacher(String name, String address) {
        super(name, address);
    }

    @Override
    public String toString() {
        return "Teacher: " + super.toString();
    }

    public boolean addCourse(String course) {
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equals(course)) {
                System.out.println("Course already exists!");
                return false;
            }
        }
        courses[numCourses] = course;
        numCourses++;
        return true;
    }

    public boolean removeCourse(String course) {
        boolean found = false;
        int index = -1;
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equals(course)) {
                found = true;
                index = i;
                break;
            }
        }
        if (!found) {
            System.out.println("Course does not exist!");
            return false;
        }
        for (int i = index; i < numCourses - 1; i++) {
            courses[i] = courses[i + 1];
        }
        numCourses--;
        return true;
    }
}