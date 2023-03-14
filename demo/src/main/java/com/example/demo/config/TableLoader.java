package com.example.demo.config;

import java.util.List;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/*
 * _____________________________________________________________________________
 * |  • A class that creates database tables using the Spring JDBC template.
 * |  • This class uses the Spring `JdbcTemplate` to execute SQL queries and create
 * |    two tables: 'staff' and 'overtime'. If these tables do not already exist in
 * |    the database, they are created with the specified columns.
 * |  • The `createTable` method is called automatically when the Spring context is
 * |    refreshed, thanks to the `@EventListener` annotation.
 * |____________________________________________________________________________
 */

@Component
public class TableLoader {
    private final JdbcTemplate jdbcTemplate;

    public TableLoader(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //dropTable();
        createStaffTable();
        createWeekTables();
        createRegisteredTable();
        createUnregisteredTable();
    }

    public void dropTable() {
        List<String> tables = jdbcTemplate.queryForList("SHOW TABLES", String.class);
        String[] tableNames = { "week1", "week2", "week3", "week4", "week5", "registered", "unregistered", "staff" };
        for (String tableName : tableNames) {
            if (tables.contains(tableName)) {
                jdbcTemplate.execute("DROP TABLE " + tableName);
                System.out.println("Table '" + tableName + "' dropped");
            }
        }
    }
    
    private void createStaffTable() {
        if (!tableExists("staff")) {
            jdbcTemplate.execute("CREATE TABLE staff ("
                    + "staff_id VARCHAR(22) NOT NULL,"
                    + "name MEDIUMTEXT NOT NULL,"
                    + "date_joined VARCHAR(22) NOT NULL,"
                    + "section VARCHAR(45) NOT NULL,"
                    + "PRIMARY KEY (staff_id)"
                    + ")");
            System.out.println("Table 'staff' created");
        }
    }
    
    private void createWeekTables() {
        for (int i = 1; i <= 5; i++) {
            String tableName = "week" + i;
            if (!tableExists(tableName)) {
                jdbcTemplate.execute("CREATE TABLE " + tableName + " ("
                        + "staff_id VARCHAR(22) NOT NULL,"
                        + "FirstDay BOOLEAN,"
                        + "SecondDay BOOLEAN,"
                        + "ThirdDay BOOLEAN,"
                        + "FourthDay BOOLEAN,"
                        + "FifthDay BOOLEAN,"
                        + "SixthDay BOOLEAN,"
                        + "SeventhDay BOOLEAN,"
                        + "PRIMARY KEY (staff_id),"
                        + "FOREIGN KEY (staff_id) REFERENCES staff(staff_id)"
                        + ")");
                System.out.println("Table '" + tableName + "' created");
            }
        }
    }
    
    private void createRegisteredTable() {
        if (!tableExists("registered")) {
            jdbcTemplate.execute("CREATE TABLE registered ("
                    + "staff_id VARCHAR(22) NOT NULL,"
                    + "date DATE NOT NULL,"
                    + "PRIMARY KEY (staff_id),"
                    + "FOREIGN KEY (staff_id) REFERENCES staff(staff_id)"
                    + ")");
            System.out.println("Table 'registered' created");
        }
    }
    
    private void createUnregisteredTable() {
        if (!tableExists("unregistered")) {
            jdbcTemplate.execute("CREATE TABLE unregistered ("
                    + "staff_id VARCHAR(22) NOT NULL,"
                    + "date DATE NOT NULL,"
                    + "PRIMARY KEY (staff_id),"
                    + "FOREIGN KEY (staff_id) REFERENCES staff(staff_id)"
                    + ")");
            System.out.println("Table 'unregistered' created");
        }
    }
    
    private boolean tableExists(String tableName) {
        List<String> tables = jdbcTemplate.queryForList("SHOW TABLES", String.class);
        return tables.contains(tableName);
    }
}