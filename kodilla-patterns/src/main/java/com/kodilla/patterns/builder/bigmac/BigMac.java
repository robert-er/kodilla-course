package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class BigMac {

    public static final String WITH_SESAME = "WITH_SESAME";
    public static final String WITHOUT_SESAME = "WITHOUT_SESAME";
    private String bun; //bun (pol. bułka do hamburgera (w odróżnieniu od roll — - zwykłej bułki — może być z sezamem lub bez)
    private int burgers;
    public static final String STANDARD_SAUCE = "STANDARD_SAUCE";
    public static final String ISLANDS_SAUCE = "ISLANDS_SAUCE";
    public static final String BBQ_SAUCE = "BBQ_SAUCE";
    private String sauce;
    private List<String > ingredients;

    public static class BigMacBuilder {
        private String bun;
        int burgers;
        private String sauce;
        private List<String > ingredients = new ArrayList<>();

        public BigMacBuilder bun(String bun) {
            if (bun.equals(WITH_SESAME) || bun.equals(WITHOUT_SESAME)) {
                this.bun = bun;
                return this;
            } else {
                throw new IllegalStateException("Wrong type of bun");
            }
        }

        public BigMacBuilder burgers(int burgers) {
            if (burgers >= 0) {
                this.burgers = burgers;
                return this;
            } else {
                throw new IllegalStateException("Wrong number of burgers");
            }
        }

        public BigMacBuilder sauce(String sauce) {
            if (sauce.equals(STANDARD_SAUCE) || sauce.equals(ISLANDS_SAUCE) || sauce.equals(BBQ_SAUCE)) {
                this.sauce = sauce;
                return this;
            } else {
                throw new IllegalStateException("Wrong type of sauce");
            }
        }

        public BigMacBuilder ingredient(String ingredient) {
            ingredients.add(ingredient);
            return this;
        }

        public BigMac build() {
            if (bun.length() == 0) {
                throw new IllegalStateException("There is no bun specified!");
            }
            return new BigMac(bun, burgers, sauce, ingredients);
        }
    }

    private BigMac(String bun, int burgers, String sauce, List<String> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public String getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "BigMac{" +
                "bun='" + bun + '\'' +
                ", burgers=" + burgers +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
