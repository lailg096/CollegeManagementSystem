package org.ghoujal.dto;

public class Student {

    private static final int MAX_NUM_OF_COURSES_PER_STUDENT = 5;
    private String firstName;
    private String lastName;
    private Course[] courses;
    private String id;
    private int courseNum;
    private static int nextId;
    private Department department;

    @Override
    public String toString(){

        return null;
    }

}
