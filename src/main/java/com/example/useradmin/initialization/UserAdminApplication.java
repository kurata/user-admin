package com.example.useradmin.initialization;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.example.useradmin" })
@EntityScan("com.example.useradmin.entities")
@EnableJpaRepositories("com.example.useradmin.entities") 
public class UserAdminApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		new UserAdminApplication().configure(new SpringApplicationBuilder(UserAdminApplication.class)).run(args);
	}

}
