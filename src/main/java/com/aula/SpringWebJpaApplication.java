package com.aula;

import javax.faces.webapp.FacesServlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.aula.model.Login;

@SpringBootApplication
public class SpringWebJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebJpaApplication.class, args);
	}
	
	@Bean
	public ServletRegistrationBean<FacesServlet> servletRegistration(){
		return new ServletRegistrationBean<FacesServlet>(new FacesServlet(), "*.jsf");
	}
	@Bean
    public Login loginMapper() {
        return new Login ();
    }
}
