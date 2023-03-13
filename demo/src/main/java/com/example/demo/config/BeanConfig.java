package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.demo.dbUtil.staffDAO;
import com.example.demo.dbUtil.weekDAO;

@Configuration
public class BeanConfig {
    @Bean
    public staffDAO staffDAO() {
        return new staffDAO();
    }

    @Bean
    public weekDAO overtimeDAO() {
        return new weekDAO();
    }
}
