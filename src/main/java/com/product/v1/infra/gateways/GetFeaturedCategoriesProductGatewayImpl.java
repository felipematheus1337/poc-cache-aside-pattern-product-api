package com.product.v1.infra.gateways;

import com.product.v1.application.gateways.GetProductsAndCategoriesFeaturedsGateway;
import com.product.v1.application.usecases.getproductsandcategories.FindProductsAndCategoriesFeaturedOutput;
import com.product.v1.infra.caching.RedisServiceCache;
import com.product.v1.infra.persistence.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class GetFeaturedCategoriesProductGatewayImpl implements GetProductsAndCategoriesFeaturedsGateway {

    private final ProductRepository repository;
    private final RedisServiceCache<List<FindProductsAndCategoriesFeaturedOutput>> redisServiceCache;

    @Override
    public List<FindProductsAndCategoriesFeaturedOutput> execute() {
        List<FindProductsAndCategoriesFeaturedOutput> categoriesFeaturedOutputs = new ArrayList<>();
        log.info("::: Searching for the products with the categories featured.");
        categoriesFeaturedOutputs = redisServiceCache.get();

        if (categoriesFeaturedOutputs.isEmpty()) {
            categoriesFeaturedOutputs = repository.getFeaturedProductsAndCategories();
            redisServiceCache.save(categoriesFeaturedOutputs);
            return categoriesFeaturedOutputs;
        }
        return categoriesFeaturedOutputs;
    }
}
