package com.kodilla.stream;

/*import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.beautifier.PoemDecorator;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.reference.FunctionalCalculator;

import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.kodilla.stream.person.People;*/


import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        /*System.out.println("Welcome to module 7 - Stream");

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
            for (char character : text.toCharArray()) {
                result.append(character).append(" ");
            }
            return result.toString();
        };
        poemBeautifier.beautify(baseText, lambda);*/

        /*  modul 7.3 - kurs
        People.getList().stream()

                .map(String::toUpperCase)
                .filter(s -> s.length() > 11)
                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
                .filter(s -> s.startsWith("M"))
                .forEach(System.out::println);
        //-------------------------------------------------------------
        BookDirectory theBookDirectory = new BookDirectory();
        theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .forEach(System.out::println);
        //-------------------------------------------------------------
        BookDirectory theBookDirectory = new BookDirectory();
        List<Book> theResultListOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toList());

        System.out.println("# elements: " + theResultListOfBooks.size());
        theResultListOfBooks
                .forEach(System.out::println);
        //-------------------------------------------------------------

        BookDirectory theBookDirectory = new BookDirectory();

        Map<String, Book> theResultMapOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toMap(Book::getSignature, book -> book));

        System.out.println("# elements: " + theResultMapOfBooks.size());
        theResultMapOfBooks.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
        //-------------------------------------------------------------

        BookDirectory theBookDirectory = new BookDirectory();
        String theResultStringOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<\n","\n>>"));

        System.out.println(theResultStringOfBooks);
        */

        // Modul 7.3 Zadanie: funkcyjny spacer po liście użytkowników forum
        Forum forum = new Forum();
        Map<Integer, ForumUser> userMap = forum.getUserList().stream()
                .filter(forumUser -> forumUser.getSex() == 'M')
                .filter(forumUser -> forumUser.getBirthDate().isBefore(LocalDate.now().minusYears(20)))
                .filter(forumUser -> forumUser.getPostCounter() > 0)
                .collect(Collectors.toMap(ForumUser::getId, Function.identity()));

        userMap.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }
}
