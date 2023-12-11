package org.ghoujal.dto;

import lombok.*;

/**
 * @author Laila Ghoujal
 */

@Setter
@Getter
@ToString

public class SchoolManagementSystem {

    private static final int MAX_NUM_OF_COURSES = 30;
    private static final int MAX_NUM_OF_DEPARTMENTS = 5;
    private static final int MAX_NUM_OF_STUDENTS = 200;
    private static final int MAX_NUM_OF_TEACHERS = 20;
    private static final int MAX_NUM_OF_STUDENTS_PER_COURSE = 5;
    private static final int MAX_NUM_OF_COURSES_PER_STUDENT = 5;
    private int amountOfTeachers = 0;
    private int amountOfStudents = 0;
    private int amountOfDepartments = 0;
    private int amountOfCourses = 0;
    private Department[] departments;
    private Course[] courses;
    private Student[] students;
    private Teacher[] teachers;

    /**
     * constructor for school management
     * @param schoolName String of school's name
     */
    public SchoolManagementSystem(String schoolName) {
        this.departments = new Department[MAX_NUM_OF_DEPARTMENTS];
        this.courses = new Course[MAX_NUM_OF_COURSES];
        this.students = new Student[MAX_NUM_OF_STUDENTS];
        this.teachers = new Teacher[MAX_NUM_OF_TEACHERS];
    }
    /**
     * finds a department based on given id
     * @param departmentId the of department's id number
     * @return corresponding department
     */
    public Department findDepartment(String departmentId){
        for (Department department : departments){
            if (department.getId().equals(departmentId)){
                return department;
            }
        }
        return null;
    }
    /**
     * prints teachers that aren't null
     */
    public void printTeachers(){
        String teacherStr = "";
        for (Teacher teacher : teachers){
            if (teacher != null){
                teacherStr += teacher + "\n";
            }
        }
        System.out.println(teacherStr);
    }
    /**
     * takes id of given teacher and assigns it to given course
     * @param teacherId String of teachers id
     * @param courseId String of course id
     */
    public void modifyCourseTeacher(String teacherId, String courseId){
        if (findTeacher(teacherId) != null && findCourse(courseId) != null){
            findCourse(courseId).setTeacher(findTeacher(teacherId));
            System.out.println((findTeacher(teacherId)) + " has been assigned to " + findCourse(courseId).getId());
        }
        else if (findTeacher(teacherId) == null){
            System.out.println(" Sorry, your teacher doesn't seem to exist\n");
        }
        else if (findCourse(courseId) == null){
            System.out.println(" Sorry, your course doesn't seem to exist\n");
        }

    }
    /**
     * adds a department
     * @param departmentName String of department name
     */
    public void addDepartment(String departmentName){
        if (amountOfDepartments < MAX_NUM_OF_DEPARTMENTS){
            departments[amountOfDepartments] = new Department(departmentName);
            System.out.println(departments[amountOfDepartments] + " added successfully\n");
            amountOfDepartments++;
        }
        else {
            System.out.println("Maximum number of departments reached");
        }
    }
    /**
     * print out students that aren't null
     */
    public void printStudents(){
        String studentStr = "";
        for (Student student : students){
            if (student != null){
                studentStr += student + "\n";
            }
        }
        System.out.println(studentStr);
    }
    /**
     * find a student based on given id
     * @param studentId String of student's id
     * @return student or null
     */
    public Student findStudent(String studentId){
        for (Student student: students){
            if (student.getId().equals(studentId)){
                return student;
            }
        }
        return null;
    }
    /**
     * creates a new course based on given parameters
     * @param courseName String of the course's name
     * @param credit how many credits the course counts for
     * @param departmentId String of the course's id number
     */
    public void addCourse(String courseName, double credit, String departmentId) {
        if (amountOfCourses < MAX_NUM_OF_COURSES){
            try{
                courses[amountOfCourses] = new Course(courseName, credit, findDepartment(departmentId));
                System.out.println(courses[amountOfCourses] + "added successfully\n");
                amountOfCourses++;
            }
            catch (NullPointerException departmentIdDoesNotExist){
                System.out.printf("Sorry, it doesn't seem like department %s exists\n", departmentId);
            }
        }
        else {
            System.out.println("Sorry, maximum number of courses has been reached");
        }
    }
    /**
     * registers student into a course
     * makes sure that course doesn't exceed 5 students
     * makes sure that students don't exceed 5 courses
     * @param studentId String of students id
     * @param courseId String of course id
     */
    public void registerCourse(String studentId, String courseId) {
        Course c =  findCourse(courseId);
        if(c == null)
        {
            System.out.println("Can't find course " + courseId + ", ignoring registration");
        }
        Student s =  findStudent(studentId);
        if(s == null)
        {
            System.out.println("Can't find student " + studentId + ", ignoring registration");
            return;
        }
        // is the course full?
        int temporaryCountOfStudents = 0;
        for (Student tmpS: c.getStudents()){
            if (tmpS != null){
                temporaryCountOfStudents++;
            }
        }
        if(temporaryCountOfStudents >= MAX_NUM_OF_STUDENTS_PER_COURSE){
            System.out.println("Course " + courseId + " already full, ignoring registration");
            return;
        }
        // is student maxed out number of registrations
        int tmpCountOfRegisteredCourses = 0;
        for (Course tmpC: s.getCourses()){
            if (tmpC != null){
                tmpCountOfRegisteredCourses++;
            }
        }
        if(tmpCountOfRegisteredCourses >= MAX_NUM_OF_COURSES_PER_STUDENT){
            System.out.println("Student " + studentId + " already registered max number of courses, ignoring registration");
            return;
        }
        // finally register a student for the course
        s.addCourse(c);
        c.addStudent(s);
        System.out.println("Successfully registered " + studentId + " for course " + courseId);
    }
    /**
     * adds teacher to specific department
     * @param firstName first name of teacher
     * @param lastName last name of teacher
     * @param departmentId department id that teacher belongs to
     */
    public void addTeacher(String firstName, String lastName, String departmentId){
        if (amountOfTeachers < MAX_NUM_OF_TEACHERS){
            try {
                teachers[amountOfTeachers] = new Teacher(firstName, lastName, findDepartment(departmentId));
                System.out.println(teachers[amountOfTeachers] + "added successfully\n");
                amountOfTeachers++;
            }
            catch (NullPointerException departmentIdDoesNotExist){
                System.out.printf("Sorry, it doesn't seem like department %s exists", departmentId);
            }
        }
        else {
            System.out.println("Sorry, maximum number of teachers has been reached");
        }
    }

    /**
     * finds a course based on given id number
     * @param courseId given id number of course
     * @return the course found
     */
    public Course findCourse(String courseId){
        for (Course course : courses){
            if (course.getId().equals(courseId)){
                return course;
            }

        }
        return null;
    }

    /**
     * prints out departments that aren't null
     */
    public void printDepartments(){
        String departStr = "";
        for (Department department : departments){
            if (department != null){
                departStr += department + "\n";
            }
        }
        System.out.println(departStr);
    }

    /**
     * adds student to a specific program/department
     * @param firstName String first name of student
     * @param lastName String last name of student
     * @param departmentId String department id student is in
     */
    public void addStudent(String firstName, String lastName, String departmentId){
        if (amountOfStudents < MAX_NUM_OF_STUDENTS){
            students[amountOfStudents] = new Student(firstName, lastName, findDepartment(departmentId));
            System.out.println(students[amountOfStudents] + " has been added successfully\n");
            amountOfStudents++;
        }
    }
    /**
     * uses given teacherId to find teacher
     * @param teacherId String of teacher's Id number
     * @return the teacher or null
     */
    public Teacher findTeacher(String teacherId){
        for (Teacher teacher : teachers){
            if (teacher.getId().equals(teacherId)){
                return teacher;
            }
        }
        return null;
    }
    /**
     * print out courses that aren't null
     */
    public void printCourses(){
        String courseStr = "";
        for (Course course : courses){
            if (course != null){
                courseStr += course + "\n";
            }
        }
        System.out.println(courseStr);
    }
}
