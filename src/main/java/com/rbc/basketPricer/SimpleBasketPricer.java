package com.rbc.basketPricer;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Simple basket price, which calculates the price of the basket. It depends on ItemPriceProvider to provide the price of the items
 */

public class SimpleBasketPricer implements BasketPricer {
    private final ItemPriceProvider priceProvider;

    public SimpleBasketPricer(ItemPriceProvider priceProvider) {
        this.priceProvider = priceProvider;
    }

    @Override
    public double priceBasket(Basket basket) {

        BigDecimal total = new BigDecimal(0);
        for (Map.Entry<String, Integer> entry : basket.getItems().entrySet()) {
            total = total.add(BigDecimal.valueOf(priceProvider.getPrice(entry.getKey()) * entry.getValue()));
        }
        return total.setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
    }
}
