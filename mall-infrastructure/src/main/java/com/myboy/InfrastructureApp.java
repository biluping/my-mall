package com.myboy;

import org.dromara.x.file.storage.spring.EnableFileStorage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableFileStorage
@SpringBootApplication
public class InfrastructureApp {

    public static void main(String[] args) {
        SpringApplication.run(InfrastructureApp.class, args);
    }
}
