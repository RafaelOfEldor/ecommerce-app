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
public class FactoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(FactoryApplication.class, args);

		/*
				Some of the tests use hard-coded values based on the commandLineRunner bean, so know that if you change
				or remove the setup-bean, some of the tests will fail based off of mis-matched id's.
		*/
	}

	@Bean
	CommandLineRunner commandLineRunner(
			AddressRepository addressRepository,
			CustomerRepository customerRepository,
			MachineRepository machineRepository,
			OrderRepository orderRepository,
			PartRepository partRepository,
			SubassemlyRepository subassemlyRepository
	) {
		Faker faker = new Faker();
		List<String> machines = new ArrayList<>();
		List<String> parts = new ArrayList<>();
		machines.add("xbox");
		machines.add("playstation");
		machines.add("computer");
		machines.add("printer");
		machines.add("car");

		parts.add("data chip");
		parts.add("engine");
		parts.add("hdmi cable");
		parts.add("LED lights");
		parts.add("pure energy");
		Random random = new Random();

		return args -> {
			try {
				for (int i = 0; i < 50; i++) {
					int randomNumber = random.nextInt(0, 5);
					String customerName = faker.name().fullName();
					Customer customer = customerRepository.save(new Customer(customerName, faker.internet().emailAddress()));
					Address address = addressRepository.save(new Address(faker.address().streetName(), faker.address().streetAddressNumber()));
					customer.getAddresses().add(address);
					customerRepository.save(customer);
					Order order = orderRepository.save(new Order("Order for " + customerName));
					Item machine = machineRepository.save(new Item(machines.get(randomNumber), randomNumber + 1));
					Subassembly subassembly = subassemlyRepository.save(new Subassembly("graphics card"));
					Part partOne = partRepository.save(new Part(parts.get(randomNumber)));
					randomNumber = random.nextInt(0, 5);
					Part partTwo = partRepository.save(new Part(parts.get(randomNumber)));
					randomNumber = random.nextInt(0, 5);
					Part partThree = partRepository.save(new Part(parts.get(randomNumber)));
					randomNumber = random.nextInt(0, 5);
					Part partFour = partRepository.save(new Part(parts.get(randomNumber)));
					subassembly.getParts().add(partOne);
					subassembly.getParts().add(partTwo);
					subassembly.getParts().add(partThree);
					subassembly.getParts().add(partFour);
					machine.getSubassemblies().add(subassembly);
					order.setCustomer(customer);
					order.getMachines().add(machine);
					customer.getOrders().add(order);
					orderRepository.save(order);
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		};
	}
}
