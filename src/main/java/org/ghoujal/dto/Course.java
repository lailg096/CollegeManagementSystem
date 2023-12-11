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
        this.studentNum = 0;
        this.credit = credit;
        this.department = department;
        this.id = String.format("C%03d", nextId++);
        this.students = new Student[MAX_NUM_OF_STUDENTS_PER_COURSE];
        this.teacher = null;

    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credit=" + credit +
                //", teacher=" + teacherToString() +
                //", department=" + department.getDepartmentName() +
                ", students=" + studentsToString() +
                '}';
    }

    public void addStudent(Student s){
        for (Student aStudent : students){
            if (aStudent != null && aStudent.getId() == s.getId()){
                return;
            }
        }
        students[studentNum] = s;
        studentNum++;
    }


    public String studentsToString(){
        String studentStr = "";
        for (Student student : students ){
            if (student != null){
                studentStr += student.getId() + "(" + student.getFirstName() + " " + student.getLastName()+ ")\n";
            }
        }
        return studentStr;
    }

    public String teacherToString(){
        String teacherStr = "";
        if (teacher != null){
            teacherStr += teacher.getFirstName() + " " + teacher.getLastName();
        }
       return teacherStr;
    }


}
