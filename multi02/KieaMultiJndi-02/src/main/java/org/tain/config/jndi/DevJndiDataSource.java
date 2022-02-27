package org.tain.config.jndi;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.tain.utils.CurrentInfo;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Profile("dev")
@Slf4j
public class DevJndiDataSource {

	@Bean
	public TomcatServletWebServerFactory tomcatFactory() {
		log.info("KANG-20220225 >>>>> {} {}", CurrentInfo.get());
		return new TomcatServletWebServerFactory() {
			@Override
			protected TomcatWebServer getTomcatWebServer(Tomcat tomcat) {
				tomcat.enableNaming();
				return super.getTomcatWebServer(tomcat);
			}
			
			@Override
			protected void postProcessContext(Context context) {
				// dev jndi1
				context.getNamingResources().addResource(getResource("jndi1", "org.h2.Driver", "jdbc:h2:tcp://localhost:9092/monsterdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE", "sa", ""));
				// dev jndi2
				//context.getNamingResources().addResource(getResource("jndi2", "org.h2.Driver", "jdbc:h2:tcp://localhost:9092/monsterdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE", "sa", ""));
			}
		};
		
	}
	
	public ContextResource getResource(String name, String driverClassName, String url, String username, String password) {
		ContextResource resource = new ContextResource();
		resource.setName(name);
		resource.setType("javax.sql.DataSource");
		resource.setAuth("Container");
		
		resource.setProperty("factory", "org.apache.commons.dbcp2.BasicDataSourceFactory");
		resource.setProperty("driverClassName", driverClassName);
		resource.setProperty("url", url);
		resource.setProperty("username", username);
		resource.setProperty("password", password);
		
		return resource;
	}
}
