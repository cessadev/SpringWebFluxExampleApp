package com.app.AppRestaurant.services.impl;

import com.app.AppRestaurant.entities.CustomerEntity;
import com.app.AppRestaurant.persistence.ICustomerDAO;
import com.app.AppRestaurant.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerDAO customerDAO;

    @Override
    public Mono<CustomerEntity> save(CustomerEntity customer) {
        return customerDAO.save(customer);
    }

    @Override
    public Mono<CustomerEntity> findById(Long id) {
        return customerDAO.findById(id);
    }

    @Override
    public Flux<CustomerEntity> findAll() {
        return customerDAO.findAll();
    }

    @Override
    public Mono<Void> delete(CustomerEntity customer) {
        return customerDAO.delete(customer);
    }
}
