package com.bhus.productservice.controller;

import com.bhus.productservice.model.ProductRequest;
import com.bhus.productservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("v1")
public class ProductController {
    @Autowired
    ProductService productService;


    @PostMapping("/product")
    public ResponseEntity<?> createProduct(@RequestBody ProductRequest request) {
        log.debug(">>> CreateProduct for Product name={}", request.getName());
        return new ResponseEntity<>(productService.save(request), HttpStatus.CREATED);
    }

    @GetMapping(path = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getProducts() {
        log.debug(">>>Get All Products");
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }
}
