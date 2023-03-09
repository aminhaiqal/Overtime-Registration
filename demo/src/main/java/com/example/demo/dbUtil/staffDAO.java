package com.example.demo.dbUtil;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.staff;
import com.example.demo.config.DataSourceConfig;

/*
 * ____________________________________________________________
 * |  • The @Repository annotation indicates that the staffDAO class 
 * |    is a Spring repository.
 * |  • The DataSource instance variable is autowired, allowing the 
 * |    staffDAO class to connect to the database.
 * |  • The insertStaff method inserts a new row into the staff table 
 * |    with the specified staff object's properties using a prepared 
 * |    statement. It returns the number of rows affected by the insert.
 * |  • The getStaff method returns a staff object with the specified
 * |____________________________________________________________
 */

@Repository
public class staffDAO {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceConfig.getDataSource());

    // Insert staff into staff table
    public int insertStaff(staff staff) {
        try {
            String sql = "INSERT INTO staff (staff_id, name, dept, section) VALUES (?,?,?,?)";
            Object[] params = {staff.getStaff_id(), staff.getName(), staff.getDept(), staff.getSection()};
            return jdbcTemplate.update(sql, params);
            
        } catch (DuplicateKeyException e) {
            return 0; // Skip the row and return 0
        }
    }

    // Get staff from staff table
    public List<staff> getStaffList() {
        List<staff> staffList = new ArrayList<staff>();

        try{
            String sql = "SELECT * FROM staff";
            staffList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<staff>(staff.class));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return staffList;
    }
}
