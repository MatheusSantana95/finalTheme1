package com.matheussantana.cloudnative.tema1.calculator;

public class Division implements Operation{

    @Override
    public String calculate(double number1, double number2) {
        if (number1==0&&number2==0)
            return number1+" / "+number2+" = Resultado Indefinido";
        double result = number1/number2;
        return number1+" / "+number2+" = "+result;
    }
}
