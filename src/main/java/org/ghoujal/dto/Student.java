package org.ghoujal.dto;

import lombok.*;

import java.util.Objects;


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

    /**
     * Student constructor
     * @param firstName first name of student
     * @param lastName last name of student
     * @param department department student is in
     */
    public Student(String firstName, String lastName, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.id = String.format("S%03d", nextId++);
        this.courses = new Course[MAX_NUM_OF_COURSES_PER_STUDENT];
    }

    /**
     * creates courses inside each student
     * @param c course
     */
    public void addCourse(Course c){
        for (Course studentCourse : courses){
            if (studentCourse != null && Objects.equals(c.getId(), studentCourse.getId())){
                return;
            }
        }
        courses[courseNum] = c;
        courseNum++;
    }

    /**
     * give string of only relevant information of student
     * @return string of student
     */
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

    /**
     * only give back relevant information of courses that are inside student
     * @return
     */
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
