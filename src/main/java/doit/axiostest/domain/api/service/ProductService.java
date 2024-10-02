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
                request.title(),
                request.content(),
                request.price()
        );

        Product savedProduct = productRepository.save(newProduct);

        return new ProductResponse(
                savedProduct.getId(),
                savedProduct.getTitle(),
                savedProduct.getContent(),
                savedProduct.getPrice()
        );
    }

    public ProductResponse findProductById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다. id=" + productId));

        return new ProductResponse(
                product.getId(),
                product.getTitle(),
                product.getContent(),
                product.getPrice()
        );
    }
}
