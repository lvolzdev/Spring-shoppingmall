package com.example.demo.order;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Repository
public class OrderRepository {
    private Map<Integer, Order> order_table = new HashMap<>();

    int id = 0;

    public void save(Order order) {
        log.info("productName = {}", order.getProduct().getName());
        log.info("count = {}", order.getCount());

        order.setId(id++);
        order_table.put(order.getId(), order);
    }
}
