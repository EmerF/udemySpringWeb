package com.aula;

import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aula.model.Login;
import com.aula.repository.LoginRepository;
import com.aula.service.LoginService;

@ManagedBean(name = "loginMB")
@Component
@ViewScoped
public class LoginMB {
	
	@Autowired
	private LoginService loginService;
	@Autowired
	LoginRepository loginRepository;
	private boolean sucessoLogin;
	
	private Login login;
	
	public void getTodosUsuarios() {
		List<Login> loginList = loginRepository.findAll();
		
		List<String> listaStream = loginList.stream().map(Login::getLogin).collect(Collectors.toList());
		listaStream.forEach(loginF ->
			System.out.println("Login for each " + loginF)
		);
		
		Long qtdLogin = loginList.stream().filter(loginFi -> loginFi.getLogin()
				.contains("Teste"))
				.count();
	}
	
	
	public void loginDoSistema() {
		
		sucessoLogin = loginService.loginDoSistema(getLogin());
		System.out.println("Logou no sistema: " + sucessoLogin);
	}
	
	
	
	public void salvarDadosLogin() {
		System.out.println("LoginIDMB: " + login.toString());	
		loginService.salvarDados(getLogin());
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
