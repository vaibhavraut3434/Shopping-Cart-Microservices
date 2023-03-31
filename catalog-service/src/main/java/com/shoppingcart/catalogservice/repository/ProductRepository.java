package com.shoppingcart.catalogservice.repository;


import com.shoppingcart.catalogservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    Optional<Product> findById(Long Id);

    @Override
    List<Product> findAll();

    List<Product> findByCode(String code);

    @Override
    <S extends Product> S save(S entity);
}
