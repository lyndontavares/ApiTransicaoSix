package py.com.datapar.transicao;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class ApiTransicaoFiveApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiTransicaoFiveApplication.class, args);
	}

	@PostConstruct
	public void init() {
	}

}
