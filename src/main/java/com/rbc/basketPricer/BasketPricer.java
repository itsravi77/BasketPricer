package com.rbc.basketPricer;

/**
 * An class representing the basket pricer, it calculates the price of the basket
 */
public interface BasketPricer {
    /**
     * It takes the basket as the input and calculates the price of the basket
     * @param basket basket containing the items
     * @return price of the basket
     */
    public double priceBasket(Basket basket);
}
