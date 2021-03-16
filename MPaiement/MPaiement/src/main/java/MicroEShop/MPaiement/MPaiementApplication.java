package MicroEShop.MPaiement;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MPaiementApplication {



	public static void main(String[] args) {
		SpringApplication.run(MPaiementApplication.class, args);
	}

}
