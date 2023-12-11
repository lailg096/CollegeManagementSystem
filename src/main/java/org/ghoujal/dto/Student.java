package org.ghoujal.dto;

import lombok.*;

import java.util.Arrays;


@Setter
@Getter
public class Student {
    private static final int MAX_NUM_OF_COURSES_PER_STUDENT = 5;
    private String id;
    private String firstName;
    private String lastName;
    private int courseNum = 0;
    private Course[] courses;
    private static int nextId = 1;
    private Department department;

    public Student(String firstName, String lastName, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.id = String.format("S%03d", nextId++);
        this.courses = new Course[MAX_NUM_OF_COURSES_PER_STUDENT];
    }

    public void addCourse(Course c){
        for (Course studentCourse : courses){
            if (studentCourse != null && c.getId() == studentCourse.getId()){
                return;
            }
        }
        courses[courseNum] = c;
        courseNum++;
    }
    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", First Name= '" + firstName + '\'' +
                ", Last Name= '" + lastName + '\'' +
                ", Courses Registered= " + courseNum +
                ", courses= [" + courseToString() + "]" +
                ", department= " + department.getDepartmentName() +
                '}';
    }

    public String courseToString(){
        String courseStr = "";
        for (Course course : courses ){
            if (course != null){
                courseStr += course.getId() + " - " + course.getCourseName() + "\n";
            }
        }
        return courseStr;
    }

}
