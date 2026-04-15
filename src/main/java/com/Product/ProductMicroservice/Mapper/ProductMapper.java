package com.Product.ProductMicroservice.Mapper;

import com.Product.ProductMicroservice.Entity.Category;
import com.Product.ProductMicroservice.Entity.Product;
import com.Product.ProductMicroservice.Request.ProductRequest;
import com.Product.ProductMicroservice.Response.ProductPurchaseResponse;
import com.Product.ProductMicroservice.Response.ProductResponse;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    //From ProductRequest To Product
    //Create a Product
    public Product toProduct(ProductRequest request){
        return Product.builder()
                .id(request.id())
                .name(request.name())
                .description(request.description())
                .availableQuantity(request.availableQuantity())
                .price(request.price())
                .category(
                        Category.builder()
                                .id(request.categoryId())
                                .build()
                )

                .build();
    }

    //From Product To ProductResponse
    //Get a Product as a Response
    public ProductResponse toProductResponse(Product product){
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getAvailableQuantity(),
                product.getPrice(),
                product.getCategory().getId(),
                product.getCategory().getCategoryName(),
                product.getCategory().getCategoryDescription()
        );
    }

    //From Product to ProductPurchaseResponse
    //Get a Purchase Product as a Resposne
    public ProductPurchaseResponse toProductPurchaseResponse(Product product, double quantity){
        return new ProductPurchaseResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                quantity
        );
    }

}
