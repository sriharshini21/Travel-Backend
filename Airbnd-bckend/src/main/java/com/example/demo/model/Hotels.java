package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Hotels {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	private String name;
	private String location;
	private int price;
	public Hotels() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Hotels(int id, String name, String location, int price) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Hotels [id=" + id + ", name=" + name + ", location=" + location + ", price=" + price + "]";
	}
	
	
	

}
