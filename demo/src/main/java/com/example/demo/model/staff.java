package com.example.demo.model;

public class staff {
    private String staff_id;
    private String name;
    private String date_joined;
    private String section;

    public staff(String staff_id, String name, String date_joined, String section) {
        this.staff_id = staff_id;
        this.name = name;
        this.date_joined = date_joined;
        this.section = section;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDate_joined(String date_joined) {
        this.date_joined = date_joined;
    }
    public void setSection(String section) {
        this.section = section;
    }

    public String getStaff_id() {
        return staff_id;
    }
    public String getName() {
        return name;
    }
    public String getDate_joined() {
        return date_joined;
    }
    public String getSection() {
        return section;
    }
}
