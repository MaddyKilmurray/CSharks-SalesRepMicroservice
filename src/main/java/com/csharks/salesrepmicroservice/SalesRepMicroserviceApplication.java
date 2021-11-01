package com.csharks.salesrepmicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SalesRepMicroserviceApplication implements CommandLineRunner {

    @Autowired
    Data data;

    public static void main(String[] args) {
        SpringApplication.run(SalesRepMicroserviceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        data.populate();
    }
}
