package com.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.jpa.entity.Customer;

// This will be AUTO IMPLEMENTED by Spring into a Bean called CustomerRepository
// CRUD refers Create, Read, Update, Delete

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
