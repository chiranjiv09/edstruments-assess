package com.chiranjiv.edstruments.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.chiranjiv.edstruments.entity.Product;
import com.chiranjiv.edstruments.services.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * REST controller for managing products.
 * Provides endpoints to create, read, update, and delete products.
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
    private ProductService productService;

	
    /**
     * Retrieve all products.
     *
     * @return a list of all products.
     */
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    
    /**
     * Retrieve a product by its ID.
     *
     * @param id the ID of the product to retrieve.
     * @return the product if found, wrapped in a ResponseEntity.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    
    /**
     * Create a new product.
     *
     * @param product the product to create.
     * @return the created product, wrapped in a ResponseEntity.
     */
    @PostMapping
    public ResponseEntity<Map<String, Object>> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        
        // Prepare the response body
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Product successfully added!");
        response.put("product", createdProduct);

        return ResponseEntity.ok(response);
    }


    
    /**
     * Update an existing product by its ID.
     *
     * @param id            the ID of the product to update.
     * @param productDetails the details to update the product with.
     * @return the updated product, wrapped in a ResponseEntity.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
    	
        Product createdProduct = productService.updateProduct(id, productDetails);
        
        // Prepare the response body
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Product successfully added!");
        response.put("product", createdProduct);

        return ResponseEntity.ok(response);
    }

    
    /**
     * Delete a product by its ID.
     *
     * @param id the ID of the product to delete.
     * @return a ResponseEntity with no content.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product Deleted successfully");
    }
}

