package com.tadhack.orlandoappointment.orlandoappointment.repository;

import com.tadhack.orlandoappointment.orlandoappointment.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT c FROM Customer c WHERE c.phoneNumber = :phoneNumber")
    Customer findCustomerByPhone(@Param("phoneNumber") String phoneNumber );
}
