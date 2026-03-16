package com.product.v1.infra.gateways;

import com.product.v1.application.gateways.CreateProductUseCaseGateway;
import com.product.v1.domain.Product;
import com.product.v1.infra.mapper.ProductMapper;
import com.product.v1.infra.persistence.entity.ProductEntity;
import com.product.v1.infra.persistence.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Slf4j
public class CreateProductGatewayImpl implements CreateProductUseCaseGateway {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    @Override
    @Transactional
    public Product execute(Product product) {
        log.info("::: Saving the product...");
        ProductEntity entity = mapper.toEntity(product);
        repository.save(entity);
        product.setId(entity.getId());
        return product;
    }
}
