package uk.co.jamesmcguigan.checkout;

import java.util.List;
import java.util.Set;

import com.google.common.collect.Sets;

public class Bookstore {

    private static final Double PRICE = 8d;
    private static final Integer MAX_DIFFERENT_BOOKS = 4;
    private static final double BOOK_DISCOUNT = 0.05;
    private static final double DEFAULT_TOTAL_BOOK_DISCOUNT = 0.80;

    public Double buyBooks(final List<String> books) {
        Set<String> uniqueBooks = Sets.newHashSet(books);
        return calculateCost(books.size(), uniqueBooks.size());
    }

    private Double calculateCost(final Integer numberOfBooks, final Integer numberOfUniqueBooks) {
        Integer diff = numberOfBooks - numberOfUniqueBooks;
        if (numberOfUniqueBooks == 1) {
            return PRICE + (diff * PRICE);
        }
        double fullCost = numberOfUniqueBooks * PRICE;
        double percentDiscount = DEFAULT_TOTAL_BOOK_DISCOUNT;
        if (numberOfUniqueBooks < MAX_DIFFERENT_BOOKS) {
            percentDiscount = 1 - ((numberOfUniqueBooks - 1) * BOOK_DISCOUNT);
        }
        return (percentDiscount * fullCost) + (diff * PRICE);
    }
}
