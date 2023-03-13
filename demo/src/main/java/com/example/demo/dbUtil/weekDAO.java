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

    // Insert week into week table
    public int insertWeek(week week) {
        try {
            String sql = "INSERT INTO week (staff_id, MON, TUE, WED, THU, FRI, SAT, SUN) VALUES (?,?,?,?,?,?,?,?)";
            Object[] params = { week.getStaff_id(), week.getMonday(), week.getTuesday(), week.getWednesday(), week.getThursday(), week.getFriday(), week.getSaturday(), week.getSunday() };
            return jdbcTemplate.update(sql, params);
            
        } catch (DuplicateKeyException e) {
            return 0; // Skip the row and return 0
        } 
    }


    // Get week from week table
    public List<week>getweekList() {
        List<week>weeklist = new ArrayList<week>();
        
        try {
            String sql = "SELECT * FROM week";
            weeklist = jdbcTemplate.query(sql, new BeanPropertyRowMapper<week>(week.class));
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return weeklist;
    }
}
