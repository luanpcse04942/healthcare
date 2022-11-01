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
public class ApointmentFacility {
    private int appoitmentId;
    private String fullNamePatient;
    private String reason;
    private String phoneNumber;
    private String fullNameDoctor;
    private Date bookingDate;
    private String status;

    public ApointmentFacility() {
    }

    public ApointmentFacility(int appoitmentId, String fullNamePatient, String reason, String phoneNumber, String fullNameDoctor, Date bookingDate, String status) {
        this.appoitmentId = appoitmentId;
        this.fullNamePatient = fullNamePatient;
        this.reason = reason;
        this.phoneNumber = phoneNumber;
        this.fullNameDoctor = fullNameDoctor;
        this.bookingDate = bookingDate;
        this.status = status;
    }

    public int getAppoitmentId() {
        return appoitmentId;
    }

    public void setAppoitmentId(int appoitmentId) {
        this.appoitmentId = appoitmentId;
    }

    public String getFullNamePatient() {
        return fullNamePatient;
    }

    public void setFullNamePatient(String fullNamePatient) {
        this.fullNamePatient = fullNamePatient;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFullNameDoctor() {
        return fullNameDoctor;
    }

    public void setFullNameDoctor(String fullNameDoctor) {
        this.fullNameDoctor = fullNameDoctor;
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
