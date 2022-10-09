/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laptrinhweb.healthcare.model;

import java.sql.Date;


public class Facility {
     private int id;
    private int medicalFacilityId;
    private String description;
    private Date established;
    private Date createdAt;
    private Date updatedAt;

    public Facility() {
    }

    public Facility(int id, int medicalFacilityId, String description, Date established, Date createdAt, Date updatedAt) {
        this.id = id;
        this.medicalFacilityId = medicalFacilityId;
        this.description = description;
        this.established = established;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMedicalFacilityId() {
        return medicalFacilityId;
    }

    public void setMedicalFacilityId(int medicalFacilityId) {
        this.medicalFacilityId = medicalFacilityId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEstablished() {
        return established;
    }

    public void setEstablished(Date established) {
        this.established = established;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    
}
