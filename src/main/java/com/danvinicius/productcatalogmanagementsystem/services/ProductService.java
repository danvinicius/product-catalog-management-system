package com.danvinicius.productcatalogmanagementsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danvinicius.productcatalogmanagementsystem.domain.category.exceptions.CategoryNotFoundException;
import com.danvinicius.productcatalogmanagementsystem.domain.product.Product;
import com.danvinicius.productcatalogmanagementsystem.domain.product.ProductDTO;
import com.danvinicius.productcatalogmanagementsystem.domain.product.exceptions.ProductNotFoundException;
import com.danvinicius.productcatalogmanagementsystem.repositories.ProductRepository;
import com.danvinicius.productcatalogmanagementsystem.services.aws.AwsSnsService;
import com.danvinicius.productcatalogmanagementsystem.services.aws.MessageDTO;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AwsSnsService snsService;


    public Product insert (ProductDTO productData) {
        Product product = new Product(productData);
        this.categoryService.getById(productData.categoryId()).orElseThrow(CategoryNotFoundException::new);
        this.productRepository.save(product);
        this.snsService.publish(new MessageDTO(product.toString()));
        return product;
    }

    public List<Product> getAll() {
        return this.productRepository.findAll();
    }

    public Product update(String id, ProductDTO productData) {
        Product product = this.productRepository.findById(id).orElseThrow(ProductNotFoundException::new);

        if (productData.categoryId() != null) {
            this.categoryService.getById(productData.categoryId()).orElseThrow(CategoryNotFoundException::new);
            product.setCategoryId(productData.categoryId());
        }

        if (!productData.title().isEmpty()) {
            product.setTitle(productData.title());
        }
        if (!productData.description().isEmpty()) {
            product.setDescription(productData.description());
        }
        if (!(productData.price() == null)) {
            product.setPrice(productData.price());
        }
        this.productRepository.save(product);

        this.snsService.publish(new MessageDTO(product.toString()));
        return product;
    }

    public void delete(String id) {
        Product product = this.productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        this.productRepository.delete(product);
    }
}
