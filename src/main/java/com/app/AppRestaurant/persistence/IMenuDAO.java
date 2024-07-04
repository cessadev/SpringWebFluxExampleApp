package com.app.AppRestaurant.persistence;

import com.app.AppRestaurant.entities.MenuEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IMenuDAO {
    Mono<MenuEntity> save(MenuEntity menu);
    Flux<MenuEntity> findAllByRestaurantId(Long id);
    Flux<MenuEntity> findAllByCategoryBreakfast();
    Flux<MenuEntity> findAllByCategoryLunch();
    Flux<MenuEntity> findAllByCategoryDinner();
    Mono<MenuEntity> findById(Long id);
    Flux<MenuEntity> findAll();
    Mono<Void> delete(MenuEntity menu);
}
