package com.web.flightManagementApplication.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "firstEntityManager",
                        basePackages = "com.web.flightManagementApplication.repository.primary",
                        transactionManagerRef = "firstTransactionManager")
public class PrimaryDatasourceConfiguration {

    @Primary
    @Bean(name="firstDatasource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource datasource(){
        //if need any hikari properties add here
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name="firstEntityManager")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setDataSource(datasource());
        bean.setPackagesToScan("com.web.flightManagementApplication.models.primary");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        bean.setJpaVendorAdapter(vendorAdapter);
        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect"); // Set your DB's dialect
        jpaProperties.put("hibernate.hbm2ddl.auto", "update");
        // Example: Update schema automatically
        jpaProperties.put("jakarta.persistence.jdbc.url", "jdbc:mysql://localhost:3306/flightbookings"); // Replace with your DB URL
        jpaProperties.put("jakarta.persistence.jdbc.user", "root"); // Replace with your DB username
        jpaProperties.put("jakarta.persistence.jdbc.password", "root"); // Replace with your DB password

        bean.setJpaProperties(jpaProperties);
        return bean;
    }

    @Primary
    @Bean(name="firstTransactionManager")
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
        return manager;
    }


}
