package projeto.consultor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ConsultorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsultorApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("123456"));
		System.out.println("STARTED");
	}


}
