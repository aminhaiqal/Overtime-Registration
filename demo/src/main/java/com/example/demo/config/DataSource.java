package com.example.demo.config;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DataSource {
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/staff_attendance");
        dataSource.setUsername("root");
        dataSource.setPassword("HawbAndFj6");
        return dataSource;
    }
    
}
