package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Validated
public class productController
{
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllUsers() {
        return productRepository.findAll();
    }

    @PostMapping
    public Product createProduct(@RequestBody @Valid Product product)
    {
        return productRepository.save(product);
    }


}
