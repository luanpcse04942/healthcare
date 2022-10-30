package com.laptrinhweb.healthcare.model;

import java.sql.Date;

/**
 *
 * @author LuanPC
 */
public class Handbook {
    private int id;
    private int adminId;
    private String handbookName;
    private Date publishedAt;
    private String image;
    private String content;
    private String fullName;



    public Handbook() {
    }

    public Handbook(int id, int adminId, String handbookName, Date publishedAt, String image, String content, String fullName) {
        this.id = id;
        this.adminId = adminId;
        this.handbookName = handbookName;
        this.publishedAt = publishedAt;
        this.image = image;
        this.content = content;
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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


    public String getHandbookName() {
        return handbookName;
    }

    public void setHandbookName(String handbookName) {
        this.handbookName = handbookName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }
    
    
}
