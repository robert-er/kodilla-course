package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.beautifier.PoemDecorator;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {
    public static void main(String[] args) {
        System.out.println("Welcome to module 7 - Stream");

        SaySomething saySomething = new SaySomething();
        saySomething.say();

        Processor processor = new Processor();
        ExecuteSaySomething executeSaySomething = new ExecuteSaySomething();
        processor.execute(executeSaySomething);

        Executor codeToExecute = () -> System.out.println("This is an example text. lambda");
        processor.execute(codeToExecute);

        processor.execute(() -> System.out.println("lambda"));

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
        MathExpression mathExpression = (a, b) -> a + b;
        expressionExecutor.executeExpression(5, 4, mathExpression);

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(10, 5, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(10, 5, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(10, 5, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(10, 5, FunctionalCalculator::divideAByB);

        //=========================== Zadanie: Upiększacz tekstów =================================
        System.out.println("Zadanie: Upiększacz tekstów ");
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String baseText = "Text";
        String decorText = "======";
        poemBeautifier.beautify(baseText, (text) -> decorText + text + decorText);
        poemBeautifier.beautify(baseText, String::toUpperCase);
        poemBeautifier.beautify(baseText, String::toLowerCase);
        PoemDecorator lambda = (text) -> {
            StringBuilder result = new StringBuilder();
            char[] charArray = text.toCharArray();
            for (char character : charArray) {
                result.append(character).append(" ");
            }
            return result.toString();
        };
        poemBeautifier.beautify(baseText, lambda);
    }
}
