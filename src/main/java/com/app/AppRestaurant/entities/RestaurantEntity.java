package com.app.AppRestaurant.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("restaurant")
public class RestaurantEntity {

    @Id
    private Long id;

    @Column("name")
    private String name;

    @Column("address")
    private String address;

    @Column("phone_number")
    private String phoneNumber;
}
