//package com.example.demo.order;
//
//import com.example.demo.product.Product;
//import com.example.demo.product.ProductService;
//import com.example.demo.utils.Validator;
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.weaver.ast.Or;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@AllArgsConstructor // 생성자 주입 방법
//public class OrderController {
//    OrderService orderService;
//    ProductService productService;
//
//    @PostMapping("/orders")
//    public void orderProduct(@RequestBody OrderDTO orderDto) {
//        Product orderedProduct = productService.findProduct(orderDto.getProductId()); // 주문상품
//
//        // TODO: Service로 옮길거야 <DTO -> Entity 변환. 생성자 방법.>
//        Order requestOrder = new Order(
//                orderedProduct, orderDto.getCount()
//        );
//
//        orderService.orderProduct(requestOrder);
//    }
//}
