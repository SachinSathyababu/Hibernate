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
public class MacAddress {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "sname" )
	private String name;
	
	@OneToOne(cascade=CascadeType.PERSIST , mappedBy="mac")
	private Laptop lap;
	
	public MacAddress() {
		
	}
	
	public MacAddress(String name) {
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

	public Laptop getLap() {
		return lap;
	}

	public void setLap(Laptop lap) {
		this.lap = lap;
	}
	
	
	
	
}
