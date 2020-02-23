package com.mytectra.hibernateexamples.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Item {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="tname")
	private String name;
	
	public Item() {
		// TODO Auto-generated constructor stub
	}

	public Item(String name) {
		this.name=name;
	}
}
