package com.tadhack.orlandoappointment.orlandoappointment.repository;

import com.tadhack.orlandoappointment.orlandoappointment.model.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppointmentsRepository extends JpaRepository<Appointments, Long> {
}
