package com.shopping.web;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * 프로젝트 작업시 사용할 bean을 정의하는 클래스
 *
 * @author ycjung
 * @since 2022.03.14
 */
@Configuration
@PropertySource(value = "classpath:/application.properties", ignoreResourceNotFound = true)
public class RootConfig {

    private final Logger Logger = LogManager.getLogger(this.getClass());

    @Autowired
    Environment env;
    
    @Bean
    public DataSource setDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        
        return dataSource;
    }
    
}
