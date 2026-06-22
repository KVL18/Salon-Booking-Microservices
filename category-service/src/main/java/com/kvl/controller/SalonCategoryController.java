package com.kvl.controller;

import com.kvl.dto.SalonDTO;
import com.kvl.model.Category;
import com.kvl.service.CategoryService;
import com.kvl.service.client.SalonFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/categories/salon-owner")
public class SalonCategoryController {

    private final CategoryService categoryService;
    private  final SalonFeignClient salonFeignClient;


    @PostMapping
    public ResponseEntity<Category> createCategory(
            @RequestBody Category category,
            @RequestHeader("Authorization") String jwt
    ) throws Exception {
        SalonDTO salonDTO = salonFeignClient.getSalonByOwnerId(jwt).getBody();

        Category savedCategory = categoryService.saveCategory(category, salonDTO);
        return ResponseEntity.ok(savedCategory);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(
            @PathVariable Long id,
            @RequestHeader("Authorization") String jwt
    ) throws Exception {

        SalonDTO salonDTO = salonFeignClient.getSalonByOwnerId(jwt).getBody();

        categoryService.deleteCategoryById(id, salonDTO.getId());

        return ResponseEntity.ok("Category Deleted Successfully");
    }


    @GetMapping("/salon/{salonId}/category/{id}")
    public ResponseEntity<Category>getCategoriesByIdAndSalon(
            @PathVariable Long id,
            @PathVariable Long salonId
    ) throws Exception {
        Category categories = categoryService.findByIdAnsSalonId(id,salonId);
        return ResponseEntity.ok(categories);

    }


}