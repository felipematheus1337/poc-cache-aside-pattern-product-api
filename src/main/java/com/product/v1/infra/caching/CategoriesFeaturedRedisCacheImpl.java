package com.product.v1.infra.caching;

import com.product.v1.application.usecases.getproductsandcategories.FindProductsAndCategoriesFeaturedOutput;
import com.product.v1.infra.persistence.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class CategoriesFeaturedRedisCacheImpl implements RedisServiceCache<List<FindProductsAndCategoriesFeaturedOutput>> {

    private final String CATEGORIES_FEATURED_CACHE_KEY = "featured_categories";
    private final Duration CATEGORIES_FEATURED_TTL = Duration.ofMinutes(10);
    private final RedisTemplate<String, List<FindProductsAndCategoriesFeaturedOutput>> redisTemplate;

    @Override
    public void save(List<FindProductsAndCategoriesFeaturedOutput> categoriesFeaturedOutput) {
       redisTemplate.opsForValue()
               .set(CATEGORIES_FEATURED_CACHE_KEY,
                       categoriesFeaturedOutput,
                       CATEGORIES_FEATURED_TTL);
    }

    @Override
    public void put() {

        redisTemplate.opsForValue().getAndDelete(CATEGORIES_FEATURED_CACHE_KEY);

    }

    @Override
    public List<FindProductsAndCategoriesFeaturedOutput> get() {

        var cachedResponse = redisTemplate.opsForValue().get(CATEGORIES_FEATURED_CACHE_KEY);

        if (cachedResponse == null) return Collections.emptyList();

        return cachedResponse;

    }
}
