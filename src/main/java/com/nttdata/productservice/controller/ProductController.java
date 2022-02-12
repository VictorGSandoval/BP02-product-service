package com.nttdata.productservice.controller;


import com.nttdata.productservice.model.Product;
import com.nttdata.productservice.service.IProductService;
import com.nttdata.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final IProductService service;

    @GetMapping
    public Flux<Product> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Product> getOne(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    public Mono<Product> create(@RequestBody Product product) {
        return service.create(product);
    }

    @PutMapping("/{id}")
    public Mono<Product> update(@PathVariable String id, @RequestBody Product product) {
        return service.update(id, product);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return service.delete(id);
    }
}
