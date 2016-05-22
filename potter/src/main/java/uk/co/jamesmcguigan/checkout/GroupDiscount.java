package uk.co.jamesmcguigan.checkout;

public class GroupDiscount implements Billing {

    public static final int BOOK_PRICE = 8;
    public static final double PERCENTAGE = 100d;
    public static final int BOOKS_IN_SERIES = 5;
    private int discount = 0;
    private int numberRequired;

    public GroupDiscount(final int percent, final int numberRequired) {
        this.discount = percent;
        this.numberRequired = numberRequired;
    }

    public double getDiscount(final Basket basket) {
        int book1 = basket.getFrequencyInBasket(new Book(Book.Books.Book1.toString(), BOOK_PRICE));
        int book2 = basket.getFrequencyInBasket(new Book(Book.Books.Book2.toString(), BOOK_PRICE));
        int book3 = basket.getFrequencyInBasket(new Book(Book.Books.Book3.toString(), BOOK_PRICE));
        int book4 = basket.getFrequencyInBasket(new Book(Book.Books.Book4.toString(), BOOK_PRICE));
        int book5 = basket.getFrequencyInBasket(new Book(Book.Books.Book5.toString(), BOOK_PRICE));

        int[] range = { book1, book2, book3, book4, book5 };
        int discountMultiplier = 0;

        for (int i = 0; i < basket.getSize(); i++) {
            int match = 0;
            for (int j = 0; j < BOOKS_IN_SERIES; j++) {
                if (range[j] != 0) {
                    range[j] -= 1;
                    match++;
                }
                if (match == numberRequired) {
                    discountMultiplier++;
                    break;
                }
            }
        }
        return discountMultiplier * numberRequired * BOOK_PRICE * discount / PERCENTAGE;
    }

}
