package com.example.demo.product;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    ProductJPARepository productJPARepository;

    public Product registerProduct(Product product) {
        System.out.println(
                "/products : service - " + product.getName());

        return productRepository.save(product);
    }

    public Product findProduct(int id) {
        return productRepository.findProduct(id);
    }

    public List<Product> findProducts(int limit, int currentPage) {
        return productRepository.findProducts(limit, currentPage);
    }

    public List<Product> findProducts(int limit, int currentPage, int categoryId) {
        return productRepository.findProducts(limit, currentPage, categoryId);
    }

//    public void deleteProduct(int id) {
//        productRepository.deleteProduct(id);
//    }
//
//    public void deleteProducts(List<Integer> productIds) {
//        productRepository.deleteProducts(productIds);
//    }
}
