package com.practice.model;

public class BuildingDTO {
	private String name, street, ward;
	private Integer numberOfBasement;
	private Double rentalPrice;
	
	
	public Double getRentalPrice() {
		return rentalPrice;
	}
	
	public void setRentalPrice(Double rentalPrice) {
		this.rentalPrice = rentalPrice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}
	public void setNumberOfBasement(Integer numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}
}
