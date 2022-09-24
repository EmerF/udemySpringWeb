package com.aula.controller;


import com.aula.model.Login;
import com.aula.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {

    @InjectMocks
    private Controller controller = new Controller();

    @Mock
    LoginService loginService;

    long userId = 0;

    @Test
    public void deveDeletarUmUserId() {
        userId = 1;
        doNothing().when(loginService).deleteLoginById(userId);
        controller.delete(userId);

        verify(loginService, times(1)).deleteLoginById(userId);
    }

    @Test
    public void deveCriarUmNovoLogin(){

        Login loginEntrada = Login.builder()
                .login("Teste")
                .senha("12345")
                .build();

        when(loginService.salvarDados(loginEntrada)).thenReturn(Login.builder()
                        .idLogin(1l)
                        .login("Teste")
                        .senha("12345")
                .build());

        Login loginRetorno = controller.salvar(loginEntrada);
        assertEquals(loginEntrada.getLogin(), 2);
        assertEquals(loginEntrada.getSenha(), loginRetorno.getSenha());
        assertNotNull(loginRetorno.getIdLogin());
    }

    @Test
    public void deveRetornarErroAoPassarDadosInvalidos(){
        Login loginEntrada = Login.builder()
                .login("Teste")
                .senha("1234")
                .build();

        when(loginService.salvarDados(loginEntrada)).thenThrow(new IllegalArgumentException("Login existente"));

        assertThrows("Erro ao criar usuário!", IllegalArgumentException.class,
                () -> controller.salvar(loginEntrada) );

    }

}
