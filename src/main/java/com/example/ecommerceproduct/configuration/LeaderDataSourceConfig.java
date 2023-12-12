package com.example.ecommerceproduct.configuration;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class LeaderDataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.leader")
    public DataSourceProperties leaderDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "leaderDataSource")
    public DataSource leaderDataSource() {
        return leaderDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }
}
