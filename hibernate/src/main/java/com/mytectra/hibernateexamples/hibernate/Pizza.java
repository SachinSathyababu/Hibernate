package com.mytectra.hibernateexamples.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "pizza")
public class Pizza extends Item{
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="pname")
	private String pizza_name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="cost")
	private int cost;
	
	
	public Pizza() {}

	public Pizza(String name, String description, int cost) {
		super(name);
		
		this.pizza_name=name;
		this.description = description;
		this.cost = cost;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPizza_name() {
		return pizza_name;
	}

	public void setPizza_name(String pizza_name) {
		this.pizza_name = pizza_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	
}

