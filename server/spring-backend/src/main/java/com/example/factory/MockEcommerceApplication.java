package com.example.factory;

import com.example.factory.model.*;
import com.example.factory.repository.*;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class MockEcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockEcommerceApplication.class, args);

	}

//	@Bean
//	CommandLineRunner commandLineRunner(
//			AddressRepository addressRepository,
//			CustomerRepository customerRepository,
//			ItemRepository itemRepository,
//			OrderRepository orderRepository,
//			UserRepository userRepository
//	) {
//		Faker faker = new Faker();
//		Random random = new Random();
//		return args -> {
//			try {
//				for (int i = 0; i < 10; i++) {
//					System.out.println(faker.commerce().productName());
//				}
//				String username = "TestUser";
//				String userPassword = "password123";
//				User user = userRepository.save(new User(username, userPassword));
//			} catch(Exception e) {
//				e.printStackTrace();
//			}
//		};
//	}
}
