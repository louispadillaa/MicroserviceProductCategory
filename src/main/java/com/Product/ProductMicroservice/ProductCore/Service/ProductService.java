package com.Product.ProductMicroservice.ProductCore.Service;

import com.Product.ProductMicroservice.ProductCore.Entity.Product;
import com.Product.ProductMicroservice.ProductCore.Request.ProductProductRequest;
import com.Product.ProductMicroservice.ProductCore.Request.ProductRequest;
import com.Product.ProductMicroservice.ProductCore.Response.ProductPurchaseResponse;
import com.Product.ProductMicroservice.ProductCore.Response.ProductResponse;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    //CreateProduct
    Integer createProduct(ProductRequest request);

    //findById
    ProductResponse findById(Integer id);

    //FindAll
    List<ProductResponse> findAll();

    //purchaseProdcuts
    List<ProductPurchaseResponse> purchaseProducts(List<ProductProductRequest> request ) ;

}
