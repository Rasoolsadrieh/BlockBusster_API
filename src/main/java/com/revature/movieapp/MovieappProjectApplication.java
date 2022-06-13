package com.revature.movieapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class MovieappProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieappProjectApplication.class, args);
    }

}