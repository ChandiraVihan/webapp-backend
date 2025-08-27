package com.loginproject.loginapp;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.*; 
import java.util.List; 
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
public class ProductController {

@Autowired
private ProductRepository productRepo;

//create a product
@PostMapping
public ResponseEntity<Product> addProduct(@RequestBody Product product) {
    Product savedProduct = productRepo.save(product);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
}

//get all products
@GetMapping
public ResponseEntity<List<Product>> getAllProducts() {
    return ResponseEntity.ok(productRepo.findAll());
}

//get a single product
@GetMapping("/{id}")
public ResponseEntity<?> getProductById(@PathVariable Long id) {
    Optional<Product> product = productRepo.findById(id);
    return product.isPresent() ?
            ResponseEntity.ok(product.get()) :
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
}

//update a product
@PutMapping("/{id}")
public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
    Optional<Product> existingProduct = productRepo.findById(id);

    if (existingProduct.isPresent()) {
        Product product = existingProduct.get();
        product.setName(productDetails.getName());
        product.setCategory(productDetails.getCategory());
        product.setPrice(productDetails.getPrice());
        product.setQuantity(productDetails.getQuantity());
        product.setImagePath(productDetails.getImagePath());

        Product updatedProduct = productRepo.save(product);
        return ResponseEntity.ok(updatedProduct);
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
    }
}

//Delete a product
@DeleteMapping("/{id}")
public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
    if (productRepo.existsById(id)) {
        productRepo.deleteById(id);
        return ResponseEntity.ok("Product deleted successfully");
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
    }
}
}

