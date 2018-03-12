package com.tadhack.orlandoappointment.orlandoappointment.repository;

import com.tadhack.orlandoappointment.orlandoappointment.model.Professional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProfessionalRepository extends JpaRepository<Professional, Long> {
}
