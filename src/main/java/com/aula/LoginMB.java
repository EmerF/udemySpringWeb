package com.aula;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aula.model.Login;
import com.aula.service.LoginService;

@ManagedBean(name = "loginMB")
@Component
@ViewScoped
public class LoginMB {
	
	@Autowired
	private LoginService loginService;
	private boolean sucessoLogin;
	
	@Autowired
	private Login login;
	
	public void loginDoSistema() {
		
		sucessoLogin = loginService.loginDoSistema(getLogin());
		System.out.println("Logou no sistema: " + sucessoLogin);
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public boolean isSucessoLogin() {
		return sucessoLogin;
	}

	public void setSucessoLogin(boolean sucessoLogin) {
		this.sucessoLogin = sucessoLogin;
	}
	
	
	

}
