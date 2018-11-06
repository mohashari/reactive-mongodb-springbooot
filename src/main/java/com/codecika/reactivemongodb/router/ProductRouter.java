package com.codecika.reactivemongodb.router;

import com.codecika.reactivemongodb.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class ProductRouter {


    @Bean
    public RouterFunction<ServerResponse> functions(ProductService productService) {
        return RouterFunctions.nest(RequestPredicates.path("/api"),
                RouterFunctions.route(RequestPredicates.POST("/product"), productService::creat)
                        .andRoute(RequestPredicates.GET("/product/{id}"), productService::getById)
                        .andRoute(RequestPredicates.GET("/product"), productService::getAll)
                        .andRoute(RequestPredicates.DELETE("/product/{id}"), productService::deleteById)
        );
    }
}
