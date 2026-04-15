package com.Product.ProductMicroservice.Service;

import com.Product.ProductMicroservice.Request.ProductPurchaseRequest;
import com.Product.ProductMicroservice.Request.ProductRequest;
import com.Product.ProductMicroservice.Response.ProductPurchaseResponse;
import com.Product.ProductMicroservice.Response.ProductResponse;

import java.util.List;

public interface ProductService {

    //CreateProduct
    Long createProduct(ProductRequest request);

    //findById
    ProductResponse findById(Long id);

    //FindAll
    List<ProductResponse> findAll();

    //purchaseProdcuts
    List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request ) ;

}
