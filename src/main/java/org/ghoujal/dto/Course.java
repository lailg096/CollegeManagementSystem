package org.ghoujal.dto;

import lombok.*;

import java.util.Arrays;

@Getter
@Setter
public class Course {
    private static final int MAX_NUM_OF_STUDENTS_PER_COURSE = 5;
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
        this.students = new Student[MAX_NUM_OF_STUDENTS_PER_COURSE];
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credit=" + credit +
                ", teacher=" + teacher +
                ", department=" + department.getDepartmentName() +
                ", students=" + studentsToString() +
                '}';
    }

    public String studentsToString(){
        String studentStr = "";
        for (Student student : students ){
            if (student != null){
                studentStr += student + "\n";
            }
        }
        return String.format(studentStr);
    }

}
