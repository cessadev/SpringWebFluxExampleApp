package com.app.AppRestaurant.mapper;

import com.app.AppRestaurant.entities.MealEntity;
import com.app.AppRestaurant.entities.dto.MealDTO;

public class MealMapper {
    public static MealEntity mapToEntity(MealDTO dto) {
        MealEntity entity = new MealEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setCategory(dto.getCategory());
        entity.setIngredients(dto.getIngredients());
        entity.setImage(dto.getImage());
        entity.setMenuId(dto.getMenuId());
        return entity;
    }

    public static MealDTO mapToDto(MealEntity entity) {
        MealDTO dto = new MealDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setPrice(entity.getPrice());
        dto.setCategory(entity.getCategory());
        dto.setIngredients(entity.getIngredients());
        dto.setImage(entity.getImage());
        dto.setMenuId(entity.getMenuId());
        return dto;
    }
}
