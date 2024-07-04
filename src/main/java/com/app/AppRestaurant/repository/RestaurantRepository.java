package com.app.AppRestaurant.repository;

import com.app.AppRestaurant.entities.RestaurantEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends R2dbcRepository<RestaurantEntity, Long> {
}
