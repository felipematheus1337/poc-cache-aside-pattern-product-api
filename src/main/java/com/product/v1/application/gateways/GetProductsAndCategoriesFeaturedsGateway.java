package com.product.v1.application.gateways;

import com.product.v1.application.usecases.getproductsandcategories.FindProductsAndCategoriesFeaturedOutput;

import java.util.List;

public interface GetProductsAndCategoriesFeaturedsGateway {

    List<FindProductsAndCategoriesFeaturedOutput> execute();
}
