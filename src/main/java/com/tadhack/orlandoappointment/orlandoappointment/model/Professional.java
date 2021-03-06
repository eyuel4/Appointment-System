package com.tadhack.orlandoappointment.orlandoappointment.model;// default package
// Generated Mar 10, 2018 3:27:23 PM by Hibernate Tools 5.2.8.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Professional generated by hbm2java
 */
@Entity
@Table(name = "professional", catalog = "orlandoappointmentdb")
public class Professional implements java.io.Serializable {

	private int idprofessional;
	private Company company;
	private String firstname;
	private String lastname;
	private String phoneNo;
	private String email;
	private Set<Appointments> appointmentses = new HashSet<Appointments>(0);
	private Set<AvailableTime> availableTimes = new HashSet<AvailableTime>(0);

	public Professional() {
	}

	public Professional(int idprofessional, Company company) {
		this.idprofessional = idprofessional;
		this.company = company;
	}

	public Professional(int idprofessional, Company company, String firstname, String lastname, String phoneNo,
			String email, Set<Appointments> appointmentses, Set<AvailableTime> availableTimes) {
		this.idprofessional = idprofessional;
		this.company = company;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phoneNo = phoneNo;
		this.email = email;
		this.appointmentses = appointmentses;
		this.availableTimes = availableTimes;
	}

	@Id

	@Column(name = "idprofessional", unique = true, nullable = false)
	public int getIdprofessional() {
		return this.idprofessional;
	}

	public void setIdprofessional(int idprofessional) {
		this.idprofessional = idprofessional;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_idcompany", nullable = false)
	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Column(name = "firstname", length = 45)
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "lastname", length = 45)
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "phone_no", length = 45)
	public String getPhoneNo() {
		return this.phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Column(name = "email", length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "professional")
	public Set<Appointments> getAppointmentses() {
		return this.appointmentses;
	}

	public void setAppointmentses(Set<Appointments> appointmentses) {
		this.appointmentses = appointmentses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "professional")
	public Set<AvailableTime> getAvailableTimes() {
		return this.availableTimes;
	}

	public void setAvailableTimes(Set<AvailableTime> availableTimes) {
		this.availableTimes = availableTimes;
	}

}
