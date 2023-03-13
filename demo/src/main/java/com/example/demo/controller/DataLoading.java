package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.dbUtil.weekDAO;
import com.example.demo.dbUtil.staffDAO;
import com.example.demo.model.week;
import com.example.demo.model.staff;

@Controller
public class DataLoading {
    @Autowired
    private staffDAO staffDAO;
    @Autowired
    private weekDAO weekDAO;
    
    public DataLoading() {}
    public DataLoading(staff staff, week[] weeks) {
        staffDAO = new staffDAO();
        staffDAO.insertStaff(staff);
        for (week week : weeks) {
            weekDAO = new weekDAO();
            weekDAO.insertWeek(week);
        }
    }
}