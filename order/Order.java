package com.example.demo.order;

import com.example.demo.product.Product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@RequiredArgsConstructor
public class Order {
    int id;
    Product product; // Domain = Object
    int count;

    public Order(Product orderedProduct, int count ){
        this.product = orderedProduct;
        this.count = count;
    }
}
