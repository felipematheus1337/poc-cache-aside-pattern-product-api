package com.product.v1.infra.dtos;

import java.math.BigDecimal;

public record ProductRequest(String name,
                             String sku,
                             Integer quantity,
                             BigDecimal value,
                             CategoryRequest category) {
}
