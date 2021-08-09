package com.aula;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aula.model.Login;

import br.com.aula.reservamaquina.service.LoginService;

@ManagedBean(name = "loginMB")
@Component
@ViewScoped
public class LoginMB {

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private Login login;
	
	public String loginDoSistema() {
		return loginService.logarNoSistema(getLogin());
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

}
