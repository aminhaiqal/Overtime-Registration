package com.example.demo.dbUtil;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.dao.DuplicateKeyException;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.week;
import com.example.demo.config.DataSourceConfig;

@Repository
public class weekDAO {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceConfig.getDataSource());

    // Insert week into week1, week2, week3, week4, week5 table respectively
    public int insertWeek(int weeknum, week week) {
        try {
            String sql = "INSERT INTO week" + weeknum + "(staff_id, FirstDay, SecondDay, ThirdDay, FourthDay, FifthDay, SixthDay, SeventhDay) VALUES (?,?,?,?,?,?,?,?)";
            Object[] params = { week.getStaff_id(), week.getFirstDay(), week.getSecondDay(), week.getThirdDay(), week.getFourthDay(), week.getFifthDay(), week.getSixthDay(), week.getSeventhDay() };
            return jdbcTemplate.update(sql, params);
            
        } catch (DuplicateKeyException e) {
            return 0; // Skip the row and return 0
        } 
    }

    // Get week from week table
    public List<week>getweekList(int weeknum) {
        List<week>weeklist = new ArrayList<week>();
        
        try {
            String sql = "SELECT * FROM week" + weeknum;
            weeklist = jdbcTemplate.query(sql, new BeanPropertyRowMapper<week>(week.class));
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return weeklist;
    }
}
