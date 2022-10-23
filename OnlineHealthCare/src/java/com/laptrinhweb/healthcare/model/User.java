package com.laptrinhweb.healthcare.model;

import java.sql.Date;

/**
 *
 * @author LuanPC
 */
public class User {
    private Integer id;
    private Integer roleId;
    private String roleName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String gender;
    private String phoneNumber;
    private String address;
    private String images;
    private Date createdAt;
    private Date updatedAt;
    private boolean onlineStatus;
    private int activedStatus;

    public User() {
        
    }
    
    public User(Integer id, Integer roleId, String roleName, String firstName, 
            String lastName, String email, String password, String gender, 
            String phoneNumber, String address, String images, Date createdAt, 
            Date updatedAt, boolean onlineStatus, int activedStatus) {
        this.id = id;
        this.roleId = roleId;
        this.roleName = roleName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.images = images;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.onlineStatus = onlineStatus;
        this.activedStatus = activedStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
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

    public boolean isOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(boolean onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public int getActivedStatus() {
        return activedStatus;
    }

    public void setActivedStatus(int activedStatus) {
        this.activedStatus = activedStatus;
    }
   
}
