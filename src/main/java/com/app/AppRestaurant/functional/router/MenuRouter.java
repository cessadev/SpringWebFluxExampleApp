package com.app.AppRestaurant.functional.router;

import com.app.AppRestaurant.functional.handler.MenuHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class MenuRouter {

    @Bean
    public RouterFunction<ServerResponse> routerMenu(MenuHandler menuHandler) {
        return RouterFunctions
                .route(GET("/functional/handler/menus"), menuHandler::getAllMenus)
                .andRoute(GET("/functional/handler/menuById/{id}"), menuHandler::getMenuById)
                .andRoute(GET("/functional/handler/menusByRestaurantId/{restaurantId}"), menuHandler::getAllMenusByRestaurantId)
                .andRoute(GET("/functional/handler/menusByCategoryBreakfast"), menuHandler::getAllMenusWithCategoryBreakfast)
                .andRoute(GET("/functional/handler/menusByCategoryLunch"), menuHandler::getAllMenusWithCategoryLunch)
                .andRoute(GET("/functional/handler/menusByCategoryDinner"), menuHandler::getAllMenusWithCategoryDinner)
                .andRoute(POST("/functional/handler/menu/save"), menuHandler::createMenu)
                .andRoute(PUT("/functional/handler/updateMenuById/{id}"), menuHandler::updateMenu)
                .andRoute(DELETE("/functional/handler/deleteMenuById/{id}"), menuHandler::deleteMenu);
    }
}
