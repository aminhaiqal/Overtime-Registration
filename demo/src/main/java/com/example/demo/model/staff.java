package com.example.demo.model;

public class staff {
    private String staff_id;
    private String name;
    private String dept;
    private String section;

    public staff(String staff_id, String name, String dept, String section) {
        this.staff_id = staff_id;
        this.name = name;
        this.dept = dept;
        this.section = section;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDept(String dept) {
        this.dept = dept;
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
    public String getDept() {
        return dept;
    }
    public String getSection() {
        return section;
    }
}
