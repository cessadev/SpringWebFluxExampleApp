package com.app.AppRestaurant.functional.response;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Data
public class CustomResponses {
    public static Mono<ServerResponse> getResponse404() {
        return ServerResponse.notFound().build();
    }
    public static Mono<ServerResponse> getResponse406() {
        return ServerResponse.status(HttpStatus.NOT_ACCEPTABLE).build();
    }
}
