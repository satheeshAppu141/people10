package com.people10.roombookingmanagement.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

/**
 * 
 * This class is responsible for persistence core module hibernate configurations (datasource, hibernate session
 * factory, template and transaction manager).
 *
 * @author: SatheeshB
 *
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.people10.roombookingmanagement.entity" })
public class HibernateConfig {

	/** Spring Environment instance to get the configurations */
	@Autowired
	private Environment environment;

	/**
	 * Method to get the people 10 datasource created
	 * 
	 * @return the DataSource object
	 */
	@Bean(name = "people10DataSource")
	public DataSource dataSource() {
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setJdbcUrl(environment.getRequiredProperty("spring.datasource.url"));
		dataSource.setUsername(environment.getRequiredProperty("spring.datasource.username"));
		dataSource.setPassword(environment.getRequiredProperty("spring.datasource.password"));

		return dataSource;

	}

	/**
	 * Method to get the hibernate session factory using datasource.
	 * 
	 * @param dataSource
	 *            DataSource object
	 * @return the LocalSessionFactoryBean object
	 */
	@Bean(name = "sessionFactory")
	@Autowired
	public LocalSessionFactoryBean sessionFactory(@Qualifier("people10DataSource") final DataSource dataSource) {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setPackagesToScan(new String[] { "com.people10.roombookingmanagement.entity" });
		sessionFactory.setAnnotatedPackages(new String[] { "com.people10.roombookingmanagement.entity" });
		sessionFactory.setHibernateProperties(hibernateProperties());

		return sessionFactory;
	}

	/**
	 * Method to get hibernate template using session factory.
	 * 
	 * @param sessionFactory
	 *            SessionFactory object
	 * @return the HibernateTemplate object
	 */
	@Bean(name = "hibernateTemplate")
	@Autowired
	public HibernateTemplate hibernateTemplate(@Qualifier("sessionFactory") final SessionFactory sessionFactory) {
		HibernateTemplate hibernateTemplate = new HibernateTemplate();
		hibernateTemplate.setSessionFactory(sessionFactory);

		return hibernateTemplate;

	}

	/**
	 * Method to get hibernate transaction manager using session factory.
	 * 
	 * @param sessionFactory
	 *            SessionFactory object
	 * @return the HibernateTransactionManager object
	 */
	@Bean(name = "transactionManager")
	@Autowired
	public HibernateTransactionManager transactionManager(
		@Qualifier("sessionFactory") final SessionFactory sessionFactory) {

		final HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);

		return txManager;
	}

	/**
	 * Method to get hibernate properties from configuration file.
	 * 
	 * @return the Properties object
	 */
	private Properties hibernateProperties() {
		final Properties properties = new Properties();
		properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
		return properties;
	}
}
