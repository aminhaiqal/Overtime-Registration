package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DataSourceConfig {
    public static DataSource getDataSource() {
        DataSource dataSource = null;

        String url = "jdbc:mysql://localhost:3306/staff_attendance";
        String username = "root";
        String password = "HawbAndFj6";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dataSource = new DriverManagerDataSource(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return dataSource;
    }
}
