package com.revature.blockbusster;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class BlockBussterApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlockBussterApplication.class, args);
    }
}
