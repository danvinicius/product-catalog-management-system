package com.danvinicius.productcatalogmanagementsystem.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.danvinicius.productcatalogmanagementsystem.domain.product.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    
}
