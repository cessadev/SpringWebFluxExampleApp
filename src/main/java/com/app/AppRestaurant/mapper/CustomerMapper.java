package com.app.AppRestaurant.mapper;

import com.app.AppRestaurant.entities.CustomerEntity;
import com.app.AppRestaurant.entities.dto.CustomerDTO;

public class CustomerMapper {

    // Map Entity to DTO
    public static CustomerDTO mapToDto(CustomerEntity customerEntity) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(customerEntity.getId());
        dto.setName(customerEntity.getName());
        dto.setLastName(customerEntity.getLastName());
        dto.setAge(customerEntity.getAge());
        dto.setDeliveryAddress(customerEntity.getDeliveryAddress());
        dto.setPhoneNumber(customerEntity.getPhoneNumber());
        dto.setEmail(customerEntity.getEmail());
        dto.setUsername(customerEntity.getUsername());
        dto.setPassword(customerEntity.getPassword());
        return dto;
    }

    // Map DTO to Entity
    public static CustomerEntity mapToEntity(CustomerDTO customerDTO) {
        CustomerEntity entity = new CustomerEntity();
        entity.setId(customerDTO.getId());
        entity.setName(customerDTO.getName());
        entity.setLastName(customerDTO.getLastName());
        entity.setAge(customerDTO.getAge());
        entity.setDeliveryAddress(customerDTO.getDeliveryAddress());
        entity.setPhoneNumber(customerDTO.getPhoneNumber());
        entity.setEmail(customerDTO.getEmail());
        entity.setUsername(customerDTO.getUsername());
        entity.setPassword(customerDTO.getPassword());
        return entity;
    }

}
