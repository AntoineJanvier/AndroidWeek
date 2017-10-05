package com.ajanvier.tp_layouts;

/*
 * Created by antoine on 05/10/17.
 */

class Student {
    private String lastName;
    private String firstName;

    Student(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
