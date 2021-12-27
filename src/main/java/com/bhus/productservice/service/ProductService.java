package com.bhus.productservice.service;

import com.bhus.productservice.model.ProductRequest;
import com.bhus.productservice.model.ProductResponse;

public interface ProductService {
    ProductResponse.Product save(ProductRequest request);

    ProductResponse getProducts();
}
