package com.mytectra.hibernateexamples.hibernate;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;

@Entity
@Table(name="Project")
public class Project {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "sname" )
	private String name;
	
	@ManyToMany(cascade=CascadeType.PERSIST, mappedBy="projects")
	private List<Engineer> engineers;

	public Project() {
		
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

	public List<Engineer> getEngineers() {
		return engineers;
	}

	public void setEngineers(List<Engineer> engineers) {
		this.engineers = engineers;
	}

	public Project(String name) {
		this.name = name;
	}
	
	
	
	
}
