package com.app.AppRestaurant.entities.dto;

import com.app.AppRestaurant.enums.ERoles;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {

    private Long id;

    @JsonProperty("name")
    private ERoles name;
}
