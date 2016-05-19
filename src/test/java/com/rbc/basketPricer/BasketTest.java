package com.rbc.basketPricer;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class BasketTest {

    Basket basket;

    @Before
    public void beforeEachMethod() {
        basket = new SimpleBasket();
    }

    @Test
    public void testEmptyBasket() {
        Map<String, Integer> expectedValues = new HashMap<>();
        assertEquals(expectedValues, basket.getItems());
    }

    @Test
    public void testSingleItem() {
        Map<String, Integer> expectedValues = new HashMap<>();

        //Add single Banana item
        basket.add("Banana");
        Map<String, Integer> items = basket.getItems();

        //we expect 1 banana only
        expectedValues.put("Banana", 1);
        assertEquals(expectedValues, items);

    }

    @Test
    public void testMultipleAddOfSameItemGroupThemTogether() {
        Map<String, Integer> expectedValues = new HashMap<>();

        //Add single Banana item
        basket.add("Banana");
        //Add another Banana
        basket.add("Banana");

        //Add 2 more Bananas to the basket
        basket.add("Banana", 2);
        Map<String, Integer> items = basket.getItems();

        //Now, we expect 4 bananas in the basket
        expectedValues.put("Banana", 4);
        assertEquals(expectedValues, items);
    }

    @Test
    public void testBasketDifferentItemsSeparately() {
        Map<String, Integer> expectedValues = new HashMap<>();

        //Add sinlge lemon to the basket
        basket.add("Lemon");

        //Add 2 Peach to the basket
        basket.add("Peach", 2);
        basket.add("Banana", 4);
        Map<String, Integer> items = basket.getItems();

        //Now, we epext 4 bananas, 1 lemon and 2 peaches
        expectedValues.put("Peach", 2);
        expectedValues.put("Banana", 4);
        expectedValues.put("Lemon", 1);
        assertEquals(expectedValues, items);
    }

    @Test
    public void testRemoveRemovesAllQuantityFromBasket() {
        Map<String, Integer> expectedValues = new HashMap<>();

        //Add lemons to the basket
        basket.add("Lemon");
        basket.add("Lemon", 2);

        //Add 2 Peach to the basket
        basket.add("Peach", 2);
        //Remove Lemon from the basket
        basket.remove("Lemon");
        Map<String, Integer> items = basket.getItems();

        //Now, we epext only 2 peaches
        expectedValues.put("Peach", 2);

        assertEquals(expectedValues, items);
    }

}