package com.example.demogcp1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@ComponentScan({"com.example.demogcp1"})
@RestController
public class DemoGcp1Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoGcp1Application.class, args);
	}

    @GetMapping("/sample") 
    public String getName() {
        return "Hello World";
    }
}
