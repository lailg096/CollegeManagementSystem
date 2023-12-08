package org.ghoujal.dto;

import lombok.ToString;

@ToString
public class Course {
    private double credit;
    private String id;
    private static int nextId = 1;
    private Student[] students;
    private Department department;
    private int studentNum;
    private Teacher teacher;
    private String courseName;

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
