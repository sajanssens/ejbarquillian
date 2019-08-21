package com.example;

import javax.validation.constraints.Size;

public class User {

    @Size(min = 2, message = "First name too short")
    private String firstName;

    @Size(min = 2, message = "Last name too short")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}