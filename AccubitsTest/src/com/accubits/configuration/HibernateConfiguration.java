package com.accubits.configuration;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.accubits.constant.HibernateConstant;


@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.accubits.configuration" })
public class HibernateConfiguration {
	@Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.accubits.model" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
     }
     
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(HibernateConstant.jdbcDriverClassName);
        dataSource.setUrl(HibernateConstant.jdbcUrl);
        dataSource.setUsername(HibernateConstant.jdbcUsername);
        dataSource.setPassword(HibernateConstant.jdbcPassword);
        return dataSource;
    }
     
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", HibernateConstant.hibernateDialect);
        properties.put("hibernate.show_sql", HibernateConstant.hibernateShowSql);
        properties.put("hibernate.format_sql", HibernateConstant.hibernateFormatSql);
        properties.put("hibernate.hbm2ddl.auto", HibernateConstant.hibernate_hbm2ddl_auto);
      
        return properties;        
    }
     
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
       HibernateTransactionManager txManager = new HibernateTransactionManager();
       txManager.setSessionFactory(s);
       return txManager;
    }

}
