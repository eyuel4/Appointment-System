package com.tadhack.orlandoappointment.orlandoappointment.repository;

import com.tadhack.orlandoappointment.orlandoappointment.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
    @Query("SELECT c FROM Category  c WHERE c.categoryId = :categoryId")
    Category findCategoryById(@Param("categoryId") int categoryId);

    @Query("SELECT c FROM Category c WHERE c.name = :categoryName")
    Category findCategoryByName(@Param("categoryName") String categoryName);
}
