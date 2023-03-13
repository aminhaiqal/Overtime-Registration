package com.example.demo.controller;

import org.springframework.stereotype.Controller;

import com.example.demo.model.staff;
import com.example.demo.model.week;

@Controller
public class AssignString {
    public AssignString() {}
    public AssignString(String[] result){
        staff staff = new staff(result[0], result[1], result[4], result[2]);
        System.out.println(result[0] + " " + result[1] + " " + result[4] + " " + result[2]);
        week week1 = new week(result[0], parseBoolean(result[5]), parseBoolean(result[6]), parseBoolean(result[7]), parseBoolean(result[8]), parseBoolean(result[9]), parseBoolean(result[10]), parseBoolean(result[11]));
        week week2 = new week(result[0], parseBoolean(result[12]), parseBoolean(result[13]), parseBoolean(result[14]), parseBoolean(result[15]), parseBoolean(result[16]), parseBoolean(result[17]), parseBoolean(result[18]));
        week week3 = new week(result[0], parseBoolean(result[19]), parseBoolean(result[20]), parseBoolean(result[21]), parseBoolean(result[22]), parseBoolean(result[23]), parseBoolean(result[24]), parseBoolean(result[25]));
        week week4 = new week(result[0], parseBoolean(result[26]), parseBoolean(result[27]), parseBoolean(result[28]), parseBoolean(result[29]), parseBoolean(result[30]), parseBoolean(result[31]), parseBoolean(result[32]));
        week week5 = new week(result[0], parseBoolean(result[33]), parseBoolean(result[34]), parseBoolean(result[35]), parseBoolean(result[36]), parseBoolean(result[37]), parseBoolean(result[38]), parseBoolean(result[39]));
        
        week[] weeks = {week1, week2, week3, week4, week5};
        new DataLoading(staff, weeks);
    }

    public boolean parseBoolean(String s) {
        return s != null && !s.isEmpty() && Double.parseDouble(s) != 0.0;
    }
}
