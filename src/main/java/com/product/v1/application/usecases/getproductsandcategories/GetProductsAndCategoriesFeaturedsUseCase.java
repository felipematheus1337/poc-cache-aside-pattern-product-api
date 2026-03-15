package com.product.v1.application.usecases.getproductsandcategories;

import com.product.v1.application.gateways.GetProductsAndCategoriesFeaturedsGateway;

public class GetProductsAndCategoriesFeaturedsUseCase {

    private final GetProductsAndCategoriesFeaturedsGateway gateway;

    public GetProductsAndCategoriesFeaturedsUseCase(GetProductsAndCategoriesFeaturedsGateway gateway) {
        this.gateway = gateway;
    }

    public FindProductsAndCategoriesFeaturedOutput execute () {
        return gateway.execute();
    }
}
