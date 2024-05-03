package com.danvinicius.productcatalogmanagementsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danvinicius.productcatalogmanagementsystem.domain.category.Category;
import com.danvinicius.productcatalogmanagementsystem.domain.category.CategoryDTO;
import com.danvinicius.productcatalogmanagementsystem.domain.category.exceptions.CategoryNotFoundException;
import com.danvinicius.productcatalogmanagementsystem.repositories.CategoryRepository;
import com.danvinicius.productcatalogmanagementsystem.services.aws.AwsSnsService;
import com.danvinicius.productcatalogmanagementsystem.services.aws.MessageDTO;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AwsSnsService snsService;

    public Category insert (CategoryDTO categoryData) {
        Category category = new Category(categoryData);
        this.categoryRepository.save(category);
        this.snsService.publish(new MessageDTO(category.toString()));
        return category;
    }

    public List<Category> getAll() {
        return this.categoryRepository.findAll();
    }

    public Optional<Category> getById(String id) {
        return this.categoryRepository.findById(id);
    }

    public Category update(String id, CategoryDTO categoryData) {
        Category category = this.categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new);
        if (!categoryData.title().isEmpty()) {
            category.setTitle(categoryData.title());
        }
        if (!categoryData.description().isEmpty()) {
            category.setDescription(categoryData.description());
        }
        this.categoryRepository.save(category);
        this.snsService.publish(new MessageDTO(category.toString()));
        return category;
    }

    public void delete(String id) {
        Category category = this.categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new);
        this.categoryRepository.delete(category);
    }
}
