package uk.co.jamesmcguigan.checkout;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class CheckoutTest {

    private Checkout checkout;
    private static final double bookPrice = 8;

    @Before
    public void setUp() {
        checkout = new Checkout();
    }

    @Test
    public void testCostEightForOneOfAnyBook() {

        double expectedSubtotal = 8;
        Book book = new Book(Book.Books.Book1.toString(), bookPrice);
        Basket basket = new Basket();
        basket.addItem(book);

        double actualSubtotal = checkout.calculateSubtotal(basket);

        assertThat(expectedSubtotal, equalTo(actualSubtotal));
    }

    @Test
    public void testGetNoDiscountForTwoOfTheSameBook() {

        double expectedSubtotal = 16;
        Book book = new Book(Book.Books.Book1.toString(), bookPrice);
        Book book2 = new Book(Book.Books.Book1.toString(), bookPrice);
        Basket basket = new Basket();
        basket.addItem(book);
        basket.addItem(book2);

        double actualSubtotal = checkout.calculateSubtotal(basket);

        assertThat(actualSubtotal, equalTo(expectedSubtotal));
    }


    @Test
    public void testGetFivePercentDiscountForTwoDifferentBooks() {

        double expectedSubtotal = 15.2;
        Book book = new Book(Book.Books.Book1.toString(), bookPrice);
        Book book2 = new Book(Book.Books.Book2.toString(), bookPrice);
        Basket basket = new Basket();
        basket.addItem(book);
        basket.addItem(book2);

        double actualSubtotal = checkout.calculateSubtotal(basket);

        assertThat(actualSubtotal, equalTo(expectedSubtotal));
    }

    @Test
    public void testGetTenPercentDiscountForThreeDifferentBooks() {

        double expectedSubtotal = 21.6;
        Book book = new Book(Book.Books.Book1.toString(), bookPrice);
        Book book2 = new Book(Book.Books.Book2.toString(), bookPrice);
        Book book3 = new Book(Book.Books.Book3.toString(), bookPrice);

        Basket basket = new Basket();
        basket.addItem(book);
        basket.addItem(book2);
        basket.addItem(book3);

        double actualSubtotal = checkout.calculateSubtotal(basket);

        assertThat(actualSubtotal, equalTo(expectedSubtotal));
    }


    @Test
    public void testGetTwentyPercentDiscountForFourDifferentBooksMultipliedTwice() {

        double expectedSubtotal = 51.2;

        Basket basket = new Basket();
        basket.addItem(new Book(Book.Books.Book1.toString(), bookPrice));
        basket.addItem(new Book(Book.Books.Book2.toString(), bookPrice));
        basket.addItem(new Book(Book.Books.Book3.toString(), bookPrice));
        basket.addItem(new Book(Book.Books.Book4.toString(), bookPrice));
        basket.addItem(new Book(Book.Books.Book1.toString(), bookPrice));
        basket.addItem(new Book(Book.Books.Book2.toString(), bookPrice));
        basket.addItem(new Book(Book.Books.Book3.toString(), bookPrice));
        basket.addItem(new Book(Book.Books.Book4.toString(), bookPrice));

        double actualSubtotal = checkout.calculateSubtotal(basket);

        assertThat(actualSubtotal, equalTo(expectedSubtotal));
    }


    @Test
    public void testGetTwentyPercentDiscountForFourDifferentBooksMultipliedTwiceWhenFiveBooksIsMoreExpensive() {

        double expectedSubtotal = 51.2;

        Basket basket = new Basket();
        basket.addItem(new Book(Book.Books.Book1.toString(), bookPrice));
        basket.addItem(new Book(Book.Books.Book1.toString(), bookPrice));

        basket.addItem(new Book(Book.Books.Book2.toString(), bookPrice));
        basket.addItem(new Book(Book.Books.Book2.toString(), bookPrice));

        basket.addItem(new Book(Book.Books.Book3.toString(), bookPrice));
        basket.addItem(new Book(Book.Books.Book3.toString(), bookPrice));

        basket.addItem(new Book(Book.Books.Book4.toString(), bookPrice));

        basket.addItem(new Book(Book.Books.Book5.toString(), bookPrice));

        double actualSubtotal = checkout.calculateSubtotal(basket);

        assertThat(actualSubtotal, equalTo(expectedSubtotal));
    }

    @Test
    public void testGetTwentyFivePercentDiscountForFiveDifferentBooks() {

        double expectedSubtotal = 30;
        Book book = new Book(Book.Books.Book1.toString(), bookPrice);
        Book book2 = new Book(Book.Books.Book2.toString(), bookPrice);
        Book book3 = new Book(Book.Books.Book3.toString(), bookPrice);
        Book book4 = new Book(Book.Books.Book4.toString(), bookPrice);
        Book book5 = new Book(Book.Books.Book5.toString(), bookPrice);
        Basket basket = new Basket();
        basket.addItem(book);
        basket.addItem(book2);
        basket.addItem(book3);
        basket.addItem(book4);
        basket.addItem(book5);

        double actualSubtotal = checkout.calculateSubtotal(basket);

        assertThat(actualSubtotal, equalTo(expectedSubtotal));
    }
}
