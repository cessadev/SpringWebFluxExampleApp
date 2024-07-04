package com.app.AppRestaurant.persistence.impl;

import com.app.AppRestaurant.entities.CustomerEntity;
import com.app.AppRestaurant.persistence.ICustomerDAO;
import com.app.AppRestaurant.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CustomerDAOImpl implements ICustomerDAO {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Mono<CustomerEntity> save(CustomerEntity customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Mono<CustomerEntity> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Flux<CustomerEntity> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Mono<Void> delete(CustomerEntity customer) {
        return customerRepository.delete(customer);
    }

}
