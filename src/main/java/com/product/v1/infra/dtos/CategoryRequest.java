package com.product.v1.infra.dtos;

public record CategoryRequest(String name, boolean isFeatured, String type) {
}
