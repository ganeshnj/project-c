package com.uha.ensisa.webapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uha.ensisa.webapp.models.Vehicle;
import com.uha.ensisa.webapp.models.VehicleType;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
	 List<Vehicle> findByType(VehicleType type);
	 List<Vehicle> findByName(String name);
}
