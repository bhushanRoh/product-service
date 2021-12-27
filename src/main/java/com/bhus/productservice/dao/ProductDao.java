package com.bhus.productservice.dao;

import com.bhus.productservice.document.ProductDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends MongoRepository<ProductDocument,Long> {
}
