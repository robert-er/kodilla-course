package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {
    @Test
    public void testCalculations() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        double resultAdd = calculator.add(1, 2);
        double resultSub = calculator.sub(3, 2);
        double resultMul = calculator.mul(5, 4);
        double resultDiv = calculator.div(10, 2);
        //Then
        Assert.assertEquals(3.0, resultAdd, 0.0);
        Assert.assertEquals(1.0, resultSub, 0.0);
        Assert.assertEquals(20.0, resultMul, 0.0);
        Assert.assertEquals(5.0, resultDiv, 0.0);
    }


}
