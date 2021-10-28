package com.csharks.salesrepmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SalesRepMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalesRepMicroserviceApplication.class, args);
    }

}
