package com.softuni.essentials;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class EssentialsApplication {

    public static void main(String[] args) {
        SpringApplication.run(EssentialsApplication.class, args);
    }
}
