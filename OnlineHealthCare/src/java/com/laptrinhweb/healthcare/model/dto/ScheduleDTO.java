package com.laptrinhweb.healthcare.model.dto;

import java.sql.Date;

/**
 *
 * @author LuanPC
 */
public class ScheduleDTO {
    private int doctorID;
    private Date scheduleDate;
    private int scheduleID;

    public ScheduleDTO() {
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public int getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(int scheduleID) {
        this.scheduleID = scheduleID;
    }
    
}
