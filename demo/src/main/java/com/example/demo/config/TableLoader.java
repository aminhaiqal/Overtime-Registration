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
        dropTable();
        createTable();
    }

    public void dropTable() {
        List<String> tables = jdbcTemplate.queryForList("SHOW TABLES", String.class);
        if (tables.contains("week1")) {
            jdbcTemplate.execute("DROP TABLE week1");
            System.out.println("Table 'week1' dropped");
        }
        if (tables.contains("week2")) {
            jdbcTemplate.execute("DROP TABLE week2");
            System.out.println("Table 'week2' dropped");
        }
        if (tables.contains("week3")) {
            jdbcTemplate.execute("DROP TABLE week3");
            System.out.println("Table 'week3' dropped");
        }
        if (tables.contains("week4")) {
            jdbcTemplate.execute("DROP TABLE week4");
            System.out.println("Table 'week4' dropped");
        }
        if (tables.contains("week5")) {
            jdbcTemplate.execute("DROP TABLE week5");
            System.out.println("Table 'week5' dropped");
        }
        if (tables.contains("registered")) {
            jdbcTemplate.execute("DROP TABLE registered");
            System.out.println("Table 'registered' dropped");
        }
        if (tables.contains("unregistered")) {
            jdbcTemplate.execute("DROP TABLE unregistered");
            System.out.println("Table 'unregistered' dropped");
        }
        if (tables.contains("staff")) {
            jdbcTemplate.execute("DROP TABLE staff");
            System.out.println("Table 'staff' dropped");
        }
    }

    public void createTable() {
        List<String> tables = jdbcTemplate.queryForList("SHOW TABLES", String.class);
        if (!tables.contains("staff")) {
            jdbcTemplate.execute("CREATE TABLE staff ("
                    + "staff_id VARCHAR(22) NOT NULL,"
                    + "name MEDIUMTEXT NOT NULL,"
                    + "date_joined VARCHAR(22) NOT NULL,"
                    + "section VARCHAR(45) NOT NULL,"
                    + "PRIMARY KEY (staff_id)"
                    + ")");
            System.out.println("Table 'staff' created");
        }
        if (!tables.contains("week1")) {
            jdbcTemplate.execute("CREATE TABLE week1 ("
                    + "staff_id VARCHAR(22) NOT NULL,"
                    + "MON BOOLEAN,"
                    + "TUE BOOLEAN,"
                    + "WED BOOLEAN,"
                    + "THU BOOLEAN,"
                    + "FRI BOOLEAN,"
                    + "SAT BOOLEAN,"
                    + "SUN BOOLEAN,"
                    + "PRIMARY KEY (staff_id),"
                    + "FOREIGN KEY (staff_id) REFERENCES staff(staff_id)"
                    + ")");
            System.out.println("Table 'week1' created");
        }
        if (!tables.contains("week2")) {
            jdbcTemplate.execute("CREATE TABLE week2 ("
                    + "staff_id VARCHAR(22) NOT NULL,"
                    + "MON BOOLEAN,"
                    + "TUE BOOLEAN,"
                    + "WED BOOLEAN,"
                    + "THU BOOLEAN,"
                    + "FRI BOOLEAN,"
                    + "SAT BOOLEAN,"
                    + "SUN BOOLEAN,"
                    + "PRIMARY KEY (staff_id),"
                    + "FOREIGN KEY (staff_id) REFERENCES staff(staff_id)"
                    + ")");
            System.out.println("Table 'week2' created");
        }
        if (!tables.contains("week3")) {
            jdbcTemplate.execute("CREATE TABLE week3 ("
                    + "staff_id VARCHAR(22) NOT NULL,"
                    + "MON BOOLEAN,"
                    + "TUE BOOLEAN,"
                    + "WED BOOLEAN,"
                    + "THU BOOLEAN,"
                    + "FRI BOOLEAN,"
                    + "SAT BOOLEAN,"
                    + "SUN BOOLEAN,"
                    + "PRIMARY KEY (staff_id),"
                    + "FOREIGN KEY (staff_id) REFERENCES staff(staff_id)"
                    + ")");
            System.out.println("Table 'week3' created");
        }
        if (!tables.contains("week4")) {
            jdbcTemplate.execute("CREATE TABLE week4 ("
                    + "staff_id VARCHAR(22) NOT NULL,"
                    + "MON BOOLEAN,"
                    + "TUE BOOLEAN,"
                    + "WED BOOLEAN,"
                    + "THU BOOLEAN,"
                    + "FRI BOOLEAN,"
                    + "SAT BOOLEAN,"
                    + "SUN BOOLEAN,"
                    + "PRIMARY KEY (staff_id),"
                    + "FOREIGN KEY (staff_id) REFERENCES staff(staff_id)"
                    + ")");
            System.out.println("Table 'week4' created");
        }
        if (!tables.contains("week5")) {
            jdbcTemplate.execute("CREATE TABLE week5 ("
                    + "staff_id VARCHAR(22) NOT NULL,"
                    + "MON BOOLEAN,"
                    + "TUE BOOLEAN,"
                    + "WED BOOLEAN,"
                    + "THU BOOLEAN,"
                    + "FRI BOOLEAN,"
                    + "SAT BOOLEAN,"
                    + "SUN BOOLEAN,"
                    + "PRIMARY KEY (staff_id),"
                    + "FOREIGN KEY (staff_id) REFERENCES staff(staff_id)"
                    + ")");
            System.out.println("Table 'week5' created");
        }
        if (!tables.contains("registered")){
            jdbcTemplate.execute("CREATE TABLE registered ("
                    + "staff_id VARCHAR(22) NOT NULL,"
                    + "date DATE NOT NULL,"
                    + "PRIMARY KEY (staff_id),"
                    + "FOREIGN KEY (staff_id) REFERENCES staff(staff_id)"
                    + ")");
            System.out.println("Table 'registered' created");
        }
        if (!tables.contains("unregistered")){
            jdbcTemplate.execute("CREATE TABLE unregistered ("
                    + "staff_id VARCHAR(22) NOT NULL,"
                    + "date DATE NOT NULL,"
                    + "PRIMARY KEY (staff_id),"
                    + "FOREIGN KEY (staff_id) REFERENCES staff(staff_id)"
                    + ")");
            System.out.println("Table 'unregistered' created");
        }
    }
}