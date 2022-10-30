package com.laptrinhweb.healthcare.model.dto;

import java.sql.Date;

public class AppointmentSmall {

    private int appointmentId;
    private int userID;
    private String userFname;
    private String userLname;
    private String status;
    private String reasonExamination;
    private Date bookingDate;

    public AppointmentSmall(int appointmentId, int userID, String userFname, String userLname, String status, String reasonExamination, Date bookingDate) {
        this.appointmentId = appointmentId;
        this.userID = userID;
        this.userFname = userFname;
        this.userLname = userLname;
        this.status = status;
        this.reasonExamination = reasonExamination;
        this.bookingDate = bookingDate;
    }

    public AppointmentSmall() {
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReasonExamination() {
        return reasonExamination;
    }

    public void setReasonExamination(String reasonExamination) {
        this.reasonExamination = reasonExamination;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getUserFname() {
        return userFname;
    }

    public void setUserFname(String userFname) {
        this.userFname = userFname;
    }

    public String getUserLname() {
        return userLname;
    }

    public void setUserLname(String userLname) {
        this.userLname = userLname;
    }
    
    
}
