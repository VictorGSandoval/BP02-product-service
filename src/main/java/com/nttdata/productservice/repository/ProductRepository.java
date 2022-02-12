package com.nttdata.productservice.repository;

import com.nttdata.productservice.model.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductRepository extends ReactiveCrudRepository<Product, String> {

}