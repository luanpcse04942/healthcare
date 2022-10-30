package com.laptrinhweb.healthcare.model.dto;

import java.sql.Date;


public class AppointmentDTO {
    private String statusName; 
    private int priceValue;
    private String reasonExamination;
    private Date bookingDate;

    public AppointmentDTO() {
    }
    
    
    public AppointmentDTO(String statusName, int priceValue, String reasonExamination, Date bookingDate) {
        this.statusName = statusName;
        this.priceValue = priceValue;
        this.reasonExamination = reasonExamination;
        this.bookingDate = bookingDate;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public int getPriceValue() {
        return priceValue;
    }

    public void setPriceValue(int priceValue) {
        this.priceValue = priceValue;
    }

    public String getReasonExamination() {
        return reasonExamination;
    }

    public void setReasonExamination(String reasonExamination) {
        this.reasonExamination = reasonExamination;
    }
    
    
}
