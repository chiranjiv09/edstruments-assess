package com.chiranjiv.edstruments.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.chiranjiv.edstruments.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
