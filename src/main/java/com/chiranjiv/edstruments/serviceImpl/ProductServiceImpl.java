package com.chiranjiv.edstruments.serviceImpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chiranjiv.edstruments.entity.Product;
import com.chiranjiv.edstruments.exceptionhandler.CustomExceptionHandler;
import com.chiranjiv.edstruments.exceptionhandler.ProductNotFoundException;
import com.chiranjiv.edstruments.exceptionhandler.ValidationException;
import com.chiranjiv.edstruments.repo.ProductRepo;
import com.chiranjiv.edstruments.services.ProductService;


/**
 * Service implementation for managing products.
 * Provides business logic for CRUD operations on Product entities.
 */
@Service
public class ProductServiceImpl implements ProductService {
	
	
    @Autowired
    private ProductRepo productRepository;


    /**
     * Retrieve all products from the database.
     *
     * @return a list of all Product entities.
     */
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

    /**
     * Retrieve a product by its ID.
     *
     * @param id the ID of the product to retrieve.
     * @return the Product entity if found.
     * @throws ProductNotFoundException if the product with the given ID does not exist.
     */
	public Product getProductById(Long id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id)
	            .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
	}

	
	
    /**
     * Create a new product in the database.
     *
     * @param product the Product entity to create.
     * @return the saved Product entity.
     */
	public Product createProduct(Product product) {
		// TODO Auto-generated method stub
		validateProduct(product);
		return productRepository.save(product);
	}

	
	
    /**
     * Update an existing product.
     *
     * @param id      the ID of the product to update.
     * @param product the updated Product details.
     * @return the updated Product entity.
     * @throws ProductNotFoundException if the product with the given ID does not exist.
     */
	public Product updateProduct(Long id, Product product) {
		// TODO Auto-generated method stub
		validateProduct(product);
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Product not found with id: " + id);
        }
        product.setId(id);
        return productRepository.save(product);
	}

	
	
    /**
     * Delete a product by its ID.
     *
     * @param id the ID of the product to delete.
     * @throws ProductNotFoundException if the product with the given ID does not exist.
     */
	public void deleteProduct(Long id) {
		// TODO Auto-generated method stub
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
	}
	
	
	
	
    public void validateProduct(Product product) {
    	// Check if the product is null or empty
        if (product == null) {
            throw new ValidationException("Product cannot be null");
        }
     // Check if the product name is null or empty
        if (product.getName() == null || product.getName().trim().isEmpty()) {
            throw new ValidationException("Product name cannot be null or empty");
        }
     // Check if the product price is null or less than or equal to zero
        if (product.getPrice() == null || product.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValidationException("Product price must be greater than zero");
        }
    }


}
