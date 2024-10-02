package doit.axiostest.domain.api.controller;

import doit.axiostest.domain.product.Product;
import java.util.ArrayList;
import java.util.List;

public record ProductResponse(
        Long id,
        String name,
        String content,
        int price
) {
    public static List<ProductResponse> from(List<Product> products) {
        return products.stream()
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getName(),
                        product.getContent(),
                        product.getPrice()
                )).toList();
    }
}
