package br.com.aula.reservamaquina.service;

import javax.faces.bean.ViewScoped;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.aula.model.Login;

@Service
@Component
@ViewScoped
public class LoginService {
	
	public String logarNoSistema(Login login) {
		if(login.getLogin().equals("teste") && login.getSenha().equals("123")){
			
			return "menuPrincipal";
		}
		return "";
	}

}
