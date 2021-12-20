package com.example.demogcp1;

import org.springframework.data.repository.CrudRepository;

public interface DatabaseService extends CrudRepository<Customer, Long> {

}