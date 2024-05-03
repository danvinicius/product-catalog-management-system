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

import com.danvinicius.productcatalogmanagementsystem.domain.product.Product;
import com.danvinicius.productcatalogmanagementsystem.domain.product.ProductDTO;
import com.danvinicius.productcatalogmanagementsystem.services.ProductService;

@RestController
@RequestMapping(path = "/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody ProductDTO productData) {
        Product createdProduct = this.productService.insert(productData);
        return ResponseEntity.ok().body(createdProduct);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        List<Product> products = this.productService.getAll();
        return ResponseEntity.ok().body(products);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable String id, @RequestBody ProductDTO productDTO) {
        Product updatedProduct = this.productService.update(id, productDTO);
        return ResponseEntity.ok().body(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable String id ) {
        this.productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
