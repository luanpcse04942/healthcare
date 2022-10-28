package com.laptrinhweb.healthcare.model.dto;

/**
 *
 * @author LuanPC
 */
public class ScheduleTimesDTO {
    private int scheduleID;
    private int timeID;
    private String timeValue;

    public ScheduleTimesDTO() {
    }

    public int getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(int scheduleID) {
        this.scheduleID = scheduleID;
    }

    public int getTimeID() {
        return timeID;
    }

    public void setTimeID(int timeID) {
        this.timeID = timeID;
    }

    public String getTimeValue() {
        return timeValue;
    }

    public void setTimeValue(String timeValue) {
        this.timeValue = timeValue;
    }
}
