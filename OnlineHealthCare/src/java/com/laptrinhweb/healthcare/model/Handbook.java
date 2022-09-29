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
    private Date updatedAt;

    public Handbook(int id, int adminId, String adminName, String handbookName, byte[] content, Date publishedAt, Date updatedAt) {
        this.id = id;
        this.adminId = adminId;
        this.adminName = adminName;
        this.handbookName = handbookName;
        this.content = content;
        this.publishedAt = publishedAt;
        this.updatedAt = updatedAt;
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
