package com.example.springpoi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableR2dbcRepositories(basePackageClasses = PoiRepository.class)
public class SpringPoiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringPoiApplication.class, args);
    }

}
