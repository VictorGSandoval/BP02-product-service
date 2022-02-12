package com.nttdata.productservice.service;

import com.nttdata.productservice.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProductService {
    Flux<Product> findAll();

    Mono<Product> findById(String id);

    Mono<Product> create(Product product);

    Mono<Product> update(String id, Product product);

    Mono<Void> delete(String id);
}
