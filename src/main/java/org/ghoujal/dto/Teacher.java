package org.ghoujal.dto;

public class Teacher {

    private static final int MAX_NUM_OF_STUDENTS_PER_COURSE = 5;
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

    public String toString(){

        return null;
    }


}
