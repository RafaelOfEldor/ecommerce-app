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
//			ItemRepository itemRepository
//	) {
//		Faker faker = new Faker();
//		Random random = new Random();
//		return args -> {
//			try {
//				for (int i = 0; i < 10; i++) {
//					Item item = new Item(
//							faker.commerce().productName(),
//							"../images/random-jacket.jpg",
//							true,
//							random.nextDouble(18, 40),
//							"Lorem ipsum dolor sit amet, et nusquam copiosae vivendum mea. Altera graecis tractatos his in, sit in dicant adipisci disputationi. No nostrud placerat voluptaria duo, facilisis constituto at nam, viris saepe ex vim. Est dolor solet ea, qui recteque gubergren voluptaria id, has at nominavi oportere. Ad vero tincidunt mei. Has summo atomorum ut,et minim blandit copiosae pro, pro in quod quidam fabellas.Mea ad tation audire. Modo persius at sea. Zril facilisis prodesset ut usu, clita prodesset persecuti his eu. Praesent rationibus scripserit id quo, altera elaboraret eloquentiam mei in. An sed augue aeque appetere, nec sumo incorrupte eu.",
//							50,
//							"Apparel"
//							);
//				}
//			} catch(Exception e) {
//				e.printStackTrace();
//			}
//		};
//	}
}
