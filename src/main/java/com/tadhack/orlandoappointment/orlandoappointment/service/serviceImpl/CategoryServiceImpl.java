package com.tadhack.orlandoappointment.orlandoappointment.service.serviceImpl;

import com.tadhack.orlandoappointment.orlandoappointment.model.Category;
import com.tadhack.orlandoappointment.orlandoappointment.repository.ICategoryRepository;
import com.tadhack.orlandoappointment.orlandoappointment.service.ICategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService {
/*    private final Logger logger = LoggerFactory.getLogger(this.getClass());*/

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public Category getCategoryById(String categoryId) {
        try {
            String catIdTrim = categoryId.trim();
            int id = Integer.parseInt(catIdTrim);
            return categoryRepository.findCategoryById(id);
        } catch (Exception e) {
//            logger.error("Exception caught on getCategoryById " + e.getMessage());
            return null;
        }
    }

    @Override
    public Category getCategoryByName(String categoryName) {
        return categoryRepository.findCategoryByName(categoryName);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

}
