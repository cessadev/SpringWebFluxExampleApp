package com.app.AppRestaurant.entities.dto;

import com.app.AppRestaurant.enums.ECategoryMeal;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MealDTO {

    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("category")
    private ECategoryMeal category;

    @JsonProperty("ingredients")
    private String ingredients;

    @JsonProperty("image")
    private String image;

    @JsonProperty("menu_id")
    private Long menuId;
}
