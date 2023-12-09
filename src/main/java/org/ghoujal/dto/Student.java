package org.ghoujal.dto;

public class Student {
    private static final int MAX_NUM_OF_COURSES_PER_STUDENT = 5;
    private String firstName;
    private String lastName;
    private Course[] courses;
    private String id;
    private int courseNum;
    private static int nextId = 1;
    private Department department;

    public Student(String firstName, String lastName, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.id = String.format("S%03d", nextId++);
    }

    @Override
    public String toString(){

        return null;
    }

}
