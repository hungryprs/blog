package com.blog.demo.controller;

import com.blog.demo.dto.CategoryDTO;
import com.blog.demo.dto.CategoryRequest;
import com.blog.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping
    public CategoryDTO createCategory(@RequestBody CategoryRequest request) {
        return categoryService.createCategory(request);
    }
}
