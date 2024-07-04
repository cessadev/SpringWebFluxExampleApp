package com.app.AppRestaurant.config.R2dbc;

import com.app.AppRestaurant.entities.MenuEntity;
import com.app.AppRestaurant.entities.RoleEntity;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.convert.R2dbcCustomConversions;
import org.springframework.data.r2dbc.dialect.DialectResolver;
import org.springframework.data.r2dbc.dialect.R2dbcDialect;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import java.util.Arrays;

@Configuration
@EnableR2dbcRepositories
public class R2dbcConfig {}
