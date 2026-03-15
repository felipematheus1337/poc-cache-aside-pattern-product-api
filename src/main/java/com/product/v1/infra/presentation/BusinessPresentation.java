package com.product.v1.infra.presentation;

import com.product.v1.application.gateways.GetProductsAndCategoriesFeaturedsGateway;
import com.product.v1.application.usecases.createproduct.CreateProductUseCase;
import com.product.v1.application.usecases.getproductsandcategories.FindProductsAndCategoriesFeaturedOutput;
import com.product.v1.domain.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class BusinessPresentation {

    private final CreateProductUseCase createProductUseCase;
    private final GetProductsAndCategoriesFeaturedsGateway getProductsAndCategoriesFeaturedsGateway;


    public BusinessPresentation(CreateProductUseCase createProductUseCase, GetProductsAndCategoriesFeaturedsGateway getProductsAndCategoriesFeaturedsGateway) {
        this.createProductUseCase = createProductUseCase;
        this.getProductsAndCategoriesFeaturedsGateway = getProductsAndCategoriesFeaturedsGateway;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> create(@RequestBody Product product) {
        createProductUseCase.execute(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<FindProductsAndCategoriesFeaturedOutput> findFeatured() {
        return ResponseEntity.ok(getProductsAndCategoriesFeaturedsGateway.execute());
    }
}
