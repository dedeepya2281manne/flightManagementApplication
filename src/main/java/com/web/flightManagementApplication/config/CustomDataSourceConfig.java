//package com.web.flightManagementApplication.config;
//
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class CustomDataSourceConfig {
//
//    @Bean
//    public DataSource dataSource(){
//        HikariConfig config = new HikariConfig();
//
//        config.setJdbcUrl("jdbc:mysql://localhost:3306/flightbookings");
//        config.setUsername("root");
//        config.setPassword("root");
//        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
//
//        // Custom HikariCP settings
//        config.setMaximumPoolSize(20);
//        config.setMinimumIdle(5);
//        config.setIdleTimeout(300000); // 5 minutes
//        config.setMaxLifetime(1800000); // 30 minutes
//        config.setConnectionTimeout(20000); // 20 seconds
//        config.setPoolName("MyCustomHikariPool");
//
//        return new HikariDataSource(config);
//    }
//}
