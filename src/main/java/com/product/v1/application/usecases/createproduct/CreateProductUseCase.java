package com.product.v1.application.usecases.createproduct;

import com.product.v1.application.gateways.CreateProductUseCaseGateway;
import com.product.v1.domain.Product;

public class CreateProductUseCase {

    private final CreateProductUseCaseGateway createUseCaseGateway;

    public CreateProductUseCase(CreateProductUseCaseGateway createUseCaseGateway) {
        this.createUseCaseGateway = createUseCaseGateway;
    }

    public Product execute(Product product) {
        return createUseCaseGateway.execute(product);
    }
}
