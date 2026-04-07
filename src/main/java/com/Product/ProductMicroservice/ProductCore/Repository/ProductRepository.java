package com.Product.ProductMicroservice.ProductCore.Repository;

import com.Product.ProductMicroservice.ProductCore.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

}
