package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class BigMacTestSuite {

    @Test
    public void testBigMacBuilder() {
        //Given
        BigMac bigMac = new BigMac.BigMacBuilder()
                .bun(BigMac.WITH_SESAME)
                .burgers(10)
                .sauce(BigMac.BBQ_SAUCE)
                .ingredient("bacon")
                .ingredient("cheese")
                .build();

        //When
        String bun = bigMac.getBun();
        int burgers = bigMac.getBurgers();
        String sauce = bigMac.getSauce();
        List<String> ingredients = bigMac.getIngredients();

        //Then
        Assert.assertEquals(BigMac.WITH_SESAME, bun);
        Assert.assertEquals(10, burgers);
        Assert.assertEquals(BigMac.BBQ_SAUCE, sauce);
        Assert.assertEquals("bacon", ingredients.get(0));
        Assert.assertEquals("cheese", ingredients.get(1));
        Assert.assertEquals(2, ingredients.size());
    }
}
