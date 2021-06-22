package com.matheussantana.cloudnative.tema1.calculator;

public class Subtract implements Operation{

    @Override
    public String calculate(double number1, double number2) {
        double result = number1 - number2;
        return number1+" - "+number2+" = "+result;
    }
}
