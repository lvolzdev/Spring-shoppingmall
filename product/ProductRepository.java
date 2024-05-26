//package com.example.demo.product;
//
//import jakarta.persistence.EntityManager;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import javax.swing.text.html.parser.Entity;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Repository
//public class ProductRepository {
//    @Autowired
//    EntityManager entityManager;
//
//    public Product save(Product product) {
//        entityManager.persist(product);
//    }
//
//    public Product findById(int id) {
//        return entityManager.find(Product.class, id);
//    }
//
//    public Product findProduct(int id) {
//        String jpql = "SELECT p FROM Product p WHERE p.id = :id";
//
//        Product foundProduct = entityManager.createQuery(jpql, Product.class)
//                                            .setParameter("id", id)
//                                            .getSingleResult();
//
//        if (foundProduct == null)
//            return null;
//        else
//            return foundProduct;
//    }
//
//    public List<Product> findProducts(int limit, int currentPage) {
//        return productTable.values().stream().toList();
//    }
//
//    public List<Product> findProducts(int limit, int currentPage, int categoryId) {
//        List<Product> resultProducts = new ArrayList<>();
//
//        for (Product product : productTable.values()) {
//            if (product.getCategoryId() == categoryId)
//                resultProducts.add(product);
//        }
//
//        return resultProducts;
//    }
//
//    public void deleteProduct(int id) {
//        productTable.remove(id);
//    }
//
//    public void deleteProducts(List<Integer> productIds) {
//        for (int idx = 0; idx < productIds.size(); idx++) {
//            productTable.remove(productIds.get(idx));
//        }
//    }
//}