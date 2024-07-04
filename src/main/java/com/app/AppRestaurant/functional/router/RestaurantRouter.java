package com.app.AppRestaurant.functional.router;

import com.app.AppRestaurant.functional.handler.RestaurantHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class RestaurantRouter {

    @Bean
    public RouterFunction<ServerResponse> routerRestaurant(RestaurantHandler restaurantHandler) {
        return RouterFunctions
                .route(GET("/functional/handler/restaurants"), restaurantHandler::getAllRestaurants)
                .andRoute(GET("/functional/handler/restaurantById/{id}"), restaurantHandler::getRestaurantById)
                .andRoute(POST("/functional/handler/restaurant/save"), restaurantHandler::createRestaurant)
                .andRoute(PUT("/functional/handler/updateRestaurantById/{id}"), restaurantHandler::updateRestaurant)
                .andRoute(DELETE("/functional/handler/deleteRestaurantById/{id}"), restaurantHandler::deleteRestaurant);
    }
}
