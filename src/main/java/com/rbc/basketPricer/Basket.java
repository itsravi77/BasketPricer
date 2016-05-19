package com.rbc.basketPricer;

import java.util.Map;

/**
 * Basket interface, which provides the methods for adding and removing the items from the basket.
 */
public interface Basket {
    /**
     * Add an item with single quantity to the basket. It will increment the quantity by 1 if the item is already there
     * in the basket
     * @param item name of the item
     */
    public void add(String item);
    /**
     * Add an item with specified quantity to the basket. It will increment the quantity by the number provided if the
     * item is already there in the basket
     * @param item name of the item
     * @param quantity quantity of the item
     */
    public void add(String item, int quantity);

    /**
     * Returns the map of the items and their associated quantity
     * @return Map of Items to the quantity
     */
    public Map<String, Integer> getItems();

    /**
     * Removes all the quantities of the item from the basket
     * @param item name of the item
     */
    public void remove(String item);
}
