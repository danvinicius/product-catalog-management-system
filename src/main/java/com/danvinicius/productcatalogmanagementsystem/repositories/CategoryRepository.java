package com.danvinicius.productcatalogmanagementsystem.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.danvinicius.productcatalogmanagementsystem.domain.category.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
    
}
