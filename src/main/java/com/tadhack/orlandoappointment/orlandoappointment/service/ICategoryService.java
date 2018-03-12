package com.tadhack.orlandoappointment.orlandoappointment.service;

import com.tadhack.orlandoappointment.orlandoappointment.model.Category;

import java.util.List;

public interface ICategoryService {

    Category getCategoryById(String categoryId);

    Category getCategoryByName(String categoryName);

    List<Category> getAllCategory();
}
