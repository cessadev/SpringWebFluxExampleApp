package com.app.AppRestaurant.mapper;

import com.app.AppRestaurant.entities.MenuEntity;
import com.app.AppRestaurant.entities.dto.MenuDTO;

public class MenuMapper {

    public static MenuEntity mapToEntity(MenuDTO dto) {
        MenuEntity entity = new MenuEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setCategory(dto.getCategory());
        entity.setRestaurantId(dto.getRestaurantId());
        return entity;
    }

    public static MenuDTO mapToDto(MenuEntity entity) {
        MenuDTO dto = new MenuDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setCategory(entity.getCategory());
        dto.setRestaurantId(entity.getRestaurantId());
        return dto;
    }
}
