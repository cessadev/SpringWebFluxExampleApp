package com.app.AppRestaurant.functional.handler;

import com.app.AppRestaurant.entities.MealEntity;
import com.app.AppRestaurant.entities.dto.MealDTO;
import com.app.AppRestaurant.functional.response.CustomResponses;
import com.app.AppRestaurant.mapper.MealMapper;
import com.app.AppRestaurant.services.IMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MealHandler {
    @Autowired
    private IMealService mealService;

    public Mono<ServerResponse> getAllMeals(ServerRequest request) {
        return mealService.findAll()
                .collectList()
                .flatMap(meals -> {
                    List<MealDTO> mealDTOList = meals.stream()
                            .map(MealMapper::mapToDto)
                            .collect(Collectors.toList());
                    return ServerResponse.ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .bodyValue(mealDTOList);
                });
    }

    public Mono<ServerResponse> getMealById(ServerRequest request) {
        String id = request.pathVariable("id");

        return mealService.findById(Long.valueOf(id))
                .flatMap(mealEntity -> {
                    MealDTO mealDTO = MealMapper.mapToDto(mealEntity);
                    return ServerResponse.ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .bodyValue(mealDTO);
                })
                .switchIfEmpty(CustomResponses.getResponse404());
    }

    public Mono<ServerResponse> createMeal(ServerRequest request) {
        Mono<MealDTO> mealDTOMono = request.bodyToMono(MealDTO.class);

        return mealDTOMono
                .flatMap(mealDTO -> {
                    MealEntity mealEntity = MealMapper.mapToEntity(mealDTO);

                    return mealService.save(mealEntity)
                            .flatMap(savedMealEntity -> {
                                try {
                                    return ServerResponse.created(new URI("/functional/handler/meal/save"))
                                            .contentType(MediaType.APPLICATION_JSON)
                                            .bodyValue(savedMealEntity);
                                } catch (URISyntaxException e) {
                                    throw new RuntimeException(e);
                                }
                            });
                })
                .switchIfEmpty(CustomResponses.getResponse406());
    }

    public Mono<ServerResponse> updateMeal(ServerRequest request) {
        Mono<MealDTO> mealDTOMono = request.bodyToMono(MealDTO.class);
        String id = request.pathVariable("id");

        return mealService.findById(Long.valueOf(id))
                .flatMap(foundMeal -> mealDTOMono.flatMap(mealDTO -> {
                    MealEntity mealEntity = MealMapper.mapToEntity(mealDTO);
                    mealEntity.setId(foundMeal.getId());

                    return mealService.save(mealEntity)
                            .flatMap(updatedMealEntity -> ServerResponse.ok()
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .bodyValue(MealMapper.mapToDto(updatedMealEntity)));
                }))
                .switchIfEmpty(CustomResponses.getResponse404());
    }

    public Mono<ServerResponse> deleteMeal(ServerRequest request) {
        String id = request.pathVariable("id");

        return mealService.findById(Long.valueOf(id))
                .flatMap(foundMeal -> mealService.delete(foundMeal)
                        .then(ServerResponse.noContent().build()))
                .switchIfEmpty(CustomResponses.getResponse404());
    }

}
