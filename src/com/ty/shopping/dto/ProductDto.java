package com.ty.shopping.dto;

public class ProductDto {
	
	private int id;
	private String name;
	private String type;
	private String brand;
	private double cost;
	
	
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", type=" + type + ", brand=" + brand + ", cost=" + cost
				+ "]";
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
	
	
	

}
