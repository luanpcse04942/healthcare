package com.laptrinhweb.healthcare.model;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Appointment {
    private int appointmentId;
    private int userId;
    private int doctorWorkingInfoId;
    private int timeId;
    private int statusId;
    private String reasonExamination; 
    private Date bookingDate;

    public Appointment() {
    }

    public Appointment(int appointmentId, int userId, int doctorWorkingInfoId, int timeId, int statusId, String reasonExamination, Date bookingDate) {
        this.appointmentId = appointmentId;
        this.userId = userId;
        this.doctorWorkingInfoId = doctorWorkingInfoId;
        this.timeId = timeId;
        this.statusId = statusId;
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

    public int getDoctorWorkingInfoId() {
        return doctorWorkingInfoId;
    }

    public void setDoctorWorkingInfoId(int doctorWorkingInfoId) {
        this.doctorWorkingInfoId = doctorWorkingInfoId;
    }

    public int getTimeId() {
        return timeId;
    }

    public void setTimeId(int timeId) {
        this.timeId = timeId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
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
