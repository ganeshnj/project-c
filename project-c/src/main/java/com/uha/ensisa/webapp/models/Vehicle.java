package com.uha.ensisa.webapp.models;

import javax.persistence.*;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	
	@Enumerated(EnumType.STRING)
	private VehicleType type;
	
	public Vehicle() {}
	
	public Vehicle(String name, VehicleType type) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.type = type;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public VehicleType getType() {
		return type;
	}

	public void setType(VehicleType type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Vehicle[id=%d, name='%s', type='%s']", id, name, type);
	}
}
