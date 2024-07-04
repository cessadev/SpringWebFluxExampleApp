package com.app.AppRestaurant.services.impl;

import com.app.AppRestaurant.entities.RestaurantEntity;
import com.app.AppRestaurant.persistence.IRestaurantDAO;
import com.app.AppRestaurant.services.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RestaurantServiceImpl implements IRestaurantService {

    @Autowired
    private IRestaurantDAO restaurantDAO;

    @Override
    public Flux<RestaurantEntity> findAll() {
        return restaurantDAO.findAll();
    }

    @Override
    public Mono<RestaurantEntity> findById(Long id) {
        return restaurantDAO.findById(id);
    }

    @Override
    public Mono<RestaurantEntity> save(RestaurantEntity restaurant) {
        return restaurantDAO.save(restaurant);
    }

    @Override
    public Mono<Void> delete(RestaurantEntity restaurant) {
        return restaurantDAO.delete(restaurant);
    }
}
