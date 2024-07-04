package com.app.AppRestaurant.functional.handler;

import com.app.AppRestaurant.entities.RestaurantEntity;
import com.app.AppRestaurant.entities.dto.RestaurantDTO;
import com.app.AppRestaurant.functional.response.CustomResponses;
import com.app.AppRestaurant.mapper.RestaurantMapper;
import com.app.AppRestaurant.services.IRestaurantService;
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
public class RestaurantHandler {
    @Autowired
    private IRestaurantService restaurantService;

    // Get all the restaurant
    public Mono<ServerResponse> getAllRestaurants(ServerRequest request) {
        return restaurantService.findAll()
                .collectList()
                .flatMap(restaurants -> {
                    List<RestaurantDTO> restaurantDTOList = restaurants.stream()
                            .map(RestaurantMapper::mapToDto)
                            .collect(Collectors.toList());
                    return ServerResponse.ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .bodyValue(restaurantDTOList);
                });
    }

    // Get a restaurant through the ID
    public Mono<ServerResponse> getRestaurantById(ServerRequest request) {
        String id = request.pathVariable("id");

        return restaurantService.findById(Long.valueOf(id))
                .flatMap(restaurantEntity -> {
                    RestaurantDTO restaurantDTO = RestaurantMapper.mapToDto(restaurantEntity);
                    return ServerResponse.ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .bodyValue(restaurantDTO);
                })
                .switchIfEmpty(CustomResponses.getResponse404());
    }

    // Persist a restaurant in the database
    public Mono<ServerResponse> createRestaurant(ServerRequest request) {
        Mono<RestaurantDTO> restaurantDTOMono = request.bodyToMono(RestaurantDTO.class);

        return restaurantDTOMono
                .flatMap(restaurantDTO -> {
                    RestaurantEntity restaurantEntity = RestaurantMapper.mapToEntity(restaurantDTO);

                    return restaurantService.save(restaurantEntity)
                            .flatMap(restaurantEntitySaved -> {
                                try {
                                    return ServerResponse.created(new URI("/functional/handler/restaurant/save"))
                                            .contentType(MediaType.APPLICATION_JSON)
                                            .bodyValue(restaurantEntitySaved);
                                } catch (URISyntaxException e) {
                                    throw new RuntimeException(e);
                                }
                            });
                })
                .switchIfEmpty(CustomResponses.getResponse406());
    }

    // Update a restaurant through their ID
    public Mono<ServerResponse> updateRestaurant(ServerRequest request) {
        Mono<RestaurantDTO> restaurantDTOMono = request.bodyToMono(RestaurantDTO.class);
        String id = request.pathVariable("id");

        return restaurantService.findById(Long.valueOf(id))
                .flatMap(restaurantFound -> restaurantDTOMono.flatMap(restaurantDTO -> {
                    RestaurantEntity restaurantEntity = RestaurantMapper.mapToEntity(restaurantDTO);
                    restaurantEntity.setId(restaurantFound.getId());

                    return restaurantService.save(restaurantEntity)
                            .flatMap(updatedRestaurantEntity -> ServerResponse.ok()
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .bodyValue(RestaurantMapper.mapToDto(updatedRestaurantEntity)));
                }))
                .switchIfEmpty(CustomResponses.getResponse404());
    }

    // Delete a contact through their ID
    public Mono<ServerResponse> deleteRestaurant(ServerRequest request) {
        String id = request.pathVariable("id");

        return restaurantService.findById(Long.valueOf(id))
                .flatMap(restaurantFound -> restaurantService.delete(restaurantFound)
                        .then(ServerResponse.noContent().build()))
                .switchIfEmpty(CustomResponses.getResponse404());
    }

}
