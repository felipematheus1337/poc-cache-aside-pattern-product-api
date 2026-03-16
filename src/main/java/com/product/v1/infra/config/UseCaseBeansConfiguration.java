package com.product.v1.infra.config;

import com.product.v1.application.gateways.CreateProductUseCaseGateway;
import com.product.v1.application.gateways.GetProductsAndCategoriesFeaturedsGateway;
import com.product.v1.application.usecases.createproduct.CreateProductUseCase;
import com.product.v1.application.usecases.getproductsandcategories.GetProductsAndCategoriesFeaturedsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeansConfiguration {

    @Bean
    public CreateProductUseCase createProductUseCase(CreateProductUseCaseGateway createProductUseCaseGateway) {
        return new CreateProductUseCase(createProductUseCaseGateway);
    }

    @Bean
    public GetProductsAndCategoriesFeaturedsUseCase getProductsAndCategoriesFeaturedsUseCase(
            GetProductsAndCategoriesFeaturedsGateway gateway) {
        return new GetProductsAndCategoriesFeaturedsUseCase(gateway);
    }
}
