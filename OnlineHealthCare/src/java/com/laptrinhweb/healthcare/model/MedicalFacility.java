package com.laptrinhweb.healthcare.model;

import java.sql.Date;

/**
 *
 * @author LuanPC
 */
public class MedicalFacility extends User{
    private int provinceId;
    private String provinceName;
    private String description;
    private Date establishedAt;

    public MedicalFacility() {
    }

    public MedicalFacility(int id, int provinceId, String provinceName, String description, Date establishedAt) {
        this.provinceId = provinceId;
        this.provinceName = provinceName;
        this.description = description;
        this.establishedAt = establishedAt;
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
}
