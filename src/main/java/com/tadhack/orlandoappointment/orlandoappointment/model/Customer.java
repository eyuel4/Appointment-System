package com.tadhack.orlandoappointment.orlandoappointment.model;// default package
// Generated Mar 10, 2018 3:27:23 PM by Hibernate Tools 5.2.8.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Customer generated by hbm2java
 */
@Entity
@Table(name = "customer", catalog = "orlandoappointmentdb")
public class Customer implements java.io.Serializable {

	private int idcustomer;
	private String firstName;
	private String lastName;
	private String phoneNumber;

	public Customer() {
	}

	public Customer(int idcustomer) {
		this.idcustomer = idcustomer;
	}

	public Customer(int idcustomer, String firstName, String lastName, String phoneNumber) {
		this.idcustomer = idcustomer;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}

	@Id

	@Column(name = "idcustomer", unique = true, nullable = false)
	public int getIdcustomer() {
		return this.idcustomer;
	}

	public void setIdcustomer(int idcustomer) {
		this.idcustomer = idcustomer;
	}

	@Column(name = "first_name", length = 45)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", length = 45)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "phone_number", length = 50)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
