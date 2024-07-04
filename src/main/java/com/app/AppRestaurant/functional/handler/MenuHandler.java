package com.app.AppRestaurant.functional.handler;

import com.app.AppRestaurant.entities.MenuEntity;
import com.app.AppRestaurant.entities.dto.MenuDTO;
import com.app.AppRestaurant.functional.response.CustomResponses;
import com.app.AppRestaurant.mapper.MenuMapper;
import com.app.AppRestaurant.services.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MenuHandler {
    @Autowired
    private IMenuService menuService;

    public Mono<ServerResponse> getAllMenus(ServerRequest request) {
        return menuService.findAll()
                .collectList()
                .flatMap(menus -> {
                    List<MenuDTO> menuDTOList = menus.stream()
                            .map(MenuMapper::mapToDto)
                            .collect(Collectors.toList());
                    return ServerResponse.ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .bodyValue(menuDTOList);
                });
    }

    public Mono<ServerResponse> getMenuById(ServerRequest request) {
        String id = request.pathVariable("id");

        return menuService.findById(Long.valueOf(id))
                .flatMap(menuEntity -> {
                    MenuDTO menuDTO = MenuMapper.mapToDto(menuEntity);
                    return ServerResponse.ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .bodyValue(menuDTO);
                })
                .switchIfEmpty(CustomResponses.getResponse404());
    }

    // Get all associated menus to a particular restaurant
    public Mono<ServerResponse> getAllMenusByRestaurantId(ServerRequest request) {
        Long restaurantId = Long.valueOf(request.pathVariable("restaurantId"));

        Flux<MenuEntity> menuFlux = menuService.findAllByRestaurantId(restaurantId);

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(menuFlux, MenuEntity.class);
    }

    // Get all menus with "BREAKFAST" category
    public Mono<ServerResponse> getAllMenusWithCategoryBreakfast(ServerRequest request) {
        Flux<MenuEntity> menuFlux = menuService.findAllByCategoryBreakfast();

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(menuFlux, MenuEntity.class);
    }

    // Get all menus with "LUNCH" category
    public Mono<ServerResponse> getAllMenusWithCategoryLunch(ServerRequest request) {
        Flux<MenuEntity> menuFlux = menuService.findAllByCategoryLunch();

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(menuFlux, MenuEntity.class);
    }

    // Get all menus with "DINNER" category
    public Mono<ServerResponse> getAllMenusWithCategoryDinner(ServerRequest request) {
        Flux<MenuEntity> menuFlux = menuService.findAllByCategoryDinner();

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(menuFlux, MenuEntity.class);
    }

    public Mono<ServerResponse> createMenu(ServerRequest request) {
        Mono<MenuDTO> menuDTOMono = request.bodyToMono(MenuDTO.class);

        return menuDTOMono
                .flatMap(menuDTO -> {
                    MenuEntity menuEntity = MenuMapper.mapToEntity(menuDTO);

                    return menuService.save(menuEntity)
                            .flatMap(savedMenuEntity -> {
                                try {
                                    return ServerResponse.created(new URI("/functional/handler/menu/save"))
                                            .contentType(MediaType.APPLICATION_JSON)
                                            .bodyValue(savedMenuEntity);
                                } catch (URISyntaxException e) {
                                    throw new RuntimeException(e);
                                }
                            });
                })
                .switchIfEmpty(CustomResponses.getResponse406());
    }

    public Mono<ServerResponse> updateMenu(ServerRequest request) {
        Mono<MenuDTO> menuDTOMono = request.bodyToMono(MenuDTO.class);
        String id = request.pathVariable("id");

        return menuService.findById(Long.valueOf(id))
                .flatMap(foundMenu -> menuDTOMono.flatMap(menuDTO -> {
                    MenuEntity menuEntity = MenuMapper.mapToEntity(menuDTO);
                    menuEntity.setId(foundMenu.getId());

                    return menuService.save(menuEntity)
                            .flatMap(updatedMenuEntity -> ServerResponse.ok()
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .bodyValue(MenuMapper.mapToDto(updatedMenuEntity)));
                }))
                .switchIfEmpty(CustomResponses.getResponse404());
    }

    public Mono<ServerResponse> deleteMenu(ServerRequest request) {
        String id = request.pathVariable("id");

        return menuService.findById(Long.valueOf(id))
                .flatMap(foundMenu -> menuService.delete(foundMenu)
                        .then(ServerResponse.noContent().build()))
                .switchIfEmpty(CustomResponses.getResponse404());
    }

}
