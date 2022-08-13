package com.aula.service;

import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.aula.model.Login;
import com.aula.repository.LoginRepository;

@Service
@Component
@ViewScoped
public class LoginService {
	
	@Autowired
	LoginRepository loginRepository;

	public boolean loginDoSistema(Login login) {

		return login.getLogin().equals("teste") && login.getSenha().equals("123");

	}
	public Login salvarDados(Login login) {
		System.out.println("Dados a salvar:");
		System.out.println("LoginID: " + login.toString());
		System.out.println("Login: " + login.getLogin());
		System.out.println("Senha: " + login.getSenha());
		return loginRepository.save(login);
		
	}

	public void deleteLoginById(Long id) {
		loginRepository.deleteById(id);
	}
}
