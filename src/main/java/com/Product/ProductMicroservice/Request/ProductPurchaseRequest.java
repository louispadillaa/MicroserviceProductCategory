package com.Product.ProductMicroservice.Request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductPurchaseRequest(

        @NotNull(message = "product is mandatory")
        Long productId,

        @Positive(message = "Quantity is mandatory")
        double quantity
) {
}
