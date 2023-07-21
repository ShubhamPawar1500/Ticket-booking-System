package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Ticket_Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	@NotBlank
	private String firstName;
	
	@Column
	@NotBlank
	private String lastName;
	
	@Column
	@NotBlank
	private String departFrom;
	
	@Column
	@NotBlank
	private String goingTo;
	
	@Column
	@NotBlank
	private String date;
	
	@Column
	private int payment;
	
	@Column
	@NotBlank
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartFrom() {
		return departFrom;
	}

	public void setDepartFrom(String departFrom) {
		this.departFrom = departFrom;
	}

	public String getGoingTo() {
		return goingTo;
	}

	public void setGoingTo(String goingTo) {
		this.goingTo = goingTo;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public Ticket_Booking(int id, @NotBlank String firstName, @NotBlank String lastName, @NotBlank String departFrom,
			@NotBlank String goingTo, @NotBlank String date, @NotBlank int payment, @NotBlank String type) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.departFrom = departFrom;
		this.goingTo = goingTo;
		this.date = date;
		this.payment = payment;
		this.type = type;
	}

	public Ticket_Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
