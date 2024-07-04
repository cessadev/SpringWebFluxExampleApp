package com.app.AppRestaurant.entities;

import com.app.AppRestaurant.enums.ECategoryMenu;
import com.app.AppRestaurant.enums.ERoles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("menu")
public class MenuEntity {

    @Id
    private Long id;

    @Column("name")
    private String name;

    @Column("description")
    private String description;

    @Column("category")
    private ECategoryMenu category;

    @Column("restaurant_id")
    private Long restaurantId;

    @Transient
    private List<MealEntity> meals = new ArrayList<>();

    public static class CategoryMenuConverter implements Converter<String, ECategoryMenu> {
        @Override
        public ECategoryMenu convert(String source) {
            return ECategoryMenu.valueOf(source.toUpperCase());
        }
    }

}
