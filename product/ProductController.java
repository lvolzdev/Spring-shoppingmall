package com.example.demo.product;

import com.example.demo.utils.ApiUtils;
import com.example.demo.utils.Validator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class ProductController {

    ProductService productService;
    @Autowired
    ProductController(ProductService productService) {
        this.productService = productService;
    }

    // 상품 개별 등록
    @PostMapping("/products")
    public ApiUtils.ApiResult<?> registerProduct(@RequestBody ProductDTO productDTO)
    {
        try {
            Product product = productDTO.convertToEntity();
            ProductDTO savedProduct = productService.save(product);
            log.info(savedProduct.getName());
            return ApiUtils.success(savedProduct);
        } catch (NullPointerException e){
            return ApiUtils.error("상품 등록 에러", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 상품 개별 조회
    @GetMapping("/products/{id}")
    public ApiUtils.ApiResult<?> findProduct(@PathVariable(value = "id") int id){
        Product product = productService.findProduct(id);
        return ApiUtils.success(product);
    }

    // 상품 전체 조회
    @GetMapping("/products")
    public ApiUtils.


//    // 상품 전체, 카테고리별 조회
//    @GetMapping("/products")
//    public ApiUtils.ApiResult<?> findProducts(
//            @RequestParam("limit") int limit,
//            @RequestParam("currentPage") int currentPage,
//            @RequestParam(value = "categoryId", required = false) Integer categoryId) {
//                List<Product> products;
//
//                if (categoryId == null) {
//                    products = productService.findProducts(limit, currentPage);
//                } else {
//                    products = productService.findProductsByCategory(limit, currentPage, categoryId);
//                }
//                return ApiUtils.success(products);
//    }

//    // 상품 개별 삭제
//    @DeleteMapping("/products/{id}")
//    public ResponseEntity deleteProduct(@PathVariable("id") int id) {
//        if(!Validator.isNumber(id))
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//
//        productService.deleteProduct(id);
//        Product product = productService.findProduct(id);
//
//        if (product == null)
//            return new ResponseEntity<>(HttpStatus.OK);
//        else
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    // 상품 여러 개 삭제
//    @PostMapping("/products/delete")
//    public ResponseEntity deleteProducts(@RequestBody Map<String, List<Integer>> deleteRequest) {
//        List<Integer> productIds = deleteRequest.get("productIds");
//
//        if (productIds.isEmpty()) {
//            log.info("productIds가 없음!");
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//
//        productService.deleteProducts(productIds);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}