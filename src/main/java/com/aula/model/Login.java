package com.aula.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Login implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_login;
	private String login;
	
	public Login() {}
	
	public Login(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}

	private String senha;


	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public long getId_login() {
		return id_login;
	}

	public void setId_login(long id_login) {
		this.id_login = id_login;
	}

	public String loginSimples() {
		return "loginSimples";
		
	}
}
