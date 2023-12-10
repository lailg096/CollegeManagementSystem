package org.ghoujal.dto;

import lombok.*;

@ToString
public class Teacher {
    private String lastName;
    private String firstName;
    private Department department;
    private String id;
    private static int nextId = 1;

    public Teacher(String lastName, String firstName, Department department) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.department = department;
        this.id = String.format("T%03d", nextId++);
    }

//    public String toString(){
//
//        return null;
//    }


}
