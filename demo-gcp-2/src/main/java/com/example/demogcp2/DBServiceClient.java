package com.example.demogcp2;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


//@FeignClient(value="database-service")
@FeignClient(name = "database-service", url = "${DEMO_GCP_1_SERVICE_HOST:http://localhost}:8091")
public interface DBServiceClient {

    @GetMapping(value = "/private/v1/get/allcustomer", produces = "application/json")
    List<Customer> getCustomers();

    @PostMapping(value = "/private/v1/add/customer")
    void saveCustomer(Customer customerData);
    
    @GetMapping("/private/v1/get/customer/{id}")
    Customer getCustomerById(@PathVariable("id") Long id);
}