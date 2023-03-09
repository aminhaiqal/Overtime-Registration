package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.dbUtil.staffDAO;

@Controller
public class DataQuering {
    @Autowired
    private staffDAO staffDAO;
    
    public DataQuering() {}
    public DataQuering(String staff_id) {

        staffDAO = new staffDAO();
        staffDAO.getStaff(staff_id);
    }
}
