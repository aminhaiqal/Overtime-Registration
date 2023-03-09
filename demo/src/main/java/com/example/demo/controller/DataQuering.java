package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dbUtil.overtimeDAO;
import com.example.demo.model.overtime;
import com.example.demo.dbUtil.staffDAO;
import com.example.demo.model.staff;

@Controller
public class DataQuering {
    @Autowired
    private overtimeDAO overtimeDAO;
    @Autowired
    private staffDAO staffDAO;
    
    public DataQuering() {}
    @GetMapping("/overtime")
    @ResponseBody
    public List<overtime> getOvertime() {
        List<overtime> overtimeList = overtimeDAO.getOvertimeList();
        return overtimeList;
    }

    @GetMapping("/staff")
    @ResponseBody
    public List<staff> getStaff() {
        List<staff> staffList = staffDAO.getStaffList();
        return staffList;
    }
}
