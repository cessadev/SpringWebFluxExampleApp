package com.app.AppRestaurant.entities;

import com.app.AppRestaurant.enums.ERoles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("role")
public class RoleEntity {

    @Id
    private Long id;

    @Column("role")
    private ERoles role;

    public static class RoleConverter implements Converter<String, ERoles> {
        @Override
        public ERoles convert(String source) {
            return ERoles.valueOf(source.toUpperCase());
        }
    }

}
