package uk.co.mcguigan.fizzbuzz;

public final class BuzzSubstitute extends AbstractSubstitute {

    public static final String BUZZ = "buzz";

    private static final int DIVISIBLE_FACTOR = 5;
    private static final int PROCESS_ORDER = 3;
    private static final int DISPLAY_ORDER = 2;

    public BuzzSubstitute() {
        super(BUZZ, PROCESS_ORDER, DISPLAY_ORDER);
    }

    public boolean condition(final int value) {
        return value % DIVISIBLE_FACTOR == 0;
    }

    @Override
    public String getSubstitute() {
        return BUZZ;
    }
}
