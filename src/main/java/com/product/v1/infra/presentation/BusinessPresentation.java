package com.product.v1.infra.presentation;

import com.product.v1.application.gateways.GetProductsAndCategoriesFeaturedsGateway;
import com.product.v1.application.usecases.createproduct.CreateProductUseCase;
import com.product.v1.application.usecases.getproductsandcategories.FindProductsAndCategoriesFeaturedOutput;
import com.product.v1.domain.Product;
import com.product.v1.infra.dtos.ProductRequest;
import com.product.v1.infra.dtos.ProductResponse;
import com.product.v1.infra.mapper.ProductMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class BusinessPresentation {

    private final CreateProductUseCase createProductUseCase;
    private final GetProductsAndCategoriesFeaturedsGateway getProductsAndCategoriesFeaturedsGateway;
    private final ProductMapper mapper;


    public BusinessPresentation(CreateProductUseCase createProductUseCase, GetProductsAndCategoriesFeaturedsGateway getProductsAndCategoriesFeaturedsGateway, ProductMapper mapper) {
        this.createProductUseCase = createProductUseCase;
        this.getProductsAndCategoriesFeaturedsGateway = getProductsAndCategoriesFeaturedsGateway;
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProductResponse> create(@RequestBody ProductRequest request) {
        Product product = mapper.requestToDomain(request);
        var productSaved = createProductUseCase.execute(product);
        ProductResponse response = mapper.toResponse(productSaved);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<FindProductsAndCategoriesFeaturedOutput>> findFeatured() {
        return ResponseEntity.ok(getProductsAndCategoriesFeaturedsGateway.execute());
    }
}
