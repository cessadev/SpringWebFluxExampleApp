package com.app.AppRestaurant.repository;

import com.app.AppRestaurant.entities.RoleEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends R2dbcRepository<RoleEntity, Long> {
}
