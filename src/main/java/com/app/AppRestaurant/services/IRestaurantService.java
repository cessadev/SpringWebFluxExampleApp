package com.app.AppRestaurant.services;

import com.app.AppRestaurant.entities.RestaurantEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IRestaurantService {
    Flux<RestaurantEntity> findAll();
    Mono<RestaurantEntity> findById(Long id);
    Mono<RestaurantEntity> save(RestaurantEntity restaurant);
    Mono<Void> delete(RestaurantEntity restaurant);
}
