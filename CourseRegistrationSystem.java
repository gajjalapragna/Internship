package internship;

import java.util.ArrayList;
import java.util.Scanner;

class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private String schedule;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }
}

class Student {
    private int studentID;
    private String name;
    private ArrayList<String> registeredCourses;

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(String courseCode) {
        registeredCourses.add(courseCode);
    }

    public void dropCourse(String courseCode) {
        registeredCourses.remove(courseCode);
    }
}

class CourseDatabase {
    private ArrayList<Course> courses;

    public CourseDatabase() {
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void displayCourses() {
        System.out.println("Available Courses:");
        for (Course course : courses) {
            int availableSlots = course.getCapacity() - getRegisteredStudents(course.getCourseCode()).size();
            System.out.println("Course Code: " + course.getCourseCode() +
                    ", Title: " + course.getTitle() +
                    ", Description: " + course.getDescription() +
                    ", Capacity: " + course.getCapacity() +
                    ", Available Slots: " + availableSlots +
                    ", Schedule: " + course.getSchedule());
        }
    }

    public ArrayList<Student> getRegisteredStudents(String courseCode) {
        ArrayList<Student> registeredStudents = new ArrayList<>();
        for (Student student : StudentDatabase.students) {
            if (student.getRegisteredCourses().contains(courseCode)) {
                registeredStudents.add(student);
            }
        }
        return registeredStudents;
    }
}

class StudentDatabase {
    static ArrayList<Student> students = new ArrayList<>();

    public static void addStudent(Student student) {
        students.add(student);
    }

    public static void displayStudentCourses(int studentID) {
        for (Student student : students) {
            if (student.getStudentID() == studentID) {
                System.out.println("Registered Courses for " + student.getName() + ": " + student.getRegisteredCourses());
                return;
            }
        }
        System.out.println("Student with ID " + studentID + " not found.");
    }
}

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        CourseDatabase courseDB = new CourseDatabase();

        Course c1 = new Course("CS101", "Introduction to Programming", "Fundamentals of programming in Java", 50, "Mon/Wed 10:00 AM - 11:30 AM");
        Course c2 = new Course("MATH201", "Calculus I", "Introduction to differential and integral calculus", 40, "Tue/Thu 1:00 PM - 2:30 PM");

        courseDB.addCourse(c1);
        courseDB.addCourse(c2);

        Student s1 = new Student(1, "John Doe");
        Student s2 = new Student(2, "Jane Smith");

        StudentDatabase.addStudent(s1);
        StudentDatabase.addStudent(s2);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Display Available Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    courseDB.displayCourses();
                    break;
                case 2:
                    System.out.print("Enter Student ID: ");
                    int studentID = scanner.nextInt();
                    StudentDatabase.displayStudentCourses(studentID);

                    System.out.print("Enter Course Code to Register: ");
                    String registerCourseCode = scanner.next();
                    courseDB.getRegisteredStudents(registerCourseCode).size();
                    s1.registerCourse(registerCourseCode);
                    System.out.println("Registration Successful!");
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    int studentIDToDrop = scanner.nextInt();
                    StudentDatabase.displayStudentCourses(studentIDToDrop);

                    System.out.print("Enter Course Code to Drop: ");
                    String dropCourseCode = scanner.next();
                    s1.dropCourse(dropCourseCode);
                    System.out.println("Course Dropped Successfully!");
                    break;
                case 4:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}