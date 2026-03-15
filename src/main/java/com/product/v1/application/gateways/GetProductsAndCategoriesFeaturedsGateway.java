package com.product.v1.application.gateways;

import com.product.v1.application.usecases.getproductsandcategories.FindProductsAndCategoriesFeaturedOutput;

public interface GetProductsAndCategoriesFeaturedsGateway {

    FindProductsAndCategoriesFeaturedOutput execute();
}
