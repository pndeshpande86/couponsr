package com.macdproduct.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.macdproduct.service.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long>{

	Product findByName(String name);

}
