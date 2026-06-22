package com.kvl.service;

import com.kvl.dto.SalonDTO;
import com.kvl.model.Category;
import org.hibernate.validator.internal.constraintvalidators.bv.size.SizeValidatorForArraysOfLong;

import java.util.List;
import java.util.Set;


public interface CategoryService {

    Category saveCategory(Category category, SalonDTO salonDTO);
    Set<Category> getAllCategoriesBySalon(Long id);
    Category getCategoryById(Long id) throws Exception;
    void deleteCategoryById(Long id,Long salonId) throws Exception;

    Category findByIdAnsSalonId(Long id, Long salonId) throws Exception;



}
