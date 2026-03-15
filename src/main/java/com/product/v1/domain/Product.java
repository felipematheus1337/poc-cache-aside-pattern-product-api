package com.product.v1.domain;

import com.product.v1.domain.enums.CategoryType;

import java.math.BigDecimal;

public class Product {

    private Long id;

    private String name;

    private String sku;

    private Integer quantity;

    private BigDecimal value;

    private Category Category;

    public Product() {
    }

    public Product(Long id, String name, String sku, Integer quantity, BigDecimal value, com.product.v1.domain.Category category) {
        this.id = id;
        this.name = name;
        this.sku = sku;
        this.quantity = quantity;
        this.value = value;
        Category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Category getCategory() {
        return Category;
    }

    public void setCategory(Category category) {
        Category = category;
    }

    public CategoryType getProductCategoryType() {
        if (getCategory() != null) return getCategory().getType();

        return null;
    }

    public boolean isProductValid() {
        if (getSku() == null || getSku().isBlank()) return false;

        if (getQuantity() == null || getQuantity() <= 0) return false;

        if (getValue() == null || getValue().compareTo(BigDecimal.ZERO) < 0) return false;

        if (getCategory() == null) return false;

        if (!getCategory().isCategoryValid()) return false;

        return true;
    }
}
