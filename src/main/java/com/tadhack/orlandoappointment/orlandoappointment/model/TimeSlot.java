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
 * TimeSlot generated by hbm2java
 */
@Entity
@Table(name = "time_slot", catalog = "orlandoappointmentdb")
public class TimeSlot implements java.io.Serializable {

	private int idtimeSlot;
	private String timeSlotcol;
	private Set<Appointments> appointmentses = new HashSet<Appointments>(0);

	public TimeSlot() {
	}

	public TimeSlot(int idtimeSlot) {
		this.idtimeSlot = idtimeSlot;
	}

	public TimeSlot(int idtimeSlot, String timeSlotcol, Set<Appointments> appointmentses) {
		this.idtimeSlot = idtimeSlot;
		this.timeSlotcol = timeSlotcol;
		this.appointmentses = appointmentses;
	}

	@Id

	@Column(name = "idtime_slot", unique = true, nullable = false)
	public int getIdtimeSlot() {
		return this.idtimeSlot;
	}

	public void setIdtimeSlot(int idtimeSlot) {
		this.idtimeSlot = idtimeSlot;
	}

	@Column(name = "time_slotcol", length = 45)
	public String getTimeSlotcol() {
		return this.timeSlotcol;
	}

	public void setTimeSlotcol(String timeSlotcol) {
		this.timeSlotcol = timeSlotcol;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "timeSlot")
	public Set<Appointments> getAppointmentses() {
		return this.appointmentses;
	}

	public void setAppointmentses(Set<Appointments> appointmentses) {
		this.appointmentses = appointmentses;
	}

}
