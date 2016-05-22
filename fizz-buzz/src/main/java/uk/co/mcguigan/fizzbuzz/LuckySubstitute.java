package uk.co.mcguigan.fizzbuzz;

public final class LuckySubstitute extends AbstractSubstitute  {

    public static final String LUCKY = "lucky";

    private static final int PROCESS_ORDER = 1;
    private static final int DISPLAY_ORDER = 4;

    public LuckySubstitute() {
        super(LUCKY, PROCESS_ORDER, DISPLAY_ORDER);
    }

    public boolean condition(final int value) {
        return Integer.toString(value).contains("3");
    }

    @Override
    public String getSubstitute() {
        return LUCKY;
    }
}
