package com.Product.ProductMicroservice.Service;

import com.Product.ProductMicroservice.Exception.ProductPurchaseException;
import com.Product.ProductMicroservice.Mapper.ProductMapper;
import com.Product.ProductMicroservice.Request.ProductPurchaseRequest;
import com.Product.ProductMicroservice.Request.ProductRequest;
import com.Product.ProductMicroservice.Response.ProductPurchaseResponse;
import com.Product.ProductMicroservice.Repository.ProductRepository;
import com.Product.ProductMicroservice.Response.ProductResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public Long createProduct(ProductRequest request) {
        var product = productMapper.toProduct(request);
        return productRepository.save(product).getId();
    }

    @Override
    public ProductResponse findById(Long id) {
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

    //Transactional: Find the products, Validate Amounts, validate availability, save, mapper response

    @Transactional(rollbackFor = ProductPurchaseException.class)
    @Override
    public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request) {
        var productIds = request //Scroll through the list of Product Purchase objects and get the id
                .stream()
                .map(ProductPurchaseRequest::productId)
                .toList();
        var storedProducts = productRepository.findAllByIdInOrderById(productIds); //Find producs by DB
        if(productIds.size() != storedProducts.size()){ //Validate amount of products
            throw new ProductPurchaseException("One or more products does not exits");
        }
        var sortedRequest = request //sorted and comparing the ProductIds
                .stream()
                .sorted(Comparator.comparing(ProductPurchaseRequest::productId))
                .toList();
        var purchasedProducts = new ArrayList<ProductPurchaseResponse>(); //Scroll through the list of purchased Products
        for (int i = 0; i < storedProducts.size(); i++){ //Validate the product availability
            var product = storedProducts.get(i);
            var productRequest = sortedRequest.get(i);
            if(product.getAvailableQuantity() < productRequest.quantity()){
                throw new ProductPurchaseException("Insufficient stock quantity for product with ID:: " + productRequest.productId());
            }
            var newAvailableQuantity = product.getAvailableQuantity() - productRequest.quantity(); //subtract the available quantity
            product.setAvailableQuantity(newAvailableQuantity); //Set the new available value
            productRepository.save(product);
            purchasedProducts.add(productMapper.toProductPurchaseResponse(product,productRequest.quantity())); //Answer as a ProductPurchaseResponse
        }
        return purchasedProducts;
    }
}
