package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dbUtil.weekDAO;
import com.example.demo.model.week;
import com.example.demo.dbUtil.staffDAO;
import com.example.demo.model.staff;

@Controller
public class DataQuering {
    @Autowired
    private weekDAO weekDAO;
    @Autowired
    private staffDAO staffDAO;
    
    public DataQuering() {}
    @GetMapping("/week")
    @ResponseBody
    public List<week> getweek() {
        List<week> weekList = weekDAO.getweekList();
        return weekList;
    }

    @GetMapping("/staff")
    @ResponseBody
    public List<staff> getStaff() {
        List<staff> staffList = staffDAO.getStaffList();
        return staffList;
    }
}
