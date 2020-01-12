package com.danielpm1982.REST_WS6.config;
import java.beans.PropertyVetoException;
//import java.io.IOException;
import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
public class MyApplicationContextConfig implements WebMvcConfigurer{
	@Autowired
	private Environment environment;
	@Bean
	public DataSource securityDataSource() {
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
		try {
			securityDataSource.setDriverClass(environment.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		securityDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
		securityDataSource.setUser(environment.getProperty("jdbc.user"));
		securityDataSource.setPassword(environment.getProperty("jdbc.password"));
		securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		return securityDataSource;
	}
	private int getIntProperty(String propertyString) {
		return Integer.parseInt(environment.getProperty(propertyString));
	}
	private Properties getHibernateProperties() {
		Properties props = new Properties();
		props.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
		props.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
		props.put("hibernate.temp.use_jdbc_metadata_defaults", environment.getProperty("hibernate.temp.use_jdbc_metadata_defaults"));
		props.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
		return props;				
	}
	@Bean
	public SessionFactory sessionFactory(){
		LocalSessionFactoryBuilder localSessionFactoryBuilder = new LocalSessionFactoryBuilder(securityDataSource()); 
		localSessionFactoryBuilder.scanPackages(environment.getProperty("hibernate.packagesToScan"));
		localSessionFactoryBuilder.addProperties(getHibernateProperties());
		return localSessionFactoryBuilder.buildSessionFactory();
	}
//	or:
//	@Bean
//	public SessionFactory sessionFactory(){
//		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
//		localSessionFactoryBean.setDataSource(securityDataSource());
//		localSessionFactoryBean.setPackagesToScan(environment.getProperty("hibernate.packagesToScan"));
//		localSessionFactoryBean.setHibernateProperties(getHibernateProperties());
//		try {
//			localSessionFactoryBean.afterPropertiesSet();
//			return localSessionFactoryBean.getObject();
//		} catch (IOException e) {
//			return null;
//		}
//	}
	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory());
		return txManager;
	}
}

/*
This class configures the creation of enterprise beans related to the Data Layer of the application,
which are the java DataSource and the Spring SessionFactory and HibernateTransactionManager... based
on properties file configuration... which later are injected and used at the Persistence Service beans
("service" package: UserService - auth - and ContactService - business). These, in turn, can be used 
anywhere else, including at the config classes ("config" package: MyWebSecurityConfigurerAdapter), at 
web Controllers ("controller" package), at the webService implementing class ("ws" package: 
ContactManagerWSImpl), at standalone Main classes, or anywhere at the application where Persistence
is needed.
*/
