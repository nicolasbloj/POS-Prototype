package com.nab.posprototype.component.config;

import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
@ComponentScan({"com.nab.posprototype.component"})
@PropertySource(value = {"classpath:data/application.properties"})
public class HibernateConfiguration {

  @Autowired
  private Environment environment;

  @Bean
  public LocalSessionFactoryBean sessionFactory() {
    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    sessionFactory.setDataSource(dataSource());
    sessionFactory.setPackagesToScan(new String[] {"com.nab.posprototype.model"});
    sessionFactory.setHibernateProperties(hibernateProperties());
    return sessionFactory;
  }

  @Bean
  public DataSource dataSource() {
    ComboPooledDataSource dataSource = new ComboPooledDataSource();

    try {
      // ?
      dataSource.setDriverClass(environment.getRequiredProperty("jdbc.driverClassName"));
      dataSource.setJdbcUrl(environment.getRequiredProperty("jdbc.url"));
      dataSource.setUser(environment.getRequiredProperty("jdbc.username"));
      dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
      dataSource.setAcquireIncrement(
          environment.getRequiredProperty("c3p0.acquire_increment", Integer.class));
      dataSource.setMinPoolSize(environment.getRequiredProperty("c3p0.min_size", Integer.class));
      dataSource.setMaxPoolSize(environment.getRequiredProperty("c3p0.max_size", Integer.class));
      dataSource
          .setMaxIdleTime(environment.getRequiredProperty("c3p0.max_idle_time", Integer.class));
      dataSource.setUnreturnedConnectionTimeout(
          environment.getRequiredProperty("c3p0.unreturned_connection_timeout", Integer.class));
      return dataSource;

    } catch (PropertyVetoException ex) {
      Logger.getLogger(HibernateConfiguration.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }

  private Properties hibernateProperties() {
    Properties properties = new Properties();
    properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
    properties.put("hibernate.show_sql", environment.getRequiredProperty("jpa.showSql"));
    properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
    properties.put("hibernate.hbm2ddl.auto",
        environment.getRequiredProperty("hibernate.hbm2ddl.auto"));//////
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
