package com.example.demo.dbUtil;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

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
        } catch (Exception e) {
            System.out.println("Error inserting staff: " + e.getMessage());
            return 0;
        }
    }

    // Get staff from staff table
    public staff getStaff (String staff_id) {
        staff staff = null;
        String sql = "SELECT * FROM staff WHERE staff_id = ?";

        try{
            staff = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<staff>(staff.class), staff_id);
            return staff;
        } catch (Exception e) {
            return null;
        }
    }
}
