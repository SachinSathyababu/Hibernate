package com.mytectra.hibernateexamples.hibernate;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="MyOrders")
public class Order {

	@Id
	@GeneratedValue
	private Integer id;
	
	public enum Size {LARGE, MEDIUM, SMALL};

	@Column(name="Size")
	@Enumerated(EnumType.STRING)
	private Size size;
	
	@Column(name="Order_Date")
	@Temporal(TemporalType.DATE)
	private Date orderDate;
	
	public Order(){}

	public Order(Size size, Date orderDate) {
		super();
		this.size = size;
		this.orderDate = orderDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	
}
