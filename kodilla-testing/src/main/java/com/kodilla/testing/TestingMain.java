package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args){
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        Calculator calculator = new Calculator();

        if (calculator.add(1,3) == 4) {
            System.out.println("calculator, method 'add' OK");
        } else {
            System.out.println("calculator, method 'add' Error");
        }

        if (calculator.subtract(9, 4) == 5) {
            System.out.println("calculator, method 'subtract' OK");
        } else {
            System.out.println("calculator, method 'subtract' Error");
        }
    }
}
