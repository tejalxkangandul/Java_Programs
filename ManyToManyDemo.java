//4.Many-to-Many Mapping
/*
In many-to-many mapping, many objects are associated with many other objects.

Examples:

Many Students ↔ Many Courses

 */

import java.util.*;

class Course {

    int courseId;
    String courseName;
    List<Student> students = new ArrayList<>();

    Course(int courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }
}

class Student {

    int studentId;
    String studentName;
    List<Course> courses = new ArrayList<>();

    Student(int studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }
}

public class ManyToManyDemo {

    public static void main(String[] args) {

        Student s1 = new Student(1, "Ravi");
        Student s2 = new Student(2, "Anita");

        Course c1 = new Course(101, "Java");
        Course c2 = new Course(102, "Python");

        // Mapping
        s1.courses.add(c1);
        s1.courses.add(c2);

        s2.courses.add(c1);

        c1.students.add(s1);
        c1.students.add(s2);

        c2.students.add(s1);

        // Output
        for (Course c : s1.courses) {
            System.out.println(s1.studentName + " enrolled in " + c.courseName);
        }

        for (Course c : s2.courses) {
            System.out.println(s2.studentName + " enrolled in " + c.courseName);
        }

        //course(java) to student 
        System.out.println("\n-------------------\n");
        for (Student s : c1.students) {
            System.out.println(s.studentName + " enrolled in " + c1.courseName);
        }
        //course(pyton) to student 
        System.out.println("\n-------------------\n");
        for (Student s : c2.students) {
            System.out.println(s.studentName + " enrolled in " + c2.courseName);
        }
    }
}
