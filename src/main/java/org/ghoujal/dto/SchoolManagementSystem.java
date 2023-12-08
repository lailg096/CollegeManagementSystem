package org.ghoujal.dto;

import lombok.*;

import java.util.Scanner;

@Setter
@Getter
public class SchoolManagementSystem {

    private static final int MAX_NUM_OF_COURSES = 30;
    private static final int MAX_NUM_OF_DEPARTMENTS = 5;
    private static final int MAX_NUM_OF_STUDENTS = 200;
    private static final int MAX_NUM_OF_TEACHERS = 20;
    private int amountOfDepartments = 0;

    public SchoolManagementSystem(String str) {

    }

    public Department findDepartment(String str){

        return null;
    }

    public void printTeachers(){

    }

    public void modifyCourseTeacher(String str, String str2){

    }
    public void addDepartment(String str){
        if (amountOfDepartments <= MAX_NUM_OF_DEPARTMENTS){


        }


    }

    public void printStudents(){

    }

    public Student findStudent(String str){

        return null;
    }

    public void addCourse(String str, double num, String str2) {

    }

    public void registerCourse(String str, String str1) {

    }

    public void addTeacher(String str, String str2, String str3){

    }
    public Course findCourse(String str){

        return null;
    }

    public void printDepartments(){

    }

    public void addStudent(String str, String str2, String str3){

    }

    public Teacher findTeacher(String str){

        return null;
    }
}
