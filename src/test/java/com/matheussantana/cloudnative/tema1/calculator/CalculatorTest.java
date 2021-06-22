package com.matheussantana.cloudnative.tema1.calculator;

import com.matheussantana.cloudnative.tema1.config.AppConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfig.class})
public class CalculatorTest {

    @Autowired
    private Calculator calc;
    @Autowired
    private Sum sum;
    @Autowired
    private Subtract subtract;
    @Autowired
    private Multiply multiply;
    @Autowired
    private Division division;
    @Autowired
    private Pow pow;

    @Test
    public void shouldSum() {
        String resultSum = calc.calculate(2,2,sum);
        assertEquals("2.0 + 2.0 = 4.0", resultSum);
    }

    @Test
    public void shouldSubtract() {
        String resultSubtract = calc.calculate(4,2,subtract);
        assertEquals("4.0 - 2.0 = 2.0", resultSubtract);
    }

    @Test
    public void shouldMultiply() {
        String resultMultiply = calc.calculate(4,2,multiply);
        assertEquals("4.0 x 2.0 = 8.0", resultMultiply);
    }

    @Test
    public void shouldDivide() {
        String resultDivision = calc.calculate(4,2,division);
        assertEquals("4.0 / 2.0 = 2.0", resultDivision);
    }

    @Test
    public void shouldDoPow() {
        String resultPow = calc.calculate(2,2,pow);
        assertEquals("2.0 to 2.0 = 4.0", resultPow);
    }

    @Test
    public void shouldReturnAnInformation() {
        String result = calc.calculate(0,0,division);
        assertEquals("0.0 / 0.0 = Resultado Indefinido", result);
    }

    @Test
    public void shouldReturnAnException() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, ()-> calc.calculate(2,2,null));
        assertEquals("The operation value is a null value!", e.getMessage());
    }

    @Test
    void getCalculatorHistoric() {
        String result1 = calc.calculate(2,2,sum);
        String result2 = calc.calculate(4,2,sum);
        String result3 = calc.calculate(8,3,multiply);
        String result4 = calc.calculate(5,2,multiply);
        String result5 = calc.calculate(3,3,division);
        String result6 = calc.calculate(12,4,division);
        String result7 = calc.calculate(6,4,pow);
        String result8 = calc.calculate(3,4,pow);
        List<String> calculatorHistoric = calc.getCalculatorHistoric();
        assertNotNull(calculatorHistoric);
        assertTrue(calculatorHistoric.contains(result1));
        assertTrue(calculatorHistoric.contains(result2));
        assertTrue(calculatorHistoric.contains(result3));
        assertTrue(calculatorHistoric.contains(result4));
        assertTrue(calculatorHistoric.contains(result5));
        assertTrue(calculatorHistoric.contains(result6));
        assertTrue(calculatorHistoric.contains(result7));
        assertTrue(calculatorHistoric.contains(result8));
    }
}