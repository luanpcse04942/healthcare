package com.laptrinhweb.healthcare.model;

import java.sql.Date;

/**
 *
 * @author LuanPC
 */
public class Handbook {
    private int id;
    private int adminId;
    private String adminName;
    private String handbookName;
    private byte[] content;
    private Date publishedAt;
    private String image;
    private String content;



    public Handbook() {
    }

    public Handbook(int id, int adminId, String handbookName, Date publishedAt, String image, String content) {
        this.id = id;
        this.adminId = adminId;
        this.adminName = adminName;
        this.handbookName = handbookName;
        this.content = content;
        this.publishedAt = publishedAt;
        this.image = image;
        this.content = content;
    }



    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getHandbookName() {
        return handbookName;
    }

    public void setHandbookName(String handbookName) {
        this.handbookName = handbookName;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    
}
