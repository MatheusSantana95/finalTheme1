package com.matheussantana.cloudnative.tema1.calculator;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Calculator {

    @Autowired
    private Storage storage;

    public String calculate(double number1, double number2, Operation operation) {
        if (operation == null)
            throw new IllegalArgumentException("The operation value is a null value!");
        String result = operation.calculate(number1, number2);
        storage.save(result);
        return result;
    }

    public List<String> getCalculatorHistoric(){
        return storage.getCalculatorHistoric();
    }
}
