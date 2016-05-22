package uk.co.jamesmcguigan.checkout;

public class Checkout {

    private DiscountStrategy discountStrategy;

    public Checkout() {
        discountStrategy = new DiscountStrategy();
    }

    public double calculateSubtotal(final Basket basket) {
        //improve algorithm here to deal with multiple for a certain book.
        double runningTotal = 0;

        for (int i = 0; i < basket.getSize(); i++) {
            runningTotal += basket.getItem(i).getPrice();
        }

        runningTotal -= discountStrategy.getBiggestDiscount(basket);
        return runningTotal;
    }
}
