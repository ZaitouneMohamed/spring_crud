package com.example.demo.controller;

import com.example.demo.Responses.JsonResponses;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@Validated
public class productController
{
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping
    public Product createProduct(@RequestBody @Valid Product product)
    {
        return productRepository.save(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product>getProductById(@PathVariable Long id)
    {
        Optional<Product> product = productRepository.findById(id);
        return product.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build() );
    }

    @PutMapping("/{id}")
    public ResponseEntity<JsonResponses> updateProduct(@PathVariable Long id, @RequestBody @Valid Product productDetail)
    {
        Optional<Product> existingProduct = productRepository.findById(id);

        if (existingProduct.isPresent()) {
            Product productToUpdate = existingProduct.get();
            productToUpdate.setName(productDetail.getName());
            productToUpdate.setCategorie(productDetail.getCategorie());
            productRepository.save(productToUpdate);
            JsonResponses response = new JsonResponses("Product update with success.", true);
            return ResponseEntity.status(200).body(response);
        }
        JsonResponses response = new JsonResponses("Product not found.", false);
        return ResponseEntity.status(404).body(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<JsonResponses>deleteProduct(@PathVariable Long id)
    {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent())
        {
            productRepository.deleteById(id);
            JsonResponses response = new JsonResponses("Product deleted successfully.", true);
            return ResponseEntity.status(200).body(response);
        }
        JsonResponses response = new JsonResponses("Product Not Found.", false);
        return ResponseEntity.status(404).body(response);
    }


}
