package uk.co.jamesmcguigan.checkout;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CheckoutTest {

    private Bookstore bookstore;

    @Before
    public void setup() {
        bookstore = new Bookstore();
    }

    @Test
    public void testAFirstBookCosts8EUR() {

        List<String> books = new ArrayList();
        books.add("first book");
        Double price = bookstore.buyBooks(books);

        assertThat(price, equalTo(8.0));

    }

    @Test
    public void testTwoDifferentBooksFromSeriesGetA5PercentDiscount() {

        List<String> books = new ArrayList();
        books.add("first book");
        books.add("second book");
        Double price = bookstore.buyBooks(books);

        assertThat(price, equalTo(15.2));
    }

    @Test
    public void testthreeDifferentBooksFromSeriesGetA10PercentDiscount() {

        List<String> books = new ArrayList();
        books.add("first book");
        books.add("second book");
        books.add("third book");
        Double price = bookstore.buyBooks(books);

        assertThat(price, equalTo(21.6));
    }

    @Test
    public void testFourDifferentBooksFromSeriesGetA20PercentDiscount() {

        List<String> books = new ArrayList();
        books.add("first book");
        books.add("second book");
        books.add("third book");
        books.add("fourth book");
        Double price = bookstore.buyBooks(books);

        assertThat(price, equalTo(25.6));
    }

    @Test
    public void testFifthDifferentBooksFromSeriesGetA20PercentDiscount() {

        List<String> books = new ArrayList();
        books.add("first book");
        books.add("second book");
        books.add("third book");
        books.add("fourth book");
        books.add("fifth book");
        Double price = bookstore.buyBooks(books);

        assertThat(price, equalTo(32.0));
    }

    @Test
    public void testFourBooksWithOneSameTitle() {

        List<String> books = new ArrayList();
        books.add("first book");
        books.add("second book");
        books.add("third book");
        books.add("third book");

        Double price = bookstore.buyBooks(books);

        assertThat(price, equalTo(29.6));
    }

    @Test
    public void testMoreThanFiveBooks() {

        List<String> books = new ArrayList();
        books.add("first book");
        books.add("second book");
        books.add("third book");
        books.add("four book");
        books.add("five book");
        books.add("five book");
        Double price = bookstore.buyBooks(books);

        assertThat(price, equalTo(40.0));
    }

}
