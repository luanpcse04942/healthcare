package com.laptrinhweb.healthcare.model;

import java.sql.Date;

/**
 *
 * @author LuanPC
 */
public class DoctorSchedule {
    private int doctorId;
    private String doctorName;
    private int timeId;
    private String timeValue;
    private Date scheduleDate;

    public DoctorSchedule(int doctorId, String doctorName, int timeId, String timeValue, Date scheduleDate) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.timeId = timeId;
        this.timeValue = timeValue;
        this.scheduleDate = scheduleDate;
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

    public int getTimeId() {
        return timeId;
    }

    public void setTimeId(int timeId) {
        this.timeId = timeId;
    }

    public String getTimeValue() {
        return timeValue;
    }

    public void setTimeValue(String timeValue) {
        this.timeValue = timeValue;
    }

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

}
