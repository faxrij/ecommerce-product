package com.example.ecommerceproduct.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.example.ecommerceproduct.repository.read",
        entityManagerFactoryRef = "followerEntityManagerFactory",
        transactionManagerRef = "followerTransactionManager"
)
public class FollowerJpaConfiguration {

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean followerEntityManagerFactory(
            @Qualifier("followerDataSource") DataSource dataSource,
            EntityManagerFactoryBuilder builder) {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.hbm2ddl.auto", "validate");
        return builder.dataSource(dataSource)
                .packages("com.example.ecommerceproduct.entity")
                .properties(properties)
                .build();
    }

    @Bean
    @Primary
    public PlatformTransactionManager followerTransactionManager (
            @Qualifier("followerEntityManagerFactory") LocalContainerEntityManagerFactoryBean followerEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(followerEntityManagerFactory.getObject()));
    }
}
