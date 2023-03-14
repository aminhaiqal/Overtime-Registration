package com.example.demo.controller;

import org.springframework.stereotype.Controller;

import com.example.demo.model.staff;
import com.example.demo.model.week;

@Controller
public class AssignString {
    public AssignString() {}
    public AssignString(String[][] data){
        for (int i = 1; i < data.length; i++) {
            staff staff = new staff(data[i][0], data[i][1], data[i][4], data[i][2]);
            week week1 = new week(data[i][0], parseBoolean(data[i][5]), parseBoolean(data[i][6]), parseBoolean(data[i][7]), parseBoolean(data[i][8]), parseBoolean(data[i][9]), parseBoolean(data[i][10]), parseBoolean(data[i][11]));
            week week2 = new week(data[i][0], parseBoolean(data[i][12]), parseBoolean(data[i][13]), parseBoolean(data[i][14]), parseBoolean(data[i][15]), parseBoolean(data[i][16]), parseBoolean(data[i][17]), parseBoolean(data[i][18]));
            week week3 = new week(data[i][0], parseBoolean(data[i][19]), parseBoolean(data[i][20]), parseBoolean(data[i][21]), parseBoolean(data[i][22]), parseBoolean(data[i][23]), parseBoolean(data[i][24]), parseBoolean(data[i][25]));
            week week4 = new week(data[i][0], parseBoolean(data[i][26]), parseBoolean(data[i][27]), parseBoolean(data[i][28]), parseBoolean(data[i][29]), parseBoolean(data[i][30]), parseBoolean(data[i][31]), parseBoolean(data[i][32]));
            week week5 = new week(data[i][0], parseBoolean(data[i][33]), parseBoolean(data[i][34]), parseBoolean(data[i][35]), false, false, false, false);
            
            week[] weeks = {week1, week2, week3, week4, week5};
            new DataLoading(staff, weeks);
        }
    }

    public boolean parseBoolean(String s) {
        return "1".equals(s);
    }
}
