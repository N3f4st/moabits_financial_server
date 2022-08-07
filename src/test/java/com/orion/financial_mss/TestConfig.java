package com.orion.financial_mss;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@PropertySource(value = { "classpath:application.properties" })
public class TestConfig {

    @Bean
    @Profile("test")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://financial-mss.cq5rwssun8jt.us-east-1.rds.amazonaws.com:5432/mss_financial");
        dataSource.setUsername("postgres");
        dataSource.setPassword("sopazaNic4");

        return dataSource;
    }
}
