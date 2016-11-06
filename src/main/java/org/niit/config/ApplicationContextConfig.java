package org.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.niit.model.BaseDomain;


import org.niit.model.Userdetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("org.niit.collaborativeplatform")
@EnableTransactionManagement

public class ApplicationContextConfig {
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName("org.h2.Driver");
	    dataSource.setUrl("jdbc:h2:tcp://localhost/~/7");
	    dataSource.setUsername("sa");
	    dataSource.setPassword("");
	 
	    return dataSource;
	}
	private Properties getHibernateProperties() {
	    Properties properties = new Properties();
	    properties.put("hibernate.show_sql", "true");
	    properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	   properties.put("hibernate.hbm2ddl.auto", "update");
	    return properties;
	}
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
	 
	    LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	    
	    sessionBuilder.addProperties(getHibernateProperties());
	 
	   
	 sessionBuilder.addAnnotatedClasses(Userdetails.class);
	 sessionBuilder.addAnnotatedClasses(BaseDomain.class);
	/* sessionBuilder.addAnnotatedClasses(Blog.class);
	 sessionBuilder.addAnnotatedClasses(Job.class);
	 sessionBuilder.addAnnotatedClasses(Friend.class);
	*/    return sessionBuilder.buildSessionFactory();
	}
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
	        SessionFactory sessionFactory) {
	    HibernateTransactionManager transactionManager = new HibernateTransactionManager(
	            sessionFactory);
	 
	    return transactionManager;
	}
	
	/* @Autowired
	   @Bean(name = "categoryDao")
	   public CategoryDAO getCategoryDao(SessionFactory sessionFactory) {
	   return new CategoryDAOImpl(sessionFactory);
	   }

	   @Autowired
	   @Bean(name = "supplierDao")
	   public SupplierDAO getSupplierDao(SessionFactory sessionFactory) {
	   return new SupplierDAOImpl(sessionFactory);
	   }
	   
	   @Autowired
	   @Bean(name = "productDao")
	   public ProductDAO getProductDao(SessionFactory sessionFactory) {
	   return new ProductDAOImpl(sessionFactory);
	   }

*/

}
