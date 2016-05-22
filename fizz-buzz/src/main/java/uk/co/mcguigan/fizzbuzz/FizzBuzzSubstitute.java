package uk.co.mcguigan.fizzbuzz;

public final class FizzBuzzSubstitute extends AbstractSubstitute  {

    public static final String FIZZ_BUZZ = "fizzbuzz";

    private static final int DIVISIBLE_FACTOR = 15;
    private static final int PROCESS_ORDER = 2;
    private static final int DISPLAY_ORDER = 3;

    public FizzBuzzSubstitute() {
        super(FIZZ_BUZZ, PROCESS_ORDER, DISPLAY_ORDER);
    }

    public boolean condition(final int value) {
        return value % DIVISIBLE_FACTOR == 0;
    }

    @Override
    public String getSubstitute() {
        return FIZZ_BUZZ;
    }
}
