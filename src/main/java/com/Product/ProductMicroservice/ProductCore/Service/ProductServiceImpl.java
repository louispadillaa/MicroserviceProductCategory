package com.Product.ProductMicroservice.ProductCore.Service;

import com.Product.ProductMicroservice.ProductCore.Mapper.ProductMapper;
import com.Product.ProductMicroservice.ProductCore.Request.ProductProductRequest;
import com.Product.ProductMicroservice.ProductCore.Request.ProductRequest;
import com.Product.ProductMicroservice.ProductCore.Response.ProductPurchaseResponse;
import com.Product.ProductMicroservice.ProductCore.Repository.ProductRepository;
import com.Product.ProductMicroservice.ProductCore.Response.ProductResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public Integer createProduct(ProductRequest request) {
        var product = productMapper.toProduct(request);
        return productRepository.save(product).getId();
    }

    @Override
    public ProductResponse findById(Integer id) {
        return productRepository.findById(id)
                //To each element apply this method
                .map(productMapper::toProductResponse)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with Id" + id));


    }

    @Override
    public List<ProductResponse> findAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toProductResponse)
                .collect(Collectors.toList());

    }

    @Override
    public List<ProductPurchaseResponse> purchaseProducts(List<ProductProductRequest> request) {
        return List.of();
    }
}
