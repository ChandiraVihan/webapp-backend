package com.loginproject.loginapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController; // --- IMPORT THIS ---

@RestController
@RequestMapping("/api/products")
// --- THIS IS THE LINE TO CHANGE ---
@CrossOrigin(
    origins = "http://localhost:3000", 
    methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE} // Explicitly allow DELETE
)
public class ProductController {

    @Autowired
    private ProductRepository productRepo;

    // GET all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    // POST a new product
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productRepo.save(product);
    }
    
    // DELETE a product
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        if (!productRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        productRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
