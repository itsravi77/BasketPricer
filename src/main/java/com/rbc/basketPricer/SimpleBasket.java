package com.rbc.basketPricer;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Object represent basket
 */
public class SimpleBasket implements Basket {
    private Map<String, Integer> items = new HashMap<>();

    @Override
    public void add(String item) {
        putOrMerge(item, 1);
    }

    @Override
    public void add(String item, int quantity) {
        putOrMerge(item, quantity);
    }

    @Override
    public Map<String, Integer> getItems() {
        return Collections.unmodifiableMap(items);
    }

    @Override
    public void remove(String item) {
        items.remove(item);
    }

    private void putOrMerge(String item, int quantity) {
        items.merge(item, quantity,  (prevQuanrity, newQuantity) -> prevQuanrity + newQuantity);
    }

    @Override
    public String toString() {
        return "SimpleBasket{" +
                "items=" + items +
                '}';
    }
}
