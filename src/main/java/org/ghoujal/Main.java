package org.ghoujal;


import lombok.*;

import org.ghoujal.dto.Department;
import org.ghoujal.dto.Course;
import org.ghoujal.dto.SchoolManagementSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        SchoolManagementSystem s1 = new SchoolManagementSystem();

        s1.addDepartment("Compsci");
        s1.printDepartments();

        s1.addCourse("Intro to prog", 3, "D001");
        s1.addCourse("Intro to prog 2", 3, "D001");
        s1.addCourse("Advanced Programming", 3, "D001");
        s1.addCourse("Data Structures", 3, "D001");
        s1.addCourse("User Interface Fundamentals", 3, "D001");
        s1.addCourse("Algorithms", 4, "D001");
        s1.addCourse("Advanced Algorigthms", 5, "D001");

        s1.addStudent("Laila", "Ghoujal", "D001");
        s1.addStudent("Joe", "Ghoujal", "D001");
        s1.addStudent("Jane", "Ghoujal", "D001");
        s1.addStudent("Lily", "Ghoujal", "D001");
        s1.addStudent("Mariam", "Ghoujal", "D001");
        s1.addStudent("Ted", "Ghoujal", "D001");
        s1.addStudent("Vishnu", "Ghoujal", "D001");
        s1.addStudent("Bob", "Ghoujal", "D001");


        Course c1 = s1.findCourse("C001");

        s1.findDepartment("D001");
        s1.printStudents();
        s1.addTeacher("Yi", "Wang", "D001");
        s1.addTeacher("Andre", "Cholmsky", "D001");
        s1.printTeachers();
        s1.modifyCourseTeacher("T001", "C001");

//        s1.printCourses();
        s1.printCourses();
        s1.registerCourse("S001", "C001");
        s1.printCourses();
        s1.registerCourse("S003", "C001");
        s1.registerCourse("S002", "C001");
        s1.registerCourse("S004", "C001");
        s1.registerCourse("S005", "C001");
        s1.printCourses();
        s1.registerCourse("S006", "C001");
        System.out.println("Expecting to still have 5 students in course C001");
        s1.printCourses();
        s1.registerCourse("S001", "C002");
        s1.registerCourse("S001", "C003");
        s1.registerCourse("S001", "C004");
        s1.registerCourse("S001", "C005");
        s1.registerCourse("S001", "C006");
        s1.printCourses();




    }
}