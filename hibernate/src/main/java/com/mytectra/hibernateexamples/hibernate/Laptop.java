package com.mytectra.hibernateexamples.hibernate;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Generated;

@Entity
public class Laptop {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "lname" )
	private String name;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	private MacAddress mac;
	
	public Laptop() {
		
	}
	
	public Laptop(String name) {
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public MacAddress getMac() {
		return mac;
	}

	public void setMac(MacAddress mac) {
		this.mac = mac;
	}
	
	
	
	
}
