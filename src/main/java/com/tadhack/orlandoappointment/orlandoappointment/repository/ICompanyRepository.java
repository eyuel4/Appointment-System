package com.tadhack.orlandoappointment.orlandoappointment.repository;

import com.tadhack.orlandoappointment.orlandoappointment.model.Company;
import com.tadhack.orlandoappointment.orlandoappointment.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICompanyRepository extends JpaRepository<Company, Long> {

    @Query("SELECT c FROM Company c WHERE c.category = :categoryId")
    List<Company> findCompanyByCategories(@Param("categoryId") String categoryId);
}
