package com.app.AppRestaurant.entities.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("age")
    private Integer age;

    @JsonProperty("delivery_address")
    private String deliveryAddress;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("email")
    private String email;

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;
}
