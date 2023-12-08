package org.ghoujal.dto;

import lombok.*;

@Setter
@Getter
@ToString

public class Department {
    private String id;
    private static int nextId = 1;
    private String departmentName;



    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.id = String.format("D%03d", nextId++);


    }

//    public String toString(){
//
//
//    }
}

