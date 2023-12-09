package org.ghoujal.dto;

import lombok.ToString;

@ToString
public class Course {
    private String id;
    private String courseName;
    private double credit;
    private Teacher teacher;
    private Department department;
    private Student[] students;
    private static int nextId = 1;
    private int studentNum;



    public Course(String courseName, double credit, Department department) {
        this.courseName = courseName;
        this.credit = credit;
        this.department = department;
        this.id = String.format("C%03d", nextId++);
    }

//    public String toString(){
//
//        return null;
//    }
}
