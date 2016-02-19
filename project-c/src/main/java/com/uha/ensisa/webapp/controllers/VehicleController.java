package com.uha.ensisa.webapp.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uha.ensisa.webapp.models.Vehicle;
import com.uha.ensisa.webapp.models.VehicleType;
import com.uha.ensisa.webapp.repository.VehicleRepository;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	@Autowired
	private VehicleRepository repository;

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Vehicle> findItems() {
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()) + "::find all");
		return repository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()) + "::created:" + vehicle.toString());
		
		return repository.save(vehicle);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Vehicle getVehicleById( @PathVariable Long id) {
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()) + "::find:" + id);
		return repository.findOne(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Vehicle updateVehicle(@RequestBody Vehicle updatedVehicle, @PathVariable Long id) {
		updatedVehicle.setId(id);
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()) + "::updated:" + updatedVehicle.toString());
		return repository.save(updatedVehicle);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteVehicle(@PathVariable Long id) {
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()) + "::deleted:" + id);
		repository.delete(id);
	}
	
	@RequestMapping(value = "/typeTotal/{type}", method = RequestMethod.GET)
	public int getTotalByType(@PathVariable VehicleType type) {
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()) + "::Get Type:" + type);
		return repository.findByType(type).size();
	}
	

}
