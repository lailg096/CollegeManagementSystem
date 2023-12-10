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

    public SchoolManagementSystem() {
        this.departments = new Department[MAX_NUM_OF_DEPARTMENTS];
        this.courses = new Course[MAX_NUM_OF_COURSES];
        this.students = new Student[MAX_NUM_OF_STUDENTS];

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

    public void modifyCourseTeacher(String str, String str2){

    }
    public void addDepartment(String departmentName){
        if (amountOfDepartments <= MAX_NUM_OF_DEPARTMENTS){
            departments[amountOfDepartments] = new Department(departmentName);
            System.out.println(departments[amountOfDepartments] + " added successfully\n");
            amountOfDepartments++;
        }
        else {
            System.out.println("Maximum number of departments reached");
        }


    }

    public void printStudents(){

    }

    public Student findStudent(String str){

        return null;
    }

    public void addCourse(String courseName, double credit, String departmentId) {
        if (amountOfCourses <= MAX_NUM_OF_COURSES){
            try{
                courses[amountOfCourses] = new Course(courseName, credit, findDepartment(departmentId));
                System.out.println(courses[amountOfCourses] + "added successfully\n");
            }
            catch (NullPointerException idDoesNotExist){
                System.out.printf("Sorry, it doesn't seem like department %s exists\n", departmentId);
            }
            amountOfCourses++;
        }
        else {
            System.out.println("Sorry, maximum number of courses has been reached");
        }

    }

    public void registerCourse(String str, String str1) {

    }

    public void addTeacher(String firstName, String lastName, String departmentName){
        if (amountOfTeachers <= MAX_NUM_OF_TEACHERS){

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
                System.out.println(students[amountOfStudents] + "has been added successfully");
            }
    }

    public Teacher findTeacher(String str){

        return null;
    }
}
