package com.app.AppRestaurant.entities.dto;

import com.app.AppRestaurant.enums.ECategoryMenu;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuDTO {

    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("category")
    private ECategoryMenu category;

    @JsonProperty("restaurant_id")
    private Long restaurantId;
}
