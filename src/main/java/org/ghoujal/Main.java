package org.ghoujal;


import org.ghoujal.dto.Department;
import org.ghoujal.dto.SchoolManagementSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        SchoolManagementSystem s1 = new SchoolManagementSystem();
        Department d1 = new Department("Computer Science");
        System.out.println(d1);
        Department d2 = new Department("Social Science");
        System.out.println(d2);

        s1.addDepartment("Arts");
        System.out.println(s1);



    }
}