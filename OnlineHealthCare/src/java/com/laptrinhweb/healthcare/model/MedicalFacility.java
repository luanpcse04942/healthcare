package com.laptrinhweb.healthcare.model;

import java.sql.Date;

/**
 *
 * @author LuanPC
 */
public class MedicalFacility {
    private int id;
    private int provinceId;
    private String provinceName;
    private String address;
    private String description;
    private Date establishedAt;
    private Date createdAt;
    private Date updatedAt;

    public MedicalFacility(int id, int provinceId, String provinceName, String address, String description, Date establishedAt, Date createdAt, Date updatedAt) {
        this.id = id;
        this.provinceId = provinceId;
        this.provinceName = provinceName;
        this.address = address;
        this.description = description;
        this.establishedAt = establishedAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEstablishedAt() {
        return establishedAt;
    }

    public void setEstablishedAt(Date establishedAt) {
        this.establishedAt = establishedAt;
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
