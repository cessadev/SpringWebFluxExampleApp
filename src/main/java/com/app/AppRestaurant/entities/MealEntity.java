package com.app.AppRestaurant.entities;

import com.app.AppRestaurant.enums.ECategoryMeal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("meal")
public class MealEntity {

    @Id
    private Long id;

    @Column("name")
    private String name;

    @Column("description")
    private String description;

    @Column("price")
    private BigDecimal price;

    @Column("category")
    private ECategoryMeal category;

    @Column("ingredients")
    private String ingredients;

    @Column("image")
    private String image;

    @Column("menu_id")
    private Long menuId;

}
