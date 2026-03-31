package com.services.dataBaseService.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class Db1Config {

    // user DataBaseSettings
    @Value("${db1.datasource.url}")
    private String dataBaseUrl1;
    @Value("${db1.datasource.username}")
    private String dataBaseUserName1;
    @Value("${db1.datasource.password}")
    private String dataBasePassword1;
    @Value("${db1.datasource.driver-class-name}")
    private String dataBaseDriver1;

    // Feed DataBaseSettings
    @Value("${db2.datasource.url}")
    private String dataBaseUrl2;
    @Value("${db2.datasource.username}")
    private String dataBaseUserName2;
    @Value("${db2.datasource.password}")
    private String dataBasePassword2;
    @Value("${db2.datasource.driver-class-name}")
    private String dataBaseDriver2;

    @Bean(name = "userDataSource")
    public DataSource UserdataSource(){
        return DataSourceBuilder.create()
                .url(dataBaseUrl1)
                .username(dataBaseUserName1)
                .password(dataBasePassword1)
                .driverClassName(dataBaseDriver1)
                .build();
    }

    @Bean(name="userJdbcTemplate")
    public JdbcTemplate UserjdbcTemplate(){
        return new JdbcTemplate(UserdataSource());
    }

    @Bean(name="feedDataSource")
    public DataSource FeeddataSource(){
        return DataSourceBuilder.create()
                .url(dataBaseUrl2)
                .username(dataBaseUserName2)
                .password(dataBasePassword2)
                .driverClassName(dataBaseDriver2)
                .build();
    }

    @Bean(name = "feedJdbcTemplate")
    public JdbcTemplate FeedjdbcTemplate(){
        return new JdbcTemplate(FeeddataSource());
    }

}
