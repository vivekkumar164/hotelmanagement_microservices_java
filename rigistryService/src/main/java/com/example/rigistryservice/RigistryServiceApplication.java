package com.example.rigistryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RigistryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RigistryServiceApplication.class, args);
    }

}
