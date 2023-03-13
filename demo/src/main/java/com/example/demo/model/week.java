package com.example.demo.model;

public class week {
    public String staff_id;
    public Boolean Monday;
    public Boolean Tuesday;
    public Boolean Wednesday;
    public Boolean Thursday;
    public Boolean Friday;
    public Boolean Saturday;
    public Boolean Sunday;

    public week(String staff_id, Boolean Monday, Boolean Tuesday, Boolean Wednesday, Boolean Thursday, Boolean Friday, Boolean Saturday, Boolean Sunday) {
        this.staff_id = staff_id;
        this.Monday = Monday;
        this.Tuesday = Tuesday;
        this.Wednesday = Wednesday;
        this.Thursday = Thursday;
        this.Friday = Friday;
        this.Saturday = Saturday;
        this.Sunday = Sunday;
    }

    public String getStaff_id() {
        return staff_id;
    }
    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }
    public Boolean getMonday() {
        return Monday;
    }
    public void setMonday(Boolean monday) {
        Monday = monday;
    }
    public Boolean getTuesday() {
        return Tuesday;
    }
    public void setTuesday(Boolean tuesday) {
        Tuesday = tuesday;
    }
    public Boolean getWednesday() {
        return Wednesday;
    }
    public void setWednesday(Boolean wednesday) {
        Wednesday = wednesday;
    }
    public Boolean getThursday() {
        return Thursday;
    }
    public void setThursday(Boolean thursday) {
        Thursday = thursday;
    }
    public Boolean getFriday() {
        return Friday;
    }
    public void setFriday(Boolean friday) {
        Friday = friday;
    }
    public Boolean getSaturday() {
        return Saturday;
    }
    public void setSaturday(Boolean saturday) {
        Saturday = saturday;
    }
    public Boolean getSunday() {
        return Sunday;
    }
    public void setSunday(Boolean sunday) {
        Sunday = sunday;
    }
}
