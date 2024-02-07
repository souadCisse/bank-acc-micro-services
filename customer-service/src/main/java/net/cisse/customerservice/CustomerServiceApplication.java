package net.cisse.customerservice;

import net.cisse.customerservice.config.GlobalConfig;
import net.cisse.customerservice.entites.Customer;
import net.cisse.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args -> {
			List<Customer> customers=List.of(
					Customer.builder()
							.firstname("sara")
							.lastname("Achouikh")
							.email("Achouikh@gmail.com")
							.build(),
					Customer.builder()
							.firstname("Zahra")
							.lastname("Zamoud")
							.email("Zamoud@gmail.com")
							.build()
			);
			customerRepository.saveAll(customers);
		};
	}

}
