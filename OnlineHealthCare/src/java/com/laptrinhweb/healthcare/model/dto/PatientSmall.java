package com.laptrinhweb.healthcare.model.dto;

import java.sql.Date;

public class PatientSmall {

    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Date bookingDate;

    public PatientSmall() {
    }
   
    public PatientSmall(int id, String firstName, String lastName, String phoneNumber, Date bookingDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.bookingDate = bookingDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    
    
}
