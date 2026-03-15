package com.product.v1.infra.persistence.repository;

import com.product.v1.application.usecases.getproductsandcategories.FindProductsAndCategoriesFeaturedOutput;
import com.product.v1.infra.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query("""
    SELECT new com.product.v1.application.usecases.getproductsandcategories.FindProductsAndCategoriesFeaturedOutput(
        p.name,
        p.sku,
        p.value,
        c.name,
        c.type
    )
    FROM ProductEntity p
    JOIN p.category c
    WHERE c.isFeatured = true
""")
    List<FindProductsAndCategoriesFeaturedOutput> getFeaturedProductsAndCategories();
}
