package uk.co.jamesmcguigan.checkout;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Basket {

    private List<Book> items;

    public Basket() {
        items = new LinkedList<Book>();
    }

    public void addItem(final Book item) {
        items.add(item);
    }

    public int getSize() {
        return items.size();
    }

    public Book getItem(final int i) {
        return items.get(i);
    }

    public int getFrequencyInBasket(final Book item) {
        int frequency = 0;
        Iterator<Book> iterator = items.iterator();
        while (iterator.hasNext()) {
            Book basketItem = iterator.next();
            if (basketItem.getName().equals(item.getName())) {
                frequency++;
            }
        }
        return frequency;
    }

}
