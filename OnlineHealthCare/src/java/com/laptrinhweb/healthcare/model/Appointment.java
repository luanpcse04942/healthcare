package com.laptrinhweb.healthcare.model;

import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class Appointment {
    private int appointmentId;
    private int userId;
    private int doctorId;
    private String doctorName;
    private int timeId;
    private String timeName;
    private int statusId;
    private String statusValue;
    private String reasonExamination; 
    private Date bookingDate;

    public Appointment(int appointmentId, int userId, int doctorId, String doctorName, int timeId, String timeName, int statusId, String statusValue, String reasonExamination, Date bookingDate) {
        this.appointmentId = appointmentId;
        this.userId = userId;
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.timeId = timeId;
        this.timeName = timeName;
        this.statusId = statusId;
        this.statusValue = statusValue;
        this.reasonExamination = reasonExamination;
        this.bookingDate = bookingDate;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public int getTimeId() {
        return timeId;
    }

    public void setTimeId(int timeId) {
        this.timeId = timeId;
    }

    public String getTimeName() {
        return timeName;
    }

    public void setTimeName(String timeName) {
        this.timeName = timeName;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatusValue() {
        return statusValue;
    }

    public void setStatusValue(String statusValue) {
        this.statusValue = statusValue;
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
    
}
