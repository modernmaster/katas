package uk.co.jamesmcguigan.checkout;

import java.util.ArrayList;
import java.util.List;

public class DiscountStrategy {

    public static final int FIVE_PERCENT = 5;
    public static final int TEN_PERCENT = 10;
    public static final int TWENTY_PERCENT = 20;
    public static final int TWENTY_FIVE_PERCENT = 25;
    public static final int TWO_BOOKS_REQUIRED = 2;
    public static final int THREE_BOOKS_REQUIRED = 3;
    public static final int FOUR_BOOKS_REQUIRED = 4;
    public static final int FIVE_BOOKS_REQUIRED = 5;
    private List<Billing> billing;

    public DiscountStrategy() {
        billing = new ArrayList<Billing>();
        billing.add(new GroupDiscount(FIVE_PERCENT, TWO_BOOKS_REQUIRED));
        billing.add(new GroupDiscount(TEN_PERCENT, THREE_BOOKS_REQUIRED));
        billing.add(new GroupDiscount(TWENTY_PERCENT, FOUR_BOOKS_REQUIRED));
        billing.add(new GroupDiscount(TWENTY_FIVE_PERCENT, FIVE_BOOKS_REQUIRED));
    }

    public double getBiggestDiscount(final Basket books) {

        double discountAmount = 0;
        for (Billing discount : billing) {
            double currentDiscount = discount.getDiscount(books);
            if (discountAmount < currentDiscount) {
                discountAmount = currentDiscount;
            }
        }
        return discountAmount;
    }

}
