package com.laptrinhweb.healthcare.model.dto;

import java.sql.Date;


public class FeedbackSmall {
    private String content;
    private String fname;
    private String lname;
    private String phoneNumber;
    private Date createdAt;

    public FeedbackSmall() {
    }

    public FeedbackSmall(String content, String fname, String lname, String phoneNumber, Date createdAt) {
        this.content = content;
        this.fname = fname;
        this.lname = lname;
        this.phoneNumber = phoneNumber;
        this.createdAt = createdAt;
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
    
    
}
