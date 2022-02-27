package org.tain.config.jndi;

import javax.sql.DataSource;

import org.apache.ibatis.type.JdbcType;
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
@MapperScan(basePackages = {"org.tain.jpa.**.repository"})
//@MapperScan(basePackages = {"org.tain.jndi1.**.repository"})
@ComponentScan(basePackages = {"org.tain.jpa.**.service"})
@EnableTransactionManagement
public class JndiRootContext {

	// set DataSource
	@Bean
	public DataSource dataSource() {
		JndiDataSourceLookup jndiLookup = new JndiDataSourceLookup();
		return jndiLookup.getDataSource("java:comp/env/jndi1");
	}
	
	// set sqlSessionFactory
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
		final SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		
		bean.setDataSource(dataSource());
		bean.setConfigLocation(resolver.getResource("classpath:mybatis/_mybatis_config.xml"));
		bean.setMapperLocations(resolver.getResources("classpath:mybatis/mappers/**/*Mapper.xml"));
		bean.setTypeAliasesPackage("org.tain.mybatis.models");
		
		bean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
		bean.getObject().getConfiguration().setCacheEnabled(true);
		bean.getObject().getConfiguration().setCallSettersOnNulls(true);
		bean.getObject().getConfiguration().setJdbcTypeForNull(JdbcType.NULL);
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
