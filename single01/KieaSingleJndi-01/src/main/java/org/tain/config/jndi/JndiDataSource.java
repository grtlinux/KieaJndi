package org.tain.config.jndi;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@Profile("dev")
public class JndiDataSource {

	@Bean
	public TomcatServletWebServerFactory tomcatFactory() {
		return new TomcatServletWebServerFactory() {
			@Override
			protected TomcatWebServer getTomcatWebServer(Tomcat tomcat) {
				tomcat.enableNaming();
				return super.getTomcatWebServer(tomcat);
			}
			
			@Override
			protected void postProcessContext(Context context) {
				// jndi info
				String jndiName = "jndi1";
				String driverClassName = "org.h2.Driver";
				String url = "jdbc:h2:tcp://localhost:9092/monsterdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE";
				String username = "sa";
				String password = "";
				context.getNamingResources().addResource(getResource(jndiName, driverClassName, url, username, password));
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
