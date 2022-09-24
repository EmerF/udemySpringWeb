package com.aula;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ServletContextAware;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
public class SpringWebJpaApplication implements ServletContextAware {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebJpaApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean<FacesServlet> servletRegistration(){
		return new ServletRegistrationBean<>(new FacesServlet(), "*.jsf");
	}

	//@Bean
/*	ServletRegistrationBean<FacesServlet> jsfServletRegistration(ServletContext servletContext) {
		servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());

		ServletRegistrationBean<FacesServlet> srb = new ServletRegistrationBean<FacesServlet>();
		srb.setServlet(new FacesServlet());
		srb.setUrlMappings(Arrays.asList("*.xhtml"));
		srb.setUrlMappings(Arrays.asList("*.jsf"));
		srb.setLoadOnStartup(1);
		return srb;
	}*/

	/*@Bean
	public com.sun.faces.config.ConfigureListener mojarraConfigureListener() {
		return new com.sun.faces.config.ConfigureListener();
	}*/
		
	/*
	 * @Bean public Login loginMapper() { return new Login (); }
	 */
	public ServletRegistrationBean facesServletRegistration() {
		ServletRegistrationBean registration = new ServletRegistrationBean(
				new FacesServlet(), "*.jsf");
		registration.setLoadOnStartup(1);
		return registration;
	}

/*	@Bean
	public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
		return new ServletListenerRegistrationBean<ConfigureListener>(
				new ConfigureListener());
	}*/

	@Override
	public void setServletContext(ServletContext servletContext) {
		servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
	}
}
