package uk.co.mcguigan.fizzbuzz;


public abstract class AbstractSubstitute implements Substitute {

    private final int displayOrder;
    private final String name;
    private final int processOrder;
    private int usage;

    protected AbstractSubstitute(final String name,
                                 final int processOrder, final int displayOrder) {
        this.name = name;
        this.processOrder = processOrder;
        this.displayOrder = displayOrder;
    }

    public abstract String getSubstitute();

    public final int getUsage() {
        return usage;
    }

    public final int getDisplayOrder() {
        return displayOrder;
    }

    public final int getProcessOrder() {
        return processOrder;
    }

    public final void incrementUsage() {
        usage++;
    }

    @Override
    public final String toString() {
        return name;
    }

}
