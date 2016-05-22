package uk.co.mcguigan.fizzbuzz;

public final class FizzSubstitute extends AbstractSubstitute {

    public static final String FIZZ = "fizz";

    private static final int DIVISIBLE_FACTOR = 3;
    private static final int PROCESS_ORDER = 4;
    private static final int DISPLAY_ORDER = 1;

    public FizzSubstitute() {
        super(FIZZ, PROCESS_ORDER, DISPLAY_ORDER);
    }

    public boolean condition(final int value) {
        return value % DIVISIBLE_FACTOR == 0;
    }

    @Override
    public String getSubstitute() {
        return FIZZ;
    }

}
