package com.bhus.productservice.service.impl;

import com.bhus.productservice.dao.ProductDao;
import com.bhus.productservice.document.ProductDocument;
import com.bhus.productservice.model.ProductRequest;
import com.bhus.productservice.model.ProductResponse;
import com.bhus.productservice.service.ProductService;
import com.bhus.productservice.service.SequenceGeneratorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    MongoOperations mongoOperations;



    @Override
    public ProductResponse.Product save(ProductRequest request) {
        ProductDocument productDocument=objectMapper.convertValue(request,ProductDocument.class);
        productDocument.setId(sequenceGeneratorService.generateSequence(ProductDocument.SEQUENCE_NAME));
        productDao.save(productDocument);
        return objectMapper.convertValue(productDocument,ProductResponse.Product.class);
    }

    @Override
    public ProductResponse getProducts() {
        ProductResponse response=new ProductResponse();
        List<ProductDocument> productDocuments=productDao.findAll();
        if(!productDocuments.isEmpty()) {
            List<ProductResponse.Product> productList=new ArrayList<>();
            productDocuments.stream()
                    .parallel()
                    .forEach(productDocument -> {
                        productList.add(objectMapper.convertValue(productDocument,ProductResponse.Product.class));
                    });
            response.setProductList(productList);
        }
        return response;
    }
}
