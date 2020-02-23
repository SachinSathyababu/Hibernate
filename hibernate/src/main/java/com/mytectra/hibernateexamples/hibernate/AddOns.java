package com.mytectra.hibernateexamples.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="addons")
@NamedQuery(name = "getAddOnsByName" , query = "FROM AddOns a where a.name = ?1")
public class AddOns extends Item{
	
	@Column(name="aname")
	private String addons_name;
	
	@Column(name="description")
	private String description;
	
	
	@Column(name="cost")
	private int cost;
	
	public AddOns() {		}
	
	
	public AddOns(String name, String description, int cost) {
		super(name);
		this.addons_name=name;
		this.description = description;
		this.cost = cost;
	}
	
	public String getAddons_name() {
		return addons_name;
	}


	public void setAddons_name(String addons_name) {
		this.addons_name = addons_name;
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
