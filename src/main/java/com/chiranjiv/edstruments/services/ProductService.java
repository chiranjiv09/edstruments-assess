package com.chiranjiv.edstruments.services;

import java.util.List;

import com.chiranjiv.edstruments.entity.Product;

public interface ProductService {

	List<Product> getAllProducts();

	Product getProductById(Long id);

	Product createProduct(Product product);

	Product updateProduct(Long id, Product productDetails);

	void deleteProduct(Long id);

}
