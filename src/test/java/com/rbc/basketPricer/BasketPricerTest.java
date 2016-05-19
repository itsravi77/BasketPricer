package com.rbc.basketPricer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BasketPricerTest {

    private ItemPriceProvider itemPriceProvider;

    @Before
    public void beforeEachMethod() {
        itemPriceProvider = mock(ItemPriceProvider.class);
    }

    @Test
    public void testEmptyBasketReturnsZeroPrice() {
        SimpleBasketPricer basketPricer = new SimpleBasketPricer(itemPriceProvider);

        SimpleBasket basket = new SimpleBasket();

        double actualPrice = basketPricer.priceBasket(basket);
        assertEquals(0.0, actualPrice, 0.0);
    }

    @Test
    public void testPricerReturnsCorrectPriceOfBasketWithMultipleItems() {
        SimpleBasketPricer basketPricer = new SimpleBasketPricer(itemPriceProvider);

        SimpleBasket basket = new SimpleBasket();
        basket.add("Banana", 2);
        basket.add("Peaches", 3);
        basket.add("Apple", 2);

        when(itemPriceProvider.getPrice("Banana")).thenReturn(0.7);
        when(itemPriceProvider.getPrice("Peaches")).thenReturn(0.81);
        when(itemPriceProvider.getPrice("Apple")).thenReturn(0.6);

        double actualPrice = basketPricer.priceBasket(basket);
        assertEquals(5.03, actualPrice, 0.0);
    }

    @Test
    public void testPricerReturnsCorrectPriceOfBasketWithSingleItems() {
        SimpleBasketPricer basketPricer = new SimpleBasketPricer(itemPriceProvider);

        SimpleBasket basket = new SimpleBasket();
        basket.add("Banana", 2);

        when(itemPriceProvider.getPrice("Banana")).thenReturn(0.7);

        double actualPrice = basketPricer.priceBasket(basket);
        assertEquals(1.4, actualPrice, 0.0);
    }
}