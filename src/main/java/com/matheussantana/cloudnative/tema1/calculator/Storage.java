package com.matheussantana.cloudnative.tema1.calculator;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class Storage {

    private List<String> calculatorHistoric = new ArrayList<>();

    public void save(String result){
        calculatorHistoric.add(result);
    }

    public List<String> getCalculatorHistoric() {
        return calculatorHistoric;
    }
}
