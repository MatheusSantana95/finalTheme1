package com.matheussantana.cloudnative.tema1.main;

import com.matheussantana.cloudnative.tema1.calculator.*;
import com.matheussantana.cloudnative.tema1.config.AppConfig;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.reactivex.netty.protocol.http.server.HttpServerRequest;
import io.reactivex.netty.protocol.http.server.HttpServerResponse;
import io.reactivex.netty.protocol.http.server.RequestHandler;
import netflix.karyon.transport.http.health.HealthCheckEndpoint;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import rx.Observable;

import java.util.List;
import java.util.Map;

public class RxNettyHandler implements RequestHandler<ByteBuf, ByteBuf> {

    private HealthCheckEndpoint healthCheckEndpoint;
    private Calculator calculator;
    private String healthCheck;

    public RxNettyHandler(String healthCheck, HealthCheckEndpoint healthCheckEndpoint, Calculator calculator) {
        this.healthCheckEndpoint = healthCheckEndpoint;
        this.calculator = calculator;
        this.healthCheck = healthCheck;
    }

    @Override
    public Observable<Void> handle(HttpServerRequest<ByteBuf> request, HttpServerResponse<ByteBuf> response) {
        Map<String, List<String>> requestParameters = request.getQueryParameters();

        if (request.getUri().startsWith("/rxnetty/")) {
            if (requestParameters.containsKey("num1") && requestParameters.containsKey("num2") && requestParameters.containsKey("op")) {

                try {
                    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
                    Calculator calc = context.getBean(Calculator.class);
                    Sum sum = context.getBean(Sum.class);
                    Subtract subtract = context.getBean(Subtract.class);
                    Multiply multiply = context.getBean(Multiply.class);
                    Division division = context.getBean(Division.class);
                    Pow pow = context.getBean(Pow.class);
                    double number1 = Double.parseDouble(requestParameters.get("num1").get(0));
                    double number2 = Double.parseDouble(requestParameters.get("num2").get(0));

                    String operation = requestParameters.get("op").get(0);
                    String result = "";
                    switch (operation) {
                        case "sum":
                            result = calc.calculate(number1, number2, sum);
                            break;
                        case "subtract":
                            result = calc.calculate(number1, number2, subtract);
                            break;
                        case "multiply":
                            result = calc.calculate(number1, number2, multiply);
                            break;
                        case "division":
                            result = calc.calculate(number1, number2, division);
                            break;
                        case "pow":
                            result = calc.calculate(number1, number2, pow);
                            break;
                        default:
                            result = "This is a invalid operation!";
                    }
                    response.setStatus(HttpResponseStatus.OK);
                    return response.writeStringAndFlush("Result: " +result);
                } catch (IllegalArgumentException e) {
                    response.setStatus(HttpResponseStatus.BAD_REQUEST);
                    return response.writeStringAndFlush("This is a null value");
                }
            } else if (requestParameters.containsKey("history")) {
                response.setStatus(HttpResponseStatus.OK);
                return response.writeStringAndFlush("Historic: "+calculator.getCalculatorHistoric());
            }

        }
        else if(request.getUri().startsWith(healthCheck)) {
            return healthCheckEndpoint.handle(request, response);
        }
        response.setStatus(HttpResponseStatus.NOT_FOUND);
        return response.close();
    }
}

