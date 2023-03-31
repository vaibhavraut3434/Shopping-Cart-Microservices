package com.shoppingcart.catalogservice.service;


import com.shoppingcart.catalogservice.model.Product;
import com.shoppingcart.catalogservice.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAllProducts(){
        log.info(">>>> In findAllProducts method of ProductService");
        List<Product> productList = productRepository.findAll();
        return productList;
    }


    public List<Product> findByProductCode(String code) {
        log.info(">>>> In findAllProducts method of ProductService");
        return productRepository.findByCode(code);
    }

    public Optional<Product> findByProductId(Long id) {
        log.info(">>>> In findAllProducts method of ProductService");
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        log.info(">>>> In createProduct method of ProductService");
        return productRepository.save(product);
    }

    public List<Product> createAllProduct(List<Product> productList) {
        log.info(">>>> In createAllProduct method of ProductService");
        return productRepository.saveAll(productList);
    }

    public void deleteAllProduct() {
        log.info(">>>> In deleteAllProduct method of ProductService");
        productRepository.deleteAll();
    }
}
