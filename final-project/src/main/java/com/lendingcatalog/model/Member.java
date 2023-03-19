package com.lendingcatalog.model;

public class Member {
    //Variables
    private String firstName;
    private String lastName;


    //constructors
    public Member(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    //methods

    @Override
    public  String toString() {
        return firstName + " " + lastName;
    }
}
