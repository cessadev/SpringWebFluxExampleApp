package com.app.AppRestaurant.repository;

import com.app.AppRestaurant.entities.CustomerEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends R2dbcRepository<CustomerEntity, Long> {
}
