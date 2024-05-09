package com.ideyalabs.demoproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DemoprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoprojectApplication.class, args);
    }

}
