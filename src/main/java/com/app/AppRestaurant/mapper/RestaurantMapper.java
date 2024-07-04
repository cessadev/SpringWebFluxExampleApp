package com.app.AppRestaurant.mapper;

import com.app.AppRestaurant.entities.RestaurantEntity;
import com.app.AppRestaurant.entities.dto.RestaurantDTO;

public class RestaurantMapper {

    // Map Entity to DTO
    public static RestaurantDTO mapToDto(RestaurantEntity restaurantEntity) {
        RestaurantDTO dto = new RestaurantDTO();
        dto.setId(restaurantEntity.getId());
        dto.setName(restaurantEntity.getName());
        dto.setAddress(restaurantEntity.getAddress());
        dto.setPhoneNumber(restaurantEntity.getPhoneNumber());
        return dto;
    }

    // Map DTO to Entity
    public static RestaurantEntity mapToEntity(RestaurantDTO dto) {
        RestaurantEntity entity = new RestaurantEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setPhoneNumber(dto.getPhoneNumber());
        return entity;
    }

}
