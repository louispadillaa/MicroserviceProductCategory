package com.Product.ProductMicroservice.ProductCore.Controller;

import com.Product.ProductMicroservice.ProductCore.Request.ProductRequest;
import com.Product.ProductMicroservice.ProductCore.Response.ProductResponse;
import com.Product.ProductMicroservice.ProductCore.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/products")
public class ProductController {

    private ProductService productService;

    @PostMapping
    public ResponseEntity<Integer> createProduct(@RequestBody ProductRequest request) {
        return ResponseEntity.ok(productService.createProduct(request));
    }

    // purchase

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(productService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll(){
        return ResponseEntity.ok(productService.findAll());
    }


}
