package com.example.demogcp1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class DemoGcp1Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoGcp1Application.class, args);
	}

}


@Slf4j
@RestController
@RequestMapping("/private/v1")
class DBController {

    @Autowired
	private DatabaseService databaseService;

	@GetMapping("/get/customer/{id}")
	public Customer getCustomerById(@PathVariable Long id) {
		
		Optional<Customer> customer = databaseService.findById(id);
		if (customer.isPresent()) {
			Customer c = customer.get();
			log.info("returning customer list ... {}",c);
			return c;
		}
		
		return null;
	}
	
	@GetMapping("/get/allcustomer")
	public List<Customer> getAllCustomer() {
		List<Customer> customerList = new ArrayList<>();
		databaseService.findAll().forEach(customerList :: add);
		log.info("returning customer list ... {}",customerList);
		return customerList;
	}
	
	@PostMapping("/add/customer")
	public void addContent(@RequestBody Customer customer) {
		log.info("adding customer ... {}",customer);
		databaseService.save(customer);
		log.info("successfully added new customer...");
	}

   @GetMapping("/logconsole")
   public String bar() {
      log.info("info log");
      log.error("error log");
      return "bar";
   }
}
