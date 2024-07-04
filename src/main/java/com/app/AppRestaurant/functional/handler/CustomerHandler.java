package com.app.AppRestaurant.functional.handler;

import com.app.AppRestaurant.entities.CustomerEntity;
import com.app.AppRestaurant.entities.dto.CustomerDTO;
import com.app.AppRestaurant.functional.response.CustomResponses;
import com.app.AppRestaurant.mapper.CustomerMapper;
import com.app.AppRestaurant.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerHandler {
    @Autowired
    private ICustomerService customerService;

    // Get all the customer
    public Mono<ServerResponse> getAllCustomers(ServerRequest request) {
        return customerService.findAll()
                .collectList()
                .flatMap(customers -> {
                    List<CustomerDTO> customerDTOList = customers.stream()
                            .map(CustomerMapper::mapToDto)
                            .collect(Collectors.toList());
                    return ServerResponse.ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .bodyValue(customerDTOList);
                });
    }

    // Get a customer through the ID
    public Mono<ServerResponse> getCustomerById(ServerRequest request) {
        String id = request.pathVariable("id");

        return customerService.findById(Long.valueOf(id))
                .flatMap(customerEntity -> {
                    CustomerDTO customerDTO = CustomerMapper.mapToDto(customerEntity);
                    return ServerResponse.ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .bodyValue(customerDTO);
                })
                .switchIfEmpty(CustomResponses.getResponse404());
    }

    // Persist a customer in the database
    public Mono<ServerResponse> createCustomer(ServerRequest request) {
        Mono<CustomerDTO> customerDTOMono = request.bodyToMono(CustomerDTO.class);

        return customerDTOMono
                .flatMap(customerDTO -> {
                    CustomerEntity customerEntity = CustomerMapper.mapToEntity(customerDTO);

                    return customerService.save(customerEntity)
                            .flatMap(customerEntitySaved -> {
                                try {
                                    return ServerResponse.created(new URI("/functional/handler/customer/save"))
                                            .contentType(MediaType.APPLICATION_JSON)
                                            .bodyValue(customerEntitySaved);
                                } catch (URISyntaxException e) {
                                    throw new RuntimeException(e);
                                }
                            });
                })
                .switchIfEmpty(CustomResponses.getResponse406());
    }

    // Update a customer through their ID
    public Mono<ServerResponse> updateCustomer(ServerRequest request) {
        Mono<CustomerDTO> customerDTOMono = request.bodyToMono(CustomerDTO.class);
        String id = request.pathVariable("id");

        return customerService.findById(Long.valueOf(id))
                .flatMap(customerFound -> customerDTOMono.flatMap(customerDTO -> {
                    CustomerEntity customerEntity = CustomerMapper.mapToEntity(customerDTO);
                    customerEntity.setId(customerFound.getId());

                    return customerService.save(customerEntity)
                            .flatMap(updatedCustomerEntity -> ServerResponse.ok()
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .bodyValue(CustomerMapper.mapToDto(updatedCustomerEntity)));
                }))
                .switchIfEmpty(CustomResponses.getResponse404());
    }

    // Delete a contact through their ID
    public Mono<ServerResponse> deleteCustomer(ServerRequest request) {
        String id = request.pathVariable("id");

        return customerService.findById(Long.valueOf(id))
                .flatMap(customerFound -> customerService.delete(customerFound)
                        .then(ServerResponse.noContent().build()))
                .switchIfEmpty(CustomResponses.getResponse404());
    }

}
