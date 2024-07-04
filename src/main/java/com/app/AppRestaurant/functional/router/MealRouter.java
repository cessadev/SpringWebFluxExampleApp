package com.app.AppRestaurant.functional.router;

import com.app.AppRestaurant.functional.handler.MealHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class MealRouter {

    @Bean
    public RouterFunction<ServerResponse> routerMeal(MealHandler mealHandler) {
        return RouterFunctions
                .route(GET("/functional/handler/meals"), mealHandler::getAllMeals)
                .andRoute(GET("/functional/handler/mealById/{id}"), mealHandler::getMealById)
                .andRoute(POST("/functional/handler/meal/save"), mealHandler::createMeal)
                .andRoute(PUT("/functional/handler/updateMealById/{id}"), mealHandler::updateMeal)
                .andRoute(DELETE("/functional/handler/deleteMealById/{id}"), mealHandler::deleteMeal);
    }

}
