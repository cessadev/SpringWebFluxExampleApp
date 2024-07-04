package com.app.AppRestaurant.services;

import com.app.AppRestaurant.entities.CustomerEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICustomerService {
    Mono<CustomerEntity> save(CustomerEntity customer);
    Mono<CustomerEntity> findById(Long id);
    Flux<CustomerEntity> findAll();
    Mono<Void> delete(CustomerEntity customer);
}
