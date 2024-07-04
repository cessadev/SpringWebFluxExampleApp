package com.app.AppRestaurant.persistence.impl;

import com.app.AppRestaurant.entities.MenuEntity;
import com.app.AppRestaurant.persistence.IMenuDAO;
import com.app.AppRestaurant.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class MenuDAOImpl implements IMenuDAO {
    @Autowired
    private MenuRepository menuRepository;

    @Override
    public Mono<MenuEntity> save(MenuEntity menu) {
        return menuRepository.save(menu);
    }

    @Override
    public Flux<MenuEntity> findAllByRestaurantId(Long id) {
        return menuRepository.findAllByRestaurantId(id);
    }

    @Override
    public Flux<MenuEntity> findAllByCategoryBreakfast() {
        return menuRepository.findAllByCategoryBreakfast();
    }

    @Override
    public Flux<MenuEntity> findAllByCategoryLunch() {
        return menuRepository.findAllByCategoryLunch();
    }

    @Override
    public Flux<MenuEntity> findAllByCategoryDinner() {
        return menuRepository.findAllByCategoryDinner();
    }

    @Override
    public Mono<MenuEntity> findById(Long id) {
        return menuRepository.findById(id);
    }

    @Override
    public Flux<MenuEntity> findAll() {
        return menuRepository.findAll();
    }

    @Override
    public Mono<Void> delete(MenuEntity menu) {
        return menuRepository.delete(menu);
    }
}
