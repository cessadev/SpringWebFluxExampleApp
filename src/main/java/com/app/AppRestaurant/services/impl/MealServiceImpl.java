package com.app.AppRestaurant.services.impl;

import com.app.AppRestaurant.entities.MealEntity;
import com.app.AppRestaurant.persistence.IMealDAO;
import com.app.AppRestaurant.services.IMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MealServiceImpl implements IMealService {
    @Autowired
    private IMealDAO mealDAO;

    @Override
    public Mono<MealEntity> save(MealEntity meal) {
        return mealDAO.save(meal);
    }

    @Override
    public Mono<MealEntity> findById(Long id) {
        return mealDAO.findById(id);
    }

    @Override
    public Flux<MealEntity> findAll() {
        return mealDAO.findAll();
    }

    @Override
    public Mono<Void> delete(MealEntity meal) {
        return mealDAO.delete(meal);
    }
}
