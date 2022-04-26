/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.security.demo.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author Dell
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.spring.security.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig  {
    
    // set the variable to hold the properties
    @Autowired
    private Environment env;
    
    //set up a logger for diagnostics
    private Logger logger = Logger.getLogger(getClass().getName());
    
    @Bean
    public ViewResolver viewResolver(){
        
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        
        // set prefix 
        viewResolver.setPrefix("/WEB-INF/view/");
       
        //set suffix
        viewResolver.setSuffix(".jsp");
        
        // return the view Resovler
        return viewResolver;
    }
    
    @Bean
    public DataSource securityDataSource(){
        
        // create connection pool
        ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
        
        try {
            //set the jdbc driver class
            securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
        } catch (PropertyVetoException ex) {
            throw new RuntimeException(ex);
        }
        
        //log the connection props
        //just to make sure we are really reading data from properties file
        logger.info(">>> jdbc.url="+env.getProperty("jdbc.url"));
        logger.info(">>> jdbc.user="+env.getProperty("jdbc.user"));
        
        //set database connection props
        securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        securityDataSource.setJdbcUrl(env.getProperty("jdbc.user"));
        securityDataSource.setJdbcUrl(env.getProperty("jdbc.password"));
        
        //set connection pool props
        securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
        securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
        securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
        securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
        
        
        //return the value
        return securityDataSource;
    }
    
    // need a helper method
    // read enviroment property and convert to int
    
    private int getIntProperty(String propName){
    
        String propVal = env.getProperty(propName);
        
        // now convert to int
        int intPropVal = Integer.parseInt(propVal);
        
        return intPropVal;
    }
}
