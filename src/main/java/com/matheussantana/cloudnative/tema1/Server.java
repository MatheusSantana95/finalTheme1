package com.matheussantana.cloudnative.tema1.main;

import com.matheussantana.cloudnative.tema1.calculator.Calculator;
import com.matheussantana.cloudnative.tema1.config.AppConfig;
import io.reactivex.netty.RxNetty;
import netflix.karyon.transport.http.health.HealthCheckEndpoint;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Server {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        HealthCheckResource healthCheck = (HealthCheckResource) applicationContext.getBean("healthCheckResource");

        RxNetty.createHttpServer(8083, new RxNettyHandler("/healthCheck",
                new HealthCheckEndpoint(healthCheck),
                (Calculator) applicationContext.getBean("calculator")))
                .startAndWait();
    }
}
