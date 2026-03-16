package com.product.v1.infra.caching;

import java.util.Collection;
import java.util.List;

public interface RedisServiceCache<T> {

    void save(T t);

    void put();

    T get();
}
