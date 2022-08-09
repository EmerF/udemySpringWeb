package com.aula.controller;

import com.aula.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

    @Autowired
    private LoginService loginService;
    @DeleteMapping( value = "{id}")
    public void delete(@PathVariable Long id ){
        loginService.deleteLoginById(id);
    }
}
