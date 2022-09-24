package com.aula;

import com.aula.model.Login;
import com.aula.repository.LoginRepository;
import com.aula.service.LoginService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

@SpringBootTest
class SpringWebJpaApplicationTests {

	@InjectMocks
	LoginService loginService;

	@Mock
	LoginRepository loginRepository;


	@Test
	public void testCriarLogin(){
		Login login = Login.builder()
				.idLogin(1l)
				.login("Teste")
				.senha("1234")
				.build();

		when(loginRepository.save(login)).thenReturn(login);

		Login returnedLogin = loginService.salvarDados(login);
		Assertions.assertEquals(returnedLogin.getLogin(), 2);
		Assertions.assertEquals(returnedLogin.getSenha(), login.getSenha());

	}

}
