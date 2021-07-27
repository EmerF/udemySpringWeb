package com.aula;

import javax.faces.webapp.FacesServlet;

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
	 * @Bean public ServletRegistrationBean <FacesServlet> servletRegistrationBean()
	 * { FacesServlet servlet = new FacesServlet(); ServletRegistrationBean
	 * <FacesServlet> servletRegistrationBean = new
	 * ServletRegistrationBean<FacesServlet>(servlet,"*.jsf"); return
	 * servletRegistrationBean; }
	 */
	
	@Bean
	public ServletRegistrationBean <FacesServlet> servletRegistrationBean() {
	    //FacesServlet servlet = new FacesServlet();
	    //ServletRegistrationBean <FacesServlet> servletRegistrationBean = 	new ServletRegistrationBean<FacesServlet>(servlet,"*.jsf");
	    return new ServletRegistrationBean<FacesServlet>(new FacesServlet(),"*.jsf");
	}
	

}
