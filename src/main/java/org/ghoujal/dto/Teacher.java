package org.ghoujal.dto;

import lombok.*;


@Setter
@Getter
public class Teacher {
    private String id;
    private String firstName;
    private String lastName;
    private Department department;
    private static int nextId = 1;

    /**
     *
     * @param firstName first name of teacher
     * @param lastName last name of teacher
     * @param department department teacher is in
     */
    public Teacher(String firstName, String lastName, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.id = String.format("T%03d", nextId++);
    }

    /**
     * manual toString method to only print out desired information
     * @return teacher in string
     */
    @Override
    public String toString() {
        return "Teacher{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department=" + department.getDepartmentName() +
                '}';
    }
}
