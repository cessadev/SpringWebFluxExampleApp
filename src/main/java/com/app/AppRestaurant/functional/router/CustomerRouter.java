package com.app.AppRestaurant.functional.router;

import com.app.AppRestaurant.functional.handler.CustomerHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class CustomerRouter {

    @Bean
    public RouterFunction<ServerResponse> routerCustomer(CustomerHandler customerHandler) {
        return RouterFunctions
                .route(GET("/functional/handler/customers"), customerHandler::getAllCustomers)
                .andRoute(GET("/functional/handler/customerById/{id}"), customerHandler::getCustomerById)
                .andRoute(POST("/functional/handler/customer/save"), customerHandler::createCustomer)
                .andRoute(PUT("/functional/handler/updateCustomerById/{id}"), customerHandler::updateCustomer)
                .andRoute(DELETE("/functional/handler/deleteCustomerById/{id}"), customerHandler::deleteCustomer);
    }
}
