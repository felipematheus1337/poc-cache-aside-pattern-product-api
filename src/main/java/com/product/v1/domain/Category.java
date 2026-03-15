package com.product.v1.domain;

import com.product.v1.domain.enums.CategoryType;

public class Category {

    private Long id;

    private String name;

    private boolean isFeatured;

    private CategoryType type;

    public Category() {
    }

    public Category(Long id, String name, boolean isFeatured, CategoryType type) {
        this.id = id;
        this.name = name;
        this.isFeatured = isFeatured;
        this.type = type;
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

    public boolean isFeatured() {
        return isFeatured;
    }

    public void setFeatured(boolean featured) {
        isFeatured = featured;
    }

    public CategoryType getType() {
        return type;
    }

    public void setType(CategoryType type) {
        this.type = type;
    }

    public boolean isCategoryValid() {
        if (getType() == null) return false;

        if (getName() == null || getName().isBlank()) return false;

        return true;
    }

}
