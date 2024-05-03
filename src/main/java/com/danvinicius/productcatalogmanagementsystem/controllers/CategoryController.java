package com.danvinicius.productcatalogmanagementsystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danvinicius.productcatalogmanagementsystem.domain.category.Category;
import com.danvinicius.productcatalogmanagementsystem.domain.category.CategoryDTO;
import com.danvinicius.productcatalogmanagementsystem.services.CategoryService;

@RestController
@RequestMapping(path = "/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> insert(@RequestBody CategoryDTO categoryData) {
        Category createdCategory = this.categoryService.insert(categoryData);
        return ResponseEntity.ok().body(createdCategory);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        List<Category> categories = this.categoryService.getAll();
        return ResponseEntity.ok().body(categories);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable String id, @RequestBody CategoryDTO categoryDTO) {
        Category updatedCategory = this.categoryService.update(id, categoryDTO);
        return ResponseEntity.ok().body(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> delete(@PathVariable String id ) {
        this.categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
