package com.product.v1.application.usecases.getproductsandcategories;

import com.product.v1.application.gateways.GetProductsAndCategoriesFeaturedsGateway;

import java.util.List;

public class GetProductsAndCategoriesFeaturedsUseCase {

    private final GetProductsAndCategoriesFeaturedsGateway gateway;

    public GetProductsAndCategoriesFeaturedsUseCase(GetProductsAndCategoriesFeaturedsGateway gateway) {
        this.gateway = gateway;
    }

    public List<FindProductsAndCategoriesFeaturedOutput> execute () {
        return gateway.execute();
    }
}
