package com.aula;

import java.util.Arrays;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringWebJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebJpaApplication.class, args);
	}
	
	/*
	 * @Bean ServletRegistrationBean<FacesServlet>
	 * servletRegistration(ServletContext servletContext){
	 * servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration",
	 * Boolean.TRUE.toString()); ServletRegistrationBean<FacesServlet> regBean = new
	 * ServletRegistrationBean<FacesServlet>(); regBean.setServlet(new
	 * FacesServlet()); regBean.setUrlMappings(Arrays.asList("*.jsf"));
	 * regBean.setLoadOnStartup(1); return regBean; }
	 */
	
	@Bean
	public ServletRegistrationBean <FacesServlet> servletRegistrationBean() {
	    FacesServlet servlet = new FacesServlet();
	    ServletRegistrationBean <FacesServlet> servletRegistrationBean = new ServletRegistrationBean<FacesServlet>(servlet,"*.jsf");
	    return servletRegistrationBean;
	}
	

}
