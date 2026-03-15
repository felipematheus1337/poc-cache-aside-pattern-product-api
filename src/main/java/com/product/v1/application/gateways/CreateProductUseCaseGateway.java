package com.product.v1.application.gateways;

import com.product.v1.domain.Product;

public interface CreateProductUseCaseGateway {

    Product execute(Product product);

}
