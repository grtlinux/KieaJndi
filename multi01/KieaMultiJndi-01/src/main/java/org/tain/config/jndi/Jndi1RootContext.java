package org.tain.config.jndi;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan(basePackages = {"org.tain.jndi1.**.repository"})
@ComponentScan(basePackages = {"org.tain.jndi1.**.service"})
@EnableTransactionManagement
public class Jndi1RootContext {

	// set DataSource
	@Bean
	public DataSource dataSource() {
		JndiDataSourceLookup jndiDataSourceLookup = new JndiDataSourceLookup();
		return jndiDataSourceLookup.getDataSource("java:comp/env/jndi1");
	}
	
	// set sqlSessionFactory
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() throws IOException {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource());
		bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml"));
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/jndi1/**/*Mapper.xml"));
		
		return bean;
	}
	
	// set transaction
	@Bean
	PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager manager = new DataSourceTransactionManager();
		manager.setDataSource(dataSource());
		return manager;
	}
}
