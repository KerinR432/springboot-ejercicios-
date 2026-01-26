package ConectarApiRest.D1_UD6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class D1Ud6Application {

	private static final Logger log = LoggerFactory.getLogger(D1Ud6Application.class);
	public static void main(String[] args) {
		SpringApplication.run(D1Ud6Application.class, args);
	}

	@Bean
	@Profile("!test")
	public ApplicationRunner run(RestClient.Builder Builder) {
		return args -> {
			Quote quote = RestClient
					.get
		}
	}

}
