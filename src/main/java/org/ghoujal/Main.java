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
        s1.addCourse("Intro to prog", 3, "D009");
        s1.addStudent("Laila", "Ghoujal", "D001");
        s1.findCourse("C001");
        s1.findDepartment("D001");






    }
}