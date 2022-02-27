package org.tain.config.jndi;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.tain.utils.CurrentInfo;

import lombok.extern.slf4j.Slf4j;

@Configuration
@MapperScan(basePackages = {"org.tain.jndi1.**.repository"})
@MapperScan(basePackages = {"org.tain.jndi1.**.mappers"})
@EntityScan(basePackages = {"org.tain.jndi1.**"})
@ComponentScan(basePackages = {"org.tain.jndi1.**"})
//@ComponentScan(basePackageClasses = {TblCustLoader.class})
@EnableTransactionManagement
@Slf4j
public class Jndi1RootContext {

	// set DataSource
	@Bean(name = "jndi1DataSource")
	public DataSource dataSource() {
		log.info("KANG-20220225 >>>>> {} {}", CurrentInfo.get());
		JndiDataSourceLookup jndiDataSourceLookup = new JndiDataSourceLookup();
		return jndiDataSourceLookup.getDataSource("java:comp/env/jndi1");
	}
	
	// set sqlSessionFactory
	@Bean(name = "jndi1SqlSessionFactory")
	public SqlSessionFactoryBean sqlSessionFactory() throws IOException {
		log.info("KANG-20220225 >>>>> {} {}", CurrentInfo.get());
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource());
		bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis/_mybatis_config.xml"));
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/jndi1/mappers/**/*Mapper.xml"));
		
		return bean;
	}
	
	// set transaction
	@Bean(name = "jndi1TransactionManager")
	PlatformTransactionManager jndi1TransactionManager() {
		log.info("KANG-20220225 >>>>> {} {}", CurrentInfo.get());
		DataSourceTransactionManager manager = new DataSourceTransactionManager();
		manager.setDataSource(dataSource());
		return manager;
	}
}
