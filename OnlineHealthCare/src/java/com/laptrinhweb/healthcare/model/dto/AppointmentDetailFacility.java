/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laptrinhweb.healthcare.model.dto;

import java.util.Date;

/**
 *
 * @author mikuo
 */
public class AppointmentDetailFacility {
    private int id;
    private String namePatient;
    private String nameDoctor;
    private String gender;
    private String phonePatient;
    private Date bookingDate;
    private int price;
    private String specName;
    private String nameFac;
    private String phoneDoctor;
    private String phoneFac;
    private String timeValue;
    private String status;
    private String imagePatient;
    private String imageDoctor;

    public AppointmentDetailFacility() {
    }

    public AppointmentDetailFacility(int id, String namePatient, String nameDoctor, String gender, String phonePatient, Date bookingDate, int price, String specName, String nameFac, String phoneDoctor, String phoneFac, String timeValue, String status, String imagePatient, String imageDoctor) {
        this.id = id;
        this.namePatient = namePatient;
        this.nameDoctor = nameDoctor;
        this.gender = gender;
        this.phonePatient = phonePatient;
        this.bookingDate = bookingDate;
        this.price = price;
        this.specName = specName;
        this.nameFac = nameFac;
        this.phoneDoctor = phoneDoctor;
        this.phoneFac = phoneFac;
        this.timeValue = timeValue;
        this.status = status;
        this.imagePatient = imagePatient;
        this.imageDoctor = imageDoctor;
    }

    public String getImagePatient() {
        return imagePatient;
    }

    public void setImagePatient(String imagePatient) {
        this.imagePatient = imagePatient;
    }

    public String getImageDoctor() {
        return imageDoctor;
    }

    public void setImageDoctor(String imageDoctor) {
        this.imageDoctor = imageDoctor;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamePatient() {
        return namePatient;
    }

    public void setNamePatient(String namePatient) {
        this.namePatient = namePatient;
    }

    public String getNameDoctor() {
        return nameDoctor;
    }

    public void setNameDoctor(String nameDoctor) {
        this.nameDoctor = nameDoctor;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhonePatient() {
        return phonePatient;
    }

    public void setPhonePatient(String phonePatient) {
        this.phonePatient = phonePatient;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public String getNameFac() {
        return nameFac;
    }

    public void setNameFac(String nameFac) {
        this.nameFac = nameFac;
    }

    public String getPhoneDoctor() {
        return phoneDoctor;
    }

    public void setPhoneDoctor(String phoneDoctor) {
        this.phoneDoctor = phoneDoctor;
    }

    public String getPhoneFac() {
        return phoneFac;
    }

    public void setPhoneFac(String phoneFac) {
        this.phoneFac = phoneFac;
    }

    public String getTimeValue() {
        return timeValue;
    }

    public void setTimeValue(String timeValue) {
        this.timeValue = timeValue;
    }
    
    
}
