package com.nttdata.productservice.service;

import com.nttdata.productservice.model.Product;
import com.nttdata.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
    private final ProductRepository repository;

    @Override
    public Flux<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Product> findById(String id) {
        return  repository.findById(id);
    } 

    @Override
    public Mono<Product> create(Product product) {
        product.setName(product.getName().toUpperCase());
        product.setDate(LocalDate.now());
        return repository.save(product);
    }

    @Override
    public Mono<Product> update(String id, Product product) {
        return repository.findById(id).flatMap(newProduct -> {
            product.setId(newProduct.getId());
            product.setName(product.getName().toUpperCase());
            product.setDate(newProduct.getDate());
            return repository.save(product);
        }).switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<Void> delete(String id) {
        return repository.findById(id).flatMap(product -> repository.deleteById(product.getId()));
    }
}
