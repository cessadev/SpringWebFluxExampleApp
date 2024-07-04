package com.app.AppRestaurant.persistence.impl;

import com.app.AppRestaurant.entities.MealEntity;
import com.app.AppRestaurant.persistence.IMealDAO;
import com.app.AppRestaurant.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class MealDAOImpl implements IMealDAO {
    @Autowired
    private MealRepository mealRepository;

    @Override
    public Mono<MealEntity> save(MealEntity meal) {
        return mealRepository.save(meal);
    }

    @Override
    public Mono<MealEntity> findById(Long id) {
        return mealRepository.findById(id);
    }

    @Override
    public Flux<MealEntity> findAll() {
        return mealRepository.findAll();
    }

    @Override
    public Mono<Void> delete(MealEntity meal) {
        return mealRepository.delete(meal);
    }
}
