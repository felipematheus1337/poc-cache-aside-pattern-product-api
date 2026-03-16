package com.product.v1.infra.mapper;

import com.product.v1.domain.Product;
import com.product.v1.infra.dtos.ProductRequest;
import com.product.v1.infra.dtos.ProductResponse;
import com.product.v1.infra.persistence.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfigGlobal.class)
public interface ProductMapper {

    ProductEntity toEntity(Product product);

    Product requestToDomain(ProductRequest request);

    ProductResponse toResponse(Product product);


}
