package uk.co.mcguigan.fizzbuzz;

public interface Substitute {
    boolean condition(final int value);

    String getSubstitute();

    void incrementUsage();

    int getUsage();

    int getDisplayOrder();

    int getProcessOrder();
}
