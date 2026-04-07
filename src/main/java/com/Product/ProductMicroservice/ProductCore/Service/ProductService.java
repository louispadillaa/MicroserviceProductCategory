package com.Product.ProductMicroservice.ProductCore.Service;

import com.Product.ProductMicroservice.ProductCore.Request.ProductProductRequest;
import com.Product.ProductMicroservice.ProductCore.Response.ProductPurchaseResponse;
import com.Product.ProductMicroservice.ProductCore.Response.ProductResponse;

import java.util.List;

public interface ProductService {

    //CreateProduct
    Integer createProduct();

    //findById
    ProductResponse findById(Integer id);

    //FindAll
    List<ProductResponse> findAll();

    //purchaseProdcuts
    List<ProductPurchaseResponse> purchaseProducts(List<ProductProductRequest> request ) ;

}
