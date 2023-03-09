package com.example.demo.dbUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;
import java.sql.ResultSet;

import com.example.demo.model.staff;

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
    @Autowired
    JdbcTemplate jdbcTemplate;

    // Insert staff into staff table
    public int insertStaff (staff staff) {
        int numRowsInserted = 0;

        String sql = "INSERT INTO staff (staff_id, name, dept, section) VALUES (?,?,?,?)";
        Object[] params = {staff.getStaff_id(), staff.getName(), staff.getDept(), staff.getSection()};
        numRowsInserted = jdbcTemplate.update(sql, params);
        
        /*try(Connection connection = jdbcTemplate.getDataSource().getConnection()) {
            String sql = "INSERT INTO staff (staff_id, name, dept, section) VALUES (?,?,?,?)";
            Object[] params = {staff.getStaff_id(), staff.getName(), staff.getDept(), staff.getSection()};
            numRowsInserted = jdbcTemplate.update(sql, params);

        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        return numRowsInserted;
    }

    // Get staff from staff table
    public staff getStaff (String staff_id) {
        staff staff = null;
    
        try (Connection connection = jdbcTemplate.getDataSource().getConnection()) {
            String sql = "SELECT * FROM staff WHERE staff_id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, staff_id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                staff = new staff(rs.getString("staff_id"), rs.getString("name"), rs.getString("dept"), rs.getString("section"));
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return staff;
    }
}
