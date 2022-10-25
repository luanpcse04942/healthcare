package com.laptrinhweb.healthcare.model.dto;

/**
 *
 * @author LuanPC
 */
public class DoctorInfoDTO {
    private int doctorId;
    private String doctorName;
    private String image;
    private String address;
    private String positionName;
    private String provinceName;
    private int price;

    public DoctorInfoDTO() {
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
    
    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
}
