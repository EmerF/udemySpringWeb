package com.aula;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;

import com.sun.faces.config.ConfigureListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.aula.model.Login;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ServletContextAware;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
public class SpringWebJpaApplication implements ServletContextAware {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebJpaApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean facesServletRegistration() {
		ServletRegistrationBean registration = new ServletRegistrationBean(
				new FacesServlet(), "*.jsf");
		registration.setLoadOnStartup(1);
		return registration;
	}

	@Bean
	public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
		return new ServletListenerRegistrationBean<ConfigureListener>(
				new ConfigureListener());
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
	}
}
