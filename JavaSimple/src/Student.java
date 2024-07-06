package JavaSimple;

import JavaSimple.Person;

import java.util.Random;

class Student extends Person
{
    public String name;
    public Student(String name, String address)
    {
        super("Student: ");
        this.name=name;
        this.address = address;
    }
    public int numCourses;
    public String[] courses;
    public int[] grades;

    public void addCourseGrade(String course, int grade)
    {

    }

    public void printGrades()
    {
        
    }

    public double getAvgGrade()
    {
        return 0;
    }

    public String toString()
    {
        return super.toString() + name + "(" + address + ")";
    }
}

class Teacher extends Person
{
    public String name;
    public Teacher(String name, String address)
    {
        super("Teacher: ");
        this.name=name;
        this.address = address;
    }
    public int numCourses;
    public String[] courses;
    public int[] grades;

    public boolean addCourse()
    {

    }  

    public boolean removeCourse()
    {

    }  

    public String toString()
    {
        return super.toString() + name + "(" + address + ")";
    }
}

public class Main
{
    public static void main(String[] args) 
    {
        Person[]
    }
}
