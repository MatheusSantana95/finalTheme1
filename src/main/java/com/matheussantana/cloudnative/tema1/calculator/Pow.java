package com.matheussantana.cloudnative.tema1.calculator;

public class Pow implements Operation{

    @Override
    public String calculate(double number1, double number2) {
        double result = Math.pow(number1,number2);
        return number1+" to "+number2+" = "+result;
    }
}
