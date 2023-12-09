package org.ghoujal;


import lombok.*;

import org.ghoujal.dto.Department;
import org.ghoujal.dto.SchoolManagementSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        SchoolManagementSystem s1 = new SchoolManagementSystem();
        System.out.println(s1);
        s1.addDepartment("Compsci");
        System.out.println(s1);
        s1.addCourse("Intro to prog", 3, "Compsci");
        System.out.println(s1);




    }
}