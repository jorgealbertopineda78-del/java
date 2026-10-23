package com.gremio.hola_mundo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class HolaMundoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	void rootDisplaysGreeting() throws Exception {
		mockMvc.perform(get("/"))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("¡Hola Mundo desde Spring Boot!")))
				.andExpect(content().string(containsString("Gran Gremio de Aventureros")))
				.andExpect(content().string(containsString("Nivel del gremio: <strong>1</strong>")));
	}

	@Test
	void saludoDisplaysGreeting() throws Exception {
		mockMvc.perform(get("/saludo"))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("¡Hola Mundo desde Spring Boot!")));
	}

}
