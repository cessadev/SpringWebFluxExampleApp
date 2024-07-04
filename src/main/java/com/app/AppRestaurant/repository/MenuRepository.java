package com.app.AppRestaurant.repository;

import com.app.AppRestaurant.entities.MenuEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface MenuRepository extends R2dbcRepository<MenuEntity, Long> {

    @Query("SELECT * FROM menu WHERE restaurant_id = :restaurantId")
    Flux<MenuEntity> findAllByRestaurantId(Long restaurantId);

    @Query("SELECT * FROM menu WHERE category = 'BREAKFAST'")
    Flux<MenuEntity> findAllByCategoryBreakfast();

    @Query("SELECT * FROM menu WHERE category = 'LUNCH'")
    Flux<MenuEntity> findAllByCategoryLunch();

    @Query("SELECT * FROM menu WHERE category = 'DINNER'")
    Flux<MenuEntity> findAllByCategoryDinner();
}
