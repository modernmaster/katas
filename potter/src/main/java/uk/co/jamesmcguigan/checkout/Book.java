package uk.co.jamesmcguigan.checkout;

public class Book {

    private String name;
    private double price;

    public Book(final String name, final double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public enum Books {Book1, Book2, Book3, Book4, Book5}

}
