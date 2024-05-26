package com.example.demo.product;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.Optional;

public interface ProductJPARepository extends JpaRepository<Product, Integer> {
    Optional<Product> findById(int id);
    Page<Product> findAll(Pageable pageable);
}