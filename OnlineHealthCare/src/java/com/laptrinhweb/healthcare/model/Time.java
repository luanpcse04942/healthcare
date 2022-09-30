package com.laptrinhweb.healthcare.model;

/**
 *
 * @author LuanPC
 */
public class Time {
    private int id;
    private String value;

    public Time(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
   
}
