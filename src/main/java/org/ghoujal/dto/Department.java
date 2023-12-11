package org.ghoujal.dto;

import lombok.*;

@Setter
@Getter
public class Department {
    private String id;
    private static int nextId = 1;
    private String departmentName;
//    private Course[] courses;

    private final static int MAX_NUM_OF_COURSES_PER_DEPARTMENT = 30;


    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.id = String.format("D%03d", nextId++);
//        this.courses = new Course[MAX_NUM_OF_COURSES_PER_DEPARTMENT];
    }

    @Override
    public String toString() {
        return "Department {" +
                "id= " + id +
                ", Department Name= " + "\"" + departmentName + "\"" +
                '}';
    }
}

