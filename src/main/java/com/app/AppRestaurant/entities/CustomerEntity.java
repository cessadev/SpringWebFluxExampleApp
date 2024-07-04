package com.app.AppRestaurant.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("customer")
public class CustomerEntity {

    @Id
    private Long id;

    @Column("name")
    private String name;

    @Column("last_name")
    private String lastName;

    @Column("age")
    private Integer age;

    @Column("delivery_address")
    private String deliveryAddress;

    @Column("phone_number")
    private String phoneNumber;

    @Column("email")
    private String email;

    @Column("username")
    private String username;

    @Column("password")
    private String password;

//    @Transient
//    private Set<RoleEntity> roles;
}
