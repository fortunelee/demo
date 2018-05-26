package com.jpa.demo.config;

import com.jpa.demo.utils.AESUtil;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;


@Configuration
@Order(300)
public class DataSourceConfig {


    @Bean(name="datasource")
    public DataSource datasource(Environment env) {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(env.getProperty("spring.datasource.url"));
        ds.setUsername(env.getProperty("spring.datasource.username"));
        String property = env.getProperty("spring.datasource.password");
        ds.setPassword(AESUtil.decrypt(property,null));
        //ds.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        return ds;
    }




}
