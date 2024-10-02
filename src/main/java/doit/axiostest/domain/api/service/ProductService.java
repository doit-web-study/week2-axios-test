package doit.axiostest.domain.api.service;

import doit.axiostest.domain.api.controller.ProductCreateRequest;
import doit.axiostest.domain.api.controller.ProductResponse;
import doit.axiostest.domain.product.Product;
import doit.axiostest.domain.product.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductResponse> findAllProducts() {
        List<Product> products = productRepository.findAll();
        return ProductResponse.from(products);
    }

    public ProductResponse createProduct(ProductCreateRequest request) {
        Product newProduct = Product.create(
                request.name(),
                request.content(),
                request.price()
        );

        Product savedProduct = productRepository.save(newProduct);

        return new ProductResponse(
                savedProduct.getId(),
                savedProduct.getName(),
                savedProduct.getContent(),
                savedProduct.getPrice()
        );
    }
}
