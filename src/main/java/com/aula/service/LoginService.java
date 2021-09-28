package com.aula.service;

import javax.faces.bean.ViewScoped;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.aula.model.Login;

@Service
@Component
@ViewScoped
public class LoginService {

	public boolean loginDoSistema(Login login) {

		return login.getLogin().equals("teste") && login.getSenha().equals("123");

	}
}
