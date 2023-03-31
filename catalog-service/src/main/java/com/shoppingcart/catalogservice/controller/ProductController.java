package com.shoppingcart.catalogservice.controller;

import com.shoppingcart.catalogservice.model.Product;
import com.shoppingcart.catalogservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@Slf4j
public class ProductController {

    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public List<Product> listAllProducts(){
        log.info(">>>> In listAllProducts method of ProductController");
        return productService.findAllProducts();
    }

    @GetMapping("/code/{code}")
    public List<Product> getProductByCode(@PathVariable String code){
        log.info(">>>> In getProductByCode method of ProductController");
        return productService.findByProductCode(code);
    }

    @GetMapping("{Id}")
    public Optional<Product> getProductById(@PathVariable Long Id){
        log.info(">>>> In getProductById method of ProductController");
        return productService.findByProductId(Id);
    }

    @PostMapping("")
    public Product createProduct(@RequestBody Product product){
        log.info(">>>> In createProduct method of ProductController");
        return productService.createProduct(product);
    }

    @PostMapping("/all")
    public List<Product> createAllProduct(@RequestBody List<Product> productList){
        log.info(">>>> In createProduct method of ProductController");
        return productService.createAllProduct(productList);
    }

    @DeleteMapping("/all")
    public void deleteAllProduct(){
        log.info(">>>> In createProduct method of ProductController");
        productService.deleteAllProduct();
    }

}
