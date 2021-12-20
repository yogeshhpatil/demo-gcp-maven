package com.example.demogcp2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@SpringBootApplication
@EnableFeignClients
public class DemoGcp2Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoGcp2Application.class, args);
	}

}


@RestController
@RequestMapping("/public/v1")
@Slf4j
class UserSvcRestController {
	
	@Autowired
	private DatabaseService databaseService;
	

	@GetMapping("/apitest/{name}")
	public String getTest(@PathVariable String name) {
		log.info("Service 2 Inside test api method.. {}", name);
		return "Hello ".concat(name);
	}
	
	@GetMapping("/get/allcustomer")
	public List<Customer> getAllCustomer() {
		log.info("Service 2 /get/allcustomer called..");
		return databaseService.findAllCustomer();
	}
	
	@PostMapping("/add/customer")
	public void addContent(@RequestBody Customer customer) {
		databaseService.save(customer);
		log.info("Service 2 customer data saved successfully..");
	}

    @GetMapping("/logconsole")
    public String bar() {
       log.info("Service 2 info log");
       log.error("Service 2 error log");
       return "bar";
    }
}
