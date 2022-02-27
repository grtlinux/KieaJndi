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
@MapperScan(basePackages = {"org.tain.jndi2.**.repository"})
@MapperScan(basePackages = {"org.tain.jndi2.**.mappers"})
@EntityScan(basePackages = {"org.tain.jndi1.**"})
@ComponentScan(basePackages = {"org.tain.jndi2.**"})
//@ComponentScan(basePackageClasses = {TblProdLoader.class})
@EnableTransactionManagement
@Slf4j
public class Jndi2RootContext {

	// set DataSource
	@Bean(name = "jndi2DataSource")
	public DataSource dataSource() {
		log.info("KANG-20220225 >>>>> {} {}", CurrentInfo.get());
		JndiDataSourceLookup jndiDataSourceLookup = new JndiDataSourceLookup();
		return jndiDataSourceLookup.getDataSource("java:comp/env/jndi2");
	}
	
	// set sqlSessionFactory
	@Bean(name = "jndi2SqlSessionFactory")
	public SqlSessionFactoryBean sqlSessionFactory() throws IOException {
		log.info("KANG-20220225 >>>>> {} {}", CurrentInfo.get());
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource());
		bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis/_mybatis_config.xml"));
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/jndi2/mappers/**/*Mapper.xml"));
		
		return bean;
	}
	
	// set transaction
	@Bean(name = "jndi2TransactionManager")
	PlatformTransactionManager jndi2TransactionManager() {
		log.info("KANG-20220225 >>>>> {} {}", CurrentInfo.get());
		DataSourceTransactionManager manager = new DataSourceTransactionManager();
		manager.setDataSource(dataSource());
		return manager;
	}
}
