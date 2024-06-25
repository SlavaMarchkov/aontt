package ru.pmgu.aontt;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class AonttApplication {

    public static void main(String[] args) {
        SpringApplication.run(AonttApplication.class, args);
    }

}
