package com.Product.ProductMicroservice.ProductCore.Service;

import com.Product.ProductMicroservice.ProductCore.Request.ProductProductRequest;
import com.Product.ProductMicroservice.ProductCore.Response.ProductPurchaseResponse;
import com.Product.ProductMicroservice.ProductCore.Repository.ProductRepository;
import com.Product.ProductMicroservice.ProductCore.Response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Override
    public Integer createProduct() {
        return 0;
    }

    @Override
    public ProductResponse findById(Integer id) {
        return null;
    }

    @Override
    public List<ProductResponse> findAll() {
        return List.of();
    }

    @Override
    public List<ProductPurchaseResponse> purchaseProducts(List<ProductProductRequest> request) {
        return List.of();
    }
}
