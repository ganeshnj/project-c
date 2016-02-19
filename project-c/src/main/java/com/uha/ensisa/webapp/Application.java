package com.uha.ensisa.webapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.uha.ensisa.webapp.models.Vehicle;
import com.uha.ensisa.webapp.models.VehicleType;
import com.uha.ensisa.webapp.repository.VehicleRepository;

@SpringBootApplication
public class Application {
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner demo(VehicleRepository repository) {
		return (args) -> {
			// save a couple of Vehicles
			repository.save(new Vehicle("Argon", VehicleType.BICYCLE));
			repository.save(new Vehicle("Harley Davidson", VehicleType.BIKE));
			repository.save(new Vehicle("Yamaha", VehicleType.BIKE));
			repository.save(new Vehicle("Ferrari", VehicleType.CAR));
			repository.save(new Vehicle("BMW", VehicleType.CAR));

			// fetch all Vehicles
			log.info("Vehicles found with findAll():");
			log.info("-------------------------------");
			for (Vehicle vehicle : repository.findAll()) {
				log.info(vehicle.toString());
			}
            log.info("");

			// fetch an individual Vehicle by ID
			Vehicle vehicle = repository.findOne(1L);
			log.info("Vehicle found with findOne(1L):");
			log.info("--------------------------------");
			log.info(vehicle.toString());
            log.info("");

			// fetch Vehicles by vehicle type
			log.info("Vehicle found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			for (Vehicle v : repository.findByType(VehicleType.BICYCLE)) {
				log.info(v.toString());
			}
            log.info("");
		};
	}
}
