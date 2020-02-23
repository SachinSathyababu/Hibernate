package com.mytectra.hibernateexamples.hibernate;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Generated;

@Entity
public class Depart {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "sname" )
	private String name;
	
	@OneToMany(cascade = {CascadeType.PERSIST , CascadeType.MERGE}, mappedBy = "dp")
	private List<Employee> employees;

	public Depart() {
		
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

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Depart(String name) {
		this.name = name;
	}
	
	
	
	
}
