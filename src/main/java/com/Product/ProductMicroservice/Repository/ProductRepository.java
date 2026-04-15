package com.Product.ProductMicroservice.Repository;

import com.Product.ProductMicroservice.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product>findAllByIdInOrderById(List<Long> productIds);
}
