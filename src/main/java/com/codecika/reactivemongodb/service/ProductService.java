package com.codecika.reactivemongodb.service;

import com.codecika.reactivemongodb.domain.Product;
import com.codecika.reactivemongodb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;


    public Mono<ServerResponse> creat(ServerRequest product) {
        return ServerResponse.ok().body(productRepository.saveAll(product.bodyToFlux(Product.class)), Product.class);
    }

    public Mono<ServerResponse> getById(ServerRequest request) {
        return ServerResponse.ok().body(productRepository.findById(request.pathVariable("id")), Product.class);
    }

    public Mono<ServerResponse> getAll(ServerRequest request) {
        return ServerResponse.ok().body(productRepository.findAll(), Product.class);
    }

    public Mono<ServerResponse> deleteById(ServerRequest request) {
        return ServerResponse.ok().body(productRepository.deleteById(request.pathVariable("id")), Void.class);
    }
}
