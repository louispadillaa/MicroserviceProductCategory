package com.Product.ProductMicroservice.ProductCore.Mapper;

import com.Product.ProductMicroservice.ProductCore.Entity.Category;
import com.Product.ProductMicroservice.ProductCore.Entity.Product;
import com.Product.ProductMicroservice.ProductCore.Request.ProductRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    //From ProductRequest To Product
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
}
