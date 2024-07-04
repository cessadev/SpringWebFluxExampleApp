package com.app.AppRestaurant.services.impl;

import com.app.AppRestaurant.entities.MenuEntity;
import com.app.AppRestaurant.persistence.IMenuDAO;
import com.app.AppRestaurant.services.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MenuServiceImpl implements IMenuService {
    @Autowired
    private IMenuDAO menuDAO;

    @Override
    public Mono<MenuEntity> save(MenuEntity menu) {
        return menuDAO.save(menu);
    }

    @Override
    public Flux<MenuEntity> findAllByRestaurantId(Long id) {
        return menuDAO.findAllByRestaurantId(id);
    }

    @Override
    public Flux<MenuEntity> findAllByCategoryBreakfast() {
        return menuDAO.findAllByCategoryBreakfast();
    }

    @Override
    public Flux<MenuEntity> findAllByCategoryLunch() {
        return menuDAO.findAllByCategoryLunch();
    }

    @Override
    public Flux<MenuEntity> findAllByCategoryDinner() {
        return menuDAO.findAllByCategoryDinner();
    }

    @Override
    public Mono<MenuEntity> findById(Long id) {
        return menuDAO.findById(id);
    }

    @Override
    public Flux<MenuEntity> findAll() {
        return menuDAO.findAll();
    }

    @Override
    public Mono<Void> delete(MenuEntity menu) {
        return menuDAO.delete(menu);
    }
}
