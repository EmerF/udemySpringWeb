package com.aula.controller;


import com.aula.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {

    @InjectMocks
    private Controller controller = new Controller();

    @Mock
    LoginService loginService;

    long userId = 0;

    @Test
    public void deveDeletarUmRegistro(){
        userId = 1;
        doNothing().when(loginService).deleteLoginById(userId);
        controller.delete(userId);
        verify(loginService, times(1)).deleteLoginById(userId);
    }

    @Test
    public void deveDisparaExceptionAoDeletarRegistroInvalido(){
        userId = 0;
        doThrow(new Exception()).when(loginService).deleteLoginById(userId);
        controller.delete(userId);
        verify(loginService, times(0)).deleteLoginById(userId);

    }

}
