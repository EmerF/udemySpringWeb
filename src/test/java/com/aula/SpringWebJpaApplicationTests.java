package com.aula;

import com.aula.model.Login;
import com.aula.repository.LoginRepository;
import com.aula.service.LoginService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.mockito.Mockito.when;

@SpringBootTest
class SpringWebJpaApplicationTests {

	@InjectMocks
	LoginService loginService;

	@Mock
	LoginRepository loginRepository;


	@Test
	public void testCriarLogin(){
		Login login = new Login();
		login.setLogin("Teste");
		login.setSenha("1234");


		when(loginRepository.save(login)).thenReturn(login);

		Login returnedLogin = loginService.salvarDados(login);
		Assertions.assertEquals(returnedLogin.getLogin(), login.getLogin());
		Assertions.assertEquals(returnedLogin.getSenha(), login.getSenha());

	}

}
