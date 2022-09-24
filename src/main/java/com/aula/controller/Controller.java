package com.aula.controller;

import com.aula.model.Login;
import com.aula.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class Controller {

    @Autowired
    private LoginService loginService;
    @DeleteMapping( value = "{id}")
    public void delete(@PathVariable Long id ){
        loginService.deleteLoginById(id);
    }

    @PostMapping()
    public Login salvar(@Valid Login login) {
        return loginService.salvarDados(login);
    }
}
