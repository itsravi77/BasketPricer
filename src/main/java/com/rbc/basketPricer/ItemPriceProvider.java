package com.rbc.basketPricer;

/**
 * An interface which will provide the price of the items
 */
public interface ItemPriceProvider {
    /**
     * It takes the name of the item and returns the price of item
     * @param item name of the item
     * @return price of the single item
     */
    double getPrice(String item);
}
