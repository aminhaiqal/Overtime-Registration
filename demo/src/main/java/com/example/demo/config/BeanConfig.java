package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.demo.dbUtil.staffDAO;
import com.example.demo.dbUtil.overtimeDAO;

@Configuration
public class BeanConfig {
    @Bean
    public staffDAO staffDAO() {
        return new staffDAO();
    }

    @Bean
    public overtimeDAO overtimeDAO() {
        return new overtimeDAO();
    }
}
