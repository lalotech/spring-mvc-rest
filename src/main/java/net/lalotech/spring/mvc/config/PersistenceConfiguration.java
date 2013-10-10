/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.lalotech.spring.mvc.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Eduardo
 */
@Configuration()
@EnableTransactionManagement
@Import(PropertiesConfiguration.class)
@ComponentScan({"net.lalotech.spring.mvc.rest.model"})
public class PersistenceConfiguration {
    @Value("${persistence.driver}")
    String driver;
    @Value("${persistence.url}")
    String url;
    @Value("${persistence.username}")
    String username;
    @Value("${persistence.password}")
    String password;
    @Value("${persistence.hibernate.scanPackage}")
    String scanPackage;
    @Value("${persistence.hibernate.hbm2ddl.auto}")
    String hbm2ddl;
    @Value("${persistence.hibernate.dialect}")
    String dialect;
            
    @Bean
    public DataSource dataSource(){
        
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);        
        return ds;
    }
    @Bean
   public AnnotationSessionFactoryBean sessionFactory() {
      AnnotationSessionFactoryBean sessionFactory = new AnnotationSessionFactoryBean();
      sessionFactory.setDataSource(dataSource());
      sessionFactory.setPackagesToScan(new String[] { scanPackage});
      sessionFactory.setHibernateProperties(hibernateProperties());
 
      return sessionFactory;
   }
   @Bean
   public HibernateTransactionManager transactionManager() {
      HibernateTransactionManager txManager = new HibernateTransactionManager();
      txManager.setSessionFactory(sessionFactory().getObject());
 
      return txManager;
   }
   
    Properties hibernateProperties() {
      return new Properties() {
         {
            setProperty("hibernate.hbm2ddl.auto", hbm2ddl);
            setProperty("hibernate.dialect", dialect);
         }
      };
   }
}
