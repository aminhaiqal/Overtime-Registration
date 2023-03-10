package com.example.demo.dbUtil;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.dao.DuplicateKeyException;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.overtime;
import com.example.demo.config.DataSourceConfig;

@Repository
public class overtimeDAO {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceConfig.getDataSource());

    // Insert overtime into overtime table
    public int insertOvertime(overtime overtime) {
        try {
            String sql = "INSERT INTO overtime (staff_id, MON, TUE, WED, THU, FRI, SAT, SUN) VALUES (?,?,?,?,?,?,?,?)";
            Object[] params = { overtime.getStaff_id(), overtime.getMON(), overtime.getTUE(), overtime.getWED(), overtime.getTHU(), overtime.getFRI(), overtime.getSAT(), overtime.getSUN() };
            return jdbcTemplate.update(sql, params);
            
        } catch (DuplicateKeyException e) {
            return 0; // Skip the row and return 0
        } 
    }


    // Get overtime from overtime table
    public List<overtime>getOvertimeList() {
        List<overtime>overtimelist = new ArrayList<overtime>();
        
        try {
            String sql = "SELECT * FROM overtime";
            overtimelist = jdbcTemplate.query(sql, new BeanPropertyRowMapper<overtime>(overtime.class));
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return overtimelist;
    }
}
