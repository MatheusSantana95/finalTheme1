package com.matheussantana.cloudnative.tema1.config;

import com.matheussantana.cloudnative.tema1.calculator.*;
import com.matheussantana.cloudnative.tema1.main.HealthCheckResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "com.matheussantana.cloudnative.tema1.calculator")
public class AppConfig {

    @Bean
    public HealthCheckResource healthCheckResource(){
        return new HealthCheckResource();
    }

    @Bean
    public Calculator calculator(){
        return new Calculator();
    }

    @Bean
    public Sum sum(){
        return new Sum();
    }

    @Bean
    public Subtract subtract(){
        return new Subtract();
    }

    @Bean
    public Multiply multiply(){
        return new Multiply();
    }

    @Bean
    public Division division(){
        return new Division();
    }

    @Bean
    public Pow pow(){
        return new Pow();
    }
}
