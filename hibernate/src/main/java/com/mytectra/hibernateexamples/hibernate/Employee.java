package com.mytectra.hibernateexamples.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Generated;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "sname" )
	private String name;

	@ManyToOne(cascade = {CascadeType.PERSIST , CascadeType.MERGE} )
	private Depart dp;
	
    public Employee() {
	}	
	
	public Employee(String name) {
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

	public Depart getDp() {
		return dp;
	}

	public void setDp(Depart dp) {
		this.dp = dp;
	}
	
	
}
