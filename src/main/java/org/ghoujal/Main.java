package org.ghoujal;


import lombok.*;

import org.ghoujal.dto.Department;
import org.ghoujal.dto.SchoolManagementSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        SchoolManagementSystem s1 = new SchoolManagementSystem();

        s1.addDepartment("Compsci");
        s1.printDepartments();
        s1.addCourse("Intro to prog", 3, "D001");
        s1.addStudent("Laila", "Ghoujal", "D001");
        s1.findCourse("C001");
        s1.findDepartment("D001");
        s1.printStudents();
        s1.addTeacher("Yi", "Wang", "D001");
        s1.addTeacher("Andre", "Cholmsky", "D001");
        s1.printTeachers();
        s1.modifyCourseTeacher("T001", "C001");

//        s1.printCourses();
        s1.addCourse("Data Structures", 4, "D001");
        s1.printCourses();
        s1.registerCourse("S001", "C001");




    }
}