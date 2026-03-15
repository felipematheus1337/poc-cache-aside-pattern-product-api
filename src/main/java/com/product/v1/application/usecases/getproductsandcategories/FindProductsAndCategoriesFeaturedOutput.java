package com.product.v1.application.usecases.getproductsandcategories;

import java.math.BigDecimal;

public record FindProductsAndCategoriesFeaturedOutput(
        String productName, String sku,
        BigDecimal value, String categoryName,
        String categoryType
) {
}
