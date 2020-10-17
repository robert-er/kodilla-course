package com.kodilla.patterns2.decorator.pizza;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class PizzaTest {

    @Test
    void testBasicPizza() {
        //Given
        Pizza pizza = new BasicPizzaDecorator();
        //When
        int cost = pizza.getCost();
        String description = pizza.getDescription();
        //Then
        assertEquals(15, cost);
        assertEquals("Pizza: sauce + cheese", description);
    }

    @Test
    void testAllInOnePizza() {
        //Given
        Pizza pizza = new BasicPizzaDecorator();
        pizza = new ExtraCheeseDecorator(pizza);
        pizza = new HamDecorator(pizza);
        pizza = new MushroomsDecorator(pizza);
        pizza = new OnionDecorator(pizza);
        //When
        int cost = pizza.getCost();
        String description = pizza.getDescription();
        //Then
        assertEquals(23, cost);
        assertEquals("Pizza: sauce + cheese + extra cheese + ham + mushrooms + onion", description);
    }
}