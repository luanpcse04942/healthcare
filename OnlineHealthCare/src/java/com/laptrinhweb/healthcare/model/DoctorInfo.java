package com.laptrinhweb.healthcare.model;

/**
 *
 * @author LuanPC
 */
public class DoctorInfo {
    private int id;
    private int doctorId;
    private String doctorName;
    private int facilityId;
    private String facilityName;
    private int specialtyId;
    private String specialtyName;
    private int positionId;
    private String positionName;
    private int priceId;
    private String priceValue;

    public DoctorInfo() {
    }

    public DoctorInfo(int id, int doctorId, String doctorName, int facilityId, String facilityName, int specialtyId, String specialtyName, int positionId, String positionName, int priceId, String priceValue) {
        this.id = id;
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.facilityId = facilityId;
        this.facilityName = facilityName;
        this.specialtyId = specialtyId;
        this.specialtyName = specialtyName;
        this.positionId = positionId;
        this.positionName = positionName;
        this.priceId = priceId;
        this.priceValue = priceValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public int getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(int specialtyId) {
        this.specialtyId = specialtyId;
    }

    public String getSpecialtyName() {
        return specialtyName;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    public String getPriceValue() {
        return priceValue;
    }

    public void setPriceValue(String priceValue) {
        this.priceValue = priceValue;
    }
    
    
}
