package com.app.AppRestaurant.persistence.impl;

import com.app.AppRestaurant.entities.RestaurantEntity;
import com.app.AppRestaurant.persistence.IRestaurantDAO;
import com.app.AppRestaurant.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class RestaurantDAOImpl implements IRestaurantDAO {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public Flux<RestaurantEntity> findAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public Mono<RestaurantEntity> findById(Long id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public Mono<RestaurantEntity> save(RestaurantEntity restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Mono<Void> delete(RestaurantEntity restaurant) {
        return restaurantRepository.delete(restaurant);
    }
}
