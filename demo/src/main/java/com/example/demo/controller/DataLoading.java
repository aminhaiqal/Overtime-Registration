package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.dbUtil.overtimeDAO;
import com.example.demo.dbUtil.staffDAO;
import com.example.demo.model.overtime;
import com.example.demo.model.staff;

@Controller
public class DataLoading {
    @Autowired
    private staffDAO staffDAO;
    @Autowired
    private overtimeDAO overtimeDAO;
    
    public DataLoading() {}
    public DataLoading(String staff_id, String name, String dept, String section, 
                       Boolean MON, Boolean TUE, Boolean WED, Boolean THU, Boolean FRI, Boolean SAT, Boolean SUN) {
        
        System.out.println("Staff Staff ID: " + staff_id + " Successfully Inserted");
        staff staff = new staff(staff_id, name, dept, section);
        overtime overtime = new overtime(staff_id, MON, TUE, WED, THU, FRI, SAT, SUN);

        staffDAO = new staffDAO();
        staffDAO.insertStaff(staff);

        overtimeDAO = new overtimeDAO();
        overtimeDAO.insertOvertime(overtime);
    }
}