package com.mytectra.hibernateexamples.hibernate;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;

@Entity
@Table(name="Engineer")
//@NamedQuery(name = "eng1" , query = "select e.name , p.name from Engineer e inner join e.projects p where p.name in ('MTL','LGB')")
@NamedQuery(name = "findEnggByName" , query = "select e from Engineer e where e.name = :name")
public class Engineer {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "ename" )
	private String name;

	@ManyToMany(cascade=CascadeType.PERSIST)
	private List<Project> projects;
	
    public Engineer() {
	}	
	
	public Engineer(String name) {
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

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	

	
	
	
}
