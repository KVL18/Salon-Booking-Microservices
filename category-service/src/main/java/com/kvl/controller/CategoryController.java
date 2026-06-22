package com.kvl.controller;


import com.kvl.model.Category;
import com.kvl.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;


    @GetMapping("/salon/{id}")
    public ResponseEntity<Set<Category>>getCategoriesBySalon(
            @PathVariable Long id
    ){
        Set<Category> categories = categoryService.getAllCategoriesBySalon(id);
        return ResponseEntity.ok(categories);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Category>getCategoryById(
            @PathVariable Long id
    ) throws Exception {
        Category category = categoryService.getCategoryById(id);
        return ResponseEntity.ok(category);

    }


}
