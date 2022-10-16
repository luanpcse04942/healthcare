/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.Date;

/**
 *
 * @author mikuo
 */
public class AppointmentPatient {
    private int appoitmentId;
    private String fullName;
    private String reason;
    private String address;
    private Date bookingDate;
    private String status;

    public AppointmentPatient() {
    }

    public AppointmentPatient(int appoitmentId, String fullName, String reason, String address, Date bookingDate, String status) {
        this.appoitmentId = appoitmentId;
        this.fullName = fullName;
        this.reason = reason;
        this.address = address;
        this.bookingDate = bookingDate;
        this.status = status;
    }

    public int getAppoitmentId() {
        return appoitmentId;
    }

    public void setAppoitmentId(int appoitmentId) {
        this.appoitmentId = appoitmentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    
}
