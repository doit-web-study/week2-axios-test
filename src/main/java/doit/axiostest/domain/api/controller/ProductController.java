package doit.axiostest.domain.api.controller;

import doit.axiostest.domain.api.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public List<ProductResponse> getAllProducts(){
        return productService.findAllProducts();
    }

    @PostMapping("/products")
    public ProductResponse createNewProduct(@RequestBody ProductCreateRequest request) {
        return productService.createProduct(request);
    }

}
