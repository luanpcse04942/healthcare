package com.laptrinhweb.healthcare.model.dto;

import java.sql.Date;

public class FeedbackSmall {

    private String content;
    private String fname;
    private String lname;
    private String phoneNumber;
    private Date createdAt;
    private String patientName;
    private String doctorName;
    private String specialties;
    private String address;
    private int id;
    

    public FeedbackSmall() {
    }

    public FeedbackSmall(String content, String fname, String lname, String phoneNumber, Date createdAt, String patientName, String doctorName, String specialties, String address, int id) {
        this.content = content;
        this.fname = fname;
        this.lname = lname;
        this.phoneNumber = phoneNumber;
        this.createdAt = createdAt;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.specialties = specialties;
        this.address = address;
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getSpecialties() {
        return specialties;
    }

    public void setSpecialties(String specialties) {
        this.specialties = specialties;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
    
