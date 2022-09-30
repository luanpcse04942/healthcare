package com.laptrinhweb.healthcare.model;

/**
 *
 * @author LuanPC
 */
public class Price {
    private int id;
    private int value;

    public Price(int id, int value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
}
