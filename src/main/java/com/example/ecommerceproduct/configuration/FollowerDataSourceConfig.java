package com.example.ecommerceproduct.configuration;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class FollowerDataSourceConfig {


    @Bean
    @ConfigurationProperties("spring.datasource.follower")
    public DataSourceProperties followerDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "followerDataSource")
    public DataSource followerDataSource() {
        return followerDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }
}
