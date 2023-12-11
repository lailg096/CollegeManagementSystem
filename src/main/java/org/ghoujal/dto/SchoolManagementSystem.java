package org.ghoujal.dto;

import lombok.*;

import java.util.Arrays;
import java.util.Scanner;

@Setter
@Getter
@ToString

public class SchoolManagementSystem {

    private static final int MAX_NUM_OF_COURSES = 30;
    private static final int MAX_NUM_OF_DEPARTMENTS = 5;
    private static final int MAX_NUM_OF_STUDENTS = 200;
    private static final int MAX_NUM_OF_TEACHERS = 20;
    private int amountOfTeachers = 0;
    private int amountOfStudents = 0;
    private int amountOfDepartments = 0;
    private int amountOfCourses = 0;
    private Department[] departments;
    private Course[] courses;
    private Student[] students;
    private Teacher[] teachers;


    public SchoolManagementSystem() {
        this.departments = new Department[MAX_NUM_OF_DEPARTMENTS];
        this.courses = new Course[MAX_NUM_OF_COURSES];
        this.students = new Student[MAX_NUM_OF_STUDENTS];
        this.teachers = new Teacher[MAX_NUM_OF_TEACHERS];

    }

    public Department findDepartment(String departmentId){
        for (Department department : departments){
            if (department.getId().equals(departmentId)){
                return department;
            }
            return null;
        }
        return findDepartment(departmentId);
    }

    public void printTeachers(){

    }

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

    public void printStudents(){
        String studentStr = "";
        for (Student student : students){
            if (student != null){
                studentStr += student + "\n";
            }
        }
        System.out.println(studentStr);


    }

    public Student findStudent(String studentId){
        for (Student student: students){
            if (student.getId().equals(studentId)){
                return student;
            }
            return null;
        }
        return findStudent((studentId));
    }

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

    public void registerCourse(String studentId, String courseId) {
        if (findStudent(studentId) != null && findCourse(courseId) != null){
           findStudent(studentId).setCourses(courses);
           findCourse(courseId).setStudents(students);
            System.out.println("Student" + findStudent(studentId) + " is registered in " + findCourse(courseId).getId());
            System.out.println("Course" + findCourse(courseId).getId()
            + " was registered by student " + findStudent(studentId));
        }
        else if (findCourse(courseId) == null){
            System.out.printf("Sorry course %s doesn't seem to exist", courseId);
        }
        else if (findStudent(studentId) == null){
            System.out.printf("Sorry student %s doesn't seem to exist", studentId);
        }


    }

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
    public Course findCourse(String courseId){
        for (Course course : courses){
            if (course.getId().equals(courseId)){
                return course;
            }
            return null;
        }
        return findCourse((courseId));
    }

    public void printDepartments(){
        String departStr = "";
        for (Department department : departments){
            if (department != null){
                departStr += department + "\n";
            }
        }
        System.out.println(departStr);
    }

    public void addStudent(String firstName, String lastName, String departmentId){
            if (amountOfStudents < MAX_NUM_OF_STUDENTS){
                students[amountOfStudents] = new Student(firstName, lastName, findDepartment(departmentId));
                System.out.println(students[amountOfStudents] + " has been added successfully\n");
            }
    }

    public Teacher findTeacher(String teacherId){
        for (Teacher teacher : teachers){
            if (teacher.getId().equals(teacherId)){
                return teacher;
            }
            return null;
        }
        return findTeacher((teacherId));
    }

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
