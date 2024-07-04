package com.app.AppRestaurant.repository;

import com.app.AppRestaurant.entities.MealEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends R2dbcRepository<MealEntity, Long> {
}
