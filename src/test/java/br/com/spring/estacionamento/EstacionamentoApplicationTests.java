package br.com.spring.estacionamento;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.function.Function;

import br.com.spring.estacionamento.EstacionamentoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EstacionamentoApplicationTests{

	@Autowired
	private WebApplicationContext context;

	@Test
	public void seEuEstacionarUmVeiculoNovo_EntaoARespostaSeraCreated() throws Exception {

		String placa = "AAA3536";

		final String body = "   {\n" +
				"        \"placa\": \"+ placa + \",\n" +
				"        \"modelo\": \"Punto\",\n" +
				"        \"nomeMarcaCarro\": \"FIAT\"\n" +
				"    }";

		MockMvcBuilders
				.webAppContextSetup(this.context)
				.build()
				.perform(request(HttpMethod.POST, "/clientes").contentType(MediaType.APPLICATION_JSON).content(body))
				.andExpect(status().isCreated());
	}

	@Test
	public void seEuEstacionarUmVeiculoNovo_EntaoARespostaSeraErro() throws Exception {

		String placa = null;

		final String body = "   {\n" +
				"        \"placa\": \"\",\n" +
				"        \"modelo\": \"Punto\",\n" +
				"        \"nomeMarcaCarro\": \"FIAT\"\n" +
				"    }";

		MockMvcBuilders
				.webAppContextSetup(this.context)
				.build()
				.perform(request(HttpMethod.POST, "/clientes").contentType(MediaType.APPLICATION_JSON).content(body))
				.andExpect(status().isBadRequest());
	}


}