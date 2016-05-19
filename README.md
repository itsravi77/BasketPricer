This is the simple pricing application for calculating the price of the basket of items.
It is a maven based project. It is developed using Java 1.8

The class SimpleBasketPricer is the main class that calculates the price of the basket, it depends on the ItemPriceProvider which provides the prices of each item.

There are some assumptions made while implementing this project:

1. Providing the prices of the items is beyond the scope, so I have mocked it in the test. ItemPriceProvider is the interface,
 which will have the list of items and the price associated with each. The actual implementation of this interface could be
 a DAO, that will fetch the values from database or a file based one, which will read some CSV file, that maintains the prices
2. Validation of the items is not in the scope. I assumed that all items are valid items and there is a price available for
 each item. If needed we could extend ItemPriceProvider by renaming it to something like ItemService, which would maintain
 the items and it's prices
3. Prices are supported upto 2 decimal points

There are tests provided for the classes, which can be used to validate the implementation.
